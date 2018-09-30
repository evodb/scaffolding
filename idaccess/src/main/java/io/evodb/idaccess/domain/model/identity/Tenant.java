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

import io.evodb.idaccess.infrastructure.persistence.HibernateConcurrencySafeEngity;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Tenant extends HibernateConcurrencySafeEngity {
    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    private boolean active;

    @Setter
    @Getter
    private @Size(max = 100) String description;

    @Setter
    @Getter
    private @Size(min = 1, max = 100) String name;

    @Embedded
    @Setter
    @Getter
    private @NotNull TenantId tenantId;

    public Tenant(TenantId aTenantId, String aName, String aDescription, boolean anActive) {
        setTenantId(aTenantId);
        setActive(anActive);
        setName(aName);
        setDescription(aDescription);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public long getId() {
        return super.getId();
    }

}
