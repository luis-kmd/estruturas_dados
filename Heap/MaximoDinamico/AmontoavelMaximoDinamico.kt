interface AmontoavelMaximoDinamico {

    // METODOS PRINCIPAIS
    fun inserir(dado: Long)
    fun obter(): Long?
    fun atualizar(novoDado: Long)
    fun extrair(): Long?

    // METODOS AUXILIARIAS
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String

}