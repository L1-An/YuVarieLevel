import io.izzel.taboolib.gradle.*


plugins {
    java
    id("io.izzel.taboolib") version "2.0.11"
    id("org.jetbrains.kotlin.jvm") version "1.8.22"
}

taboolib {
    env {
        install(BUKKIT_ALL)
        install(UNIVERSAL)
        install(DATABASE, EXPANSION_PLAYER_DATABASE)
        install(NMS_UTIL)
        install(KETHER)
        install(METRICS)
    }
    description {
        name = "YuVarieLevel"
        desc("Variable & level system")
        contributors {
            name("L1An")
        }
    }
    version { taboolib = "6.1.1" }
    relocate("org.serverct.parrot.parrotx", "${project.group}.parrotx")
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("ink.ptms.core:v12004:12004:mapped")
    compileOnly("ink.ptms.core:v12004:12004:universal")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
    taboo(files("libs/module-parrotx-1.5.7-7-special.jar"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }
}

tasks.withType<Jar> {
    destinationDirectory.set(file("/Users/yuxin/minecraft/servers/1.20.4Test/plugins"))
    //destinationDirectory.set(file("$projectDir/build-jar"))
}