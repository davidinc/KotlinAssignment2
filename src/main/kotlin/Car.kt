/**
 * Car is a sub class of vehicle.
 *
 * The Car constructor receives the common Vehicle properties
 * and it's own number of Doors property
 */

class Car(
    brand: String,
    model: String,
    dailyRate: Double,
    private val numberOfDoors: Int
) : Vehicle(brand, model, dailyRate) {

    init {
        require(numberOfDoors > 0) {
            "Number of doors must be greater than zero."
        }
    }

    /**
     * Overrides the Vehicle description method.
     *
     * This is one example of polymorphism because Car provides
     * its own implementaiton of a Vehicle method.
     */

    override fun description(): String {
        return "${super.description()} - Car with $numberOfDoors doors"
    }
}