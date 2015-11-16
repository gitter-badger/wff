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
package com.webfirmframework.wffweb.css;

import java.util.logging.Logger;

import com.webfirmframework.wffweb.InvalidValueException;
import com.webfirmframework.wffweb.NullValueException;
import com.webfirmframework.wffweb.clone.CloneUtil;
import com.webfirmframework.wffweb.data.AbstractBean;
import com.webfirmframework.wffweb.data.Bean;
import com.webfirmframework.wffweb.informer.StateChangeInformer;
import com.webfirmframework.wffweb.util.TagStringUtil;

/**
 *
 * @author WFF
 * @since 1.0.0
 */
public class BorderColorCssValues extends AbstractBean<BorderColorCssValues>
        implements StateChangeInformer<Bean> {

    private static final long serialVersionUID = -5840355060958262635L;

    public static final Logger LOGGER = Logger
            .getLogger(BorderColorCssValues.class.getName());

    public static final String TRANSPARENT = "transparent";

    private String cssValue;

    private RgbCssValue rgbCssValue;

    private RgbaCssValue rgbaCssValue;

    private HslCssValue hslCssValue;

    private HslaCssValue hslaCssValue;

    /**
     * The {@code initial} will be set as the value
     */
    public BorderColorCssValues() {
        setValue("black");
    }

    /**
     * @param cssValue
     *            the css value to set.
     */
    public BorderColorCssValues(final String cssValue) {
        setValue(cssValue);
    }

    /**
     * @param borderColorCssValue
     *            the {@code BorderColorCssValues} object from which the
     *            cssValue to set.And, {@code null} will throw
     *            {@code NullValueException}
     */
    public BorderColorCssValues(final BorderColorCssValues borderColorCssValue) {
        if (borderColorCssValue == null) {
            throw new NullValueException("borderColorCssValue can not be null");
        }
        setValue(borderColorCssValue.getValue());
    }

    /**
     * @param rgbCssValue
     */
    public BorderColorCssValues(final RgbCssValue rgbCssValue) {
        super();
        setRgbCssValue(rgbCssValue);
    }

    /**
     * @param rgbaCssValue
     */
    public BorderColorCssValues(final RgbaCssValue rgbaCssValue) {
        super();
        setRgbaCssValue(rgbaCssValue);
    }

    /**
     * @param hslCssValue
     */
    public BorderColorCssValues(final HslCssValue hslCssValue) {
        super();
        setHslCssValue(hslCssValue);
    }

    /**
     * @param hslCssValue
     */
    public BorderColorCssValues(final HslaCssValue hslaCssValue) {
        super();
        setHslaCssValue(hslaCssValue);
    }

    /**
     * @param rgbaCssValue2
     * @author WFF
     * @since 1.0.0
     */
    public void setRgbaCssValue(final RgbaCssValue rgbaCssValue) {
        if (rgbaCssValue == null) {
            throw new NullValueException("rgbaCssValue can not be null");
        }
        if (this.rgbaCssValue != null) {
            if (rgbaCssValue.isAlreadyInUse()
                    && this.rgbaCssValue.getStateChangeInformer() != rgbaCssValue
                            .getStateChangeInformer()) {
                try {
                    final RgbaCssValue rgbaCssValueClone = CloneUtil
                            .deepClone(rgbaCssValue);
                    this.rgbaCssValue.setAlreadyInUse(false);
                    this.rgbaCssValue = rgbaCssValueClone;
                    LOGGER.warning("cloned rgbaCssValue " + rgbaCssValue
                            + "(hashcode: " + rgbaCssValue.hashCode()
                            + ") as it is already used by another object");
                } catch (final CloneNotSupportedException e) {
                    throw new InvalidValueException(e.toString());
                }
            } else {
                this.rgbaCssValue.setAlreadyInUse(false);
                this.rgbaCssValue = rgbaCssValue;
            }
        } else {
            if (rgbaCssValue.isAlreadyInUse()) {
                try {
                    this.rgbaCssValue = CloneUtil.deepClone(rgbaCssValue);
                    LOGGER.warning("cloned rgbaCssValue " + rgbaCssValue
                            + "(hashcode: " + rgbaCssValue.hashCode()
                            + ") as it is already used by another object");
                } catch (final CloneNotSupportedException e) {
                    throw new InvalidValueException(e.toString());
                }
            } else {
                this.rgbaCssValue = rgbaCssValue;
            }
        }
        cssValue = this.rgbaCssValue.getValue();
        this.rgbaCssValue.setStateChangeInformer(this);
        this.rgbaCssValue.setAlreadyInUse(true);
        makeRgbCssValueNull();
        makeHslCssValueNull();
        makeHslaCssValueNull();
    }

    /**
     * @param hslaCssValue
     *            the hslaCssValue to set.
     * @author WFF
     * @since 1.0.0
     */
    public void setHslaCssValue(final HslaCssValue hslaCssValue) {
        if (hslaCssValue == null) {
            throw new NullValueException("hslaCssValue can not be null");
        }
        if (this.hslaCssValue != null) {
            if (hslaCssValue.isAlreadyInUse()
                    && this.hslaCssValue.getStateChangeInformer() != hslaCssValue
                            .getStateChangeInformer()) {
                try {
                    final HslaCssValue hslaCssValueClone = CloneUtil
                            .deepClone(hslaCssValue);
                    this.hslaCssValue.setAlreadyInUse(false);
                    this.hslaCssValue = hslaCssValueClone;
                    LOGGER.warning("cloned hslaCssValue " + hslaCssValue
                            + "(hashcode: " + hslaCssValue.hashCode()
                            + ") as it is already used by another object");
                } catch (final CloneNotSupportedException e) {
                    throw new InvalidValueException(e.toString());
                }
            } else {
                this.hslaCssValue.setAlreadyInUse(false);
                this.hslaCssValue = hslaCssValue;
            }
        } else {
            if (hslaCssValue.isAlreadyInUse()) {
                try {
                    this.hslaCssValue = CloneUtil.deepClone(hslaCssValue);
                    LOGGER.warning("cloned hslaCssValue " + hslaCssValue
                            + "(hashcode: " + hslaCssValue.hashCode()
                            + ") as it is already used by another object");
                } catch (final CloneNotSupportedException e) {
                    throw new InvalidValueException(e.toString());
                }
            } else {
                this.hslaCssValue = hslaCssValue;
            }
        }
        cssValue = this.hslaCssValue.getValue();
        this.hslaCssValue.setStateChangeInformer(this);
        this.hslaCssValue.setAlreadyInUse(true);
        makeRgbCssValueNull();
        makeRgbaCssValueNull();
        makeHslCssValueNull();
    }

    @Override
    public String toString() {
        return getValue();
    }

    /**
     * gets the value, {@code getCssValue} method can also be used to get the
     * same value.
     *
     * @return the value in String.
     * @since 1.0.0
     * @author WFF
     */
    @Override
    public String getValue() {
        return cssValue;
    }

    /**
     * @param cssValue
     *            the value should be a color/color code/rgb, for example
     *            <code>#0000ff</code>. {@code null} is considered as an invalid
     *            value and it will throw {@code NullValueException}.And an
     *            empty string is also considered as an invalid value and it
     *            will throw {@code InvalidValueException}.
     * @since 1.0.0
     * @author WFF
     */
    public BorderColorCssValues setValue(final String cssValue) {
        final String previousCssValue = this.cssValue;
        try {
            if (cssValue == null) {
                throw new NullValueException(
                        "null is an invalid value. The value should be any color for example #0000ff, rgb(15, 25, 155), rgba(15, 25, 155, 0.5) Or, initial/inherit/transparent.");
            } else if (!isValid(cssValue)) {
                throw new InvalidValueException(
                        cssValue
                                + " is an invalid value. The value should be any color for example #0000ff, rgb(15, 25, 155), rgba(15, 25, 155, 0.5) Or, initial/inherit/transparent.");
            } else {
                this.cssValue = cssValue.trim();
                if (RgbCssValue.isValid(cssValue)) {
                    if (rgbCssValue == null) {
                        rgbCssValue = new RgbCssValue(cssValue);
                    } else {
                        rgbCssValue.setRgb(this.cssValue);
                    }
                    rgbCssValue.setStateChangeInformer(this);
                } else {
                    makeRgbCssValueNull();
                }

                if (RgbaCssValue.isValid(cssValue)) {
                    if (rgbaCssValue == null) {
                        rgbaCssValue = new RgbaCssValue(cssValue);
                    } else {
                        rgbaCssValue.setRgba(this.cssValue);
                    }
                    rgbaCssValue.setStateChangeInformer(this);
                } else {
                    makeRgbaCssValueNull();
                }

                if (HslCssValue.isValid(cssValue)) {
                    if (hslCssValue == null) {
                        hslCssValue = new HslCssValue(cssValue);
                    } else {
                        hslCssValue.setHsl(this.cssValue);
                    }
                    hslCssValue.setStateChangeInformer(this);
                } else {
                    makeHslCssValueNull();
                }

                if (HslaCssValue.isValid(cssValue)) {
                    if (hslaCssValue == null) {
                        hslaCssValue = new HslaCssValue(cssValue);
                    } else {
                        hslaCssValue.setHsla(this.cssValue);
                    }
                    hslaCssValue.setStateChangeInformer(this);
                } else {
                    makeHslaCssValueNull();
                }

                if (getStateChangeInformer() != null) {
                    getStateChangeInformer().stateChanged(this);
                }
            }
        } catch (final InvalidValueException e) {
            this.cssValue = previousCssValue;
            throw e;
        }
        return this;
    }

    /**
     * sets as {@code transparent}
     *
     * @since 1.0.0
     * @author WFF
     */
    public void setAsTransparent() {
        setValue(TRANSPARENT);
    }

    /**
     * @param cssValue
     * @return true if the given {@code cssValue} is valid.
     * @since 1.0.0
     * @author WFF
     */
    public static boolean isValid(final String cssValue) {

        if (cssValue == null) {
            return false;
        }

        final String trimmedCssValue = cssValue.trim();

        if (trimmedCssValue.isEmpty()) {
            return false;
        }

        final String trimmedCssValueLowerCase = TagStringUtil
                .toLowerCase(trimmedCssValue);

        if (TRANSPARENT.equals(trimmedCssValueLowerCase)) {
            return true;
        }

        if (CssColorName.isValid(trimmedCssValue)) {
            return true;
        }

        if (RgbCssValue.isValid(trimmedCssValue)) {
            return true;
        }
        if (RgbaCssValue.isValid(trimmedCssValue)) {
            return true;
        }
        if (HslCssValue.isValid(trimmedCssValue)) {
            return true;
        }
        if (HslaCssValue.isValid(trimmedCssValue)) {
            return true;
        }

        try {
            if (!trimmedCssValue.startsWith("#")) {
                return false;
            }
            final long value = Long.parseLong(cssValue.replaceFirst("[#]", ""),
                    16);
            // Long.parseLong("FFFFFF", 16) gives 16777215L;
            final long maxCssValue = 16777215L;
            if (value > maxCssValue || value < 0) {
                return false;
            }
            return true;
        } catch (final NumberFormatException ex) {
        }

        return false;
    }

    @Override
    public void stateChanged(final Bean stateChangedObject) {
        cssValue = stateChangedObject.getValue();
        if (getStateChangeInformer() != null) {
            getStateChangeInformer().stateChanged(this);
        }
    }

    /**
     * @return the rgbCssValue
     * @since 1.0.0
     * @author WFF
     */
    public RgbCssValue getRgbCssValue() {
        return rgbCssValue;
    }

    /**
     * @return the rgbaCssValue
     * @author WFF
     * @since 1.0.0
     */
    public RgbaCssValue getRgbaCssValue() {
        return rgbaCssValue;
    }

    /**
     * @return the hslCssValue
     * @author WFF
     * @since 1.0.0
     */
    public HslCssValue getHslCssValue() {
        return hslCssValue;
    }

    /**
     * @return the hslaCssValue
     * @author WFF
     * @since 1.0.0
     */
    public HslaCssValue getHslaCssValue() {
        return hslaCssValue;
    }

    /**
     * @param rgbCssValue
     *            the rgbCssValue to set
     * @since 1.0.0
     * @author WFF
     */
    public void setRgbCssValue(final RgbCssValue rgbCssValue) {
        if (rgbCssValue == null) {
            throw new NullValueException("rgbCssValue can not be null");
        }
        if (this.rgbCssValue != null) {
            if (rgbCssValue.isAlreadyInUse()
                    && this.rgbCssValue.getStateChangeInformer() != rgbCssValue
                            .getStateChangeInformer()) {
                try {
                    final RgbCssValue rgbCssValueClone = CloneUtil
                            .deepClone(rgbCssValue);
                    this.rgbCssValue.setAlreadyInUse(false);
                    this.rgbCssValue = rgbCssValueClone;
                    LOGGER.warning("cloned rgbCssValue " + rgbCssValue
                            + "(hashcode: " + rgbCssValue.hashCode()
                            + ") as it is already used by another object");
                } catch (final CloneNotSupportedException e) {
                    throw new InvalidValueException(e.toString());
                }
            } else {
                this.rgbCssValue.setAlreadyInUse(false);
                this.rgbCssValue = rgbCssValue;
            }
        } else {
            if (rgbCssValue.isAlreadyInUse()) {
                try {
                    this.rgbCssValue = CloneUtil.deepClone(rgbCssValue);
                    LOGGER.warning("cloned rgbCssValue " + rgbCssValue
                            + "(hashcode: " + rgbCssValue.hashCode()
                            + ") as it is already used by another object");
                } catch (final CloneNotSupportedException e) {
                    throw new InvalidValueException(e.toString());
                }
            } else {
                this.rgbCssValue = rgbCssValue;
            }
        }
        cssValue = this.rgbCssValue.getValue();
        this.rgbCssValue.setStateChangeInformer(this);
        this.rgbCssValue.setAlreadyInUse(true);
        makeRgbaCssValueNull();
        makeHslCssValueNull();
        makeHslaCssValueNull();
    }

    /**
     * @param hslCssValue
     *            the hslCssValue to set
     * @since 1.0.0
     * @author WFF
     */
    public void setHslCssValue(final HslCssValue hslCssValue) {
        if (hslCssValue == null) {
            throw new NullValueException("hslCssValue can not be null");
        }
        if (this.hslCssValue != null) {
            if (hslCssValue.isAlreadyInUse()
                    && this.hslCssValue.getStateChangeInformer() != hslCssValue
                            .getStateChangeInformer()) {
                try {
                    final HslCssValue hslCssValueClone = CloneUtil
                            .deepClone(hslCssValue);
                    this.hslCssValue.setAlreadyInUse(false);
                    this.hslCssValue = hslCssValueClone;
                    LOGGER.warning("cloned hslCssValue " + hslCssValue
                            + "(hashcode: " + hslCssValue.hashCode()
                            + ") as it is already used by another object");
                } catch (final CloneNotSupportedException e) {
                    throw new InvalidValueException(e.toString());
                }
            } else {
                this.hslCssValue.setAlreadyInUse(false);
                this.hslCssValue = hslCssValue;
            }
        } else {
            if (hslCssValue.isAlreadyInUse()) {
                try {
                    this.hslCssValue = CloneUtil.deepClone(hslCssValue);
                    LOGGER.warning("cloned hslCssValue " + hslCssValue
                            + "(hashcode: " + hslCssValue.hashCode()
                            + ") as it is already used by another object");
                } catch (final CloneNotSupportedException e) {
                    throw new InvalidValueException(e.toString());
                }
            } else {
                this.hslCssValue = hslCssValue;
            }
        }
        cssValue = this.hslCssValue.getValue();
        this.hslCssValue.setStateChangeInformer(this);
        this.hslCssValue.setAlreadyInUse(true);
        makeRgbCssValueNull();
        makeRgbaCssValueNull();
        makeHslaCssValueNull();
    }

    private void makeRgbCssValueNull() {
        if (rgbCssValue != null) {
            rgbCssValue.setAlreadyInUse(false);
            rgbCssValue = null;
        }
    }

    private void makeRgbaCssValueNull() {
        if (rgbaCssValue != null) {
            rgbaCssValue.setAlreadyInUse(false);
            rgbaCssValue = null;
        }
    }

    private void makeHslCssValueNull() {
        if (hslCssValue != null) {
            hslCssValue.setAlreadyInUse(false);
            hslCssValue = null;
        }
    }

    private void makeHslaCssValueNull() {
        if (hslaCssValue != null) {
            hslaCssValue.setAlreadyInUse(false);
            hslaCssValue = null;
        }
    }
}
