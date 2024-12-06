fun main() {
    val heap = MonteMinimoDinamico(5)

    println("Heap Inicial: ${heap.imprimir()}")
    heap.inserir(40)
    heap.inserir(30)
    heap.inserir(15)
    heap.inserir(10)
    heap.inserir(20)

    println("Heap após inserções: ${heap.imprimir()}")
    println("Menor elemento (obter): ${heap.obter()}")

    heap.extrair()
    println("Heap após extrair o menor elemento: ${heap.imprimir()}")
}