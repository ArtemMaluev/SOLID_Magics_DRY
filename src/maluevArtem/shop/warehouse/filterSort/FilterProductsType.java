package maluevArtem.shop.warehouse.filterSort;

@FunctionalInterface
public interface FilterProductsType {

    // Отфильтровать товар по типу
    void filterProductsType(int number);
}
