package javaModule.file;


import java.io.*;

/**
 * Created by dell on 2017/5/4.
 */
public class FileUtils {

    public static BufferedReader getReader(String name) {
        try {
            InputStream in = new FileInputStream(new File(name));
            return new BufferedReader(new InputStreamReader(in, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
