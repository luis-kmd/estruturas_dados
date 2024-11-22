Class MonteMaximoDinamico(private var tamanho: Int): AmontoavelMaximoDinamico{
    private var dados = LongArray(tamanho)
    private var ponteiroFim: Int = -1

    private fun indicePai(filho: Int): Int{
        return (filho-1) / 2
    }

    private fun filhoEsquerda(pai: Int): Int{
        return pai*2+1
    }

    private fun filhoDireita(pai: Int): Int{
        return pai*2+2
    }

    private fun maior(pai: Int, esquerda: Int, direita: Int): Int{
        var maior = pai

        if (esquerda <= ponteiroFim && dados[esquerda] > dados[maior])
            maior = esquerda

        if (direita <= ponteiroFim && dados[direita] > dados[maior])
            maior = direita

        return maior
    }

    private fun trocar(a: Int, b: Int){
        val aux = dados[a]
        dados[a] = dados[b]
        dados[b] = aux
    }

    private fun ajustarAbaixo(indiceRaiz: Int){
        var pai = indiceRaiz
        while (true) {
            val filhoEsquerda = filhoEsquerda(pai)
            val filhoDireita = filhoDireita(pai)
            val maior = maior(pai, filhoEsquerda, filhoDireita)
            if (maior == pai) break
            trocar(pai, maior)
            pai = maior
        }
    }

    private fun ajustarAcima(indice: Int){
        var filho = indice
        var pai = indicePai(filho)

        while (filho > 0 && dados[pai] < dados[filho]){
            trocar(pai, filho)
            filho = pai
            pai = indicePai(filho)
        }
    }

    private fun redimencionar(){
        tamanho *= 2
        var novosDados = LongArray(tamanho)
        for (i in 0 .. ponteiroFim){
            novosDados[i] = dados[i]
        }
        dados = novosDados
    }

    override fun inserir(dado: Long) {
        if (estaCheia())
            redimencionar()
        ponteiroFim++
        dados[ponteiroFim] = dado
        ajustarAcima(ponteiroFim)
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

    override fun atualizar(novoDado: Long) {
        if (!estaVazia()){
            dados[0] = novoDado
            ajustarAbaixo(0)
        } else {
            println("Heap Vazia!")
        }
    }

    override fun extrair(): Long? {
        var retorno: Long? = null

        if (!estaVazia()){
            retorno = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim--
            ajustarAbaixo(0)
        } else {
            println("Heap Vazia!")
        }

        return retorno
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