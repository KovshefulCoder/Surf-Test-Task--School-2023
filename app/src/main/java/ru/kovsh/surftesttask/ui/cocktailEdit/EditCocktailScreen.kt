package ru.kovsh.surftesttask.ui.cocktailEdit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.kovsh.surftesttask.R
import ru.kovsh.surftesttask.ui.theme.ErrorColor
import ru.kovsh.surftesttask.ui.theme.MainTextColor
import ru.kovsh.surftesttask.ui.theme.SecondTextColor
import ru.kovsh.surftesttask.ui.theme.TextFieldColor
import ru.kovsh.surftesttask.ui.theme.typography
import ru.kovsh.surftesttask.viewModels.CocktailEditViewModel

@Composable
internal fun EditCocktailScreen(
    onSave: () -> Unit,
    viewModel: CocktailEditViewModel,
) {
    EditCocktailScreen()
}

@Preview
@Composable
fun PrevEditCocktailScreen() {
    EditCocktailScreen()
}

@Composable
private fun EditCocktailScreen() {
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
                            modifier = Modifier.fillMaxSize().size(200.dp)
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
                        "Hello there", {}
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    DescriptionTextField(
                        "Hello there", {}
                    )
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedTextField(
    text: String,
    onTextChange: (String) -> Unit,
    placeholderText: String,
    labelText: String,
    supportingText: String,
    maxLines: Int = 4,
    isExpanded: Boolean = false,
) {
    val outlindedTF = if (isExpanded) {
        Modifier.fillMaxWidth().height(200.dp)
    } else {
        Modifier.fillMaxWidth()
    }
    OutlinedTextField(
        value = text,
        onValueChange = { onTextChange(it) },
        modifier = outlindedTF,
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
                style = typography.body1.copy(
                    color = SecondTextColor,
                )
            )
        },
        supportingText = {
            Text(
                text = supportingText,
                style = typography.body1.copy(
                    color = SecondTextColor,
                )
            )
        },
        placeholder = {
            Text(
                text = "$placeholderText...",
                style = typography.body1.copy(
                    color = Color.Gray,
                    fontStyle = FontStyle.Italic)
            )
        },
    )
}

@Composable
fun TitleTextField(
    text: String,
    onTextChange: (String) -> Unit,
) {
    val placeholderText = "Enter the title"
    val labelText = "Title"
    val supportingText = "Add title"
    SharedTextField(
        text = text,
        onTextChange = onTextChange,
        placeholderText = placeholderText,
        labelText = labelText,
        supportingText = supportingText
    )
}

@Composable
fun DescriptionTextField(
    text: String,
    onTextChange: (String) -> Unit,
) {
    val placeholderText = "Enter the description"
    val labelText = "Description"
    val supportingText = "Add description"
    SharedTextField(
        text = text,
        onTextChange = onTextChange,
        placeholderText = placeholderText,
        labelText = labelText,
        supportingText = supportingText,
        isExpanded = true
    )
}
