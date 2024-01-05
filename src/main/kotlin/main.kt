fun main() {
    val secondsAgo = 172800
    val text = agoToText(secondsAgo)
    println(text)
}

fun agoToText(secondsAgo: Int): String {
    return when {
        secondsAgo in 0..60 -> "был(а) только что"
        secondsAgo in 61..(60 * 60 - 1) -> "был(а) ${minutesAgoText(secondsAgo / 60)} назад"
        secondsAgo in 60 * 60 + 0..24 * (60 * 60 - 1) -> "был(а) ${hoursAgoText(secondsAgo / (60 * 60))} назад"
        secondsAgo in 24 * 60 * 60 + 0..2 * 24 * (60 * 60 - 1) -> "был(а) вчера"
        secondsAgo in 2 * 24 * 60 * 60 + 0..3 * 24 * 60 * 60 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun minutesAgoText(minutes: Int): String {
    return when {
        minutes == 1 || minutes == 11 || minutes == 21 || minutes == 31 || minutes == 41 || minutes == 51 -> "$minutes минуту"
        minutes in 2..4 || minutes in 22..24 || minutes in 32..34 || minutes in 42..44 || minutes in 52..54 -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun hoursAgoText(hours: Int): String {
    return when {
        hours % 10 == 1 && hours % 100 != 11 -> "$hours час"
        hours % 10 in 2..4 && (hours % 100 < 10 || hours % 100 > 20) -> "$hours часа"
        else -> "$hours часов"
    }
}
