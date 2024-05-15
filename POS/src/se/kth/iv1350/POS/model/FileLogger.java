package se.kth.iv1350.POS.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Martin Nylund
 */
public class FileLogger {

    private String filename;
    private PrintWriter w;

    public FileLogger(String filename) {
        try {
        this.filename = filename;
        File file = new File(filename);
        w = new PrintWriter(new FileWriter(this.filename), true);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void log(String string) {
        w.println(string);
    }
}
