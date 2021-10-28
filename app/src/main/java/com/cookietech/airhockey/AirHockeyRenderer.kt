package com.cookietech.airhockey

import android.opengl.GLES20.*
import android.opengl.GLSurfaceView
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10


//open gl pipeline -
// Read vertex data -> Execute vertex shader -> assemble primitives -> rasterize primitives -> Execute fragment shader -> write to frame buffer -> see it on the screen


const val POSITION_COMPONENT_COUNT = 2
const val BYTES_PER_FLOAT = 4
//Float has 32 bits of precision so 4 bytes = 32 bit
class AirHockeyRenderer : GLSurfaceView.Renderer {
    val vertexData: FloatBuffer


    init {
        val tableVerticesWithTriangles = floatArrayOf(
            0f,0f,
            9f,14f,
            0f,14f,

            0f,0f,
            9f,0f,
            9f,14f
        )

        vertexData = ByteBuffer.allocateDirect(tableVerticesWithTriangles.size * BYTES_PER_FLOAT).order(
            ByteOrder.nativeOrder()).asFloatBuffer()

        vertexData.put(tableVerticesWithTriangles)
    }


    override fun onSurfaceCreated(p0: GL10?, p1: EGLConfig?) {
        //Surface is created, called multiple time (first run, resuming )

        glClearColor(1.0f,0.0f,0.0f,0.0f)

    }

    override fun onSurfaceChanged(p0: GL10?, width: Int, height: Int) {
        //the view port size
        glViewport(0,0,width,height)

    }

    override fun onDrawFrame(p0: GL10?) {
        //clearing the surface

        glClear(GL_COLOR_BUFFER_BIT)
    }



}
