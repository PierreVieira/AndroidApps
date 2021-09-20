package com.example.profilecard

data class User(
    val name: String,
    val imageUrl: String,
    val online: Boolean,
)

val userList = listOf(
    User(
        name = "Android 18",
        imageUrl = "https://pm1.narvii.com/5943/b5ae3a69a0e08513ce9d1fe2a8cee85f6082c4fc_hq.jpg",
        online = true
    ),
    User(
        name = "Android 17",
        imageUrl = "https://i.pinimg.com/564x/13/44/23/134423f8449aa626602eb1c7f7f57b4b.jpg",
        online = true
    ),
    User(
        name = "Gohan",
        imageUrl = "https://gartic.com.br/imgs/mural/in/ino_yamanaka_z/mirai-gohan.png",
        online = false
    ),
    User(
        name = "Trunks",
        imageUrl = "https://gartic.com.br/imgs/mural/go/goiaba516/mirai-trunks-3.png",
        online = true
    ),
    User(
        name = "Bulma",
        imageUrl = "https://www.personality-database.com/profile_images/12170.png",
        online = true
    ),
    User(
        name = "Vegeta",
        imageUrl = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/a229ed1f-ebe6-4001-9da1-2053b109892d/ddv7bff-d4de9b3b-e22d-493d-b019-811bbb78ddda.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcL2EyMjllZDFmLWViZTYtNDAwMS05ZGExLTIwNTNiMTA5ODkyZFwvZGR2N2JmZi1kNGRlOWIzYi1lMjJkLTQ5M2QtYjAxOS04MTFiYmI3OGRkZGEucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.fQHjXzAoFfiTV9FB9UxnOGQORPkFmOjLlGiqAP65kHk",
        online = false
    )
)