plugins {
    application
    kotlin("jvm") version "1.4-M1"
    //kotlin("jvm") version "1.3.70"
    //kotlin("jvm") version "1.3.61"
    //kotlin("jvm") version "1.3.31"
}

group = "info.lotharschulz"
version = "1.0-SNAPSHOT"

val mainClass by extra("info.lotharschulz.lazy/DearlazyKt")

application {
    mainClassName = mainClass
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation(kotlin("stdlib"))
}

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    jcenter()
    mavenCentral()
}