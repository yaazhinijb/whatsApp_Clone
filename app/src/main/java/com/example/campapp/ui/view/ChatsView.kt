package com.example.campapp.ui.view

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.campapp.data.Chat
import com.example.campapp.data.DummyData
import com.example.campapp.DetailsActivity

@Composable
fun ChatsView(mContext: Context){
    val dummyChat = DummyData.listChat
    LazyColumn{
        items(dummyChat.size){ index ->
            ChatItem(dummyChat[index], mContext)
        }
    }
}


@Composable
fun ChatItem(chat: Chat, mContext: Context){
    Row(Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .clickable {
            val intent = Intent(mContext, DetailsActivity::class.java)
            intent.putExtra("extra_chatid", chat.id)
            mContext.startActivity(intent)
        }
    ){
        Image(
            painter = rememberImagePainter(data = chat.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp),
            contentScale = ContentScale.Crop
        )
        Column(Modifier.padding(horizontal = 20.dp)){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(chat.name, fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(chat.time, fontWeight = FontWeight.Light, fontSize = 12.sp)
            }
            Text(
                chat.lastMessage ?: "",
                maxLines = 1,
                fontSize = 15.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color(0xFFebebeb))
        }

    }
}



