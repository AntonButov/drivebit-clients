plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.ktlint) apply true
}

private val ktLintConfig: org.jlleitschuh.gradle.ktlint.KtlintExtension.() -> Unit = {
    debug.set(false)
    android.set(true)
    ignoreFailures.set(true)
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
    }
    filter {
        exclude("**/generated/**")
        exclude("**/build/**")
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    tasks.matching { it.name == "test" || it.name == "build" }.configureEach {
        dependsOn("ktlintFormat")
    }

    ktlint {
        ktLintConfig()
    }
}

ktlint {
    ktLintConfig()
}

// ktlint tasks are configured in subprojects
