package validators;

import org.banking.Menu;
import org.banking.peoples.Customer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Pattern;

public class ValidCustomer {
    public static void check(Customer customer, Menu menu) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz = customer.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ValidPesel.class)) {
                ValidPesel annotation = field.getAnnotation(ValidPesel.class);
                String regex = annotation.regex();
                boolean access = field.isAccessible();
                field.setAccessible(true);
                String pesel = (String) field.get(customer);
                System.out.println(field + ": " + regex);
                boolean match = Pattern.matches(regex, pesel);

                String newPesel;

                if (!match) {
                    do {
                        Method method = menu.getClass().getDeclaredMethod("askQuestion", String.class, List.class);
                        method.setAccessible(true);
                        newPesel = (String) method.invoke(menu, "Enter PESEL: ", null);
                        method.setAccessible(false);
                        match = Pattern.matches(regex, newPesel);

                        if (!match) {
                            System.out.println("ON");
                        }
                    } while (!match);

                    field.set(customer, newPesel);
                    field.setAccessible(access);
                }

            }
        }

    }
}
