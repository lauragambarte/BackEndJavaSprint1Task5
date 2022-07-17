package nivel1.ejercicio2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    //static: We can run without an object
    //i create my own comparator to compare files names no matter if they are upper or lower case
    static Comparator<File> alphabeticalByFileNameComparator = (File f1, File f2) -> f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());

    public static void main(String[] args) {
       //String dir and args[0] points to the same object.
     printFilesinDirectoriesAndSubdirectories(args[0]);
    }

    public static void printFilesinDirectoriesAndSubdirectories(String dir) {
        SimpleDateFormat date= new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        //dir: is the path to the start directory. listFiles() returns array of all files and directories inside that path.
        //if dir is nivel 1 I will get ejercicio 1, ejercicio 2, ejercicio3.
        File[] files=new File(dir).listFiles();
         //converting files array into a list variable, so I can sort.
        List<File> listOfFiles=Arrays.asList(files);
        listOfFiles.sort(alphabeticalByFileNameComparator);
        //looping thru all the files in listOfFiles
        //1st dir: nivel1 array listOfFiles are ej1,ej2,ej3

        for (File file:listOfFiles) {
            System.out.println(file.getName() + " " + (file.isDirectory()?"es D":"es F")+ " su ultima modificación fue "+ date.format(file.lastModified()));
            if(file.isDirectory()){
                //ruta absoluta de un fichero=file.getAbsolutePath()
                printFilesinDirectoriesAndSubdirectories(file.getAbsolutePath());
            }
        }


    }

}

