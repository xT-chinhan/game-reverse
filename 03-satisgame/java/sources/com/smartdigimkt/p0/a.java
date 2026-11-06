package com.smartdigimkt.p0;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.smartdigimkt.z0.u;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final String a;
    public final String b;
    public final MediaCodecInfo.CodecCapabilities c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3) {
        str.getClass();
        this.a = str;
        this.b = str2;
        this.c = codecCapabilities;
        this.g = z;
        boolean z4 = true;
        this.d = !z2 && codecCapabilities != null && u.a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback");
        this.e = codecCapabilities != null && u.a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback");
        if (!z3 && (codecCapabilities == null || u.a < 21 || !codecCapabilities.isFeatureSupported("secure-playback"))) {
            z4 = false;
        }
        this.f = z4;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0090  */
    public final boolean a(String str) {
        String strA;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        Integer numValueOf;
        Integer numValueOf2;
        int i;
        if (str == null || this.b == null) {
            return true;
        }
        ArrayList arrayList = com.smartdigimkt.z0.i.a;
        String strTrim = str.trim();
        Pair pair = null;
        int i2 = 2;
        if (strTrim.startsWith("avc1") || strTrim.startsWith("avc3")) {
            strA = "video/avc";
        } else if (strTrim.startsWith("hev1") || strTrim.startsWith("hvc1")) {
            strA = "video/hevc";
        } else if (strTrim.startsWith("vp9") || strTrim.startsWith("vp09")) {
            strA = "video/x-vnd.on2.vp9";
        } else if (strTrim.startsWith("vp8") || strTrim.startsWith("vp08")) {
            strA = "video/x-vnd.on2.vp8";
        } else if (strTrim.startsWith("mp4a")) {
            if (strTrim.startsWith("mp4a.")) {
                String strSubstring = strTrim.substring(5);
                if (strSubstring.length() >= 2) {
                    try {
                        String strSubstring2 = strSubstring.substring(0, 2);
                        int i3 = u.a;
                        strA = com.smartdigimkt.z0.i.a(Integer.parseInt(strSubstring2 == null ? null : strSubstring2.toUpperCase(Locale.US), 16));
                    } catch (NumberFormatException unused) {
                        strA = null;
                    }
                } else {
                    strA = null;
                }
            } else {
                strA = null;
            }
            if (strA == null) {
                strA = "audio/mp4a-latm";
            }
        } else if (strTrim.startsWith("ac-3") || strTrim.startsWith("dac3")) {
            strA = "audio/ac3";
        } else if (strTrim.startsWith("ec-3") || strTrim.startsWith("dec3")) {
            strA = "audio/eac3";
        } else if (strTrim.startsWith("ec+3")) {
            strA = "audio/eac3-joc";
        } else if (strTrim.startsWith("dtsc") || strTrim.startsWith("dtse")) {
            strA = "audio/vnd.dts";
        } else if (strTrim.startsWith("dtsh") || strTrim.startsWith("dtsl")) {
            strA = "audio/vnd.dts.hd";
        } else if (strTrim.startsWith("opus")) {
            strA = "audio/opus";
        } else if (strTrim.startsWith("vorbis")) {
            strA = "audio/vorbis";
        } else {
            ArrayList arrayList2 = com.smartdigimkt.z0.i.a;
            if (arrayList2.size() > 0) {
                arrayList2.get(0).getClass();
                throw new ClassCastException();
            }
            strA = null;
        }
        if (strA == null) {
            return true;
        }
        if (!this.b.equals(strA)) {
            int i4 = u.a;
            return false;
        }
        a aVar = j.a;
        String[] strArrSplit = str.split("\\.");
        String str2 = strArrSplit[0];
        str2.getClass();
        str2.hashCode();
        switch (str2) {
            case "avc1":
            case "avc2":
                if (strArrSplit.length >= 2) {
                    try {
                        if (strArrSplit[1].length() == 6) {
                            numValueOf = Integer.valueOf(Integer.parseInt(strArrSplit[1].substring(0, 2), 16));
                            numValueOf2 = Integer.valueOf(Integer.parseInt(strArrSplit[1].substring(4), 16));
                        } else if (strArrSplit.length >= 3) {
                            numValueOf = Integer.valueOf(Integer.parseInt(strArrSplit[1]));
                            numValueOf2 = Integer.valueOf(Integer.parseInt(strArrSplit[2]));
                        }
                        int i5 = j.d.get(numValueOf.intValue(), -1);
                        if (i5 != -1 && (i = j.e.get(numValueOf2.intValue(), -1)) != -1) {
                            pair = new Pair(Integer.valueOf(i5), Integer.valueOf(i));
                        }
                    } catch (NumberFormatException unused2) {
                    }
                    break;
                }
                break;
            case "hev1":
            case "hvc1":
                if (strArrSplit.length >= 4) {
                    Matcher matcher = j.b.matcher(strArrSplit[1]);
                    if (matcher.matches()) {
                        String strGroup = matcher.group(1);
                        if ("1".equals(strGroup)) {
                            i2 = 1;
                        } else if ("2".equals(strGroup)) {
                        }
                        Integer num = (Integer) j.f.get(strArrSplit[3]);
                        if (num == null) {
                            matcher.group(1);
                        } else {
                            pair = new Pair(Integer.valueOf(i2), num);
                        }
                    }
                    break;
                }
                break;
        }
        if (pair == null) {
            return true;
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.c;
        if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
            codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == ((Integer) pair.first).intValue() && codecProfileLevel.level >= ((Integer) pair.second).intValue()) {
                return true;
            }
        }
        int i6 = u.a;
        return false;
    }

    public final boolean b(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.c;
        if (codecCapabilities == null) {
            int i2 = u.a;
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            int i3 = u.a;
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        int i4 = u.a;
        return false;
    }

    public final boolean a(int i, int i2, double d) {
        boolean zIsSizeSupported;
        boolean zIsSizeSupported2;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.c;
        if (codecCapabilities == null) {
            int i3 = u.a;
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            int i4 = u.a;
            return false;
        }
        if (d != -1.0d && d > 0.0d) {
            zIsSizeSupported = videoCapabilities.areSizeAndRateSupported(i, i2, d);
        } else {
            zIsSizeSupported = videoCapabilities.isSizeSupported(i, i2);
        }
        if (zIsSizeSupported) {
            return true;
        }
        if (i < i2) {
            if (d != -1.0d && d > 0.0d) {
                zIsSizeSupported2 = videoCapabilities.areSizeAndRateSupported(i2, i, d);
            } else {
                zIsSizeSupported2 = videoCapabilities.isSizeSupported(i2, i);
            }
            if (zIsSizeSupported2) {
                int i5 = u.a;
                return true;
            }
        }
        int i6 = u.a;
        return false;
    }

    public final Point a(int i, int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.c;
        if (codecCapabilities == null) {
            int i3 = u.a;
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            int i4 = u.a;
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i5 = u.a;
        return new Point((((i + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i2 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    public final boolean a(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.c;
        if (codecCapabilities == null) {
            int i2 = u.a;
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            int i3 = u.a;
            return false;
        }
        String str = this.b;
        int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
        if (maxInputChannelCount <= 1 && ((u.a < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str) && !"audio/3gpp".equals(str) && !"audio/amr-wb".equals(str) && !"audio/mp4a-latm".equals(str) && !"audio/vorbis".equals(str) && !"audio/opus".equals(str) && !"audio/raw".equals(str) && !"audio/flac".equals(str) && !"audio/g711-alaw".equals(str) && !"audio/g711-mlaw".equals(str) && !"audio/gsm".equals(str))) {
            if ("audio/ac3".equals(str)) {
                maxInputChannelCount = 6;
            } else {
                maxInputChannelCount = "audio/eac3".equals(str) ? 16 : 30;
            }
        }
        if (maxInputChannelCount >= i) {
            return true;
        }
        int i4 = u.a;
        return false;
    }
}
