class ListaDinamica(var tamanho: Int): Listavel {
    private var quantidade: Int = 0
    private var ponteiroFim: NoDuplo
    private var ponteiroInicio: NoDuplo

    //Metodos Auxiliares
    override fun estaCheia(): Boolean{
        return(quantidade == tamanho)
    }

    override fun estaVazia(): Boolean{
        return(quantidade == 0)
    }

    override fun selecionar(posicao: Int): Any?{
        if(!estaVazia()){
            if(posicao >= 0 && posicao < quantidade)
                var aux = ponteiroInicio
                for(i in 0 until posicao){

                    aux = aux.proximo
                }
                // laço para ir ate o nó que em o dado a ser retornado

        }
    }

    override fun limpar(){
        quantidade = 0
        ponteiroFim = ponteiroInicio = null
    }

    override fun selecionarTodos(): Array<Any?>{
        val arrayDados: Array<Any?> = ArrayOfNulls(quantidade)
        val aux = ponteiroInicio
        if(!estaVazia()){
            for(i in 0 until quantidade){
                arrayDados[i] = aux.dado
                aux = aux.proximo    
        }
        else {
            throw NoSuchElementException("Lista Vazia !")
        }
    }

    override fun imprimir(): String{
        var resultado = "["
        var aux = ponteiroInicio
        for(i in 0 until quantidade){
            resultado += aux.dado
            if(i != quantidade - 1) {
            resultado += ","
            aux.proximo
        }
        return "${resultado}]"
    }

}