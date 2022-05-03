package maluevArtem.shop.warehouse.filterSort;

@FunctionalInterface
public interface SortValue {

    // Отфильтровать товар по возрастанию рейтинга
    void filterValue(int number);
}
