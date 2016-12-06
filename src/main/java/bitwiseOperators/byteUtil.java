package bitwiseOperators;

import java.nio.ByteBuffer;

public class byteUtil {
	
	byte[] token = {-76,-37,10,-119,-1,-42,127,-14,11,-49,41,-29,43,9,100,104,-33,108,29,18,85,-101,108,-107,-62,-101,56,111,-70,30,-99,-46,-20,40,-13,-38,-49,94,57,95,68,-106,89,-82,96,72,-48,45,-24,51,88,-20,-127,45,-79,-1,30,-107,57,104,-61,99,-33,25,-109,6,-36,8,-97,-84,-5,25,-67,108,-114,17,111,-93,-30,-28};
	byte[] encryptionKey = {-36,-91,71,4,-120,112,-90,112,66,-109,10,-6,-9,-46,26,-101};
	byte[] iv = {1};
	private static byte[] src = {0,0,0,32,54,69,55,54,67,54,70,51,50,68,55,57,68,53,67,49,68,65,54,68,56,67,57,49,50,51,48,53,51,53,65,49,19,86,-91,-38,62,113,118,64,0,0,0,24,47,112,97,115,115,119,111,114,100,47,118,101,114,105,102,121,47,97,112,112,108,101,105,100};
								 
	public static void main(String[] args) {
		int length = intFromBytes(src, 0);
		System.out.println(longFromBytes(src, length+4));
	}
	
    public static int intFromBytes(byte[] src, int readPos) {
        return src[readPos++] << 24 |
                (src[readPos++] & 0xFF) << 16 |
                (src[readPos++] & 0xFF) << 8 |
                (src[readPos++] & 0xFF);
    }
    
    public static long longFromBytes(byte[] src, int readPos) {
    	return (src[readPos++] & 0xFFL) << 56 |
                (src[readPos++] & 0xFFL) << 48 |
                (src[readPos++] & 0xFFL) << 40 |
                (src[readPos++] & 0xFFL) << 32 |
                (src[readPos++] & 0xFFL) << 24 |
                (src[readPos++] & 0xFFL) << 16 |
                (src[readPos++] & 0xFFL) << 8 |
                (src[readPos++] & 0xFFL);
    }
    
    public static long toLong(byte[] b) {
        ByteBuffer bb = ByteBuffer.allocate(b.length);
        bb.put(b);
        return bb.getLong();
    }
    
    //check what is the output of this
    public static final long toLong (byte[] byteArray, int offset, int len)
    {
       long val = 0;
       len = Math.min(len, 8);
       for (int i = (len - 1); i >= 0; i--)
       {
          val <<= 8;
          val |= (byteArray [offset + i] & 0x00FF);
       }
       return val;
    }
    
 

}
