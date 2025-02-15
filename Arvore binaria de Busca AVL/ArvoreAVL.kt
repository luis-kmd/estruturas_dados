interface ArvoreAVL<T : Comparable<T>> {
    fun insere(valor: T): Boolean
    fun busca(valor: T): T?
    fun remove(valor: T): Boolean
}