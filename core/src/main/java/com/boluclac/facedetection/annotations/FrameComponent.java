package com.boluclac.facedetection.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * <h1>Frame Component</h1>
 * Annotation is used when implement Frame for face detection.<br>
 * Any frame use, It will be created automatically
 *
 * @author boluclac
 * @version 0.0.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface FrameComponent {
    @AliasFor(
            annotation = Component.class
    )
    String value() default "";
}
