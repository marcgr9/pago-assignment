package ro.marc.pago

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.dsl.module

class PagoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

        }
    }

}