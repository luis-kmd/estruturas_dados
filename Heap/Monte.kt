class Monte: Amontoavel{
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

    

}