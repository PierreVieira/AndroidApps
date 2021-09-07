package com.example.crud.ui.screens.crud.components.editText.cep

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CepTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString) = cepMaskFilter(text)

    private fun cepMaskFilter(text: AnnotatedString): TransformedText {

        // NNNNN-NNN
        val trimmed = if (text.text.length >= 8) text.text.substring(0..7) else text.text
        var output = ""
        for (i in trimmed.indices) {
            output += trimmed[i]
            if (i == 4) output += "-"
        }
        val numberOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= 4) return offset
                if (offset <= 8) return offset + 1
                return 9

            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 5) return offset
                if (offset <= 9) return offset - 1
                return 8
            }
        }
        return TransformedText(AnnotatedString(output), numberOffsetTranslator)
    }
}