package cn.com.superv.util;

public class MultiUtil {
	/**  
	 * Convert hex string to byte[]  
	 * @param hexString the hex string  
	 * @return byte[]  
	 */  
	public static byte[] hexStringToBytes(String hexString) {   
	    if (hexString == null || hexString.equals("")) {   
	        return null;   
	    }   
	    hexString = hexString.toUpperCase();   
	    int length = hexString.length() / 2;   
	    char[] hexChars = hexString.toCharArray();   
	    byte[] d = new byte[length];   
	    for (int i = 0; i < length; i++) {   
	        int pos = i * 2;   
	        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));   
	    }   
	    return d;   
	}
	
	/**  
	 * Convert char to byte  
	 * @param c char  
	 * @return byte  
	 */  
	 private static byte charToByte(char c) {   
	    return (byte) "0123456789ABCDEF".indexOf(c);   
	 }
	 
	 /**
	  * convert byte[] to hexString
	  * @param  byte[]
	  * @return hexString
	  */
	 public static String getByteString( byte[] buff_out )
		{
			StringBuffer strBuf = new StringBuffer(buff_out.length * 3);
			strBuf.append("Length[");
			strBuf.append(buff_out.length);
			strBuf.append("];Content[");
			for ( int i = 0 ; i < buff_out.length ; ++i ) {
				int l = buff_out[i] & 0x0F;
				int h = (buff_out[i] & 0xF0) >> 4;

				char ll = (char) (l > 9 ? 'a' + l - 10 : '0' + l);
				char hh = (char) (h > 9 ? 'a' + h - 10 : '0' + h);

				strBuf.append(hh);
				strBuf.append(ll);
				strBuf.append(" ");
			}
			strBuf.append("]");
			return strBuf.toString().toUpperCase();
		}
}
