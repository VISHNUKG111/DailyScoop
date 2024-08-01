package com.example.dailyscoop.util

sealed class Resource<T>(
    val data: T? = null
    val message: string? = null
){
    class  success<T>(data: T): resource<T>(data)
    class Error<T>(message: string, data: T?=null):resources<T>(data, message)
    class loading<T>: resource<T>()
}