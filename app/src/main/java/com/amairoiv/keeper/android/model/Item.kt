package com.amairoiv.keeper.android.model

import java.io.Serializable

data class Item(val id: String, val name: String, val placeId: String) : Serializable {
}