package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    
    val artworks = listOf(artwork1, artwork2, artwork3, artwork4)

    var artworkIndex by remember {
        mutableIntStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {

        ArtWorkWall(artwork = artworks[artworkIndex])
        ArtworkDescriptor(artwork = artworks[artworkIndex])
        DisplayController(
            onPreviousClick = {
                artworkIndex = if (artworkIndex == 0) artworks.lastIndex else artworkIndex - 1
            },
            onNextClick = {
                artworkIndex = if (artworkIndex == artworks.lastIndex) 0 else artworkIndex + 1
            }
        )

    }
}

@Composable
fun ArtWorkWall(
    artwork: Artwork,
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier
            .wrapContentSize()
            .padding(horizontal = 12.dp, vertical = 24.dp),
        shape = RoundedCornerShape(size = 8.dp),
        shadowElevation = 12.dp
    ) {
        Image(
            painter = painterResource(id = artwork.imageResource),
            contentDescription = stringResource(id = artwork.contentDes),
            contentScale = ContentScale.Fit,
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
fun ArtworkDescriptor(
    artwork: Artwork,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(
            text = stringResource(id = artwork.title),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            lineHeight = 28.sp,
            textAlign = TextAlign.Center
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentSize()
                .padding(top = 4.dp)
        ) {
            Text(text = stringResource(id = artwork.artist))
            Text(
                text = "(" + stringResource(id = artwork.publishedYear) + ")",
                fontWeight = FontWeight.W300, // Thickness increases as the number increases
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(start = 4.dp)
            )

        }
    }
}

@Composable
fun DisplayController(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.requiredSize(width = 140.dp, height = 48.dp)
        ) {
            Text(
                text = stringResource(id = R.string.on_button_previous),
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }

        Button(
            onClick = onNextClick,
            modifier = Modifier.requiredSize(width = 140.dp, height = 48.dp)
        ) {
            Text(
                text = stringResource(id = R.string.on_button_next),
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}