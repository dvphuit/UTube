// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.Project.androidGradlePlugin)
        classpath(BuildPlugins.Project.kotlinGradlePlugin)
        classpath(BuildPlugins.Project.kotlinSerialization)
        classpath(BuildPlugins.Project.daggerHilt)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
    }
}

tasks.register("clean").configure {
    delete("build")
}