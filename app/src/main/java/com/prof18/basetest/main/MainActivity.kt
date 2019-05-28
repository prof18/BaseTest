package com.prof18.basetest.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.prof18.basetest.R
import com.prof18.basetest.base.BaseActivity
import com.prof18.basetest.base.BaseViewModel
import com.prof18.basetest.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel

    override fun setViewModel(): BaseViewModel {
        viewModel = ViewModelProviders.of(this@MainActivity).get(MainViewModel::class.java)
        return viewModel
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_main

    override fun setupActionBar(toolbarTitle: String, showBackButton: Boolean, toolbarAction: () -> Unit) {
        super.setupActionBar(
            toolbarTitle = getString(R.string.app_name),
            showBackButton = showBackButton,
            toolbarAction = toolbarAction
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fab.setOnClickListener { view ->
            startActivity(Intent(this@MainActivity, DetailActivity::class.java))
        }

        viewModel.liveMessage.observe(this@MainActivity, Observer {message ->
            message?.let {
                text.text = it
            }
        })

        viewModel.generateMessage()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
