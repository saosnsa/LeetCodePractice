//From this question -> https://leetcode.com/problems/ones-and-zeroes/description/
// Treated this questions as 0/1 knapsack problem, got the idea from discussion

public class numZerosAndOnes {
	public static void main(String Args[]) {
		// Example given by the question
		String[] arr = new String[]{"10", "0", "1"};
		int m = 1;
		int n = 1;
		int result = findMaxForm(arr, m, n);
		System.out.println(result);
		
		// Example given by the question
		arr = new String[]{"10", "0001", "111001", "1", "0"};
		m = 5;
		n = 3;
		result = findMaxForm(arr, m, n);
		System.out.println(result);
	}
	
	public static int findMaxForm(String[] strs, int m, int n) {
        int numZero;
        int numOne;
        if (strs.length == 0 || (m == 0 && n == 0 ) ) {
            return 0;
        }
        
        int numFit[][][] = new int[strs.length+1][m+1][n+1]; // numFit[i][m][n]->Max # of strings that fit from first i arguments with <= m 0's and <= n 1's
        
        for (int i = 1; i < strs.length+1; i++) { // For i=0, all of numFit[0][j][k] = 0
            // Refresh these variables to 0 for each i
            numZero = 0;
            numOne = 0;
            
            for (int index = 0; index < strs[i-1].length(); index++) { // Calculating the number of zero and ones
                if (strs[i-1].charAt(index) == '0') {
                    numZero += 1;
                } else {
                    numOne += 1;
                }
            }
            
            for (int j = 0; j < m+1; j++) {
                for (int k = 0; k < n+1; k++) {
                    if (j >= numZero && k >= numOne) { // If there are enough resources (0 and 1's) left, decide if i should be included or not 
                        numFit[i][j][k] = Math.max(numFit[i-1][j-numZero][k-numOne]+1, numFit[i-1][j][k]);
                    } else { // Not enough resources left to pick i, so we do not include i in the solution.
                        numFit[i][j][k] = numFit[i-1][j][k];
                    }
                }
            }
        }
        return numFit[strs.length][m][n];
    }
}
