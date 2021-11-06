package org.andy.page_3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn

class SecondViewModel: ViewModel() {

    private val pagingConfig =
        PagingConfig(pageSize = 20, enablePlaceholders = false, maxSize = 300)

    val list = Pager(pagingConfig){
        SecondPageDataSource()
    }.flow.cachedIn(viewModelScope)

}