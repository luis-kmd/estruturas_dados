fun main() {
    val lista: Listavel = ListaDinamica(10)
    lista.inserir(5, 0)
    lista.inserir(6, 0)
    lista.inserir(7, 1)
    lista.inserir(10, 0)
    lista.inserir(8, 3)

    println("Lista: ${lista.imprimir()}")

    lista.apagar(2)
    println("Após apagar posição 2: ${lista.imprimir()}")

    lista.atualizar(15, 1)
    println("Após atualizar posição 1 com 15: ${lista.imprimir()}")

    println("Elemento na posição 3: ${lista.selecionar(3)}")

    lista.ordenar()
    println("Lista ordenada: ${lista.imprimir()}")

    lista.limpar()
    println("Lista após limpar: ${lista.imprimir()}")
}
