package com.github.jing332.tts_server_android.service.systts

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech

class CheckVoiceData : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val result = TextToSpeech.Engine.CHECK_VOICE_DATA_PASS
        val returnData = Intent()

        val available: ArrayList<String> = arrayListOf("eng-GBR", "eng-USA", "fra-FRA", "spa-ESP", "deu-DEU", "ita-ITA",
        "kor-KOR", "nld-NLD", "dan-DNK", "fin-FIN", "jpn-JPN", "nor-NOR", "pol-POL", "por-PRT", "por-BRA", "rus-RUS",
        "swe-SWE", "zho-CHN", "zho-HKG", "zho-TWN", "ara-SAU", "hi-IN", "ces-CZE", "ell-GRC", "hun-HUN", "ron-ROU",
        "slk-SVK", "tha-THA", "tur-TUR", "cym-GBR", "isl-ISL", "in-IDN")
        // val available: ArrayList<String> = arrayListOf("zho-CHN")
        val unavailable: ArrayList<String> = arrayListOf()

        returnData.putStringArrayListExtra(TextToSpeech.Engine.EXTRA_AVAILABLE_VOICES, available)
        returnData.putStringArrayListExtra(
            TextToSpeech.Engine.EXTRA_UNAVAILABLE_VOICES,
            unavailable
        )
        setResult(result, returnData)
        finish()
    }
}
