import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Metodit{
    Scanner skanneri = new Scanner(System.in);



public void asemienValinta(){ // Käyttäjä antaa junan lähtö- ja päämääräasemat. Metodi etsii kyseisellä välillä kulkevat junat.
    System.out.println();

}
public void junanValinta (){
    System.out.println("Anna junan tunnus"); // Käyttäjä antaa junan tunnuksen, metodi hakee kyseisen junan tiedot.
    String junanTunnus = skanneri.nextLine();
//    System.out.println(juna.get(0).getTrainNumber());

    System.out.println(lueJunanJSONData(junanTunnus));



}
public void sijaintitiedot(){ // HC-suoritus! Esitetään graafisesti junan sijainti. Cool wow.

}





/*
Vaatii Jackson kirjaston:
File | Project Structure
Libraries >> Add >> Maven
Etsi "jackson-databind", valitse esimerkiksi versio 2.0.5
Asentuu Jacksonin databind, sekä core ja annotations
 */


        public String lueJunanJSONData(String junanTyyppi) {
            String baseurl = "https://rata.digitraffic.fi/api/v1";
            try {
                URL url = new URL(URI.create(String.format("%s/live-trains", baseurl)).toASCIIString());
                ObjectMapper mapper = new ObjectMapper();
                CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Juna.class);
                List<Juna> junat = mapper.readValue(url, tarkempiListanTyyppi);  // pelkkä List.class ei riitä tyypiksi
//                System.out.println(junat.get(1).getTrainNumber());
                // Seuraavaa varten on toteutettava TimeTableRow luokka:
                //System.out.println(junat.get(0).getTimeTableRows().get(0).getScheduledTime());
//                System.out.println("\n\n");
//                System.out.println(junat.get(1));

                for (int i = 0; i<junat.size(); i++){
                    String junanId = junat.get(i).getTrainType()+junat.get(i).getTrainNumber();
                    if (junanId.equals(junanTyyppi)) {
                        return "" + junat.get(i);
                    }
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }
            return "fuck this shit";
        }

    }






