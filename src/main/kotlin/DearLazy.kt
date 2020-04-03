fun main(/*args: Array<String>*/) {
    val myLazyString: String by lazy {
        println("lazy init")
        "Hello"
    }

    println(myLazyString)
    println("----------")
    println(myLazyString)
}