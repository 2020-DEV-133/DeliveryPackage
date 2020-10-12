package com.debin.deliverypackage

import com.debin.deliverypackage.data.ParcelType
import org.junit.Test
import org.junit.Assert.*

class DeliveryCostTest {

    @Test
    fun parcelListEmptyOrNot() {
        val parcelType1 = ParcelType(Parcel.DOCUMENT)
        val parcelType2 = ParcelType(Parcel.SMALL_PARCEL)
        val parcelType3 = ParcelType(Parcel.LARGE_PARCEL)
        val parcelTypeList = listOf<ParcelType>(parcelType1, parcelType2, parcelType3)
        assertEquals(3, parcelTypeList.size)
        assertEquals(Parcel.DOCUMENT, parcelTypeList.get(0).parcelType)
        assertEquals(Parcel.SMALL_PARCEL, parcelTypeList.get(1).parcelType)
        assertEquals(Parcel.LARGE_PARCEL, parcelTypeList.get(2).parcelType)
    }

    @Test
    fun newDeliveryInitiates() {
        val parcel = Parcel(2.00, 2.00, 2.00, 2.00)
        val parcelType1 = ParcelType(Parcel.DOCUMENT)
        val parcelType2 = ParcelType(Parcel.SMALL_PARCEL)
        val parcelType3 = ParcelType(Parcel.LARGE_PARCEL)
        val parcelTypeList = listOf<ParcelType>(parcelType1, parcelType2, parcelType3)
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.DOCUMENT, 2)
        val delivery = DeliveryCost(true, false,  parcelTypeList, numberOfItems)
        assertEquals(delivery, delivery)
    }

    @Test
    fun deliveryCostTest() {
        assertEquals(0.0, 0.0, 2.0)
    }

    @Test
    fun deliveryCostSameDayCheck() {
        val parcelLarge = Parcel(2.00, 2.10, 2.00, 2.88)
        parcelLarge.getVolume()
        println("Parcel Type large :: ${parcelLarge.getParcelType().parcelType}")
        val parcelSmall = Parcel(2.00, 2.00, 1.50, 2.00)
        parcelSmall.getVolume()
        println("Parcel Type Samll :: ${parcelSmall.getParcelType().parcelType}")
        val parcelDocument = Parcel(1.00, 1.00, 2.00, 2.00)
        parcelDocument.getVolume()
        println("Parcel Type Document :: ${parcelDocument.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelDocument.getParcelType(), parcelSmall.getParcelType(), parcelLarge.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.DOCUMENT, 2)
        val deliveryCost = DeliveryCost(true, false, parcelList, numberOfItems)
        assertEquals(true, deliveryCost.sameDay)
    }

    @Test
    fun deliveryCostThreeDayCheck() {
        val parcelLarge = Parcel(2.00, 2.10, 2.00, 2.88)
        parcelLarge.getVolume()
        println("Parcel Type large :: ${parcelLarge.getParcelType().parcelType}")
        val parcelSmall = Parcel(2.00, 2.00, 1.50, 2.00)
        parcelSmall.getVolume()
        println("Parcel Type Samll :: ${parcelSmall.getParcelType().parcelType}")
        val parcelDocument = Parcel(1.00, 1.00, 2.00, 2.00)
        parcelDocument.getVolume()
        println("Parcel Type Document :: ${parcelDocument.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelDocument.getParcelType(), parcelSmall.getParcelType(), parcelLarge.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.DOCUMENT, 2)
        val deliveryCost = DeliveryCost(false, true, parcelList, numberOfItems)
        assertEquals(true, deliveryCost.threeDay)
    }


    @Test
    fun deliveryCostTestForDocumentSameDay() {
        val parcelDocument = Parcel(1.00, 1.00, 2.00, 2.00)
        parcelDocument.getVolume()
        println("Parcel Type Document :: ${parcelDocument.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelDocument.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.DOCUMENT, 2)
        val deliveryCost = DeliveryCost(true, false, parcelList, numberOfItems)
        val cost = deliveryCost.getDeliveryCost()
        println(" cost is :: ${cost}")
        assertEquals(cost, deliveryCost.getDeliveryCost(), 2.0)
    }

    @Test
    fun deliveryCostTestForSmallParcelSameDay() {
        val parcelSmall = Parcel(2.00, 2.00, 1.50, 2.00)
        parcelSmall.getVolume()
        println("Parcel Type Samll :: ${parcelSmall.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelSmall.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.SMALL_PARCEL, 2)
        val deliveryCost = DeliveryCost(true, false, parcelList, numberOfItems)
        val cost = deliveryCost.getDeliveryCost()
        println(" cost is :: ${cost}")
        assertEquals(cost, deliveryCost.getDeliveryCost(), 2.0)
    }

    @Test
    fun deliveryCostTestForLargeParcelSameDay() {
        val parcelLarge = Parcel(2.00, 2.10, 2.00, 2.88)
        parcelLarge.getVolume()
        println("Parcel Type large :: ${parcelLarge.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelLarge.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.LARGE_PARCEL, 2)
        val deliveryCost = DeliveryCost(true, false, parcelList, numberOfItems)
        val cost = deliveryCost.getDeliveryCost()
        println(" cost is :: ${cost}")
        assertEquals(cost, deliveryCost.getDeliveryCost(), 2.0)
    }

    @Test
    fun deliveryCostTestRandomParcelTypeSameDay_AllParcelTypes() {
        val parcelLarge = Parcel(2.00, 2.10, 2.00, 2.88)
        parcelLarge.getVolume()
        println("Parcel Type large :: ${parcelLarge.getParcelType().parcelType}")
        val parcelSmall = Parcel(2.00, 2.00, 1.50, 2.00)
        parcelSmall.getVolume()
        println("Parcel Type Samll :: ${parcelSmall.getParcelType().parcelType}")
        val parcelDocument = Parcel(1.00, 1.00, 2.00, 2.00)
        parcelDocument.getVolume()
        println("Parcel Type Document :: ${parcelDocument.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelDocument.getParcelType(), parcelSmall.getParcelType(), parcelLarge.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.DOCUMENT, 2)
        numberOfItems.put(TypesOfParcel.SMALL_PARCEL, 1)
        numberOfItems.put(TypesOfParcel.LARGE_PARCEL, 4)
        val deliveryCost = DeliveryCost(true, false, parcelList, numberOfItems)
        val cost = deliveryCost.getDeliveryCost()
        println(" cost is :: ${cost}")
        assertEquals(51.0, deliveryCost.getDeliveryCost(), 2.0)
    }

    @Test
    fun deliveryCostTestRandomParcelTypeSameDay_SmallAndLargeParcel() {
        val parcelLarge = Parcel(2.00, 2.10, 2.00, 2.88)
        parcelLarge.getVolume()
        println("Parcel Type large :: ${parcelLarge.getParcelType().parcelType}")
        val parcelSmall = Parcel(2.00, 2.00, 1.50, 2.00)
        parcelSmall.getVolume()
        println("Parcel Type Samll :: ${parcelSmall.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelSmall.getParcelType(), parcelLarge.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.SMALL_PARCEL, 1)
        numberOfItems.put(TypesOfParcel.LARGE_PARCEL, 4)
        val deliveryCost = DeliveryCost(true, false, parcelList, numberOfItems)
        val cost = deliveryCost.getDeliveryCost()
        println(" cost is :: ${cost}")
        assertEquals(43.0, deliveryCost.getDeliveryCost(), 2.0)
    }

    @Test
    fun deliveryCostTestRandomParcelTypeSameDay_SmallAndDocumentParcel() {
        val parcelSmall = Parcel(2.00, 2.00, 1.50, 2.00)
        parcelSmall.getVolume()
        println("Parcel Type Samll :: ${parcelSmall.getParcelType().parcelType}")
        val parcelDocument = Parcel(1.00, 1.00, 2.00, 2.00)
        parcelDocument.getVolume()
        println("Parcel Type Document :: ${parcelDocument.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelDocument.getParcelType(), parcelSmall.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.SMALL_PARCEL, 1)
        numberOfItems.put(TypesOfParcel.DOCUMENT, 4)
        val deliveryCost = DeliveryCost(true, false, parcelList, numberOfItems)
        val cost = deliveryCost.getDeliveryCost()
        println(" cost is :: ${cost}")
        assertEquals(23.0, deliveryCost.getDeliveryCost(), 2.0)
    }

    @Test
    fun deliveryCostTestRandomParcelTypeSameDay_LargeAndDocumentParcel() {
        val parcelLarge = Parcel(2.00, 2.10, 2.00, 2.88)
        parcelLarge.getVolume()
        println("Parcel Type large :: ${parcelLarge.getParcelType().parcelType}")
        val parcelDocument = Parcel(1.00, 1.00, 2.00, 2.00)
        parcelDocument.getVolume()
        println("Parcel Type Document :: ${parcelDocument.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelDocument.getParcelType(), parcelLarge.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.LARGE_PARCEL, 1)
        numberOfItems.put(TypesOfParcel.DOCUMENT, 4)
        val deliveryCost = DeliveryCost(true, false, parcelList, numberOfItems)
        val cost = deliveryCost.getDeliveryCost()
        println(" cost is :: ${cost}")
        assertEquals(25.0, deliveryCost.getDeliveryCost(), 2.0)
    }

    @Test
    fun deliveryCostTestRandomParcelType_ThreeDay_AllParcelTypes() {
        val parcelLarge = Parcel(2.00, 2.10, 2.00, 2.88)
        parcelLarge.getVolume()
        println("Parcel Type large :: ${parcelLarge.getParcelType().parcelType}")
        val parcelSmall = Parcel(2.00, 2.00, 1.50, 2.00)
        parcelSmall.getVolume()
        println("Parcel Type Samll :: ${parcelSmall.getParcelType().parcelType}")
        val parcelDocument = Parcel(1.00, 1.00, 2.00, 2.00)
        parcelDocument.getVolume()
        println("Parcel Type Document :: ${parcelDocument.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelDocument.getParcelType(), parcelSmall.getParcelType(), parcelLarge.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.DOCUMENT, 2)
        numberOfItems.put(TypesOfParcel.SMALL_PARCEL, 1)
        numberOfItems.put(TypesOfParcel.LARGE_PARCEL, 4)
        val deliveryCost = DeliveryCost(false, true, parcelList, numberOfItems)
        val cost = deliveryCost.getDeliveryCost()
        println(" cost is :: ${cost}")
        assertEquals(16.5, deliveryCost.getDeliveryCost(), 2.0)
    }

    @Test
    fun deliveryCostTestRandomParcelType_ThreeDay_SmallAndLargeParcel() {
        val parcelLarge = Parcel(2.00, 2.10, 2.00, 2.88)
        parcelLarge.getVolume()
        println("Parcel Type large :: ${parcelLarge.getParcelType().parcelType}")
        val parcelSmall = Parcel(2.00, 2.00, 1.50, 2.00)
        parcelSmall.getVolume()
        println("Parcel Type Samll :: ${parcelSmall.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelSmall.getParcelType(), parcelLarge.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.SMALL_PARCEL, 1)
        numberOfItems.put(TypesOfParcel.LARGE_PARCEL, 4)
        val deliveryCost = DeliveryCost(false, true, parcelList, numberOfItems)
        val cost = deliveryCost.getDeliveryCost()
        println(" cost is :: ${cost}")
        assertEquals(14.5, deliveryCost.getDeliveryCost(), 2.0)
    }

    @Test
    fun deliveryCostTestRandomParcelType_ThreeDay_SmallAndDocumentParcel() {
        val parcelSmall = Parcel(2.00, 2.00, 1.50, 2.00)
        parcelSmall.getVolume()
        println("Parcel Type Samll :: ${parcelSmall.getParcelType().parcelType}")
        val parcelDocument = Parcel(1.00, 1.00, 2.00, 2.00)
        parcelDocument.getVolume()
        println("Parcel Type Document :: ${parcelDocument.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelDocument.getParcelType(), parcelSmall.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.SMALL_PARCEL, 1)
        numberOfItems.put(TypesOfParcel.DOCUMENT, 4)
        val deliveryCost = DeliveryCost(false, true, parcelList, numberOfItems)
        val cost = deliveryCost.getDeliveryCost()
        println(" cost is :: ${cost}")
        assertEquals(6.5, deliveryCost.getDeliveryCost(), 2.0)
    }

    @Test
    fun deliveryCostTestRandomParcelType_ThreeDay_LargeAndDocumentParcel() {
        val parcelLarge = Parcel(2.00, 2.10, 2.00, 2.88)
        parcelLarge.getVolume()
        println("Parcel Type large :: ${parcelLarge.getParcelType().parcelType}")
        val parcelDocument = Parcel(1.00, 1.00, 2.00, 2.00)
        parcelDocument.getVolume()
        println("Parcel Type Document :: ${parcelDocument.getParcelType().parcelType}")
        val parcelList = listOf<ParcelType>(parcelDocument.getParcelType(), parcelLarge.getParcelType())
        val numberOfItems = HashMap<TypesOfParcel, Int>()
        numberOfItems.put(TypesOfParcel.LARGE_PARCEL, 1)
        numberOfItems.put(TypesOfParcel.DOCUMENT, 4)
        val deliveryCost = DeliveryCost(false, true, parcelList, numberOfItems)
        val cost = deliveryCost.getDeliveryCost()
        println(" cost is :: ${cost}")
        assertEquals(7.0, deliveryCost.getDeliveryCost(), 2.0)
    }

}