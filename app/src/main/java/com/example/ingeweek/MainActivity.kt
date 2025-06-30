package com.example.ingeweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.ingeweek.databinding.ActivityMainBinding
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        // Verificación de depuración
        if (binding.bottomNavigation == null) {
            println("Error: bottomNavigation es nulo")
        } else {
            println("bottomNavigation encontrado")
        }

        // Configura el BottomNavigationView
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            println("Seleccionando item: ${item.title}") // Depuración adicional
            when (item.itemId) {
                R.id.nav_agenda -> {
                    replaceFragment(AgendaFragment())
                    true
                }
                R.id.nav_competencias -> {
                    replaceFragment(CompetenciasFragment())
                    true
                }
                R.id.nav_seminarios -> {
                    replaceFragment(SeminariosFragment())
                    true
                }
                else -> false
            }
        }

        // Carga el fragmento Agenda por defecto al iniciar
        if (savedInstanceState == null) {
            println("Inicializando fragmento por defecto: AgendaFragment") // Depuración
            replaceFragment(AgendaFragment())
        }
    }

    // Método para reemplazar fragmentos
    private fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        try {
            println("Intentando reemplazar fragmento: ${fragment.javaClass.simpleName}")
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.setReorderingAllowed(true)
            transaction.addToBackStack(null)
            transaction.commit()
            println("Fragmento reemplazado con éxito")
        } catch (e: Exception) {
            println("Error en transacción: ${e.message}")
        }
    }

    // Infla el menú en la Toolbar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Maneja las selecciones del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                Toast.makeText(this, "Acerca de IngeWeek", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_share -> {
                Toast.makeText(this, "Compartir IngeWeek", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_update_agenda -> {
                Toast.makeText(this, "Actualizando Agenda...", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}