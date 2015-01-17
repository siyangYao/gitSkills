package foo.validate;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component("PasswordEncryAndDecry")
public class PasswordEncryAndDecry {
	
	private MessageDigest md=null;
	
	
	public PasswordEncryAndDecry() throws NoSuchAlgorithmException{
		md=MessageDigest.getInstance("MD5");
	}
	
	public String encrypt(String password) {
		byte[] messageDigest = md.digest(password.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
	}
}
