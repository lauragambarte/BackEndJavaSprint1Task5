package nivel1.ejercicio1;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    //static: i can run without an object
    public static void main(String[] args) {
     /*   System.out.println("hello world");
        for (String argument : args) {
            System.out.println("hello " + argument);
        }*/
        //String dir and args[0] points to the same object.
        List<String> files=listFilesUsingJavaIO(args[0]);
        //i create my own comparator to compare strings no matter if they are upper or lower case
        Comparator<String> alphabeticalComparator=(String s1, String s2)->s1.toLowerCase().compareTo(s2.toLowerCase());
        //METHOD THAT DOES THE SORTING BASED ON A COMPARATOR, otherwise will take its natural sort.1st Mayus,2nd minus
        // We can only sort LIst, not sets, because those are not ordered by definition.
        Collections.sort(files,alphabeticalComparator);
        for (String file:files) {
            System.out.println(file);
        }

    }
    public static List<String> listFilesUsingJavaIO(String dir) {
            return Stream.of(new File(dir).listFiles())
                    //.map: File->getName(for each File)
                    .map(File::getName)
                    .collect(Collectors.toList());
        }

    }

