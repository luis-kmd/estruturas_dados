class Pilha : Empilhavel {
    private var ponteiroTopo: Int
    private var dados: Array<Any?>

    constructor(tamanho: Int) {
        ponteiroTopo = -1
        dados = arrayOfNulls(tamanho)
    }

    override fun estaCheia(): Boolean {
        return (ponteiroTopo == dados.size - 1)
    }

    override fun estaVazia(): Boolean {
        return (ponteiroTopo == -1)
    }

    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroTopo++
            dados[ponteiroTopo] = dado
        } else {
            println("Pilha está cheia!")
        }
    }

    override fun atualizar(dado: Any?) {
        if (!estaVazia()) {
            dados[ponteiroTopo] = dado
        } else {
            println("Pilha está vazia!")
        }
    }

    override fun desempilhar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = dados[ponteiroTopo]
            dados[ponteiroTopo] = null // Limpa a posição desempilhada
            ponteiroTopo--
        } else {
            println("Pilha está vazia!")
        }
        return dadoTopo
    }

    override fun espiar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = dados[ponteiroTopo]
        } else {
            println("Pilha está vazia!")
        }
        return dadoTopo
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in ponteiroTopo downTo 0) {
            resultado += if (i == 0) {
                "${dados[i]}"
            } else {
                "${dados[i]}, "
            }
        }
        return "$resultado]"
    }
}
