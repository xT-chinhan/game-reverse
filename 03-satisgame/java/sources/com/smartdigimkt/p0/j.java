package com.smartdigimkt.p0;

import android.media.MediaCodecInfo;
import android.util.SparseIntArray;
import com.smartdigimkt.z0.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public static final SparseIntArray d;
    public static final SparseIntArray e;
    public static final HashMap f;
    public static final a a = new a("OMX.google.raw.decoder", null, null, true, false, false);
    public static final Pattern b = Pattern.compile("^\\D?(\\d+)$");
    public static final HashMap c = new HashMap();
    public static int g = -1;

    public static a a(String str, boolean z) {
        List listUnmodifiableList;
        synchronized (j.class) {
            e eVar = new e(str, z);
            listUnmodifiableList = (List) c.get(eVar);
            if (listUnmodifiableList == null) {
                int i = u.a;
                g iVar = i >= 21 ? new i(z) : new h();
                ArrayList arrayListA = a(eVar, iVar, str);
                if (z && arrayListA.isEmpty() && 21 <= i && i <= 23) {
                    iVar = new h();
                    arrayListA = a(eVar, iVar, str);
                    if (!arrayListA.isEmpty()) {
                        String str2 = ((a) arrayListA.get(0)).a;
                    }
                }
                if ("audio/eac3-joc".equals(str)) {
                    arrayListA.addAll(a(new e("audio/eac3", z), iVar, str));
                }
                if (i < 26) {
                    if (arrayListA.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(((a) arrayListA.get(0)).a)) {
                        for (int i2 = 1; i2 < arrayListA.size(); i2++) {
                            a aVar = (a) arrayListA.get(i2);
                            if ("OMX.google.raw.decoder".equals(aVar.a)) {
                                arrayListA.remove(i2);
                                arrayListA.add(0, aVar);
                                break;
                            }
                        }
                    }
                }
                listUnmodifiableList = Collections.unmodifiableList(arrayListA);
                c.put(eVar, listUnmodifiableList);
            }
        }
        if (listUnmodifiableList.isEmpty()) {
            return null;
        }
        return (a) listUnmodifiableList.get(0);
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap map = new HashMap();
        f = map;
        map.put("L30", 1);
        map.put("L60", 4);
        map.put("L63", 16);
        map.put("L90", 64);
        map.put("L93", 256);
        map.put("L120", 1024);
        map.put("L123", 4096);
        map.put("L150", 16384);
        map.put("L153", 65536);
        map.put("L156", 262144);
        map.put("L180", 1048576);
        map.put("L183", 4194304);
        map.put("L186", 16777216);
        map.put("H30", 2);
        map.put("H60", 8);
        map.put("H63", 32);
        map.put("H90", 128);
        map.put("H93", 512);
        map.put("H120", 2048);
        map.put("H123", 8192);
        map.put("H150", 32768);
        map.put("H153", 131072);
        map.put("H156", 524288);
        map.put("H180", 2097152);
        map.put("H183", 8388608);
        map.put("H186", 33554432);
    }

    public static int a() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        int i;
        if (g == -1) {
            int iMax = 0;
            a aVarA = a("video/avc", false);
            if (aVarA != null) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = aVarA.c;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                int length = codecProfileLevelArr.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i2 = codecProfileLevelArr[iMax].level;
                    if (i2 != 1 && i2 != 2) {
                        switch (i2) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    iMax2 = Math.max(i, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, u.a >= 21 ? 345600 : 172800);
            }
            g = iMax;
        }
        return g;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ed A[Catch: Exception -> 0x0114, TryCatch #4 {Exception -> 0x0114, blocks: (B:3:0x0004, B:5:0x0016, B:7:0x0026, B:9:0x002e, B:48:0x00e7, B:50:0x00ed, B:53:0x00f4), top: B:69:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x00f4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public static ArrayList a(e eVar, g gVar, String str) throws f {
        int i;
        int i2;
        String[] strArr;
        String str2;
        MediaCodecInfo mediaCodecInfo;
        boolean z;
        String str3;
        try {
            ArrayList arrayList = new ArrayList();
            String str4 = eVar.a;
            int iA = gVar.a();
            boolean zB = gVar.b();
            for (int i3 = 0; i3 < iA; i3++) {
                MediaCodecInfo mediaCodecInfoA = gVar.a(i3);
                String name = mediaCodecInfoA.getName();
                if (a(mediaCodecInfoA, name, zB, str)) {
                    String[] supportedTypes = mediaCodecInfoA.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i4 = 0;
                    while (i4 < length) {
                        String str5 = supportedTypes[i4];
                        if (str5.equalsIgnoreCase(str4)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA.getCapabilitiesForType(str5);
                                boolean zA = gVar.a(str4, capabilitiesForType);
                                if (u.a <= 22) {
                                    String str6 = u.d;
                                    if (("ODROID-XU3".equals(str6) || "Nexus 10".equals(str6)) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name))) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                } else {
                                    z = false;
                                }
                                if (!(zB && eVar.b == zA) && (zB || eVar.b)) {
                                    i = i4;
                                    i2 = length;
                                    strArr = supportedTypes;
                                    str3 = name;
                                    mediaCodecInfo = mediaCodecInfoA;
                                    if (!zB && zA) {
                                        str2 = str3;
                                        try {
                                            arrayList.add(new a(str2 + ".secure", str4, capabilitiesForType, false, z, true));
                                            return arrayList;
                                        } catch (Exception e2) {
                                            e = e2;
                                            if (u.a <= 23) {
                                            }
                                            throw e;
                                        }
                                    }
                                    str2 = str3;
                                } else {
                                    try {
                                        i = i4;
                                        i2 = length;
                                        strArr = supportedTypes;
                                        str3 = name;
                                        mediaCodecInfo = mediaCodecInfoA;
                                        try {
                                            arrayList.add(new a(name, str4, capabilitiesForType, false, z, false));
                                            str2 = str3;
                                        } catch (Exception e3) {
                                            e = e3;
                                            str2 = str3;
                                            if (u.a <= 23 || arrayList.isEmpty()) {
                                                throw e;
                                            }
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        i = i4;
                                        i2 = length;
                                        strArr = supportedTypes;
                                        mediaCodecInfo = mediaCodecInfoA;
                                        str2 = name;
                                        if (u.a <= 23) {
                                        }
                                        throw e;
                                    }
                                }
                            } catch (Exception e5) {
                                e = e5;
                                i = i4;
                                i2 = length;
                                strArr = supportedTypes;
                                str2 = name;
                                mediaCodecInfo = mediaCodecInfoA;
                            }
                        } else {
                            i = i4;
                            i2 = length;
                            strArr = supportedTypes;
                            str2 = name;
                            mediaCodecInfo = mediaCodecInfoA;
                        }
                        i4 = i + 1;
                        gVar = gVar;
                        name = str2;
                        mediaCodecInfoA = mediaCodecInfo;
                        length = i2;
                        supportedTypes = strArr;
                    }
                }
            }
            return arrayList;
        } catch (Exception e6) {
            throw new f(e6);
        }
    }

    public static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i = u.a;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = u.b;
            if ("a70".equals(str3) || ("Xiaomi".equals(u.c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = u.b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = u.b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(u.c))) {
            String str6 = u.b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(u.c)) {
            String str7 = u.b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && u.b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }
}
