
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class MergeSort extends Sortieralgorithmen
{
    // Objekte
    
    // Konstruktor
    public MergeSort(){
        
    }

    // Dienste
    public void mergeSort(int pArray[], int pN){
        array = new int[pN];
        for(int i=0;i < pArray.length; i++)
        {
            array[i] = pArray[i];
        }
        meineUhr.starte();
        this.sort(array, 0 , pN-1);
        meineUhr.stoppe();
        t = meineUhr.gestoppteZeit();
    }
    
    void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            println();
            sort(arr , m+1, r); 
            println();
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
            println();
        } 
    } 
    
     /*Gibt Wert der gestoppten Zeit zurück
    * als mittelwert von 10 sortierungen
    */ 
    public double time(int array[] ,int  n)
        {
             
            for(int i=0; i<9 ; i++) //i index
            {
                this.deleteln();
                f = f + t;   //die neuen Zahlen werden addiert
                this.mergeSort(array, n);      //erneutes Sortieren
            }
            
            t = f / 10; //Mittlere Wert wird berechnet
            f = 0;
            return (t);  //mittlerer Wert wird zurück gegeben

        }
}
