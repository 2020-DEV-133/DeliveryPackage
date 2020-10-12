package com.debin.deliverypackage

data class TotalCost(
    val itemPrice : Double,
    val parcelDeliveryCost : DeliveryCost) {

    private var totalCost = 0.0

    fun totalCost() : Double {
        return itemPrice + parcelDeliveryCost.getDeliveryCost()
    }
}