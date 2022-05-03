package maluevArtem.shop.warehouse;

import maluevArtem.products.Product;

public interface IWarehouse {

    // Добавить товар
    void addProduct(Product product);

    // Убрать товар
    void removeProduct(Product product);

    // Вывести список товаров
    void outputListProducts();
}
