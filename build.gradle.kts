import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.0.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
}

group = "com.example"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.1")
    implementation("org.springframework.boot:spring-boot-configuration-processor:2.1.3.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("mysql:mysql-connector-java")
    implementation("com.alibaba:druid-spring-boot-starter:1.1.10")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.create("pack",Zip::class.java){
    description = "build the resource pack zip output"
    group = "build"
    dependsOn("bootJar")
    from("build/libs"){
        include("${project.name}*.jar")
        rename{"${project.name}.jar"}
    }
    from("src/main/resources/"){
        include("*")
        into("config/")
    }
    from("src/main/bash/")
}
