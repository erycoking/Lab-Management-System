package main;

import org.mindrot.jbcrypt.BCrypt;

public class Utility {

    public String hashpwd(String pwd){
        return BCrypt.hashpw(pwd, BCrypt.gensalt());
    }

    public boolean verifyPasswd(String userpwd, String storedpwd){
        if (BCrypt.checkpw(userpwd, storedpwd)){
            return true;
        }
        return false;
    }
}
