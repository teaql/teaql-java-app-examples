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
    implementation("io.teaql:teaql-core:1.511-RELEASE")
    implementation("io.teaql:teaql-sqlite:1.511-RELEASE")
    implementation("org.xerial:sqlite-jdbc:3.45.2.0")
    implementation("io.teaql:teaql-provider-jdbc:1.510-RELEASE")
    implementation("io.teaql:teaql-data-service-sql:1.510-RELEASE")
}

sourceSets {
    main {
        java.srcDirs("generated-lib/lib/src/main/java")
    }
}

tasks.register<JavaExec>("executeIntegrationTest") {
    mainClass.set("com.teaql.vending.compose.IntegrationTestKt")
    classpath = sourceSets["main"].runtimeClasspath
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
