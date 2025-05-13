package net.salesianos.element;

public class Element {
    private String name;
    private int ranking;
    private float price;
    private int numberCigarretes;

    public Element(String name, int ranking, float price, int sizes) {
        this.name = name;
        this.ranking = ranking;
        this.price = price;
        this.numberCigarretes = sizes;
    }

    
}
