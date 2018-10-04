import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        valitseAsemat();
//
    }

    public static void valitseAsemat(){         // Valikko. Käyttäjä valitsee toiminnon. Väärän numeron syöttäminen johtaa paluuseen.
        Metodit metodi = new Metodit();
        AsemienValinta valinta = new AsemienValinta();
        System.out.println(
                "                 _-====-__-======-__-========-_____-============-__\n" +
                "               _(                                                 _)\n" +
                "            OO(      •._.••´¯``•.¸¸.•`TERVETULOA`•.¸¸.•´´¯`••._.•     )_\n" +
                "           0  (_                                                   _)\n" +
                "         o0     (_                                                _)\n" +
                "        o         '=-___-===-_____-========-___________-===-----='\n" +
                "      .o                                _________\n" +
                "     . ______          ______________  |         |      _____\n" +
                "   _()_||__|| ________ |            |  |_________|   __||___||__\n" +
                "  (   VR    | |      | |            | __Y______00_| |_         _|\n" +
                " /-OO----OO\"\"=\"OO--OO\"=\"OO--------OO\"=\"OO-------OO\"=\"OO-------OO\"=P\n" +
                "#####################################################################");

        System.out.println("   ______________________________\n" +
                " / \\                             \\.\n" +
                "|   |                            |.\n" +
                " \\_ |                            |.\n" +
                "    |      Valitse luku 1-3      |.\n" +
                "    |                            |.\n" +
                "    | 1. Hae asemien perusteella |.\n" +
                "    | 2. Hae junan perusteella   |.\n" +
                "    | 3. Lopeta                  |.\n" +
                "    |                            |.\n" +
                "    |                            |.\n" +
                "    |                            |.\n" +
                "    |                            |.\n" +
                "    |                            |.\n" +
                "    |                            |.\n" +
                "    |   _________________________|___\n" +
                "    |  /                            /.\n" +
                "    \\_/____________________________/.");
        Scanner skanneri = new Scanner(System.in);
        String luku = skanneri.nextLine();
        if (luku.equals("1")) {
            valinta.asemienValinta();
        }
        else if (luku.equals("2")){
            metodi.junanValinta();
        }
        else if (luku.equals("3")){
            System.out.println("Kiitti moi");
        }else{
            System.out.println("Virheellinen syöte, valitse numero 1-3");
            System.out.println("Paluu etusivulle kolmessa sekuntissa");
            try{
                Thread.sleep(3000);}
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            valitseAsemat();

        }

        }
    }
