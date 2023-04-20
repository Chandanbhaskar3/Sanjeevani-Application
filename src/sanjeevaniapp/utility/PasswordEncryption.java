/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevaniapp.utility;

import java.util.Base64;
public class PasswordEncryption {
    public static String getEncryptedPassword(String password){
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(password.getBytes());
    }
}

class test{
    public static void main(String[] args) {
      //  String s = "chandan";
        String so = "sumit";
        System.out.println(PasswordEncryption.getEncryptedPassword(so));
    }
}