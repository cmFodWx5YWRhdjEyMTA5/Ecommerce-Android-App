package com.vishal.store.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import com.vishal.store.AppBaseActivity
import com.vishal.store.R
import com.vishal.store.adapter.RecyclerViewAdapter
import com.vishal.store.fragments.ViewAllProductFragment
import com.vishal.store.models.CategoryData
import com.vishal.store.models.FilterProductRequest
import com.vishal.store.models.ProductDataNew
import com.vishal.store.models.RequestModel
import com.vishal.store.utils.Constants
import com.vishal.store.utils.Constants.KeyIntent.DATA
import com.vishal.store.utils.Constants.KeyIntent.KEYID
import com.vishal.store.utils.Constants.KeyIntent.TITLE
import com.vishal.store.utils.Constants.KeyIntent.VIEWALLID
import com.vishal.store.utils.Constants.ViewAllCode.CATEGORY_FEATURED
import com.vishal.store.utils.extensions.*
import kotlinx.android.synthetic.main.activity_sub_category.*
import kotlinx.android.synthetic.main.toolbar.*

class SubCategoryActivity : AppBaseActivity() {
    private lateinit var mCategoryData: CategoryData
    private var imgLayoutParams: LinearLayout.LayoutParams? = null
    private lateinit var mFeaturedAdapter: RecyclerViewAdapter<ProductDataNew>
    private lateinit var mNewArrivalAdapter: RecyclerViewAdapter<ProductDataNew>
    private var mViewAllProductFragment = ViewAllProductFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)
        if (intent.getSerializableExtra(DATA) == null) {
            toast(R.string.error_something_went_wrong)
            finish()
            return
        }
        mCategoryData = intent.getSerializableExtra(DATA) as CategoryData

        setToolbar(toolbar)
        title = mCategoryData.name.getHtmlString()
        imgLayoutParams = productLayoutParams()
        rcvNewArrival.setHorizontalLayout()
        rcvPopular.setHorizontalLayout()
        mFeaturedAdapter = getFeaturedAdapter()
        mNewArrivalAdapter = getFeaturedAdapter()
        rcvNewArrival.adapter = mNewArrivalAdapter
        rcvPopular.adapter = mFeaturedAdapter
        mNewArrivalAdapter.setModelSize(5)
        mFeaturedAdapter.setModelSize(5)
        mFeaturedAdapter.onItemClick = { pos, view, item ->
            showProductDetail(item)
        }
        mNewArrivalAdapter.onItemClick = { pos, view, item ->
            showProductDetail(item)
        }

        viewNewArrival.onClick {
            launchActivity<ViewAllProductActivity> {
                putExtra(TITLE, getString(R.string.lbl_new_arrival))
                putExtra(VIEWALLID, Constants.ViewAllCode.CATEGORY_NEWEST)
                putExtra(KEYID, mCategoryData.cat_ID)
            }
        }
        viewFeatured.onClick {
            launchActivity<ViewAllProductActivity> {
                putExtra(TITLE, getString(R.string.lbl_popular))
                putExtra(VIEWALLID, CATEGORY_FEATURED)
                putExtra(KEYID, mCategoryData.cat_ID)
            }
        }
        getSubCategoryProducts()
        getFeaturedProducts()
        if (mCategoryData.subcategory?.isNotEmpty()!!) {
            setupSubCategory()
            rcvSubCategory.show()
        } else {
            rcvSubCategory.hide()
        }
    }

    private fun setupSubCategory() {
        showProgress(true)
        val requestModel = RequestModel(); requestModel.cat_id = mCategoryData.cat_ID

        callApi(getRestApis(false).getSubCategories(requestModel), onApiSuccess = {
            showProgress(false)
            val subCategoryAdapter = getCategoryAdapter()
            rcvSubCategory.apply { setHorizontalLayout(); adapter = subCategoryAdapter }
            subCategoryAdapter.addItems(it)
        }, onApiError = {
            showProgress(false)
            snackBarError(it)
        }, onNetworkError = {
            showProgress(false)
            noInternetSnackBar()
        })
    }

    private fun getFeaturedProducts() {
        showProgress(true)
        val mSelectedCategory: ArrayList<Int> = ArrayList()
        mSelectedCategory.add(mCategoryData.cat_ID)
        val requestModel = FilterProductRequest(); requestModel.category = mSelectedCategory
        callApi(getRestApis(false).getFeaturedProducts(requestModel), onApiSuccess = {
            showProgress(false)
            if (it.size == 0) {
                rlFeature.hide()
                rcvPopular.hide()
            } else {
                rlFeature.show()

                mFeaturedAdapter.addItems(it)
            }
        }, onApiError = {
            rlFeature.hide()
            rcvPopular.hide()
            showProgress(false)
            if (it.contains("Sorry! No Product Available")){
                snackBarError("Sorry! No featured Product Available")
            }else{
                snackBarError(it)
            }
        }, onNetworkError = {
            showProgress(false)
            noInternetSnackBar()
        })
    }

    private fun getSubCategoryProducts() {
        showProgress(true)
        val mFilterProductRequest = FilterProductRequest()

        val mSelectedCategory: ArrayList<Int> = ArrayList()
        mSelectedCategory.add(mCategoryData.cat_ID)

        if (mSelectedCategory.isNotEmpty()) mFilterProductRequest.category = mSelectedCategory

        callApi(getRestApis().filterProduct(request = mFilterProductRequest), onApiSuccess = {
            showProgress(false)
            if (it.size == 0) {
                rlNewArrival.hide()
                rcvNewArrival.hide()
            } else {
                rlNewArrival.show()
                mNewArrivalAdapter.addItems(it)
            }
            showProgress(false)
        }, onApiError = {
            rlNewArrival.hide()
            rcvNewArrival.hide()
            showProgress(false)
            if (it.contains("Sorry! No Product Available")){
                snackBarError("Sorry! No Newest Product Available")
            }else{
                snackBarError(it)
            }
        }, onNetworkError = {
            showProgress(false)
            openLottieDialog {
                getSubCategoryProducts()
            }
        })
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.getItem(0)?.isVisible = !mViewAllProductFragment.isVisible
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_search) {
            loadSearchFragment()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    private fun loadSearchFragment() {
        launchActivity<SearchActivity>()
    }

    override fun onBackPressed() {
        when {
            mViewAllProductFragment.isVisible -> {
                title = intent.getStringExtra(TITLE)
                removeFragment(mViewAllProductFragment)
                invalidateOptionsMenu()
            }
            else -> super.onBackPressed()
        }
    }

    private fun getFeaturedAdapter(): RecyclerViewAdapter<ProductDataNew> {
        return RecyclerViewAdapter(
            R.layout.item_product_new,
            onBind = { view, item, position -> setProductItem(view, item) })
    }


}