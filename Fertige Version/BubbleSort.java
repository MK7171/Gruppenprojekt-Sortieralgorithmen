
/**
 * @author
 * @version 
 */
public class BubbleSort extends Sortieralgorithmen
{
    // Bezugsobjekte

    // Attribute
    private boolean swapped;

    // Konstruktor
    public BubbleSort()
    {
        
    }

    // Dienste
    public void bubbleSort(int pArray[], int pN)
    {
        n=pN;
        array = new int[pN];
        for(int i=0; i<pArray.length; i++) // Solange i kleiner ist als die Laenge von pArray wird i um 1 erhoeht sodass am Ende alle Stellen gleichgesetzt sind
        {
            array[i] = pArray[i]; // Das Array dieser Klasse wird dem der anderen gleichgesetzt
        }
        
        meineUhr.starte();
        
        for(int w=0; w<pN-1; w++) // w wiederholungen
        {
            swapped = false;
            for(int i=0; i<pN-1 ; i++) // i index
            {
                if(array[i+1]<array[i])
                {
                    int temporary = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temporary;
                    save();
                    swapped = true;
                }
            }
            if(!swapped) // Damit früher beendete Sortierung festgestellt werden kann (Zeitkürzung)
            {break;}
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
                f = f + t; // Die neuen Zahlen werden addiert
                this.bubbleSort(array, n); // Erneutes Sortieren
            }
            
            t = f / 10; // Mittlerer Wert wird berechnet
            f = 0;
            return (t); // Mittlerer Wert wird zurück gegeben
            
        }
} 
