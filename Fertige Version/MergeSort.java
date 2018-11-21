
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
        n=pN;
        array = new int[pN];
        for(int i=0;i < pArray.length; i++) // Solange i kleiner ist als die Laenge von pArray wird i um 1 erhoeht sodass am Ende alle Stellen gleichgesetzt sind
        {
            array[i] = pArray[i]; // Das Array dieser Klasse wird dem der anderen gleichgesetzt
        }
        meineUhr.starte();
        this.sort(array, 0 , pN-1);
        meineUhr.stoppe();
        t = meineUhr.gestoppteZeit();
    }
    
    void merge(int arr[], int l, int m, int r) 
    { 
        // Die Größen der Arrays speichern
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        // Temporaere arrays erstellen
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        // Array arr in 2 weitere aufteilen
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
        // Groeßen der beiden arrays 
        int i = 0, j = 0; 
  
        // Die Temporaeren arrays werden gemerged
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
  
        // Restliche Elemente von L[] kopieren (Falls vorhanden)
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        // Restliche Elemente von R[] kopieren (Falls vorhanden)
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
            // Der Mittelpunkt wird berechnet
            int m = (l+r)/2; 
  
            // Beide Haelften werden sortiert
            sort(arr, l, m); 
            save();
            sort(arr , m+1, r); 
            save();
  
            // Die Haelften werden gemerged
            merge(arr, l, m, r); 
            save();
        } 
    } 
    
    /* Gibt Wert der gestoppten Zeit zurück
       als mittelwert von 10 sortierungen */
     
    public double time(int array[] ,int  n)
        {
             
            for(int i=0; i<9 ; i++) // i index
            {
                this.resetS();
                f = f + t; // Die neuen Zahlen werden addiert
                this.mergeSort(array, n); //Erneutes Sortieren
            }
            
            t = f / 10; // Mittlerer Wert wird berechnet
            f = 0;
            return (t); // Mittlerer Wert wird zurück gegeben

        }
}
