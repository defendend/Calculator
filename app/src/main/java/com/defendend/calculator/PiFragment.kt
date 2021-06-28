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

class PiFragment : Fragment() {

    private val viewModel: PiViewModel by viewModels()
    private val piTextView: TextView?
        get() = view?.findViewById(R.id.pi_text_view)
    private val pbHorizontal: ProgressBar?
        get() = view?.findViewById(R.id.pb_horizontal)
    private val tvProgressHorizontal: TextView?
        get() = view?.findViewById(R.id.tv_progress_horizontal)
    private val buttonPi: Button?
        get() = view?.findViewById(R.id.button_pi)
    private val piEditText: EditText?
        get() = view?.findViewById(R.id.pi_edit_text)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.pi_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonPi?.setOnClickListener {
            if (viewModel.getCalculateBoolean()) {
                viewModel.setCalculateBoolean(false)
                Snackbar.make(
                    view,
                    SNACK_STRING,
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                getText()
            }
        }
        viewModel.calculateBoolean.observe(viewLifecycleOwner) {
            visibleView(it)
        }
        viewModel.piString.observe(viewLifecycleOwner) {
            piTextView?.text = it
        }
        viewModel.percent.observe(viewLifecycleOwner) {
            pbHorizontal?.secondaryProgress = it
            tvProgressHorizontal?.text = "$it %"
        }
    }

    private fun visibleView(boolean: Boolean) {
        if (boolean) {
            pbHorizontal?.visibility = View.VISIBLE
            tvProgressHorizontal?.visibility = View.VISIBLE
            buttonPi?.text = STOP_STRING
        } else {
            pbHorizontal?.visibility = View.INVISIBLE
            tvProgressHorizontal?.visibility = View.INVISIBLE
            buttonPi?.text = START_STRING
        }
    }

    private fun getText() {
        viewModel.setAccuracyNumber(piEditText?.text.toString())
        viewModel.setCalculateBoolean(true)
        viewModel.piNum()
    }

    companion object {
        private const val START_STRING = "Рассчитать"
        private const val STOP_STRING = "Остановить"
        private const val SNACK_STRING = "Рассчет закончен"
    }
}