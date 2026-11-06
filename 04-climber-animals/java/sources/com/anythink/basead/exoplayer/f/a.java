package com.anythink.basead.exoplayer.f;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.k.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final String a = "MediaCodecInfo";
    public static final int b = -1;
    public final String c;
    public final String d;
    public final MediaCodecInfo.CodecCapabilities e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public static a a(String str) {
        return new a(str, null, null, true, false, false);
    }

    private static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return new a(str, str2, codecCapabilities, false, false, false);
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, false, z, z2);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:24:0x0046  */
    /* JADX WARN: Code duplicated, block: B:36:0x005f  */
    private a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        this.c = (String) com.anythink.basead.exoplayer.k.a.a(str);
        this.d = str2;
        this.e = codecCapabilities;
        this.i = z;
        boolean z6 = true;
        if (z2 || codecCapabilities == null) {
            z4 = false;
        } else {
            if (af.a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback")) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        this.f = z4;
        if (codecCapabilities == null) {
            z5 = false;
        } else {
            if (af.a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback")) {
                z5 = true;
            } else {
                z5 = false;
            }
        }
        this.g = z5;
        if (!z3) {
            if (codecCapabilities == null) {
                z6 = false;
            } else {
                if (!(af.a >= 21 && codecCapabilities.isFeatureSupported("secure-playback"))) {
                    z6 = false;
                }
            }
        }
        this.h = z6;
    }

    public final MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.e.profileLevels;
    }

    private int b() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (af.a < 23 || (codecCapabilities = this.e) == null) {
            return -1;
        }
        return codecCapabilities.getMaxSupportedInstances();
    }

    public final boolean b(String str) {
        String strC;
        if (str == null || this.d == null || (strC = o.c(str)) == null) {
            return true;
        }
        if (!this.d.equals(strC)) {
            c("codec.mime " + str + ", " + strC);
            return false;
        }
        Pair<Integer, Integer> pairA = d.a(str);
        if (pairA == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
            if (codecProfileLevel.profile == ((Integer) pairA.first).intValue() && codecProfileLevel.level >= ((Integer) pairA.second).intValue()) {
                return true;
            }
        }
        c("codec.profileLevel, " + str + ", " + strC);
        return false;
    }

    public final boolean a(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("sizeAndRate.vCaps");
            return false;
        }
        if (a(videoCapabilities, i, i2, d)) {
            return true;
        }
        if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
            c("sizeAndRate.support, " + i + "x" + i2 + "x" + d);
            return false;
        }
        Log.d(a, "AssumedSupport [" + ("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d) + "] [" + this.c + ", " + this.d + "] [" + af.e + "]");
        return true;
    }

    public final Point a(int i, int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(af.a(i, widthAlignment) * widthAlignment, af.a(i2, heightAlignment) * heightAlignment);
    }

    public final boolean a(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        c("sampleRate.support, ".concat(String.valueOf(i)));
        return false;
    }

    public final boolean b(int i) {
        int i2;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("channelCount.aCaps");
            return false;
        }
        String str = this.c;
        String str2 = this.d;
        int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
        if (maxInputChannelCount <= 1 && ((af.a < 26 || maxInputChannelCount <= 0) && !o.t.equals(str2) && !o.I.equals(str2) && !o.J.equals(str2) && !o.r.equals(str2) && !o.G.equals(str2) && !o.H.equals(str2) && !o.w.equals(str2) && !o.K.equals(str2) && !o.x.equals(str2) && !o.y.equals(str2) && !o.M.equals(str2))) {
            if (o.z.equals(str2)) {
                i2 = 6;
            } else {
                i2 = o.A.equals(str2) ? 16 : 30;
            }
            Log.w(a, "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i2 + "]");
            maxInputChannelCount = i2;
        }
        if (maxInputChannelCount >= i) {
            return true;
        }
        c("channelCount.support, ".concat(String.valueOf(i)));
        return false;
    }

    private void c(String str) {
        Log.d(a, "NoSupport [" + str + "] [" + this.c + ", " + this.d + "] [" + af.e + "]");
    }

    private void d(String str) {
        Log.d(a, "AssumedSupport [" + str + "] [" + this.c + ", " + this.d + "] [" + af.e + "]");
    }

    private static int a(String str, String str2, int i) {
        int i2;
        if (i > 1 || ((af.a >= 26 && i > 0) || o.t.equals(str2) || o.I.equals(str2) || o.J.equals(str2) || o.r.equals(str2) || o.G.equals(str2) || o.H.equals(str2) || o.w.equals(str2) || o.K.equals(str2) || o.x.equals(str2) || o.y.equals(str2) || o.M.equals(str2))) {
            return i;
        }
        if (o.z.equals(str2)) {
            i2 = 6;
        } else {
            i2 = o.A.equals(str2) ? 16 : 30;
        }
        Log.w(a, "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
        return i2;
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return af.a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return af.a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return af.a >= 21 && codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d == -1.0d || d <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }

    private static int g(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.getMaxSupportedInstances();
    }
}
