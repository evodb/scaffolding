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

import io.evodb.common.domain.model.AbstractValueObject;
import java.io.Serializable;
import java.util.Objects;

public class ContactInformation extends AbstractValueObject<ContactInformation> implements Serializable {
    private CellPhone cellPhone;
    private EmailAddress emailAddress;

    public ContactInformation(FullName aFullName, CellPhone aCellPhone, EmailAddress anEmailAddress) {
        setCellPhone(aCellPhone);
        setEmailAddress(anEmailAddress);
    }

    public CellPhone cellPhone() {
        return cellPhone;
    }

    public EmailAddress emailAddress() {
        return emailAddress;
    }

    public boolean isEqualsTo(ContactInformation contactInformation) {
        return equals(contactInformation);
    }

    protected void setCellPhone(CellPhone aCellPhone) {
        assertArgumentNotNull(aCellPhone, "The cell phone is required.");
        cellPhone = aCellPhone;
    }

    protected void setEmailAddress(EmailAddress anEmailAddress) {
        assertArgumentNotNull(anEmailAddress, "The email address is required.");
        emailAddress = anEmailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ContactInformation)) {
            return false;
        }
        ContactInformation that = (ContactInformation) o;
        return Objects.equals(cellPhone, that.cellPhone) &&
            Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellPhone, emailAddress);
    }
}
