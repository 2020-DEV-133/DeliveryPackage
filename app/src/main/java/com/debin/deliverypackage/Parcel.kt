package com.debin.deliverypackage

import com.debin.deliverypackage.data.ParcelType

data class Parcel(
    val mWidth : Double,
    val mHeight : Double,
    val mDepth : Double,
    val mWeight : Double
) {

    var mVolume : Double = 0.0
    fun getVolume() : Double {
        mVolume = mWeight * mHeight * mDepth
        return mVolume
    }

    fun getParcelType() : ParcelType {
            if(mVolume <= 4.0) {
                return ParcelType(Parcel.DOCUMENT)
            } else if(!(mVolume <= 4.0 || mVolume >= 8.0)){
                return ParcelType(Parcel.SMALL_PARCEL)
            } else {
                return ParcelType(Parcel.LARGE_PARCEL)
            }
    }

    companion object {
        const val DOCUMENT = "DOCUMENT"
        const val SMALL_PARCEL = "SMALL PARCEL"
        const val LARGE_PARCEL = "LARGE PARCEL"
    }



}