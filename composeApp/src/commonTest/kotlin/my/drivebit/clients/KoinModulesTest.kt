package my.drivebit.clients

import my.drivebit.clients.di.appModule
import my.drivebit.clients.screens.splash.SplashState
import my.drivebit.clients.screens.splash.SplashViewModel
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class KoinModulesTest {

    @BeforeTest
    fun setup() {
        stopKoin()
        startKoin {
            modules(appModule)
        }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun resolvesSplashViewModel() {
        val koin = GlobalContext.get().koin
        val vm: SplashViewModel = koin.get()
        assertNotNull(vm)
        // initial state should be Init before async loader flips it
        assertIs<SplashState.Init>(vm.state.value)
    }
}


