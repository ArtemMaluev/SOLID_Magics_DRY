package maluevArtem.products;

import maluevArtem.enums.TypeProduct;

public abstract class Product implements ITypeProduct {

    protected static int id;
    protected int rating;
    private  String name;
    private  String colour;
    private  String producingCountry;
    private  int price;

    protected Product() {}

    protected Product(int rating, String name, String colour, String producingCountry, int price) {
        this.rating = rating;
        this.name = name;
        this.colour = colour;
        this.producingCountry = producingCountry;
        this.price = price;
        ++id;
    }

    @Override
    public abstract TypeProduct getTYPE_PRODUCT();

    public int getId() { return id; }

    public void setRating(int value) {
        if (rating != 0) {
            this.rating = (rating + value) / 2;
        } else this.rating = value;
        System.out.println("Спасибо за оценку!");
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Телефон { " +
                "рейтинг = " + rating +
                ", название = \"" + name + '\"' +
                ", цвет = " + colour +
                ", страна производитель = " + producingCountry +
                ", цена = " + price + " р. " +
                '}';
    }
}
