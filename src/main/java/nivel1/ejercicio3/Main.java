package nivel1.ejercicio3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    static Comparator<File> alphabeticalByFileNameComparator = (File f1, File f2) -> f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());

    //static: i can run without an object
    public static void main(String[] args) {
        //String dir and args[0] points to the same object.
        printFilesinDirectoriesAndSubdirectories(args[0]);
    }

    public static void printFilesinDirectoriesAndSubdirectories(String dir) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        //listFiles() returns array of files and directories inside dir
        File[] files = new File(dir).listFiles();
        //converting files array into a list variable
        List<File> listOfFiles = Arrays.asList(files);
        listOfFiles.sort(alphabeticalByFileNameComparator);
        //looping thru all the files in listOfFiles
        for (File file : listOfFiles) {
            String toWrite = file.getName() + " " + (file.isDirectory() ? "es D" : "es F") + " su ultima modificación fue " + date.format(file.lastModified()) + "\n";
            writeToTxt(toWrite);
            if (file.isDirectory()) {
                printFilesinDirectoriesAndSubdirectories(file.getAbsolutePath());
            }
        }
    }

    public static void writeToTxt(String toWrite) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/nivel1/ejercicio3/output.txt", true));
            writer.write(toWrite);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
