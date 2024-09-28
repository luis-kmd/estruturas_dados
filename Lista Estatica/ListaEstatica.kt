class ListaEstatica: Listavel{
    private var ponteiroInicio: Int
    private var ponteiroFim: Int
    private var quantidade: Int
    private val dados: Array<Any?>

    constructor(tamanho: Int){
        ponteiroInicio = 0
        ponteiroFim = -1
        quantidade = 0
        dados = arrayOfNulls(tamanho)
    }


    override fun inserir(posicao: Int, dado: Any?){
        if(!estaCheia()){
                if((posicao >= 0) && (posicao <= quantidade)){
                    val posicaoFisica = (ponteiroInicio + posicao)%dados.size
                    for(i in quantidade-posicao .. 0){
                        dados[(posicaoFisica + 1 + i)%dados.size] = dados[(i + posicaoFisica)%dados.size]
                    }
                    dados[posicaoFisica] = dado
                    ponteiroFim = (ponteiroFim + 1)%dados.size
                    quantidade++
                }
                else{
                    println("Posição invalida !")}
            }
            else{
                println("Lista está cheia !")
            }
        }                     


    override fun anexar(dado: Any?){
        if(!estaCheia()){
            ponteiroFim = (ponteiroFim+1)%dados.size
            dados[ponteiroFim] = dado
            quantidade++
        }
        else{
            println("Lista está cheia !")
        }
    }  

    override fun  selecionar(posicao: Int): Any?{
        var aux: Any? = null
        if(!estaVazia()){
                if((posicao >= 0) && (posicao < quantidade)){
                    val posicaoFisica = (ponteiroInicio + posicao)%dados.size
                    aux = dados[posicaoFisica]
                }
                else{
                    println("Posição invalida !")}
            }
            else{
                println("Lista está vazia !")
            }
            return aux
        }                     

    override fun selecionarTodos(): Array<Any?> {
        var dadosAux: Array<Any?> = arrayOfNulls(quantidade)
        if(!estaVazia()){
            var ponteiroAux = ponteiroInicio
            for(i in 0 until quantidade){
                dadosAux[i] = dados[(ponteiroAux + i)%dados.size]
                ponteiroAux++
                }  
        }
        else {
            print("Lista está vazia !")
        }
        return dadosAux
    }

    override fun atualizar(posicao: Int, dado: Any?){
        if(!estaVazia()){
            if((posicao >= 0) && (posicao < quantidade)){
                val posicaoFisica = (ponteiroInicio + posicao)%dados.size
                dados[posicaoFisica] = dado
            }
            else{
                println("Posição invalida !")}
        }
        else{
            println("Lista está vazia !")
        }
    }           

    override fun apagar(posicao: Int): Any? {
        var aux: Any? = null
        if(!estaVazia()){
            if((posicao >= 0) && (posicao < quantidade)){
                val posicaoFisica = (ponteiroInicio + posicao)%dados.size
                aux = dados[posicaoFisica]
                for(i in 0 until quantidade - posicao){
                    dados[posicaoFisica + i] = dados[(posicaoFisica + i + 1)%dados.size]
                }
            ponteiroFim --
            if(ponteiroFim == -1){
                ponteiroFim = dados.size - 1
            }
            quantidade --
            }
            else{
                println("Posição invalida !")}
        }
        else{
            println("Lista está vazia !")
        }
        return aux
    }           

    override fun limpar(){
        ponteiroInicio = 0
        ponteiroFim = -1
        quantidade = 0
    }                              

// Metodos auxiliares
    override fun imprimir(): String{
        var retorno = "["
        var ponteiroAux = ponteiroInicio
        for(i in 0 until quantidade){
            if(i== quantidade -1)
                retorno += "${dados[ponteiroAux%dados.size]}"
            else
                retorno += "${dados[ponteiroAux%dados.size]}," 

        ponteiroAux ++   
        }

        return "${retorno}]"
    }

    override fun estaCheia(): Boolean{
        return(quantidade == dado.size)
    }

    override fun estaVazia(): Boolean{
        return(quantidade == 0)
    }


}














// COMPLEXIDADE DE ALGORITMOS
// ORDEM DE COMPLEXIDADE
    // PILHA {
    // EMPILHAR = CONSTANTE == O(1)
    // DESEMPILHAR = CONSTANTE == O(1)
    // ATUALZIAR = CONSTANTE == O(1)
    // ESPIAR = CONSTANTE == O(1)
    // IMPRIMIR = VARIA = (O)N }

    // FILA {
    // ENFILEIRAR = CONSTANTE == O(1)
    // DESENFILEIRAR = CONSTANTE == O(1)
    // ATUALIZAR = CONSTANTE == O(1)
    // FRENTE = CONSTANTE == O(1)
    // IMPRIMIR = = VARIA = (O)N }

