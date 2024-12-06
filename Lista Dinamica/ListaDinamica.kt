class ListaDinamica(private val tamanho: Int = 10) : Listavel {
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    override fun anexar(dado: Any?) {
        if (!estaCheia()) {
            val noTemp = NoDuplo(dado)
            noTemp.anterior = ponteiroFim
            if (!estaVazia()) {
                ponteiroFim?.proximo = noTemp
            } else {
                ponteiroInicio = noTemp
            }
            ponteiroFim = noTemp
            quantidade++
        } else {
            println("Lista Cheia!")
        }
    }

    override fun selecionarTodos(): Array<Any?> {
        val dadosAux: Array<Any?> = arrayOfNulls(quantidade)
        if (!estaVazia()) {
            var ponteiroAuxiliar = ponteiroInicio
            for (i in 0 until quantidade) {
                dadosAux[i] = ponteiroAuxiliar?.dado
                ponteiroAuxiliar = ponteiroAuxiliar?.proximo
            }
        } else {
            println("Lista Vazia!")
        }
        return dadosAux
    }

    override fun selecionar(posicao: Int): Any? {
        if (!estaVazia() && posicao in 0 until quantidade) {
            var ponteiroAuxiliar = ponteiroInicio
            for (i in 0 until posicao) {
                ponteiroAuxiliar = ponteiroAuxiliar?.proximo
            }
            return ponteiroAuxiliar?.dado
        }
        println("Índice Inválido!")
        return null
    }

    override fun atualizar(dado: Any?, posicao: Int) {
        if (!estaVazia() && posicao in 0 until quantidade) {
            var ponteiroAuxiliar = ponteiroInicio
            for (i in 0 until posicao) {
                ponteiroAuxiliar = ponteiroAuxiliar?.proximo
            }
            ponteiroAuxiliar?.dado = dado
        } else {
            println("Índice Inválido!")
        }
    }

    override fun limpar() {
        ponteiroInicio = null
        ponteiroFim = null
        quantidade = 0
    }

    override fun apagar(posicao: Int): Any? {
        if (!estaVazia() && posicao in 0 until quantidade) {
            var ponteiroAuxiliar = ponteiroInicio
            for (i in 0 until posicao) {
                ponteiroAuxiliar = ponteiroAuxiliar?.proximo
            }

            val dadoRemovido = ponteiroAuxiliar?.dado
            val ponteiroAnterior = ponteiroAuxiliar?.anterior
            val ponteiroProximo = ponteiroAuxiliar?.proximo

            if (ponteiroAnterior != null) {
                ponteiroAnterior.proximo = ponteiroProximo
            } else {
                ponteiroInicio = ponteiroProximo
            }

            if (ponteiroProximo != null) {
                ponteiroProximo.anterior = ponteiroAnterior
            } else {
                ponteiroFim = ponteiroAnterior
            }

            quantidade--
            return dadoRemovido
        }
        println("Índice Inválido!")
        return null
    }

    override fun inserir(dado: Any?, posicao: Int) {
        if (!estaCheia() && posicao in 0..quantidade) {
            val noTemp = NoDuplo(dado)
            var ponteiroAnterior: NoDuplo? = null
            var ponteiroProximo = ponteiroInicio

            for (i in 0 until posicao) {
                ponteiroAnterior = ponteiroProximo
                ponteiroProximo = ponteiroProximo?.proximo
            }

            noTemp.anterior = ponteiroAnterior
            noTemp.proximo = ponteiroProximo

            if (ponteiroAnterior != null) {
                ponteiroAnterior.proximo = noTemp
            } else {
                ponteiroInicio = noTemp
            }

            if (ponteiroProximo != null) {
                ponteiroProximo.anterior = noTemp
            } else {
                ponteiroFim = noTemp
            }

            quantidade++
        } else {
            println("Índice Inválido ou Lista Cheia!")
        }
    }

    override fun ordenar() {
        if (quantidade > 1) {
            for (i in 0 until quantidade - 1) {
                var ponteiroAuxiliar = ponteiroInicio
                for (j in 0 until quantidade - i - 1) {
                    if (ponteiroAuxiliar?.dado is Comparable<*> && ponteiroAuxiliar.proximo?.dado is Comparable<*>) {
                        if ((ponteiroAuxiliar.dado as Comparable<Any>) > (ponteiroAuxiliar.proximo?.dado as Comparable<Any>)) {
                            val temp = ponteiroAuxiliar.dado
                            ponteiroAuxiliar.dado = ponteiroAuxiliar.proximo?.dado
                            ponteiroAuxiliar.proximo?.dado = temp
                        }
                    }
                    ponteiroAuxiliar = ponteiroAuxiliar?.proximo
                }
            }
        }
    }

    override fun estaCheia(): Boolean{
        return(quantidade == tamanho)
    }

    override fun estaVazia(): Boolean{ 
        return(quantidade == 0)
    }

    override fun imprimir(): String {
        val resultado = StringBuilder("[")
        var ponteiroAuxiliar = ponteiroInicio
        for (i in 0 until quantidade) {
            resultado.append(ponteiroAuxiliar?.dado)
            if (i != quantidade - 1) resultado.append(",")
            ponteiroAuxiliar = ponteiroAuxiliar?.proximo
        }
        resultado.append("]")
        return resultado.toString()
    }
}