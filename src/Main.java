import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by deepdoradla on 07/03/2016.
 */
public class Main {

    public static void main(String args[])
    {

        String filePath = "/Users/deepdoradla/Documents/Cloudwick/SearchText/plainText.txt";
        int count = 10;

        int wordCount = 0;
        int wordCountWithMatcher = 0;
        String newLine = "Hello, how are you the 123";
        String regex = "\\bthe\\b";
        FileReader reader = null;

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(newLine);

        if(matcher.find())
            System.out.println("Matched");
        else
            System.out.println("Did not match");

        /*if(match.find(123))
            System.out.print("Got the match");
        else
            System.out.print("Did not get the match");*/


        try {
            //Scanner fileData = new Scanner(new FileReader(filePath));
            reader = new FileReader(filePath);
            BufferedReader bReader = new BufferedReader(reader);
            String line;
            try {
                while((line = bReader.readLine()) != null)
                {
                    String[] str = line.split(" ");

                    int length = str.length;

                    for(int i=0; i<length; i++)
                    {
                        //Clean the data
                        String word = str[i];
                        Boolean strExists = word.matches("\\bthe\\b");

                        if(strExists)
                            wordCount++;

                        //Now with Pattern and Matcher classes
                        Matcher matcher1 = pattern.matcher(word);
                        if(matcher1.find())
                            wordCountWithMatcher++;
                    }
                }

                System.out.println("Word count for word the using matches method is " + wordCount);
                System.out.println("Word count for word the using pattern and matcher is " + wordCountWithMatcher);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //System.out.print(wordCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
