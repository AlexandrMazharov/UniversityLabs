package app.exception;

public class ItemNotFoundException extends Exception {
    private Integer role_id;

    public ItemNotFoundException(Long role_id) {
        super(String.format("Book is not found with id : '%s'", role_id));
    }
}
