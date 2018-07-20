package SamouczekProgramisty.Zadania._9_Adnotacje;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@MyDocumentation(author = "kowalski", comment = "super")
public class AnnotationProcessor {
    private static List SKIP_METHODS = Arrays.asList("equals", "toString", "hashCode", "annotationType");

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        for (Annotation classAnnotation : AnnotationProcessor.class.getDeclaredAnnotations()) {
            printAnnotationDetails(classAnnotation);
        }
    }

    private static void printAnnotationDetails(Annotation annotation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Znalazłem adnotacje: " + annotation);
        for (Method method : annotation.annotationType().getMethods()) {
            if (SKIP_METHODS.contains(method.getName())) {
                continue;
            }
            System.out.println("Nazwa elementu: " + method.getName());
            System.out.println("Wartosc domyslna elementu: " + method.getDefaultValue());
            System.out.println();
        }
    }
}
