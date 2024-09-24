fun main() {
    var pilha: Empilhavel = Pilha(8)

    // Inserir dados na pilha
    pilha.empilhar("Instituto")
    pilha.empilhar("Federal")

    println(pilha.imprimir()) 
    // Vai imprimir o conteúdo da pilha
    pilha.desempilhar()
    println(pilha.imprimir())
}
