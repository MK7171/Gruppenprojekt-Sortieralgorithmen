import sum.ereignis.*;
import sum.komponenten.*;
import sum.werkzeuge.*;
/**
 * @author
 * @version
 */
public class SuMAnwendung extends EBAnwendung
{
    // Bezugsobjekte
    int [] array; //Array mit Zahlen

    BubbleSort bubble; //Deklarierung der Klasse für Bubble Sort 
    InsertionSort insertion; //Deklarierung der Klasse für Insertion Sort
    SelectionSort selection; //Deklarierung der Klasse für Selection Sort
    QuickSort quick; //Deklarierung der Klasse für Quick Sort

    Knopf bFillArray; //Knopf, um das Array zu füllen

    Auswahl aLaenge; //Dropdown zur Auswahl der Arraylänge

    Knopf bBubble; //Knopf, um das Array mit Bubble Sort zu sortieren
    Knopf bInsertion; //Knopf, um das Array mit Insertion Sort zu sortieren
    Knopf bSelection; //Knopf, um das Array mit Selection Sort zu sortieren
    Knopf bQuick; //Knopf, um das Array mit Bubble Sort zu sortieren

    Etikett zeit; //Etioppte Zeitktt, dass die beim Sortieren gestoppte Zeit angibt
    Etikett test; //Etikett, das den Ursprungszustand des Arrays enthält

    Rechner r; //Für die Zufallszahlen, die das Array füllen werden

    // Attribute
    int n; //Anzahl der Zahlen im Array
    boolean sorted = false; 

    // Konstruktor
    public SuMAnwendung()
    {
        super(1000,600);

        bubble = new BubbleSort();
        insertion = new InsertionSort();
        selection = new SelectionSort();
        quick = new QuickSort();

        bFillArray = new Knopf(10,10,75,25,"Fill Array","bFillArrayGeklickt");

        aLaenge = new Auswahl(100,10,50,25); 
        fillAuswahlen();

        bBubble = new Knopf(200,10,100,25,"Bubble Sort","bBubbleGeklickt");
        bInsertion = new Knopf(300,10,100,25,"Insertion Sort","bInsertionGeklickt");
        bSelection = new Knopf(400,10,100,25,"Selection Sort","bSelectionGeklickt");
        bQuick = new Knopf(500,10,100,25,"Quick Sort","bQuickGeklickt");

        zeit = new Etikett(800,50,100,30,"Gestoppte Zeit");
        test = new Etikett(10,50,990,25,"");
        test.setzeSchriftgroesse(20);

        r = new Rechner();
    }

    // Dienste
    public void fillAuswahlen()
    {
        for(int i=3; i<=100; i++)
        {
            aLaenge.haengeAn(""+i);
        }
    }

    public void bFillArrayGeklickt()
    {
        fillArray();
        deleteNumbers();
        printNumbers();
        if(sorted)
        {
            bubble.deleteln();
            insertion.deleteln();
            selection.deleteln();
            //quick.deleteln();
        } //->damit die Sortierschritte auch gelöscht werden
        sorted = false;
    }

    public void fillArray()
    {
        n = aLaenge.index()+2;
        array = new int[n]; //Array wird mit n Plätzen initialisiert
        for(int i=0; i<array.length; i++)
        {array[i] = r.ganzeZufallszahl(1,5);}
    }

    public void printNumbers()
    {
        for(int i=0; i<array.length; i++)
        {
            test.setzeInhalt(test.inhaltAlsText()+array[i]);
            if(i<array.length-1)
            {test.setzeInhalt(test.inhaltAlsText()+", ");}
        }
    }

    public void deleteNumbers()
    {
        test.setzeInhalt("");
    }

    public void bBubbleGeklickt()
    {
        if(sorted)
        {
            bubble.deleteln();
            insertion.deleteln();
            selection.deleteln();
            quick.deleteln();
        }
        if(test.inhaltAlsText()!="") //->damit der Knopf erst verwendet werden kann, wenn es auch was zum Sortieren gibt
        {
            bubble.bubbleSort(array, n);
            sorted = true;
            zeit.setzeInhalt("BubbleSort:" + bubble.time());
        }
    }

    public void bInsertionGeklickt()
    {
        if(sorted)
        {
            bubble.deleteln();
            insertion.deleteln();
            selection.deleteln();
            quick.deleteln();
        }
        if(test.inhaltAlsText()!="")
        {
            insertion.insertionSort(array, n);
            sorted = true;
            zeit.setzeInhalt("InsertionSort:" + insertion.time());
        } 
    }

    public void bSelectionGeklickt()
    {
        if(sorted)
        {
            bubble.deleteln();
            insertion.deleteln();
            selection.deleteln();
            quick.deleteln();
        }
        if(test.inhaltAlsText()!="")
        {
            selection.selectionSort(array, n);
            sorted = true;
            zeit.setzeInhalt("SelectionSort:" + selection.time());
        }
    }

    public void bQuickGeklickt()
    {
        if(sorted)
        {
            bubble.deleteln();
            insertion.deleteln();
            selection.deleteln();
            quick.deleteln();
        }
        if(test.inhaltAlsText()!="")
        {
            quick.quickSort(array, n);
            sorted = true;
            zeit.setzeInhalt("QuickSort:" + quick.time());
        }
    }
}
