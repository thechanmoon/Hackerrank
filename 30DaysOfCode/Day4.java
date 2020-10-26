import java.io.*;
import java.util.*;

class Person {
    private int age;

    public Person(int initialAge) {
        // Add some more code to run some checks on initialAge
        if (initialAge < 0) {
            String statement = "Age is not valid, setting age to 0.";
            System.out.println(statement/* Insert correct print statement here */);
            this.age = 0;
        } else {
            this.age = initialAge;
        }
    }

    public void amIOld() {
        // Write code determining if this person's age is old and print the correct
        // statement:
        /*
         * Age is not valid, setting age to 0. If <13, print You are young.. If >=13 and
         * < 18, print You are a teenager.. Otherwise, print You are old..
         */
        String statement = "";
        if (this.age < 13) {
            statement = "You are young.";
        } else if (this.age < 18) {
            statement = "You are a teenager.";
        } else {
            statement = "You are old.";
        }

        System.out.println(statement/* Insert correct print statement here */);
    }

    public void yearPasses() {
        // Increment this person's age.
        this.age++;
    }
}

class Day4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int age = sc.nextInt();
            Person p = new Person(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
        sc.close();
    }
}