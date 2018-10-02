import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        valitseAsemat();
//
    }

    public static void valitseAsemat(){         // Valikko. Käyttäjä valitsee toiminnon. Väärän numeron syöttäminen johtaa paluuseen.
        Metodit metodi = new Metodit();
        System.out.println("Valitse luku 1-4");
        System.out.println("1. Hae asemien perusteella");
        System.out.println("2. Hae junan tunnuksen perusteella");
        System.out.println("3. Hae paikkatietojen mukaan (ehkä)");
        System.out.println("4. Lopeta");
        Scanner skanneri = new Scanner(System.in);
        String luku = skanneri.nextLine();
        if (luku.equals("1")) {
            metodi.asemienValinta();
        }
        else if (luku.equals("2")){
            metodi.junanValinta();
        }
        else if (luku.equals("3")){
            metodi.sijaintitiedot();
        }
        else if (luku.equals("4")){
            System.out.println("Kiitti moi");
        }else{
            System.out.println("Virheellinen syöte, valitse numero 1-4");
            valitseAsemat();
        }

        }
    }
