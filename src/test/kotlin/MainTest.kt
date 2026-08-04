import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {

    /**
     * Tests that the String function removes extra spaces
     * and correctly capitalizes the customer's name.
     */
    @Test
    fun `formatCustomerName formats name correctly`() {
        val result = formatCustomerName("  dAWIT   chERNET  ")

        assertEquals("Dawit Chernet", result)
    }

    /**
     * Tests the normal rental calculation inherited from Vehicle.
     */
    @Test
    fun `car calculates normal rental cost`() {
        val car = Car(
            brand = "Toyota",
            model = "RAV4",
            dailyRate = 50.0,
            numberOfDoors = 5
        )

        assertEquals(150.0, car.calculateRentalCost(3))
    }

    /**
     * Tests the polymorphic rental calculation provided
     * by ElectricScooter.
     */
    @Test
    fun `scooter receives weekly discount`() {
        val scooter = ElectricScooter(
            brand = "Segway",
            model = "Ninebot",
            dailyRate = 20.0,
            rangeKm = 40
        )

        // $20 × 7 days = $140
        // 10% discount = $126
        assertEquals(126.0, scooter.calculateRentalCost(7))
    }
}