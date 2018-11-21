
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
        n=pN;
        array = new int[pN];
        for(int i=0; i<pArray.length; i++) // Solange i kleiner ist als die Laenge von pArray wird i um 1 erhoeht sodass am Ende alle Stellen gleichgesetzt sind
        {
            array[i] = pArray[i]; // Das Array dieser Klasse wird dem der anderen gleichgesetzt
        }
        meineUhr.starte(); // Startet die Stoppuhr
        /* Die For-Schleife läuft einmal weniger durch als das Array lang ist. Dies kommt daher, dass jede Position genau 
           einmal mit den davor liegenden verglichen wird außer die erste. Bei einem Array der länge 28 läuft sie also 9 mal durch */
        
        for (int i=1; i<pN; i++) 
        { 
            int key = array[i]; 
            int j = i-1; 
            /* Vergleicht zwei positionen des Arrays miteinander. Bsw.Position 5 mit 4.
               Also zuerst immer eine mit der davor liegenden. Wenn die Davorliegende größer ist
               das Vergleichsobjekt, dann wird das nächste verglichen (in diesem Fall die Position 3).
               Wenn diese nun auch größer ist wird wieder die Position davor genommen. Das geschiet bis das 
               Vergleichsobjekt kleiner ist als die Position an der man gerade ist oder man mit der 1ten Position 
               des Arrays verglichen hat. Dann wird das Vergleichsobjekt hinter das kleinere gelegt und alle anderen rücken auf */
                
            while (j>=0 && array[j] > key)  
            { 
                array[j+1] = array[j]; 
                j = j-1; 
            } 
            array[j+1] = key; 
            save();
        } 
        meineUhr.stoppe(); // Stoppt die Stoppuhr
        t = meineUhr.gestoppteZeit();
    }
    
    
    /* Gibt Wert der gestoppten Zeit zurück
       als mittelwert von 10 sortierungen */
         
    public double time(int array[] ,int  n)
        {
             
            for(int i=0; i<9 ; i++) // i index
            {
                this.resetS();
                f = f + t; // Die neuen Zahlen werden addiert
                this.insertionSort(array, n); // Erneutes Sortieren
            }
            
            t = f / 10; // Mittlerer Wert wird berechnet
            f = 0;
            return (t); // Mittlerer Wert wird zurück gegeben
            
        }

}
