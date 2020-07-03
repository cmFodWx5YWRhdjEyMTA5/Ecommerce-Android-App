package com.vishal.store.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.vishal.store.AppBaseActivity
import com.vishal.store.R
import com.vishal.store.base.IExpandableListAdapter
import com.vishal.store.databinding.ItemFaqHeadingBinding
import com.vishal.store.databinding.ItemFaqSubheadingBinding
import com.vishal.store.models.Category
import com.vishal.store.models.SubCategory
import com.vishal.store.utils.Constants.AppBroadcasts.CART_COUNT_CHANGE
import com.vishal.store.utils.extensions.*
import kotlinx.android.synthetic.main.activity_faqactrivity.*
import kotlinx.android.synthetic.main.menu_cart.view.*
import kotlinx.android.synthetic.main.toolbar.*

class FAQActivity : AppBaseActivity() {
    private lateinit var mMenuCart: View
    private lateinit var mFaqAdapter: IExpandableListAdapter<Category, SubCategory, ItemFaqHeadingBinding, ItemFaqSubheadingBinding>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqactrivity)
        title = getString(R.string.title_faq)
        setToolbar(toolbar)
        setFaq()

        BroadcastReceiverExt(this) {
            onAction(CART_COUNT_CHANGE) {
                setCartCount()
            }
        }
    }

    private fun setFaq() {
        mFaqAdapter = object : IExpandableListAdapter<Category, SubCategory, ItemFaqHeadingBinding, ItemFaqSubheadingBinding>(this) {
            override fun bindChildView(view: ItemFaqSubheadingBinding, childObject: SubCategory, groupPosition: Int, childPosition: Int): ItemFaqSubheadingBinding {
                return view
            }

            override fun bindGroupView(view: ItemFaqHeadingBinding, groupObject: Category, groupPosition: Int): ItemFaqHeadingBinding {
                return view
            }

            override val childItemResId: Int = R.layout.item_faq_subheading

            override val groupItemResId: Int = R.layout.item_faq_heading
        }
        exFaq.setAdapter(mFaqAdapter)
        addItems()
    }

    private fun addItems() {
        val mHeading = arrayOf(getString(R.string.lbl_account_deactivate), getString(R.string.lbl_quick_pay), getString(R.string.lbl_return_items), getString(R.string.lbl_replace_items))
        val mSubHeading = arrayOf(getString(R.string.lbl_account_deactivate), getString(R.string.lbl_quick_pay), getString(R.string.lbl_return_items), getString(R.string.lbl_replace_items))
        val map = HashMap<Category, ArrayList<SubCategory>>()
        val mFaqList = ArrayList<Category>()
        mHeading.forEachIndexed { i: Int, s: String ->
            val heading = Category()
            heading.category_name = s
            mFaqList.add(heading)
        }
        mFaqList.forEach {
            val list = ArrayList<SubCategory>()
            mSubHeading.forEach {
                val subCat = SubCategory()
                subCat.subcategory_name = it
                list.add(subCat)
            }
            map[it] = list
        }
        mFaqAdapter.addExpandableItems(mFaqList, map)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard, menu)
        val menuWishItem: MenuItem = menu!!.findItem(R.id.action_cart)
        val menuSearch: MenuItem = menu.findItem(R.id.action_search)
        menuWishItem.isVisible = true
        menuSearch.isVisible = false
        mMenuCart = menuWishItem.actionView
        mMenuCart.ivCart.setColorFilter(this.color(R.color.textColorPrimary))
        setCartCount()
        menuWishItem.actionView.onClick {
            launchActivity<MyCartActivity> { }
        }
        return super.onCreateOptionsMenu(menu)
    }

    fun setCartCount() {
        val count = getCartCount()
        mMenuCart.tvNotificationCount.text = count
        if (count.checkIsEmpty()) {
            mMenuCart.tvNotificationCount.hide()
        } else {
            mMenuCart.tvNotificationCount.show()
        }
    }
}
