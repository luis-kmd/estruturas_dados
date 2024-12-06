interface Listavel {
    fun inserir(dado: Any?, posicao: Int)
    fun anexar(dado: Any?)
    fun atualizar(dado: Any?, posicao: Int)
    fun apagar(posicao: Int): Any?
    fun limpar()
    fun selecionar(posicao: Int): Any?
    fun selecionarTodos(): Array<Any?>
    fun ordenar()
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}