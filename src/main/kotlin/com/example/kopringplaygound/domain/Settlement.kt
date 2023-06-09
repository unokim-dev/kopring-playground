package com.example.kopringplaygound.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

/**
 * 해당 Entity 및 테이블은 `해당 예약건이 실제로 출발을 했는가` 로 정산 대상 인지에 대한 체크 용도로만 사용됩니다. (출발 확정 = 수수료 계산 대상)
 * 포괄적으로 `정산` 이라는 용어를 사용한 것이고, 보편적으로 알고있는 명확한 정산 시스템을 의미하지 않습니다.
 * 추후 정산 시스템이 만들어질 경우 해당 객체는 데이터만 마이그레이션 되고, 추가 논의사항이 생길 예정입니다.
 */
@Entity
@Table(
    name = "ts_settlement",
)
class Settlement(
    val reservationCode: String,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
) {
    @Enumerated(EnumType.STRING)
    var reservationPaymentStatus: SampleEnum = SampleEnum.AAA
//        private set

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
//        protected set

    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.now()
//        protected set

    fun updateReservationPaymentStatus(reservationPaymentStatus: SampleEnum) {
        this.reservationPaymentStatus = reservationPaymentStatus
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Settlement

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Settlement(reservationCode='$reservationCode', id=$id, reservationPaymentStatus=$reservationPaymentStatus, createdAt=$createdAt, updatedAt=$updatedAt)"
    }
}
