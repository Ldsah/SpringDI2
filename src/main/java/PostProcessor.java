import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * Created by dav on 11/01/16.
 */
public class PostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field f: fields){
            UglyTask annotation = f.getAnnotation(UglyTask.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                f.setAccessible(true);
                try {
                    f.set(o, max + min);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
