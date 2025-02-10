class ABB<T : Comparable<T>> : ArvoreBinaria<T> {
    // A raiz da árvore
    private var raiz: Node<T>? = null

    // Método para inserir um valor na árvore
    override fun insere(valor: T): Boolean {
        // Caso a árvore esteja vazia, cria um novo nó na raiz
        if (raiz == null) {
            raiz = Node(valor)
            return true
        }

        // Percorre a árvore para encontrar a posição correta do novo valor
        var atual = raiz
        while (atual != null) {
            when {
                // Se o valor é menor que o nó atual, vá para a subárvore esquerda
                valor < atual.info -> {
                    if (atual.esq == null) {
                        atual.esq = Node(valor) // Insere o valor na subárvore esquerda
                        return true
                    }
                    atual = atual.esq
                }
                // Se o valor é maior que o nó atual, vá para a subárvore direita
                valor > atual.info -> {
                    if (atual.dir == null) {
                        atual.dir = Node(valor) // Insere o valor na subárvore direita
                        return true
                    }
                    atual = atual.dir
                }
                // Caso o valor já exista na árvore, não insere duplicados
                else -> return false
            }
        }
        return false
    }

    // Método para buscar um valor na árvore
    override fun busca(valor: T): T? {
        // Começa a busca a partir da raiz
        var atual = raiz
        while (atual != null) {
            atual = when {
                // Se o valor buscado é menor, vá para a subárvore esquerda
                valor < atual.info -> atual.esq
                // Se o valor buscado é maior, vá para a subárvore direita
                valor > atual.info -> atual.dir
                // Se o valor é igual ao nó atual, o encontramos
                else -> return atual.info
            }
        }
        // Retorna null se o valor não foi encontrado
        return null
    }

    // Método para remover um valor da árvore
    override fun remove(valor: T): Boolean {
        // Chama a função auxiliar para remover o nó e atualiza a raiz, se necessário
        raiz = removeRec(raiz, valor) ?: return false
        return true
    }

    // Função recursiva para remover um nó da árvore
    private fun removeRec(no: Node<T>?, valor: T): Node<T>? {
        if (no == null) return null // Se o nó for nulo, o valor não está na árvore

        when {
            // Se o valor é menor, vá para a subárvore esquerda
            valor < no.info -> no.esq = removeRec(no.esq, valor)
            // Se o valor é maior, vá para a subárvore direita
            valor > no.info -> no.dir = removeRec(no.dir, valor)
            // Encontramos o nó a ser removido
            else -> {
                // Caso 1: Nó é uma folha (sem filhos)
                if (no.esq == null && no.dir == null) return null

                // Caso 2: Nó tem apenas um filho
                if (no.esq == null) return no.dir // Substitui pelo filho direito
                if (no.dir == null) return no.esq // Substitui pelo filho esquerdo

                // Caso 3: Nó tem dois filhos
                // Substitui o valor pelo maior valor da subárvore esquerda
                no.info = maiorValor(no.esq!!)
                // Remove o maior valor da subárvore esquerda
                no.esq = removeRec(no.esq, no.info)
            }
        }
        return no
    }

    // Função auxiliar para encontrar o maior valor na subárvore esquerda
    private fun maiorValor(no: Node<T>): T {
        var atual = no
        // Percorre para a direita até encontrar o maior valor
        while (atual.dir != null) atual = atual.dir!!
        return atual.info
    }
}