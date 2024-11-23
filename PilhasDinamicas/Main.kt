fun main() {
    var pilha: Empilhavel = PilhaDinamica(8)

    pilha.empilhar("Instituto")
    pilha.empilhar("Federal")
    println(pilha.imprimir()) // Vai imprimir o conteúdo da pilha
    pilha.desempilhar()
    println(pilha.imprimir())
}
