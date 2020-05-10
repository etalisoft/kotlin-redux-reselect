@file:Suppress("UNCHECKED_CAST")

package com.github.etalisoft.kotlin.redux

internal interface SelectorSet<Input, Output> {
    fun dependency(input: Input): DependencySet
    fun call(dependency: DependencySet, block: Function<Output>): Output
}

internal data class SelectorSet1<Input, T1, Output>(
    val sel1: (Input) -> T1
) : SelectorSet<Input, Output> {
    override fun dependency(input: Input) = DependencySet1(
        sel1(input)
    )
    override fun call(dependency: DependencySet, block: Function<Output>): Output {
        val d = dependency as DependencySet1<T1>
        val f = block as (T1) -> Output
        return f(d.t1)
    }
}

internal data class SelectorSet2<Input, T1, T2, Output>(
    val sel1: (Input) -> T1,
    val sel2: (Input) -> T2
) : SelectorSet<Input, Output> {
    override fun dependency(input: Input) = DependencySet2(
        sel1(input),
        sel2(input)
    )
    override fun call(dependency: DependencySet, block: Function<Output>): Output {
        val d = dependency as DependencySet2<T1, T2>
        val f = block as (T1, T2) -> Output
        return f(d.t1, d.t2)
    }
}

internal data class SelectorSet3<Input, T1, T2, T3, Output>(
    val sel1: (Input) -> T1,
    val sel2: (Input) -> T2,
    val sel3: (Input) -> T3
) : SelectorSet<Input, Output> {
    override fun dependency(input: Input) = DependencySet3(
        sel1(input),
        sel2(input),
        sel3(input)
    )
    override fun call(dependency: DependencySet, block: Function<Output>): Output {
        val d = dependency as DependencySet3<T1, T2, T3>
        val f = block as (T1, T2, T3) -> Output
        return f(d.t1, d.t2, d.t3)
    }
}

internal data class SelectorSet4<Input, T1, T2, T3, T4, Output>(
    val sel1: (Input) -> T1,
    val sel2: (Input) -> T2,
    val sel3: (Input) -> T3,
    val sel4: (Input) -> T4
) : SelectorSet<Input, Output> {
    override fun dependency(input: Input) = DependencySet4(
        sel1(input),
        sel2(input),
        sel3(input),
        sel4(input)
    )
    override fun call(dependency: DependencySet, block: Function<Output>): Output {
        val d = dependency as DependencySet4<T1, T2, T3, T4>
        val f = block as (T1, T2, T3, T4) -> Output
        return f(d.t1, d.t2, d.t3, d.t4)
    }
}

internal data class SelectorSet5<Input, T1, T2, T3, T4, T5, Output>(
    val sel1: (Input) -> T1,
    val sel2: (Input) -> T2,
    val sel3: (Input) -> T3,
    val sel4: (Input) -> T4,
    val sel5: (Input) -> T5
) : SelectorSet<Input, Output> {
    override fun dependency(input: Input) = DependencySet5(
        sel1(input),
        sel2(input),
        sel3(input),
        sel4(input),
        sel5(input)
    )
    override fun call(dependency: DependencySet, block: Function<Output>): Output {
        val d = dependency as DependencySet5<T1, T2, T3, T4, T5>
        val f = block as (T1, T2, T3, T4, T5) -> Output
        return f(d.t1, d.t2, d.t3, d.t4, d.t5)
    }
}

internal data class SelectorSet6<Input, T1, T2, T3, T4, T5, T6, Output>(
    val sel1: (Input) -> T1,
    val sel2: (Input) -> T2,
    val sel3: (Input) -> T3,
    val sel4: (Input) -> T4,
    val sel5: (Input) -> T5,
    val sel6: (Input) -> T6
) : SelectorSet<Input, Output> {
    override fun dependency(input: Input) = DependencySet6(
        sel1(input),
        sel2(input),
        sel3(input),
        sel4(input),
        sel5(input),
        sel6(input)
    )
    override fun call(dependency: DependencySet, block: Function<Output>): Output {
        val d = dependency as DependencySet6<T1, T2, T3, T4, T5, T6>
        val f = block as (T1, T2, T3, T4, T5, T6) -> Output
        return f(d.t1, d.t2, d.t3, d.t4, d.t5, d.t6)
    }
}

internal data class SelectorSet7<Input, T1, T2, T3, T4, T5, T6, T7, Output>(
    val sel1: (Input) -> T1,
    val sel2: (Input) -> T2,
    val sel3: (Input) -> T3,
    val sel4: (Input) -> T4,
    val sel5: (Input) -> T5,
    val sel6: (Input) -> T6,
    val sel7: (Input) -> T7
) : SelectorSet<Input, Output> {
    override fun dependency(input: Input) = DependencySet7(
        sel1(input),
        sel2(input),
        sel3(input),
        sel4(input),
        sel5(input),
        sel6(input),
        sel7(input)
    )
    override fun call(dependency: DependencySet, block: Function<Output>): Output {
        val d = dependency as DependencySet7<T1, T2, T3, T4, T5, T6, T7>
        val f = block as (T1, T2, T3, T4, T5, T6, T7) -> Output
        return f(d.t1, d.t2, d.t3, d.t4, d.t5, d.t6, d.t7)
    }
}

internal data class SelectorSet8<Input, T1, T2, T3, T4, T5, T6, T7, T8, Output>(
    val sel1: (Input) -> T1,
    val sel2: (Input) -> T2,
    val sel3: (Input) -> T3,
    val sel4: (Input) -> T4,
    val sel5: (Input) -> T5,
    val sel6: (Input) -> T6,
    val sel7: (Input) -> T7,
    val sel8: (Input) -> T8
) : SelectorSet<Input, Output> {
    override fun dependency(input: Input) = DependencySet8(
        sel1(input),
        sel2(input),
        sel3(input),
        sel4(input),
        sel5(input),
        sel6(input),
        sel7(input),
        sel8(input)
    )
    override fun call(dependency: DependencySet, block: Function<Output>): Output {
        val d = dependency as DependencySet8<T1, T2, T3, T4, T5, T6, T7, T8>
        val f = block as (T1, T2, T3, T4, T5, T6, T7, T8) -> Output
        return f(d.t1, d.t2, d.t3, d.t4, d.t5, d.t6, d.t7, d.t8)
    }
}

internal data class SelectorSet9<Input, T1, T2, T3, T4, T5, T6, T7, T8, T9, Output>(
    val sel1: (Input) -> T1,
    val sel2: (Input) -> T2,
    val sel3: (Input) -> T3,
    val sel4: (Input) -> T4,
    val sel5: (Input) -> T5,
    val sel6: (Input) -> T6,
    val sel7: (Input) -> T7,
    val sel8: (Input) -> T8,
    val sel9: (Input) -> T9
) : SelectorSet<Input, Output> {
    override fun dependency(input: Input) = DependencySet9(
        sel1(input),
        sel2(input),
        sel3(input),
        sel4(input),
        sel5(input),
        sel6(input),
        sel7(input),
        sel8(input),
        sel9(input)
    )
    override fun call(dependency: DependencySet, block: Function<Output>): Output {
        val d = dependency as DependencySet9<T1, T2, T3, T4, T5, T6, T7, T8, T9>
        val f = block as (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> Output
        return f(d.t1, d.t2, d.t3, d.t4, d.t5, d.t6, d.t7, d.t8, d.t9)
    }
}
