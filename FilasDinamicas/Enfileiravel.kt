interface Enfileiravel{
    // Metodos Principais
    fun enfileirar(dado: Any?) // C
    fun atualizar(dado: Any?)  // U
    fun frente(): Any?         // R
    fun desenfileirar(): Any?  // D

    // Metodos Auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String

}