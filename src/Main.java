import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Juna juna = new Juna();
        Metodit metodi = new Metodit();
        valitseAsemat();
    }

    public static void valitseAsemat(){
        Metodit metodi = new Metodit();
        System.out.println("Valitse luku 1-4");
        System.out.println("1. Hae asemien perusteella");
        System.out.println("2. Hae junan tunnuksen perusteella");
        System.out.println("3. Hae paikkatietojen mukaan (ehkä)");
        System.out.println("4. Lopeta");
        Scanner skanneri = new Scanner(System.in);
        int luku = Integer.parseInt(skanneri.nextLine());
        if (luku == 1){
            metodi.asemanValinta();
        }
        else if (luku == 2){
            metodi.junanValinta();
        }
        else if (luku ==3){
            metodi.sijaintitiedot();
        }
        else if (luku ==4){
            System.out.println("Kiitti moi");
        }else{
            System.out.println("Virheellinen luku. Valitse luku 1-4");
            valitseAsemat();
        }
    }
}
