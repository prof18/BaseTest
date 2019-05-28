package com.prof18.basetest.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.prof18.basetest.R
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var viewModel: BaseViewModel

    /**
     * Implement it to provide the id of the main layout
     */
    protected abstract fun getLayoutResourceId(): Int

    /**
     * Override it if you want a specific ViewModel.
     *
     * If you don't want a view model, the base one is instantiated
     *
     */
    protected open fun setViewModel(): BaseViewModel {
        return ViewModelProviders.of(this@BaseActivity).get(BaseViewModel::class.java)
    }

    /**
     *
     * Override it if you want to provide a custom title, show the back button
     * or setup a custom back behaviour
     *
     */
    protected open fun setupActionBar(
            toolbarTitle: String = "",
            showBackButton: Boolean = false,
            toolbarAction: () -> Unit = { onBackPressed() }
    ) {
        base_toolbar.title = toolbarTitle
        setSupportActionBar(base_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(showBackButton)
        supportActionBar?.setDisplayShowHomeEnabled(showBackButton)
        base_toolbar.setNavigationOnClickListener { toolbarAction() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_base)
        base_stub_layout.layoutResource = getLayoutResourceId()
        base_stub_layout.inflate()

        setupActionBar()

        viewModel = setViewModel()

        // Just a log to see that the base observer is working
        viewModel.liveMessage.observe(this@BaseActivity, Observer {
            Log.d("BaseActivity", it)
        })
    }
}