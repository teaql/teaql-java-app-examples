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
    maven("https://maven.teaql.io/repository/maven-releases/")
}

dependencies {
    // Note: compose.desktop.currentOs is provided by the Compose plugin
    implementation(compose.desktop.currentOs)
    
    // Depend on our generated TeaQL core and local app logic!
    implementation("io.teaql:teaql-core:1.500-RELEASE")
    implementation("io.teaql:teaql-sqlite:1.500-RELEASE")
    implementation("cn.hutool:hutool-all:5.8.20")
}

sourceSets {
    main {
        java.srcDirs("generated-lib/lib/src/main/java")
    }
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
