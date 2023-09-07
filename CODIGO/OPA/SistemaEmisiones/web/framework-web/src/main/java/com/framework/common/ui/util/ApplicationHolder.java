package com.framework.common.ui.util;

//import com.vaadin.Application;
import com.vaadin.server.*;
import com.vaadin.ui.UI;


/**
 * Clases de integracion Vaadin -Spring
 * The Class ApplicationHolder.
 */
public class ApplicationHolder {

    /** The app. */
    private static ThreadLocal<UI> ui = new ThreadLocal<UI>();

    /**
     * Sets the application.
     *
     * @param application the new application
     */
    public static void setApplication(UI ui) {
        ui.setContent(ui);
    }

    /**
     * Reset application.
     */
    public static void resetApplication() {
        ui.remove();
    }

    /**
     * Gets the application.
     *
     * @return the application
     */
    public static UI getApplication() {
        return ui.get();
    }
}
