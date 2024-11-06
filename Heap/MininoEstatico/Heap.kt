fun main() {
    val heap = Monte(10)

    println("Inserindo elementos na heap:")
    heap.inserir(10)
    heap.inserir(5)
    heap.inserir(3)
    heap.inserir(2)
    heap.inserir(15)

    println("Heap após inserções: ${heap.imprimir()}")

    println("Elemento raiz (mínimo): ${heap.buscar()}")

    println("Extraindo o elemento mínimo:")
    println("Elemento extraído: ${heap.extrair()}")
    println("Heap após extração: ${heap.imprimir()}")

    println("Atualizando o elemento raiz para 1:")
    heap.atualizar(1)
    println("Heap após atualização: ${heap.imprimir()}")
}