fun Main(){
    var pilha: Empilhavel = PilhaInvertida(7)

    pilha.empilhar("primeiro")
    pilha.empilhar("segundo")
    pilha.empilhar("terceiro")
    pilha.empilhar("quarto")
    pilha.empilhar("quinto")
    println(pilha.imprimir())
    pilha.empilhar("teste")
    pilha.atualizar("Opa")
    println(pilha.imprimir())
    println(pilha.observar())

}