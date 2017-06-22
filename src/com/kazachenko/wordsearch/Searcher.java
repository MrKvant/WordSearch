package com.kazachenko.wordsearch;

import com.kazachenko.wordsearch.model.Words;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by admin on 6/22/2017.
 */
public class Searcher {
    public List<Words> searchWordInColumns(String arr[][], String word) {

        String invertArr[][] = invertArray(arr);
        List<Words> wordsList = new ArrayList<>();
        try {
        Pattern p = Pattern.compile(word);
        Matcher m;
        
            for (int i = 0; i < invertArr.length; i++)
                for (int j = 0; j < invertArr[i].length; j++) {
                    m = p.matcher(invertArr[i][j]);
                    if (m.matches()) {
                        wordsList.add(new Words(invertArr[i]));
                        break;
                    }
                }
        }catch (PatternSyntaxException e){
            System.out.println("ERROR: Wrong pattern syntax.");
        }
        return wordsList;
    }

    private String[][] invertArray(String[][] arr) {

        String invertArr[][] = new String[getSizeLongestColumn(arr)][arr.length];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                invertArr[j][i] = arr[i][j];

        removeNullValue(invertArr);

        return invertArr;
    }

    private int getSizeLongestColumn(String[][] arr) {
        int sizeLongestColumn = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i].length > sizeLongestColumn)
                sizeLongestColumn = arr[i].length;
        return sizeLongestColumn;
    }

    private void removeNullValue(String arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            ArrayList<String> list = new ArrayList<String>();
            for (String s : arr[i])
                if (!(s == null))
                    list.add(s);
            arr[i] = list.toArray(new String[list.size()]);
        }

    }
}
