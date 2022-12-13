package com.example.homework_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import com.example.homework_3.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var launcher: ActivityResultLauncher <Intent>? = null

    lateinit var bindingClass: ActivityMainBinding
    var n: Int = Random.nextInt(100) / 2 * 2
    val s: MutableSet<Int> = mutableSetOf()
    val ranArray = s.toIntArray()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val ranArray = result.data?.getIntArrayExtra("key1")
                Log.d("MyLog", "Result from SecondActivity $ranArray")
            }
        }

        while (s.size < n) {
            s.add((0..99).random())
        }



        bindingClass.b1.setOnClickListener {
            bindingClass.tv1.text = s.toString()
        }

        fun onClick (view: View){
            launcher?.launch(Intent(this, SecondActivity:: class.java))
        }

//        private fun openSomeActivityForResult(bundle: Bundle) {
//            val intentEx = Intent(this, SecondActivity::class.java)
//            intent.puttras(bundle)
//            launcher.launch(intent)
//        }
//
//        private fun onActivityResult(result: ActivityResult) {
//            if (result.resultCode == Activity.RESULT_OK) {
//                val intent = result.data
//                intent?.let { resultAction(it) }
//            }
//        }
//
//        private fun resultAction(intent: Intent) {
//            val text = intent.extras?.get(RESULT).toString()
//            appName.text = text
//        }
    }

}
