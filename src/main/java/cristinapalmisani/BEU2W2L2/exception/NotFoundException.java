package cristinapalmisani.BEU2W2L2.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Elemento con id " + id + " non trovato!");
    }
}
