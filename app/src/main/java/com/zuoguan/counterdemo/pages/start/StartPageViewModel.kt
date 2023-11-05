package com.zuoguan.counterdemo.pages.start
import androidx.lifecycle.ViewModel
import com.zuoguan.counterdemo.di.CountRecorderService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


data class CountState(
    var count: Int = 0,
)

@HiltViewModel
class StartPageViewModel @Inject constructor(
    private val countRecorderService: CountRecorderService
) : ViewModel() {
    private val _countState = MutableStateFlow(CountState())
    val countState = _countState.asStateFlow()

    fun addOne(){
        countRecorderService.addCount()
        _countState.update { it.copy(count = it.count+1) }
    }
}