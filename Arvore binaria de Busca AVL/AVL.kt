class AVL<T : Comparable<T>> : ArvoreAVL<T> {
    private var raiz: Node<T>? = null

    // Retorna altura do nó
    private fun altura(no: Node<T>?): Int = no?.altura ?: 0

    // Obtém o fator de balanceamento
    private fun balanceamento(no: Node<T>?): Int = altura(no?.esq) - altura(no?.dir)

    // Rotação à direita
    private fun rotacaoDireita(y: Node<T>): Node<T> {
        val x = y.esq!!
        y.esq = x.dir
        x.dir = y
        y.altura = maxOf(altura(y.esq), altura(y.dir)) + 1
        x.altura = maxOf(altura(x.esq), altura(x.dir)) + 1
        return x
    }

    // Rotação à esquerda
    private fun rotacaoEsquerda(x: Node<T>): Node<T> {
        val y = x.dir!!
        x.dir = y.esq
        y.esq = x
        x.altura = maxOf(altura(x.esq), altura(x.dir)) + 1
        y.altura = maxOf(altura(y.esq), altura(y.dir)) + 1
        return y
    }

    // Insere um valor na árvore
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

    // Busca um valor na árvore
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

    // Remove um valor da árvore
    override fun remove(valor: T): Boolean {
        if (busca(valor) == null) return false
        raiz = removeRec(raiz, valor)
        return true
    }

    private fun removeRec(no: Node<T>?, valor: T): Node<T>? {
        if (no == null) return null

        when {
            valor < no.info -> no.esq = removeRec(no.esq, valor)
            valor > no.info -> no.dir = removeRec(no.dir, valor)
            else -> {
                // Caso 1: Nó sem filhos
                if (no.esq == null && no.dir == null) return null
                // Caso 2: Nó com um único filho
                if (no.esq == null) return no.dir
                if (no.dir == null) return no.esq
                // Caso 3: Nó com dois filhos
                val sucessor = menorValor(no.dir!!)
                no.info = sucessor.info
                no.dir = removeRec(no.dir, sucessor.info)
            }
        }

        no.altura = maxOf(altura(no.esq), altura(no.dir)) + 1
        return balancear(no)
    }

    // Retorna o menor valor da subárvore
    private fun menorValor(no: Node<T>): Node<T> {
        var atual = no
        while (atual.esq != null) atual = atual.esq!!
        return atual
    }

    // Balanceia o nó após inserção ou remoção
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

    // Exibe a árvore em pré-ordem
    fun preOrdem(no: Node<T>? = raiz) {
        if (no != null) {
            print("${no.info} ")
            preOrdem(no.esq)
            preOrdem(no.dir)
        }
    }
}