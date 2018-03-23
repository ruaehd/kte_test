package com.kte.mvc.func;

import java.security.MessageDigest;

public class Function {
	public static String getEncSHA256(String txt) throws Exception{
	    StringBuffer sbuf = new StringBuffer();
	     
	    MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
	    mDigest.update(txt.getBytes());
	     
	    byte[] msgStr = mDigest.digest() ;
	     
	    for(int i=0; i < msgStr.length; i++){
	        byte tmpStrByte = msgStr[i];
	        String tmpEncTxt = Integer.toString((tmpStrByte & 0xff) + 0x100, 16).substring(1);
	        sbuf.append(tmpEncTxt) ;
	    }
	    
	    String tmp = sbuf.toString();
	    System.out.println("A - "+tmp);
	    tmp = tmp.charAt(tmp.length()-1) + tmp.substring(0, tmp.length()-1);
	    tmp = tmp.charAt(tmp.length()-1) + tmp.substring(0, tmp.length()-1);
	    tmp = tmp.charAt(tmp.length()-1) + tmp.substring(0, tmp.length()-1);
	    System.out.println("B - "+tmp);
	    return sbuf.toString();
	}
}
