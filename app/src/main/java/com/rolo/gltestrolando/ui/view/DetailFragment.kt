package com.rolo.gltestrolando.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.rolo.gltestrolando.data.model.ItemGL
import com.rolo.gltestrolando.databinding.DetailFragmentBinding
import com.rolo.gltestrolando.ui.viewmodel.SharedViewModel
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var vBinding: DetailFragmentBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DetailFragmentBinding =
            DetailFragmentBinding.inflate(inflater, container, false)

        vBinding = binding

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    private fun setupUI() {
        sharedViewModel._item_selected.observe(viewLifecycleOwner, Observer<ItemGL> { item ->
            vBinding.title.text = item.title
            vBinding.description.text = item.description

            Picasso
                .get()
                .load(item.image)
                .into(vBinding.imageDetail)

        })
    }
}