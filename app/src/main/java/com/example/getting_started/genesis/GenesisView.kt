package com.example.getting_started.genesis

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun GenesisView(genesisViewModel: GenesisViewModel?) {
    /**
     * The mutable class allows the composable to listen for state changes. On state change its re-renders (invokes) the composable again
     *
     * The remember allows the composable to remember its old state (previous state).
     *
     * to use `by` delegate function import the below
     *
     * import androidx.compose.runtime.getValue
     * import androidx.compose.runtime.setValue
     *
     */
////    var counter = remember { mutableIntStateOf(0) };
////    var counter by remember { mutableIntStateOf(0) };
//    var counter by rememberSaveable { mutableIntStateOf(0) };
//    val incrementClickHandler = {
//        counter++
////        counter.intValue = counter.intValue + 1
//        Log.i("MainScreen", "Counter value is $counter")
//    }
//    val decrementClickHandler = {
//        counter--
////        counter.intValue = counter.intValue - 1
//        Log.i("MainScreen", "Counter value is $counter")
//    }

    genesisViewModel?.counter?.observeAsState()?.value
    genesisViewModel?.error?.observeAsState()?.value?.let {
//        Log.i("MainScrenn", "Error state change, its now: ${mainActivityViewModel.error.value}")
        Toast.makeText(LocalContext.current, it.toString(), Toast.LENGTH_LONG).show()
    }

    Column(
    modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { genesisViewModel?.incrementClickHandler?.invoke() },
                modifier = Modifier.padding(5.dp)
            ) {
                Text("Good Click 🙏")
            }

            Text(text = "${genesisViewModel?.counter?.value ?: 0}")

            Button(
                onClick = { genesisViewModel?.decrementClickHandler?.invoke() },
                modifier = Modifier.padding(5.dp)
            ) {
                Text("Bad Click 😈")
            }
        }
    }
}