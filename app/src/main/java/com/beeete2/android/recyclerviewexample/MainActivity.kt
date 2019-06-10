package com.beeete2.android.recyclerviewexample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val data = listOf(
        SwitchModel("Switch1"),
        SwitchModel("Switch2"),
        SwitchModel("Switch3"),
        SwitchModel("Switch4"),
        SwitchModel("Switch5"),
        SwitchModel("Switch6"),
        SwitchModel("Switch7"),
        SwitchModel("Switch8"),
        SwitchModel("Switch9"),
        SwitchModel("Switch10"),
        SwitchModel("Switch11"),
        SwitchModel("Switch12"),
        SwitchModel("Switch13"),
        SwitchModel("Switch14"),
        SwitchModel("Switch15"),
        SwitchModel("Switch16"),
        SwitchModel("Switch17"),
        SwitchModel("Switch18"),
        SwitchModel("Switch19"),
        SwitchModel("Switch20")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = RecyclerAdapter(this, data)
        recycler_view.apply {
            this.setHasFixedSize(true)
            this.layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
        }
    }

    class SwitchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val switchCompat: SwitchCompat by lazy { view.findViewById<SwitchCompat>(R.id.switch_compat) }
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

    data class SwitchModel(val label: String, val checked: Boolean = false)
}
