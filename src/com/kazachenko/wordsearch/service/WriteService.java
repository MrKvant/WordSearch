package com.kazachenko.wordsearch.service;

import com.kazachenko.wordsearch.file.CSVFileWriter;
import com.kazachenko.wordsearch.file.FileWriter;
import com.kazachenko.wordsearch.file.TXTFileWriter;
import com.kazachenko.wordsearch.model.Words;

import java.io.File;
import java.util.List;

/**
 * Created by admin on 6/22/2017.
 */
public class WriteService {

    private static final String FILE_CSV = "csv";
    private static final String FILE_TXT = "txt";

    private static FileWriter getWriter(File file) {

        FileWriter fileWriter = null;
        String ext = getFileExtension(file.getName());

        assert ext != null;
        switch (ext) {
            case FILE_CSV:
                fileWriter = new CSVFileWriter();
                break;
            case FILE_TXT:
                fileWriter = new TXTFileWriter();
                break;
        }
        return fileWriter;
    }

    public static void write(File file, List<Words> wordsList) {
        getWriter(file).write(file, wordsList);
    }

    private static String getFileExtension(String fileName) {
        int index = fileName.indexOf('.');
        return index == -1 ? null : fileName.substring(index + 1).toLowerCase();
    }
}

