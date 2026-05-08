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
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        
        AhrensburgLogo(modifier = Modifier.size(150.dp))
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Text(
            text = "Ahrensburg",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            ),
            color = Color(0xFF1A237E)
        )
        
        Text(
            text = "Wissendatenbank",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Ein  Open-Source-Projekt",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 32.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KnowledgeBaseHomePreview() {
    Wissen_ahrensburgTheme {
        KnowledgeBaseHome()
    }
}
