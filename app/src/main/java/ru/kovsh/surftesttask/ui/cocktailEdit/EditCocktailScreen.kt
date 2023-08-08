package ru.kovsh.surftesttask.ui.cocktailEdit

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.kovsh.surftesttask.R
import ru.kovsh.surftesttask.entities.Cocktail
import ru.kovsh.surftesttask.ui.theme.Backgroud
import ru.kovsh.surftesttask.ui.theme.BlueIconsColor
import ru.kovsh.surftesttask.ui.theme.ChipColor
import ru.kovsh.surftesttask.ui.theme.ErrorColor
import ru.kovsh.surftesttask.ui.theme.MainTextColor
import ru.kovsh.surftesttask.ui.theme.SecondTextColor
import ru.kovsh.surftesttask.ui.theme.TextFieldColor
import ru.kovsh.surftesttask.ui.theme.typography
import ru.kovsh.surftesttask.viewModels.CocktailEditViewModel

@Composable
internal fun EditCocktailScreen(
    onSave: () -> Unit,
    onBackClicked: () -> Unit,
    viewModel: CocktailEditViewModel,
) {
    val state by viewModel.state.collectAsState()
    EditCocktailScreen(
        ingredients = state.ingredients,
        title = state.title,
        description = state.description,
        recipe = state.recipe,
        onAddIngredient = viewModel::addIngredient,
        onTitleChanged = {
            viewModel.onChangeDataValidityStatus(it.isNotEmpty())
            viewModel.onTitleChange(it)
        },
        titleStatus = state.isValidDataInput,
        onDescriptionChanged = viewModel::onDescriptionChange,
        onRecipeChanged = viewModel::onRecipeChange,
        onBackClicked = onBackClicked,
        onSaveClicked = {
            if (state.title.isEmpty()) {
                viewModel.onChangeDataValidityStatus(false)
            } else {
                //maybe optional
                viewModel.onChangeDataValidityStatus(true)
                onSave()
            }
        }
    )
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun PrevEditCocktailScreen() {
    EditCocktailScreen(
        ingredients = listOf("one", "two", "three"),
        title = "",
        description = "",
        recipe = "",
        onBackClicked = {},
        onSaveClicked = {},
        titleStatus = true
    )
}

@Composable
private fun EditCocktailScreen(
    ingredients: List<String>,
    onAddIngredient: () -> Unit = {},
    title: String,
    titleStatus: Boolean,
    description: String,
    recipe: String,
    onTitleChanged: (String) -> Unit = {},
    onDescriptionChanged: (String) -> Unit = {},
    onRecipeChanged: (String) -> Unit = {},
    onBackClicked: () -> Unit,
    onSaveClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxSize()
                                .size(200.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_photo_placeholder_svg),
                                contentDescription = "image description",
                                modifier = Modifier.fillMaxSize(),
                                //contentScale = ContentScale.FillBounds,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    TitleTextField(
                        title,
                        onTitleChanged,
                        titleStatus
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    DescriptionTextField(
                        description,
                        onDescriptionChanged
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        items(ingredients) {
                            IngredientItem(
                                text = it,
                                onRemove = {}
                            )
                        }
                        item {
                            IconButton(
                                onClick = { },
                                modifier = Modifier.size(36.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_add_idgredient),
                                    contentDescription = "image description",
                                    modifier = Modifier.size(36.dp)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(28.dp))
                    RecipeTextField(
                        recipe,
                        onRecipeChanged
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = onSaveClicked,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = BlueIconsColor,
                        )
                    ) {
                        Text(
                            text = "Save",
                            style = typography.h2.copy(
                                color = Backgroud,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = onBackClicked,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Backgroud,
                        ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = BlueIconsColor
                        )
                    ) {
                        Text(
                            text = "Cancel",
                            style = typography.h2.copy(
                                color = BlueIconsColor,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                }

            }
        }
    }
    BackHandler(onBack = onBackClicked)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandedOptionalTextField(
    text: String,
    onTextChange: (String) -> Unit,
    placeholderText: String,
    labelText: String,
    supportingText: String,
    maxLines: Int = 4,
) {
    OutlinedTextField(
        value = text,
        onValueChange = { onTextChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        maxLines = maxLines,
        shape = RoundedCornerShape(40.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = TextFieldColor,
            cursorColor = Color.Blue,
            textColor = MainTextColor,
            errorBorderColor = ErrorColor
        ),
        label = {
            Text(
                text = labelText,
                style = typography.caption.copy(
                    color = SecondTextColor,
                )
            )
        },
        supportingText = {
            Text(
                text = supportingText,
                style = typography.caption.copy(
                    color = SecondTextColor,
                )
            )
        },
        placeholder = {
            Text(
                text = "$placeholderText...",
                style = typography.body1.copy(
                    color = Color.Gray,
                    fontStyle = FontStyle.Italic
                )
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneLineRequiredTextField(
    text: String,
    onTextChange: (String) -> Unit,
    placeholderText: String,
    labelText: String,
    supportingText: String,
    maxLines: Int = 4,
    validityState: Boolean = true,
) {
    var isValidState by remember { mutableStateOf(true) }
    if (!validityState) {
        isValidState = false
    }
    OutlinedTextField(
        value = text,
        onValueChange = {
            isValidState = it.isNotEmpty()
            onTextChange(it)
        },
        isError = !isValidState,
        modifier = Modifier.fillMaxWidth(),
        maxLines = maxLines,
        shape = RoundedCornerShape(40.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = TextFieldColor,
            cursorColor = Color.Blue,
            textColor = MainTextColor,
            errorBorderColor = ErrorColor
        ),
        label = {
            Text(
                text = labelText,
                style = typography.caption.copy(
                    color = if (isValidState) SecondTextColor else ErrorColor,
                )
            )
        },
        supportingText = {
            Text(
                text = supportingText,
                style = typography.caption.copy(
                    color = if (isValidState) SecondTextColor else ErrorColor,
                )
            )
        },
        placeholder = {
            Text(
                text = "$placeholderText...",
                style = typography.body1.copy(
                    color = Color.Gray,
                    fontStyle = FontStyle.Italic
                )
            )
        },
    )
}

@Composable
fun TitleTextField(
    text: String,
    onTitleChange: (String) -> Unit,
    titleValidityStatus: Boolean
) {
    val placeholderText = "Enter the title"
    val labelText = "Title"
    val supportingText = "Add title"
    OneLineRequiredTextField(
        text = text,
        onTextChange = { onTitleChange(it) },
        placeholderText = placeholderText,
        labelText = labelText,
        supportingText = supportingText,
        validityState = titleValidityStatus
    )
}

@Composable
fun DescriptionTextField(
    text: String,
    onTextChange: (String) -> Unit,
) {
    val placeholderText = "Enter the description"
    val labelText = "Description"
    val supportingText = "Optional field"
    ExpandedOptionalTextField(
        text = text,
        onTextChange = onTextChange,
        placeholderText = placeholderText,
        labelText = labelText,
        supportingText = supportingText,
    )
}

@Composable
fun RecipeTextField(
    text: String,
    onTextChange: (String) -> Unit,
) {
    val placeholderText = "Enter the recipe"
    val labelText = "Recipe"
    val supportingText = "Optional field"
    ExpandedOptionalTextField(
        text = text,
        onTextChange = onTextChange,
        placeholderText = placeholderText,
        labelText = labelText,
        supportingText = supportingText,
    )
}

@Composable
fun IngredientItem(text: String, onRemove: () -> Unit) {
    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = ChipColor,
                shape = RoundedCornerShape(40.dp),
            )
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            modifier = Modifier.height(28.dp),
            style = typography.body1.copy(
                color = MainTextColor,
            ),
            textAlign = TextAlign.Center,
        )
        IconButton(
            onClick = onRemove,
            modifier = Modifier.size(20.dp)
        ) {
            Icon(
                Icons.Rounded.Close,
                contentDescription = "close",
                tint = BlueIconsColor,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
