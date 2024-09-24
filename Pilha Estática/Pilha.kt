class Pilha: Empilhavel{
    var ponteiroTopo Int
    var dados Array<Any>

    constructor(tamanho: Int){
        ponteiroTopo = -1
        dados = arrayOfNulls(tamanho)
    }

    override fun estaVazia(): Any?{
        return(ponteiroTopo == -1)
    }

    override fun estaCheia(): Any?{
        return(ponteiroTopo == dados.size - 1)
    }

    override fun empilhar(dados: Any?){
        if(!estaCheia()){
            ponteiroTopo ++
            dados[ponteiroTopo] = dado
        }

        else {
            println("Pilha está cheia !")
        }
    }
    
    override fun desempilhar(): Any?{
        var dadoTopo: Any? = null
        if(!estaVazia()){
            dadoTopo = dados[ponteiroTopo]
            ponteiroTopo --
        }
        else {
            println("Pilha está vazia !")
        }

        return dadoTopo
    }

    override fun atualizar(dado: Any?){
        if(!estaVazia()){
            dados[ponteiroTopo] = ponteiroTopo
        }
        else {
            println("Pilha está vazia !")
        }

    }

    override fun espiar(): Any?{
        var dadoTopo: Any? = null
        if(!estaVazia()){
            dadoTopo = dados[ponteiroTopo]
        }
        else {
            println("Pilha está vazia")
        }
        return dadoTopo
    }

    override fun imprimir(): String{
        var retorno = "["
        for (i in ponteiroTopo downTo 0){
            retorno += if(i == 0){
                "${dados[i]}"
            } else {
                "${dados[i]},"
            }
        }
        return "$retorno]"
    }
}