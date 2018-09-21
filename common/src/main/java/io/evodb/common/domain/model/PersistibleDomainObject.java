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

package io.evodb.common.domain.model;

import io.evodb.common.AssertionConcern;
import java.io.Serializable;


public abstract class PersistibleDomainObject extends AssertionConcern implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;

    protected PersistibleDomainObject() {
        setId(-1);
    }

    protected long id() {
        return id;
    }

    protected void setId(long anId) {
        id = anId;
    }
}