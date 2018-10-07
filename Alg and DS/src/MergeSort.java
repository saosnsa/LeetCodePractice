
public class MergeSort {
	public static void main(String Args[]) {
		// Examples to test the code
		int[] arr = new int[] {38, 27, 43, 3, 9, 82, 10};
		mergeSort(arr, 0, arr.length-1);
		for (int i=0; i < arr.length-1; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.print(arr[arr.length-1]);
		
		System.out.println();
		
		int[] arr1 = new int[] {55, 89, 87, 73, 54, 20, 1, 13, 99, 82};
		mergeSort(arr1, 0, arr1.length-1);
		for (int i=0; i < arr1.length-1; i++) {
			System.out.print(arr1[i] + ",");
		}
		System.out.print(arr1[arr1.length-1]);
	}
	
	public static int[] mergeSort(int[] a, int s, int e) {
		if (s < e) { // If s > e, then it would not be valid indexing for sorting
			int mid = (s+e)/2;
			mergeSort(a, s, mid);
			mergeSort(a, mid+1, e);
			merge(a, s, mid, e);
		}
		return a;
	}
	
	public static int[] merge(int[] a, int start, int mid, int end) {
		if (start == end) { // One item array
			return a;
		} else {
			int temp1size = mid - start + 1;
			int temp2size = end - mid;
			int[] temp1 = new int[temp1size];
			int[] temp2 = new int[temp2size];
			
			for (int i =0; i < temp1size; i++) { //Copy first half of the array
				temp1[i] = a[start+i];
			}
			
			for (int i = 0; i < temp2size; i++) { //Copy second half of the array
				temp2[i] = a[mid+1+i];
			}
			
			int first = 0;
			int second = 0;
			int mainIndex = start;
			int temp1end = temp1.length;
			int temp2end = temp2.length;
			
			while (first < temp1end && second < temp2end) {
				if (temp1[first] < temp2[second]) {
					a[mainIndex] = temp1[first];
					first++;
				} else {
					a[mainIndex] = temp2[second];
					second++;
				}
				mainIndex++;
			}
			
			if (first == temp1end) {
				while (mainIndex <= end) {
					a[mainIndex] = temp2[second];
					second++;
					mainIndex++;
				}
			} else {
				while (mainIndex <= end) {
					a[mainIndex] = temp1[first];
					first++;
					mainIndex++;
				}
			}
		}
		return a;
	}
}
