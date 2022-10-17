package com.example.campapp.data

import android.os.Message

data class Chat(
    val id: Int,
    val name: String,
    val time: String,
    val date: String?,
    val lastMessage: String?,
    val imageUrl: String
)

data class Call(
    val id: Int,
    val name: String,
    val date: String,
    val imageUrl: String,
    val isMissCall: Boolean,
    val isIncoming: Boolean
)

data class Message(
    val message: String,
    val isPeer: Boolean
)

object DummyData{
    val listChat = listOf(
        Chat(
            id = 0,
            name = "Light Yagami",
            time = "00:53",
            date = "Dec. 22",
            lastMessage = "I am KIRA! 😈",
            imageUrl = "https://static.wikia.nocookie.net/villains/images/5/54/Light_YagamiHD.jpg/revision/latest?cb=20180414020152"
        ),

        Chat(
            id = 1,
            name = "Naruto Uzumaki",
            time = "23:00",
            date = "Oct. 03",
            lastMessage = "Dattebayo! 🧿",
            imageUrl = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/341cea7f-8a6b-4263-8246-6a7425e4da88/d8omeg5-a3211c04-f341-4de2-9253-d85d1403763e.png/v1/fill/w_1600,h_1001,q_80,strp/chuffed__naruto__wallpaper__by_sgcassidy_d8omeg5-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTAwMSIsInBhdGgiOiJcL2ZcLzM0MWNlYTdmLThhNmItNDI2My04MjQ2LTZhNzQyNWU0ZGE4OFwvZDhvbWVnNS1hMzIxMWMwNC1mMzQxLTRkZTItOTI1My1kODVkMTQwMzc2M2UucG5nIiwid2lkdGgiOiI8PTE2MDAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.tDFkUYuOjUnm4lwjqY-aqfD8WbgfHDJh61vDNruG-mY"
        ),

        Chat(
            id = 2,
            name = "Tanjiro Kamado",
            time = "19:00",
            date = "Oct. 15",
            lastMessage = "Hinokami Kagura ‍🔥",
            imageUrl = "https://i.pinimg.com/736x/d7/8b/a9/d78ba9e301e1d46ea09a1606383fcf0a.jpg"
        ),

        Chat(
            id = 3,
            name = "Takemichi Hanagaki",
            time = "3:33",
            date = "Oct. 31",
            lastMessage = "In the future… In the past… Always and forever… I’ve always loved you",
            imageUrl = "https://otakukart.com/wp-content/uploads/2021/05/Tokyo-Revengers-Episode-5-Preview-and-Recap.jpg"
        )
    )

    val listCall = listOf(

        Call(
            id = 0,
            name = "Light Yagami",
            date = "Dec. 22",
            imageUrl = "https://static.wikia.nocookie.net/villains/images/5/54/Light_YagamiHD.jpg/revision/latest?cb=20180414020152",
            isMissCall = false,
            isIncoming = true
        ),

        Call(
            id = 1,
            name = "Tanjiro Kamado",
            date = "Oct. 15",
            imageUrl = "https://i.pinimg.com/736x/d7/8b/a9/d78ba9e301e1d46ea09a1606383fcf0a.jpg",
            isMissCall = true,
            isIncoming = false
        ),

        Call(
            id = 2,
            name = "Zenitsu",
            date = "Oct. 04",
            imageUrl = "https://i.pinimg.com/originals/c2/24/30/c224301194317847f49b6920b82bc8bb.jpg",
            isMissCall = true,
            isIncoming = false
        )




    )

    val listMessage = listOf(
        Message("Hey, What's Up?", false),
        Message("I'm in Training. Here in the woods", true),
        Message("With?", false),
        Message("With Tomioka Giyu", true),
        Message("Aight. TTYL", false),
        Message("Bubye.", true)
    )
}
