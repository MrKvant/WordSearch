package com.kazachenko.wordsearch;

/**
 * Created by admin on 6/22/2017.
 */

/**
 * Created by admin on 6/15/2017.
 */

//Singletone class
public class Config {

    private static final String FLAG_I = "-I";
    private static final String FLAG_Q = "-Q";
    private static final String FLAG_O = "-O";

    private static Config uniqueInstance;

    private String inputFile;
    private String query;
    private String outputFile;

    public static Config createConfig(String[] args) {
        if (uniqueInstance == null) {
            uniqueInstance = new Config(args);
        }
        return uniqueInstance;
    }

    public static Config getConfig() {
        return uniqueInstance;
    }

    private Config(String[] args) {
        inputFile = null;
        query = null;
        outputFile = null;
        setFlags(args);
        checkFlags(args);
    }

    private void setFlags(String[] args) {
        try {
            boolean cond[] = new boolean[3];
            for (int i = 0; i < args.length; i++)
                switch (args[i].toUpperCase()) {
                    case FLAG_I:inputFile = args[++i];cond[0] = true;break;
                    case FLAG_Q:query = args[++i];cond[1] = true;break;
                    case FLAG_O:outputFile = args[++i];cond[2] = true;break;
                }
            if (!(cond[0] & cond[1] & cond[2])) {
                System.out.println("ERROR: Incorrect argument.");
                System.exit(0);
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR: Flag is empty.");
            System.exit(0);
        }
    }

    private void checkFlags(String[] args) {

    }

    private void checkSavingPlace(){

    }

    public String getInputFile() {
        return inputFile;
    }

    public String getQuery() {
        return query;
    }

    public String getOutputFile() {
        return outputFile;
    }
}
