package com.webfirmframework.wffweb.tag.html;

import java.util.logging.Logger;

import com.webfirmframework.wffweb.settings.WffConfiguration;
import com.webfirmframework.wffweb.tag.html.attribute.core.AbstractAttribute;
import com.webfirmframework.wffweb.tag.html.identifier.GlobalAttribute;
import com.webfirmframework.wffweb.tag.html.identifier.QfnAttribute;

/**
 * @author WFF
 * @since 1.0.0
 * @version 1.0.0
 *
 */
public class Qfn extends AbstractHtml {

    private static final long serialVersionUID = -7984624397729683713L;

    public static final Logger LOGGER = Logger.getLogger(Qfn.class.getName());

    {
        init();
    }

    /**
     * Represents the root of an HTML or XHTML document. All other elements must
     * be descendants of this element.
     *
     * @param base
     *            i.e. parent tag of this tag
     * @param attributes
     *            An array of {@code AbstractAttribute}
     *
     * @since 1.0.0
     */
    public Qfn(final AbstractHtml base, final AbstractAttribute... attributes) {
        super(Qfn.class.getSimpleName().toLowerCase(), base, attributes);
        if (WffConfiguration.isDirectionWarningOn()) {
            for (final AbstractAttribute abstractAttribute : attributes) {
                if (!(abstractAttribute != null && (abstractAttribute instanceof QfnAttribute || abstractAttribute instanceof GlobalAttribute))) {
                    LOGGER.warning(abstractAttribute
                            + " is not an instance of QfnAttribute");
                }
            }
        }
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