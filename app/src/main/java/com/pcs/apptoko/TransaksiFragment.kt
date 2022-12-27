package com.pcs.apptoko

import android.net.DnsResolver.Callback
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pcs.apptoko.api.BaseRetrofit
import com.pcs.apptoko.response.login.cart.Cart
import java.util.concurrent.Callable

class TransaksiFragment : Fragment() {

    private val api by lazy{ BaseRetrofit().endpoint}
    private lateinit var my_cart : ArrayList<Cart>
    private lateinit var total_bayar : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_transaksi, container, false)

        getProduk(view)

        val btnBayar = view.findViewById<Button>(R.id.btnBayar)
        btnBayar.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelableArrayList("MY_CART",my_cart)
            bundle.putString("TOTAL",total_bayar)

            findNavController().navigate(R.id.bayarFragment,bundle)
        }
        return view
    }

    fun getProduk(view:View){
        val token = LoginActivity.sessionManager.getString("TOKEN")

        api.getProduk(token.toString()).enqueue(object: Callback<ProdukResponse> {
            override fun onResponse(
                call: Call<ProdukResponse>
            )  {
                
            }
        }
    }

}