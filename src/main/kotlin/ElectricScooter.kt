/**
 * ElectricScooter is another subclass of Vehicle.
 *
 * It inherits the brand, model, and rental price properties
 * from the Vehicle superclass.
 */

class ElectricScooter(
    brand: String,
    model: String,
    dailyRate : Double,
    private val rangeKm: Int
) : Vehicle(brand, model, dailyRate) {

    init {
        require(rangeKm > 0) {
            "Scooter range must be greater than zero."
        }
    }
    /**
     * Provides a description specifically for an electric scooter.
     */
    override fun description(): String {
        return "${super.description()} - Electric scooter with $rangeKm km range"
    }

    /**
     * Overrides the superclass rental calculation.
     *
     * Electric scooters receive a 10% discount when they are
     * rented for seven days or longer.
     */
    override fun calculateRentalCost(days: Int): Double {
        val regularCost = super.calculateRentalCost(days)

        return if (days >= 7) {
            regularCost * 0.90
        } else {
            regularCost
        }
    }
}