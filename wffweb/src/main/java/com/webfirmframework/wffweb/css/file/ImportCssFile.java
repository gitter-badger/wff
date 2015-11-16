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
/**
 *
 */
package com.webfirmframework.wffweb.css.file;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author WFF
 * @since 1.0.0
 *
 */
/**
 * To import {@code CssFile} extended class in to another {@code CssFile}
 * extended class.
 *
 * @author WFF
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImportCssFile {

    // public boolean import() default true; this feature is disabled as its
    // corresponding implementation may compromise performance

}
