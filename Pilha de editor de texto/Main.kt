fun main() {
    val editor = PilhaDeTexto(5)
    
    editor.digitar("Primeira linha.")
    editor.digitar("Segunda linha.")
    editor.digitar("Terceira linha.")
    
    editor.imprimir() 

    editor.desfazer() 
    
    editor.imprimir() 
}
