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
package com.webfirmframework.wffweb.tag.html.attribute;

import com.webfirmframework.wffweb.tag.html.attribute.core.AbstractAttribute;
import com.webfirmframework.wffweb.tag.html.identifier.AAttribute;
import com.webfirmframework.wffweb.tag.html.identifier.AreaAttribute;

/**
 * This attribute is used to define a selectable region for hypertext source
 * links associated with a figure to create an image map. The values for the
 * attribute are circle, default, polygon, and rect. The format of the coords
 * attribute depends on the value of shape. For circle, the value is x,y,r where
 * x and y are the pixel coordinates for the center of the circle and r is the
 * radius value in pixels. For rect, the coords attribute should be x,y,w,h. The
 * x,y values define the upper-left-hand corner of the rectangle, while w and h
 * define the width and height respectively. A value of polygon for shape
 * requires x1,y1,x2,y2,... values for coords. Each of the x,y pairs defines a
 * point in the polygon, with successive points being joined by straight lines
 * and the last point joined to the first. The value default for shape requires
 * that the entire enclosed area, typically an image, be used.
 *
 * <code>shape</code> attribute for the element.NB: This attribute is not
 * supported by html5
 *
 * @author WFF
 *
 */
public class Shape extends AbstractAttribute implements AAttribute, AreaAttribute {

    private static final long serialVersionUID = 1_0_0L;

    /**
     * Specifies the entire region
     */
    public static final String DEFAULT = "default";

    /**
     * Defines a rectangular region
     */
    public static final String rect = "rect";

    /**
     * Defines a circular region
     */
    public static final String circle = "circle";

    /**
     * Defines a polygonal region
     */
    public static final String poly = "poly";

    {
        super.setAttributeName(AttributeNameConstants.SHAPE);
        init();
    }

    /**
     *
     * @param value
     *            the value for the attribute
     * @since 1.0.0
     * @author WFF
     */
    public Shape(final String value) {
        setAttributeValue(value);
    }

    /**
     * sets the value for this attribute
     *
     * @param value
     *            the value for the attribute.
     * @since 1.0.0
     * @author WFF
     */
    protected void setValue(final String value) {
        super.setAttributeValue(value);
    }

    /**
     * gets the value of this attribute
     *
     * @return the value of the attribute
     * @since 1.0.0
     * @author WFF
     */
    public String getValue() {
        return super.getAttributeValue();
    }

    /**
     * invokes only once per object
     *
     * @author WFF
     * @since 1.0.0
     */
    protected void init() {
    }

}