class PilhaDinamica(var tamanho: Int): Empilhavel{
    private var ponteiroTopo: NoDuplo? = null
    private var quantidade: Int = 0

    override fun estaCheia(): Boolean{
        return(quantidade == tamanho)
    }

    override fun estaVazia(): Boolean{
        return(quantidade == 0)
    }

    override fun empilhar(dado: Any?){
        if(!estaCheia()){
            val novoNo = NoDuplo(dado)
            if(!estaVazia()){
                ponteiroTopo?.proximo = novoNo
            }
            novoNo.anterior = ponteiroTopo
            ponteiroTopo  = novoNo
            quantidade++
        } else {
            println("Pilha está Cheia!")
        }
    }

    override fun desempilhar(): Any?{
        var dadoAux: Any? = null
        if(!estaVazia()){
            dadoAux = ponteiroTopo.dado
            if(ponteiroTopo != null)
            ponteiroTopo.proximo = null
            quantidade--
        } else {
            println("Pilha está vazia !")
        }
        return dadoAux
    }

    override fun espiar(): Any?{
        var dadoAux: Any? = null
        if(!estaVazia()){
            dadoAux = ponteiroTopo.dado
        } else {
            println("Pilha está vazia !")
        }
        return dadoAux
    }

    override fun atualizar(dado: Any?){
        if(!estaVazia()){
            ponteiroTopo.dado = dado
        } else {
            println("Pilha está vazia !")
        }
    }

    override fun imprimir(): String{
        var aux: Any? = ponteiroTopo
        var retorno = "["
        while(aux.anterior != null){
            retorno += aux.dado
            aux = aux.anterior
        }
        return "${retorno}]"
    }

}