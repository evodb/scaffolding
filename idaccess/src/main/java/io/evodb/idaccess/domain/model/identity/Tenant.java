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

import io.evodb.common.domain.model.ConcurrencySafeEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tenant extends ConcurrencySafeEntity {
    private static final long serialVersionUID = 1L;

    private boolean active;
    private String description;
    private String name;
    private TenantId tenantId;

    public Tenant(TenantId aTenantId, String aName, String aDescription, boolean anActive) {
        setTenanId(aTenantId);
        setActive(anActive);
        setName(aName);
        setDescription(aDescription);
    }

    public String description() {
        return description;
    }

    public String name() {
        return name;
    }

    public TenantId tenantId() {
        return tenantId;
    }

    public boolean isActive() {
        return active;
    }

    protected void setActive(boolean aFlag) {
        active = aFlag;
    }

    protected void setDescription(String aDescription) {
        assertArgumentNotEmpty(aDescription, "The tenant description is required.");
        assertArgumentLength(aDescription, 1, 100, "The tenant description must be 100 characters or less.");
        description = aDescription;
    }

    protected void setTenanId(TenantId aTenanId) {
        assertArgumentNotNull(aTenanId, "The TenantId is required.");
        tenantId = aTenanId;
    }

    protected void setName(String aName) {
        assertArgumentNotEmpty(aName, "The tenant name is required.");
        assertArgumentLength(aName, 1, 100, "The tenant description must be 100 characters or less.");
        name = aName;
    }


    @Id
    @GeneratedValue
    @Override
    protected void setId(long anId) {
        super.setId(anId);
    }
}
