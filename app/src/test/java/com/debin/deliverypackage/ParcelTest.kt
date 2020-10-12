package com.debin.deliverypackage

import org.junit.Test
import org.junit.Assert.*

class ParcelTest {

    @Test
    fun newParcel_Initiates() {
        val parcel = Parcel(2.00, 2.10, 2.00, 2.88)
        assertEquals(parcel, parcel )
    }

    @Test
    fun getVolume() {
        val parcel = Parcel(2.00, 2.00, 2.00, 2.00)
        println("Parcel volume is : ${parcel.getVolume()}")
        assertEquals(8.0, parcel.getVolume(), 2.0)
    }

    @Test
    fun getParcelType() {
        val parcel = Parcel(2.00, 2.00, 2.00, 2.00)
        assertEquals("0", parcel.getParcelType())
    }

    @Test
    fun getParcelTypeTest2() {
        val parcel = Parcel(1.00, 1.00, 2.00, 2.00)
        println("Parcel volume is : ${parcel.getVolume()}")
        assertEquals(Parcel.DOCUMENT, parcel.getParcelType())
    }

    @Test
    fun getParcelTypeTest3() {
        val parcel = Parcel(2.00, 2.00, 1.50, 2.00)
        println("Parcel volume is : ${parcel.getVolume()}")
        assertEquals(Parcel.SMALL_PARCEL, parcel.getParcelType())
    }

    @Test
    fun getParcelTypeTest4() {
        val parcel = Parcel(2.00, 2.00, 2.00, 2.00)
        println("Parcel volume is : ${parcel.getVolume()}")
        assertEquals(Parcel.LARGE_PARCEL, parcel.getParcelType())
    }
}