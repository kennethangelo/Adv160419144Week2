package id.ac.ubaya.informatika.adv160419144week2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

class MainFragment : Fragment() {

    //Buat array berisi operasi perhitungan
    val operation = arrayOf("+", "-", "/", "x")
    var score = 0
    var pos = Random.nextInt(0,4)
    var opera = operation[pos]
    var number1 = Random.nextInt(0,100)
    var number2 = Random.nextInt(0,100)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        txtQuestion.text = number1.toString() + " " + opera + " " + number2.toString()

        super.onViewCreated(view, savedInstanceState)
        btnStart.setOnClickListener{
            var yourAnswer = editAnswer.text.toString()
            var sysAnswer = when(opera.toString()){
                "+" -> number1 + number2
                "-" -> number1 - number2
                "/" -> number1 / number2
                "x" -> number1 * number2
                else -> "Number cannot be operated."
            }
            Log.d("ans", sysAnswer.toString())
            if (yourAnswer.equals(sysAnswer.toString())){
                score++
                number1 = Random.nextInt(0,100)
                number2 = Random.nextInt(0,100)
                pos = Random.nextInt(0,4)
                opera = operation[pos]

                txtQuestion.text = number1.toString() + " " + opera + " " + number2.toString()
                editAnswer.text?.clear()
            } else {
                //MainFragmentDirections -> class generated by safeargs
                //Holds all actions arrow that defined previously on navigation graph
                val action = MainFragmentDirections.actionGameFragment(score)
                //To trigger navigation, simply call Navigation obj and navigate method to the action
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}