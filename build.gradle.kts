plugins {
    id("common")
    application
}

repositories {
    mavenCentral()
    maven("https://github-package-registry-mirror.gc.nav.no/cached/maven-release")
}

dependencies {
    implementation(libs.rapids.and.rivers)
    implementation(libs.konfig)
    implementation(libs.kotlin.logging)

    testImplementation(libs.rapids.and.rivers.test)
    testImplementation(libs.kotest.assertions.core)
}

configurations.all {
    exclude(group = "junit", module = "junit")
}

application {
    mainClass.set("no.nav.dagpenger.oppfolging.AppKt")
}
