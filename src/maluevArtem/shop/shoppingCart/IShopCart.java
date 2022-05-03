package maluevArtem.shop.shoppingCart;

import maluevArtem.products.Product;

import java.util.List;

public interface IShopCart {

    void addProduct(int number, List<Product> listProduct);

    void removeProduct(int number);

    void outputListProductsShoppingCart();
}
