fun main() {
    val heap = MonteMaximo(5)

    heap.inserir(15)
    heap.inserir(35)
    heap.inserir(25)

    println("Heap após inserções: ${heap.imprimir()}")
    println("Maior elemento (obter): ${heap.obter()}")

    println("Extraindo o maior elemento: ${heap.extrair()}")
    println("Heap após extração: ${heap.imprimir()}")
}
