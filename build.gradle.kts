/*
plugins {
    application
    id 'org.jetbrains.kotlin.jvm' version '1.4-M1'
    //id 'org.jetbrains.kotlin.jvm' version '1.3.61'
}
*/

plugins {
    application
    kotlin("jvm") version "1.4-M1"
    //kotlin("jvm") version "1.3.61"
}

group = "org.example"
version = "1.0-SNAPSHOT"

val mainClass by extra("DearLazy")

application {
    mainClassName = mainClass
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation(kotlin("stdlib"))
}

repositories {
    //maven { url "https://dl.bintray.com/kotlin/kotlin-eap" }
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    jcenter()
    mavenCentral()
}

/*
-----------

repositories {
    maven { url 'https://dl.bintray.com/kotlin/kotlin-eap' }
    mavenCentral()
}

dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
}

compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}
compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
}

 */