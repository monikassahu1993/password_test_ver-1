

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.spec.PBEKeySpec;

public class Sample_New {
	
	
	private static byte[] hashPassword1(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        return md.digest();
	}

	private static byte[] hashPassword2(String password) throws NoSuchAlgorithmException {
        Random r = new Random(0);
        byte [] salt = new byte[4];
		r.nextBytes(salt);
		byte[] saltedPassword = new byte[password.length() + salt.length];
		System.arraycopy(password.getBytes(), 0, saltedPassword, 0, password.length());
		System.arraycopy(salt, 0, saltedPassword, password.length(), salt.length);
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(saltedPassword);
        return md.digest();
	}

	
	
 	private PBEKeySpec getPBEParameterSpec(String password) throws Throwable {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] saltGen = md.digest(password.getBytes());
        byte[] salt = new byte[8];
        System.arraycopy(saltGen, 0, salt, 0, 8);
        int iteration = password.toCharArray().length + 1;
        return new PBEKeySpec(password.toCharArray(), salt, iteration);
	}
 	
 	public static void main(String args[]) {
 		Random r = new Random(0);
 		System.out.println(r.nextInt());
 	}

}