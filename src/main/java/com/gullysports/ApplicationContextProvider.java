
package com.gullysports;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * This class provides access to Application Context.
 * 
 * @author Rakesh Sawan
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    /**
     * Spring Application Context.
     */
    private static ApplicationContext applicationContext;

    /**
     * Sets the application context, called by spring framework at boot.
     * 
     * @param context Spring Application Context instance
     * @throws BeansException in case of an issue
     */
    @Override
    public void setApplicationContext(final ApplicationContext context)
        throws BeansException {

        applicationContext = context;
    }

    /**
     * Gets the Spring application context.
     * 
     * @return ApplicationContext instance
     */
    public static ApplicationContext getContext() {

        return applicationContext;
    }

    /**
     * Get's a given class instance from Spring Bean context.
     * 
     * @param <T> type of the class
     * @param type of the class
     * @return T Instance of the object of type T
     */
    public static <T extends Object> T getInstance(final Class<T> type) {

        ApplicationContext applicationContext = ApplicationContextProvider.getContext();
        return (T) applicationContext.getBean(type);
    }

}
