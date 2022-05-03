package maluevArtem.shop.warehouse;

import maluevArtem.enums.ProductFieldFilter;
import maluevArtem.enums.TypeProduct;
import maluevArtem.shop.warehouse.filterSort.FilterProductsType;
import maluevArtem.shop.warehouse.filterSort.SortValue;
import maluevArtem.shop.warehouse.filterSort.RemovalFilters;
import maluevArtem.products.*;

import java.util.*;

public class Warehouse implements IWarehouse, SortValue, FilterProductsType, RemovalFilters {

    private final Map<Integer, Product> listProductMap;
    private List<Product> listProduct;

    public Warehouse() {
        listProductMap = new HashMap<>();
        listProduct = new ArrayList<>();
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public Map<Integer, Product> getListProductMap() {
        return listProductMap;
    }

    // Добавить товар
    @Override
    public void addProduct(Product product) {
        listProduct.add(product);
        sort(listProduct);
        listProductMap.put(product.getId(), product);
    }

    // Убрать товар
    @Override
    public void removeProduct(Product product) {
        if (listProduct.isEmpty()) {
            System.out.println("На складе нет товаров!");
            return;
        }
        listProduct.remove(product);
        sort(listProduct);
        listProductMap.remove(product.getId());
    }

    // Вывести список товаров
    @Override
    public void outputListProducts() {
        if (listProduct.isEmpty()) {
            System.out.println("На складе нет товаров!");
            return;
        }
        int n = 1;
        for (Product p : listProduct) {
            System.out.println(n++ + ". " + p);
        }
        System.out.println();
    }

    // Отсортировать список товаров на складе
    public void sort(List<Product> list) {
        list.sort(Comparator.comparing(Product::getTYPE_PRODUCT).thenComparing(Product::getName)
                .thenComparing(Product::getColour).thenComparing(Product::getProducingCountry)
                .thenComparing(Product::getRating).thenComparing(Product::getPrice));
    }

    // Отфильтровать товар по типу
    @Override
    public void filterProductsType(int number) {
        if (number > TypeProduct.values().length || number <= 0) {
            System.out.println("Введено неверное значение");
            return;
        }
        for (TypeProduct type : TypeProduct.values()) {
            if (type.ordinal() == number - 1) {
                listProduct = listProduct.stream().filter(x -> x.getTYPE_PRODUCT().equals(type)).toList();
            }
        }
    }

    // Отсортировать товар по значению
    @Override
    public void filterValue(int number) {
        if (number > ProductFieldFilter.values().length || number <= 0) {
            System.out.println("Введено неверное значение");
            return;
        }
        if (ProductFieldFilter.RATING.ordinal() == number - 1) {
            listProduct.sort(Comparator.comparing(Product::getRating));
        } else if (ProductFieldFilter.NAME.ordinal() == number - 1) {
            listProduct.sort(Comparator.comparing(Product::getName));
        } else listProduct.sort(Comparator.comparing(Product::getPrice));
    }

    // Отменить фильтры
    @Override
    public void removeFilters() {
        listProduct = listProductMap.values().stream().toList();
    }
}
