const val OLD: Int = 5
const val KILOMETERS: Int = 100_000
const val MAXIMUM_SPEED: Int = 120
const val AUTOMATIC: Boolean = false

fun carPrice(old: Int = 5, kilometers: Int = 100_000, maximumSpeed: Int = 120, automatic: Boolean = false): String {
    val originalPrice = 20_000

    if (automatic) {
        return "Your car is worth: $${originalPrice + 1_500}"
    } else if (old > 5) {
        return "Your car is worth: $${originalPrice - ((old - 5) * 2_000)}"
    } else if (kilometers > 100_000) {
        val updatedKm = kilometers - 100_000
        val updatedAmount = (updatedKm / 10_000)
        val finalUpdatedAmount = kotlin.math.floor(updatedAmount.toDouble()).toInt()
        return "Your car is worth: $${originalPrice - (finalUpdatedAmount * 2_000)}"
    } else if (maximumSpeed > 120) {
        return "Your car is worth: $${originalPrice + (maximumSpeed - 120) * 100}"
    } else if (maximumSpeed < 120) {
        return "Your car is worth: $${originalPrice - (120 - maximumSpeed) * 100}"
    } else {
        return "Your car is worth: $${originalPrice}"
    }

}

fun update(changedName: String, changedVal: Int) {
    when (changedName) {
        "old" -> {
            val amount = changedVal + 5
            println(carPrice(old = amount))
        }
        "kilometers" -> {
            println(carPrice(kilometers = changedVal))
        }
        "maximumSpeed" -> {
            println(carPrice(maximumSpeed = changedVal))
        }
        "automatic" -> {
            println(carPrice(automatic = true))
        }
        else -> println("Invalid option please check your option and try again")
    }
}

fun difference() {
    val difference = readln()
    when (difference.toInt()) {
        1 -> {
            println("Please in years how many years older is your car from the default of 5 years")
            val new = readln().toInt()
            update("old", new)
        }
        2 -> {
            println("Please enter how many kilometers your car has")
            val new = readln().toInt()
            update("kilometers", new)
        }
        3 -> {
            println("Please enter your car's maximum speed")
            val new = readln().toInt()
            update("maximumSpeed", new)
        }
        4 -> {
            update("automatic", 1)
        }
        5 -> println(carPrice())
        else -> {
            println("Invalid option please check your option and try again")
            difference()
        }
    }
}

fun main() {
    println("Please type the different option your car has from our default values")
    println("""
        1. old
        2. kilometers
        3. maximumSpeed
        4. automatic
        5. none
    """.trimIndent())
    difference()
}
