package com.codingwithmitch.cleannotes.business.data.cache

import com.codingwithmitch.cleannotes.business.data.cache.CacheErrors.CACHE_ERROR_NULL
import com.codingwithmitch.cleannotes.business.domain.state.*

abstract class CacheResponseHandler<ViewState, Data>(
    private val response: CacheResult<Data?>,
    private val stateEvent: StateEvent?
){
    suspend fun getResult(): DataState<ViewState>?{
        return when(response){
            is CacheResult.GenericError -> {
                DataState.error(
                    response =  Response(
                        message = "${stateEvent?.errorInfo()}\n\n" +
                                "Reason: ${response.errorMessage}",
                        uiComponentType = UIComponentType.Dialog(),
                        messageType = MessageType.Error()
                    ),
                    stateEvent = stateEvent
                )
            }

            is CacheResult.Success -> {
                if(response.value == null){
                    DataState.error(
                        response =  Response(
                            message = "${stateEvent?.errorInfo()}\n\n" +
                                    "Reason: ${CACHE_ERROR_NULL}",
                            uiComponentType = UIComponentType.Dialog(),
                            messageType = MessageType.Error()
                        ),
                        stateEvent = stateEvent
                    )
                } else {
                    handleSuccess(resultObj = response.value)
                }
            }
        }
    }


    abstract fun handleSuccess(resultObj: Data): DataState<ViewState>
}