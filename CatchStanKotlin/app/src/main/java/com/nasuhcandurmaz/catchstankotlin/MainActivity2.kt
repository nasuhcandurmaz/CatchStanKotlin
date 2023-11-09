package com.nasuhcandurmaz.catchstankotlin

import android.content.DialogInterface
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.nasuhcandurmaz.catchstankotlin.databinding.ActivityMain2Binding
import kotlinx.coroutines.Runnable
import kotlin.random.Random as Random

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding



    var imageArray = ArrayList<ImageView>()
    var runnable: Runnable = Runnable{}
    var handler : Handler = Handler(Looper.getMainLooper())
    var score = 0







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        imageArray.add(binding.imageView10)
        imageArray.add(binding.imageView11)
        imageArray.add(binding.imageView12)
        imageArray.add(binding.imageView13)
        hideImages()




        object : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                binding.textView.text = "Time: ${p0 / 1000}"
            }

            override fun onFinish() {
                binding.textView.text = "Time: 0"

                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }



                val alert = AlertDialog.Builder(this@MainActivity2)

                alert.setTitle("Back to Main Menu")
                alert.setMessage("Are you sure?")
                alert.setCancelable(false)
                alert.setPositiveButton("Yes", object : DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        intent = Intent(this@MainActivity2,MainActivity::class.java)
                        startActivity(intent)
                    }


                })

                alert.setNegativeButton("No") {dialog, which ->
                    val intent = intent
                    finish()
                    dialog.dismiss()
                    startActivity(intent)
                }

                alert.show()



                handler.removeCallbacks(runnable)
            }


        }.start()


        }

    fun hideImages() {

        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = java.util.Random()
                val randomIndex = random.nextInt(12)
                imageArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }

        handler.post(runnable)

    }

    fun onc1(view: View){
        score = score + 1
        binding.scoreText.text = "Score: ${score}"
    }




    }



