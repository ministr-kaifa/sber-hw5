Домашнее задание №5

Ответить на вопросы:

1. Почему на любом объекте можем вызвать метод getClas()?

    Метод определен в классе Object, необходим для динамического получения объекта Class

1. Почему на любом классе можем вызвать .class?

    "Поле" class создается для каждого класса/интерфейса/примитива jvm, необходим для статического получения конкретного объекта Class

1. В чём отличие динамического прокси от статического?

    Прокси - паттерн с помощью которого мы можем добавить или поменять функционал сущности не меняя непосредственно его.
    ```java
      public interface Service {
        public Data getData();
      }

      public class RealService implements Service {
        public Data getData() {
          return new Data();
        }
      }

      public class ProxyService implements Service {
        private final RealService service;
        public Data getData() {
          //место для кода
          var data = service.getData();
          //место для кода
          return data;
        }
      }
    ```
    Это нагляднейший пример статического прокси. Мы вручную описываем класс прокси для другого конкретного класса. Это не самый распостраненный вид паттерна, чаще используют динамический: когда описывают колбек которому передается joinpoint для понимания контекста вызова. Далее любой другой объект можно завернуть в такой прокси и при каждом обращении к объекту попадать в описанный колбек. Реализовано через рефлексию и кодогенерацию.

1. Приведите преимущества и недостатки.

    Для общих задач статический прокси очень плохо применяется потому что для каждого класса нужно будет создавать отдельный класс(для логирования или транзакций нам придется создать неоправданно много классов из за чего в проекте невозможно будет ориентироваться). Динамический подойдет лучше для общих задач в виду диаметрально другого колличества кода. Мы пишем 1 общий класс с колбеком а не для каждого класса отдельный класс с отдельной логикой. Но за это мы немного жертвуем производительностью. Другой вопрос, что для очень узких задач, где вполне можно обойтись и статическим прокси.