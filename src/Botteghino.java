import java.util.List;

public class Botteghino {
    List<Venditore> venditori;

    public Botteghino(List<Venditore> venditori) {
        this.venditori = venditori;
    }

    public Venditore getVenditoreLibero(){
        //la ricerca di un venditore libero si fermerà solo
        //quando sara ritornato un venditore libero
        while(true)
            for(Venditore v : venditori){
                if(v.isLibero())
                    return v;
            }
    }
}