import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum
{
    public static void main( String[] args )
    {
        int[] nums = { 8, 22, 7, 11, 2};
        int target = 9;
        int[] result = twoSum1( nums, target );
        Arrays.stream( result ).forEach( p ->  System.out.println(p));

    }

    // Time complexity - O(n*2) since two loops
    // space - O(n) saves n elements in map
    public static int[] twoSum1( int[] nums, int target )
    {
        int[] result = new int[2];
        for( int i = 0; i < nums.length; i++ )
        {
            for( int j = i + 1; j < nums.length; j++ )
            {
                if(nums[i] + nums[j] == target)
                {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    // Time complexity - O(n) since two loops
    // space - O(n) saves n elements in map
    public static int[] twoSum2( int[] nums, int target )
    {
        Map<Integer, Integer> map = new HashMap<>();
        for( int i = 0; i < nums.length; i++ )
        {
            int complement = target - nums[i];
            if(map.containsKey( Integer.valueOf( complement ) ))
            {
                return new int[] {map.get(  Integer.valueOf( complement ) ), i};
            }
            map.put( nums[i], i );
        }
       return new int[2];
    }
}
