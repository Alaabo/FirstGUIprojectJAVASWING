package BACKEND;

import UI.reg;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hashing {

    public static String doshing(String password){


        try {
            MessageDigest md = MessageDigest.getInstance("sha256");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
                    for(byte b : digest){
                        sb.append(String.format("%02x",b));
                    }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        return "";

    }

    public static void main(String[] args) {
        System.out.println(doshing("example"));
    }
    }


