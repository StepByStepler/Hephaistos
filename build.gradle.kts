plugins {
    kotlin("jvm") version "1.5.10"
    java
    id("org.jetbrains.dokka") version "1.5.0"
}

repositories {
    mavenCentral()
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.dokka")

    group = "io.github.jglrxavpok.hephaistos"
    version = "2.5.3-patched"

    repositories {
        mavenCentral()
    }

    dependencies {
        // Use the Kotlin JDK 8 standard library.
        implementation(kotlin("stdlib"))

        // Use the JUpiter test library.
        testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    }

    tasks {
        test { useJUnitPlatform() }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

        withSourcesJar()
    }

    val dokkaHtml by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class)

    val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
        dependsOn(dokkaHtml)
        archiveClassifier.set("javadoc")
        from(dokkaHtml.outputDirectory)
    }

    val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
    compileKotlin.kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    compileKotlin.kotlinOptions.languageVersion = "1.5"

    compileKotlin.kotlinOptions {
        freeCompilerArgs = listOf("-Xuse-experimental=kotlin.MultiPlatform")
    }
}
