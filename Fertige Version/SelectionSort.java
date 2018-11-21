
/**
 * @author 
 * @version 
 */
public class SelectionSort extends Sortieralgorithmen
{
    // Bezugsobjekte

    // Attribute

    // Konstruktor
    public SelectionSort()
    {

    }

    // Dienste
    public void selectionSort(int pArray[], int pN) 
    { 
        n=pN;
        array = new int[pN];
        for(int i=0; i<pArray.length; i++) // Solange i kleiner ist als die Laenge von pArray wird i um 1 erhoeht sodass am Ende alle Stellen gleichgesetzt sind
        {
            array[i] = pArray[i]; // Das Array dieser Klasse wird dem der anderen gleichgesetzt
        }
        
        meineUhr.starte();
        
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < pN-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < pN; j++) 
            {
                if (array[j] < array[min_idx]) 
                {
                    min_idx = j; 
                }
            }

            // Swap the found minimum element with the first 
            // element 
            int temp = array[min_idx]; 
            array[min_idx] = array[i]; 
            array[i] = temp; 
            save();
        } 
        meineUhr.stoppe();
        t = meineUhr.gestoppteZeit();
    }
    
    /* Gibt Wert der gestoppten Zeit zurück
       als mittelwert von 10 sortierungen */
     
    public double time(int array[] ,int  n)
        {
             
            for(int i=0; i<9 ; i++) // i index
            {
                this.resetS();
                f = f + t;   // Die neuen Zahlen werden addiert
                this.selectionSort(array, n); // Erneutes Sortieren
            }
            
            t = f / 10; // Mittlerer Wert wird berechnet
            f = 0;
            return (t); // Mittlerer Wert wird zurück gegeben
            
        }
    

}
