package com.boluclac.facedetection;

import com.boluclac.facedetection.configurations.ApplicationConfig;
import com.boluclac.facedetection.configurations.LoggingConfig;
import com.boluclac.facedetection.utils.LogUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * <h1>Configuration</h1>
 * Configuration for face detection
 *
 * @author boluclac
 * @version 0.0.0
 */
@Configuration
@ComponentScan
@PropertySources({
        @PropertySource("classpath:config/config.properties")
})
public class ConfigurationCore {

    /**
     * Application context
     */
    private static ApplicationContext applicationContext;

    /**
     * <h2>Initialize configuration</h2>
     * configuration detail:
     * <ul>
     *     <li>Component scan bean: {@link com.boluclac.facedetection}</li>
     *     <li>Application config: {@link ApplicationConfig}</li>
     *     <li>Logging config: {@link LogUtils}</li>
     * </ul>
     */
    public static void config() {
        AnnotationConfigApplicationContext configuration = new AnnotationConfigApplicationContext();
        ConfigurationCore.applicationContext = configuration;
        configuration.register(LoggingConfig.class);
        configuration.register(ConfigurationCore.class);
        configuration.register(ApplicationConfig.class);
        configuration.refresh();

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            LogUtils.debug("Bean is created: " + beanDefinitionName);
        }
    }

    /**
     * <h2>Get bean</h2>
     * get any bean is created
     *
     * @param clazz Class object
     * @param <T>   Class type template
     * @return bean object
     */
    public static <T> T getBean(Class<T> clazz) {
        if (applicationContext != null) {
            LogUtils.debug("get bean: " + clazz.toString());
            return applicationContext.getBean(clazz);
        } else {
            return null;
        }
    }
}
