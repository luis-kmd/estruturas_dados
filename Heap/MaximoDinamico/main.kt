fun main() {
    val heap = MonteMaximoDinamico(5)

    println("Heap Inicial: ${heap.imprimir()}")
    heap.inserir(10)
    heap.inserir(20)
    heap.inserir(15)
    heap.inserir(30)
    heap.inserir(40)

    println("Heap após inserções: ${heap.imprimir()}")
    println("Maior elemento (obter): ${heap.obter()}")

    heap.extrair()
    println("Heap após extrair o maior elemento: ${heap.imprimir()}")
}