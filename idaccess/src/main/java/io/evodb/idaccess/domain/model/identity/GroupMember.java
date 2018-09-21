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

import io.evodb.common.domain.model.PersistibleValueObject;

public class GroupMember extends PersistibleValueObject<GroupMember> {
    private String name;
    private TenantId tenantId;
    private GroupMemberType groupMemberType;

    public GroupMember(TenantId aTenantId, String aName, GroupMemberType aGroupMemberType) {
        setTenantId(aTenantId);
        setName(aName);
        setGroupMemberType(groupMemberType);
    }


    public String name() {
        return name;
    }

    public TenantId tenantId() {
        return tenantId;
    }

    public boolean isUser() {
        return groupMemberType.isUser();
    }

    public boolean isGroup() {
        return groupMemberType.isGroup();
    }

    protected void setName(String aName) {
        assertArgumentNotNull(aName, "The group member name is required.");
        assertArgumentLength(aName, 1, 20, "The group member name must be 1 to 30 characters.");
        name = aName;
    }

    protected void setTenantId(TenantId aTenantId) {
        assertArgumentNotNull(aTenantId, "The tenant id is required.");
        tenantId = aTenantId;
    }

    protected void setGroupMemberType(GroupMemberType aGroupMemberType) {
        assertArgumentNotNull(aGroupMemberType, "The group member type is required");
        groupMemberType = aGroupMemberType;

    }

    public boolean isEqualsTo(GroupMember aGroupMember) {
        return equals(aGroupMember);
    }
}
