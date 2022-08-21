package com.boluclac.facedetection.gui.common.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * <h1>Facade Component</h1>
 * Annotation is used when implement Facade for face detection.<br>
 * Any frame use, It will be created automatically
 *
 * @author boluclac
 * @version 0.0.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Facade {
    @AliasFor(
            annotation = Component.class
    )
    String value() default "";
}
