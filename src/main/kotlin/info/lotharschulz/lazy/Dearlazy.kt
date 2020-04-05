package info.lotharschulz.lazy

class Dearlazy {
    val myLazyString:String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { "hi" }
}

fun main() {
    println(Dearlazy().myLazyString)
}
