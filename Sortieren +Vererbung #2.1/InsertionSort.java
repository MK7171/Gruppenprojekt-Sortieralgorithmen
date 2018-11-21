
/**
 * @author 
 * @version 
 */
public class InsertionSort extends Sortieralgorithmen
{
    // Bezugsobjekte

    // Attribute
    
    // Konstruktor
    public InsertionSort()
    {
        
    }

    // Dienste
    void insertionSort(int pArray[], int pN) 
    { 
        array = new int[pN];
        for(int i=0; i<pArray.length; i++) //solange i kleiner ist als die Laenge von pArray wird i um 1 erhoeht sodass am Ende alle Stellen gleichgesetzt sind
        {
            array[i] = pArray[i]; //Das Array dieser Klasse wird dem der anderen gleichgesetzt
        }
        meineUhr.starte();
        for (int i=1; i<pN; ++i) 
        { 
            int key = array[i]; 
            int j = i-1; 

            while (j>=0 && array[j] > key) 
            { 
                array[j+1] = array[j]; 
                j = j-1; 
            } 
            array[j+1] = key; 
            println(); //ausgeben von aktuellem Array
        } 
        meineUhr.stoppe();
        t = meineUhr.gestoppteZeit();
    }
    
    
        /*Gibt Wert der gestoppten Zeit zurück
         * als mittelwert von 10 sortierungen
        */ 
    public double time(int array[] ,int  n)
        {
             
            for(int i=0; i<9 ; i++) //i index
            {
                f = f + t;   //die neuen Zahlen werden addiert
                this.insertionSort(array, n);      //erneutes Sortieren
            }
            
            t = f / 10; //Mittlere Wert wird berechnet
            f = 0;
            return (t);  //mittlerer Wert wird zurück gegeben
            
        }

}
