fun main() {
    val fila = FilaDinamica(5)

    println("Enfileirando elementos 10, 20, 30...")
    fila.enfileirar(10)
    fila.enfileirar(20)
    fila.enfileirar(30)

    println("Fila atual: ${fila.imprimir()}")
    println("Elemento na frente da fila: ${fila.frente()}")

    println("Atualizando o elemento da frente para 99...")

    fila.atualizar(99)
    println("Fila após atualização: ${fila.imprimir()}")

    println("Desenfileirando elemento...")
    println("Elemento removido: ${fila.desenfileirar()}")
    println("Fila após desenfileirar: ${fila.imprimir()}")

    println("Fila está cheia? ${fila.estaCheia()}")
    println("Fila está vazia? ${fila.estaVazia()}")
}
