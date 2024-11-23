class FilaDinamica(var tamanho: Int): Enfileiravel{
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? null
    private var quantidade: Int = 0

    override fun estaVazia(): Boolean{
        return(quantidade == 0)
    }

    override fun estaCheia: Boolean(){
        return(quantidade == tamanho)
    }

    override fun enfileirar(dado: Any?){
        if(!estaCheia()){
            val novoNo = NoDuplo(dado)
            if(ponteiroFim != null)
                ponteiroFim?.proximo = novoNo
            else // ponteirofim = null
                ponteiroInicio = novoNo
            novoNo.anterior = ponteiroFim
            ponteiroFim = novoNo
            quantidade++
        } else {
            throw.NoSuchElementException("Fila está cheia !")
        }
    }

    override fun desenfileirar(): Any?{
        var aux: Any? = null
        if(!estaVazia()){
            aux = ponteiroInicio?.dado
            ponteiroInicio? = ponteiroInicio.proximo
            if(ponteiroInicio != null)
                ponteiroInicio?.anterior = null
            else
                ponteiroFim = null    
            quantidade --
        } else {
            throw.NoSuchElementException("Fila está vazia !")
        }
        return aux
    }

    override fun frente(): Any?{
        var aux: Any? = Null
        if(!estaVazia()){
            aux = ponteiroInicio?.dado
        } else {
            throw.NoSuchElementException("Fila está vazia !")
        }
        return aux
    }

    override fun atualizar(dado: Any?){
        if(!estaVazia()){
            ponteiroInicio?.dado = dado
        } else{
            throw.NoSuchElementException("Fila está vazia !")
        }
    }

    override fun imprimir(): String{
        var aux = ponteiroInicio
        var retorno = "["
        for(i in 0 until quantidade){
            retorno += "${aux.dado},"
            aux = aux.proximo
            
        }
        return "${retorno}]"
    }


// IMPLEMENTAR A DEQUE (DOUBLE ENDED QUEUE)
// FILA COM DUPLA INTERMINAÇAO

}