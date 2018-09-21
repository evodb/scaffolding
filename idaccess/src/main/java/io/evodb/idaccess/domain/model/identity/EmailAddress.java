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

public class EmailAddress extends AbstractValueObject<EmailAddress> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String emailAddress;

    public EmailAddress(String anEmailAddress) {
        setEmailAddress(anEmailAddress);
    }

    protected void setEmailAddress(String anEmailAddress) {
        assertArgumentLength(anEmailAddress, 1, 100, "The email address must be 100 characters or less. ");
        emailAddress = anEmailAddress;
    }

    public String address() {
        return emailAddress;
    }

    public boolean isEqualsTo(EmailAddress aValueObject) {
        return false;
    }
}
