package com.cookietech.airhockey

import android.app.ActivityManager
import android.content.Context
import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class AirHockeyActivity : AppCompatActivity() {
    var glSurfaceView:GLSurfaceView? = null
    var rendererSet = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        glSurfaceView = GLSurfaceView(this)
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager;
        val configurationInfo = activityManager.deviceConfigurationInfo

        val supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000

        if(supportsEs2){
            glSurfaceView?.setEGLContextClientVersion(2);

            glSurfaceView?.setRenderer(AirHockeyRenderer())
            rendererSet = true
        }else{
            Toast.makeText(this,"This device does not support OpenGL ES 2.0.",Toast.LENGTH_LONG).show()
        }


        setContentView(glSurfaceView)

    }


    override fun onPause() {
        super.onPause()
        if(rendererSet){
            glSurfaceView?.onPause()
        }
    }


    override fun onResume() {
        super.onResume()
        if(rendererSet){
            glSurfaceView?.onResume()
        }
    }



}