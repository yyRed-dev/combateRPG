import java.util.Random;

public class Dados extends Classe{

    Armas arma;
    Magias magias;

    public Dados() {
        super("Default", 0, 0,0, Armas.acha);
    }

    // Rolar dados
    static int rolarD3() {
         Random rndm = new Random();
         return rndm.nextInt(3)+1;
    }

    static int rolarD4() {
         Random rndm = new Random();
         return rndm.nextInt(4)+1;
    }

    static int rolarD6() {
         Random rndm = new Random();
         return rndm.nextInt(6)+1;
    }

    static int rolarD8() {
         Random rndm = new Random();
         return rndm.nextInt(8)+1;
    }

    static int rolarD10() {
         Random rndm = new Random();
         return rndm.nextInt(10)+1;
    }

    static int rolarD12() {
         Random rndm = new Random();
         return rndm.nextInt(12)+1;
    }

    static int rolarD20() {
         Random rndm = new Random();
         return rndm.nextInt(20)+1;
    }


    // Causar danos
    static int rolarAtaque(Classe classe) {
        Random rndm = new Random();
        return rndm.nextInt(20) + 1 +  classe.getMod();
    }

    static int rolarDanoArma(Classe classe, Armas arma) {
        Random rndm = new Random();
        return rndm.nextInt(arma.getdanoArma()) + 1 + classe.getMod();
    }

    static int rolarDanoMagia(Magias magias) {
        Random rndm = new Random();
        return rndm.nextInt(magias.getdanoMagia()) * magias.getdadosDanoMagia();
    }
}