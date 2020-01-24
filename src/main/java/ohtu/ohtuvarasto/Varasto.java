package ohtu.ohtuvarasto;

/**
 * Luokka edustaa varastoa.  
 */
public class Varasto {

    // --- piilotettu tietorakenteen toteutus: ---
    private double tilavuus;  // paljonko varastoon mahtuu,  > 0
    private double saldo;     // paljonko varastossa on nyt, >= 0

    // --- konstruktorit: ---
    /**
    * Metodi on konstruktori.  
    */
    public Varasto(double tilavuus) {  // tilavuus on annettava
        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
        } else {
            this.tilavuus = 0.0;  // => käyttökelvoton varasto
        }
        saldo = 0;     // oletus: varasto on tyhjä
    }

    /**
    * Metodi on konstruktori.  
    */
    public Varasto(double tilavuus, double alkuSaldo) { // kuormitetaan
        asetaTilavuusKonstruktoriin(tilavuus);

        if (alkuSaldo < 0.0) {
            this.saldo = 0.0;
        } else if (alkuSaldo <= tilavuus) { // mahtuu        
            this.saldo = alkuSaldo;
        } else {
            this.saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }

    public void asetaTilavuusKonstruktoriin(double tilavuus) {
        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
        } else { //virheellinen, nollataan
            this.tilavuus = 0.0;  // => käyttökelvoton varasto
        }
    }

    // --- ottavat aksessorit eli getterit: ---
    /**
    * Metodi palauttaa saldon.  
    */
    public double getSaldo() {
        return saldo;
    }

    /**
    * Metodi palauttaa tilavuuden.  
    */
    public double getTilavuus() {
        return tilavuus;
    }

    /**
    * Metodi kertoo kuinka paljon varastoon mahtuu.  
    */
    public double paljonkoMahtuu() {  // huom: ominaisuus voidaan myös laskea
        return tilavuus - saldo;        //  ei tarvita erillistä kenttää vielaTilaa tms.
    }

    // --- asettavat aksessorit eli setterit: ---
    /**
    * Metodi lisää varastoon parametrina annetun määrän.  
    */
    public void lisaaVarastoon(double maara) {
        if (maara < 0) {// virhetilanteessa voidaan tehdä 
            return;       // tällainen pikapoistuminenkin!
        }
        if (maara <= paljonkoMahtuu()) { // omia aksessoreita voi kutsua
            saldo = saldo + maara;          // ihan suoraan sellaisinaan
        } else {
            saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }

    /**
    * Metodi ottaa varastosta parametrina olevan määrän.  
    */
    public double otaVarastosta(double maara) {
        if (maara < 0) { // virhetilanteessa voidaan tehdä 
            return 0.0;   // tällainen pikapoistuminenkin!
        }
        if (maara > saldo) {          // annetaan mitä voidaan
            double kaikkiMitaVoidaan = saldo;
            saldo = 0.0;               // ja tyhjäksi menee
            return kaikkiMitaVoidaan;  // poistutaan saman tien
        }
        // jos tänne päästään, kaikki pyydetty voidaan antaa
        saldo = saldo - maara;  // vähennetään annettava saldosta
        return maara;
    }

    // --- Merkkijonoesitys Varasto-oliolle: ----
    /**
    * Metodi palauttaa merkkijonoesityksen Varasto-oliolle.  
    */
    public String toString() {
        return ("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
    }
}