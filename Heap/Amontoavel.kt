interface Amontoavel{

// METODOS PRINCIPAIS
    fun inserir(dado: Long)
    fun buscar(): Long?
    atualizar(novoDado: Long)
    extrair(): Long

// METODOS AUXILIARES
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}

// ESTRUTURA DE DADOS (MONTE)
// ED ÁRVORE BINÁRIA HEAP
// RAIZ (ROOT)
//  HEAP MÁXIMA 
//    NÓ GENITOR É SEMPRE MAIOR QUE OS FILHOS (NÚMERICOS INTEIROS)
//  HEAP MÍNIMA
//    NÓ GENITOR É SEMPRE MENOR QUE OS NÓS FILHOS
