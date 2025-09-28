package my.drivebit.clients.web

import my.drivebit.clients.screens.splash.SplashViewModel

class WebDataService {
    private val splashViewModel = SplashViewModel()

    fun getHeroTitle(): String {
        // Используем общую логику из SplashViewModel
        return "Арендуй машину у частного владельца на 40% дешевле"
    }

    fun getHeroSubtitle(): String {
        return "Мы создали сервис, который решает главные проблемы аренды автомобилей"
    }

    fun getCars(): List<CarData> {
        return listOf(
            CarData("Skoda Rapid", "📍 Калининград", "2800₽ / сутки", "2019 год", "Механическая", "Бензин", "1.6 л"),
            CarData("BMW X5", "📍 Москва", "8000₽ / сутки", "2021 год", "Автоматическая", "Бензин", "3.0 л"),
            CarData(
                "Hyundai Creta",
                "📍 Санкт-Петербург",
                "3500₽ / сутки",
                "2020 год",
                "Автоматическая",
                "Бензин",
                "2.0 л",
            ),
        )
    }

    fun getFeatures(): List<FeatureData> {
        return listOf(
            FeatureData(
                "₽",
                "Дешевле проката на 40%",
                "Работаем без посредников и лишних наценок. Аренда напрямую у владельцев.",
            ),
            FeatureData(
                "🛡️",
                "Полная страховка",
                "Решаем проблемы за вас. Ваша ответственность — 0₽. Все риски на нас.",
            ),
            FeatureData("📞", "Поддержка 24/7", "Поможем в любой ситуации в дороге. На связи круглосуточно."),
            FeatureData(
                "⏱️",
                "Честный залог",
                "Возвращаем сразу после сдачи авто. Никаких задержек и скрытых удержаний.",
            ),
        )
    }
}

data class CarData(
    val title: String,
    val location: String,
    val price: String,
    val year: String,
    val transmission: String,
    val fuel: String,
    val engine: String,
)

data class FeatureData(
    val icon: String,
    val title: String,
    val description: String,
)
