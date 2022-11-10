import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PionerData(
    val name:String?,
    val location:String?,
    val type:String?,
    val rate:String?,
    val power_consume:String?
) : Parcelable

