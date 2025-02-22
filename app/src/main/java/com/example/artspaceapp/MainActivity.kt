package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.data.Artwork
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                ArtWorkScreen()
            }
        }
    }
}

@Composable
fun ArtWorkScreen() {
    val artworks = mutableListOf<Artwork>()
    artworks.add(Artwork(
        imageRes = R.drawable.arc_pic,
        imageDescRes = "Image of the Arc Triomphe",
        title = "Majestic Arc de Triomphe: A Timeless Symbol of Victory",
        artistName = "José Araújo",
        year = "2024"
    ))
    artworks.add(Artwork(
        imageRes = R.drawable.campus_pic,
        imageDescRes = "Image of mountain view at UGA",
        title = "Mountain View at UGA",
        artistName = "José Araújo",
        year = "2024"
    ))
    artworks.add(Artwork(
        imageRes = R.drawable.jean_baptiste_pic,
        imageDescRes = "Artwork of Léonard de Vinci, Saint Jean Baptiste",
        title = "Saint Jean Baptiste",
        artistName = "Léonard de Vinci",
        year = "1508 / 1519"
    ))
    artworks.add(Artwork(
        imageRes = R.drawable.man_pic,
        imageDescRes = "A Man Reading the Morning Journal in a Grenoble Café",
        title = "A Quiet Moment: A Man Reading the Morning Journal in a Grenoble Café",
        artistName = "José Araújo",
        year = "2022"
    ))

    artworks.add(Artwork(
        imageRes = R.drawable.natal_pic,
        imageDescRes = "Image of a Christmas turkey",
        title = "The Star of Christmas Dinner",
        artistName = "José Araújo",
        year = "2024"
    ))

    artworks.add(Artwork(
        imageRes = R.drawable.paris2_pic,
        imageDescRes = "Image of Paris",
        title = "Paris Unveiled: The Northern Horizon",
        artistName = "José Araújo",
        year = "2022"
    ))

    artworks.add(Artwork(
        imageRes = R.drawable.paris3_pic,
        imageDescRes = "Image of Paris",
        title = "Paris Unveiled: The Southern Stretch",
        artistName = "José Araújo",
        year = "2022"
    ))
    artworks.add(Artwork(
        imageRes = R.drawable.paris_pic,
        imageDescRes = "Image of Paris",
        title = "Paris Unveiled: The Eastern Charm",
        artistName = "José Araújo",
        year = "2022"
    ))
    artworks.add(Artwork(
        imageRes = R.drawable.recife_pic,
        imageDescRes = "Image of the sky of Recife city",
        title = "The Infinite Blue: Recife from Above",
        artistName = "José Araújo",
        year = "2024"
    ))
    artworks.add(Artwork(
        imageRes = R.drawable.tour_pic,
        imageDescRes = "Image of the Tower Eiffel",
        title = "The Iron Lady",
        artistName = "José Araújo",
        year = "2022"
    ))
    artworks.add(Artwork(
        imageRes = R.drawable.van_gogh_pic,
        imageDescRes = "Van Gogh's artwork",
        title = "Echoes of Van Gogh",
        artistName = "Van Gogh",
        year = "1889"
    ))


    var positionElement by remember { mutableStateOf(0) }
    var artwork by remember { mutableStateOf(artworks[0]) }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .safeDrawingPadding()
            .fillMaxHeight()
            .padding(horizontal = 30.dp)
            .padding(top = 80.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        ArtworkWall(artwork = artwork)
        Spacer(modifier = Modifier.height(50.dp))
        ArtworkDescriptor(artwork = artwork, modifier = Modifier
            .width(350.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        ArtworkController(modifier = Modifier.fillMaxWidth()) { isNext ->
            if (isNext) {
                if (positionElement < (artworks.size - 1)) positionElement += 1
            } else {
                if (positionElement > 0) positionElement -= 1
            }
            artwork = artworks[positionElement]

        }

    }
}

@Composable
fun ArtworkWall(modifier: Modifier = Modifier, artwork: Artwork) {
    Surface(
        modifier = modifier
            .fillMaxHeight(0.6f),
        shadowElevation = 5.dp,
    ) {
    Image(
        painter = painterResource(artwork.imageRes),
        contentDescription = stringResource(R.string.artwork_image, artwork.imageDescRes),
        modifier = modifier
            .padding(25.dp)
    )
    }
}

@Composable
fun ArtworkDescriptor(modifier: Modifier = Modifier, artwork: Artwork) {

    Surface(
        color = colorResource(R.color.gray_100),
        modifier = modifier

    ) {
        Column(
            modifier = modifier
                .padding(horizontal = 20.dp, vertical = 15.dp)
                .wrapContentWidth()
        ){
            Text(
                text = artwork.title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier,
                fontSize = 22.sp,
                textAlign = TextAlign.Start
            )
            Row {
                Text(
                    text = artwork.artistName,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight(900),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(end = 2.dp)
                )
                Text(
                    text = stringResource(R.string.artwork_year, artwork.year),
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start
                )
            }

        }
    }
}

@Composable
fun ArtworkController(modifier: Modifier = Modifier, callback: (Boolean) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Button(
            onClick = { callback(false) }
        ) {
            Text(
                text = stringResource(R.string.artwork_button_previous),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(100.dp)
            )
        }
        Button(onClick = { callback(true) }) {
            Text(
                text = stringResource(R.string.artwork_button_next),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(100.dp)
                )

        }
    }
}



@Preview(showBackground = true)
@Composable
fun ArtworkScreenPreview() {
    ArtSpaceAppTheme {
        ArtWorkScreen()
    }
}