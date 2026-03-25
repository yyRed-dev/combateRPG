import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main (String[] args) {
        
        int rodada = 1;

        System.out.println("Bem vindo ao Simulador de Batalhas!\n");
        System.out.println("Para começar, selecione sua classe:");
        System.out.println("1. Barbaro \n2. Druida \n3. Ladino \n4. Mago \n5. Ranger");

        int classeProta = sc.nextInt();

        Random rnd = new Random();
        int classeInimigo = rnd.nextInt(5)+1;

        Classe prota = Classe.escolherClasse(classeProta);
        Classe inimigo = Classe.escolherClasse(classeInimigo);

        System.out.println("\nSua Classe: " + prota.getnomeClasse());
        System.out.println("Classe do seu Adversario: " + inimigo.getnomeClasse());
        
        System.out.println("\n");

        String[] iniciativa = jogarIniciativa(prota, inimigo);

        System.out.println("Teste dano das Magias\n");

        System.out.println("Espada Magica: " + danoMagico(Magias.espadaMagica));
        System.out.println("Cuspe Acido: " + danoMagico(Magias.cuspeAcido));
        System.out.println("Raio Congelante: " + danoMagico(Magias.raioCongelante));
        System.out.println("Bola de Fogo: " + danoMagico(Magias.bolaDeFogo));



        // para aqui
        while (prota.getHp() > 0 && inimigo.getHp() > 0) {

            System.out.println("Rodada atual: " + rodada+"\n");

            ataquesRodada(prota, inimigo, iniciativa);
            System.out.println("Fim da rodada " + rodada +"\n-----------------\n");
            rodada++;
        }

        quemGanhou(prota, inimigo);
        

    }

    // METODOS !

    // Iniciativa
    static String[] jogarIniciativa(Classe prota, Classe inimigo) {
        String[] iniciativa = new String[2];

        int iniciativaProta = Dados.rolarD20() + prota.getMod();
        int iniciativaInimigo = Dados.rolarD20() + inimigo.getMod();

        if (iniciativaProta > iniciativaInimigo) {
            iniciativa[0] = "prota";
            iniciativa[1] = "inimigo";
        } else if (iniciativaInimigo > iniciativaProta) {
            iniciativa[0] = "inimigo";
            iniciativa[1] = "prota";
        } else if (iniciativaInimigo == iniciativaProta) {
            iniciativaProta = Dados.rolarD20() + prota.getMod();
            iniciativaInimigo = Dados.rolarD20() + inimigo.getMod();
        }
        
        return iniciativa;
    }


    // metodo teste para rodada de porrada normal
    static void ataquesRodada(Classe prota, Classe inimigo, String[] iniciativa) {

        for (int i=0; i < 2; i++) {

            if (iniciativa[0].equals("prota")) {

                ataqueProta(prota, inimigo);
                if (inimigo.getHp() == 0) {
                    return;
                }

                ataqueInimigo(inimigo, prota);
                if (prota.getHp() == 0) {
                    return;
                }

            } else {
                ataqueInimigo(inimigo, prota);

                if (prota.getHp() == 0) {
                    return;
                }

                ataqueProta(prota, inimigo);
                if (inimigo.getHp() == 0) {
                    return;
                }
            }
        }
    }


    // Ataque jogador
    static int ataqueProta(Classe prota, Classe inimigo) {
        int x = Dados.rolarAtaque(prota);
        System.out.println("Voce tirou um " + x + " no seu ataque!");

        int dano = 0;

        if (x >= inimigo.getDef()) {
            System.out.println("Voce acertou o ataque!");

            dano = Dados.rolarDanoArma(prota, prota.getArma());
            System.out.println("Ele sofre " + dano + " pontos de dano de " + prota.getArma().gettipoDano());
            inimigo.setHp(inimigo.getHp() - dano);

            if (inimigo.getHp() < 0) {
                inimigo.setHp(0);
            }

            System.out.println("A vida do seu adversario e: " +inimigo.getHp());
        } else {
            System.out.println("Voce errou o ataque...");
        }

        System.out.println("\n");

        return dano;
    }


    // Ataque inimigo
    static int ataqueInimigo(Classe inimigo, Classe prota) {

        int y = Dados.rolarAtaque(inimigo);
        System.out.println("Teste ataque inimigo: " + y);

        int dano = 0;

        if (y >= prota.getDef()) {
            System.out.println("Ele acertou o Ataque!");

            dano = Dados.rolarDanoArma(inimigo, inimigo.getArma());
            System.out.println("Voce sofre " + dano + " pontos de dano de " + inimigo.getArma().gettipoDano());
            prota.setHp(prota.getHp() - dano);

            if (prota.getHp() < 0) {
                prota.setHp(0);
            }

            System.out.println("A sua vida e: " + prota.getHp());

        } else {
            System.out.println("Ele errou o Ataque!\n");
        }

        System.out.println("\n");

        return dano;
    }


    // Anunciar vencedor
    static int quemGanhou(Classe prota, Classe inimigo) {

        if (prota.getHp() <= 0) {
            System.out.println("\nSua vida chegou a 0, voce perdeu...");
        }
        
        if (inimigo.getHp() <= 0) {
            System.out.print("\nA vida de seu adversario chegou a 0! Voce ganhou!");
        }
        
        return 0;
    }


    // Causar dano magias
    static int danoMagico(Magias magia) {

    if (magia.getdanoMagia() == 0) {
        return 0;
    }

    Random rnd = new Random();
    int total = 0;

    for (int i = 0; i < magia.getdadosDanoMagia(); i++) {
        total += rnd.nextInt(magia.getdanoMagia()) + 1;
    }

    return total;
}



} //final da Main