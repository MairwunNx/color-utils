import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val projectVersion = "8.0.0"
val projectGroup = "org.jfxextras"
val projectArtifactId = "jfxcolorutils"

plugins {
    kotlin("jvm") version "1.3.31"
    id("org.jetbrains.dokka") version "0.9.18"
    id("com.github.johnrengelman.shadow") version "5.0.0"
    `maven-publish`
}

group = projectGroup
version = projectVersion

val projectTasks = tasks {
    val sourcesJar by creating(Jar::class) {
        dependsOn(JavaPlugin.CLASSES_TASK_NAME)
        classifier = "sources"
        from(sourceSets["main"].allSource)
    }

    artifacts {
        add("archives", sourcesJar)
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testCompile("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.3.1")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = projectGroup
            artifactId = projectArtifactId
            version = projectVersion

            from(components["java"])

            val sourcesArtifact = projectTasks["sourcesJar"]
            artifact(sourcesArtifact)
        }
    }
}
