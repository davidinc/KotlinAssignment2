/**
 * String function required by the assignment.
 *
 * This function:
 * 1. Removes spaces from the beginning and end.
 * 2. Removes unnecessary spaces between names.
 * 3. Converts every name to title case.
 *
 * Example:
 * "  dAWIT   chERNET  " becomes "Dawit Chernet".
 */
fun formatCustomerName(name: String): String {
    return name
        .trim()
        .split(Regex("\\s+"))
        .filter { it.isNotEmpty() }
        .joinToString(" ") { word ->
            word.lowercase().replaceFirstChar { firstCharacter ->
                firstCharacter.titlecase()
            }
        }
}

/**
 * Formats a Double value as a dollar amount.
 */
fun formatCurrency(amount: Double): String {
    return "$${"%.2f".format(amount)}"
}

/**
 * Main program entry point.
 */
fun main() {
    println("===================================")
    println("        VEHICLE RENTAL SYSTEM")
    println("===================================")

    // Demonstrates the String function implemented in Main.kt.
    val customerName = formatCustomerName("  dAWIT   chERNET  ")

    /*
     * These are the two instances or objects required by the assignment.
     *
     * familyCar is created using the Car constructor.
     * cityScooter is created using the ElectricScooter constructor.
     */
    val familyCar = Car(
        brand = "Toyota",
        model = "RAV4",
        dailyRate = 79.99,
        numberOfDoors = 5
    )

    val cityScooter = ElectricScooter(
        brand = "Segway",
        model = "Ninebot",
        dailyRate = 24.99,
        rangeKm = 40
    )

    /*
     * The list has the superclass type Vehicle, but it contains
     * objects created from two different subclasses.
     *
     * When description() and calculateRentalCost() are called,
     * Kotlin selects the correct overridden subclass method.
     *
     * This demonstrates runtime polymorphism.
     */
    val availableVehicles: List<Vehicle> = listOf(
        familyCar,
        cityScooter
    )

    val rentalDays = 7

    println("Welcome, $customerName!")
    println("Available rental options for $rentalDays days:")
    println()

    availableVehicles.forEach { vehicle ->
        val rentalCost = vehicle.calculateRentalCost(rentalDays)

        println("Vehicle: ${vehicle.description()}")
        println("Rental cost: ${formatCurrency(rentalCost)}")
        println("-----------------------------------")
    }

    println("Thank you for using the Vehicle Rental System.")
}