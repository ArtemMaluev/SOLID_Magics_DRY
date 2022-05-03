package maluevArtem.products;

import maluevArtem.enums.TypeProduct;

public class Television extends Product {

    private final TypeProduct TYPE_PRODUCT = TypeProduct.TELEVISION;
    private int id = 200;
    private final String diagonalScreen;

    public Television(int rating, String name, String diagonalScreen, String colour, String producingCountry, int price) {
        super(rating, name, colour, producingCountry, price);
        this.diagonalScreen = diagonalScreen;
        this.id += Product.id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public TypeProduct getTYPE_PRODUCT() {
        return TYPE_PRODUCT;
    }

    public String getDiagonalScreen() {
        return diagonalScreen;
    }

    @Override
    public String toString() {
        return "Телевизор { " +
                "рейтинг = " + super.getRating() +
                ", название = \"" + super.getName() + '\"' +
                ", диагональ экрана = " + diagonalScreen +
                ", цвет = " + super.getColour() +
                ", страна производитель = " + super.getProducingCountry() +
                ", цена = " + super.getPrice() + " р. " +
                '}';
    }
}
