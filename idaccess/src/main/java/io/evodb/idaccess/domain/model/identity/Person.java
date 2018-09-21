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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Person extends ConcurrencySafeEntity {
    private static final long serialVersionUID = 1L;
    private TenantId tenantId;
    private FullName fullName;
    private ContactInformation contactInformation;

    public Person(TenantId aTenantId, FullName aFullName, ContactInformation aContactInformation) {
        setTenantId(aTenantId);
        setFullName(aFullName);
        setContactInformation(aContactInformation);
    }

    public TenantId tenantId() {
        return tenantId;
    }

    public FullName fullName() {
        return fullName;
    }

    public ContactInformation contactInformation() {
        return contactInformation;
    }

    protected void setTenantId(TenantId aTenantId) {
        assertArgumentNotNull(aTenantId, "The tenantId is required.");
        tenantId = aTenantId;
    }

    protected void setFullName(FullName aFullName) {
        assertArgumentNotNull(aFullName, "The full name is required");
        fullName = aFullName;
    }

    protected void setContactInformation(ContactInformation aContactInformation) {
        assertArgumentNotNull(aContactInformation, "The contact information is required.");
        contactInformation = aContactInformation;
    }

    @Id
    @GeneratedValue
    @Override
    protected void setId(long anId) {
        super.setId(anId);
    }
}
