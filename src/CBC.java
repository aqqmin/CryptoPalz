import java.util.Arrays;

/*
 * 
 * 
Implement CBC mode

CBC mode is a block cipher mode that allows us to encrypt irregularly-sized messages, despite the fact that a block cipher natively only transforms individual blocks.

In CBC mode, each ciphertext block is added to the next plaintext block before the next call to the cipher core.

The first plaintext block, which has no associated previous ciphertext block, is added to a "fake 0th ciphertext block" called the initialization vector, or IV.

Implement CBC mode by hand by taking the ECB function you wrote earlier, making it encrypt instead of decrypt (verify this by decrypting whatever you encrypt to test), and using your XOR function from the previous exercise to combine them.

The file here is intelligible (somewhat) when CBC decrypted against "YELLOW SUBMARINE" with an IV of all ASCII 0 (\x00\x00\x00 &c)
Don't cheat.

Do not use OpenSSL's CBC code to do CBC mode, even to verify your results. What's the point of even doing this stuff if you aren't going to learn from it?

 */

public class CBC {
    public static byte[] encrypt(byte[] bytes, byte[] key, byte[] iv){
        if(bytes.length>= key.length && iv.length == key.length){
            byte[] retBytes = new byte[bytes.length];
            int i = 0;
            byte[] myIv = Arrays.copyOf(iv, iv.length);
            while(i<bytes.length){
                
                for(int j = 0; j<key.length;j++){
                    
                    //System.out.println("encrypting " + (char)bytes[i]);
                    retBytes[i] = (byte) ((bytes[i]^key[j])^myIv[j]);
                    //System.out.println(" to  " + (char)retBytes[i]);
                    myIv[j]=retBytes[i];
                    //System.out.println(new String(myIv));
                    i++;
                    if(i==bytes.length){break;}
                }
            }
            return retBytes;
        }
        return new byte[1];
    }

    public static byte[] decrytp(byte[] bytes, byte[] key, byte[] iv){
            byte[] retBytes = new byte[bytes.length];
            int i = bytes.length-1;
            //System.out.println("trying");
            while(i>0){
                for(int j = key.length -1; j>=0; j--){
                    if(i==bytes.length-1 && bytes.length%key.length!=0){
                        j = bytes.length%key.length-1;
                    }
                    if(i>key.length-1){
                        System.out.println(iv.length-1);
                        System.out.println(i);

                        retBytes[i] = (byte) (bytes[i]^key[j]^bytes[i-key.length]);
                        i--;
                    }
                    else if(i<=iv.length-1){
                       // System.out.println("trying");
                        //System.out.println(i);
                        retBytes[i] = (byte) (bytes[i]^key[j]^iv[i]);
                        i--;
                        if(i<0){break;}
                    }    

                }
            }
            return retBytes;

    }     
        
    
}
