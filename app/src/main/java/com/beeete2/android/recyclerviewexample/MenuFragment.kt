package com.beeete2.android.recyclerviewexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.TypedEpoxyController
import com.beeete2.android.recyclerviewexample.view.menuItem
import navigate

class MenuFragment : Fragment() {

    private val data = listOf(
        Menu("RecyclerView.Adapter", R.id.adapterFragment),
        Menu("Epoxy.Adapter", R.id.epoxyFragment)
    )

    private lateinit var controller: Controller
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_base, container, false).apply {
            controller = Controller()
            controller.setData(data)
            recyclerView = findViewById(R.id.recycler_view)
            recyclerView.apply {
                this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                this.adapter = controller.adapter
            }
        }

        return view
    }

    private inner class Controller : TypedEpoxyController<List<Menu>>() {
        override fun buildModels(data: List<Menu>?) {
            data ?: return

            data.forEachIndexed { index, menu ->
                menuItem {
                    id("menu$index")
                    label(menu.label)
                    clickListener { _ ->
                        navigate(menu.navigationId)
                    }
                }
            }
        }
    }
}

data class Menu(val label: String, val navigationId: Int)
