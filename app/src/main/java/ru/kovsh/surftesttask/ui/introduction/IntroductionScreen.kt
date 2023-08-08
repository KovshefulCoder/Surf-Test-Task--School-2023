package ru.kovsh.surftesttask.ui.introduction

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.kovsh.surftesttask.R
import ru.kovsh.surftesttask.ui.theme.MainTextColor
import ru.kovsh.surftesttask.ui.theme.SecondTextColor

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun PrevIntroductionScreen() {
    IntroductionScreen {

    }
}

@Composable
fun IntroductionScreen(
    onFirstCocktailCreate: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.introduction_image),
                contentDescription = "Andy Rubin",
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "My cocktails",
                color = MainTextColor,
                style = ru.kovsh.surftesttask.ui.theme.typography.h1.copy(
                    fontWeight = FontWeight.Light
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .weight(1f)
                    .fillMaxSize()
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                )
                {
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier.weight(1f)
                    )
                    {
                        Text(
                            text = "Add your first cocktail here",
                            color = SecondTextColor,
                            style = ru.kovsh.surftesttask.ui.theme.typography.subtitle2.copy(
                                fontWeight = FontWeight.Light
                            ),
                            textAlign = TextAlign.Center,
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
                Image(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = "image description",
                    modifier = Modifier
                        .weight(0.8f)
                        .fillMaxSize()
                )
                IconButton(
                    onClick = {
                        onFirstCocktailCreate()
                    },
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "image description",
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

    }
}