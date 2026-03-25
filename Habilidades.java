public class Habilidades {

    private boolean furia;
    private int furiaRodadas;

    private boolean habil;


    private boolean ataqueFurtivo;


    private boolean conjurador;


    private boolean maosAgeis;

// ----------------------------- O que cada Habilidade faz -----------------------------
//
// Furia = +2 dano fisico e danos fisicos (Corte, Impacto e Perfuração) sofridos são /2
// Habil = Consegue usar "Truques"
// Atk furtivo = +2d6 de dano ao atacar c Arma
// Conjurador = Consegue conjurar "Magias"
// Mãos Ageis = Atira sempre 2 flechas por ação (+50% dano)
//
// -------------------------------------------------------------------------------------

    public Habilidades(boolean furia, boolean habil, boolean ataqueFurtivo, boolean conjurador, boolean maosAgeis) {
        this.furia = furia;
        this.habil = habil;
        this.ataqueFurtivo = ataqueFurtivo;
        this.conjurador = conjurador;
        this.maosAgeis = maosAgeis;
    }

    //FURIA

    // Ligar a furia
    public void ativarFuria() {
        this.furia = true;
        this.furiaRodadas = 3;
    }

    // Atualizar a Furia e reduzir a duração dela
    public void atualizarFuria() {
        if (furia) {
            furiaRodadas--;
        }

        if (furiaRodadas <= 0) {
            furia = false;
            System.out.println("A Furia chegou ao fim!");
        }
    }

    // Verificar se ta brabo
    public boolean estaEmFuria () {
        return furia;
    }


    //HABIL


    //ATK FURTIVO
    public void verificarClasse() {

    }

    // Dano extra


    //CONJURADOR

    
    //MÃOS AGEIS

}