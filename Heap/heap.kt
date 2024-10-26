// ESTRUTURA DE DADOS (MONTE)
// ED ÁRVORE BINÁRIA HEAP
// RAIZ (ROOT)
//  HEAP MÁXIMA 
//    NÓ GENITOR É SEMPRE MAIOR QUE OS FILHOS (NÚMERICOS INTEIROS)
//  HEAP MÍNIMA
//    NÓ GENITOR É SEMPRE MENOR QUE OS NÓS FILHOS

Monte HEAP
    fun inserir(dado: Long)
    fun buscar(): Long
    atualizar(dado: Long)
    extrair()