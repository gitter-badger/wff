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
 */
package com.webfirmframework.wffweb.server.page;

import com.webfirmframework.wffweb.tag.html.AbstractHtml;
import com.webfirmframework.wffweb.tag.html.attribute.core.AbstractAttribute;
import com.webfirmframework.wffweb.tag.html.listener.AttributeAddListener;
import com.webfirmframework.wffweb.util.WffBinaryMessageUtil;
import com.webfirmframework.wffweb.util.data.NameValue;

public class AttributeAddListenerImpl implements AttributeAddListener {

    private static final long serialVersionUID = 1L;

    private BrowserPage browserPage;

    @SuppressWarnings("unused")
    private AttributeAddListenerImpl() {
        throw new AssertionError();
    }

    AttributeAddListenerImpl(final BrowserPage browserPage) {
        this.browserPage = browserPage;
    }

    @Override
    public void addedAttributes(final AddEvent event) {

        // should always be taken from browserPage as it could be changed
        final WebSocketPushListener wsListener = browserPage.getWsListener();

        try {

            if (wsListener != null) {

                //@formatter:off
                // removed attribute task format :-
                // { "name": task_byte, "values" : [ADDED_ATTRIBUTES_byte_from_Task_enum]}, { "name": MANY_TO_ONE_byte, "values" : [ tagName, its_data-wff-id, attribute_name=value1, attribute_name2=value2 ]}
                // { "name": 2, "values" : [[1]]}, { "name":[2], "values" : ["div", "C55", "style=color:green", "name=hello"]}
                //@formatter:on

                final NameValue task = Task.ADDED_ATTRIBUTES.getTaskNameValue();

                final NameValue nameValue = new NameValue();
                // many attributes to one tag
                nameValue.setName(Task.MANY_TO_ONE.getValueByte());

                final AbstractHtml addedToTag = event.getAddedToTag();
                final byte[][] tagNameAndWffId = DataWffIdUtil
                        .getTagNameAndWffId(addedToTag);

                final AbstractAttribute[] addedAttributes = event
                        .getAddedAttributes();

                final int totalValues = addedAttributes.length + 2;

                final byte[][] values = new byte[totalValues][0];

                values[0] = tagNameAndWffId[0];
                values[1] = tagNameAndWffId[1];

                for (int i = 2; i < totalValues; i++) {
                    // should be name=somevalue
                    String attrNameValue = addedAttributes[i - 2]
                            .toHtmlString("UTF-8").replaceFirst("[=][\"]", "=");

                    if (attrNameValue
                            .charAt(attrNameValue.length() - 1) == '"') {
                        attrNameValue = attrNameValue.substring(0,
                                attrNameValue.length() - 1);
                    }

                    values[i] = attrNameValue.getBytes("UTF-8");
                }

                nameValue.setValues(values);

                final byte[] wffBinaryMessageBytes = WffBinaryMessageUtil.VERSION_1
                        .getWffBinaryMessageBytes(task, nameValue);

                wsListener.push(wffBinaryMessageBytes);

            }
        } catch (final Exception e) {
            e.printStackTrace();

        }

    }

}
