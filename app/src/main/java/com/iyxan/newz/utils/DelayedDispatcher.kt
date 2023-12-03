package com.iyxan.newz.utils

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

private const val MSG_WHAT = 0xDEADEAD

// didn't think android would have built-in functionality for search things
// i thought i'd need to implement my own search by periodically calling the
// search api as the user writes.
class DelayedDispatcher<O>(
    private val receiver: (Bundle) -> O,
    private val checkForEveryMs: Long,
    lifecycle: Lifecycle? = null
): DefaultLifecycleObserver, Handler(Looper.getMainLooper()) {
    init {
        lifecycle?.addObserver(this)
    }

    override fun handleMessage(msg: Message) {
        if (msg.what == MSG_WHAT && msg.target == this) {
            receiver(msg.data)
        }
    }

    private fun clearMessages() {
        removeMessages(MSG_WHAT)
    }

    fun dispatchNow(msg: Bundle) {
        clearMessages()
        sendMessage(
            Message.obtain(this, MSG_WHAT).apply {
                data = msg
            }
        )
    }

    fun tryDispatch(msg: Bundle) {
        clearMessages()
        sendMessageDelayed(
            Message.obtain(this, MSG_WHAT).apply {
                data = msg
            }, checkForEveryMs
        )
    }

    override fun onStop(owner: LifecycleOwner) {
        clearMessages()
        super.onStop(owner)
    }
}