import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController){
    var racerName by remember {
        mutableStateOf("")
    }

    var racers = remember {
        mutableStateListOf<String>()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Spacer(modifier = Modifier.height(16.dp))
        Row() {
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.testTag("backButton")
            ) {
                Text("Back")
            }
            Button(
                onClick = {racers.clear()},
                modifier = Modifier.testTag("clearButton")
            ) {
                Text("Clear")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Racers",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            TextField(
                value = racerName,
                onValueChange = {
                    racerName = it
                },
                label = {
                    Text("Racer Name")
                },
                modifier = Modifier.testTag("racerInput")
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (racerName.isNotBlank()){
                        racers.add(racerName)
                        racerName = ""
                    }
                },
                modifier = Modifier.testTag("addRacerButton")
            ){
                Text("Add")
            }
        }
        LazyColumn() {
            items(racers) {race ->
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = race,
                    fontSize = 24.sp
                )
            }
        }

    }
}