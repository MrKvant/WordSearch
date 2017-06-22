package com.kazachenko.wordsearch;

import com.kazachenko.wordsearch.file.CSVFileReader;
import com.kazachenko.wordsearch.model.Words;
import com.kazachenko.wordsearch.service.WriteService;

import java.io.File;

import java.util.List;

/**
 * Hello world!
 */
public class WordSearch {
    public static void main(String[] args) {
        Config con = Config.createConfig(args);
        File inputFile = new File(con.getInputFile());
        File outputFile = new File(con.getOutputFile());
        String searchingWord = con.getQuery();
        String arr[][] = null;
        List<Words> wordsList = null;

        CSVFileReader reader = new CSVFileReader();
        Searcher sercher = new Searcher();

        //read file
        arr = reader.read(inputFile);

        //search word
        wordsList = sercher.searchWordInColumns(arr, searchingWord);

        if (wordsList.size() == 0){
            System.out.println("INFO: Word not found.");
            System.exit(0);
        } else System.out.println("INFO: Word \"" + searchingWord + "\" found.");

        //write words in file
        WriteService.write(outputFile, wordsList);

    }
}
