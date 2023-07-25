package com.example.mycountor

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycountor.CountorViewModel.CountorViewModel
import com.example.mycountor.CountorViewModel.CountorViewModelFactory
import com.example.mycountor.ui.theme.MyCountorTheme

class MainActivity : ComponentActivity() {


    private val countorModel: CountorViewModel by viewModels{CountorViewModelFactory()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MyCountorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            showCount()
                            Spacer(modifier = Modifier.size(10.dp))
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                myButton(text = "Up")
                                myButton(text = "Down")
                                myButton(text = "Reset")
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun showCount(){
        Text(text = countorModel.count.toString())
    }


    @Composable
    fun myButton(text:String){

        Button(onClick = {
             when(text){
                 "Up"-> countorModel.countUp()
                 "Down"-> countorModel.countDw()
                 else -> countorModel.countRs()
             }
        },

        ) {

            when(text){
                "Up"-> Icon(
                    Icons.Filled.KeyboardArrowUp,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                "Down"-> Icon(
                    Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                else-> Icon(
                    Icons.Filled.Delete,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = text)
        }
    }
}



