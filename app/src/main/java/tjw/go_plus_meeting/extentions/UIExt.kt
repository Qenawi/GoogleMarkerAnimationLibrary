package tjw.go_plus_meeting.extentions

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.core.view.GravityCompat
import androidx.databinding.BindingAdapter
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.*
import tjw.go_plus_meeting.R
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


fun Activity.cHideSoftKeyboard() {
    val focusedView = currentFocus
    focusedView?.let { view ->
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
@BindingAdapter("loadImageFromUrl", "load_as_cover", requireAll = false)
fun cLoadImageFromUrl(view: ImageView, url: String?, cover: Boolean? = false)
{
    val requestOptions = RequestOptions().apply {
        if (cover == true) {
            //placeholder(R.color.carbon_white)
            error(R.color.colorAccent).placeholder(R.color.colorAccent)
        } else {
            //  this.placeholder(R.drawable.user)
            error(R.drawable.ic_launcher_background).placeholder(R.drawable.ic_launcher_background)
        }
    }
    Glide.with(view.context).applyDefaultRequestOptions(requestOptions).load("$url")
        .into(view)
}

fun View.cVisible(boolean: Boolean?) {
    boolean?.let {
        if (boolean) this.visibility = View.VISIBLE
        else this.visibility = View.INVISIBLE
    }
}

fun View.cEnable(boolean: Boolean?) =
    when (boolean) {
        true -> {
            this.isEnabled = true
        }
        false -> {
            this.isEnabled = false
        }
        null -> {
        }
    }

fun EditText.cTextExtractor(): String {
    return if (this.text.isNullOrEmpty()) ""
    else this.text.toString()
}
fun Spinner.cPopulate(arrayListID: Int) {
    this.context?.let { ctx ->
        val mArray = ctx.resources.getStringArray(arrayListID)
        val adb = ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_dropdown_item, mArray)
        this.adapter = adb
    }
}
@BindingAdapter("lock_view")
fun View.mLock(load: Boolean?) = load?.let { bool -> this.mEnable(!bool) }
fun View.mEnable(boolean: Boolean?) =
    when (boolean) {
        true -> {
            this.isEnabled = true
        }
        false -> {
            this.isEnabled = false
        }
        null -> {
        }
    }

@BindingAdapter("progress_view")
fun View.mProgress(boolean: Boolean?) {
    cVisible(boolean)
}
@SuppressLint("SetTextI18n")
@BindingAdapter(
    value = ["safe_text", "decimal_format", "before_text", "after_text"],
    requireAll = false
)
fun TextView.mText(any: Any?, boolean: Boolean?, before_text: Int?, after_text: Int?) =
    any?.let { sText ->
        text = if (boolean == true) (sText as Int).safeDecimalFormat() else sText.toString()
        before_text?.let { aa ->
            text = "${getString_(aa)} ${text.toString()}"
        }
        after_text?.let { aa ->
            text = "${text.toString()} ${getString_(aa)} "
        }
    }

fun Int?.safeDecimalFormat():String{
    val df = DecimalFormat("#,###")
    df.roundingMode = RoundingMode.CEILING
    return  this?.let {num->

        val ret=  df.format(num)
        ret
    }?: ""
}
fun delay250(block: (Any) -> Unit = {}) {
    GlobalScope.launch {
        delay(250)
        withContext(Dispatchers.Main)
        { block(Any()) }
    }
}
fun delay150(block: (Any) -> Unit = {}) {
    GlobalScope.launch {
        delay(150)
        withContext(Dispatchers.Main)
        { block(Any()) }
    }
}
@SuppressLint("SetTextI18n")
@BindingAdapter("safe_date")
fun TextView.mSafeDate(date:String?)
{
    val formatDate= try{ convertDateFromFormatToOther(date?:"") }catch (e:Exception) {null}
    this.text=formatDate?:"not dated"
}
private fun convertDateFromFormatToOther(fDate:String):String?
{
    val parser =  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT).parse(fDate)
    val formatter = SimpleDateFormat("MMM dd yyyy",Locale.ROOT)
    return parser?.let { date -> formatter.format(date) }
}
@SuppressLint("SimpleDateFormat")
@BindingAdapter("milliSecondData")
fun TextView.msData(msDate: String?)
        = msDate?.let {date->
    this.text= SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).format(date.toLong())
}
@BindingAdapter("go_back", "title", requireAll = false)
fun View.handle(data: MutableLiveData<Boolean>?, name: MutableLiveData<String>?)
{
    when (name?.value) {
        getString_(R.string.app_name) -> this.cVisible(false)
        else -> this.cVisible(true)
    }
    this.setOnClickListener { data?.postValue(true) }
}
@BindingAdapter( "menue_action","menue_title",requireAll = true)
fun View.handleMenue(data: MutableLiveData<Boolean>?,name: MutableLiveData<String>?)
{
    when (name?.value) {
        getString_(R.string.app_name) -> this.cVisible(true)
        else -> this.cVisible(false)
    }
    this.setOnClickListener { data?.postValue(true) }
}

@BindingAdapter("search_", "title_", requireAll = false)
fun View.handle_search(data: MutableLiveData<Boolean>?, name: MutableLiveData<String>?) {
    when (name?.value) {
        getString_(R.string.app_name) -> this.cVisible(false)
        else -> this.cVisible(true)
    }
    this.setOnClickListener { data?.postValue(true) }
}



fun View.getString_(resource_id: Int): String = try {
    this.context.getString(resource_id)
} catch (e: Exception) {
    "-"
}

fun View.getImg_(resource_id: Int): Drawable = try {
    this.context.resources.getDrawable(resource_id)
} catch (e: Exception) {
    this.context.resources.getDrawable(R.drawable.ic_launcher_foreground)
}


@BindingAdapter("from_res_id")
fun View.fromDate(int: Int?)
{
    int?.let {id->
        when(this)
        {
            is TextView -> this.text=this.getString_(id)
            is ImageView->this.setImageDrawable(this.getImg_(id))
        }
    }}
@BindingAdapter("menu_selection","selection",requireAll = true)
fun View.menuSelection(res: tjw.go_plus_meeting.extentions.MenuItem?, navigation: Navigation?)=cVisible(navigation?.equals(res?.type))


fun RecyclerView.mLinearLayoutManager() {
    this.layoutManager = LinearLayoutManager(this.context)
}

@BindingAdapter("controle_drawer")
fun DrawerLayout.handle(navigation: NavState?)
{
    when(navigation)
    {
        NavState.Closed  -> if (isDrawerOpen(GravityCompat.START)) closeDrawer(GravityCompat.START) else openDrawer(
            GravityCompat.START)
        NavState.OPENED -> if (!isDrawerOpen(GravityCompat.START))  openDrawer(GravityCompat.START) else closeDrawer(
            GravityCompat.START)
        null,NavState.NONE ->{}
    }

}

//new Update ->
