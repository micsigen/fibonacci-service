import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.9"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	// Add Jib plugin
	id("com.google.cloud.tools.jib") version "3.3.2"
}

group = "hu.obuda.devops"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	// Add this line for actuator support
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

// Jib configuration
jib {
	from {
		image = "openjdk:11-jre-slim"
	}
	to {
		image = "fibonacci-service"
		tags = setOf("latest", version.toString())
	}
	container {
		ports = listOf("8000", "9000")
		jvmFlags = listOf(
			"-Xms512m",
			"-Xmx512m"
		)
		mainClass = "hu.obuda.devops.fibonaccirestapi.FibonacciRestapiApplicationKt"
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
