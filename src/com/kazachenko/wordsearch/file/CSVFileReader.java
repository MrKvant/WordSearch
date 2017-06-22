package com.kazachenko.wordsearch.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 6/13/2017.
 */

public class CSVFileReader {
    public String[][] read(File file) {
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = " ";

        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR:File not found.");
            System.exit(0);
        }

        List<String[]> list = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                String[] str = line.split(csvSplitBy);
                list.add(str);
            }
        } catch (IOException e) {
            System.out.println("ERROR: Incorrect file syntax or file damaged.");
            System.exit(0);
        }

        String arr[][] = new String[list.size()][];

        for (int i = 0; i < list.size(); i++)
                arr[i] = list.get(i);

        return arr;

    }
}
