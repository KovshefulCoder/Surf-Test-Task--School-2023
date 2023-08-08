package ru.kovsh.surftesttask.ui.mainScreen

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ru.kovsh.surftesttask.R
import ru.kovsh.surftesttask.entities.Cocktail
import ru.kovsh.surftesttask.ui.theme.Backgroud
import ru.kovsh.surftesttask.ui.theme.BlueIconsColor
import ru.kovsh.surftesttask.ui.theme.BottomBarColor
import ru.kovsh.surftesttask.ui.theme.MainTextColor
import ru.kovsh.surftesttask.ui.theme.typography
import ru.kovsh.surftesttask.viewModels.CocktailEditViewModel
import ru.kovsh.surftesttask.viewModels.CocktailsViewModel

@Composable
internal fun MainScreen(
    onCocktailEditClicked: (Cocktail) -> Unit,
    viewModel: CocktailsViewModel
) {
    val cocktails by viewModel.cocktails.collectAsState()
    MainScreen(
        cocktails = cocktails,
        onCocktailEditClicked = onCocktailEditClicked
    )
}

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun MainScreen(
    cocktails: List<Cocktail>,
    onCocktailEditClicked: (Cocktail) -> Unit,
) {
    var bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    var pickedCocktailID by rememberSaveable { mutableStateOf(-1) }
    Box(
    ) {
        ModalBottomSheetLayout(
            sheetContent = {
                CocktailDerailsScreen(
                    cocktail = cocktails.find { it.id == pickedCocktailID } ?: Cocktail(),
                    onEditClicked = {
                        coroutineScope.launch {
                            bottomSheetState.hide()
                        }
                        onCocktailEditClicked(it)
                    },
                )
            },
            sheetState = bottomSheetState,
            sheetBackgroundColor = Backgroud,
            sheetShape = RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp),
            scrimColor = Color.Black.copy(alpha = 0.5f),
            sheetElevation = 32.dp,
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
                        onClick = { onCocktailEditClicked(Cocktail()) },
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
                            .fillMaxWidth().padding(bottom = 64.dp)
                    ) {
                        items(cocktails) { cocktail ->
                            CocktailCard(
                                cocktail,
                                onCocktailClicked = {
                                    coroutineScope.launch {
                                        pickedCocktailID = it.id
                                        bottomSheetState.show()
                                        Log.i("MainScreen", "pickedCocktailID = $pickedCocktailID")
                                    }
                                }
                            )
                        }
                    }
                }
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

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun PrevDetails() {
    CocktailDerailsScreen(
        cocktail = Cocktail(
            0,
            "Title",
            "description",
            "recipe",
        ), {}
    )
}

@Composable
fun CocktailDerailsScreen(
    cocktail: Cocktail,
    onEditClicked: (Cocktail) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val lazyState = rememberLazyListState()
    val ingredients = listOf<String>() // replace to query to database TODO()
    Box(
        modifier = Modifier
            .height(478.dp)
    )
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            state = lazyState,
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
                Text(
                    text = cocktail.description,
                    color = MainTextColor,
                    style = typography.subtitle1.copy(
                        fontWeight = FontWeight.Normal
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(32.dp))
                for (ingredient in ingredients) {
                    Text(
                        text = ingredient,
                        color = MainTextColor,
                        style = typography.subtitle1.copy(
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
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Recipe:",
                    color = MainTextColor,
                    style = typography.subtitle1.copy(
                        fontWeight = FontWeight.Normal
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = cocktail.recipe,
                    color = MainTextColor,
                    style = typography.subtitle1.copy(
                        fontWeight = FontWeight.Normal
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        onEditClicked(cocktail)
                        coroutineScope.launch {
                            lazyState.scrollToItem(0)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = BlueIconsColor,
                    )
                ) {
                    Text(
                        text = "Edit",
                        style = typography.h2.copy(
                            color = Backgroud,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
            }
        }
    }
}