package com.example.campapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.campapp.composable.AppTabBar
import com.example.campapp.composable.AppTabs
import com.example.campapp.ui.theme.CampAppTheme
import com.example.campapp.ui.theme.WhatsAppGreen
import com.example.campapp.ui.view.CallsView
import com.example.campapp.ui.view.ChatsView
import com.example.campapp.ui.view.StatusView
import androidx.compose.ui.graphics.Color

enum class HomeTab{
    CHATS, STATUS, CALLS
}

class HomeActv : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CampAppTheme {
                Surface(
                    color = WhatsAppGreen,
                    modifier = Modifier.background(WhatsAppGreen)
                ) {
                    HomeView(this)
                }
            }
        }
    }
}

@Composable
fun HomeView(mContext: Context) {
    var showMenu by remember{ mutableStateOf(false)}
    var tabSelected by remember { mutableStateOf(HomeTab.CHATS)}
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("WhatsApp")},
                elevation = 0.dp,
                actions = {
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(onClick = {}) {
                            Text(text = "Settings")
                        }
                    }
                    IconButton(onClick = {}){
                        Icon(Icons.Default.Search, contentDescription = null)
                    }
                    IconButton(onClick = { showMenu = showMenu != true}){
                        Icon(Icons.Default.MoreVert, contentDescription = null)
                    }
                }
            )
        },
        floatingActionButton = {
            when(tabSelected){
                HomeTab.CHATS -> {
                    FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = androidx.compose.ui.graphics.Color.White) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_message),
                            contentDescription = null,
                            tint = androidx.compose.ui.graphics.Color.White
                        )
                    }
                }
                HomeTab.STATUS -> {
                    Column{
                        FloatingActionButton(
                            onClick = {},
                            backgroundColor = androidx.compose.ui.graphics.Color.White,
                            modifier = Modifier.size(40.dp)
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.ic_create),
                                contentDescription = null,
                                tint = androidx.compose.ui.graphics.Color.DarkGray
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = androidx.compose.ui.graphics.Color.Green) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_camera),
                                contentDescription = null,
                                tint =  androidx.compose.ui.graphics.Color.White
                            )
                        }
                    }
                }
                HomeTab.CALLS -> {
                    FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = androidx.compose.ui.graphics.Color.Green) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_addcall),
                            contentDescription = null,
                            tint = androidx.compose.ui.graphics.Color.White
                        )
                    }
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ){
        Column(Modifier.fillMaxSize()){
            var tabSelected by remember{ mutableStateOf(HomeTab.CHATS)}
            HomeTabBar(
                tabSelected,
                onTabSelected = { tabSelected = it }
            )
            when(tabSelected){
                HomeTab.CHATS -> ChatsView(mContext)
                HomeTab.STATUS -> StatusView()
                HomeTab.CALLS -> CallsView()
            }
        }
    }
}

@Composable
fun HomeTabBar(
    tabSelected: HomeTab,
    onTabSelected: (HomeTab) -> Unit
){
    AppTabBar{ tabBarModifier ->
        AppTabs(
            modifier = tabBarModifier,
            titles = HomeTab.values().map {it.name},
            tabSelected = tabSelected,
            onTabSelected = { newTab ->
                onTabSelected(HomeTab.values()[newTab.ordinal])
            }
        )
    }

}
