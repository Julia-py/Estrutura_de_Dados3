package Arvore;

public class Nodo {
    int valor;
    Nodo esquerdo;
    Nodo direito;

    public Nodo(int valor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getDireito() {
        return direito;
    }

    public void setDireito(Nodo direito) {
        this.direito = direito;
    }

    public Nodo getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(Nodo esquerdo) {
        this.esquerdo = esquerdo;
    }
}
