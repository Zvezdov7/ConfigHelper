package ru.siblion.zvezdov.config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author Dmitry Zvezdov
 *         10.10.2017.
 */
@Component
public class Config {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);
    private static final String CONFIGURATION_LOCAL_PATH = "/Users/Zvezdov/Documents/DevTools/conf/config.properties";
    private Configurations configs = new Configurations();


    public String getIntFolder() {
        try {
            Configuration config = configs.properties(new File(CONFIGURATION_LOCAL_PATH));
            return config.getString("folder.int");
        }
        catch (ConfigurationException e) {
            logger.warn("Configuration exception: ", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getExtFolder() {
        try {
            Configuration config = configs.properties(new File(CONFIGURATION_LOCAL_PATH));
            return config.getString("folder.ext");
        }
        catch (ConfigurationException e) {
            logger.warn("Configuration exception: ", e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
