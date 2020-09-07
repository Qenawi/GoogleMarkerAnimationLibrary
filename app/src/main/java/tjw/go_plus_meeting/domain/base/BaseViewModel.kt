package tjw.go_plus_meeting.domain.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import tjw.go_plus_meeting.domain.network.Failure

open class BaseViewModel<T>(
    application: Application,
    private val useCase: T
) : AndroidViewModel(application)
{
    val toastMutable: MutableLiveData<Failure> = MutableLiveData()

    /**
     * This is the job for all coroutines started by this ViewModel.
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    val job = Job()
    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     * Since we pass viewModelJob, you can cancel all coroutines
     * launched by uiScope by calling viewModelJob.cancel()
     */
    val uiScope = CoroutineScope(Dispatchers.Main + job)

    protected fun handleFailure(failure: Failure)
    {
        this.toastMutable.value = failure
    }

    /**
     * Cancel all coroutines when the ViewModel is cleared
     */
    override fun onCleared()
    {
        super.onCleared()
        if(useCase is BaseUseCase<*, *>)
            (useCase as BaseUseCase<*, *>).onCleared()
        // todo add Use Case OnClear
    }
}