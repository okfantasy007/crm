package com.chdsxt.crm.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MD5Util{
    public static String convertToMD5(String str) {
        String s=str;
		if(s==null){
			return "";
		}else{
			String value = null;
			MessageDigest md5 = null;
			try {
					md5 = MessageDigest.getInstance("MD5");
				}catch (NoSuchAlgorithmException ex) {
					Logger.getLogger(MD5Util.class.getName()).log(Level.SEVERE, null, ex);
				}
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder();
			try {
					value = baseEncoder.encode(md5.digest(s.getBytes("utf-8")));
				} catch (Exception ex) {
					
				}
			return value;
		}
	} 
}