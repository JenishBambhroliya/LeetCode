
//====================================================================(Leetcode solution start)====================================================================================================

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || 
                        (rating[i] > rating[j] && rating[j] > rating[k])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

//====================================================================(Leetcode solution end)====================================================================================================

  
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] rating1 = {2, 5, 3, 4, 1};
        System.out.println(solution.numTeams(rating1)); // Output: 3

        int[] rating2 = {2, 1, 3};
        System.out.println(solution.numTeams(rating2)); // Output: 0

        int[] rating3 = {1, 2, 3, 4};
        System.out.println(solution.numTeams(rating3)); // Output: 4
    }
}
