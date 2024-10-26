class Monte: AmontoavelMinimo{
    private var dados: Array<Long>
    private var ponteiroFim: Int

    constructor(tamanho: int){
        dados = LongArray(tamanho)
        ponteiroFim = -1
        
    }

    override fun estaVazia(): Boolean{
        return(ponteiroFim == - 1)    
    }

    override fun estaCheia(): Boolean{
        return(ponteiroFim == dados.size - 1)
    }


    override fun obter(): Long?{
        var aux: Long? = null
        if(estaVazia()){
            aux = dados[0]
        }
        else{
            println("Heap está vazia !)
        }
        return aux
    }

    override fun buscar(): Long{
        if(!estaVazia()){
            return dados[0]
        }
        else{
            println("Heap está vazia !")
        }
    }

    override fun atualizar(novoDado: Long){
        dados[0] = novoDado
        ajustarAbaixo()
    }

    override fun imprimir(): String{
        var resultado = "["
        for(i in 0 until dados.size){
            if(i == dados.size)
                resultado += "${dados[i]}"
            else
                resultado += "${dados[i]},"
        }
        return "${resultado}]"
    }

    private fun troca(i: Int, j: Int){
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    private fun filhoEsquerda(indicePai: Int): Int{
        return(indicePai * 2 + 1)
    }

    private fun filhoDireita(indicePai: Int): Int{
        return(indicePai * 2 + 2)
    }

    private fun pai(indiceFilho: Int): Int{
        return(indiceFilho - 1) / 2
    }

    override fun inserir(dado: Long){
        if(!estaCheia()){
            ponteiroFim++
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        }
        else{
            print("Heap está cheia !")
        }
    }

    override fun atualizar(novoDado: Long){
        if(!estaVazia()){
            dados[0] = novoDado
            ajustarAbaixo(0)
        }
        else{
            println("Heap está vazia !")
        }
    }

    override fun extrair(): Long?{
        var aux: Any? = null
        if(!estaVazia()){
            aux = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim--
            ajustarAbaixo(0)
        }
        else{
            println("Heap está vazia !")
        }
        return aux
    } 

    private fun menor(a: Int, b: Int, c: Int){
        if(dados[a] < dados[b]) &&  (dados[a] < dados[c])
            return a
        } else if (dados[b] < dados[a]) && (dados[b] < dados[c]){
            return b
        }
        else{
            return c
        }
    }

    private ajustarAcima(indice: Int){
        var indiceFilho = indice
        var indicePai = pai(indiceFilho)
        while(indiceFilho > 0){
            if(dados[indiceFilho] < dados[indicePai]){
                troca(indiceFilho, IndicePai)
            }
            else{
                break
            }
            indiceFilho = indicePai
            indicePai = pai(indiceFilho)
        }
    }
    
    private ajustarAbaixo(indice: Int){
        var indicePai = indice
        var indiceFilhoEsquerda = filhoEsquerda(indicePai)
        var indiceFilhoDireta = filhoDireita(indicePai)
        val menor = menor(indice, indiceFilhoEsquerda, indiceFilhoDireita)
        if(indicePai != menor){
            val menorFilho = menor(indiceFilhoEsquerda, indiceFIlhoDireita)
            troca(indicePai, menorFilho
            ajustarAbaixo(menorFilho)
        }
    }
}