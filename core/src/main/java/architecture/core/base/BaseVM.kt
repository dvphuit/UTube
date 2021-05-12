package architecture.core.base

import androidx.lifecycle.ViewModel

abstract class BaseVM : ViewModel() {
    protected fun isOnline(): Boolean = true
}