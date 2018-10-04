import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class AsemienValinta extends Metodit {
    Scanner skanneri = new Scanner(System.in);
    Metodit metodi = new Metodit();
    Main main = new Main();


    public void asemienValinta() { // Käyttäjä antaa junan lähtö- ja päämääräasemat. Metodi etsii kyseisellä välillä kulkevat junat.
        System.out.println("Syötä lähtöasema: ");
        String lähtöAsema = skanneri.nextLine();
        System.out.println("Syötä pääteasema: ");
        String pääteAsema = skanneri.nextLine();
        String lahtoasemanMuunto = syötetynLahtoasemanMuunto(lähtöAsema);
        String paateasemanMuunto = syötetynPaateasemanMuunto(pääteAsema);
        String lähtö = lähtöAsemanMuunto(lahtoasemanMuunto);
        String pääte = pääteAsemanMuunto(paateasemanMuunto);
        reitinHaku(lähtö, pääte);
        System.out.println(reitinHaku(lähtö, pääte));

        System.out.println("\n1. Tee haku uudestaan");
        System.out.println("2. Syötä halutun junan tunnus");
        System.out.println("3. Lopeta");
        String jatkonValinta = skanneri.nextLine();

        if (jatkonValinta.equals("1")){
            asemienValinta();
        }
        else if(jatkonValinta.equals("2")){
            metodi.junanValinta();
        }
        else if (jatkonValinta.equals("3")){
            System.out.println("Kiitos käynnistä!");
        }else{
            System.out.println("Lue ohjeet, urpo!");
            System.out.println("Paluu etusivulle kolmessa sekuntissa");
            try{
            Thread.sleep(3000);}
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            main.valitseAsemat();

        }
    }

    public String syötetynPaateasemanMuunto(String pääteAsema){
//        File file = new File ("asemat.properties");
        ResourceBundle rb = ResourceBundle.getBundle("asemat");
        if (rb.containsKey(pääteAsema)){
            return ""+ rb.getString(pääteAsema);
        }
        return ""+pääteAsema;
    }
    public String syötetynLahtoasemanMuunto(String lähtöAsema){
//        File file = new File ("asemat.properties");
        ResourceBundle rb = ResourceBundle.getBundle("asemat");
        if (rb.containsKey(lähtöAsema)){
            return ""+ rb.getString(lähtöAsema);
        }
        return ""+lähtöAsema;
    }

    public String lähtöAsemanMuunto(String lähtöAsema) {
        if (asemaLista == null) {
            lueAsemanJSONData(); }
        for (int i = 0; i < asemaLista.size(); i++) {
            if (lähtöAsema.equals(asemaLista.get(i).stationName)) {
                return asemaLista.get(i).stationShortCode;
            }
        }
        return null;
    }

    public String reitinHaku (String lähtö, String pääte) {
        List<Juna> junat = haeReitinJunat(lähtö, pääte);
        return junat.stream()
                .map(Juna::vainJunanTiedot)
                .collect(Collectors.joining("\n"));
/*
        for (int i = 0; i < junaLista.get(i).timeTableRows.size(); i++) {
            if (junaLista.get(i).timeTableRows.get(i).getStationShortCode().equals(lähtö)
                    && junaLista.get(i).timeTableRows.get(i).getStationShortCode().equals(pääte)) {
                return "" + junaLista.get(i).timeTableRows.get(i);
            }
        }
*/

    }

    public String pääteAsemanMuunto(String pääteAsema) {
        if (asemaLista == null) {
            lueAsemanJSONData(); }
        for (int i = 0; i < asemaLista.size(); i++) {
            if (pääteAsema.equals(asemaLista.get(i).stationName)) {
                return asemaLista.get(i).stationShortCode;
            }
        }
        return null;
    }




}

