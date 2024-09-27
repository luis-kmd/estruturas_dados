class FilaEstatica(tamanho: Int): Enfileiravel{
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)

    override fun estaVazia(): Boolean{
        return(ponteiroInicio == ponteiroFim + 1)
    }

    override fun estaCheia(): Boolean{
        return(ponteiroFim == dados.size - 1)
    }

    override fun enfileirar(dado: Any?){
        if(!estaCheia()){
            ponteiroFim ++
            dados[ponteiroFim] = dado
        }
        else{
            println("Fila está cheia !")
        }
    }

    override fun desenfileirar(): Any?{
        var dadoInicio: Any? = null
        if(!estaVazia()){
            ponteiroInicio ++
			dadoInicio = dados[ponteiroInicio]
        }
        else{
            println("Fila está vazia !")
        }
        return dadoInicio
    }

    override fun atualizar(dado: Any?){
        if(!estaVazia()){
            dados[ponteiroInicio] = dado
        }
        else{
            println("Fila está vazia !")
        }
    }

    override fun frente(): Any?{
        var dadoFim: Any? = null
        if(!estaVazia()){
            dadoFim = dados[ponteiroFim]
        }
        else{
            println("Fila está vazia !")
        }
        return dadoFim
    }

    override fun imprimir(): String{
        var retorno = "["
        for(i in ponteiroInicio .. ponteiroFim){
            if(i == ponteiroFim)
                retorno += "${dados[i]}"
            else
                retorno += "${dados[i]},"
        }
        return "${retorno}]"
    }
}