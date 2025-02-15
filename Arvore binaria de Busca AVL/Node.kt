class Node<T : Comparable<T>>(var info: T, var altura: Int = 1) {
    var esq: Node<T>? = null
    var dir: Node<T>? = null
}