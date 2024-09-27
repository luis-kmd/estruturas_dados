class PilhaDeTexto: Editavel{
    private var digitado: Array<String?>
    private var ponteiroTopo: Int

    constructor(tamanho: Int){
        ponteiroTopo = - 1
        digitado = arrayOfNulls(tamanho)
    }

    override fun estaVazia(): Boolean{
        return(ponteiroTopo == -1)
    }

    override fun estaCheia(): Boolean{
        return(ponteiroTopo == digitado.size - 1)
    }

    override fun digitar(texto: String){
        if(!estaCheia()){
            ponteiroTopo ++
            digitado[ponteiroTopo] = texto
    }   else {
            println("Editor de texto cheio !")    
    }
    }

    override fun desfazer(): String? {
        return if (!estaVazia()) {
            val dadotopo = digitado[ponteiroTopo]
            digitado[ponteiroTopo] = null
            ponteiroTopo--
            println("Você utilizou o Ctrl + Z, último texto digitado ('$dadotopo') foi apagado.")
            dadotopo
        } else {
            println("Editor de texto está vazio!")
            null
        }
    }

    override fun espiar(): Any?{
       var dadotopo: Any? = null
       if(!estaVazia()){
            dadotopo = digitado[ponteiroTopo] 
    } else {
        dadotopo = println("Editor de texto está vazio !")
    }
        return dadotopo
    }


    override fun imprimir() {
        println("=-=-=-=-=-=-=-=- EDITOR DE TEXTO =-=-=-=-=-=-=-=-")
        if (!estaVazia()) {
            for (i in ponteiroTopo downTo 0) {
                println("'$i': ${digitado[i]}")
            }
        } else {
            println("Editor de texto vazio!")
        }
    }
}
