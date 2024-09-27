interface Editavel{

    fun digitar(texto: String)
    fun desfazer(): Any?
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun espiar(): Any?
    fun imprimir(): Any?
}
