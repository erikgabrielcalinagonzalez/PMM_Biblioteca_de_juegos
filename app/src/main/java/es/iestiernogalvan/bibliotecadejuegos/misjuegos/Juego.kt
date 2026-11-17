package es.iestiernogalvan.bibliotecadejuegos.misjuegos

data class Juego(
    val id: Int,
    val titulo: String,
    val desarrolladora: String,
    val genero: String,
    val formato: String,
    val jugado: Boolean
)
