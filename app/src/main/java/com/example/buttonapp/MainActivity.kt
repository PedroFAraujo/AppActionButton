package com.example.buttonapp

import android.os.Bundle
import android.util.Log
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buttonapp.ui.theme.BButtonColors
import com.example.buttonapp.ui.theme.ButtonAppTheme
import com.example.buttonapp.ui.theme.IButtonColors
import com.example.buttonapp.ui.theme.MBButtonColors
import com.example.buttonapp.ui.theme.RButtonColors


const val TAG = "TestAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    textColor: Color,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ){
        Text(text = text)
    }
}

@Composable
private fun App(){
    val image = painterResource(R.drawable.logo_etec)
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){
        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = image,
                contentDescription = stringResource(R.string.string_logo_etec),
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = stringResource(R.string.string_titulo_pam),
                color = Color.Black,
                fontSize = 24.sp
            )

            ActionButton(
                text = "I",
                textColor = Color.White,
                buttonColors = IButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                /*Ação do Botão*/
                Log.e(TAG, "App: Nota: I!")
            }

            ActionButton(
                text = "R",
                textColor = Color.White,
                buttonColors = RButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                /*Ação do Botão*/
                Log.w(TAG, "App: Nota: R!")
            }

            ActionButton(
                text = "B",
                textColor = Color.White,
                buttonColors = BButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                /*Ação do Botão*/
                Log.i(TAG, "App: Nota B!")
            }

            ActionButton(
                text = "MB",
                textColor = Color.White,
                buttonColors = MBButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                /*Ação do Botão*/
                Log.d(TAG, "App: Nota: MB!")
            }

        }
    }
}
