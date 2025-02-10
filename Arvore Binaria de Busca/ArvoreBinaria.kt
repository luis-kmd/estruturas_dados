interface ArvoreBinaria<T : Comparable<T>> {
    fun insere(valor: T): Boolean
    fun remove(valor: T): Boolean
    fun busca(valor: T): T?
}
