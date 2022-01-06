package com.log.eventtimer.presentation.util.composables.textfield

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

private fun defaultValidator(text: String): Boolean = text.isNotEmpty() && text.isNotBlank()

open class TextFieldState(
    private val validator: (String) -> Boolean = ::defaultValidator,
    private val errorFor: (String) -> String = { "" },
    private var pHint: String? = null,
) {
    var isFocusedDirty: Boolean by mutableStateOf(false)
    var isFocused: Boolean by mutableStateOf(false)
    private var displayErrors: Boolean by mutableStateOf(false)

    var text: String by mutableStateOf("")
    var hint: String by mutableStateOf("").apply {
        pHint?.let {
            this.value = it
        }
    }

    fun onFocusChange(focused: Boolean) {
        isFocused = focused
        if (focused) isFocusedDirty = true
    }

    fun enableShowErrors() {
        if (isFocusedDirty) {
            displayErrors = true
        }
    }

    fun showErrors() = !isValid && displayErrors

    open val isValid: Boolean
        get() = validator(text)

    open fun getError(): String {
        return if (showErrors()) {
            errorFor(text)
        } else {
            "Invalid input!"
        }
    }


}


