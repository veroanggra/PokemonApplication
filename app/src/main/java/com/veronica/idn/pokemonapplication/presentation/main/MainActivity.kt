package com.veronica.idn.pokemonapplication.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.veronica.idn.pokemonapplication.R
import com.veronica.idn.pokemonapplication.databinding.ActivityMainBinding
import com.veronica.idn.pokemonapplication.presentation.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(), MainInterface.View {
    @Inject
    lateinit var presenter: MainInterface.Presenter<MainInterface.View>

    private lateinit var navController: NavController


    override fun onConnectivityChanged(isOnline: Boolean) {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setupPresenter() {
        presenter.attachView(this, this.lifecycle)
    }

    override fun onPresenterAttached() {
        navController = Navigation.findNavController(this, R.id.fragment)
    }

    override fun showMainProgressBar(show: Boolean) {
    }

    override fun showError(message: String?) {
        Timber.e(message)
    }

    companion object {
        fun getLaunchService(from: Context) =
            Intent(from, MainActivity::class.java).apply {
                addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
                            or Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
            }
    }
}