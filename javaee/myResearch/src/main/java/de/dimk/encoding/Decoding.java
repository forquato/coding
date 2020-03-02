package de.dimk.encoding;

import org.apache.commons.codec.binary.Base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * Created by KORB009 on 07.06.2017.
 */
public class Decoding {

    public static byte[] decodingFromString(String encoded) {

        byte[] bytedString = encoded.getBytes(StandardCharsets.UTF_8);
        return Base64.decodeBase64(bytedString);

    }

    private String getHash(String filename) throws IOException {

        String readThis = new String();

        try (FileInputStream fis = new FileInputStream(filename)) {
            readThis += fis.toString();

        }

        // here byte[] data is needed, not an inpit stream
        String md5Hash = org.apache.commons.codec.digest.DigestUtils.md5Hex(new byte[0]);

        return md5Hash;
    }




}
