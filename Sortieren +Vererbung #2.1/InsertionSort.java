
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
        //Übergangsarray wird erzeugt
        array = new int[pN];
        for(int i=0; i<pArray.length; i++)
        {
            array[i] = pArray[i];
        }
        
        //Insertion Sort
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
            println();
        } 
    }

}
