package com.gdev.jetpack.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gdev.jetpack.compose.ui.theme.HelloComposeTheme

class StatelessMainActivity : ComponentActivity() {
    private val viewModel: HelloViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloComposeTheme(darkTheme = true) {
                Surface(color = MaterialTheme.colors.background) {
                    HelloScreen(helloViewModel = viewModel)
                }
            }
        }
    }
}

//class ViewModel
class HelloViewModel : ViewModel() {
    //LiveData holds state which is observed by the UI
    //(state flows down from ViewModel
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    //onNameChange is an event we're defining that the UI can invoke
    // (events flow up from UI)

    fun onNameChange(newName: String) {
        _name.value = newName
    }
}

@Composable
fun HelloScreen(helloViewModel: HelloViewModel) {
    //by default, viewModel() follows the Livecycle as the Activity or fragments
    //that calls HelloScreen(). this lifecycle can be modified by callers of HelloScreen.
    //name is the current value of [helloViewModel.name]
    //with an initial value of ""
    val name: String by helloViewModel.name.observeAsState("")
    HelloContent(name = name, onNameChange = { helloViewModel.onNameChange(it) })
}

@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    var greeting by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        //Text Greeting
        TextGreeting(greeting)

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name")
        })

        //Button Click Me
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = { if (name.isEmpty()) Toast.makeText(context, "Enter Name", Toast.LENGTH_SHORT).show() else greeting = name }) {
            Text(text = "Click Me")
        }
    }
}

@Composable
fun TextGreeting(name: String) {
    Text(
        text = if (name.isEmpty()) "Hello Whats up !" else "Hello $name !",
        modifier = Modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.h5
    )
}