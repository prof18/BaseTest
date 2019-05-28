package com.prof18.basetest.detail

import com.prof18.basetest.R
import com.prof18.basetest.base.BaseActivity

class DetailActivity : BaseActivity() {

    override fun getLayoutResourceId(): Int = R.layout.activity_detail

    override fun setupActionBar(toolbarTitle: String, showBackButton: Boolean, toolbarAction: () -> Unit) {
        super.setupActionBar(
            toolbarTitle = "Detail Screen",
            showBackButton = true,
            toolbarAction = toolbarAction
        )
    }
}