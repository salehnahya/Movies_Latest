object Versions {

    const val kotlin = "1.8.10"
    const val kotlinCoroutines = "1.6.4"
    const val ktor = "2.3.0"
    const val kotlinxSerialization = "1.5.0"
    const val kotlinxDateTime = "0.4.0"
    const val multiplatformSettings = "1.0.0"

    const val junit = "4.13"
    const val compose = "1.4.0"
    const val preCompose = "1.4.1"

}


object Deps {
    const val multiplatformSettings =
        "com.russhwolf:multiplatform-settings:${Versions.multiplatformSettings}"
    const val multiplatformSettingsCoroutines =
        "com.russhwolf:multiplatform-settings-coroutines:${Versions.multiplatformSettings}"

    object Kotlinx {
        const val serializationCore =
            "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}"
        const val serializationJson =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}"
    }


    object Ktor {
        const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
        const val json = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"

        const val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val clientJava = "io.ktor:ktor-client-java:${Versions.ktor}"
        const val clientIos = "io.ktor:ktor-client-darwin:${Versions.ktor}"
    }
    object PreCompose {
        const val precompose = "moe.tlaster:precompose:${Versions.preCompose}"
    }
}

object Test {
    const val junit = "junit:junit:${Versions.junit}"
}

