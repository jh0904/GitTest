package java8.Annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * java8.Annotation
 *
 * @author jh
 * @date 2018/8/3 23:01
 * description:
 */

@Repeatable (MyAnnotations.class)
@Target ({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,TYPE_PARAMETER})
@Retention (RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String value() default "hehe";
}
