import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum
{

        public static void main( String[] args )
        {
            int[] nums = { 12, 22, 7, 11, 2};
            int target = 9;
            int[] result = twoSum( nums, target );
            Arrays.stream( result ).forEach( p ->  System.out.println(p));

        }

        public static int[] twoSum( int[] nums, int target )
        {
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
    }

