import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

class Quicksort {
    public static int[] intArr = {};

    public int[] sort(int l, int r) {
        int q;
        if (l < r) {
            q = partition(l, r);
            // Rekursion
            sort(l, q);
            sort(q + 1, r);
        }
        return intArr;
    }

    int partition(int l, int r) {

        int i, j, x = intArr[(l + r) / 2];
        i = l - 1;
        j = r + 1;
        while (true) {
            do {
                i++;
            } while (intArr[i] < x);

            do {
                j--;
            } while (intArr[j] > x);

            if (i < j) {
                int k = intArr[i];
                intArr[i] = intArr[j];
                intArr[j] = k;
            } else {
                return j;
            }
        }
    }

    public static void readData(){
        List<Integer> intList = new ArrayList<Integer>();
        File file = new File("quicksort_data.txt");

        System.out.println("Wir lesen ein: ");

        try {
            Scanner scanner = new Scanner(file);
    
            while (scanner.hasNextLine()) {
                int i = scanner.nextInt();
                intList.add(i);                
                System.out.print(i + " ");
            }
            scanner.close();
            System.out.println("");
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        intArr = new int[intList.size()];
        int i = 0;
        for (Integer e : intList)  
            intArr[i++] = e;
    }

    public static void main(String[] args) {
        Quicksort qs = new Quicksort();
        qs.readData();
        int[] arr = qs.sort(0, intArr.length - 1);
        System.out.print("Wir geben aus: ");
        System.out.println(Arrays.toString(arr));
    } 
}
