package com.azamovhudstc.tradingapp.utils

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.azamovhudstc.tradingapp.R
import kotlin.random.Random

fun createLetterAvatar(context: Context, letter: String, size: Int): Drawable {
    val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)

    // Generate a gradient color based on the letter
    val gradient = generateGradientFromLetter(letter, size)

    // Draw gradient background
    val paint = Paint().apply {
        isAntiAlias = true
        shader = gradient
    }
    canvas.drawCircle(size.toFloat() / 2, size.toFloat() / 2, size.toFloat() / 2, paint)

    val textColor = ContextCompat.getColor(context, R.color.white)
    paint.shader = null // Reset shader for drawing text
    paint.color = textColor
    paint.textSize = (size / 2).toFloat()
    paint.textAlign = Paint.Align.CENTER

    // Draw letter
    val x = canvas.width / 2
    val y = (canvas.height / 2 - (paint.descent() + paint.ascent()) / 2)
    canvas.drawText(letter, x.toFloat(), y, paint)

    return BitmapDrawable(context.resources, bitmap)
}


// Function to generate a color based on the letter
private fun generateGradientFromLetter(letter: String, size: Int): Shader {
    val colors = arrayOf(
        Color.parseColor("#F44336"), // Red
        Color.parseColor("#E91E63"), // Pink
        Color.parseColor("#9C27B0"), // Purple
        Color.parseColor("#673AB7"), // Deep Purple
        Color.parseColor("#3F51B5"), // Indigo
        Color.parseColor("#2196F3"), // Blue
        Color.parseColor("#03A9F4"), // Light Blue
        Color.parseColor("#00BCD4"), // Cyan
        Color.parseColor("#009688"), // Teal
        Color.parseColor("#4CAF50"), // Green
        Color.parseColor("#8BC34A"), // Light Green
        Color.parseColor("#CDDC39"), // Lime
        Color.parseColor("#FFEB3B"), // Yellow
        Color.parseColor("#FFC107"), // Amber
        Color.parseColor("#FF9800"), // Orange
        Color.parseColor("#FF5722")  // Deep Orange
    )

    // Use the first character of the letter to determine the color index
    val charIndex = (letter[0].toInt() + Random(10000).nextInt()) % colors.size

    val startColor = colors[charIndex]
    val endColor = if (charIndex < colors.size - 1) colors[charIndex + 1] else colors[0]

    return LinearGradient(
        0f,
        0f,
        size.toFloat(),
        size.toFloat(),
        startColor,
        endColor,
        Shader.TileMode.CLAMP
    )
}


 fun generateColorFromLetter(letter: String): Int {
    // Choose a base color
    val baseColor = Color.parseColor("#607D8B") // Blue Grey

    // Calculate offsets based on the letter's characters
    val charOffsets = letter.map { it.toInt() }.sum()

    // Apply the offsets to the base color
    val red = (Color.red(baseColor) + charOffsets) % 256
    val green = (Color.green(baseColor) + charOffsets) % 256
    val blue = (Color.blue(baseColor) + charOffsets) % 256

    return Color.rgb(red, green, blue)
}

