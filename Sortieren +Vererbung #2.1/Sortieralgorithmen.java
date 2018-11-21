import sum.strukturen.*;
import sum.komponenten.*;
import sum.werkzeuge.*;
/**
 * @author 
 * @version 
 */
public class Sortieralgorithmen
{
    // Bezugsobjekte
    Uhr meineUhr;
    protected int [] array;
    protected Liste<Etikett> e;

    // Attribute
    protected int zeile = 1;
    protected double t;
    protected double f;
    protected String inhalt = "";

    // Konstruktor
    public Sortieralgorithmen()
    {
        e = new Liste<Etikett>();
        meineUhr = new Uhr();
    }

    // Dienste
    public String getArray()
    {
        inhalt = "";
        for(int i = 0; i < array.length; i++)
        {
            inhalt = inhalt+array[i];
            if(i<array.length-1)
            {inhalt = inhalt+", ";}
        }
        return inhalt;
    }
    
    //Das Array wird als Zahlenkette auf dem Bildschirm dargestellt

    public void println()
    {
        zeile += 1;
        e.haengeAn(new Etikett(10,50+zeile*30,990,25,getArray()));
        e.geheZuPosition(e.laenge());
        e.aktuellesElement().setzeSchriftgroesse(20);
    }

    public void deleteln() //löscht alle Sortierschritte
    {
        for (int i = 1; i<=e.laenge(); i++)
        {
            e.geheZuPosition(i);
            e.aktuellesElement().setzeInhalt("");
        }
        zeile = 1;
    }
    
    
    /*Gibt Wert der gestoppten Zeit zurück
    */ 
    public double time()
        {
            return (t);
        }
}
