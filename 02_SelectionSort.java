//Liste l, die mit dem Heapsort sortiert werden soll
import java.util.Arrays;

public class SelectionSort
{ 
	public static int[] selectionsort(int[] sortieren) {
		for (int i = 0; i < sortieren.length - 1; i++) {
			for (int j = i + 1; j < sortieren.length; j++) {
				if (sortieren[i] > sortieren[j]) {
					int temp = sortieren[i];
					sortieren[i] = sortieren[j];
					sortieren[j] = temp;
				}
			}
		}
		return sortieren;
	}

    public static void main(String[] args) {

		int[] unsortiert = { 4, 1, 8, -3, 5, 7 };
		int[] sortiert = selectionsort(unsortiert);

		System.out.println("Sortieres Array");
        System.out.println(Arrays.toString(sortiert));
	}


}