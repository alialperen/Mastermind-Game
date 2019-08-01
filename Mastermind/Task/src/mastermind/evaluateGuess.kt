package mastermind

import kotlin.math.min


data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rp = 0
    val secretCharCount = IntArray(26)
    val guessCharCount = IntArray(26)
    (0 until secret.length).forEach { i ->
        val s = secret[i]
        val g = guess[i]
        ++secretCharCount[s.toInt() - 'A'.toInt()]
        ++guessCharCount[g.toInt() - 'A'.toInt()]
        if (s == g) ++rp
    }

    val w = (0 until secretCharCount.size).sumBy { min(secretCharCount[it], guessCharCount[it]) }

    return Evaluation(rp, w - rp)
}


