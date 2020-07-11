package baeck7568;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Baeck7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Person> personList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            Person person = new Person(x, y);
            personList.add(person);
        }

        List<String> result = solve(personList);

        System.out.println(String.join(" ", result));
    }

    private static List<String> solve(List<Person> personList) {
        List<String> result = new ArrayList<>();

        for(Person person : personList) {
            int rank = 1;
            int weight = person.weight;
            int height = person.height;

            for(Person otherPerson : personList) {
                int otherWeight = otherPerson.weight;
                int otherHeight = otherPerson.height;

                if(otherHeight > height && otherWeight > weight) rank++;
            }

            result.add(String.valueOf(rank));
        }

        return result;
    }

    static class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
