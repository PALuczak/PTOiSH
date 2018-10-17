package pl.p.lodz.dmcs.ptoish;

import java.io.*;
import java.time.Instant;
import java.util.Date;

public class Exercise11 {
    public static void main(String[] args) {
        Person person = new Person("Jan", "Kowalski", Date.from(Instant.now()), 18);
        serializeExercise("Exercise11.ser", person);
        externalizeExercise("Exercise11.ext", person);
    }

    private static void externalizeExercise( String filename, Person person) {
        try (FileOutputStream fileOut = new FileOutputStream(filename)) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                person.writeExternal(out);
            }
            System.out.println("Person externalized");
        } catch (IOException i) {
            i.printStackTrace();
        }
        try (FileInputStream fileIn = new FileInputStream(filename)) {
            Person newPerson = new Person();
            try (ObjectInputStream in = new ObjectInputStream(fileIn)) {
                 newPerson.readExternal(in);
            }
            System.out.println("Person deexternalized");
            System.out.println(newPerson.getName());
            System.out.println(newPerson.getSurname());
            System.out.println(newPerson.getBirthday());
            System.out.println(newPerson.getAge());
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }
    }

    private static void serializeExercise(String filename, Person person) {
        try (FileOutputStream fileOut = new FileOutputStream(filename)) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(person);
            }
            System.out.println("Person serialized");
        } catch (IOException i) {
            i.printStackTrace();
        }
        Person newPerson = null;
        try (FileInputStream fileIn = new FileInputStream(filename)) {
            try (ObjectInputStream in = new ObjectInputStream(fileIn)) {
                newPerson = (Person) in.readObject();
            }
            System.out.println("Person deserialized");
            System.out.println(newPerson.getName());
            System.out.println(newPerson.getSurname());
            System.out.println(newPerson.getBirthday());
            System.out.println(newPerson.getAge());
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }
    }
}
