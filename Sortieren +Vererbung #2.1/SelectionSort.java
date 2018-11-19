
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
        array = new int[pN];
        for(int i=0; i<pArray.length; i++)
        {
            array[i] = pArray[i];
        }

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
            println();
        } 
    }
}
