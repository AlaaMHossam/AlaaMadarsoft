package app.madar.alaamadarsoft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import app.madar.alaamadarsoft.ui.add_person.AddPersonScreen
import app.madar.alaamadarsoft.ui.navigation.AddPersonDestination
import app.madar.alaamadarsoft.ui.navigation.PeopleDestination
import app.madar.alaamadarsoft.ui.people.PeopleScreen
import app.madar.alaamadarsoft.ui.theme.AlaaMadarsoftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val backStack = rememberNavBackStack(AddPersonDestination)

            AlaaMadarsoftTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    NavDisplay(
                        modifier = Modifier.padding(paddingValues),
                        backStack = backStack,
                        onBack = { backStack.removeLastOrNull() },
                        entryProvider = entryProvider {
                            entry<AddPersonDestination> {
                                AddPersonScreen(navigateToPeople = {
                                    backStack.add(PeopleDestination)
                                })
                            }
                            entry<PeopleDestination> { PeopleScreen() }
                        })
                }
            }
        }
    }
}