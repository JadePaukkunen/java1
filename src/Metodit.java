import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import javax.print.DocFlavor;
import java.net.URI;
import java.net.URL;
import java.util.*;


public class Metodit {
    Scanner skanneri = new Scanner(System.in);
    List<Juna> junaLista;
    List<Asema> asemaLista;
    List<TimeTableRow> timeTableRows;


    public List<Juna> lueJunanJSONData() {
        String baseurl = "https://rata.digitraffic.fi/api/v1";
        try {
            URL url = new URL(URI.create(String.format("%s/live-trains", baseurl)).toASCIIString());
            ObjectMapper mapper = new ObjectMapper();
            CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Juna.class);
            junaLista = mapper.readValue(url, tarkempiListanTyyppi);
            return junaLista;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Juna> haeReitinJunat(String lahto, String maara) {
        String baseurl = "https://rata.digitraffic.fi/api/v1";
        try {
            URL url = new URL(URI.create(String.format("%s/live-trains/station/%s/%s", baseurl, lahto, maara)).toASCIIString());
            ObjectMapper mapper = new ObjectMapper();
            CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Juna.class);
            List<Juna> junaLista = mapper.readValue(url, tarkempiListanTyyppi);
            return junaLista;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public List<Asema> lueAsemanJSONData() {
        String baseurl = "https://rata.digitraffic.fi/api/v1";
        try {
            URL url = new URL(URI.create(String.format("%s/metadata/stations", baseurl)).toASCIIString());
            ObjectMapper mapper = new ObjectMapper();
            CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Asema.class);
            asemaLista = mapper.readValue(url, tarkempiListanTyyppi);
            return asemaLista;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }




    public void junanValinta() {
        System.out.println("Anna junan tunnus: "); // Käyttäjä antaa junan tunnuksen, metodi hakee kyseisen junan tiedot.
        String junanTunnus = skanneri.nextLine();
//        lueJunanJSONData().toString();
        //lueJunanJSONData().indexOf(1);
        String käyttäjänHakemaJuna = junanHaku(junanTunnus);
        System.out.println(käyttäjänHakemaJuna);

    }

    public void sijaintitiedot() { // HC-suoritus! Esitetään graafisesti junan sijainti. Cool wow.

    }

    public String junanHaku(String junanTyyppi) {
        if (junaLista == null) {
            lueJunanJSONData();
        }
        for (int i = 0; i < junaLista.size(); i++) {
            String junanId = junaLista.get(i).getTrainType() + junaLista.get(i).getTrainNumber();
            if (junanId.equals(junanTyyppi)) {
                return "" + junaLista.get(i);
            }
        }
                return "";

    }

    public String asemienYhdistäminen(final String stationShortCode) {
        if (asemaLista == null) {
            lueAsemanJSONData();
        }

        Optional<String> nimi = asemaLista
                .parallelStream()
                .filter(a->a.getStationShortCode().equals(stationShortCode))
                .map(Asema::getStationName)
                .findFirst();
        return nimi.orElse("Tuntematon");

/*
        for(Asema a : asemaLista) {
            if (a.getStationShortCode().equals(stationShortCode)) {
                return a.getStationName();
            }
        }
        return "Tuntematon";
*/
    }
}






