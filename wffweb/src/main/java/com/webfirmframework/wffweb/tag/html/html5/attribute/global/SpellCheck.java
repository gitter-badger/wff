/*
 * Copyright 2014-2015 Web Firm Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @author WFF
 */
package com.webfirmframework.wffweb.tag.html.html5.attribute.global;

import com.webfirmframework.wffweb.tag.html.attribute.AttributeNameConstants;
import com.webfirmframework.wffweb.tag.html.attribute.core.AbstractAttribute;
import com.webfirmframework.wffweb.tag.html.identifier.GlobalAttribute;

/**
 * {@code <element spellcheck="true|false"> }
 *
 * <pre>
 * The spellcheck attribute specifies whether the element is to have its spelling and grammar checked or not.
 *
 * The following can be spellchecked:
 *
 *     Text values in input elements (not password)
 *     Text in <textarea> elements
 *     Text in editable elements
 *
 * </pre>
 *
 * @author WFF
 *
 */
public class SpellCheck extends AbstractAttribute implements GlobalAttribute {

    private static final long serialVersionUID = -4612248339193953402L;

    private boolean check;

    {
        super.setAttributeName(AttributeNameConstants.SPELLCHECK);
        init();
    }

    /**
     * <code>false</code> will be set as the value.
     *
     * @author WFF
     * @since 1.0.0
     */
    public SpellCheck() {
        setAttributeValue(String.valueOf(check));
    }

    public SpellCheck(final boolean check) {
        setAttributeValue(String.valueOf(check));
        this.check = check;
    }

    /**
     * invokes only once per object
     *
     * @author WFF
     * @since 1.0.0
     */
    protected void init() {
    }

    /**
     * @return the check
     * @author WFF
     * @since 1.0.0
     */
    public boolean isCheck() {
        return check;
    }

    /**
     * @param check
     *            the check to set.
     * @author WFF
     * @since 1.0.0
     */
    public void setCheck(final boolean check) {
        setAttributeValue(String.valueOf(check));
        this.check = check;
    }

}