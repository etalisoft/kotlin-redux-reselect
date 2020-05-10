package com.github.etalisoft.kotlin.redux

internal interface DependencySet

internal data class DependencySet1<T1>(val t1: T1) : DependencySet
internal data class DependencySet2<T1, T2>(val t1: T1, val t2: T2) : DependencySet
internal data class DependencySet3<T1, T2, T3>(val t1: T1, val t2: T2, val t3: T3) : DependencySet
internal data class DependencySet4<T1, T2, T3, T4>(val t1: T1, val t2: T2, val t3: T3, val t4: T4) : DependencySet
internal data class DependencySet5<T1, T2, T3, T4, T5>(val t1: T1, val t2: T2, val t3: T3, val t4: T4, val t5: T5) : DependencySet
internal data class DependencySet6<T1, T2, T3, T4, T5, T6>(val t1: T1, val t2: T2, val t3: T3, val t4: T4, val t5: T5, val t6: T6) : DependencySet
internal data class DependencySet7<T1, T2, T3, T4, T5, T6, T7>(val t1: T1, val t2: T2, val t3: T3, val t4: T4, val t5: T5, val t6: T6, val t7: T7) : DependencySet
internal data class DependencySet8<T1, T2, T3, T4, T5, T6, T7, T8>(val t1: T1, val t2: T2, val t3: T3, val t4: T4, val t5: T5, val t6: T6, val t7: T7, val t8: T8) : DependencySet
internal data class DependencySet9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(val t1: T1, val t2: T2, val t3: T3, val t4: T4, val t5: T5, val t6: T6, val t7: T7, val t8: T8, val t9: T9) : DependencySet
