class MonteMaximo(private val tamanho: Int): AmontoavelMaximo {
    private var dados = LongArray(tamanho)
    private var ponteiroFim: Int = -1

    private fun indicePai(indiceFilho: Int): Int{
        return (indiceFilho-1) / 2
    }

    private fun indiceFilhoEsquerda(indicePai: Int): Int{
        return indicePai * 2 + 1
    }

    private fun indiceFilhoDireita(indicePai: Int): Int{
        return indicePai * 2 + 2
    }

    private fun troca(a: Int, b: Int){
        val aux = dados[a]
        dados[a] = dados[b]
        dados[b] = aux
    }

    private fun ajustarAcima(indice: Int){
        var indiceFilho = indice
        var indicePai = indicePai(indiceFilho)

        while (indiceFilho > 0 && dados[indicePai] < dados[indiceFilho]){
            troca(indicePai, indiceFilho)
            indiceFilho = indicePai
            indicePai = indicePai(indiceFilho)
        }
    }

    override fun inserir(dado: Long) {
        if (!estaCheia()){
            ponteiroFim++
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else {
            println("Heap Cheia!")
        }
    }

    override fun obter(): Long? {
        var retorno: Long? = null

        if (!estaVazia()){
            retorno = dados[0]
        } else {
            println("Heap Vazia!")
        }

        return retorno
    }

    private fun maior(indicePai: Int, esquerda: Int, direita: Int): Int {
        var maior = indicePai

        if (esquerda <= ponteiroFim && dados[esquerda] > dados[maior]) {
            maior = esquerda
        }
        if (direita <= ponteiroFim && dados[direita] > dados[maior]) {
            maior = direita
        }

        return maior
    }

    private fun ajustarAbaixo(indice: Int) {
        var pai = indice

        while (true) {
            val esquerda = indiceFilhoEsquerda(pai)
            val direita = indiceFilhoDireita(pai)
            val maiorFilho = maior(pai, esquerda, direita)

            if (maiorFilho == pai) break

            troca(pai, maiorFilho)
            pai = maiorFilho
        }
    }

    override fun atualizar(dado: Long) {
        if (!estaVazia()){
            dados[0] = dado
            ajustarAbaixo(0)
        } else {
            println("Heap Vazia!")
        }
    }

    override fun extrair(): Long? {
        var retornoRemovido: Long? = null

        if (!estaVazia()){
            retornoRemovido = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim--
            ajustarAbaixo(0)
        } else {
            println("Heap Vazia!")
        }

        return retornoRemovido
    }

    override fun estaCheia(): Boolean {
        return (ponteiroFim == (dados.size-1))
    }

    override fun estaVazia(): Boolean {
        return (ponteiroFim == -1)
    }

    override fun imprimir(): String {
        var retorno = "["

        for (i in 0 .. ponteiroFim){
            retorno += "${dados[i]}"
            if (i != ponteiroFim)
                retorno += ","
        }

        return "$retorno]"
    }
}