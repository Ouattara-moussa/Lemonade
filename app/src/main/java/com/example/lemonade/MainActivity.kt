package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        fontWeight = FontWeight.Bold
                    )
                },
                // Couleur jaune exacte de la barre supérieure (TopAppBar)
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFF9E44C)
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> LemonTextAndImage(
                    textResourceId = R.string.lemon_select,
                    imageResourceId = R.drawable.lemon_tree,
                    contentDescriptionResourceId = R.string.lemon_tree_content_description,
                    onImageClick = {
                        currentStep = 2
                        squeezeCount = (2..4).random()
                    }
                )
                2 -> LemonTextAndImage(
                    textResourceId = R.string.lemon_squeeze,
                    imageResourceId = R.drawable.lemon_squeeze,
                    contentDescriptionResourceId = R.string.lemon_content_description,
                    onImageClick = {
                        squeezeCount--
                        if (squeezeCount == 0) {
                            currentStep = 3
                        }
                    }
                )
                3 -> LemonTextAndImage(
                    textResourceId = R.string.lemon_drink,
                    imageResourceId = R.drawable.lemon_drink,
                    contentDescriptionResourceId = R.string.lemonade_content_description,
                    onImageClick = { currentStep = 4 }
                )
                4 -> LemonTextAndImage(
                    textResourceId = R.string.lemon_empty,
                    imageResourceId = R.drawable.lemon_restart,
                    contentDescriptionResourceId = R.string.empty_glass_content_description,
                    onImageClick = { currentStep = 1 }
                )
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    textResourceId: Int,
    imageResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(40.dp),
            // Couleur vert menthe / vert clair exacte du fond du bouton
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC3ECD2)
            )
        ) {
            Image(
                painter = painterResource(imageResourceId),
                contentDescription = stringResource(contentDescriptionResourceId),
                modifier = Modifier
                    .width(128.dp)
                    .height(160.dp)
                    .padding(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textResourceId),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}