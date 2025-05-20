package net.salesianos.element;

import net.salesianos.utils.Validation;

public class Tobacco implements Validation{
    private String name;
    private int ranking;
    private float price;
    private int numberCigarretes;

    public Tobacco(String name, int ranking, float price, int sizes) {
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
    public boolean validateName(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    @Override
    public boolean validateRanking(String rankingTexto) {
        try {
            int r = Integer.parseInt(rankingTexto.trim());
            return r >= 0 && r <= 10; // ejemplo de rango
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean validatePrice(String precioTexto) {
        try {
            float p = Float.parseFloat(precioTexto.trim());
            return p > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean validateSize(String tamanioTexto) {
        try {
            int t = Integer.parseInt(tamanioTexto.trim());
            return t > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString(){
        String textToConsole = "";
        textToConsole += "---------------------------------------\n";
        textToConsole += "- Nombre:" + name;
        textToConsole += "\n- Ranking: " + ranking;
        textToConsole += "\n- Precio: " + price;
        textToConsole += "\n- Numero de cigarrillos: " + numberCigarretes;
        return textToConsole;
    }    
}
