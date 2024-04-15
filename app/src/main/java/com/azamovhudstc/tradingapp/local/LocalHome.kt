package com.azamovhudstc.tradingapp.local

import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.data.DepositeItem
import com.azamovhudstc.tradingapp.data.DiveItem
import com.azamovhudstc.tradingapp.data.MarketItem
import com.azamovhudstc.tradingapp.data.TrendItem

object LocalHome {
    fun localDriveItem(): ArrayList<DiveItem> {
        val list = ArrayList<DiveItem>()

        list.add(DiveItem(R.drawable.invest, "Invest"))
        list.add(DiveItem(R.drawable.card, "Withdrawal"))
        list.add(DiveItem(R.drawable.support, "Support"))
        list.add(DiveItem(R.drawable.document, "Details"))
        list.add(DiveItem(R.drawable.share, "Share"))
        list.add(DiveItem(R.drawable.radio, "News"))
        list.add(DiveItem(R.drawable.team, "Team"))
        list.add(DiveItem(R.drawable.about, "About"))

        return list
    }

    fun loadTrendList(): ArrayList<TrendItem> {
        val list = ArrayList<TrendItem>()
        list.add(TrendItem(R.drawable.meta, "Meta", "$ 213.89", "+4.3 %", "#0070F0"))
        list.add(TrendItem(R.drawable.tesla, "Tesla", "\$ 341.65", "+6.6 %", "#E82126"))
        list.add(TrendItem(R.drawable.nvidia, "Nvidia", "\$ 591.67", "+9.4 %", "#94C11E"))
        list.add(TrendItem(R.drawable.meta, "Meta", "$ 421.89", "+6.3 %", "#FEC107"))
        list.add(TrendItem(R.drawable.tesla, "Tesla", "\$ 341.65", "+6.6 %", "#E82126"))
        list.add(TrendItem(R.drawable.tesla, "Tesla", "\$ 341.65", "+6.6 %", "#E82126"))
        list.add(TrendItem(R.drawable.nvidia, "Nvidia", "\$ 591.67", "+9.4 %", "#94C11E"))
        list.add(TrendItem(R.drawable.meta, "Meta", "$ 421.89", "+6.3 %", "#FEC107"))
        list.add(TrendItem(R.drawable.tesla, "Tesla", "\$ 341.65", "+6.6 %", "#E82126"))
        list.add(TrendItem(R.drawable.nvidia, "Nvidia", "\$ 591.67", "+9.4 %", "#94C11E"))
        list.add(TrendItem(R.drawable.meta, "Meta", "$ 421.89", "+6.3 %", "#FEC107"))
        list.add(TrendItem(R.drawable.tesla, "Tesla", "\$ 341.65", "+6.6 %", "#E82126"))
        list.add(TrendItem(R.drawable.nvidia, "Nvidia", "\$ 591.67", "+9.4 %", "#94C11E"))
        list.add(TrendItem(R.drawable.meta, "Meta", "$ 421.89", "+6.3 %", "#FEC107"))
        return list
    }

    fun loadMarketList(): ArrayList<MarketItem> {
        val list = ArrayList<MarketItem>()
        list.add(
            MarketItem(
                "ETH",
                R.drawable.ethereum,
                "Tether Ethereum",
                "\$ 3,101.52",
                "−44.12 %"
            )
        )
        list.add(
            MarketItem(
                "BIT",
                R.drawable.bitcoin,
                "Tether Bitcoin",
                "\$ 56 348 01",
                "+ 7,34 %"
            )
        )
        list.add(
            MarketItem(
                "USD",
                R.drawable.usd,
                "Tether USD",
                "\$ 76 458 00",
                "+14.12 %"
            )
        )
        list.add(
            MarketItem(
                "BNB",
                R.drawable.bnb,
                "Tether BNB",
                "\$ 56 458 00",
                "-8.12 %"
            )
        )
        list.add(
            MarketItem(
                "DOGE",
                R.drawable.dogecoin,
                "Tether DOGE",
                "\$ 1,939.13",
                "-104.12 %"
            )
        )
        list.add(
            MarketItem(
                "CSM",
                R.drawable.cosmos,
                "Tether CMS",
                "\$ 6 458 00",
                "+34.12 %"
            )
        )
        list.add(
            MarketItem(
                "LUNC",
                R.drawable.crypto,
                "Tether CMS",
                "\$  4 00",
                "-14.12 %"
            )
        )
        list.add(
            MarketItem(
                "BNB",
                R.drawable.bnb,
                "Tether BNB",
                "\$ 56 458 00",
                "-8.12 %"
            )
        )
        list.add(
            MarketItem(
                "DOGE",
                R.drawable.dogecoin,
                "Tether DOGE",
                "\$ 1,939.13",
                "-104.12 %"
            )
        )
        list.add(
            MarketItem(
                "ETH",
                R.drawable.ethereum,
                "Tether Ethereum",
                "\$ 3,101.52",
                "−44.12 %"
            )
        )
        list.add(
            MarketItem(
                "BIT",
                R.drawable.bitcoin,
                "Tether Bitcoin",
                "\$ 56 348 01",
                "+ 7,34 %"
            )
        )
        list.add(
            MarketItem(
                "USD",
                R.drawable.usd,
                "Tether USD",
                "\$ 76 458 00",
                "+14.12 %"
            )
        )
        list.add(
            MarketItem(
                "BNB",
                R.drawable.bnb,
                "Tether BNB",
                "\$ 56 458 00",
                "-8.12 %"
            )
        )
        list.add(
            MarketItem(
                "DOGE",
                R.drawable.dogecoin,
                "Tether DOGE",
                "\$ 1,939.13",
                "-104.12 %"
            )
        )
        list.add(
            MarketItem(
                "CSM",
                R.drawable.cosmos,
                "Tether CMS",
                "\$ 6 458 00",
                "+34.12 %"
            )
        )
        return list
    }
    fun loadDeposite(): ArrayList<DepositeItem> {
        val list = ArrayList<DepositeItem>()
        list.add(DepositeItem("SA;p,",""))
        return list
    }
}