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
    MergeSort merge; //Deklarierung der Klasse für Merge Sort

    Knopf bFillArray; //Knopf, um das Array zu füllen

    Auswahl aLaenge; //Dropdown zur Auswahl der Arraylänge

    Knopf bBubble; //Knopf, um das Array mit Bubble Sort zu sortieren
    Knopf bInsertion; //Knopf, um das Array mit Insertion Sort zu sortieren
    Knopf bSelection; //Knopf, um das Array mit Selection Sort zu sortieren
    Knopf bQuick; //Knopf, um das Array mit Bubble Sort zu sortieren
    Knopf bMerge; //Knopf, um das Array mit Merge Sort zu sortieren

    Etikett zeit; //Etioppte Zeitktt, dass die beim Sortieren gestoppte Zeit angibt
    Etikett status; //Etikett, dass einen Statusbericht anzeigt (Bsw. "Berechne" oder "fertig")
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
        merge = new MergeSort();

        bFillArray = new Knopf(10,10,75,25,"Fill Array","bFillArrayGeklickt");

        aLaenge = new Auswahl(100,10,50,25); 
        fillAuswahlen();

        bBubble = new Knopf(200,10,100,25,"Bubble Sort","bBubbleGeklickt");
        bInsertion = new Knopf(300,10,100,25,"Insertion Sort","bInsertionGeklickt");
        bSelection = new Knopf(400,10,100,25,"Selection Sort","bSelectionGeklickt");
        bQuick = new Knopf(500,10,100,25,"Quick Sort","bQuickGeklickt");
        bMerge = new Knopf(600,10,100,25,"Merge Sort","bMergeGeklickt");

        zeit = new Etikett(800,20,100,30,"Gestoppte Zeit");
        status = new Etikett(800,3,100,30,"Warte auf Start");
        status.setzeSchriftFarbe(1);
        test = new Etikett(10,50,990,25,"");
        test.setzeSchriftGroesse(20);

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
        status.setzeSchriftFarbe(1);        //status zeigt hier in der Farbe Blau  an, das die Sortierung begonnen werden kann
        status.setzeInhalt("Warte auf Start");
        deleteNumbers();
        printNumbers();
        if(sorted)
        {
            bubble.deleteln();
            insertion.deleteln();
            selection.deleteln();
            quick.deleteln();
            merge.deleteln();
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
        status.setzeSchriftFarbe(10);           //status zeigt hier in der Farbe Rot an, das nun berechnet wird
        status.setzeInhalt("Berechne...");
        zeit.setzeInhalt("");
        if(sorted)
        {
            bubble.deleteln();
            insertion.deleteln();
            selection.deleteln();
            quick.deleteln();
            merge.deleteln();
        }
        if(test.inhaltAlsText()!="") //->damit der Knopf erst verwendet werden kann, wenn es auch was zum Sortieren gibt
        {
            bubble.bubbleSort(array, n);
            zeit.setzeInhalt("BubbleSort:" + bubble.time(array, n) + "ms");
            status.setzeSchriftFarbe(5);        //status zeigt hier in der Farbe Grün an, das die Sortierung abgeschlossen ist
            status.setzeInhalt("FERTIG");
            sorted = true;
        }
    }

    public void bInsertionGeklickt()
    {
        status.setzeSchriftFarbe(10);       //status zeigt hier in der Farbe Rot an, das nun berechnet wird
        status.setzeInhalt("Berechne...");
        zeit.setzeInhalt("");
        if(sorted)
        {
            bubble.deleteln();
            insertion.deleteln();
            selection.deleteln();
            quick.deleteln();
            merge.deleteln();
        }
        if(test.inhaltAlsText()!="")
        {
            insertion.insertionSort(array, n);
            zeit.setzeInhalt("InsertionSort:" + insertion.time(array, n) + "ms");
            status.setzeSchriftFarbe(5);        //status zeigt hier in der Farbe Grün an, das die Sortierung abgeschlossen ist
            status.setzeInhalt("FERTIG");
            sorted = true;
        } 
    }

    public void bSelectionGeklickt()
    {
        status.setzeSchriftFarbe(10);       //status zeigt hier in der Farbe Rot an, das nun berechnet wird
        status.setzeInhalt("Berechne...");
        zeit.setzeInhalt("");
        if(sorted)
        {
            bubble.deleteln();
            insertion.deleteln();
            selection.deleteln();
            quick.deleteln();
            merge.deleteln();
        }
        if(test.inhaltAlsText()!="")
        {
            selection.selectionSort(array, n);
            zeit.setzeInhalt("SelectionSort:" + selection.time(array, n) + "ms");
            status.setzeSchriftFarbe(5);        //status zeigt hier in der Farbe Grün an, das die Sortierung abgeschlossen ist
            status.setzeInhalt("FERTIG");
            sorted = true;
        }
    }

    public void bQuickGeklickt()
    {
        status.setzeSchriftFarbe(10);       //status zeigt hier in der Farbe Rot an, das nun berechnet wird
        status.setzeInhalt("Berechne...");
        zeit.setzeInhalt("");
        if(sorted)
        {
            bubble.deleteln();
            insertion.deleteln();
            selection.deleteln();
            quick.deleteln();
            merge.deleteln();
        }
        if(test.inhaltAlsText()!="")
        {
            quick.quickSort(array, n);
            zeit.setzeInhalt("QuickSort:" + quick.time(array, n) + "ms");      //ruft die Methode der Zeitberechnung auf und zeigt das Ergebniss an
            status.setzeSchriftFarbe(5);        //status zeigt hier in der Farbe Grün an, das die Sortierung abgeschlossen ist
            status.setzeInhalt("FERTIG");
            sorted = true;
        }
    }
    
    public void bMergeGeklickt()
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
            merge.mergeSort(array, n);
            sorted = true;
            zeit.setzeInhalt("MergeSort:" + merge.time());
        }
    }
}
