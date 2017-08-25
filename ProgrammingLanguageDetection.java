/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Minato
 */
public class ProgrammingLanguageDetection {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        String Java = "(((import java\\.)[a-zA-Z\\.\\*]*;)|(public static void main(.*))|(class\\s[a-zA-Z_$]+[\\s]*\\{)|(System\\.out\\.print))";
        String Python = "(class\\s[A-Z_]+[a-zA-Z_0-9]*:)|(\\sprint[^fl])";
        String C = "(\\#include\\s*<[a-z]+\\.[a-z]>)|(\\sscanf(.+);)";
        
        String text = "";
        
        while (input.hasNextLine()) {
            sb.append(input.nextLine());
            sb.append("\n");
        }
        
        text = sb.toString();
        
        Pattern pattern1 = Pattern.compile(Java);
        Pattern pattern2 = Pattern.compile(Python);
        Pattern pattern3 = Pattern.compile(C);
        
        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);
        Matcher matcher3 = pattern3.matcher(text);
        
        String output1 = "";
        String output2 = "";
        String output3 = "";
        String result = "";
        
        while (matcher1.find()) {
            output1 += matcher1.group();
            if (!output1.equals("")){
                result = "Java";
                break;
            }
        }
        
        while (matcher2.find()) {
            output2 += matcher2.group();
            if (!output2.equals("")){
                result = "Python";
                break;
            }
        }
        
        while (matcher3.find()) {
            output3 += matcher3.group();
            if (!output3.equals("")){
                result = "C";
                break;
            }
        }
        System.out.println(result);
    }

}
