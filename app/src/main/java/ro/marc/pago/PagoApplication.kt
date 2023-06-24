package ro.marc.pago

import android.app.Application
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import ro.marc.pago.activity.MainActivityVM
import ro.marc.pago.data.repo.Repository
import ro.marc.pago.data.service.Service
import ro.marc.pago.utils.SecurityUtils

class PagoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                module {
                    single {
                        SecurityUtils.getRetrofit()
                    }
                    single {
                        Repository(
                            get<Retrofit>().create(Service::class.java),
                        )
                    }
                },
                module {
                    viewModel {
                        MainActivityVM(get())
                    }
                },
            )
        }
    }

}
