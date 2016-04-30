/*
 * Copyright 2014-2016 Web Firm Framework
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
package com.webfirmframework.wffweb.tag.html.html5.attribute;

import com.webfirmframework.wffweb.tag.html.attribute.AttributeNameConstants;
import com.webfirmframework.wffweb.tag.html.attribute.core.AbstractAttribute;
import com.webfirmframework.wffweb.tag.html.identifier.InputAttributable;

/**
 *
 * <code>form</code> attribute for the element. <br/>
 *
 * The form element that the input element is associated with (its form owner).
 * The value of the attribute must be an id of a {@code<form>} element in the
 * same document. If this attribute is not specified, this {@code
 * <input>} element must be a descendant of a {@code<form>} element. This
 * attribute enables you to place {@code<input>} elements anywhere within a
 * document, not just as descendants of their form elements. An input can only
 * be associated with one form.
 *
 *
 * @author WFF
 * @since 1.0.0
 */
public class FormAttribute extends AbstractAttribute
        implements InputAttributable {

    private static final long serialVersionUID = 1_0_0L;

    {
        super.setAttributeName(AttributeNameConstants.FORM);
        init();
    }

    /**
     *
     * @param value
     *            the value for the attribute
     * @since 1.0.0
     */
    public FormAttribute(final String value) {
        setAttributeValue(value);
    }

    /**
     * sets the value for this attribute
     *
     * @param value
     *            the value for the attribute.
     * @since 1.0.0
     */
    protected void setValue(final String value) {
        super.setAttributeValue(value);
    }

    /**
     * gets the value of this attribute
     *
     * @return the value of the attribute
     * @since 1.0.0
     */
    public String getValue() {
        return super.getAttributeValue();
    }

    /**
     * invokes only once per object
     *
     * @since 1.0.0
     */
    protected void init() {
        // to override and use this method
    }

}
