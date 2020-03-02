package de.dimk.encoding;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by KORB009 on 07.06.2017.
 */
public class generateDecodedPDFFile {

    public  static void main(String args[]) throws IOException {

        generateDecodedPDFFile fileOps = new generateDecodedPDFFile();

        // decode a Base64 encoded String
        String pdfFileLatin1 = fileOps.readSmallTextFile("pdflatin1.txt", StandardCharsets.UTF_8).get(0);
        String pdfFileUTF8 = fileOps.readSmallTextFile("pdfUTF8.txt", StandardCharsets.UTF_8).get(0);
        String testCase = fileOps.readSmallTextFile("acc-Test", StandardCharsets.UTF_8).get(0);


        byte[] decodedPdfBytes = Decoding.decodingFromString(pdfFileLatin1);
        String decodedString = new String(decodedPdfBytes, StandardCharsets.ISO_8859_1);


        // ISO88591
        File file = new File("C:\\test\\OUTPUT-PDF-ISO-88591.pdf");
        FileOutputStream out = new FileOutputStream(file);
        try (BufferedOutputStream writer = new BufferedOutputStream(out)) {
            writer.write(decodedString.getBytes(StandardCharsets.ISO_8859_1));
        }

        // UTF-8
        File fileUtf8 = new File("C:\\test\\OUTPUT-PDF-UTF8.pdf");
        FileOutputStream outUtf8 = new FileOutputStream(fileUtf8);
        BufferedOutputStream writerUtf8 = new BufferedOutputStream(outUtf8);
        writerUtf8.write(decodedString.getBytes(StandardCharsets.UTF_8));


        //writer.write(decodedString.getBytes(Charset.forName("UTF-8")));


    }

    // reads all Lines of File into a List of String
    List<String> readSmallTextFile(String aFileName, Charset ENCODING) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String fileName = classLoader.getResource(aFileName).getFile();
        File file = new File(fileName);
        String absPath = file.getAbsolutePath();
        Path path = Paths.get(absPath);
        return Files.readAllLines(path, ENCODING);
    }



    // to be refactored!!
    byte[] getBtesFromFile(String aFileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String fileName = classLoader.getResource(aFileName).getFile();
        File file = new File(fileName);
        String absPath = file.getAbsolutePath();
        Path path = Paths.get(absPath);
        byte[] fileBytes = Files.readAllBytes(path);




       // byte[] data = Files.readAllBytes(path);
       // /C:/eclipse-workspaces/intJProjects/myResearch/target/classes/pdflatin1.txt

        //String fileNam = classLoader.getResource(aFileName).getFile();
        //byte[] fila = fileNam.getBytes(StandardCharsets.UTF_8);




       // byte[] filebtes = fileName.getBytes(ENCODING);
        return fileBytes;
    }


    //InputStream fileNam = classLoader.getResourceAsStream(aFileName);

}
