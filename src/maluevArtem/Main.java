package maluevArtem;

import maluevArtem.enums.ProductFieldFilter;
import maluevArtem.enums.TypeProduct;
import maluevArtem.products.*;
import maluevArtem.shop.shoppingCart.ShopCart;
import maluevArtem.shop.warehouse.Warehouse;

import java.util.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Warehouse warehouse = new Warehouse();
    public static ShopCart shoppingCart = new ShopCart();

    public static void main(String[] args) {

        // Заполним товарами склад магазина
        Product phone1 = new Phone(8, "ГовориФон", "Я-15", "32", "черный", "Россия", 20000);
        Product phone2 = new Phone(9, "Sam-Go-fon", "U-2", "64", "белый", "Китай", 50000);
        Product phone3 = new Phone(5, "BlaBlaFon", "i-1", "8", "черный", "Китай", 8000);
        Product television1 = new Television(10, "GG", "40", "черный", "Корея", 82000);
        Product television2 = new Television(6, "Sas", "24", "белый", "Китай", 29000);
        Product computer1 = new Computer(9, "Len", "i-10", "12", "черный", "Китай", 120000);
        Product computer2 = new Computer(7, "Len", "i-8", "8", "красный", "Китай", 90000);

        warehouse.addProduct(computer1);
        warehouse.addProduct(phone1);
        warehouse.addProduct(phone3);
        warehouse.addProduct(television1);
        warehouse.addProduct(phone2);
        warehouse.addProduct(television2);
        warehouse.addProduct(computer2);
        //warehouse.outputListProducts();
        System.out.println();

        StoreInterface.startMenu();

        scanner.close();
    }

    // Выбор команды
    public static int inputCommands() {
        try {
            System.out.print(">> ");
            return Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Введено не верное значение!");
            return inputCommands();
        }
    }

    private static class StoreInterface {

        static int MAX_EVALUATION = 10;
        static int MIN_EVALUATION = 0;

        // Меню начала покупок
        public static void startMenu() {
            System.out.println("Добро пожаловать в онлайн-магазин!");
            System.out.println("Выберите команду: \n1. Выбрать товар \n2. Закончить покупки");
            switch (inputCommands()) {
                case 1:
                    warehouse.outputListProducts();
                    shoppingMenu();
                    break;
                case 2:
                    System.out.println("Покупки завершины");
                    break;
                default:
                    System.out.println("Такой команды нет!");
                    startMenu();
            }
        }

        // Основное меню магазина
        public static void shoppingMenu() {
            boolean flag = true;
            while (flag) {
                System.out.println("Выберите команду: \n1. Ввывести список товаров \n2. Отфильтровать и отсорировать товар " +
                        "\n3. Убрать фильтры \n4. Добавить товар в корзину \n5. Убрать товар из корзины \n6. Показать товары в корзине " +
                        "\n7. Оценить товар \n8. Оплатить товар \n9. Вернуться в стартовое меню \n10. Закончить покупки");
                switch (inputCommands()) {
                    case 1:
                        warehouse.outputListProducts();
                        break;
                    case 2: // Отфильтровать товар
                        filteringMenu();
                        break;
                    case 3: // Убрать фильтры
                        warehouse.removeFilters();
                        break;
                    case 4: // Добавить товар в корзину
                        System.out.println("Выберите номер товара, для добавления его в корзину");
                        warehouse.outputListProducts();
                        shoppingCart.addProduct(inputCommands(), warehouse.getListProduct());
                        break;
                    case 5: // Убрать товар из корзины
                        if (shoppingCart.getShoppingList().isEmpty()) {
                            System.out.println("Корзина пуста!");
                            break;
                        }
                        System.out.println("Выберите номер товара, чтобы убрать его из корзины");
                        shoppingCart.outputListProductsShoppingCart();
                        shoppingCart.removeProduct(inputCommands());
                        break;
                    case 6: // Показать товары в корзине
                        shoppingCart.outputListProductsShoppingCart();
                        break;
                    case 7: // Оценить товар
                        System.out.println("Выберите товар для оценки");
                        warehouse.outputListProducts();
                        evaluateProduct(inputCommands());
                        break;
                    case 8: // Оплатить товар
                        if (shoppingCart.getShoppingList().isEmpty()) {
                            System.out.println("Корзина пуста!");
                            break;
                        }
                        System.out.println("Товар оплачен");
                        for (Product p : shoppingCart.getShoppingList()) {
                            warehouse.removeProduct(p);
                        }
                        shoppingCart.getShoppingList().clear();
                        break;
                    case 9: // Вернуться в стартовое меню
                        startMenu();
                        flag = false;
                        break;
                    case 10: // Закончить покупки
                        System.out.println("Покупки завершины");
                        flag = false;
                        break;
                    default:
                        System.out.println("Такой команды нет!");
                }
            }
        }

        // Меню сортировки и фильтрации
        public static void filteringMenu() {
            System.out.println("Выберите команду: \n1. Отфильтровать по типу товара \n2. Отсортировать по значению");
            switch (inputCommands()) {
                case 1:
                    System.out.println("Выберите тип товара: " +
                            TypeProduct.COMPUTER.ordinal() + 1 + ". Компьютер " +
                            TypeProduct.PHONE.ordinal() + 1 + ". Телефон " +
                            TypeProduct.TELEVISION.ordinal() + 1 + ". Телевизор");
                    warehouse.filterProductsType(inputCommands());
                    break;
                case 2:
                    System.out.println("Выберите значение: " +
                            ProductFieldFilter.RATING.ordinal() + 1 + ". Рейтинг " +
                            ProductFieldFilter.NAME.ordinal() + 1 + ". Название " +
                            ProductFieldFilter.PRICE.ordinal() + 1 + ". Цена");
                    warehouse.filterValue(inputCommands());
                    break;
                default:
                    System.out.println("Такой команды нет!");
                    filteringMenu();
            }
        }

        // Оценка товара
        public static void evaluateProduct(int number) {
            System.out.println(warehouse.getListProduct().get(number - 1));
            System.out.println("Оцените товар по шкале от " + MIN_EVALUATION + " до " + MAX_EVALUATION);
            int value = inputCommands();
            if (value > MAX_EVALUATION || value < MIN_EVALUATION) {
                System.out.println("Введено неверное значение");
            } else warehouse.getListProduct().get(number - 1).setRating(value);
        }
    }
}
