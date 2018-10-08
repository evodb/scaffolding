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

package io.evodb.idaccess.infrastructure.persistence;

import io.evodb.idaccess.domain.model.identity.Tenant;
import io.evodb.idaccess.domain.model.identity.TenantId;
import io.evodb.idaccess.domain.model.identity.TenantRepository;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;

@Component
public class JpaTenantRepository implements TenantRepository {
    private final EntityManager entityManager;

    public JpaTenantRepository(EntityManager anEntityManager) {
        entityManager = anEntityManager;
    }

    @Override
    public void add(Tenant aTenant) {
        entityManager.persist(aTenant);
    }

    @Override
    public TenantId nextIdentity() {
        return new TenantId(UUID.randomUUID().toString());
    }

    @Override
    public void remove(Tenant aTenant) {
        entityManager.remove(aTenant);
    }

    @Override
    public Tenant tenantOfId(TenantId aTenantId) {
        TypedQuery<Tenant> query = entityManager.createQuery("SELECT t FROM Tenant t WHERE t.tenantId= :tenantId", Tenant.class);
        query.setParameter("tenantId", aTenantId);
        List<Tenant> list = query.getResultList();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
}
