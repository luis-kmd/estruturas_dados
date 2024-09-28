interface Listavel{
// Metodos principais
    fun inserir(posicao: Int, dado: Any?)              // C     // O(N)
    fun anexar(dado: Any?)                             // C     // O(1)
    fun  selecionar(posicao: Int): Any?                // R     // O(1)
    fun  selecionarTodos(): Array<Any?>                // R     // O(N)
    fun atualizar(posicao: Int, dado: Any?)            // U     // O(1)
    fun apagar(posicao: Int): Any?                     // D     // O(N)
    fun limpar()                                       // D     // O(1)

// Metodos auxiliares
    fun imprimir(): String
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
}

// metodos extas
// fun inserirInicio(dado: Any)
// fun selecionarInicio(): Any?
// fun atualizarFim(dado: Any?)
