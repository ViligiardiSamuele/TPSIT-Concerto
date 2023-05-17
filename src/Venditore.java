public class Venditore extends Thread{
    private boolean libero;
    private int numBiglietti;
    

    public Venditore(String name) {
        super(name);
        this.libero = true;
        this.numBiglietti = 5;
    }
    
    public synchronized boolean acquistaBiglietto(){
        libero = false;
        numBiglietti--;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignoreException) {}
        System.out.println(Thread.currentThread().getName() + " ha comprato il biglietto");
        libero = true;
        return true;
    }
    public synchronized boolean restituisciBiglietto(Compratore compratore){
        libero = false;
        numBiglietti++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignoreException) {}
        System.out.println(compratore.getName() + " ha restituito il biglietto");
        libero = true;
        return true;
    }
    
    public boolean isLibero(){
        if(numBiglietti > 0)
            return libero;
        return false;
    }
}