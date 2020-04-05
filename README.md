# Exploration of how Kotlin 1.4 optimizes compilation of **lazy** as delegated property

How Kotlin 1.4 optimizes compilation of **lazy** and how to use it in Kotlin 1.3

### Preconditions
- [kotlin 1.4M1](https://blog.jetbrains.com/kotlin/2020/03/kotlin-1-4-m1-released/) ([how to try](https://kotlinlang.org/eap/configure-build-for-eap.html))
- [kotlin 1.3.X](https://blog.jetbrains.com/kotlin/2020/03/kotlin-1-3-70-released/)
- [gradle 5+](https://docs.gradle.org/5.0/release-notes.html) ([Kotlin DSL](https://docs.gradle.org/5.0/release-notes.html#kotlin-dsl-1.0) is used in [build.gradle.kts](build.gradle.kts))
- [javap](https://manpages.debian.org/testing/openjdk-11-jdk-headless/javap.1.en.html)
- [procyon](https://bitbucket.org/mstrobel/procyon/wiki/Java%20Decompiler)

## Source Code

clean
```bash
./gradlew clean
```

compile
```bash
./gradlew build
```

run
```bash
./gradlew run
```

decompile
```bash
cd build/classes/kotlin/main/info/lotharschulz/lazy && procyon Dearlazy && cd ../../../../../../..
# does return different results than:
# procyon build/classes/kotlin/main/info/lotharschulz/lazy/Dearlazy

# two commands below show the same result
javap -c -p build/classes/kotlin/main/info/lotharschulz/lazy/Dearlazy
cd build/classes/kotlin/main/info/lotharschulz/lazy/ && javap -c -p Dearlazy && cd ../../../../../../..
```

test
```bash
./gradlew test
```

**key commands one liner**
```bash
./gradlew clean test run && cd build/classes/kotlin/main/info/lotharschulz/lazy/ && procyon Dearlazy && cd ../../../../../../..
```

I am happy about your [contributions](CONTRIBUTING.md) :relaxed:.

### Links

- https://youtu.be/MYQWtNG2so8?list=LLaVcONSNkhDcKwqzpYHUajA&t=150
- https://youtu.be/MYQWtNG2so8?list=LLaVcONSNkhDcKwqzpYHUajA&t=177
- https://youtu.be/MYQWtNG2so8?list=LLaVcONSNkhDcKwqzpYHUajA&t=1527

- https://blog.jetbrains.com/kotlin/2019/12/what-to-expect-in-kotlin-1-4-and-beyond/#delegated-properties
    - https://blog.jetbrains.com/kotlin/2019/12/what-to-expect-in-kotlin-1-4-and-beyond/#trailing-commas

- https://javahungry.blogspot.com/2018/12/8-best-java-decompiler-in-2019.html

## Decompiled classes

#### kotlin version 1.4-M1

```bash
$ ./gradlew clean test run && cd build/classes/kotlin/main/info/lotharschulz/lazy/ && procyon Dearlazy && cd ../../../../../../..

> Task :run
hi

BUILD SUCCESSFUL in 2s
3 actionable tasks: 3 executed
// 
// Decompiled by Procyon v0.5.32
// 

package info.lotharschulz.lazy;

import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.LazyThreadSafetyMode;
import org.jetbrains.annotations.NotNull;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(mv = { 1, 4, 0 }, bv = { 1, 0, 3 }, k = 1, xi = 2, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t" }, d2 = { "Linfo/lotharschulz/lazy/Dearlazy;", "", "()V", "myLazyString", "", "getMyLazyString", "()Ljava/lang/String;", "myLazyString$delegate", "Lkotlin/Lazy;", "lazy" })
public final class Dearlazy
{
    @NotNull
    private final Lazy myLazyString$delegate;
    
    @NotNull
    public final String getMyLazyString() {
        return (String)this.myLazyString$delegate.getValue();
    }
    
    public Dearlazy() {
        this.myLazyString$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)Dearlazy$myLazyString.Dearlazy$myLazyString$2.INSTANCE);
    }
}
```


### kotlin version 1.3.70

```bash
$ ./gradlew clean test run && cd build/classes/kotlin/main/info/lotharschulz/lazy/ && procyon Dearlazy && cd ../../../../../../..

> Task :run
hi

BUILD SUCCESSFUL in 18s
3 actionable tasks: 3 executed
// 
// Decompiled by Procyon v0.5.32
// 

package info.lotharschulz.lazy;

import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.LazyThreadSafetyMode;
import org.jetbrains.annotations.NotNull;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(mv = { 1, 1, 16 }, bv = { 1, 0, 3 }, k = 1, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t" }, d2 = { "Linfo/lotharschulz/lazy/Dearlazy;", "", "()V", "myLazyString", "", "getMyLazyString", "()Ljava/lang/String;", "myLazyString$delegate", "Lkotlin/Lazy;", "lazy" })
public final class Dearlazy
{
    @NotNull
    private final Lazy myLazyString$delegate;
    
    @NotNull
    public final String getMyLazyString() {
        return (String)this.myLazyString$delegate.getValue();
    }
    
    public Dearlazy() {
        this.myLazyString$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)Dearlazy$myLazyString.Dearlazy$myLazyString$2.INSTANCE);
    }
}
```

### kotlin version 1.3.61

```bash
$ ./gradlew clean test run && cd build/classes/kotlin/main/info/lotharschulz/lazy/ && procyon Dearlazy && cd ../../../../../../..

> Task :run
hi

BUILD SUCCESSFUL in 2s
3 actionable tasks: 3 executed
// 
// Decompiled by Procyon v0.5.32
// 

package info.lotharschulz.lazy;

import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.reflect.KDeclarationContainer;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import kotlin.Lazy;
import kotlin.reflect.KProperty;
import kotlin.Metadata;

@Metadata(mv = { 1, 1, 16 }, bv = { 1, 0, 3 }, k = 1, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t" }, d2 = { "Linfo/lotharschulz/lazy/Dearlazy;", "", "()V", "myLazyString", "", "getMyLazyString", "()Ljava/lang/String;", "myLazyString$delegate", "Lkotlin/Lazy;", "lazy" })
public final class Dearlazy
{
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    @NotNull
    private final Lazy myLazyString$delegate;
    
    static {
        $$delegatedProperties = new KProperty[] { (KProperty)Reflection.property1((PropertyReference1)new PropertyReference1Impl((KDeclarationContainer)Reflection.getOrCreateKotlinClass((Class)Dearlazy.class), "myLazyString", "getMyLazyString()Ljava/lang/String;")) };
    }
    
    @NotNull
    public final String getMyLazyString() {
        final Lazy myLazyString$delegate = this.myLazyString$delegate;
        final KProperty kProperty = Dearlazy.$$delegatedProperties[0];
        return (String)myLazyString$delegate.getValue();
    }
    
    public Dearlazy() {
        this.myLazyString$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)Dearlazy$myLazyString.Dearlazy$myLazyString$2.INSTANCE);
    }
}

```
