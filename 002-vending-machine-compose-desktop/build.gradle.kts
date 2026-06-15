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
    implementation("io.teaql:teaql-postgres:1.513-RELEASE")
    implementation("io.teaql:teaql-mysql:1.513-RELEASE")
    implementation("io.teaql:teaql-dm8:1.513-RELEASE")
    
    // For Integration Tests with PostgreSQL, MySQL & DM8
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("com.mysql:mysql-connector-j:8.3.0")
    // Dameng JDBC driver (assuming it's available in standard repositories or local maven)
    implementation("com.dameng:DmJdbcDriver18:8.1.3.140")
    
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
        csv.required.set(true)
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
