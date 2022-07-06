package com.gmail.spencerdamon1974.countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmail.spencerdamon1974.countries.data.remote.model.Country
import com.gmail.spencerdamon1974.countries.databinding.ItemCountryListBinding

class CountryAdapter(private val countryList: List<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(private val binding: ItemCountryListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            with(binding) {
                Glide.with(binding.root)
                    .load(country.flags.png)
                    .into(binding.ivFlag)
                tvCountryName.text = country.name.common
                tvOfficialCountryName.text = country.name.official
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countryList[position])
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}