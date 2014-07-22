package uz.micros.jstore.service.exception;

public class UsernameAlreadyInUseException extends org.hibernate.service.spi.ServiceException {
    public UsernameAlreadyInUseException(String username) {
        super("The username '" + username + "' is already in use.");
    }
}
