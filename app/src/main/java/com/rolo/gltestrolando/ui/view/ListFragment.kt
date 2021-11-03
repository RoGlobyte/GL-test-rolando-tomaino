package com.rolo.gltestrolando.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rolo.gltestrolando.data.model.ItemGL
import com.rolo.gltestrolando.databinding.ListFragmentBinding
import com.rolo.gltestrolando.ui.adapter.MainAdapter
import com.rolo.gltestrolando.ui.viewmodel.MainViewModel
import com.rolo.gltestrolando.ui.viewmodel.SharedViewModel
import com.rolo.gltestrolando.utils.Status
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {


    private val mainViewModel: MainViewModel by viewModel()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var mAdapter: MainAdapter
    private lateinit var vBinding: ListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ListFragmentBinding =
            ListFragmentBinding.inflate(inflater, container, false)

        vBinding = binding

        setupUI()
        setupObserver()

        return binding.root
    }


    private fun setupUI() {
        vBinding.rvItems.layoutManager = LinearLayoutManager(context)

        val itemOnClick: (ItemGL) -> Unit = { item ->
            sharedViewModel.select(item)
        }

        mAdapter = MainAdapter(arrayListOf(), itemClickListener = itemOnClick)
        vBinding.rvItems.addItemDecoration(
            DividerItemDecoration(
                vBinding.rvItems.context,
                (vBinding.rvItems.layoutManager as LinearLayoutManager).orientation
            )
        )
        vBinding.rvItems.adapter = mAdapter
    }

    private fun setupObserver() {
        mainViewModel.items.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    vBinding.progressBar.visibility = View.GONE
                    vBinding.txtError.visibility = View.GONE
                    it.data?.let { itemsgl -> renderList(itemsgl) }
                    vBinding.rvItems.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    vBinding.progressBar.visibility = View.VISIBLE
                    vBinding.rvItems.visibility = View.GONE
                    vBinding.txtError.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    vBinding.progressBar.visibility = View.GONE
                    vBinding.txtError.visibility = View.VISIBLE
                    vBinding.txtError.text = it.message
                }
            }
        })
    }

    private fun renderList(users: List<ItemGL>) {
        mAdapter.addData(users)
        mAdapter.notifyDataSetChanged()
    }

}