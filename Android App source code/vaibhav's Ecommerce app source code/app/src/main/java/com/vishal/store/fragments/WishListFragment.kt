package com.vishal.store.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vishal.store.R
import com.vishal.store.activity.ProductDetailActivity
import com.vishal.store.base.BaseRecyclerAdapter
import com.vishal.store.databinding.ItemWishlistBinding
import com.vishal.store.models.RequestModel
import com.vishal.store.models.WishListData
import com.vishal.store.utils.Constants.KeyIntent.PRODUCT_ID
import com.vishal.store.utils.extensions.*
import kotlinx.android.synthetic.main.fragment_wishlist.*
import kotlinx.android.synthetic.main.layout_nodata.*

class WishListFragment : BaseFragment() {
    private val mListAdapter = getAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wishlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvWishList.adapter = mListAdapter
        rvWishList.rvItemAnimation()
    }

    private fun getAdapter(): BaseRecyclerAdapter<WishListData, ItemWishlistBinding> {

        return object : BaseRecyclerAdapter<WishListData, ItemWishlistBinding>() {

            override fun onItemClick(view: View, model: WishListData, position: Int, dataBinding: ItemWishlistBinding) {
                when (view.id) {
                    R.id.btnRemove -> {
                        showProgress()
                        val requestModel = RequestModel(); requestModel.pro_id = model.pro_id.toString()
                        activity?.removeFromWishList(requestModel) {
                            if(activity == null) return@removeFromWishList
                            hideProgress()
                            if (it) snackBar(getString(R.string.lbl_removed))
                        }
                    }
                    R.id.llMoveToCart -> {
                        showProgress()
                        val requestModel = RequestModel()
                        requestModel.pro_id = model.pro_id.toString()
                        requestModel.product_id = model.pro_id.toString()
                        requestModel.quantity = 1
                        //TODO
                        requestModel.size = "S"
                        requestModel.color = "#000000"

                        callApi(getRestApis(false).addItemToCart(request = requestModel), onApiSuccess = {
                            if(activity == null) return@callApi
                            activity?.fetchAndStoreCartData()
                            hideProgress()
                            activity?.removeFromWishList(requestModel) { if (it) snackBar(getString(R.string.lbl_removed)); hideProgress() }
                        }, onApiError = {
                            if(activity == null) return@callApi
                            hideProgress()
                            activity?.snackBarError(it)
                        }, onNetworkError = {
                            if(activity == null) return@callApi
                            hideProgress()
                            activity?.noInternetSnackBar()
                        })
                    }
                    else -> {
                        activity?.launchActivity<ProductDetailActivity> { putExtra(PRODUCT_ID,model.pro_id) }
                    }
                }
            }

            override val layoutResId: Int = R.layout.item_wishlist

            override fun onBindData(model: WishListData, position: Int, dataBinding: ItemWishlistBinding) {
                if (activity !== null) {
                    dataBinding.tvProductPrice.text = model.price?.currencyFormat()
                    dataBinding.tvProductActualPrice.text = model.regular_price?.currencyFormat()
                    dataBinding.tvProductActualPrice.applyStrike()

                    if (model.full != null) dataBinding.ivProduct.loadImageFromUrl(model.full!!)

                    dataBinding.llProductColor.removeAllViews()
                }
            }

            override fun onItemLongClick(view: View, model: WishListData, position: Int) {}
        }
    }

    override fun onResume() {
        super.onResume()
        wishListItemChange()
    }

    fun wishListItemChange() {
        if (rvWishList != null) {
            val mWishList = getWishListFromPref()
            mListAdapter.addItems(mWishList)
            if (mWishList.size == 0) rlNoData.show()
            else rlNoData.hide()
        }
    }
}
