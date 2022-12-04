plugins {
    kotlin("jvm")
    id("fabric-loom") version "1.0.12"
    java
}

group = property("maven_group")!!
version = property("mod_version")!!

repositories {
    mavenCentral()
    maven { url = uri("https://maven.bai.lol") }
}

dependencies {
    minecraft("com.mojang:minecraft:1.19.2")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:0.14.10")

    modImplementation("net.fabricmc:fabric-language-kotlin:1.8.7+kotlin.1.7.22")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.68.1+1.19.3")

    // compile against the API
    compileOnly("mcp.mobius.waila:wthit-api:mojmap-5.13.3")

    // run against the full jar
    runtimeOnly("mcp.mobius.waila:wthit:fabric-5.13.3")
    runtimeOnly("lol.bai:badpackets:fabric-0.2.0")
}

tasks {

    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }

    jar {
        from("LICENSE.md")
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }

}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    withSourcesJar()
}