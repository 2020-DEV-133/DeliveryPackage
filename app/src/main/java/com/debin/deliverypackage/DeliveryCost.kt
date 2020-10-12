package com.debin.deliverypackage

import com.debin.deliverypackage.data.ParcelType

data class DeliveryCost(
    val sameDay: Boolean,
    val threeDay: Boolean,
    val parcel: List<ParcelType>,
    val numberOfItems: HashMap<TypesOfParcel, Int>
) {
    private var deliveryCost: Double = 0.0

    fun getDeliveryCost(): Double {
        if (sameDay) {
            if (parcel.isNotEmpty()) {
                if (ParcelType(Parcel.DOCUMENT) in parcel &&
                    ParcelType(Parcel.SMALL_PARCEL) in parcel &&
                    ParcelType(Parcel.LARGE_PARCEL) in parcel) {
                    deliveryCost =
                        DC_LARGE_PARCEL_SAME_DAY * numberOfItems[TypesOfParcel.LARGE_PARCEL]!! +
                                DC_SMALL_PARCEL_SAME_DAY * numberOfItems[TypesOfParcel.SMALL_PARCEL]!! +
                                DC_DOCUMENT_SAME_DAY * numberOfItems[TypesOfParcel.DOCUMENT]!!
                } else if (ParcelType(Parcel.DOCUMENT) in parcel &&
                    ParcelType(Parcel.SMALL_PARCEL) in parcel) {
                    deliveryCost =
                        DC_DOCUMENT_SAME_DAY * numberOfItems[TypesOfParcel.DOCUMENT]!! +
                                DC_SMALL_PARCEL_SAME_DAY * numberOfItems[TypesOfParcel.SMALL_PARCEL]!!
                } else if (ParcelType(Parcel.SMALL_PARCEL) in parcel &&
                    ParcelType(Parcel.LARGE_PARCEL) in parcel) {
                    deliveryCost =
                        DC_LARGE_PARCEL_SAME_DAY * numberOfItems[TypesOfParcel.LARGE_PARCEL]!! +
                                DC_SMALL_PARCEL_SAME_DAY * numberOfItems[TypesOfParcel.SMALL_PARCEL]!!
                } else if (ParcelType(Parcel.DOCUMENT) in parcel &&
                    ParcelType(Parcel.LARGE_PARCEL) in parcel) {
                    deliveryCost =
                        DC_LARGE_PARCEL_SAME_DAY * numberOfItems[TypesOfParcel.LARGE_PARCEL]!! +
                                DC_DOCUMENT_SAME_DAY * numberOfItems[TypesOfParcel.DOCUMENT]!!
                } else if (ParcelType(Parcel.DOCUMENT) in parcel) {
                    deliveryCost =
                        DC_DOCUMENT_SAME_DAY * numberOfItems[TypesOfParcel.DOCUMENT]!!
                } else if (ParcelType(Parcel.SMALL_PARCEL) in parcel) {
                    deliveryCost =
                        DC_SMALL_PARCEL_SAME_DAY * numberOfItems[TypesOfParcel.SMALL_PARCEL]!!
                } else if (ParcelType(Parcel.LARGE_PARCEL) in parcel) {
                    deliveryCost =
                        DC_LARGE_PARCEL_SAME_DAY * numberOfItems[TypesOfParcel.LARGE_PARCEL]!!
                }
            }
        } else if (threeDay) {
            if (parcel.isNotEmpty()) {
                if (ParcelType(Parcel.DOCUMENT) in parcel &&
                    ParcelType(Parcel.SMALL_PARCEL) in parcel &&
                    ParcelType(Parcel.LARGE_PARCEL) in parcel) {
                    deliveryCost =
                        DC_LARGE_PARCEL_THREE_DAY * numberOfItems[TypesOfParcel.LARGE_PARCEL]!! +
                                DC_SMALL_PARCEL_THREE_DAY * numberOfItems[TypesOfParcel.SMALL_PARCEL]!! +
                                DC_DOCUMENT_THREE_DAY * numberOfItems[TypesOfParcel.DOCUMENT]!!
                } else if (ParcelType(Parcel.DOCUMENT) in parcel &&
                    ParcelType(Parcel.SMALL_PARCEL) in parcel) {
                    deliveryCost =
                        DC_DOCUMENT_THREE_DAY * numberOfItems[TypesOfParcel.DOCUMENT]!! +
                                DC_SMALL_PARCEL_THREE_DAY * numberOfItems[TypesOfParcel.SMALL_PARCEL]!!
                } else if (ParcelType(Parcel.SMALL_PARCEL) in parcel &&
                    ParcelType(Parcel.LARGE_PARCEL) in parcel) {
                    deliveryCost =
                        DC_LARGE_PARCEL_THREE_DAY * numberOfItems[TypesOfParcel.LARGE_PARCEL]!! +
                                DC_SMALL_PARCEL_THREE_DAY * numberOfItems[TypesOfParcel.SMALL_PARCEL]!!
                } else if (ParcelType(Parcel.DOCUMENT) in parcel &&
                    ParcelType(Parcel.LARGE_PARCEL) in parcel) {
                    deliveryCost =
                        DC_LARGE_PARCEL_THREE_DAY * numberOfItems[TypesOfParcel.LARGE_PARCEL]!! +
                                DC_DOCUMENT_THREE_DAY * numberOfItems[TypesOfParcel.DOCUMENT]!!
                } else if (ParcelType(Parcel.DOCUMENT) in parcel) {
                    deliveryCost =
                        DC_DOCUMENT_THREE_DAY * numberOfItems[TypesOfParcel.DOCUMENT]!!
                } else if (ParcelType(Parcel.SMALL_PARCEL) in parcel) {
                    deliveryCost =
                        DC_SMALL_PARCEL_THREE_DAY * numberOfItems[TypesOfParcel.SMALL_PARCEL]!!
                } else if (ParcelType(Parcel.LARGE_PARCEL) in parcel) {
                    deliveryCost =
                        DC_LARGE_PARCEL_THREE_DAY * numberOfItems[TypesOfParcel.LARGE_PARCEL]!!
                }
            }
        }
        return deliveryCost
    }

    companion object {
        const val DC_DOCUMENT_SAME_DAY = 4.0
        const val DC_SMALL_PARCEL_SAME_DAY = 7.0
        const val DC_LARGE_PARCEL_SAME_DAY = 9.0
        const val DC_DOCUMENT_THREE_DAY = 1.0
        const val DC_SMALL_PARCEL_THREE_DAY = 2.5
        const val DC_LARGE_PARCEL_THREE_DAY = 3.0
    }
}