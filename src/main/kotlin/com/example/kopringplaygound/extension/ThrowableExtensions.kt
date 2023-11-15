package com.example.kopringplaygound.extension

/**
 * 예외 처리에 편의 기능을 제공하기 위한 확장 함수 모음
 */
object ThrowableExtensions {

    /**
     * 중첩된 예외 스택에서 가장 근원 예외(root cause)를 찾아 리턴해주는 확장 함수.
     * 같은 일을 하는 유틸리티가 스프링 프레임워크 안에 내장되어 있으나,
     * 스프링 전용 예외 및 패키지 의존성으로부터 분리하기 위해 여기서 별도 구현한다.
     *
     * @return 근원 예외(root cause)
     * @see org.springframework.core.NestedExceptionUtils.getRootCause
     */
    fun Throwable.rootCause(): Throwable {
        var rootCause: Throwable = this

        while (rootCause.cause != null && rootCause.cause != rootCause) {
            rootCause = rootCause.cause!!
        }

        return rootCause
    }

    /**
     * 스택 트레이스에서 애플리케이션 패키지와 관련 있는 부분만 추출해서 보여주는 확장 함수.
     *
     * @param includeCause 콜 스택에서 발생한 예외 클래스들을 볼 것인지 결정 (기본값: 본다.)
     * @param packageName 추출할 패키지명 (기본값: 트립스토어 패키지명, "kr.tripstore")
     * @return 패키지명으로 추출한 스택 트레이스 문자열
     */
    fun Throwable.packageStackTraceToString(
        includeCause: Boolean = true,
        packageName: String = "kr.tripstore",
    ): String = this.stackTraceToString()
        .split("\n")
        .filter { (if (includeCause) !it.startsWith("\t") else false) || it.contains(packageName) }
        .joinToString("\n")
}
