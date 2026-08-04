/**
 * Vehicle is the superclass for all types of rental vehicles.
 *
 * The constructor receives the common information required
 * by every vehicle: brand, model, and daily rental rate.
 *
 * The open keyword allows other classes to inherit from Vehicle.
 */
open class Vehicle(
    val brand: String,
    val model: String,
    private val dailyRate: Double
) : Rentable {

    /**
     * The init block validates the constructor information.
     */
    init {
        require(brand.isNotBlank()) {
            "Vehicle brand cannot be empty."
        }

        require(model.isNotBlank()) {
            "Vehicle model cannot be empty."
        }

        require(dailyRate > 0) {
            "Daily rate must be greater than zero."
        }
    }

    /**
     * Returns general information about the vehicle.
     *
     * The method is open so subclasses can override it.
     */
    open fun description(): String {
        return "$brand $model"
    }

    /**
     * Implements the function declared in the Rentable interface.
     */
    override fun calculateRentalCost(days: Int): Double {
        require(days > 0) {
            "Rental days must be greater than zero."
        }

        return dailyRate * days
    }
}