package com.barbanyaga.androiddisplay;

import java.io.File;
import java.io.IOException;

/**
 * Created by barbanyaga on 15.04.2015.
 */
public class AppConfig {
    public static String defaultPath = "/sdcard/MultimediaBroadcast";

    public static void createDefaultAppDir() throws IOException {
        File file = new File(defaultPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
