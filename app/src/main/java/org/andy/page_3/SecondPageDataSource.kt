package org.andy.page_3

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.flow.collect

class SecondPageDataSource: PagingSource<Int, String>() {
    companion object{
        const val TAG = "SecondPageDataSource"
    }
    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        val curPage = params.key?:0
        val loadSize = params.loadSize
        val start = curPage*loadSize
        Log.d(TAG, "$start")
        val data = ArrayList<String>()
        for(i in 0 until loadSize){
            data.add("item ${start+i}")
        }
        return LoadResult.Page(
            data = data,
            nextKey = curPage +1,
            prevKey = if(curPage> 0)(curPage -1) else null
        )
    }
}