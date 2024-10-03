interface Empilhavel{
    // Metodos Principais
    fun empilhar(dado: Int)
    fun desempilhar(): Any?
    fun atualizar(dado: Any?)
    fun observar(): Any?

    // Metodos auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}