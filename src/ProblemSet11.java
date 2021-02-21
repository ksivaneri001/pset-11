import java.util.ArrayList;
import java.util.Arrays;

public class ProblemSet11 {

    public static void main(String[] args) {
        ProblemSet11 tester = new ProblemSet11();

        // Exercise 1
        System.out.println("Exercise 1");
        System.out.println(tester.fizzBuzz(1, 6));
        System.out.println(tester.fizzBuzz(1, 8));
        System.out.println(tester.fizzBuzz(1, 11));
        System.out.println(tester.fizzBuzz(5, 17));
        System.out.println(tester.fizzBuzz(1, 1));

        // Exercise 2
        System.out.println("\nExercise 2");
        System.out.println(tester.maxSpan(new ArrayList<>(Arrays.asList(1, 2, 1, 1, 3))));
        System.out.println(tester.maxSpan(new ArrayList<>(Arrays.asList(1, 4, 2, 1, 4, 1, 4))));
        System.out.println(tester.maxSpan(new ArrayList<>(Arrays.asList(1, 4, 2, 1, 4, 4, 4))));
        System.out.println(tester.maxSpan(null));
        System.out.println(tester.maxSpan(new ArrayList<>(Arrays.asList(1))));
        System.out.println(tester.maxSpan(new ArrayList<>()));

        // Exercise 3
        System.out.println("\nExercise 3");
        System.out.println(tester.fix34(new ArrayList<>(Arrays.asList(1, 3, 1, 4))));
        System.out.println(tester.fix34(new ArrayList<>(Arrays.asList(1, 3, 1, 4, 4, 3, 1))));
        System.out.println(tester.fix34(new ArrayList<>(Arrays.asList(3, 2, 2, 4))));
        System.out.println(tester.fix34(new ArrayList<>(Arrays.asList(4, 3, 5, 5))));
        System.out.println(tester.fix34(new ArrayList<>(Arrays.asList(3, 2, 3, 4, 5))));
        System.out.println(tester.fix34(new ArrayList<>(Arrays.asList(3, 2, 4, 5, 4, 3))));
        System.out.println(tester.fix34(new ArrayList<>(Arrays.asList(3, 4, 2, 3, 3, 5, 4, 5, 4))));
        System.out.println(tester.fix34(new ArrayList<>(Arrays.asList(2, 2, 2, 2))));
        System.out.println(tester.fix34(null));

        // Exercise 4
        System.out.println("\nExercise 4");
        System.out.println(tester.fix45(new ArrayList<>(Arrays.asList(5, 4, 9, 4, 9, 5))));
        System.out.println(tester.fix45(new ArrayList<>(Arrays.asList(1, 4, 1, 5))));
        System.out.println(tester.fix45(new ArrayList<>(Arrays.asList(1, 4, 1, 5, 5, 4, 1))));
        System.out.println(tester.fix45(new ArrayList<>(Arrays.asList(1, 5, 3, 3))));
        System.out.println(tester.fix45(new ArrayList<>(Arrays.asList(4, 2, 4, 4, 5))));
        System.out.println(tester.fix45(new ArrayList<>(Arrays.asList(3, 2, 4, 5, 5, 4))));
        System.out.println(tester.fix45(new ArrayList<>(Arrays.asList(3, 4, 2, 4, 4, 5, 5, 5, 3))));
        System.out.println(tester.fix45(new ArrayList<>(Arrays.asList(1, 3, 6, 6))));
        System.out.println(tester.fix45(null));

        // Exercise 5
        System.out.println("\nExercise 5");
        System.out.println(tester.canBalance(new ArrayList<>(Arrays.asList(1, 1, 1, 2, 1))));
        System.out.println(tester.canBalance(new ArrayList<>(Arrays.asList(2, 1, 1, 2, 1))));
        System.out.println(tester.canBalance(new ArrayList<>(Arrays.asList(10, 10))));
        System.out.println(tester.canBalance(new ArrayList<>(Arrays.asList(1))));
        System.out.println(tester.canBalance(null));
    }

    public ArrayList<String> fizzBuzz(int start, int end) {
        ArrayList<String> values = new ArrayList<>(end - start);
        for (int i = 0; i < end - start; i++) {
            String temp = "";
            if ((i + start) % 3 == 0 || (i + start) % 5 == 0) {
                if ((i + start) % 3 == 0) temp += "Fizz";
                if ((i + start) % 5 == 0) temp += "Buzz";
            }
            else temp = String.valueOf(i + start);
            values.add(temp);
        }
        return values;
    }

    public int maxSpan(ArrayList<Integer> numbers) {
        if (numbers == null) return -1;
        ArrayList<Integer> newNumbers = new ArrayList<>(numbers);
        int maxSpanLength = 0;
        for (int i = 0; i < newNumbers.size(); i++) {
            int x = newNumbers.lastIndexOf(newNumbers.get(i));
            if (x - i + 1 > maxSpanLength) maxSpanLength = x - i + 1;
        }
        return maxSpanLength;
    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {
        if (numbers == null) return null;
        ArrayList<String> newNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) newNumbers.add(String.valueOf(numbers.get(i)));
        if (newNumbers.indexOf("3") > newNumbers.indexOf("4")) return null;
        int threeCount = 0;
        int fourCount = 0;
        for (int i = 0; i < newNumbers.size(); i++) {
            if (newNumbers.get(newNumbers.size() - 1).equals("3")) return null;
            if (i != newNumbers.size() - 1 && newNumbers.get(i).equals("3") && newNumbers.get(i + 1).equals("3")) return null;
            if (newNumbers.get(i).equals("3")) threeCount++;
            if (newNumbers.get(i).equals("4")) fourCount++;
        }
        if (threeCount != fourCount) return null;
        while (threeCount > 0) {
            int x = newNumbers.indexOf("3");
            int y = newNumbers.indexOf("4");
            String z = newNumbers.get(x + 1);
            newNumbers.set(x + 1, "4");
            newNumbers.set(y, z);
            newNumbers.set(x, "x");
            newNumbers.set(x + 1, "y");
            threeCount--;
        }
        for (int i = 0; i < newNumbers.size(); i++) {
            if (newNumbers.get(i).equals("x")) newNumbers.set(i, "3");
            if (newNumbers.get(i).equals("y")) newNumbers.set(i, "4");
        }
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < newNumbers.size(); i++) output.add(Integer.parseInt(newNumbers.get(i)));
        return output;
    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {
        if (numbers == null) return null;
        ArrayList<String> newNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) newNumbers.add(String.valueOf(numbers.get(i)));
        int fourCount = 0;
        int fiveCount = 0;
        for (int i = 0; i < newNumbers.size(); i++) {
            if (newNumbers.get(newNumbers.size() - 1).equals("4")) return null;
            if (i != newNumbers.size() - 1 && newNumbers.get(i).equals("4") && newNumbers.get(i + 1).equals("4")) return null;
            if (newNumbers.get(i).equals("4")) fourCount++;
            if (newNumbers.get(i).equals("5")) fiveCount++;
        }
        if (fourCount != fiveCount) return null;
        while (fourCount > 0) {
            int x = newNumbers.indexOf("4");
            int y = newNumbers.indexOf("5");
            String z = newNumbers.get(x + 1);
            newNumbers.set(x + 1, "5");
            newNumbers.set(y, z);
            newNumbers.set(x, "x");
            newNumbers.set(x + 1, "y");
            fourCount--;
        }
        for (int i = 0; i < newNumbers.size(); i++) {
            if (newNumbers.get(i).equals("x")) newNumbers.set(i, "4");
            if (newNumbers.get(i).equals("y")) newNumbers.set(i, "5");
        }
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < newNumbers.size(); i++) output.add(Integer.parseInt(newNumbers.get(i)));
        return output;
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) return false;
        for (int i = 0; i <= numbers.size(); i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) leftSum += numbers.get(j);
            for (int k = i; k < numbers.size(); k++) rightSum += numbers.get(k);
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {
        return false;
    }

    public ArrayList<Integer> squareUp(int n) {
        return null;
    }

    public ArrayList<Integer> seriesUp(int n) {
        return null;
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        return -1;
    }

    public int countClumps(ArrayList<Integer> numbers) {
        return -1;
    }
}
