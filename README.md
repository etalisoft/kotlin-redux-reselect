# Kotlin-Redux-Reselect

> A Reselect implementation for Kotlin

Simple "selector" library for Redux (and others) based on [Reselect](https://github.com/reduxjs/reselect).

- Selectors can compute derived data, allowing Redux to store the minimal possible state.
- Selectors are efficient. A selector is not recomputed unless one of its arguments changes.
- Selectors are composable. They can be used as input to other selectors.

```kotlin
data class Person(val name: Name, val age: Int)
data class Name(val first: String, val last: String)

val selectName = createSelector<Person, Name> { it.name }
val selectAge = createSelector<Person, Int> { it.age }
val selectFirstName = createSelector(selectName) { it.first }
val selectLastName = createSelector(selectName) { it.last }
val selectInfo = createSelector(selectFirstName, selectLastName, selectAge) { 
    first, last, age -> "$first $last is $age"
}

val exampleState = Person(Name("Bob", "Smith"), 42)

println(selectInfo(exampleState)) // Bob Smith is 42
```
