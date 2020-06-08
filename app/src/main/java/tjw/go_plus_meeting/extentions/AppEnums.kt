package tjw.go_plus_meeting.extentions

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import tjw.go_plus_meeting.R
import tjw.go_plus_meeting.domain.network.Failure



enum class NavState{Closed,OPENED,NONE}
enum class RecyclerViewStatus { Loading, NetWorkFailure, ResponseFail, EmptyResponse ,Success,UnknownFail }
enum class Navigation { Nav1, Nav2}
@Parcelize
data class MenuItem(
    var type: Navigation=Navigation.Nav1,
    var name: Int,
    var img: Int
) : Parcelable


fun NavState?.revert()=
when(this){
    NavState.Closed -> NavState.OPENED
    NavState.OPENED , null -> NavState.Closed
    else -> NavState.NONE
}




fun ArrayList<*>?.toRecyclerViewStatus()
{
 if (this.isNullOrEmpty())RecyclerViewStatus.EmptyResponse
 else RecyclerViewStatus.Success
}
fun Failure.toRecyclerViewStatus():RecyclerViewStatus
= when (this) {
        is Failure.NetworkConnection -> RecyclerViewStatus.NetWorkFailure
        is Failure.RequestError , is Failure.ServerError -> RecyclerViewStatus.ResponseFail
        else->RecyclerViewStatus.ResponseFail
    }
