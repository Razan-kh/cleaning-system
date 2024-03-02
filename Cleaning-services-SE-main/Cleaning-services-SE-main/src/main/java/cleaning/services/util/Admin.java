package cleaning.services.util; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;


public class Admin {
    private boolean isloggedin = false;
    private String passwordHash; // Hashed password
    private String userName = "Admin";
    private static final Logger logger = Logger.getLogger(Admin.class.getName());

    public Admin() {
        try {
         
            passwordHash = hashPassword("correct");
        } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
        }
    }

    public boolean checkpass(String input) throws NoSuchAlgorithmException {
      
            // Hash the input password and compare with the stored password hash
            String hashedInput = hashPassword(input);
            return(hashedInput.equals(passwordHash));
           
      
    }
 
    public boolean checkUser(String input) {
        return input.equals(userName);
    }

    public void goHomePage() {
        isloggedin = true;
    }

    public void showFailMessage() {
        isloggedin = false;

    	DB.extractedLogger();
        logger.info("The entered password was wrong. Please try again!\n");
    }

    public void setLoggedIn(boolean b) {
        isloggedin = b;
    }

    public boolean getLoggedIn() {
        return isloggedin;
    }

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedHash);
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
