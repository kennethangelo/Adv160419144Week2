package id.ac.ubaya.informatika.adv160419144week2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBack.setOnClickListener{
            //MainFragmentDirections -> class generated by safeargs
            //Holds all actions arrow that defined previously on navigation graph
            val action = ResultFragmentDirections.actionMainFragment()
            //To trigger navigation, simply call Navigation obj and navigate method to the action
            Navigation.findNavController(it).navigate(action)
        }
//        if(arguments != null){
        arguments?.let{
            val score = ResultFragmentArgs.fromBundle(requireArguments()).score
            txtScore.text = "Your score is $score"
        }
//        }

    }
}