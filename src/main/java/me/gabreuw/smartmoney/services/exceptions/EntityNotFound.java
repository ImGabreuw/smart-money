package me.gabreuw.smartmoney.services.exceptions;

public class EntityNotFound extends RuntimeException {
    public EntityNotFound(Long id) {
        super("Não foi possível achar uma entidade com o ID: " + id + ".");
    }
}
