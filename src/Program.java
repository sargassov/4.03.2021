import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Program {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class cl = TestClass.class;
        TestClass testClass = (TestClass) cl.newInstance();

        Method[] methods = cl.getDeclaredMethods();
        List<Method> listMethods = new ArrayList<>();
        Method beforeMethod = null, afterMethod = null;

        for(Method m : methods){
            if(m.isAnnotationPresent(Test.class)){
                listMethods.add(m);
            }
            else if(m.isAnnotationPresent(BeforeSuite.class)){
                beforeMethod = m;
            }
            else if(m.isAnnotationPresent(AfterSuite.class)){
                afterMethod = m;
            }
        }

        sort(listMethods);

        if(beforeMethod != null && afterMethod != null){
            beforeMethod.invoke(testClass);
            for(Method m : listMethods){
                m.invoke(testClass);
            }
            afterMethod.invoke(testClass);
        }
        else{
            throw new RuntimeException("beforeMethod of afterMethod is null");
        }
    }

    private static void sort(List<Method> aList) {
        for(int x = 0; x < aList.size() - 1; x++){
            for(int y = 0; y < aList.size() - 1 - x; y++){
                Test test1 = aList.get(y).getAnnotation(Test.class);
                Test test2 = aList.get(y + 1).getAnnotation(Test.class);
                if(test1.priority() > test2.priority()){
                    Method temp = aList.get(y);
                    aList.set(y, aList.get(y + 1));
                    aList.set(y + 1, temp);
                }
            }
        }
    }
}
