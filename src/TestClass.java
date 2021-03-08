import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

public class TestClass {
//    1. Создать класс, который может выполнять «тесты», в качестве тестов
//    выступают классы с наборами методов с аннотациями @annotations.Test. Для этого
//    у него должен быть статический метод start(), которому в качестве
//    параметра передается или объект типа Class, или имя класса. Из
//    «класса-теста» вначале должен быть запущен метод с аннотацией @annotations.BeforeSuite,
//    если такой имеется, далее запущены методы с аннотациями @annotations.Test, а по
//    завершению всех тестов – метод с аннотацией @annotations.AfterSuite. К каждому тесту
//    необходимо также добавить приоритеты (int числа от 1 до 10), в соответствии
//    с которыми будет выбираться порядок их выполнения, если приоритет
//        одинаковый, то порядок не имеет значения. Методы с аннотациями
//    @annotations.BeforeSuite и @annotations.AfterSuite должны присутствовать в единственном экземпляре,
//    иначе необходимо бросить RuntimeException при запуске «тестирования».

    @BeforeSuite
    public void initial(){
        System.out.println("init");
    }
    @AfterSuite
    public void deinitial(){
        System.out.println("destruktor");
    }

    @Test(priority = 4)
    public void test4(){
        System.out.println("4");
    }

    @Test(priority = 1)
    public void test1(){
        System.out.println("1");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("2");
    }

    @Test(priority = 3)
    public void test3(){
        System.out.println("3");
    }


}
