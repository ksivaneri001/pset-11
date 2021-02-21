import java.util.ArrayList;

public class ProblemSet11 {
    public static void main(String[] args) {

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
        if (outer == null || inner == null || outer.size() == 0 || inner.size() == 0) return false;
        for (int i = 0; i < outer.size() - 1; i++) if (outer.get(i + 1) < outer.get(i)) return false;
        for (int i = 0; i < inner.size() - 1; i++) if (inner.get(i + 1) < inner.get(i)) return false;
        for (int i = 0; i < inner.size(); i++) {
            boolean appears = false;
            for (int j = 0; j < outer.size(); j++) if (outer.get(j).equals(inner.get(i))) appears = true;
            if (!appears) return false;
        }
        return true;
    }

    public ArrayList<Integer> squareUp(int n) {
        if (n < 0) return null;
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                int x = (j >= i - 1) ? n - j : 0;
                values.add(x);
            }
        }
        return values;
    }

    public ArrayList<Integer> seriesUp(int n) {
        if (n < 0) return null;
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                values.add(j);
            }
        }
        return values;
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        if (numbers == null) return -1;
        int largest = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = numbers.size() - 1; j >= 0; j--) {
                int size = 0;
                int x = i;
                int y = j;
                while (x < numbers.size() && y >= 0 && numbers.get(x) == numbers.get(y)) {
                    size++;
                    x++;
                    y--;
                }
                largest = Math.max(largest, size);
            }
        }
        return largest;
    }

    public int countClumps(ArrayList<Integer> numbers) {
        if (numbers == null) return -1;
        int clumps = 0;
        int consecutive = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i + 1).equals(numbers.get(i))) consecutive++;
            else if (consecutive > 0) {
                consecutive = 0;
                clumps++;
            }
        }
        if (consecutive > 0) clumps++;
        return clumps;
    }
}
