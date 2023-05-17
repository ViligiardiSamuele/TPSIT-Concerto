public class Compratore extends Thread{
    private Botteghino botteghino;

    public Compratore(String nome, Botteghino botteghino){
        super(nome);
        this.botteghino = botteghino;
    }

    @Override
    public void run() {
        boolean bigliettoDaComprare = true;
        while(bigliettoDaComprare)
            if(botteghino.getVenditoreLibero().acquistaBiglietto())
                bigliettoDaComprare = false;
            else bigliettoDaComprare = true;
    }

    public void restituisciBiglietto(Compratore compratore){
        boolean bigliettoDaRestituire = true;
        while(bigliettoDaRestituire)
            if(botteghino.getVenditoreLibero().restituisciBiglietto(compratore))
                bigliettoDaRestituire = false;
            else bigliettoDaRestituire = true;

    }

    public Botteghino getBotteghino() {
        return botteghino;
    }
}
