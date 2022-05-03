package maluevArtem.products;

import maluevArtem.enums.TypeProduct;

public class Computer extends Product {

    private final TypeProduct TYPE_PRODUCT = TypeProduct.COMPUTER;
    private int id = 300;
    private final String core;
    private final String memory;

    public Computer(int rating, String name, String core, String memory, String colour, String producingCountry, int price) {
        super(rating, name, colour, producingCountry, price);
        this.core = core;
        this.memory = memory;
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

    public String getCore() {
        return core;
    }

    public String getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return "Компьютер { " +
                "рейтинг = " + super.getRating() +
                ", название = \"" + super.getName() + '\"' +
                ", ядро = " + core +
                ", память = " + memory + " ГБ" +
                ", цвет = " + super.getColour() +
                ", страна производитель = " + super.getProducingCountry() +
                ", цена = " + super.getPrice() + " р. " +
                '}';
    }
}
