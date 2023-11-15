package com.example.kopringplaygound.domain.embeddable

import jakarta.persistence.Embeddable

@Embeddable
class MyDiscount {
    var tripstoreDiscount: Int? = null
    var supplierDiscount: Int? = null
}