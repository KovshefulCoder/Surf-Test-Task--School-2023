package ru.kovsh.surftesttask.ui.mainScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.kovsh.surftesttask.R
import ru.kovsh.surftesttask.entities.Cocktail
import ru.kovsh.surftesttask.ui.theme.Backgroud
import ru.kovsh.surftesttask.ui.theme.BottomBarColor
import ru.kovsh.surftesttask.ui.theme.MainTextColor
import ru.kovsh.surftesttask.ui.theme.typography
import ru.kovsh.surftesttask.viewModels.CocktailEditViewModel

@Composable
internal fun MainScreen(
) {
    MainScreen(
        listOf(
            Cocktail(0, "Title1", "", "", listOf()),
            Cocktail(0, "Title2", "", "", listOf()),
            Cocktail(0, "Title3", "", "", listOf()),
            Cocktail(0, "Title4", "", "", listOf()),
            Cocktail(0, "Title5", "", "", listOf()),
            Cocktail(0, "Title6", "", "", listOf()),
            Cocktail(0, "Title7", "", "", listOf()),
            Cocktail(0, "Title8", "", "", listOf()),
        ),
    )
}

//@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
//@Composable
//fun PrevMainScreen() {
//    MainScreen(
//        listOf(
//            Cocktail(0, "Title1", "", "", listOf()),
//            Cocktail(0, "Title2", "", "", listOf()),
//            Cocktail(0, "Title3", "", "", listOf()),
//            Cocktail(0, "Title4", "", "", listOf()),
//            Cocktail(0, "Title5", "", "", listOf()),
//            Cocktail(0, "Title6", "", "", listOf()),
//            Cocktail(0, "Title7", "", "", listOf()),
//            Cocktail(0, "Title8", "", "", listOf()),
//        )
//    )
//}

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun MainScreen(
    cocktalis: List<Cocktail>,
) {
    var isCocktailClicked by rememberSaveable { mutableStateOf(Pair(false, Cocktail())) }
    Box(
    ) {
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier
                        .height(65.dp)
                        .clip(RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp))
                        .shadow(
                            shape = RoundedCornerShape(corner = CornerSize(4.dp)),
                            elevation = 10.dp,
                            ambientColor = Color.Black,
                            spotColor = Color.Black,
                        ),
                    cutoutShape = CircleShape,
                    backgroundColor = BottomBarColor,
                    elevation = 22.dp
                ) {

                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    backgroundColor = Color.Transparent,
                    contentColor = Color.Transparent
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "image description",
                    )
                }
            }
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "My cocktails",
                    color = MainTextColor,
                    style = typography.h1.copy(
                        fontWeight = FontWeight.Light
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(24.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(cocktalis) { cocktail ->
                        CocktailCard(
                            cocktail,
                            onCocktailClicked = {
                                isCocktailClicked = Pair(true, it)
                            }
                        )
                    }
                }
            }
        }
        if (isCocktailClicked.first) {
            ModalBottomSheetLayout(
                sheetContent = {
                    CocktailDerailsScreen(isCocktailClicked.second)
                },
                sheetBackgroundColor = Backgroud,
                sheetShape = RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp),
                scrimColor = Color.Black.copy(alpha = 0.5f),
                sheetElevation = 22.dp,
            ) {

            }
        }
    }
}

@Composable
fun CocktailCard(
    cocktail: Cocktail,
    onCocktailClicked: (Cocktail) -> Unit
) {
    val shape = RoundedCornerShape(8.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(White, shape = shape)
            .clickable { onCocktailClicked(cocktail) },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cocktail_background),
            contentDescription = "Cocktail + ${cocktail.title}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape)
        )
        Text(
            text = cocktail.title,
            style = typography.h4.copy(
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            color = White
        )
    }
}

@Preview
@Composable
fun PrevDetails() {
    CocktailDerailsScreen(cocktail = Cocktail(0, "Title", "", "", listOf("first", "second")))
}

@Composable
fun CocktailDerailsScreen(cocktail: Cocktail) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = cocktail.title,
                color = MainTextColor,
                style = typography.h1.copy(
                    fontWeight = FontWeight.Normal
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            for (ingredient in cocktail.ingredients) {
                Text(
                    text = ingredient,
                    color = MainTextColor,
                    style = typography.h3.copy(
                        fontWeight = FontWeight.Light
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = "Line"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(cocktail.ingredients) { ingredient ->
                    Text(
                        text = ingredient,
                        color = MainTextColor,
                        style = typography.h3.copy(
                            fontWeight = FontWeight.Light
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}