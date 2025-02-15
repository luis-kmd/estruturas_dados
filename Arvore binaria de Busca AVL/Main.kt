fun main() {
    val arvore = AVL<Int>()
    val valores = listOf(10, 20, 30, 40, 50, 25)

    for (valor in valores) arvore.insere(valor)
    println("Árvore em pré-ordem após inserção:")
    arvore.preOrdem()
    println()

    println("Removendo 30...")
    arvore.remove(30)
    println("Árvore em pré-ordem após remoção:")
    arvore.preOrdem()
    println()

    println("Buscando 25: ${arvore.busca(25)}") 
    println("Buscando 100: ${arvore.busca(100)}")
}