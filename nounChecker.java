java

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Noun {
    static String[] x = new String[1000];
    static String initial;
    static String tagged;
    static ArrayList<String> AlTypes = new ArrayList<>();
    static ArrayList<String> nouns = new ArrayList<>();
    static ArrayList<String> clean = new ArrayList<>();
    static ArrayList<String> clean2 = new ArrayList<>();
    static ArrayList<String> lowercase = new ArrayList<>();
    static ArrayList<String> ffinal = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        Scanner xD = new Scanner(System.in);
        getString();
        typeAssigner(initial);
        splitWords(tagged);
        nounPicker();
        cleaner();
        setLowercase();
        findDuplicate();
        stringPrinter();
        int x = xD.nextInt();

    }

    public static String getString() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter new string: ");
        initial = input.nextLine();
        return initial;
    }

    public static String typeAssigner(String al) throws IOException {
        InputStream inputStream = Noun.class.getResourceAsStream("/en-pos-maxent.bin");
        POSModel model = new POSModel(inputStream);
        POSTaggerME tagger = new POSTaggerME(model);
        WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;
        String[] tokens = whitespaceTokenizer.tokenize(al);
        String[] tags = tagger.tag(tokens);
        POSSample sample = new POSSample(tokens, tags);
        tagged = sample.toString();
        return tagged;
    }

    public static void splitWords(String f) {
        x = f.split(" ");
        Collections.addAll(AlTypes, x);
    }

    public static void nounPicker() {
        for (String y : AlTypes
        ) {
            if (y.endsWith("_NNP")) {
                nouns.add(y);
            }
            {
                if (y.endsWith("_NN")) {
                    nouns.add(y);
                }
            }
        }
    }

    public static void cleaner() {
        for (String y : nouns
        ) {
            if (y.endsWith("_NNP")) {
                clean.add(y.substring(0, y.length() - 4));
            }
            {
                if (y.endsWith("_NN")) {
                    clean.add(y.substring(0, y.length() - 3));
                }
            }
        }

        for (String a : clean
        ) {
            if (a.endsWith(".")) {
                clean2.add(a.substring(0, a.length() - 1));
            }   else if (a.endsWith(",")) {
                clean2.add(a.substring(0, a.length() - 1));
            }else {
                clean2.add(a);

            }
        }

    }

    public static void setLowercase(){
        for (String b: clean2
             ) {
            lowercase.add(b.toLowerCase());

        }
    }

    public static void findDuplicate(){
        int count = 0;
        for (int i = 0; i < lowercase.size(); i++) {
            for (int j = 0; j < ffinal.size() ; j++) {
                if ((lowercase.get(i).equals(ffinal.get(j)))){
                    count ++;
                }
            }
            if (count == 0){
                ffinal.add(lowercase.get(i));
            }
            count=0;
        }
    }
    public static void stringPrinter(){
        for (String i : ffinal
        ) {
            System.out.println(i);

        }
    }

}