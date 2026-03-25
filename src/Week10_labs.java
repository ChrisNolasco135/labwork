import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Week10_labs
{
    public static void main(String[] args)
    {
        List<String> fruit = Arrays.asList(
            "cherry","banana","berry","apple","cherry","kiwi","fig",
            "date","lemon","honeydew","cherry","elderberry","apple",
            "banana","grape"
        );

        // Collect elements into a Set
		
		// Using Collectors.toSet() to get unique fruits
        Set<String> fruitSet = fruit.stream()
                                   .collect(Collectors.toSet());
        System.out.println("Set: " + fruitSet);

        // Group by first character

		// Using Collectors.groupingBy to group fruits by their first character
        Map<Character, List<String>> byFirstChar =
            fruit.stream()
                 .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("Group by first char: " + byFirstChar);

        // Group by length

		// Using Collectors.groupingBy to group fruits by their length
        Map<Integer, List<String>> byLength =
            fruit.stream()
                 .collect(Collectors.groupingBy(String::length));
        System.out.println("Group by length: " + byLength);

        // Collect fruit that contains "erry"

		 // Using filter to find fruits that contain "erry" and collect them into a List
        List<String> containsErry =
            fruit.stream()
                 .filter(s -> s.contains("erry"))
                 .collect(Collectors.toList());
        System.out.println("Contains 'erry': " + containsErry);

        // Partition based on "erry"

		 // Using Collectors.partitioningBy to partition fruits based on whether they contain "erry"
        Map<Boolean, List<String>> partitionErry =
            fruit.stream()
                 .collect(Collectors.partitioningBy(s -> s.contains("erry")));
        System.out.println("Partition 'erry': " + partitionErry);

        // Fruit with length <= 5

		// Using filter to find fruits with length <= 5 and collect them into a List
        List<String> shortFruit =
            fruit.stream()
                 .filter(s -> s.length() <= 5)
                 .collect(Collectors.toList());
        System.out.println("Length <= 5: " + shortFruit);

        // Total number of characters

		// Using mapToInt to get the length of each fruit and sum them up to get the total number of characters
        int totalChars =
            fruit.stream()
                 .mapToInt(String::length)
                 .sum();
        System.out.println("Total chars: " + totalChars);


        List<Integer> data = Arrays.asList(
            87, 23, 45, 100, 6, 78, 92, 44, 13, 56, 34, 99, 82, 19,
            1012, 78, 45, 90, 23, 56, 78, 100, 3, 43, 67, 89, 21, 34, 10
        );

        // Partition >= 50

		 // Using Collectors.partitioningBy to partition integers based on whether they are greater than or equal to 50
        Map<Boolean, List<Integer>> partition50 =
            data.stream()
                .collect(Collectors.partitioningBy(x -> x >= 50));
        System.out.println("Partition >=50: " + partition50);

        // Group by remainder mod 7

		 // Using Collectors.groupingBy to group integers by their remainder when divided by 7
        Map<Integer, List<Integer>> mod7 =
            data.stream()
                .collect(Collectors.groupingBy(x -> x % 7));
        System.out.println("Mod 7 groups: " + mod7);

        // Sum of data

		 // Using mapToInt to convert Integer to int and then summing them up to get the total sum of the data
        int sum =
            data.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum: " + sum);

        // Unique values

		 // Using Collectors.toSet() to get unique integers from the data
        Set<Integer> unique =
            data.stream()
                .collect(Collectors.toSet());
        System.out.println("Unique: " + unique);

        // Cube each value

		 // Using map to cube each integer and collect the results into a List
        List<Integer> cubes =
            data.stream()
                .map(x -> x * x * x)
                .collect(Collectors.toList());
        System.out.println("Cubes: " + cubes);

        // Sum of cubes

		 // Using mapToInt to cube each integer and then summing them up to get the total sum of cubes
        int sumCubes =
            data.stream()
                .mapToInt(x -> x * x * x)
                .sum();
        System.out.println("Sum of cubes: " + sumCubes);

        // Increase each by 5

		 // Using map to add 5 to each integer and collect the results into a List
        List<Integer> plusFive =
            data.stream()
                .map(x -> x + 5)
                .collect(Collectors.toList());
        System.out.println("Plus 5: " + plusFive);

        // Cube of even values

		 // Using filter to find even integers, then map to cube them, and collect the results into a List
        List<Integer> evenCubes =
            data.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x * x)
                .collect(Collectors.toList());
        System.out.println("Even cubes: " + evenCubes);
    }
}