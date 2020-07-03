package com.vishal.store.activity

import android.os.Bundle
import android.view.View
import com.vishal.store.AppBaseActivity
import com.vishal.store.R
import com.vishal.store.base.BaseRecyclerAdapter
import com.vishal.store.databinding.ItemOrderBinding
import com.vishal.store.databinding.ItemTrackBinding
import com.vishal.store.models.MyOrderData
import com.vishal.store.models.OrderTrack
import com.vishal.store.utils.Constants
import com.vishal.store.utils.Constants.DateFormatCodes.YMD
import com.vishal.store.utils.extensions.*
import kotlinx.android.synthetic.main.activity_track_item.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlin.math.roundToInt

class TrackItemActivity : AppBaseActivity() {
    private lateinit var mOrderItemAdapter: BaseRecyclerAdapter<MyOrderData.LineItem, ItemOrderBinding>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_item)
        val orderModel = intent.getSerializableExtra(Constants.KeyIntent.DATA) as MyOrderData

        setToolbar(toolbar)
        title = orderModel.transaction_id

        //disableHardwareRendering(rcvTracks)

        mOrderItemAdapter = object : BaseRecyclerAdapter<MyOrderData.LineItem, ItemOrderBinding>() {
            override val layoutResId: Int get() = R.layout.item_order

            override fun onBindData(model: MyOrderData.LineItem, position: Int, dataBinding: ItemOrderBinding) {
                dataBinding.tvPrice.text = model.total.roundToInt().toString().currencyFormat(orderModel.currency)
                dataBinding.tvOriginalPrice.text = model.price.toString().currencyFormat(orderModel.currency)
                dataBinding.tvTotalItem.text = String.format("%S %S", getString(R.string.lbl_total_item_count), model.quantity)
                dataBinding.tvOriginalPrice.applyStrike()
            }

            override fun onItemClick(view: View, model: MyOrderData.LineItem, position: Int, dataBinding: ItemOrderBinding) {
            }

            override fun onItemLongClick(view: View, model: MyOrderData.LineItem, position: Int) {
            }
        }

        rvOrderItems.apply { setVerticalLayout();adapter = mOrderItemAdapter }
        rcvTracks.apply { setVerticalLayout();adapter = mTracksAdapter }

        mOrderItemAdapter.addItems(orderModel.line_items)

        getOrderTracking(orderModel.id)
    }

    private fun getOrderTracking(id: Int) {
        showProgress(true)
        callApi(getRestApis().getOrderTracking(id), onApiSuccess = {
            showProgress(false)
            if (it.size > 0) mTracksAdapter.addItems(it) else tvNoTracking.show()
        }, onApiError = {
            showProgress(false)
            snackBarError(it)
        }, onNetworkError = {
            showProgress(false)
            openLottieDialog() {
                getOrderTracking(id)
            }
        })
    }

    private var mTracksAdapter = object : BaseRecyclerAdapter<OrderTrack, ItemTrackBinding>() {
        override val layoutResId: Int = R.layout.item_track

        override fun onBindData(model: OrderTrack, position: Int, dataBinding: ItemTrackBinding) {
            dataBinding.tvText1.text = "Order shipped by ${model.tracking_provider}"
            dataBinding.tvDate.text = toDate(model.date_shipped, YMD)
            if (position == mModelList.size - 1) {
                dataBinding.ivLine.hide()
            } else {
                dataBinding.ivLine.show()
            }
        }

        override fun onItemClick(view: View, model: OrderTrack, position: Int, dataBinding: ItemTrackBinding) {
            openCustomTab(model.tracking_link)
        }

        override fun onItemLongClick(view: View, model: OrderTrack, position: Int) {
        }
    }
}
