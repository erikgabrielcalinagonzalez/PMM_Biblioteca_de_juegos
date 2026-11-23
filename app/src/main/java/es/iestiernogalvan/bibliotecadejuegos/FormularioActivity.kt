package es.iestiernogalvan.bibliotecadejuegos

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormularioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.botonGuardar.setOnClickListener { guardar() }
        binding.botonCancelar.setOnClickListener { finish() }

    }

    private fun guardar() {
        val titulo = binding.editTitulo.text.toString().trim()
        val autor = binding.editAutor.text.toString().trim()

        if (titulo.isEmpty()) {
            binding.editTitulo.error = getString(R.string.error_obligatorio)
            binding.editTitulo.requestFocus()
            return
        }

        if (autor.isEmpty()) {
            binding.editAutor.error = getString(R.string.error_obligatorio)
            binding.editAutor.requestFocus()
            return
        }

        val genero = binding.spinnerGenero.selectedItem.toString()
        val formato = when (binding.grupoFormato.checkedRadioButtonId) {
            R.id.radio_electronico -> getString(R.string.electronico)
            R.id.radio_audiolibro -> getString(R.string.audiolibro)
            else -> getString(R.string.papel)
        }
        val leido = binding.checkLeido.isChecked

    Biblioteca.anadir(titulo, autor, genero, formato, leido)
    Toast.makeText(this, R.string.libro_guardado, Toast.LENGTH_SHORT).show()
    finish()
    }



}