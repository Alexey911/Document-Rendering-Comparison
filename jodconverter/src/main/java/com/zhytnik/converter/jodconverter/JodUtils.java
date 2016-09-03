package com.zhytnik.converter.jodconverter;

import com.sun.star.beans.PropertyValue;
import com.sun.star.lang.XComponent;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.util.CloseVetoException;
import com.sun.star.util.XCloseable;
import com.sun.star.util.XRefreshable;

import java.util.Map;

/**
 * @author Alexey Zhytnik
 * @since 01.09.2016
 */
class JodUtils {

    private JodUtils() {
    }

    static void refresh(XComponent document) {
        final XRefreshable refreshable = (XRefreshable) UnoRuntime.queryInterface(XRefreshable.class, document);
        if (refreshable != null) {
            refreshable.refresh();
        }
    }

    static void quietlyClose(XComponent document) {
        final XCloseable closeable = (XCloseable) UnoRuntime.queryInterface(XCloseable.class, document);
        if (closeable != null) {
            try {
                closeable.close(true);
            } catch (CloseVetoException ignored) {
                //TODO: log warning
            }
        } else {
            document.dispose();
        }
    }

    static PropertyValue[] properties(Map<String, Object> settings) {
        final PropertyValue[] properties = new PropertyValue[settings.size()];
        int pos = 0;
        for (Map.Entry<String, Object> entry : settings.entrySet()) {
            properties[pos++] = property(entry.getKey(), entry.getValue());
        }
        return properties;
    }

    private static PropertyValue property(String name, Object value) {
        final PropertyValue p = new PropertyValue();
        p.Name = name;
        p.Value = value;
        return p;
    }
}
