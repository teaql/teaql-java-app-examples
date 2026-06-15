import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.compose") version "1.6.0"
    jacoco
}

jacoco {
    toolVersion = "0.8.11"
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
    implementation("io.teaql:teaql-core:1.513-RELEASE")
    implementation("io.teaql:teaql-sqlite:1.513-RELEASE")
    implementation("io.teaql:teaql-sql-portable:1.513-RELEASE")
    implementation("io.teaql:teaql-provider-jdbc:1.513-RELEASE")
    implementation("org.xerial:sqlite-jdbc:3.45.2.0")
    implementation("io.teaql:teaql-data-service-sql:1.513-RELEASE")
    
    // For Integration Tests with PostgreSQL
    implementation("org.postgresql:postgresql:42.6.0")
    
    // Test framework
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

sourceSets {
    main {
        java.srcDirs("generated-lib/lib/src/main/java")
    }
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(false)
        csv.required.set(false)
        html.required.set(true)
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
