package com.kazachenko.wordsearch.file;

import com.kazachenko.wordsearch.model.Words;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 6/22/2017.
 */
public class TXTFileWriter implements FileWriter{
    @Override
    public void write(File file, List<Words> wordsList) {
        PrintWriter out;
        try {
            out = new PrintWriter(new BufferedWriter(new java.io.FileWriter(file)));
            for (Words w : wordsList) {
                String arr[] = w.getWords();
                for (int i = 0; i < arr.length; i++)
                    out.println(arr[i]);
            }
            out.close();
        } catch (IOException e) {
            System.out.println("ERROR: File not write.");
        }

    }
}
