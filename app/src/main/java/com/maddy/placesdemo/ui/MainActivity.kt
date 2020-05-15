package com.maddy.placesdemo.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.maddy.placesdemo.adapter.PlacesListAdapter
import com.maddy.placesdemo.databinding.ActivityMainBinding
import com.maddy.placesdemo.model.PlacesData
import com.maddy.placesdemo.viewmodel.PlacesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val handler = Handler(Looper.getMainLooper())
    private var runnable: Runnable? = null
    lateinit var placeViewModel: PlacesViewModel
    var city: String = ""
    var address: String = ""

    override val layoutResourceId: Int
        get() = com.maddy.placesdemo.R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideProgress()
        showData()
        hideBack()
        setToolbarText("Places Search")
        initViewModel()
        textchangeListeners()
    }

    private fun initViewModel() {
        placeViewModel = ViewModelProviders.of(this).get(PlacesViewModel::class.java)
    }

    private fun textchangeListeners() {
        city = et_place.text.toString().trim()
        binding.etPlace.onChange {
            city = it
            handler.removeCallbacks(runnable)
            runnable = Runnable { getPlacesApi(address, city) }
            handler.postDelayed(runnable, 500)
        }

        binding.etAddress.onChange {
            address = it
            handler.removeCallbacks(runnable)
            runnable = Runnable { getPlacesApi(address, city) }
            handler.postDelayed(runnable, 500)
        }
    }

    private fun getPlacesApi(query: String, city: String) {
        placeViewModel.getPlaces(query, city).observe(this, Observer { placesData ->
            if (placesData.status == 1) {
                if (placesData.data != null)
                    setAdapter(placesData.data.addressList)
                else
                    showToast("Some Error Occured")
            } else {
                showToast("Some Error Occured")
            }
        })
    }

    private fun setAdapter(newsList: ArrayList<PlacesData.Address>) {
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PlacesListAdapter(this@MainActivity, newsList)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    fun EditText.onChange(cb: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {cb(s.toString())}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

}
