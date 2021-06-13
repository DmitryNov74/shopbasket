import java.text.DecimalFormat;
import java.util.*;

public class TryInherit extends Tuote{

    LinkedList<Tuote>koris = new LinkedList<>();

    public TryInherit(String nimi, int kpl, double hinta,String kuvaus) {
        super(nimi, kpl, hinta,kuvaus);
    }

    public void lisaaTuote(){
        Scanner input = new Scanner(System.in);
        System.out.println("anna nimi");
        String nimi = input.next();

        System.out.println("anna määrä");
        int kpl = input.nextInt();

        System.out.println("anna hinta");
        double hinta = input.nextDouble();

        input.nextLine();

        System.out.println("kuvaus:");
        String kuvaus = input.nextLine();

        Tuote tuote = new Tuote(nimi,kpl,hinta,kuvaus);
        koris.add(tuote);
    }


    public void naytaKaikki(){
        System.out.println(ThreadColor.ANSI_BLUE +"---RUOKAKORISSASI ON:----");
        ListIterator<Tuote>it = koris.listIterator();
        if (it.hasNext()){
            for (int i = 0; i < koris.size();i ++){
                Tuote tuote = koris.get(i);

                double yhteensa =  hintaYhteensa(tuote.getHinta(), tuote.getKpl());


                System.out.println( tuote.getNimi().toUpperCase(Locale.ROOT));
                System.out.println("määrä: " + tuote.getKpl());
                System.out.println("hinta: " + tuote.getHinta());
                System.out.println("kuvaus: " + tuote.getKuvaus());

                DecimalFormat des = new DecimalFormat("0.00");
                System.out.println(des.format(yhteensa) + " euroa");
                
            }
        }else {
            System.out.println( "kori on tyhjä");

        }
        System.out.println("--------------------");

    }

    public void poistaTuote(){

        Scanner input = new Scanner(System.in);
        ListIterator<Tuote>it = koris.listIterator();

        for (int i = 0;i < koris.size();i ++){
            Tuote tuote = koris.get(i);
            System.out.println("nimi " + tuote.getNimi());

        }

        System.out.println("mitä poistetaan ?");
        String poista = input.next();

        for (int i = 0;i < koris.size();i ++ ){
            Tuote tuote = koris.get(i);
            if (tuote.getNimi().equals(poista)){
                koris.remove(i);
            }
        }
        // lisätään iterator onko korissa tavaraa vai ei


        if (!it.hasNext()){
            System.out.println("korissa ei ole tuotteita");
        }

    }


    public double hintaYhteensa(double hinta, int kpl){

        return hinta * kpl;
    }


    public static void main(String[] args) {

        TryInherit olio = new TryInherit("nimi",2,2,"kuvaus");


        Scanner input = new Scanner(System.in);


        int valinta = -1;

        do {
            System.out.println("1 = lisää ; 2 = näytä ; 3 = poista");
            valinta = input.nextInt();

            if (valinta == 1){
                olio.lisaaTuote();
            }else if(valinta == 2){
                olio.naytaKaikki();

            }else if(valinta == 3){
                olio.poistaTuote();

            }
        }while (valinta != 0);

    }


}

class ThreadColor{
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PUR = "\u001B[35m";
    public static final String ANSI_GRAY = "\u001B[37m";
}
