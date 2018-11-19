
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
    
    public void quickSort(int pArray[], int pN)
    {
        array = new int[pN];
        for(int i=0;i < pArray.length; i++)
        {
            array[i] = pArray[i];
        }
        this.sort(array, 0 , pN-1);
    }
    
        
     /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted arrayay, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
    int partition(int array[], int low, int high) 
    { 
        int pivot = array[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (array[j] <= pivot) 
            { 
                i++; 
  
                // swap array[i] and array[j] 
                int temp = array[i]; 
                array[i] = array[j]; 
                array[j] = temp; 
    
                println();               
            } 
        } 
  
        // swap array[i+1] and array[high] (or pivot) 
        int temp = array[i+1]; 
        array[i+1] = array[high]; 
        array[high] = temp; 
  
        println();
                
        return i+1; 
    } 
    
    /* The main function that implements QuickSort() 
      arrayay[] --> arrayay to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(int array[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, array[pi] is  
              now at right place */
            int pi = partition(array, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(array, low, pi-1); 
            sort(array, pi+1, high); 
        } 
    } 
    
}
