
package com.gullysports;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * This class provides access to application configuration as defined in,
 * application.properties.
 * 
 * @author Rakesh Sawan
 */
@Configuration("config")
public class AppConfig {

    /**
     * Gets the instance of AppConfig bean. Ideally @Autowired annotation should
     * work, but for some reason it's not working hence we are creating the
     * instance ourselves.
     * 
     * @return AppConfig instance
     */
    public static AppConfig getInstance() {

        ApplicationContext applicationContext = ApplicationContextProvider.getContext();
        return (AppConfig) applicationContext.getBean(AppConfig.class);
    }
    /**
     * configuration property which defines whether we must install trust
     * manager for network calls over secure networks or not.
     */
    @Value("${trust_to_certs:false}")
    private boolean trustToCertificates;
    
    /**
     * Determines if certificates should be trusted or not.
     * 
     * @return true/false
     */
    public boolean isTrustToCertificates() {

        return this.trustToCertificates;
    }

}
