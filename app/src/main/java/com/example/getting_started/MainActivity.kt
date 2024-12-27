package com.example.getting_started

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import com.example.getting_started.ui.theme.Getting_startedTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * ##Lifecycle Methods##
         * onCreate()
         * onStart()
         * onRestoreInstanceState()
         * onResume()
         * onPause()
         * onSaveInstanceState()
         * onStop()
         * onDestroy()
         * ##Lifecycle Methods##
         */
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            MainScreen(MainActivityViewModel())
        }
    }
}

@Composable
fun MainScreen(mainActivityViewModel:MainActivityViewModel?) {
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

    mainActivityViewModel?.counter?.observeAsState()?.value?.let {
        Log.i("MainScreen", "A Counter value is now: ${mainActivityViewModel.counter?.value}")
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
                onClick = { mainActivityViewModel?.incrementClickHandler?.invoke() },
                modifier = Modifier.padding(5.dp)
            ) {
                Text("Good Click 🙏")
            }

            Text(text = "${mainActivityViewModel?.counter?.value ?: 0}")

            Button(
                onClick = { mainActivityViewModel?.decrementClickHandler?.invoke() },
                modifier = Modifier.padding(5.dp)
            ) {
                Text("Bad Click 😈")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen(MainActivityViewModel())
}