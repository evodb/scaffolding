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
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class Tenant extends ConcurrencySafeEntity {
    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    private boolean active;

    @Getter
    private String description;

    @Getter
    private String name;

    @Getter
    @Setter
    private Date createTime;

    @Getter
    private TenantId tenantId;

    public Tenant(TenantId aTenantId, String aName, String aDescription, boolean anActive) {
        setTenantId(aTenantId);
        setActive(anActive);
        setName(aName);
        setDescription(aDescription);
        setCreateTime(new Date());
    }

    public void rename(String aName) {
        setName(aName);
    }

    public void activate() {
        if (!isActive()) {
            setActive(true);
        }
    }

    public void deactivate() {
        if (isActive()) {
            setActive(false);
        }
    }

    protected void setName(String aName) {
        assertArgumentNotNull(aName, "The name is required.");
        assertArgumentLength(aName, 1, 100, "The name must be 1 to 100 characters.");
        name = aName;
    }

    protected void setTenantId(TenantId aTenantId) {
        assertArgumentNotNull(aTenantId, "The Tenant id is required.");
        tenantId = aTenantId;
    }

    protected void setDescription(String aDescription) {
        assertArgumentLength(aDescription, 100, "The description must be 100 characters or less.");
        description = aDescription;
    }


}
