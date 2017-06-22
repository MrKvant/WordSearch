package com.kazachenko.wordsearch.file;

import com.kazachenko.wordsearch.model.Words;

import java.io.File;
import java.util.List;

/**
 * Created by admin on 6/22/2017.
 */
public interface FileWriter {
    void write(File file, List<Words> wordsList);
}
