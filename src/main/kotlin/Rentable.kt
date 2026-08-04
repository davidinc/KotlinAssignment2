/**
 * The Rentable interface defines the behaviour required
 * for an object that can be rented.
 */
interface Rentable {

    /**
     * Calculates the rental price based on the number of days.
     */
    fun calculateRentalCost(days: Int): Double
}