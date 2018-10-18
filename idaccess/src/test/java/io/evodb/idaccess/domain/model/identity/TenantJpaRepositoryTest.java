/*
 * Copyright 2018 The Scaffolding Project
 *
 *  The Scaffolding Project licenses this file to you under the Apache License,
 *  version 2.0 (the "License"); you may not use this file except in compliance
 *  with the License. You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 *
 */

package io.evodb.idaccess.domain.model.identity;

import io.evodb.idaccess.infrastructure.persistence.JpaTenantRepository;
import javax.persistence.PersistenceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@Import(JpaTenantRepository.class)
public class TenantJpaRepositoryTest {

    @Autowired
    private TenantRepository tenantRepository;

    @Test
    public void testAddTenant() {
        TenantId tenantId = tenantRepository.nextIdentity();
        Tenant tenant = new Tenant(
            tenantId,
            "testTenantName",
            "description",
            true);
        tenantRepository.add(tenant);
        Assert.assertNotNull(tenantRepository.tenantOfId(tenantId));
    }

    @Test
    public void testRemoveTenant() {
        TenantId tenantId = tenantRepository.nextIdentity();
        Tenant tenant = new Tenant(
            tenantId,
            "testTenantName",
            "description",
            true);
        tenantRepository.add(tenant);
        tenantRepository.remove(tenant);
        Assert.assertNull(tenantRepository.tenantOfId(tenantId));
    }

    @Test
    public void testRenameTenant() {
        TenantId tenantId = tenantRepository.nextIdentity();
        Tenant tenant = new Tenant(
            tenantId,
            "testTenantName",
            "description",
            true);
        tenantRepository.add(tenant);
        tenant.rename("new tenant name");
        tenant = tenantRepository.tenantOfId(tenantId);
        Assert.assertEquals("new tenant name", tenant.getName());
    }

    @Test
    public void testTenantActive() {
        TenantId tenantId = tenantRepository.nextIdentity();
        Tenant tenant = new Tenant(
            tenantId,
            "testTenantName",
            "description",
            true);
        tenantRepository.add(tenant);

        Assert.assertTrue(tenant.isActive());
        tenant.deactivate();
        Assert.assertFalse(tenant.isActive());
        tenant.activate();
        Assert.assertTrue(tenant.isActive());
    }

    @Test(expected = PersistenceException.class)
    public void testTenantNameConflict() {
        TenantId tenantId = tenantRepository.nextIdentity();
        Tenant tenant = new Tenant(
            tenantId,
            "testTenantName",
            "description",
            true);
        tenantRepository.add(tenant);

        TenantId otherTenantId = tenantRepository.nextIdentity();
        Tenant otherTenant = new Tenant(
            otherTenantId,
            "testTenantName",
            "description",
            true);
        tenantRepository.add(otherTenant);
    }

    @Test(expected = PersistenceException.class)
    public void testTenantIdConflict() {
        TenantId tenantId = tenantRepository.nextIdentity();
        Tenant tenant = new Tenant(
            tenantId,
            "testTenantName",
            "description",
            true);
        tenantRepository.add(tenant);

        Tenant otherTenant = new Tenant(
            tenantId,
            "otherName",
            "description",
            true);
        tenantRepository.add(otherTenant);
    }
}
