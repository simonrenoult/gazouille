public class Gazouilli {

    public static final int MESSAGE_MINIMUM_LENGTH = 3;

    private final String message;
    private GazouilliStatut statut;

    public Gazouilli(String message) {
        if (message.length() < MESSAGE_MINIMUM_LENGTH) {
            throw new MessageTooShortError();
        }

        this.message = message;
        this.statut = GazouilliStatut.BROUILLON;
    }

    public String getMessage() {
        return message;
    }

    public Boolean isBrouillon() {
        return this.statut.equals(GazouilliStatut.BROUILLON);
    }

    class MessageTooShortError extends IllegalArgumentException {

    }

    public enum GazouilliStatut {
        BROUILLON
    }
}
