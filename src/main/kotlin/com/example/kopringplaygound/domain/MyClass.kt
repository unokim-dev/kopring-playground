package com.example.kopringplaygound.domain

data class MyClass(val str: String, val inner: InnerClass) {
    data class InnerClass(val name: String)
}
