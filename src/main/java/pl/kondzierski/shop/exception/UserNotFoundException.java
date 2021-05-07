package pl.kondzierski.shop.exception;

public class UserNotFoundException extends Exception{

    private String message;

    public static UserNotFoundException createException(String message){
        return new UserNotFoundException(message);
    }

    private UserNotFoundException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
