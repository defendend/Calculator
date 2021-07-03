package com.defendend.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar

class EFragment : Fragment() {

    private val viewModel: EViewModel by viewModels()

    private val eTextView: TextView?
        get() = view?.findViewById(R.id.e_text_view)
    private val pbHorizontalE: ProgressBar?
        get() = view?.findViewById(R.id.pb_horizontal_e)
    private val tvProgressHorizontalE: TextView?
        get() = view?.findViewById(R.id.tv_progress_horizontal_e)
    private val buttonE: Button?
        get() = view?.findViewById(R.id.button_e)
    private val eEditText: EditText?
        get() = view?.findViewById(R.id.e_edit_text)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.e_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonE?.setOnClickListener {
            if (viewModel.getIsCalculating()) {
                viewModel.setIsCalculating(false)
                Snackbar.make(
                    view,
                    R.string.end,
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                startCalculation()
            }
        }
        viewModel.isCalculating.observe(viewLifecycleOwner) {
            handleCalculation(it)
        }
        viewModel.eString.observe(viewLifecycleOwner) {
            eTextView?.text = it
        }
        viewModel.percent.observe(viewLifecycleOwner) {
            pbHorizontalE?.secondaryProgress = it
            tvProgressHorizontalE?.text =
                context?.getString(R.string.percent_pattern, it.toString())
        }
    }

    private fun handleCalculation(isCalculating: Boolean) {
        if (isCalculating) {
            pbHorizontalE?.visibility = View.VISIBLE
            tvProgressHorizontalE?.visibility = View.VISIBLE
            buttonE?.text = getString(R.string.stop)
        } else {
            pbHorizontalE?.visibility = View.INVISIBLE
            tvProgressHorizontalE?.visibility = View.INVISIBLE
            buttonE?.text = getString(R.string.start)
        }
    }

    private fun startCalculation() {
        viewModel.setAccuracyNumber(eEditText?.text.toString())
        viewModel.setIsCalculating(true)
    }
}
