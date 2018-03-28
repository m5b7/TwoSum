import java.time.LocalDateTime;
import java.time.Duration;

        /* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1]. */


public class Solution{

    public static void main(String[] args) {

        int[] summandsToCheck = new int[100000005];

        for (int i = 0; i <= 100000003; i++) {

            summandsToCheck[i]=i;
        }

        int target = 200000003;

        // save time
        LocalDateTime startTime = LocalDateTime.now();

        System.out.println(identifySummands(summandsToCheck, target)[0]);
        System.out.println(identifySummands(summandsToCheck, target)[1]);

        // print time difference
        System.out.println("Duration " + Duration.between(startTime, LocalDateTime.now()).toMillis());
    }


    public static int[] identifySummands(int[] nums, int target) {

        // I assume nums is a sorted array. Otherwise I would sort it first. //

        int i = 1;
        int k = 0;

        while (i <= nums.length && nums[i] <= target) {

            while (k < i) {
                if (nums[i] + nums[k] >=  target /* faster than "==" */) {      // ToDo: Compare time effort with "==" here
                    break;
                }
                k++;
            }
            if (nums[i] + nums[k] == target) {
                break;
            }

            i++;
        }

        int[] solution = {k, i};

        return solution;
    }
}