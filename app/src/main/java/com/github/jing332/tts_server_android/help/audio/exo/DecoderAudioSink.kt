package com.github.jing332.tts_server_android.help.audio.exo

import com.google.android.exoplayer2.Format
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.audio.AudioSink
import com.google.android.exoplayer2.audio.AudioSink.SINK_FORMAT_SUPPORTED_DIRECTLY
import com.google.android.exoplayer2.audio.AudioSink.SINK_FORMAT_SUPPORTED_WITH_TRANSCODING
import com.google.android.exoplayer2.audio.AuxEffectInfo
import java.nio.ByteBuffer

/**
 * 用于接收从 ExoPlayer 解码后的 PCM 数据，而不是播放到 AudioTrack。
 */
class DecoderAudioSink(private val onPcmBuffer: (ByteBuffer) -> Unit) : AudioSink {
    private var timeUs: Long = 0L

    companion object {
        const val TAG = "DecoderAudioSink"
    }

    override fun setListener(listener: AudioSink.Listener) {
    }

    override fun supportsFormat(format: Format): Boolean {
        return format.sampleMimeType == "audio/raw" // 只接收 PCM 格式
    }

    override fun getFormatSupport(format: Format): Int = SINK_FORMAT_SUPPORTED_WITH_TRANSCODING

    override fun getCurrentPositionUs(sourceEnded: Boolean): Long = timeUs

    override fun configure(
        inputFormat: Format,
        specifiedBufferSize: Int,
        outputChannels: IntArray?
    ) {
    }

    override fun play() {
    }

    override fun handleDiscontinuity() {

    }

    override fun handleBuffer(
        buffer: ByteBuffer,
        presentationTimeUs: Long,
        encodedAccessUnitCount: Int
    ): Boolean {
        onPcmBuffer.invoke(buffer)
        timeUs += presentationTimeUs
        return true
    }

    override fun playToEndOfStream() {

    }

    override fun isEnded(): Boolean = true

    override fun hasPendingData(): Boolean = true

    override fun setPlaybackParameters(playbackParameters: PlaybackParameters) {

    }

    override fun getPlaybackParameters(): PlaybackParameters = PlaybackParameters(1f)


    override fun setSkipSilenceEnabled(skipSilenceEnabled: Boolean) {

    }

    override fun getSkipSilenceEnabled(): Boolean = false

    override fun setAudioAttributes(audioAttributes: AudioAttributes) {

    }

    override fun getAudioAttributes(): AudioAttributes? = null

    override fun setAudioSessionId(audioSessionId: Int) {

    }

    override fun setAuxEffectInfo(auxEffectInfo: AuxEffectInfo) {

    }

    override fun enableTunnelingV21() {

    }

    override fun disableTunneling() {

    }

    override fun setVolume(volume: Float) {

    }

    override fun pause() {

    }

    override fun flush() {

    }

    override fun experimentalFlushWithoutAudioTrackRelease() {

    }

    override fun reset() {


    }
}