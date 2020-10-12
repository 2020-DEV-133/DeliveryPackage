package com.debin.deliverypackage

import com.debin.deliverypackage.data.ParcelType
import org.junit.Test
import org.junit.Assert.*

class TotalCostTest {
    @Test
    fun totalCostInitiates() {
        val parcelLarge = Parcel(2.00, 2.10, 2.00, 2.88)
        parcelLarge.getVolume()
        val parcelList = listOf<ParcelType>(parcelLarge.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.LARGE_PARCEL, 2)
        val deliveryCost = DeliveryCost(true, false, parcelList, numberOfItems)
        val totalCost = TotalCost(20.0, deliveryCost)
        assertEquals(totalCost, totalCost)
    }
    @Test
    fun totalCostTest() {
        val parcelLarge = Parcel(2.00, 2.10, 2.00, 2.88)
        parcelLarge.getVolume()
        val parcelList = listOf<ParcelType>(parcelLarge.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.LARGE_PARCEL, 2)
        val deliveryCost = DeliveryCost(true, false, parcelList, numberOfItems)
        val totalCost = TotalCost(200.0, deliveryCost)
        println("Delivery Cost :: ${deliveryCost.getDeliveryCost()}")
        assertEquals(218.0, totalCost.totalCost(), 2.0)
    }
}