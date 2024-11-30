inferface Listavel{
    fun inserir(dado: Any?, posicao: Int)
    fun anexar(dado: Any?)
    fun atualizar(dado: Any?, posicao: Int)
    fun apagar(posicao: Int)
    fun limpar()

    fun selecionar(posicao: Int): Any?
    fun selecionarTodos(): Array<Any?>
    fun ordenar() //S - Sort

    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}