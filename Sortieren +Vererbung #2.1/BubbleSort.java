
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
        array = new int[pN];
        for(int i=0; i<pArray.length; i++)
        {
            array[i] = pArray[i];
        }
        
        for(int w=0; w<pN-1; w++) //w wiederholungen
        {
            swapped = false;
            for(int i=0; i<pN-1 ; i++) //i index
            {
                if(array[i+1]<array[i])
                {
                    int temporary = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temporary;
                    println();
                    swapped = true;
                }
            }
            if(!swapped) //Damit früher beendete Sortierung festgestellt werden kann (Zeitkürzung)
            {break;}
        }
    }
} 
