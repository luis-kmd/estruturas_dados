class AVL<T : Comparable<T>> : ArvoreAVL<T> {
    private var raiz: Node<T>? = null
    private fun altura(no: Node<T>?): Int = no?.altura ?: 0
    private fun balanceamento(no: Node<T>?): Int = altura(no?.esq) - altura(no?.dir)

    private fun rotacaoDireita(y: Node<T>): Node<T> {
        val x = y.esq!!
        y.esq = x.dir
        x.dir = y
        y.altura = maxOf(altura(y.esq), altura(y.dir)) + 1
        x.altura = maxOf(altura(x.esq), altura(x.dir)) + 1
        return x
    }

    private fun rotacaoEsquerda(x: Node<T>): Node<T> {
        val y = x.dir!!
        x.dir = y.esq
        y.esq = x
        x.altura = maxOf(altura(x.esq), altura(x.dir)) + 1
        y.altura = maxOf(altura(y.esq), altura(y.dir)) + 1
        return y
    }

    override fun insere(valor: T): Boolean {
        raiz = insereRec(raiz, valor) ?: return false
        return true
    }

    private fun insereRec(no: Node<T>?, valor: T): Node<T>? {
        if (no == null) return Node(valor)

        when {
            valor < no.info -> no.esq = insereRec(no.esq, valor)
            valor > no.info -> no.dir = insereRec(no.dir, valor)
            else -> return no // Não permite valores duplicados
        }

        no.altura = maxOf(altura(no.esq), altura(no.dir)) + 1
        return balancear(no)
    }

    override fun busca(valor: T): T? {
        var atual = raiz
        while (atual != null) {
            atual = when {
                valor < atual.info -> atual.esq
                valor > atual.info -> atual.dir
                else -> return atual.info
            }
        }
        return null
    }

    private fun balancear(no: Node<T>): Node<T> {
        val balance = balanceamento(no)

        return when {
            balance > 1 && balanceamento(no.esq) >= 0 -> rotacaoDireita(no) // Rotação simples direita
            balance > 1 -> {
                no.esq = rotacaoEsquerda(no.esq!!) // Rotação dupla esquerda-direita
                rotacaoDireita(no)
            }
            balance < -1 && balanceamento(no.dir) <= 0 -> rotacaoEsquerda(no) // Rotação simples esquerda
            balance < -1 -> {
                no.dir = rotacaoDireita(no.dir!!) // Rotação dupla direita-esquerda
                rotacaoEsquerda(no)
            }
            else -> no
        }
    }
}
