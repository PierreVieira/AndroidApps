package com.example.composebasics.model

import com.example.composebasics.model.Author
import com.example.composebasics.model.Message

object SampleData {
    val conversationSample = listOf(
        Message(
            author = Author.pierre,
            body = "I'm learning a lot with the new android interface creation library. The Jetpack Compose."
        ),
        Message(
            author = Author.android,
            body = "Very cool Pierre! I'm happy to hear that we have one more person engaged in learning more about our new features!"
        ),
        Message(
            author = Author.android,
            body = "Did you know that Jetpack Compose will kill other layout creation frameworks like Flutter and React Native?"
        ),
        Message(
            author = Author.pierre,
            body = "Are you serious? Oh my god, how amazing this is!"
        ),
        Message(
            author = Author.android,
            body = "Yes. Jetpack Compose will take over the world!"
        ),
        Message(
            author = Author.pierre,
            body = "How can I help jetpack compose take over the world?"
        ),
        Message(
            author = Author.android,
            body = "You need to convince more and more people to use jepack compose."
        ),
        Message(
            author = Author.pierre,
            body = "But what actually is jetpack compose? xD"
        ),
        Message(
            author = Author.android,
            body = "Jetpack Compose is a modern, declarative UI toolkit for Android. Compose makes it easier to create and maintain the app's UI by providing a declarative API that lets you render the app's UI without imperatively modifying the front-end views. This terminology needs to be explained, but the implications are important for your app design."
        )
    )
}
