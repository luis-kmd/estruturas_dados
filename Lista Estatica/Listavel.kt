interface Listavel{
// Metodos principais
    fun inserir(posicao: Int, dado: Any?)              // C
    fun anexar(dado: Any?)                             // C
    fun  selecionar(posicao: Int): Any?                // R
    fun  selecionarTodos(): Array<Any?>                // R
    fun atualizar(posicao: Int, dado: Any?)            // U
    fun apagar(posicao: Int): Any?                     // D
    fun limpar(): Boolean                              // D

// Metodos auxiliares
    fun imprimir(): String
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
}

// metodos extas
// fun inserirInicio(dado: Any)
// fun selecionarInicio(): Any?
// fun atualizarFim(dado: Any?)
