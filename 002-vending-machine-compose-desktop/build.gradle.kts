import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.compose") version "1.6.0"
}

group = "com.teaql.vending.compose"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

dependencies {
    // Note: compose.desktop.currentOs is provided by the Compose plugin
    implementation(compose.desktop.currentOs)
    
    // Depend on our generated TeaQL core and local app logic!
    implementation("io.teaql:teaql-core:1.198-RELEASE")
    implementation("io.teaql:teaql-sqlite:1.198-RELEASE")
    // If the Android project was built as a library, we could depend on it.
    // For now, let's just make it run as an empty Compose window to show it works!
}

compose.desktop {
    application {
        mainClass = "com.teaql.vending.compose.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "RobotTaskBoard"
            packageVersion = "1.0.0"
        }
    }
}
