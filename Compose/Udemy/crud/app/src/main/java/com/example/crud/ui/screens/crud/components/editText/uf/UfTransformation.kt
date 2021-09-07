package com.example.crud.ui.screens.crud.components.editText.uf

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.util.*

class UfTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString) = ufMask(text)

    private fun ufMask(text: AnnotatedString): TransformedText {
        val trimmed = if (text.text.length >= 2) text.text.substring(0..1) else text.text
        val output = trimmed.uppercase(Locale.ROOT)
        val numberOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int) = if (offset <= 2) offset else 2

            override fun transformedToOriginal(offset: Int) = if (offset > 2) offset - 1 else offset
        }
        return TransformedText(AnnotatedString(output), numberOffsetTranslator)
    }
}