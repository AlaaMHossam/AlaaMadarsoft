package app.madar.alaamadarsoft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import app.madar.alaamadarsoft.ui.add_person.AddPersonScreen
import app.madar.alaamadarsoft.ui.theme.AlaaMadarsoftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlaaMadarsoftTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    AddPersonScreen(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}