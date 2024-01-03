package com.cs407.kotlincompose_composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cs407.kotlincompose_composequadrant.ui.theme.KotlinCompose_ComposeQuadrantTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinCompose_ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    fourBoxComposeApp()
                }
            }
        }
    }
}

//used to set our data to the Compose UI structure
@Composable
fun fourBoxComposeApp(modifier: Modifier = Modifier) {
    fourBoxCompose(
        textTitle = stringResource(R.string.textTitle), textDescription = stringResource(R.string.textDescription) , backgroundColor1=  colorResource(R.color.box1color),
        imageTitle = stringResource(R.string.imgTitle), imageDescription = stringResource(R.string.imgDescription), backgroundColor2=  colorResource(R.color.box2color),
        rowTitle = stringResource(R.string.rowTitle), rowDescription = stringResource(R.string.rowDescription), backgroundColor3=  colorResource(R.color.box3color),
        columnTitle = stringResource(R.string.columnTitle), columnDescription = stringResource(R.string.columnDescription), backgroundColor4=  colorResource(R.color.box4color)
    )
}

//used to set the Compose UI structure for 4 boxes
@Composable
fun fourBoxCompose(textTitle: String, textDescription: String, backgroundColor1: Color,
                   imageTitle: String, imageDescription: String, backgroundColor2: Color,
                   rowTitle: String, rowDescription: String, backgroundColor3: Color,
                   columnTitle: String, columnDescription: String, backgroundColor4: Color,
                   modifier: Modifier = Modifier) {
    Column(
        //TODO: fillMaxWidth makes the composable fill the maximum width given to it from its parent.
        // Although not needed for our program since the width can be gained from the parent, which is
        // where we declare in our setContent
        modifier.fillMaxWidth()
    ) {
        Row(modifier.weight(1f)) {
            //TODO: note, pass on weight so our 2x2 grid can show
            boxCompose(title = textTitle, description = textDescription, backgroundColor = backgroundColor1, modifier= modifier.weight(1f))
            boxCompose(title = imageTitle, description = imageDescription, backgroundColor = backgroundColor2, modifier= modifier.weight(1f))
        }
        Row(modifier.weight(1f)) {
            boxCompose(title = rowTitle, description = rowDescription, backgroundColor = backgroundColor3, modifier.weight(1f))
            boxCompose(title = columnTitle, description = columnDescription, backgroundColor = backgroundColor4, modifier= modifier.weight(1f))
        }
    }
}


//single box compose UI structure
@Composable
fun boxCompose(title: String, description: String, backgroundColor: Color, modifier: Modifier = Modifier){
    Column(
        //TODO: note: arrange column layout text to be centered
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier= modifier
            //TODO: makes sure that with full size, we put our backgroud color to our padding
            .fillMaxSize()
            //TODO: note that padding and backgroundColor is put with modifier. AND
            // AND order matters. padding will have background color if color has been specified before
            // declaring background color
            .background(backgroundColor)
            .padding(16.dp)
    ){
        Text(
            text= title,
            //TODO: NOTE: to make a new modifier, for example here we need a new one and not the paremeter
            // version because it has .weight(1f) passed onto it, we just say Modifier with a capital M
            modifier = Modifier.padding(bottom = 16.dp),
            //TODO: note: upper case F for Font, then .Bold
            fontWeight = FontWeight.Bold
        )
        Text(
            text= description,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun fourBoxComposeAppPreview() {
    KotlinCompose_ComposeQuadrantTheme {
        fourBoxComposeApp()
    }
}


//Reference code from Googles learning lab guide
/**
@Composable
fun ComposeQuadrantApp() {
    Column(
        //Modifier.fillMaxWidth()
    ) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.textTitle),
                description = stringResource(R.string.textDescription),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.imgTitle),
                description = stringResource(R.string.imgDescription),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.rowTitle),
                description = stringResource(R.string.rowDescription),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.columnTitle),
                description = stringResource(R.string.columnDescription),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp).weight(1f),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantAppPreview() {
    KotlinCompose_ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}
**/