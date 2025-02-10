class ABB<T : Comparable<T>> {
    private var raiz: Node<T>? = null

    // Método de inserção
    fun insere(valor: T): Boolean {
        if (raiz == null) {
            raiz = Node(valor)
            return true
        }

        var atual = raiz
        while (atual != null) {
            when {
                valor < atual.info -> {
                    if (atual.esq == null) {
                        atual.esq = Node(valor)
                        return true
                    }
                    atual = atual.esq
                }
                valor > atual.info -> {
                    if (atual.dir == null) {
                        atual.dir = Node(valor)
                        return true
                    }
                    atual = atual.dir
                }
                else -> return false // Valor já existe na árvore
            }
        }
        return false
    }

    // Método de busca
    fun busca(valor: T): T? {
        var atual = raiz
        while (atual != null) {
            atual = when {
                valor < atual.info -> atual.esq
                valor > atual.info -> atual.dir
                else -> return atual.info
            }
        }
        return null // Valor não encontrado
    }

    // Método de remoção
    fun remove(valor: T): T? {
        var atual = raiz
        var pai: Node<T>? = null

        // Localiza o nó a ser removido e seu pai
        while (atual != null && atual.info != valor) {
            pai = atual
            atual = if (valor < atual.info) atual.esq else atual.dir
        }

        atual ?: return null // Valor não encontrado

        val retorno = atual.info

        // Nó é uma folha
        if (atual.esq == null && atual.dir == null) {
            if (atual == raiz) raiz = null
            else if (pai?.esq == atual) pai.esq = null
            else pai?.dir = null
        }
        // Nó tem apenas um filho
        else if (atual.esq == null || atual.dir == null) {
            val filho = atual.esq ?: atual.dir
            if (atual == raiz) raiz = filho
            else if (pai?.esq == atual) pai.esq = filho
            else pai?.dir = filho
        }
        // Nó tem dois filhos
        else {
            val substituto = removeMaiorEsq(atual)
            atual.info = substituto
        }

        return retorno
    }

    private fun removeMaiorEsq(no: Node<T>): T {
        var pai = no
        var atual = no.esq!!

        while (atual.dir != null) {
            pai = atual
            atual = atual.dir!!
        }

        if (pai.esq == atual) pai.esq = atual.esq else pai.dir = atual.esq
        return atual.info
    }
}