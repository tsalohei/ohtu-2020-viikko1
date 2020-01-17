package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void toStringMetodiToimii() {
        String str1 = "saldo = 0.0, vielä tilaa 10.0";
        String str2 = varasto.toString();
        //assertEquals(str1, str2);
        //TESTIMUUTOS
        assertEquals(1,2);
    }
    
    @Test
    public void varastostaYritetaanOttaaEnemmanMitaSaldoa() {
        varasto.lisaaVarastoon(7);
        assertEquals(7, varasto.otaVarastosta(300), vertailuTarkkuus);
    }
    
    @Test
    public void varastostaYritetaanOttaaNegatiivinenMaara() {
        varasto.otaVarastosta(-3);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void varastoonLaitetaanLiikaaTavaraa() {
        varasto.lisaaVarastoon(12);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void varastoonYritetaanLisataNegatiivinenMaara() {
        varasto.lisaaVarastoon(-3);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void kontruktoriLuoVarastonJonkaAlkusaldoIsompiKuinTilavuus() {
        Varasto testiVarasto = new Varasto(2, 3);
        assertEquals(2, testiVarasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(2, testiVarasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoVarastonJonkaTilavuusPosJaAlkusaldoNeg() {
        Varasto testiVarasto = new Varasto(2,-1);
        assertEquals(2, testiVarasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, testiVarasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test //luotu varasto tilavuus 0, alkusaldo -2 ei ole kauhean järkevä
    public void konstruktoriLuoVarastonJonkaTilavuusNegJaAlkusaldoPos() {
        Varasto testiVarasto = new Varasto(-2,1);
        assertEquals(0, testiVarasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(-2, testiVarasto.getSaldo(), vertailuTarkkuus);
        
    }
    
    @Test
    public void konstruktoriLuoVarastonJonkaTilavuusJaAlkusaldoJarkevat() {
        Varasto testiVarasto = new Varasto(2,1);
        assertEquals(2, testiVarasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(1, testiVarasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoVarastonJonkaTilavuusNegatiivinen() {
        Varasto testiVarasto = new Varasto(-2);
        assertEquals(0, testiVarasto.getSaldo(), vertailuTarkkuus);
    }
    //*****
    
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

}