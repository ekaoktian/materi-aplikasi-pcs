package com.pcs.apptoko.response.login.produk

data class ProdukResponsePost(
    val `data`: DataProduk,
    val message: String,
    val success: Boolean
    )

data class DataProduk (
    val `produk`: Produk
    )