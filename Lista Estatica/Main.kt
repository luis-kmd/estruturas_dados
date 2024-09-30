fun main() {
    val lista = ListaEstatica(5)

    lista.anexar("Primeiro")
    lista.anexar("Segundo")
    lista.anexar("Terceiro")
    println("Após anexar três elementos: " + lista.imprimir())


    val selecionado = lista.selecionar(2)
    println("Elemento na posição 2: $selecionado")

    lista.atualizar(0, "AtualizadoPrimeiro")
    println("Após atualizar o primeiro elemento: " + lista.imprimir())

    val removido = lista.apagar(1)
    println("Elemento removido da posição 1: $removido")
    println("Após remover o elemento da posição 1: " + lista.imprimir())

    val todos = lista.selecionarTodos()
    println("Todos os elementos da lista: " + todos.contentToString())

    lista.limpar()
    println("Após limpar a lista: " + lista.imprimir())
}