package com.github.etalisoft.kotlin.redux

fun <Input, Output> createSelector(
    block: (Input) -> Output
) = Selector(SelectorSet1 { i: Input -> i }, block)

fun <Input, T1, Output> createSelector(
    selector: (Input) -> T1,
    block: (T1) -> Output
) = Selector(
    SelectorSet1(
        selector
    ),
    block
)

fun <Input, T1, T2, Output> createSelector(
    selector1: (Input) -> T1,
    selector2: (Input) -> T2,
    block: (T1, T2) -> Output
) = Selector(
    SelectorSet2(
        selector1,
        selector2
    ),
    block
)

fun <Input, T1, T2, T3, Output> createSelector(
    selector1: (Input) -> T1,
    selector2: (Input) -> T2,
    selector3: (Input) -> T3,
    block: (T1, T2, T3) -> Output
) = Selector(
    SelectorSet3(
        selector1,
        selector2,
        selector3
    ),
    block
)

fun <Input, T1, T2, T3, T4, Output> createSelector(
    selector1: (Input) -> T1,
    selector2: (Input) -> T2,
    selector3: (Input) -> T3,
    selector4: (Input) -> T4,
    block: (T1, T2, T3, T4) -> Output
) = Selector(
    SelectorSet4(
        selector1,
        selector2,
        selector3,
        selector4
    ),
    block
)

fun <Input, T1, T2, T3, T4, T5, Output> createSelector(
    selector1: (Input) -> T1,
    selector2: (Input) -> T2,
    selector3: (Input) -> T3,
    selector4: (Input) -> T4,
    selector5: (Input) -> T5,
    block: (T1, T2, T3, T4, T5) -> Output
) = Selector(
    SelectorSet5(
        selector1,
        selector2,
        selector3,
        selector4,
        selector5
    ),
    block
)

fun <Input, T1, T2, T3, T4, T5, T6, Output> createSelector(
    selector1: (Input) -> T1,
    selector2: (Input) -> T2,
    selector3: (Input) -> T3,
    selector4: (Input) -> T4,
    selector5: (Input) -> T5,
    selector6: (Input) -> T6,
    block: (T1, T2, T3, T4, T5, T6) -> Output
) = Selector(
    SelectorSet6(
        selector1,
        selector2,
        selector3,
        selector4,
        selector5,
        selector6
    ),
    block
)

fun <Input, T1, T2, T3, T4, T5, T6, T7, Output> createSelector(
    selector1: (Input) -> T1,
    selector2: (Input) -> T2,
    selector3: (Input) -> T3,
    selector4: (Input) -> T4,
    selector5: (Input) -> T5,
    selector6: (Input) -> T6,
    selector7: (Input) -> T7,
    block: (T1, T2, T3, T4, T5, T6, T7) -> Output
) = Selector(
    SelectorSet7(
        selector1,
        selector2,
        selector3,
        selector4,
        selector5,
        selector6,
        selector7
    ),
    block
)

fun <Input, T1, T2, T3, T4, T5, T6, T7, T8, Output> createSelector(
    selector1: (Input) -> T1,
    selector2: (Input) -> T2,
    selector3: (Input) -> T3,
    selector4: (Input) -> T4,
    selector5: (Input) -> T5,
    selector6: (Input) -> T6,
    selector7: (Input) -> T7,
    selector8: (Input) -> T8,
    block: (T1, T2, T3, T4, T5, T6, T7, T8) -> Output
) = Selector(
    SelectorSet8(
        selector1,
        selector2,
        selector3,
        selector4,
        selector5,
        selector6,
        selector7,
        selector8
    ),
    block
)

fun <Input, T1, T2, T3, T4, T5, T6, T7, T8, T9, Output> createSelector(
    selector1: (Input) -> T1,
    selector2: (Input) -> T2,
    selector3: (Input) -> T3,
    selector4: (Input) -> T4,
    selector5: (Input) -> T5,
    selector6: (Input) -> T6,
    selector7: (Input) -> T7,
    selector8: (Input) -> T8,
    selector9: (Input) -> T9,
    block: (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> Output
) = Selector(
    SelectorSet9(
        selector1,
        selector2,
        selector3,
        selector4,
        selector5,
        selector6,
        selector7,
        selector8,
        selector9
    ),
    block
)
