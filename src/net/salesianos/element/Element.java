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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberCigarretes() {
        return numberCigarretes;
    }

    public void setNumberCigarretes(int numberCigarretes) {
        this.numberCigarretes = numberCigarretes;
    }

    @Override
    public String toString(){
        String textToConsole = "";
        textToConsole += "---------------------------------------\n";
        textToConsole += "- Nombre:" + name;
        textToConsole += "\n- Ranking: " + ranking;
        textToConsole += "\n- Precio: " + price;
        textToConsole += "\n- "
    }
    
}
