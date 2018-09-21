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

public class CellPhone extends AbstractValueObject<CellPhone> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cellPhone;

    public CellPhone(String aCellPhone) {
        setCellPhone(aCellPhone);
    }

    public String number() {
        return cellPhone;
    }

    protected void setCellPhone(String cellPhone) {
        assertArgumentNotNull(cellPhone, "The cell phone is requried.");
        assertArgumentLength(cellPhone, 1, 20, "The cell phone must be 20 characters or less.");
    }

    public boolean isEqualsTo(CellPhone aCellPhone) {
        return equals(aCellPhone);
    }
}
