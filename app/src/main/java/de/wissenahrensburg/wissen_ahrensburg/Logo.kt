package de.wissenahrensburg.wissen_ahrensburg

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AhrensburgLogo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val strokeWidth = canvasWidth * 0.05f
            
            // Castle Base (representing Schloss Ahrensburg)
            val castleColor = Color(0xFF1A237E) // Deep Blue
            
            val castleWidth = canvasWidth * 0.6f
            val castleHeight = canvasHeight * 0.5f
            val left = (canvasWidth - castleWidth) / 2
            val top = (canvasHeight - castleHeight) / 2 + (canvasHeight * 0.1f)
            
            // Draw Main Building
            drawRect(
                color = castleColor,
                topLeft = Offset(left, top),
                size = Size(castleWidth, castleHeight),
                style = Fill
            )
            
            // Draw 4 Towers
            val towerWidth = castleWidth * 0.25f
            val towerHeight = castleHeight * 0.4f
            
            // Top Left Tower
            drawRect(
                color = castleColor,
                topLeft = Offset(left - (towerWidth * 0.2f), top - (towerHeight * 0.8f)),
                size = Size(towerWidth, towerHeight),
                style = Fill
            )
            // Top Right Tower
            drawRect(
                color = castleColor,
                topLeft = Offset(left + castleWidth - (towerWidth * 0.8f), top - (towerHeight * 0.8f)),
                size = Size(towerWidth, towerHeight),
                style = Fill
            )
            
            // "W" for Wissendatenbank or an Open Book symbol in the middle
            val bookWidth = castleWidth * 0.5f
            val bookHeight = castleHeight * 0.4f
            val bookLeft = left + (castleWidth - bookWidth) / 2
            val bookTop = top + (castleHeight - bookHeight) / 2
            
            // Symbolic Book
            drawRect(
                color = Color.White,
                topLeft = Offset(bookLeft, bookTop),
                size = Size(bookWidth, bookHeight),
                style = Fill
            )
            // Center line of the book
            drawLine(
                color = castleColor,
                start = Offset(bookLeft + bookWidth / 2, bookTop),
                end = Offset(bookLeft + bookWidth / 2, bookTop + bookHeight),
                strokeWidth = strokeWidth / 4
            )
            // Lines representing text
            for (i in 1..3) {
                val lineY = bookTop + (bookHeight * i / 4)
                drawLine(
                    color = castleColor,
                    start = Offset(bookLeft + (bookWidth * 0.1f), lineY),
                    end = Offset(bookLeft + (bookWidth * 0.4f), lineY),
                    strokeWidth = strokeWidth / 8
                )
                drawLine(
                    color = castleColor,
                    start = Offset(bookLeft + (bookWidth * 0.6f), lineY),
                    end = Offset(bookLeft + (bookWidth * 0.9f), lineY),
                    strokeWidth = strokeWidth / 8
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AhrensburgLogoPreview() {
    AhrensburgLogo(modifier = Modifier.size(200.dp))
}
