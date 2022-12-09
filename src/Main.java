public class Main{
    public static void main(String[] args){
        
        ///String string = """""";

        byte[] string0 = "some sample string to make a comparison to".getBytes();

        byte[] bytes = string.getBytes();
        byte[] key = "YELLOW SUBMARINE".getBytes();
        byte[] iv = {(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, 0x00, 0x00, 0x00, 0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, 0x00, 0x00, 0x00, 0x00};
        byte[] cipherBytes = CBC.encrypt(string0, key, iv);
        byte[] decrypt0 = CBC.decrytp(cipherBytes, key, iv);
        //byte[] decryptBytes = CBC.decrytp(bytes, key, iv);
        System.out.println(new String(decrypt0));
        //System.out.println(new String(decryptBytes));
    }

}