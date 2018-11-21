
/**
 * @author 
 * @version 
 */
public class QuickSort extends Sortieralgorithmen
{
    // Bezugsobjekte
    
    // Attribute
    
    // Konstruktor
    public QuickSort()
    {

    }
    // Dienste
    
    /* Diese Klasse ist ein "Vermittler" zwischen der SuMAnwendung() und dem
       etwas komplexerem QuickSort. Hier ermittelt das Programm die Array 
       länge welche später noch gebraucht wird (als high bzw pivot).
       Außerdem wird ein "Vermittler Array" gleich dem Original Array gesetzt.
       So ändert das Programm nichts am Original Array, sodass auf diesen 
       weiterhin zugegriffen werden kann. */
      
    public void quickSort(int pArray[], int pN)
    {
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
    
        
     /* In dieser Methode wird das Letzte Element (high  bzw. Pivot) an seine
        Korrekte Stelle gelegt. Daraufhin werden alle Elemente welche einen 
        größeren Wert haben als das Pivot, auf dessen recht Seite verschoben
        und alle Elemente welche einen kleineren Wert haben kommen auf die
        linke Seite        
                                1,5,1,7,4,8,3
                                            ^
                                            |
                                      high bzw. Pivot
                                      
                                      
                                      
                                      
                                          
                     nach der Methode:     1,1,3,8,4,7,5
                                               ^
                                               |
                                         high bzw. Pivot */                    
      
    int partition(int array[], int low, int high) 
    { 
        int pivot = array[high];  
        int i = (low-1); // Index des kleineren Elementes
        for (int j=low; j<high; j++) 
        { 
            // Falls das aktuelle Objekt kleiner oder gleich dem Pivot Element ist
            if (array[j] <= pivot) 
            { 
                i++; 
  
                // Tauscht array[i] und array[j] 
                int temp = array[i]; 
                array[i] = array[j]; 
                array[j] = temp; 
    
                save();         
            } 
        } 
  
        // swap array[i+1] and array[high] (or pivot) 
        int temp = array[i+1]; 
        array[i+1] = array[high]; 
        array[high] = temp; 
  
        save();
                
        return i+1; 
    } 
    
    /* Die Hauptbegiffe die von QuickSort() im folgenden genutzt werden
       array[] --> der array der im fogenden sortiert werden soll, 
       low  --> Start Index (in diesem fall einfach 0), 
       high  --> Der letzte Index im Array */
    void sort(int array[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi ist der seperations index, array[xy] wird an die 
               richtige stelle gepackt */
              
            int xy = partition(array, low, high); 
  
            // Rekursiver Aufruf zum Sortieren              
            sort(array, low, xy-1); 
            sort(array, xy+1, high); 
        } 
    } 
    
    
    /* Gibt Wert der gestoppten Zeit zurück
         als Mittelwert von 10 Sortierungen */
     
    public double time(int array[] ,int  n)
        {
             
            for(int i=0; i<9 ; i++) // i index
            {
                this.resetS();
                f = f + t; // Die neuen Zahlen werden addiert
                this.quickSort(array, n); // Erneutes Sortieren
            }
            
            t = f / 10; // Mittlerer Wert wird berechnet
            f = 0;
            return (t); // Mittlerer Wert wird zurück gegeben
        }


}
