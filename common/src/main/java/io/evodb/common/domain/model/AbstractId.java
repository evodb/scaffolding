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
import java.util.Objects;

public abstract class AbstractId extends AssertionConcern implements Identity, Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    public AbstractId() {

    }

    public AbstractId(String anId) {
        setId(anId);
    }

    @Override
    public String getId() {
        return id;
    }

    protected void validateId(String anId) {

    }

    public void setId(String anId) {
        assertArgumentNotEmpty(anId, "The basic identity is required.");
        assertArgumentLength(anId, 36, "The basic identity must be 36 characters.");
        validateId(anId);
        id = anId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractId)) {
            return false;
        }
        AbstractId that = (AbstractId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
