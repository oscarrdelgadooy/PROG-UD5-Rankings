package net.salesianos.utils;

public interface Validation {
    boolean validateName(String nombre);
    boolean validateRanking(String rankingTexto);
    boolean validatePrice(String precioTexto);
    boolean validateSize(String tamanioTexto);
}
