import sum.ereignis.*;
import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.strukturen.*;
/**
 * @author
 * @version
 */
public class SuMAnwendung extends EBAnwendung
{
    // Bezugsobjekte
    int [] array; // Array mit Zahlen

    BubbleSort bubble; // Deklarierung der Klasse für Bubble Sort 
    InsertionSort insertion; // Deklarierung der Klasse für Insertion Sort
    SelectionSort selection; // Deklarierung der Klasse für Selection Sort
    QuickSort quick; // Deklarierung der Klasse für Quick Sort
    MergeSort merge; // Deklarierung der Klasse für Merge Sort

    Knopf bFillArray; // Knopf, um das Array zu füllen

    Auswahl aLaenge; // Dropdown zur Auswahl der Arraylänge

    Knopf bBubble; // Knopf, um das Array mit Bubble Sort zu sortieren
    Knopf bInsertion; // Knopf, um das Array mit Insertion Sort zu sortieren
    Knopf bSelection; // Knopf, um das Array mit Selection Sort zu sortieren
    Knopf bQuick; // Knopf, um das Array mit Bubble Sort zu sortieren
    Knopf bMerge; // Knopf, um das Array mit Merge Sort zu sortieren

    Etikett zeit; // Etioppte Zeitktt, dass die beim Sortieren gestoppte Zeit angibt
    Etikett status; // Etikett, dass einen Statusbericht anzeigt (Bsw. "Berechne" oder "fertig")
    Etikett test; // Etikett, das den Ursprungszustand des Arrays enthält

    Rechner r; // Für die Zufallszahlen, die das Array füllen werden

    Knopf bFirst = new Knopf(25,675,75,25,"<<","first");
    Knopf bPrevious = new Knopf(100,675,75,25,"<","previous");
    Knopf bNext = new Knopf(175,675,75,25,">","next");
    Knopf bLast = new Knopf(250,675,75,25,">>","last");
    
    // Attribute
    int n; // Anzahl der Zahlen im Array
    int seite = 1;
    int maxSeite = 1;
    boolean sorted = false; 
    String lastUsed;
    
    // Konstruktor
    public SuMAnwendung()
    {
        super(1200,710);

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
        test = new Etikett(10,50,1200,25,"");
        test.setzeSchriftGroesse(20);

        r = new Rechner();
    }

    // Dienste
    public void fillAuswahlen()
    {
        for(int i=3; i<=33; i++)
        {
            aLaenge.haengeAn(""+i);
        }
    }

    public void bFillArrayGeklickt()
    {
        fillArray();
        status.setzeSchriftFarbe(1); // Status zeigt hier in der Farbe Blau  an, das die Sortierung begonnen werden kann
        status.setzeInhalt("Warte auf Start");
        zeit.setzeInhalt("Gestoppte Zeit");
        deleteNumbers();
        printNumbers();
        if(sorted)
        {
            bubble.resetE();
            bubble.resetS();
            insertion.resetE();
            insertion.resetS();
            selection.resetE();
            selection.resetS();
            quick.resetE();
            quick.resetS();
            merge.resetE();
            merge.resetS();
        } // Damit die Sortierschritte auch gelöscht werden
        sorted = false;
    }

    public void fillArray()
    {
        n = aLaenge.index()+2;
        array = new int[n]; // Array wird mit n Plätzen initialisiert
        for(int i=0; i<array.length; i++)
        {array[i] = r.ganzeZufallszahl(1,100);}
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
        status.setzeSchriftFarbe(10); // Status zeigt hier in der Farbe Rot an, das nun berechnet wird
        status.setzeInhalt("Berechne...");
        zeit.setzeInhalt("");
        if(sorted)
        {
            bubble.resetE();
            bubble.resetS();
            insertion.resetE();
            insertion.resetS();
            selection.resetE();
            selection.resetS();
            quick.resetE();
            quick.resetS();
            merge.resetE();
            merge.resetS();
        }
        if(test.inhaltAlsText()!="") // Damit der Knopf erst verwendet werden kann, wenn es auch was zum Sortieren gibt
        {
            lastUsed = "bubble";
            bubble.bubbleSort(array, n);
            zeit.setzeInhalt("BubbleSort:"+bubble.time(array, n)+"ms");
            status.setzeSchriftFarbe(5); // Status zeigt hier in der Farbe Grün an, das die Sortierung abgeschlossen ist
            status.setzeInhalt("FERTIG");
            maxSeite=1;
            getMaxSeite();
            //System.out.println(maxSeite+" Seite(n) (BubbleSort)");
            first();
            sorted = true;
        }
    }

    public void bInsertionGeklickt()
    {
        status.setzeSchriftFarbe(10); // Status zeigt hier in der Farbe Rot an, das nun berechnet wird
        status.setzeInhalt("Berechne...");
        zeit.setzeInhalt("");
        if(sorted)
        {
            bubble.resetE();
            bubble.resetS();
            insertion.resetE();
            insertion.resetS();
            selection.resetE();
            selection.resetS();
            quick.resetE();
            quick.resetS();
            merge.resetE();
            merge.resetS();
        }
        if(test.inhaltAlsText()!="")
        {
            lastUsed = "insertion";
            insertion.insertionSort(array, n);
            zeit.setzeInhalt("InsertionSort:" + insertion.time(array, n) + "ms");
            status.setzeSchriftFarbe(5); // Status zeigt hier in der Farbe Grün an, das die Sortierung abgeschlossen ist
            status.setzeInhalt("FERTIG");
            maxSeite=1;
            getMaxSeite();
            System.out.println(maxSeite+" Seite(n) (InsertionSort)");
            first();
            sorted = true;
        } 
    }

    public void bSelectionGeklickt()
    {
        status.setzeSchriftFarbe(10); // Status zeigt hier in der Farbe Rot an, das nun berechnet wird
        status.setzeInhalt("Berechne...");
        zeit.setzeInhalt("");
        if(sorted)
        {
            bubble.resetE();
            bubble.resetS();
            insertion.resetE();
            insertion.resetS();
            selection.resetE();
            selection.resetS();
            quick.resetE();
            quick.resetS();
            merge.resetE();
            merge.resetS();
        }
        if(test.inhaltAlsText()!="")
        {
            lastUsed = "selection";
            selection.selectionSort(array, n);
            zeit.setzeInhalt("SelectionSort:" + selection.time(array, n) + "ms");
            status.setzeSchriftFarbe(5); // Status zeigt hier in der Farbe Grün an, das die Sortierung abgeschlossen ist
            status.setzeInhalt("FERTIG");
            maxSeite=1;
            getMaxSeite();
            System.out.println(maxSeite+" Seite(n) (SelectionSort)");
            first();
            sorted = true;
        }
    }

    public void bQuickGeklickt()
    {
        status.setzeSchriftFarbe(10); // Status zeigt hier in der Farbe Rot an, das nun berechnet wird
        status.setzeInhalt("Berechne...");
        zeit.setzeInhalt("");
        if(sorted)
        {
            bubble.resetE();
            bubble.resetS();
            insertion.resetE();
            insertion.resetS();
            selection.resetE();
            selection.resetS();
            quick.resetE();
            quick.resetS();
            merge.resetE();
            merge.resetS();
        }
        if(test.inhaltAlsText()!="")
        {
            lastUsed = "quick";
            quick.quickSort(array, n);
            zeit.setzeInhalt("QuickSort:" + quick.time(array, n) + "ms"); // Ruft die Methode der Zeitberechnung auf und zeigt das Ergebniss an
            status.setzeSchriftFarbe(5); // Status zeigt hier in der Farbe Grün an, das die Sortierung abgeschlossen ist
            status.setzeInhalt("FERTIG");
            maxSeite=1;
            getMaxSeite();
            System.out.println(maxSeite+" Seite(n) (QuickSort)");
            first();
            sorted = true;
        }
    }
    
    public void bMergeGeklickt()
    {
        status.setzeSchriftFarbe(10); // Status zeigt hier in der Farbe Rot an, das nun berechnet wird
        status.setzeInhalt("Berechne...");
        zeit.setzeInhalt("");
        if(sorted)
        {
            bubble.resetE();
            bubble.resetS();
            insertion.resetE();
            insertion.resetS();
            selection.resetE();
            selection.resetS();
            quick.resetE();
            quick.resetS();
            merge.resetE();
            merge.resetS();
        }
        if(test.inhaltAlsText()!="")
        {
            lastUsed = "merge";
            merge.mergeSort(array, n);
            zeit.setzeInhalt("MergeSort:" + merge.time(array, n) + "ms"); // Ruft die Methode der Zeitberechnung auf und zeigt das Ergebniss an
            status.setzeSchriftFarbe(5); // Status zeigt hier in der Farbe Grün an, das die Sortierung abgeschlossen ist
            status.setzeInhalt("FERTIG");
            maxSeite=1;
            getMaxSeite();
            //System.out.println(maxSeite+" Seite(n) (MergeSort)");
            first();
            sorted = true;
        }
    }
    
    public void resetAndFillE()
    {
        if(lastUsed=="bubble")
        {bubble.resetE();}
        else if(lastUsed=="insertion")
        {insertion.resetE();}
        else if(lastUsed=="selection")
        {selection.resetE();}
        else if(lastUsed=="quick")
        {quick.resetE();}
        else if(lastUsed=="merge")
        {merge.resetE();}
        for(int i=1;i<20;i++)
        {
            if(lastUsed=="bubble")
            {
                bubble.e.geheZuPosition(i);
                bubble.schritte.geheZuPosition(19*(seite-1)+i);
                bubble.e.aktuelles().setzeInhalt(bubble.schritte.aktuelles());
            }
            else if(lastUsed=="insertion")
            {
                insertion.e.geheZuPosition(i);
                insertion.schritte.geheZuPosition(19*(seite-1)+i);
                insertion.e.aktuelles().setzeInhalt(insertion.schritte.aktuelles());
            }
            else if(lastUsed=="selection")
            {
                selection.e.geheZuPosition(i);
                selection.schritte.geheZuPosition(19*(seite-1)+i);
                selection.e.aktuelles().setzeInhalt(selection.schritte.aktuelles());
            }
            else if(lastUsed=="quick")
            {
                quick.e.geheZuPosition(i);
                quick.schritte.geheZuPosition(19*(seite-1)+i);
                quick.e.aktuelles().setzeInhalt(quick.schritte.aktuelles());
            }
            else if(lastUsed=="merge")
            {
                merge.e.geheZuPosition(i);
                merge.schritte.geheZuPosition(19*(seite-1)+i);
                merge.e.aktuelles().setzeInhalt(merge.schritte.aktuelles());
            }
            else
            {break;}
        }
    }

    public void getMaxSeite()
    {
        if(lastUsed=="bubble")
        {
            int i = 1;
            while(true)
            {
                if(bubble.schritte.laenge()>19*i)
                {
                    maxSeite+=1;
                    i+=1;
                }
                else
                {break;}
            }
        }
        else if(lastUsed=="insertion")
        {
            int i = 1;
            while(true)
            {
                if(insertion.schritte.laenge()>19*i)
                {
                    maxSeite+=1;
                    i+=1;
                }
                else
                {break;}
            }
        }
        else if(lastUsed=="selection")
        {
            int i = 1;
            while(true)
            {
                if(selection.schritte.laenge()>19*i)
                {
                    maxSeite+=1;
                    i+=1;
                }
                else
                {break;}
            }
        }
        else if(lastUsed=="quick")
        {
            int i = 1;
            while(true)
            {
                if(quick.schritte.laenge()>19*i)
                {
                    maxSeite+=1;
                    i+=1;
                }
                else
                {break;}
            }
        }
        else if(lastUsed=="merge")
        {
            int i = 1;
            while(true)
            {
                if(merge.schritte.laenge()>19*i)
                {
                    maxSeite+=1;
                    i+=1;
                }
                else
                {break;}
            }
        }
    }

    public void first()
    {	
        seite = 1;
        resetAndFillE();
    }

    public void previous()
    {
        if(seite>1)
        {
            seite -= 1;
            resetAndFillE();
        }
    }

    public void next()
    {
        if(seite<maxSeite)
        {
            seite += 1;
            resetAndFillE();
        }
    }

    public void last()
    {
        if(seite<maxSeite)
        {
            seite = r.gerundet(maxSeite);
            resetAndFillE();
        }
    }
}
