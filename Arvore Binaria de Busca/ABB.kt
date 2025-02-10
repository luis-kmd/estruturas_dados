class ABB<T : Comparable<T>> : ArvoreBinaria<T> {
    private var raiz: Node<T>? = null

    override fun insere(valor: T): Boolean {
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
                else -> return false // Valor já existe
            }
        }
        return false
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

    override fun remove(valor: T): Boolean {
        raiz = removeRec(raiz, valor) ?: return false
        return true
    }

    private fun removeRec(no: Node<T>?, valor: T): Node<T>? {
        if (no == null) return null

        when {
            valor < no.info -> no.esq = removeRec(no.esq, valor)
            valor > no.info -> no.dir = removeRec(no.dir, valor)
            else -> {
                // Nó encontrado, trata remoção
                if (no.esq == null) return no.dir
                if (no.dir == null) return no.esq

                // Substitui pelo maior da subárvore esquerda
                no.info = maiorValor(no.esq!!)
                no.esq = removeRec(no.esq, no.info)
            }
        }
        return no
    }

    private fun maiorValor(no: Node<T>): T {
        var atual = no
        while (atual.dir != null) atual = atual.dir!!
        return atual.info
    }
}
