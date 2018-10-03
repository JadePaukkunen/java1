import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class AsemienValinta extends Metodit {
    Scanner skanneri = new Scanner(System.in);


    public void asemienValinta() { // Käyttäjä antaa junan lähtö- ja päämääräasemat. Metodi etsii kyseisellä välillä kulkevat junat.
        System.out.println("Syötä lähtöasema: ");
        String lähtöAsema = skanneri.nextLine();
        System.out.println("Syötä pääteasema: ");
        String pääteAsema = skanneri.nextLine();
        String lähtö = lähtöAsemanMuunto(lähtöAsema);
        String pääte = pääteAsemanMuunto(pääteAsema);
        reitinHaku(lähtö, pääte);
        System.out.println(reitinHaku(lähtö, pääte));
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

