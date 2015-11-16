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
package com.webfirmframework.wffweb.util;

/**
 *
 * @author WFF
 * @since 1.0.0
 */
public class StringBuilderUtil {
    private StringBuilderUtil() {
        throw new AssertionError();
    }

    /**
     * @param sb
     *            the {@code StringBuilder} object to create a trimmed string
     *            from it.
     * @return
     * @since 1.0.0
     * @author WFF
     */
    public static String getTrimmedString(final StringBuilder sb) {
        int first, last;

        for (first = 0; first < sb.length(); first++) {
            if (!Character.isWhitespace(sb.charAt(first))) {
                break;
            }
        }

        for (last = sb.length(); last > first; last--) {
            if (!Character.isWhitespace(sb.charAt(last - 1))) {
                break;
            }
        }

        return sb.substring(first, last);
    }

}
