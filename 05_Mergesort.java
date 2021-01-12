import java.util.Arrays;

class MergeSort 
{
    void merge(int arr[], int l, int m, int r)
    {
        // subarrays finden
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Daten in temporäre Arrays packen*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge der temporären Arrays */ 
        int i = 0, j = 0; 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Hauptfunktion zum Sortieren von arr
    // merge ist hier der rekursive Aufruf
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Mittelpunkt
            int m = (l + r) / 2; 
            // Sortieren der Hälften
            sort(arr, l, m);
            sort(arr, m + 1, r);
             // Merge --> Rekursion!
            merge(arr, l, m, r);
        }
    } 
 
    public static void main(String args[])
    {
        // Eingabearray
        int arr[] = { 12, 11, 13, 5, 6, 7 };
 
        System.out.print("Eingegebene Daten: ");
        System.out.println(Arrays.toString(arr));
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
 
        System.out.print("Sortierte Daten: ");
        System.out.println(Arrays.toString(arr));
    }
}
