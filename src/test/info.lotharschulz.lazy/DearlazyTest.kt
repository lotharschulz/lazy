package lazy

import kotlin.test.Test
import kotlin.test.assertNotNull

class DearlazyTest {
    @Test fun testAppHasAGreeting() {
        assertNotNull(Dearlazy().myLazyString, "app should have a greeting")
    }
}
