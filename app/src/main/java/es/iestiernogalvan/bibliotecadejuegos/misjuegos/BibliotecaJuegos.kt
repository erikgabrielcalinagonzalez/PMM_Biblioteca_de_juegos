package es.iestiernogalvan.bibliotecadejuegos.misjuegos

object BibliotecaJuegos {
    val juegos = mutableListOf(
        Juego(1, "Cien años de soledad", "Gabriel García Márquez", "Novela", "Papel", true),
        Juego(2, "Sapiens", "Yuval Noah Harari", "Ensayo", "Electrónico", false),
        Juego(3, "Veinte poemas de amor y una canción desesperada", "Pablo Neruda", "Poesía", "Papel", true)
    )
    private var ultimoId = juegos.size

    fun anadir(titulo: String, autor: String, genero: String, formato: String, leido: Boolean) {
        ultimoId++
        juegos.add(Juego(ultimoId, titulo, autor, genero, formato, leido))
    }
    fun buscar(id: Int): Juego? = juegos.find { it.id == id }
    fun borrar(id: Int) {
        juegos.removeAll { it.id == id }
    }
    fun borrarTodos() {
        juegos.clear()
    }
}