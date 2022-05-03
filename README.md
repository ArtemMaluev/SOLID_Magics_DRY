## Magics, DRY, SOLID

#### 1. Магические числа

Класс Main, метод filteringMenu() строки 149 - 151    
Пункты меню, будут соответствовать номерам enum, которые они описывают

#### 2. Повторения (DRY)

Класс Main строки 64, 85, 98, 107, 115, 145, 151, 158, 170    
Использование метода inputCommands() позволяет избежать повторения одного и того же кода

### SOLID

#### 1. Принцип единственной ответственности (Single Responsibility Principle)

Класс ShopCart    
Класс преднозначины для создания объекта, хранит его состояние и описывают поведение

#### 2. Принцип открытости/закрытости (Open Closed Principle)

Класс Product расширяют классы Phone, Television, Computer    
но сам класс не меняется

#### 3. Принцип замены Барбары Лисков (Liskov Substitution Principle)

Классы Phone, Television, Computer переопределяют метод toString() класса Product    
не изменяя ожидаемое поведение переопределенного метода

#### 4. Принцип разделения интерфейса (Interface Segregation Principle)

Интерфейсы FilterProductsType, SortValue, RemovalFilters позволяю реализовать фильтрацию    
и сортировку объектов в классе Warehouse. Данные функции класс может реализовывать по отдельности.

#### 5. Принцип инверсии зависимостей (Dependency Inversion Principle)

В классе Warehouse создавая список ArrayList<>() типом данных поля listProduct     
выбераем интерфейс Map<Integer, Product>





