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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class User extends ConcurrencySafeEntity {
    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private TenantId tenantId;

    private Person person;

    private boolean active;

    private Date registerTime;

    public User(TenantId aTenantId, String aUsername, String aPassword, Person aPerson, boolean anActive) {
        setTenantId(aTenantId);
        setUsername(aUsername);
        setPassword(aPassword);
        setPerson(aPerson);
        setActive(anActive);
        setRegisterTime(new Date());
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public TenantId tenantId() {
        return tenantId;
    }

    public Person person() {
        return person;
    }

    public boolean isActive() {
        return active;
    }

    public Date registerTime() {
        return registerTime;
    }

    protected void setUsername(String aUsername) {
        assertArgumentNotNull(aUsername, "The username is required.");
        assertArgumentLength(aUsername, 3, 200, "The username must be 3 to 250 characters.");
        username = aUsername;
    }

    protected void setPassword(String aPassword) {
        password = aPassword;
    }

    protected void setTenantId(TenantId aTenantId) {
        assertArgumentNotNull(aTenantId, "The tenant id is required.");
        tenantId = aTenantId;
    }

    protected void setPerson(Person aPerson) {
        assertArgumentNotNull(aPerson, "The person is required.");
        person = aPerson;
    }

    protected void setActive(boolean aFlag) {
        active = aFlag;
    }

    private void setRegisterTime(Date aRegisterTime) {
        assertArgumentNotNull(registerTime, "The register time is required.");
        registerTime = aRegisterTime;
    }

    @Id
    @GeneratedValue
    @Override
    protected void setId(long anId) {
        super.setId(anId);
    }
}
