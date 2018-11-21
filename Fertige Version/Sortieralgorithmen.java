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
    protected Liste<String> schritte;
    protected Liste<Etikett> e;

    // Attribute
    protected int seite = 1;
    protected int n;
    protected double t;
    protected double f;
    protected String step = "";

    // Konstruktor
    public Sortieralgorithmen()
    {
        schritte = new Liste<String>();
        e = new Liste<Etikett>();
        for(int i = 1; i<20; i++)
        {
            e.haengeAn(new Etikett(10,70+30*i,1200,25,""));
            e.zumEnde();
            e.aktuelles().setzeSchriftgroesse(20);
        }
        meineUhr = new Uhr();
    }

    // Dienste
    public void save()
    {
        step = "";
        for(int i=0;i<n;i++)
        {
            step = step+array[i];
            if(i<n-1)
            {step = step+", ";}
        }
        schritte.haengeAn(step);
    }
    
    public void resetS()
    {
        schritte.entferneAlleElemente();
    }

    public void resetE()
    {
        for(int i=1;i<20;i++)
        {
            e.geheZuPosition(i);
            e.aktuelles().setzeInhalt("");
        }
    }
    
    
    // Gibt Wert der gestoppten Zeit zurück
     
    public double time()
        {
            return (t);
        }
}
