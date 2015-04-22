package com.barbanyaga.androiddisplay.util.helpers.FileHelpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by barbanyaga on 20.04.2015.
 */
public class FileHelper {

    /**
     * Читает содержимое текстового файла в строку
     * @param file
     * @return
     */
    public static String readTextFile(File file) {

        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        } catch (IOException e) {
            //You'll need to add proper error handling here
        }

        return text.toString();
    }
}
