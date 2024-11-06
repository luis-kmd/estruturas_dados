class Monte(tamanho: Int) : AmontoavelMinimo {
    private var dados = LongArray(tamanho)
    private var ponteiroFim = -1

    override fun estaVazia(): Boolean {
        return ponteiroFim == -1
    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == dados.size - 1
    }

    override fun obter(): Long? {
        return if (!estaVazia()) dados[0] else null
    }

    override fun buscar(): Long? {
        return if (!estaVazia()) dados[0] else null
    }

    override fun atualizar(novoDado: Long) {
        if (!estaVazia()) {
            dados[0] = novoDado
            ajustarAbaixo(0)
        } else {
            println("Heap está vazia!")
        }
    }

    override fun imprimir(): String {
        return dados.take(ponteiroFim + 1).joinToString(prefix = "[", postfix = "]", separator = ", ")
    }

    private fun troca(i: Int, j: Int) {
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    private fun filhoEsquerda(indicePai: Int): Int {
        return 2 * indicePai + 1
    }

    private fun filhoDireita(indicePai: Int): Int {
        return 2 * indicePai + 2
    }

    private fun pai(indiceFilho: Int): Int {
        return (indiceFilho - 1) / 2
    }

    override fun inserir(dado: Long) {
        if (!estaCheia()) {
            ponteiroFim++
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else {
            println("Heap está cheia!")
        }
    }

    override fun extrair(): Long? {
        return if (!estaVazia()) {
            val raiz = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim--
            ajustarAbaixo(0)
            raiz
        } else {
            println("Heap está vazia!")
            null
        }
    }

        private fun menor(pai: Int, esquerda: Int, direita: Int): Int {
            var menor = pai

            if (esquerda <= ponteiroFim && dados[esquerda] < dados[menor]) {
                menor = esquerda
            }
            if (direita <= ponteiroFim && dados[direita] < dados[menor]) {
                menor = direita
            }

            return menor
    }

    private fun ajustarAcima(indice: Int) {
        var indiceFilho = indice
        var indicePai = pai(indiceFilho)
        while (indiceFilho > 0 && dados[indiceFilho] < dados[indicePai]) {
            troca(indiceFilho, indicePai)
            indiceFilho = indicePai
            indicePai = pai(indiceFilho)
        }
    }

    private fun ajustarAbaixo(indice: Int) {
        var indicePai = indice
        while (true) {
            val indiceFilhoEsquerda = filhoEsquerda(indicePai)
            val indiceFilhoDireita = filhoDireita(indicePai)
            val menorIndice = menor(indicePai, indiceFilhoEsquerda, indiceFilhoDireita)
            if (menorIndice != indicePai) {
                troca(indicePai, menorIndice)
                indicePai = menorIndice
            } else {
                break
            }
        }
    }
}