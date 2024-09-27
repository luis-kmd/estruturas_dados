interface Enfileiravel {
    // Métodos principais
    fun enfileirar(dado: Any?) // C
    fun atualizar(dado: Any?)  // U
    fun frente(): Any?         // R
    fun desenfileirar(): Any?  // D

    // Métodos auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}