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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Group extends ConcurrencySafeEntity {
    private static final long serialVersionUID = 1L;

    private String description;
    private String name;
    private TenantId tenantId;
    private Set<GroupMember> groupMembers = new HashSet<GroupMember>();

    public Group(TenantId aTenantId, String aName, String aDescription) {
        setTenantId(aTenantId);
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

    public Set<GroupMember> getGroupMembers() {
        return Collections.unmodifiableSet(groupMembers);
    }

    protected void setDescription(String aDescription) {
        description = aDescription;
    }

    protected void setName(String aName) {
        assertArgumentNotNull(aName, "The group name is required.");
        assertArgumentLength(aName, 1, 100, "The group name must be 1 to 100 characters.");
        name = aName;
    }

    protected void setTenantId(TenantId aTenantId) {
        assertArgumentNotNull(aTenantId, "The tenant id is required.");
        tenantId = aTenantId;
    }

    @Id
    @GeneratedValue
    @Override
    protected void setId(long anId) {
        super.setId(anId);
    }
}
