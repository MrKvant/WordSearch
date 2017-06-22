package com.kazachenko.wordsearch.file;

import com.kazachenko.wordsearch.model.Words;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 6/22/2017.
 */
public class CSVFileWriter implements FileWriter{

    @Override
    public void write(File file, List<Words> wordsList) {
        PrintWriter out;
        try {
            out = new PrintWriter(new BufferedWriter(new java.io.FileWriter(file)));
            for (Words words : wordsList)
                out.println(String.join(" ", words.getWords()));
            out.close();
        } catch (IOException e) {
            System.out.println("ERROR: File not write.");
        }

    }
}
