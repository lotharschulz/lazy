import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale;

fun main(/*args: Array<String>*/) {
    val myLazyString: String by lazy (LazyThreadSafetyMode.SYNCHRONIZED){   //(LazyThreadSafetyMode.PUBLICATION) //(LazyThreadSafetyMode.NONE)
        println("lazy init")
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())
        val formatted = current.format(formatter)

        /*
        SimpleDateFormat("dd MMM yyyy", locale).apply {
            this.timeZone = timeZone
        }.format(calendar.time)
        */
        "Hello"
    }

    println(myLazyString)
    println("----------")
    println(myLazyString)
}