plugins {
    `maven-publish`
    id("convention.publication")
}

dependencies {
    api(project(":antlr"))
}

configurations {
    testImplementation {
        extendsFrom(configurations.compileOnly.get())
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    publishing {
        repositories {
            maven {
                name = "MeProjectMaven"
                url = uri("https://repo.rustme.net/private")
                credentials(PasswordCredentials::class)
                authentication {
                    create<BasicAuthentication>("basic")
                }
            }
        }
    }
}