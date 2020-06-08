package tjw.go_plus_meeting.domain.network

sealed class Failure() {
    // external
    object NetworkConnection : Failure()// failed to connect to network
    {
        override var f_causeSt: String? = "لا يمكن الاتصال بالانترنت"
        override var f_causeTh: Throwable? = null
    }

    // server has empty response or useless response
    object ServerError : Failure() {
        override var f_causeSt: String? = "برجاء المحاوله في وقت اخر .."
        override var f_causeTh: Throwable? = null
    }

    // request has been sent but it has the wrong response
    object RequestError : Failure() {
        override var f_causeSt: String? = "برجاء تفقد البيانات المرسله واعاده الارسال"
        override var f_causeTh: Throwable? = null
    }
    object AuthrizationError : Failure() {
        override var f_causeSt: String? = "يجب عليك تسجيل الدخول مره اخري"
        override var f_causeTh: Throwable? = null
    }
    // internal
    // gps is not enabled and location is turned off
    object GPSError : Failure() {
        override var f_causeSt: String? = "برجاء تشغيل ال Gps"
        override var f_causeTh: Throwable? = null
    }

    object SecurityError : Failure()// permissions
    {
        override var f_causeSt: String? = "برجاء اعطاء التطبيق الصلاحيات المطلوبه للمتابعه"
        override var f_causeTh: Throwable? = null
    }

    object ValidationError : Failure()// permissions
    {
        override var f_causeSt: String? = "من فضلك ادخل بيناتك بطريقه صحيحه"
        override var f_causeTh: Throwable? = null
    }

    // base params for failure cause
    abstract var f_causeTh: Throwable?//only for future use and as fall safe
    abstract var f_causeSt: String?

    //------------------------------------
    abstract class FeatureFailure : Failure() // todo Refactor

    object AccountActivationError:Failure() {
        override var f_causeSt: String? = "من فضلك ادخل بيناتك بطريقه صحيحه"
        override var f_causeTh: Throwable? = null
    }


}
fun <T : Failure> T.setArgs(str: String?, thr: Throwable?=null): T {
    this.f_causeSt = str
    this.f_causeTh = thr
    return this
}
fun <T : Failure> T.fast_int(f:Failure): T {
    this.f_causeSt = f.f_causeSt
    this.f_causeTh = f.f_causeTh
    return this
}