fun main() {
    val arvore: ArvoreBinaria<Int> = ABB()

    // Inserção
    arvore.insere(6)
    arvore.insere(2)
    arvore.insere(7)
    arvore.insere(1)
    arvore.insere(4)

    // Busca
    println(arvore.busca(4)) // Saída: 4
    println(arvore.busca(10)) // Saída: null

    // Remoção
    arvore.remove(2)
    println(arvore.busca(2)) // Saída: null
}
