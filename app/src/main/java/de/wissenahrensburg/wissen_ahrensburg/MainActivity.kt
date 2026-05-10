package de.wissenahrensburg.wissen_ahrensburg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import de.wissenahrensburg.wissen_ahrensburg.model.WissenLoader
import de.wissenahrensburg.wissen_ahrensburg.model.Wissendatenbank
import de.wissenahrensburg.wissen_ahrensburg.ui.theme.Wissen_ahrensburgTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Wissen_ahrensburgTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    KnowledgeBaseHome(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun KnowledgeBaseHome(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var wissenobjekt by remember { mutableStateOf<List<Wissendatenbank>>(emptyList()) }

    LaunchedEffect(Unit) {
        wissenobjekt = WissenLoader.loadWissen(context)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        
        AhrensburgLogo(modifier = Modifier.size(100.dp))
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Ahrensburg",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            ),
            color = Color(0xFF1A237E)
        )
        
        Text(
            text = "Wissendatenbank",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f).padding(horizontal = 16.dp)
        ) {
            items(wissenobjekt) { item ->
                WissenCard(item)
            }
        }

        Text(
            text = "Ein Open-Source-Projekt",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}

@Composable
fun WissenCard(item: Wissendatenbank) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = item.titel,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A237E)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.beschreibung,
                style = MaterialTheme.typography.bodyMedium
            )
            if (item.adresse.isNotEmpty() && item.adresse != "keine Angabe") {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "📍 ${item.adresse}",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KnowledgeBaseHomePreview() {
    Wissen_ahrensburgTheme {
        KnowledgeBaseHome()
    }
}
