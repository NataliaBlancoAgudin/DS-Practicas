package util;

public class UserAuthentication {

    private String[] validUsers = { "raul", "cesar", "aquilino" };

    public boolean isValid(String userName) {
        for (String user : validUsers) {
            if (user.equals(userName))
                return true;
        }
        return false;
    }
}
