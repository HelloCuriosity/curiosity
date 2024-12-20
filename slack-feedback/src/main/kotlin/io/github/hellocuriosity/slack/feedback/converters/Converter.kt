package io.github.hellocuriosity.slack.feedback.converters

interface Converter<A, B> {
    fun from(value: A): B

    fun to(value: B): A
}
