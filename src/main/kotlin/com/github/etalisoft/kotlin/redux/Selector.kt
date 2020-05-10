package com.github.etalisoft.kotlin.redux

class Selector<Input, Output> internal constructor(
    private val selectorSet: SelectorSet<Input, Output>,
    private val block: Function<Output>
) : (Input) -> Output {
    private var prevInput: Input? = null
    private var prevDependency: DependencySet? = null
    private var prevOutput: Output? = null

    private fun record(input: Input? = prevInput, dependency: DependencySet? = prevDependency, output: Output? = prevOutput): Output {
        prevInput = input
        prevDependency = dependency
        prevOutput = output
        return output!!
    }

    override operator fun invoke(input: Input): Output {
        if (input === prevInput) return record()
        val dependency = selectorSet.dependency(input)
        return if (dependency == prevDependency) record(input, dependency)
        else record(input, dependency, selectorSet.call(dependency, block))
    }
}
