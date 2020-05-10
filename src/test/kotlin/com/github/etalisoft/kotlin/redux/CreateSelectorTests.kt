package com.github.etalisoft.kotlin.redux

import assertk.assertThat
import assertk.assertions.*
import org.junit.jupiter.api.*

data class State(val person: Person)
data class Person(val name: Name, val age: Int)
data class Name(val first: String, val last: String)

class CreateSelectorTests {
    lateinit var state: State

    @BeforeEach
    fun beforeEach() {
        state = State(
            person = Person(
                name = Name(
                    first = "Bob",
                    last = "Smith"
                ),
                age = 42
            )
        )
    }

    @Test
    fun `should memoize`() {
        val calls = mutableListOf<String>()
        fun <T> spy(call: String, block: () -> T) = block().also { calls.add(call) }
        val selectPerson = createSelector<State, Person> { spy("selectPerson") { it.person } }
        val selectName = createSelector(selectPerson) { spy("selectName") { it.name } }
        val selectFirst = createSelector(selectName) { spy("selectFirst") { it.first } }
        val selectLast = createSelector(selectName) { spy("selectLast") { it.last } }
        val selectFullName = createSelector(selectFirst, selectLast) { first, last -> spy("selectFullName") { "$first $last" } }
        val selectAge = createSelector(selectPerson) { spy("selectAge") { it.age } }
        val selectInfo = createSelector(selectFullName, selectAge) { fullName, age -> "$fullName is $age" }
        assertThat(selectInfo(state)).isEqualTo("Bob Smith is 42")
        assertThat(calls).isEqualTo(listOf("selectPerson", "selectName", "selectFirst", "selectLast", "selectFullName", "selectAge"))

        calls.clear()
        assertThat(selectInfo(state)).isEqualTo("Bob Smith is 42")
        assertThat(calls).isEqualTo(emptyList<String>())
    }

    @Test
    fun `should memoize deep`() {
        val calls = mutableListOf<String>()
        fun <T> spy(call: String, block: () -> T) = block().also { calls.add(call) }
        val selectPerson = createSelector<State, Person> { spy("selectPerson") { it.person } }
        val selectName = createSelector(selectPerson) { spy("selectName") { it.name } }
        val selectFirst = createSelector(selectName) { spy("selectFirst") { it.first } }
        val selectLast = createSelector(selectName) { spy("selectLast") { it.last } }
        val selectFullName = createSelector(selectFirst, selectLast) { first, last -> spy("selectFullName") { "$first $last" } }
        val selectAge = createSelector(selectPerson) { spy("selectAge") { it.age } }
        val selectInfo = createSelector(selectFullName, selectAge) { fullName, age -> "$fullName is $age" }
        assertThat(selectInfo(state)).isEqualTo("Bob Smith is 42")
        assertThat(calls).isEqualTo(listOf("selectPerson", "selectName", "selectFirst", "selectLast", "selectFullName", "selectAge"))

        calls.clear()
        state = State(Person(state.person.name, 43))
        assertThat(selectInfo(state)).isEqualTo("Bob Smith is 43")
        assertThat(calls).isEqualTo(listOf("selectPerson", "selectName", "selectAge"))
    }

    @Test
    fun `should work with 0 selectors`() {
        val selectFirstName = createSelector<State, String> { it.person.name.first }
        assertThat(selectFirstName(state)).isEqualTo("Bob")
    }

    @Test
    fun `should work with 1 selector`() {
        val selectName: (State) -> Name = { it.person.name }
        val selectFirst = createSelector(selectName) { it.first }
        assertThat(selectFirst(state)).isEqualTo("Bob")
    }

    @Test
    fun `should work with 2 selectors`() {
        val selectAge = createSelector<State, Int> { it.person.age }
        val s = (1..2).map { n -> createSelector(selectAge) { it * n } }
        val expected = (1..2).map { it * state.person.age }.toList()
        val select = createSelector(s[0], s[1]) { n0, n1 -> listOf(n0, n1) }
        assertThat(select(state)).isEqualTo(expected)
    }

    @Test
    fun `should work with 3 selectors`() {
        val selectAge = createSelector<State, Int> { it.person.age }
        val s = (1..3).map { n -> createSelector(selectAge) { it * n } }
        val expected = (1..3).map { it * state.person.age }.toList()
        val select = createSelector(s[0], s[1], s[2]) { n0, n1, n2 -> listOf(n0, n1, n2) }
        assertThat(select(state)).isEqualTo(expected)
    }

    @Test
    fun `should work with 4 selectors`() {
        val selectAge = createSelector<State, Int> { it.person.age }
        val s = (1..4).map { n -> createSelector(selectAge) { it * n } }
        val expected = (1..4).map { it * state.person.age }.toList()
        val select = createSelector(s[0], s[1], s[2], s[3]) { n0, n1, n2, n3 -> listOf(n0, n1, n2, n3) }
        assertThat(select(state)).isEqualTo(expected)
    }

    @Test
    fun `should work with 5 selectors`() {
        val selectAge = createSelector<State, Int> { it.person.age }
        val s = (1..5).map { n -> createSelector(selectAge) { it * n } }
        val expected = (1..5).map { it * state.person.age }.toList()
        val select = createSelector(s[0], s[1], s[2], s[3], s[4]) { n0, n1, n2, n3, n4 -> listOf(n0, n1, n2, n3, n4) }
        assertThat(select(state)).isEqualTo(expected)
    }

    @Test
    fun `should work with 6 selectors`() {
        val selectAge = createSelector<State, Int> { it.person.age }
        val s = (1..6).map { n -> createSelector(selectAge) { it * n } }
        val expected = (1..6).map { it * state.person.age }.toList()
        val select = createSelector(s[0], s[1], s[2], s[3], s[4], s[5]) { n0, n1, n2, n3, n4, n5 -> listOf(n0, n1, n2, n3, n4, n5) }
        assertThat(select(state)).isEqualTo(expected)
    }

    @Test
    fun `should work with 7 selectors`() {
        val selectAge = createSelector<State, Int> { it.person.age }
        val s = (1..7).map { n -> createSelector(selectAge) { it * n } }
        val expected = (1..7).map { it * state.person.age }.toList()
        val select = createSelector(s[0], s[1], s[2], s[3], s[4], s[5], s[6]) { n0, n1, n2, n3, n4, n5, n6 -> listOf(n0, n1, n2, n3, n4, n5, n6) }
        assertThat(select(state)).isEqualTo(expected)
    }

    @Test
    fun `should work with 8 selectors`() {
        val selectAge = createSelector<State, Int> { it.person.age }
        val s = (1..8).map { n -> createSelector(selectAge) { it * n } }
        val expected = (1..8).map { it * state.person.age }.toList()
        val select = createSelector(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]) { n0, n1, n2, n3, n4, n5, n6, n7 -> listOf(n0, n1, n2, n3, n4, n5, n6, n7) }
        assertThat(select(state)).isEqualTo(expected)
    }

    @Test
    fun `should work with 9 selectors`() {
        val selectAge = createSelector<State, Int> { it.person.age }
        val s = (1..9).map { n -> createSelector(selectAge) { it * n } }
        val expected = (1..9).map { it * state.person.age }.toList()
        val select = createSelector(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8]) { n0, n1, n2, n3, n4, n5, n6, n7, n8 -> listOf(n0, n1, n2, n3, n4, n5, n6, n7, n8) }
        assertThat(select(state)).isEqualTo(expected)
    }
}
