package me.lab.happyflight.di

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import me.lab.happyflight.views.ui.booking.BookingViewModel
import me.lab.happyflight.views.ui.dashboard.DashboardViewModel
import me.lab.happyflight.views.ui.home.HomeViewModel
import me.lab.happyflight.views.ui.notifications.NotificationsViewModel
import me.lab.happyflight.views.ui.ticket.TicketViewModel
import org.koin.dsl.module

val appModule = module {
    factory { (context: Context, lifecycleScope: LifecycleCoroutineScope) ->
        NotificationsViewModel(context, lifecycleScope)
    }

    factory { (context: Context, lifecycleScope: LifecycleCoroutineScope) ->
        HomeViewModel(context, lifecycleScope)
    }
    factory { (context: Context, lifecycleScope: LifecycleCoroutineScope) ->
        DashboardViewModel(context, lifecycleScope)
    }
    factory { (context: Context, lifecycleScope: LifecycleCoroutineScope) ->
        BookingViewModel(context, lifecycleScope)
    }
    factory { (context: Context, lifecycleScope: LifecycleCoroutineScope) ->
        TicketViewModel(context, lifecycleScope)
    }
}

