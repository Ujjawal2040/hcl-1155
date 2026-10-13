
package Exceptions;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class Checked_exceptions {

    public static void main(String[] args) {

        // 1. IOException
        try {
            FileReader fr = new FileReader("missing.txt");
            fr.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // 2. FileNotFoundException
        try {
            FileReader fr = new FileReader("abc.txt");
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException while closing file");
        }

        // 3. ClassNotFoundException
        try {
            Class.forName("UnknownClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }

        // 4. InterruptedException
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("InterruptedException");
        }

        // 5. ParseException
        try {
            SimpleDateFormat sdf =
                    new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            Date date = sdf.parse("35-13-2025");
        } catch (ParseException e) {
            System.out.println("ParseException: Invalid date");
        }

        // 6. SQLException (requires JDBC imports)
        // Usually occurs while interacting with a database.
        // Example: Connection, PreparedStatement, ResultSet.

        // 7. NoSuchMethodException
        try {
            Class<?> c = String.class;
            c.getMethod("unknownMethod");
        } catch (NoSuchMethodException e) {
            System.out.println("NoSuchMethodException");
        }

        // 8. NoSuchFieldException
        try {
            Class<?> c = String.class;
            c.getField("unknownField");
        } catch (NoSuchFieldException e) {
            System.out.println("NoSuchFieldException");
        }

        // 9. InstantiationException
        try {
            Class<?> c = AbstractExample.class;
            c.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            System.out.println("Reflection exception: " +
                    e.getClass().getSimpleName());
        }

        System.out.println("Program completed.");
    }

    abstract static class AbstractExample {
        AbstractExample() {}
    }
}
