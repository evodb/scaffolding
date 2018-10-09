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

import io.evodb.idaccess.infrastructure.persistence.JpaConcurrencySafeEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(indexes = @Index(name = "username", columnList = "username", unique = true))
public class User extends JpaConcurrencySafeEntity {
    private static final long serialVersionUID = 1L;

    @Getter
    private String username;

    @Getter
    private String password;

    @Getter
    private TenantId tenantId;

    @Getter
    private Person person;

    @Getter
    private boolean active;

    @Getter
    private Date registerTime;

    public User(TenantId aTenantId, String aUsername, String aPassword, boolean anActive) {
        setTenantId(aTenantId);
        setUsername(aUsername);
        setPassword(aPassword);
        setActive(anActive);
        setRegisterTime(new Date());
    }

    public User(TenantId aTenantId, String aUsername, String aPassword, Person aPerson, boolean anActive) {
        setTenantId(aTenantId);
        setUsername(aUsername);
        setPassword(aPassword);
        setActive(anActive);
        setPerson(aPerson);
        setRegisterTime(new Date());
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
}
