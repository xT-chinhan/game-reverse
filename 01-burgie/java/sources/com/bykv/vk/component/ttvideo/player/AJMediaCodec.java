package com.bykv.vk.component.ttvideo.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import com.byazt.ca.ho;
import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.utils.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class AJMediaCodec {
    private static final int AV_TRC_ARIB_STD_B67 = 18;
    private static final int AV_TRC_SMPTE2084 = 16;
    private static final int CODEC_ERROR = -10000;
    private static final int CODEC_EXCEPTION_ERROR = -10001;
    private static final int CODEC_ILLEGAL_ARGUMENT = -10003;
    private static final int CODEC_ILLEGAL_STATE = -10002;
    private static final double FIX_VERSION = 0.18041d;
    private static final long INPUT_TIMEOUT_US = 30000;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int NO_VALUE = -1;
    private static final int PIXEL_FORMAT_NV12 = 3;
    private static final int PIXEL_FORMAT_YUV420P = 0;
    private static final String TAG = "aj_media_codec";
    private static final String VENDOR_OPPO_PROPERTY = "persist.sys.aweme.hdsupport";
    private static final String VERSION_PROPERTY = "ro.config.hw_codec_support";
    private MediaCodec.BufferInfo mBufferInfo;
    private Surface mDummySurface;
    private String mExceptionInfo;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private static ArrayList<MediaCodecInfo> mVideoHWDecoderCodecs = new ArrayList<>();
    private static Object mCodecListLock = new Object();
    private static boolean mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mIsInitDetected = false;
    private static boolean mIsByteVC1Blocklist = false;
    private static boolean mNeedByteVC1WorkAround = false;
    private boolean mInputBuffersValid = false;
    private android.media.MediaFormat mOutputMediaFormat = null;

    public boolean MTKByteVC1NeedWorkAround() {
        return mNeedByteVC1WorkAround;
    }

    public static String getProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            return str3;
        } catch (Exception e) {
            return str2;
        } catch (Throwable th) {
            return str2;
        }
    }

    public AJMediaCodec() {
        boolean z = false;
        if (!mIsInitDetected) {
            if (Util.HARDWARE.toLowerCase(Locale.US).startsWith("mt") && Util.SDK_INT < 26) {
                z = true;
            }
            mNeedByteVC1WorkAround = z;
            if (isHisiByteVC1BlockList() || isMtkByteVC1BlockList()) {
                mIsByteVC1Blocklist = true;
            }
        }
        codecNeedsSetOutputSurfaceWorkaround();
        mIsInitDetected = true;
    }

    public String getErrorInfo() {
        return this.mExceptionInfo;
    }

    private boolean isHisiByteVC1BlockList() {
        String property = getProperty("ro.board.platform", null);
        if (Util.SDK_INT == 26 && property != null) {
            if (property.startsWith("kirin960") || property.startsWith("hi3660")) {
                double d = 0.0d;
                try {
                    d = Double.parseDouble(getProperty(VERSION_PROPERTY, "0.0"));
                } catch (NumberFormatException e) {
                }
                if (d < FIX_VERSION) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean supportSetSurface() {
        return !mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    private boolean isMtkByteVC1BlockList() {
        String lowerCase = Util.HARDWARE.toLowerCase(Locale.US);
        return lowerCase.startsWith("mt6763") || lowerCase.startsWith("mt6757") || lowerCase.startsWith("mt6739") || lowerCase.startsWith("mt6750");
    }

    public int vendorOppoHWEnable() {
        if (Util.BARND.equals(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            try {
                return Integer.parseInt(getProperty(VENDOR_OPPO_PROPERTY, "1"));
            } catch (NumberFormatException e) {
            }
        }
        return 1;
    }

    public int createByCodecName(String str) {
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            return -1;
        }
    }

    private static void maybeSetInteger(android.media.MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    private static void maybeSetCsdBuffers(android.media.MediaFormat mediaFormat, ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null) {
            return;
        }
        mediaFormat.setByteBuffer("csd-".concat(String.valueOf(i)), byteBuffer);
    }

    private void createDummySurface() {
        this.mDummySurface = DummySurface.newInstanceV17(false);
    }

    public int configure(int i, int i2, int i3, int i4, int i5, String str, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, Surface surface, boolean z, boolean z2, int i6, int i7, boolean z3, int i8, boolean z4, boolean z5, int i9, int i10) {
        Surface surface2;
        int i11 = i6;
        int i12 = i7;
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString("mime", str);
        maybeSetInteger(mediaFormat, "width", i);
        maybeSetInteger(mediaFormat, "height", i2);
        if (i11 != -1 && i12 != -1) {
            if (i11 <= i) {
                i11 = i;
            }
            maybeSetInteger(mediaFormat, "max-width", i11);
            if (i12 <= i2) {
                i12 = i2;
            }
            maybeSetInteger(mediaFormat, "max-height", i12);
        }
        maybeSetInteger(mediaFormat, MediaFormat.KEY_SAMPLE_RATE, i4);
        maybeSetInteger(mediaFormat, MediaFormat.KEY_CHANNEL_COUNT, i5);
        maybeSetInteger(mediaFormat, "max-input-size", getMaxInputSize(str, i, i2));
        maybeSetCsdBuffers(mediaFormat, byteBuffer, 0);
        maybeSetCsdBuffers(mediaFormat, byteBuffer2, 1);
        maybeSetCsdBuffers(mediaFormat, byteBuffer3, 2);
        if (!z) {
            surface2 = surface;
        } else {
            if (Util.SDK_INT >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i3);
            }
            if ((surface == null || !surface.isValid()) && this.mDummySurface == null && Util.SDK_INT >= 23 && !mDeviceNeedsSetOutputSurfaceWorkaround) {
                createDummySurface();
                surface2 = this.mDummySurface;
            } else {
                surface2 = surface;
            }
            if (surface2 == null) {
                this.mExceptionInfo = "Error: configure with null surface";
                return CODEC_ILLEGAL_ARGUMENT;
            }
        }
        if (Util.SDK_INT >= 23 && z2) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z3) {
            VendorQTI.setupVpp(mediaFormat, i8);
        }
        if (z4) {
            VendorQTI.debugEffect(mediaFormat);
        }
        if (z5) {
            VendorQTI.enableLowLatency(mediaFormat);
        }
        if (i10 > 0 && i9 >= 0) {
            String dolbyCodecs = MediaCodecUtil.getDolbyCodecs(i9, i10);
            Pair<Integer, Integer> dolbyVisionProfileAndLevel = MediaCodecUtil.getDolbyVisionProfileAndLevel(dolbyCodecs, dolbyCodecs.split("\\."));
            if (dolbyVisionProfileAndLevel != null) {
                maybeSetInteger(mediaFormat, "profile", ((Integer) dolbyVisionProfileAndLevel.first).intValue());
            }
        }
        try {
            this.mMediaCodec.configure(mediaFormat, surface2, (MediaCrypto) null, 0);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            if (!(e instanceof IllegalArgumentException)) {
                return -1;
            }
            return CODEC_ILLEGAL_ARGUMENT;
        }
    }

    public int start() {
        try {
            this.mMediaCodec.start();
            this.mInputBuffers = this.mMediaCodec.getInputBuffers();
            if (Util.SDK_INT >= 21) {
                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
            }
            this.mInputBuffersValid = true;
            this.mBufferInfo = new MediaCodec.BufferInfo();
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            return -1;
        }
    }

    public int open(int i, int i2, int i3, String str, String str2, ByteBuffer byteBuffer, Surface surface) {
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
            mediaFormat.setString("mime", str2);
            maybeSetInteger(mediaFormat, "width", i);
            maybeSetInteger(mediaFormat, "height", i2);
            if (byteBuffer != null) {
                mediaFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (surface != null && Util.SDK_INT >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i3);
            }
            try {
                this.mMediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
                try {
                    this.mMediaCodec.start();
                    this.mInputBuffers = this.mMediaCodec.getInputBuffers();
                    this.mInputBuffersValid = true;
                    String.format(Locale.US, "open() input params. width:%d,height:%d", Integer.valueOf(i), Integer.valueOf(i2));
                    return 0;
                } catch (Exception e) {
                    return -1;
                }
            } catch (Exception e2) {
                return -1;
            }
        } catch (Exception e3) {
            return -1;
        }
    }

    public int stop() {
        if (this.mInputBuffersValid) {
            try {
                this.mInputBuffersValid = false;
                this.mMediaCodec.stop();
            } catch (Exception e) {
                return -1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodec(MediaCodec mediaCodec) {
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.release();
            Surface surface = this.mDummySurface;
            if (surface != null) {
                surface.release();
                this.mDummySurface = null;
            }
        } catch (Exception e) {
            if (this.mDummySurface != null) {
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
        } catch (Throwable th) {
            if (this.mDummySurface != null) {
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            throw th;
        }
    }

    public void close() {
        if (this.mMediaCodec != null) {
            stop();
            final MediaCodec mediaCodec = this.mMediaCodec;
            this.mInputBuffers = null;
            this.mOutputBuffers = null;
            this.mMediaCodec = null;
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.player.AJMediaCodec.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AJMediaCodec.this.releaseCodec(mediaCodec);
                    }
                });
            } catch (Throwable th) {
                releaseCodec(mediaCodec);
            }
        }
    }

    private int renderOutputBufferV21(int i, long j) {
        try {
            this.mMediaCodec.releaseOutputBuffer(i, j);
            return 0;
        } catch (Exception e) {
            return CODEC_ERROR;
        }
    }

    public int handleCodecExceptionV21(Exception exc) {
        if (exc instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) exc;
            if (Util.SDK_INT >= 23) {
                codecException.isRecoverable();
                codecException.getErrorCode();
                if (!codecException.isRecoverable() && codecException.getErrorCode() != 1100 && codecException.getErrorCode() != 1101) {
                    return CODEC_EXCEPTION_ERROR;
                }
            } else {
                codecException.isRecoverable();
                if (!codecException.isRecoverable()) {
                    return CODEC_EXCEPTION_ERROR;
                }
            }
        }
        if (exc instanceof IllegalStateException) {
            return CODEC_ILLEGAL_STATE;
        }
        return CODEC_ERROR;
    }

    public int handleCodecException(Exception exc) {
        this.mExceptionInfo = exc.toString();
        if (Util.SDK_INT >= 21) {
            return handleCodecExceptionV21(exc);
        }
        if (exc instanceof IllegalStateException) {
            return CODEC_ILLEGAL_STATE;
        }
        return CODEC_ERROR;
    }

    public int dequeueInputBuffer(long j) {
        try {
            return this.mMediaCodec.dequeueInputBuffer(j);
        } catch (Exception e) {
            return handleCodecException(e);
        }
    }

    public ByteBuffer[] getInputBuffers() {
        if (this.mInputBuffersValid) {
            return this.mInputBuffers;
        }
        return null;
    }

    public int queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        try {
            this.mMediaCodec.queueInputBuffer(i, i2, i3, j, i4);
            return 0;
        } catch (Exception e) {
            return handleCodecException(e);
        }
    }

    public int setOutputSurface(Surface surface) {
        if (!mDeviceNeedsSetOutputSurfaceWorkaround && this.mInputBuffersValid) {
            if (surface == null) {
                if (this.mDummySurface == null) {
                    createDummySurface();
                }
                surface = this.mDummySurface;
            }
            return setOutputSurfaceV23(this.mMediaCodec, surface);
        }
        return -1;
    }

    public int write(AJMediaCodecFrame aJMediaCodecFrame) {
        if (aJMediaCodecFrame == null || aJMediaCodecFrame.data == null) {
            return -1;
        }
        try {
            int iDequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(INPUT_TIMEOUT_US);
            if (iDequeueInputBuffer >= 0) {
                this.mInputBuffers[iDequeueInputBuffer].put(aJMediaCodecFrame.data);
                this.mMediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, aJMediaCodecFrame.size, aJMediaCodecFrame.pts, 0);
                return 0;
            }
            if (iDequeueInputBuffer != -1) {
                return -1;
            }
            return 4;
        } catch (Exception e) {
            ho.hw(TAG, "write meet exception =".concat(String.valueOf(e)));
            return -1;
        }
    }

    public int read(AJMediaCodecFrame aJMediaCodecFrame, long j) {
        while (true) {
            try {
                int iDequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, j);
                if (iDequeueOutputBuffer >= 0) {
                    aJMediaCodecFrame.data = this.mOutputBuffers[iDequeueOutputBuffer];
                    aJMediaCodecFrame.pts = this.mBufferInfo.presentationTimeUs;
                    aJMediaCodecFrame.index = iDequeueOutputBuffer;
                    aJMediaCodecFrame.size = this.mBufferInfo.size;
                    aJMediaCodecFrame.flags = this.mBufferInfo.flags;
                    return 0;
                }
                if (iDequeueOutputBuffer == -3) {
                    try {
                        this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                    } catch (Exception e) {
                        return handleCodecException(e);
                    }
                } else {
                    if (iDequeueOutputBuffer == -2) {
                        try {
                            this.mOutputMediaFormat = this.mMediaCodec.getOutputFormat();
                            if (this.mOutputBuffers == null) {
                                try {
                                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                                } catch (Exception e2) {
                                    return handleCodecException(e2);
                                }
                            }
                            return iDequeueOutputBuffer;
                        } catch (Exception e3) {
                            return handleCodecException(e3);
                        }
                    }
                    if (iDequeueOutputBuffer != -1) {
                        ho.hw(TAG, "error, idx = ".concat(String.valueOf(iDequeueOutputBuffer)));
                    }
                    return -1;
                }
            } catch (Exception e4) {
                return handleCodecException(e4);
            }
        }
    }

    public void flush() {
        try {
            this.mMediaCodec.flush();
        } catch (Exception e) {
        }
    }

    public int releaseBuffer(int i, boolean z, long j) {
        if (Util.SDK_INT >= 21 && z) {
            return renderOutputBufferV21(i, j);
        }
        try {
            this.mMediaCodec.releaseOutputBuffer(i, z);
            return 0;
        } catch (Exception e) {
            return handleCodecException(e);
        }
    }

    public int getFormatWidth() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        try {
            if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                return (this.mOutputMediaFormat.getInteger(KEY_CROP_RIGHT) - this.mOutputMediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
            }
            return this.mOutputMediaFormat.getInteger("width");
        } catch (Exception e) {
            return 0;
        }
    }

    public int getFormatHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        try {
            if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                return (this.mOutputMediaFormat.getInteger(KEY_CROP_BOTTOM) - this.mOutputMediaFormat.getInteger(KEY_CROP_TOP)) + 1;
            }
            return this.mOutputMediaFormat.getInteger("height");
        } catch (Exception e) {
            return 0;
        }
    }

    public int getStride() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        try {
            return mediaFormat.getInteger("stride");
        } catch (Exception e) {
            return 0;
        }
    }

    public int getSliceHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        try {
            return mediaFormat.getInteger("slice-height");
        } catch (Exception e) {
            return 0;
        }
    }

    public int getSampleRate() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        try {
            return mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
        } catch (Exception e) {
            return 0;
        }
    }

    public int getChannelCount() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        try {
            return mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
        } catch (Exception e) {
            return 0;
        }
    }

    public int getColorFormat() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        try {
            switch (mediaFormat.getInteger("color-format")) {
                case 21:
                case 2130706688:
                case 2141391872:
                    return 3;
                default:
                    return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public int getColorTransfer() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        try {
            switch (mediaFormat.getInteger("color-transfer")) {
                case 6:
                    return 16;
                case 7:
                    return 18;
                default:
                    return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public int getOSVerion() {
        return Util.SDK_INT;
    }

    public void speedEnhance(float f) {
        if (this.mMediaCodec != null && this.mInputBuffersValid && Util.SDK_INT >= 23 && f > 30.0f) {
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", f);
            try {
                this.mMediaCodec.setParameters(bundle);
            } catch (Exception e) {
            }
        }
    }

    public void decodeFRC(int i) {
        if (this.mMediaCodec != null && this.mInputBuffersValid && Util.SDK_INT >= 23) {
            Bundle bundle = new Bundle();
            bundle.putInt("vivo.video-dec.dynamic-frc", i);
            try {
                this.mMediaCodec.setParameters(bundle);
            } catch (Exception e) {
            }
        }
    }

    public String getBestCodecName(String str) {
        boolean z;
        String[] supportedTypes;
        AJMediaCodecRank aJMediaCodecRank;
        if (Util.SDK_INT < 16 || TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("video/hevc") && mIsByteVC1Blocklist) {
            String str2 = Util.HARDWARE;
            return null;
        }
        ArrayList<AJMediaCodecRank> arrayList = new ArrayList();
        synchronized (mCodecListLock) {
            try {
                if (mVideoHWDecoderCodecs.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                try {
                    int size = z ? mVideoHWDecoderCodecs.size() : MediaCodecList.getCodecCount();
                    for (int i = 0; i < size && (!z || arrayList.isEmpty()); i++) {
                        MediaCodecInfo codecInfoAt = z ? mVideoHWDecoderCodecs.get(i) : MediaCodecList.getCodecInfoAt(i);
                        String name = codecInfoAt.getName();
                        if (!codecInfoAt.isEncoder() && !name.startsWith("OMX.google") && !name.startsWith("c2.android") && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                            for (String str3 : supportedTypes) {
                                if (!TextUtils.isEmpty(str3)) {
                                    if (!z && str3.startsWith("video/")) {
                                        mVideoHWDecoderCodecs.add(codecInfoAt);
                                    }
                                    if (str3.equalsIgnoreCase(str) && ((name.startsWith("OMX.") || name.startsWith("c2.")) && !name.startsWith("OMX.pv") && !name.startsWith("OMX.ittiam") && !name.contains("ffmpeg") && !name.contains("avcodec") && !name.contains("secure") && ((!name.startsWith("OMX.MTK.") || Util.SDK_INT >= 18) && !codecNeedsFlushWorkaround(name) && (aJMediaCodecRank = AJMediaCodecRank.setupRank(codecInfoAt, str)) != null))) {
                                        aJMediaCodecRank.mMediaCodecInfo.getName();
                                        if ((aJMediaCodecRank.mRank != 40 || Util.SDK_INT >= 21) && aJMediaCodecRank.mRank != 20) {
                                            arrayList.add(aJMediaCodecRank);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    AJMediaCodecRank aJMediaCodecRank2 = (AJMediaCodecRank) arrayList.get(0);
                    for (AJMediaCodecRank aJMediaCodecRank3 : arrayList) {
                        if (aJMediaCodecRank3.mRank > aJMediaCodecRank2.mRank) {
                            aJMediaCodecRank2 = aJMediaCodecRank3;
                        }
                    }
                    return aJMediaCodecRank2.mMediaCodecInfo.getName();
                } catch (Exception e) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0027  */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:40:0x006f A[Catch: all -> 0x0077, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:40:0x006f, B:41:0x0071, B:10:0x0018, B:12:0x001c, B:13:0x0024, B:25:0x0047, B:28:0x004d, B:29:0x0053, B:38:0x006b, B:31:0x0057, B:34:0x0061, B:27:0x004b, B:15:0x0028, B:18:0x0032, B:21:0x003c, B:42:0x0073), top: B:48:0x0003 }] */
    private static boolean codecNeedsSetOutputSurfaceWorkaround() {
        synchronized (AJMediaCodec.class) {
            if (!mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                if (Util.SDK_INT > 27 || !"dangal".equals(Util.DEVICE)) {
                    if (Util.SDK_INT < 27) {
                        switch (Util.DEVICE) {
                            case "deb":
                            case "mido":
                            case "santoni":
                                mDeviceNeedsSetOutputSurfaceWorkaround = true;
                                break;
                        }
                        switch (Util.MODEL) {
                            case "AFTA":
                            case "AFTN":
                                mDeviceNeedsSetOutputSurfaceWorkaround = true;
                                break;
                        }
                    }
                } else {
                    mDeviceNeedsSetOutputSurfaceWorkaround = true;
                }
                mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    private int setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        try {
            mediaCodec.setOutputSurface(surface);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            return -1;
        }
    }

    public static int ceilDivide(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    private static int getMaxInputSize(String str, int i, int i2) {
        int iCeilDivide;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        if (str.equals("video/3gpp") || str.equals("video/mp4v-es")) {
            iCeilDivide = i * i2;
            i3 = 2;
        } else if (str.equals("video/avc")) {
            if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
                return -1;
            }
            iCeilDivide = ceilDivide(i, 16) * ceilDivide(i2, 16) * 16 * 16;
            i3 = 2;
        } else if (str.equals("video/x-vnd.on2.vp8")) {
            iCeilDivide = i * i2;
            i3 = 2;
        } else {
            if (!str.equals("video/hevc") && !str.equals("video/x-vnd.on2.vp9")) {
                return -1;
            }
            iCeilDivide = i * i2;
            i3 = 4;
        }
        return (iCeilDivide * 3) / (i3 * 2);
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        if (Util.SDK_INT >= 18) {
            if (Util.SDK_INT != 18 || (!"OMX.SEC.avc.dec".equals(str) && !"OMX.SEC.avc.dec.secure".equals(str))) {
                if (Util.SDK_INT == 19 && Util.MODEL.startsWith("SM-G800")) {
                    return "OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str);
                }
                return false;
            }
            return true;
        }
        return true;
    }
}
