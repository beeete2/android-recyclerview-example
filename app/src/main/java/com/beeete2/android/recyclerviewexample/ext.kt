import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.beeete2.android.recyclerviewexample.SwitchModel

fun Fragment.navigate(@IdRes id: Int) {
    findNavController().navigate(id)
}

fun Fragment.createSwitchModels(): List<SwitchModel> {
    return listOf(
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
}
