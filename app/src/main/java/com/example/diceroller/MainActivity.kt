package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
               DiceRollerApp()

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DiceRollerApp(){
 DiceWIthButtonAndImage(modifier = Modifier
     .fillMaxSize()
     .wrapContentSize(Alignment.Center))
    Spacer(modifier = Modifier.height(20.dp))

}
@Composable
fun DiceWIthButtonAndImage(modifier: Modifier = Modifier){

    var result by remember {
        mutableStateOf(1)
    }


    val imageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
       Image(painter = painterResource(id = imageResource), contentDescription = result.toString())

        Button(onClick = {result = (1..6).random()}, shape = RoundedCornerShape(12.dp)) {
           Text(stringResource(R.string.roll))

       }
    }

}
