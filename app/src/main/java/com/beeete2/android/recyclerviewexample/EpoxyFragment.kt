package com.beeete2.android.recyclerviewexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.airbnb.epoxy.EpoxyRecyclerView
import com.beeete2.android.recyclerviewexample.view.switchItem
import createSwitchModels

class EpoxyFragment : Fragment() {

    private val data = createSwitchModels()

    private lateinit var recyclerView: EpoxyRecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_epoxy, container, false).apply {
            recyclerView = findViewById(R.id.recycler_view)
            recyclerView.apply {
                this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                this.withModels {
                    data.forEachIndexed { index, model ->
                        switchItem {
                            id("switch$index")
                            label(model.label)
                        }
                    }
                }
            }
        }

        return view
    }

}