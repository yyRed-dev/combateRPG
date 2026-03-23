import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main (String[] args) {
        
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

        int x = Dados.rolarAtaque(prota);
        System.out.println("Teste ataque prota: " + x);
        if (x >= inimigo.getDef()) {
            System.out.println("Voce acertou o Ataque!");
            
            int dano = Dados.rolarDanoArma(prota, prota.getArma());
            System.out.println("Ele sofre " + dano + " pontos de dano de " + prota.getArma().gettipoDano());

        } else {
            System.out.println("Voce errou o Ataque!\n");
        }

        System.out.println("\n");

        int y = Dados.rolarAtaque(inimigo);
        System.out.println("Teste ataque inimigo: " + x);
        if (y >= inimigo.getDef()) {
            System.out.println("Ele  acertou o Ataque!");
            
            int dano = Dados.rolarDanoArma(inimigo, inimigo.getArma());
            System.out.println("Voce sofre " + dano + " pontos de dano de " + inimigo.getArma().gettipoDano());

        } else {
            System.out.println("Ele errou o Ataque!\n");
        }
    }
}