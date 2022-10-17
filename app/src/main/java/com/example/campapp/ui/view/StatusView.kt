package com.example.campapp.ui.view

import android.graphics.Color.parseColor
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Icon
import com.example.campapp.R
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun StatusView() {
    // My Status
    Row(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Box(Modifier.weight(2f)) {
            Image(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape).size(48.dp).background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = null,
                tint = Color.Green,
                modifier = Modifier.offset(x = 32.dp, y = 32.dp)
            )
        }
        Column(
            Modifier
                .padding(horizontal = 8.dp)
                .weight(8f)
        ) {
            Text("My Status", maxLines = 1, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(6.dp))
            Text("Tap to add status update", fontSize = 14.sp, color = Color.Gray)
        }
    }
}
