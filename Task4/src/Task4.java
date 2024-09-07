import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task4 {

    public static void main(String[] args) {

        String filename = args[0];
        List<Integer> nums = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                for (String part : parts) {
                    nums.add(Integer.parseInt(part));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }


        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);

        int totalMoves = 0;
        for (int num : nums) {
            totalMoves += Math.abs(num - median);
        }
        System.out.println(totalMoves);
    }
}
