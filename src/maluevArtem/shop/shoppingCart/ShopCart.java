package maluevArtem.shop.shoppingCart;

import maluevArtem.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShopCart implements IShopCart {

    private final List<Product> shoppingList;

    public ShopCart() {
        shoppingList = new ArrayList<>();
    }

    public List<Product> getShoppingList() {
        return shoppingList;
    }

    @Override
    public void addProduct(int number, List<Product> listProduct) {
        shoppingList.add(listProduct.get(number - 1));
        System.out.println(">> Товар добавлен в корзину");
    }

    @Override
    public void removeProduct(int number) {
        try {
            shoppingList.remove(number - 1);
            System.out.println(">> Товар удален из корзины");
        } catch (Exception e) {
            System.out.println("Товар с таким номером не найден!");
        }
    }

    @Override
    public void outputListProductsShoppingCart() {
        if (shoppingList.isEmpty()) {
            System.out.println("Корзина пуста!");
            return;
        }
        System.out.println("Товары в корзине:");
        int n = 1;
        for (Product s : shoppingList) {
            System.out.println(n++ + ". " + s);
        }
        System.out.println();
    }
}
