package com.example.appgrid_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appgrid_codelab.data.DataSource
import com.example.appgrid_codelab.model.Topic
import com.example.appgrid_codelab.ui.theme.AppGrid_codelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppGrid_codelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridApp()
                }
            }
        }
    }
}

@Composable
fun GridApp(modifier: Modifier = Modifier) {
    // TopicList()
    TopicGrid(modifier.padding(8.dp))
}

@Composable
fun TopicGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(DataSource.topics) { topic ->
            TopicCard(topic)
        }
    }
}

// My version for the grid, I didn't know there was a grid composable so I did it this way
// after finding out by reviewing the solution code I made another "version"
// with that composable which is the one being used since it has better padding :)

// If you want to use mine just uncomment the TopicList() call on GridApp
// and comment the one of TopicGrid!

@Composable
fun TopicList(modifier: Modifier = Modifier){

    val topics1 = DataSource.topics.slice(0 until DataSource.topics.size/2)
    val topics2 = DataSource.topics.slice(DataSource.topics.size/2 until DataSource.topics.lastIndex+1)

    Row (
        horizontalArrangement = Arrangement.SpaceAround)  {

        Column (modifier = modifier.weight(5f)) {
            LazyColumn(modifier = modifier){
                items(topics1) {topic ->
                    TopicCard(
                        topic = topic,
                        modifier = modifier
                            .padding(8.dp)
                            .height(68.dp)
                            .fillMaxWidth())
                }
            }
        }

        Column (modifier.weight(5f)) {
            LazyColumn(modifier = modifier){
                items(topics2) {topic ->
                    TopicCard(
                        topic = topic,
                        modifier = modifier
                            .padding(8.dp)
                            .height(68.dp)
                            .fillMaxWidth())
                }
            }
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {

    Card(modifier = modifier) {
        Row (modifier = Modifier){
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = LocalContext.current.getString(topic.stringResourceId),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.bodyMedium,

                )
                Row (verticalAlignment = Alignment.CenterVertically){
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = topic.associatedCourses.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }

            }
        }
    }
}


@Preview
@Composable
private fun GridCardPreview() {
    //TopicCard(Topic(R.string.architecture, 50, R.drawable.architecture))
    TopicList()
}