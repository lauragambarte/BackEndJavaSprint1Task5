package nivel1.ejercicio5;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Grey", 5);
        try {
            //Creates a file output stream to write to the file with the specified name(Person.ser)
            //serialize:take an object of a class and put into a file
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/nivel1/ejercicio5/Person.ser");
            //writing objects to the fileoutputstream above
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person1);
            objectOutputStream.flush();
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("src/main/java/nivel1/ejercicio5/Person.ser");
            //read as objects
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //take the serialized version of the object(file) and make it a new object with the same state as person1 before we serialize it.
            Person person2 = (Person) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(person1);
            System.out.println(person2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
