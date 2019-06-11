package com.beeete2.android.recyclerviewexample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import createSwitchModels

class AdapterFragment : Fragment() {

    private val data = createSwitchModels()

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_base, container, false).apply {
            recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
                this.setHasFixedSize(true)
                this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                this.adapter = RecyclerAdapter(requireContext(), data)
            }
        }
        return view
    }

    class RecyclerAdapter(
        private val context: Context,
        private val data: List<SwitchModel>
    ) : RecyclerView.Adapter<SwitchViewHolder>() {

        private var recyclerView: RecyclerView? = null

        override fun onAttachedToRecyclerView(rv: RecyclerView) {
            super.onAttachedToRecyclerView(rv)
            recyclerView = rv
        }

        override fun onDetachedFromRecyclerView(rv: RecyclerView) {
            super.onDetachedFromRecyclerView(rv)
            recyclerView = null
        }

        override fun onBindViewHolder(holder: SwitchViewHolder, position: Int) {
            val model = data[position]
            holder.switchCompat.apply {
                this.text = model.label
                this.isChecked = model.checked
            }
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwitchViewHolder {
            val layoutInflater = LayoutInflater.from(context)
            val mView = layoutInflater.inflate(R.layout.item_switch, parent, false)

            return SwitchViewHolder(mView)
        }
    }

    class SwitchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val switchCompat: SwitchCompat by lazy { view.findViewById<SwitchCompat>(R.id.switch_compat) }
    }

}
