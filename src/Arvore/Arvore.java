package Arvore;

import java.util.Stack;

// remover
/* folha
-o pai aponta para null;
* 1 filho
* - deixar o filho no lugar dele
* 2 filhos
 - procurar o sucessor, o número maior
 - o filho fica no seu lugar
 - */
public class Arvore {
    Nodo raiz;

    public Arvore() {
        raiz = null;
    }

    public void adicionar(int valor){
        raiz = adicionarRec(raiz, valor);
    }
    public boolean buscar(int valor){
        return buscarRec(raiz, valor);
    }
    public void remover(int valor){
        raiz = removerRec(raiz, valor);
    }


    private Nodo adicionarRec( Nodo atual, int valor){
        if (atual == null){
            return new Nodo(valor);
        }
        if (valor < atual.valor){
            atual.esquerdo = adicionarRec(atual.esquerdo, valor);
        }else if (valor > atual.valor){
            atual.direito = adicionarRec(atual.direito, valor);
        }
        return atual;
    }

    private boolean buscarRec(Nodo atual, int valor){
        if(atual == null){
            return false;
        }
        if (valor == atual.valor){
            return true;
        }
        if(valor < atual.valor){
            return buscarRec(atual.esquerdo, valor);
        } else {
            return buscarRec(atual.direito, valor);
        }
   }

   private Nodo removerRec(Nodo atual, int valor) {
        if (atual == null){
            return null;
        }
        if (valor < atual.valor) {
            atual.esquerdo = removerRec(atual.esquerdo, valor);
        }else if(valor > atual.valor){
            atual.direito = removerRec(atual.direito, valor);
        }else {
            // sem filhos(folha)
            if(atual.esquerdo == null && atual.direito == null){
                return null;
            }
            //um filho
            if (atual.esquerdo == null){
                return atual.direito;
            }
            if (atual.direito == null) {
                return atual.esquerdo;
            }
            // dois filhos
            int menorValor = menorvalor(atual.direito);
            atual.valor = menorValor;
            atual.direito = removerRec(atual.direito, menorValor);// aqui acha o maior valor e troca

        }
        return atual;
   }

   private int menorvalor(Nodo nodo){
        int menor = nodo.valor;

        while(nodo.esquerdo != null){ // o lado esquerdo sempre tá o menor valor
            menor = nodo.esquerdo.valor;
            nodo = nodo.esquerdo;
        }
        return menor;
   }

    //1. raiz --> 2.Esquerda --> 3. direita
    // Print -> anda
    public void PreOrdem(){
        preOrdemR(raiz);
    }
    private void preOrdemR(Nodo atual){
        if (atual!= null){
            System.out.println(atual.valor + " ");
            preOrdemR(atual.esquerdo);
            preOrdemR(atual.direito);
        }
    }

    // 1.Esquerda -> 2. raiz -> 3.Direita
    //Anda -> imprimi
    public void EmOrdem(){
        emOrdemR(raiz);
    }
    private void emOrdemR(Nodo atual){
        if(atual != null){
            emOrdemR(atual.esquerdo);
            System.out.println(atual.valor + " ");
            emOrdemR(atual.direito);
        }
    }
    //1.Esquerda -> 2. direita -> 3. raiz
    public void PosOrdem(){
    posOrdemR(raiz);
    }
    private void posOrdemR(Nodo atual){
        if (atual != null){
           posOrdemR(atual.esquerdo);
           preOrdemR(atual.direito);
           System.out.println(atual.valor +" ");
        }
    }

   public void imprimir(){
        imprimirRec(raiz, "", true);

   }
   private void imprimirRec (Nodo nodo, String prefixo, boolean isLetf) {
        if(nodo!= null) {
            System.out.println(prefixo + (isLetf ? "|- " : "'-- " ) + nodo.valor);
            imprimirRec(nodo.esquerdo, prefixo + (isLetf ? "|  " : "  "), true);
            imprimirRec(nodo.direito, prefixo + (isLetf ? "|  " : "  "), false);

        }
   }
}
