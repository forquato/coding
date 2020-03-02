package de.dimk.encoding;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by korb009 on 16.05.2017.
 */
public class Encoding {

    public static void encoding(){

    //String test = "hello my name is  Rücklastschrift, äöüß!\"§$%&: \"accountOwner\": \"RübnerNicole\"";
    String test = "test";
        System.out.println("String: " + test);

    byte[] testByted = test.getBytes(StandardCharsets.UTF_8);
        System.out.println("Byted: "); for(byte b:testByted) System.out.print(b);

        System.out.println("\n");

    byte[] testEncoded = Base64.encodeBase64(testByted);
        System.out.println("Byted & Encoded: "); for(byte b:testEncoded) System.out.print(b);

    System.out.println("\nDecoded: ");
    byte[] decodedBytes = Base64.decodeBase64(testEncoded); //for(byte b:decodedBytes) System.out.print(b);

    String stringDecoded = new String(decodedBytes, Charset.forName("UTF-8"));

        System.out.println(stringDecoded);

    }

}
