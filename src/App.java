import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //creo i venditori
        List<Venditore> ventitori = new ArrayList<Venditore>();
        for (int i = 0; i < 3; i++)
            ventitori.add(new Venditore("Venditore " + (i+1)));

        //creo "botteghino" e gli assegno i venditori
        Botteghino botteghino = new Botteghino(ventitori);

        //creo i compratori e gli assegno la risorsa
        List<Compratore> compratori = new ArrayList<Compratore>();
        for (int i = 0; i < 30; i++)
            compratori.add(new Compratore("Compratore " + (i+1), botteghino));

        for(Venditore v : ventitori)
            v.start();
        for(Compratore c : compratori)
            c.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignoreException) {}

        //valore random tra 0 e 29 (estremi inclusi)
        int rand = (int) (Math.random() * 30);
        compratori.get(rand).restituisciBiglietto(compratori.get(rand));
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignoreException) {}
        for(Venditore v : ventitori)
            v.interrupt();
        for(Compratore c : compratori)
            c.interrupt();
        System.exit(0);
    }
}
