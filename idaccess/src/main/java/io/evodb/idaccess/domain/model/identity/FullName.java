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

public class FullName extends AbstractValueObject<FullName> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;

    public FullName(String aFirstName, String aLastName) {
        setFirstName(aFirstName);
        setLastName(aLastName);
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    protected void setFirstName(String aFirstName) {
        assertArgumentNotNull(aFirstName, "The first name is required.");
        assertArgumentLength(aFirstName, 1, 50, "First name must be 50 characters or less.");
        firstName = aFirstName;
    }

    protected void setLastName(String aLastName) {
        assertArgumentNotNull(aLastName, "The last name is required.");
        assertArgumentLength(aLastName, 1, 50, "Last name must be 50 characters or less.");
        lastName = aLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FullName)) {
            return false;
        }
        FullName fullName = (FullName) o;
        return Objects.equals(firstName, fullName.firstName) &&
            Objects.equals(lastName, fullName.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public boolean isEqualsTo(FullName aFullName) {
        return equals(aFullName);
    }
}
