package com.smartdigimkt.n3;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {
    public static final char[] a = "0123456789abcdef".toCharArray();

    public static String a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        try {
            StringBuilder sb = new StringBuilder(160);
            sb.append("{\"ini\":\"").append(j);
            sb.append("\",\"pil\":\"").append(j2);
            sb.append("\",\"btb\":\"").append(j3);
            sb.append("\",\"nbd\":\"").append(j4);
            sb.append("\",\"ofr\":\"").append(j5);
            sb.append("\",\"res\":\"").append(j6);
            sb.append("\",\"oth\":\"").append(j7);
            sb.append("\",\"cb\":\"").append(j8);
            sb.append("\",\"total\":\"").append(j9);
            sb.append("\"}");
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(com.smartdigimkt.b3.k kVar) {
        if (kVar == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(256);
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            int i = 0;
            int i2 = 0;
            for (com.smartdigimkt.b3.j jVar : new ArrayList(kVar.l)) {
                if (jVar != null) {
                    String str = jVar.a;
                    if ("img".equals(str) || "minor".equals(str) || "internal".equals(str) || MediaFormat.KEY_VIDEO.equals(str) || "h5zip".equals(str) || "unzip".equals(str)) {
                        if (i2 >= 50) {
                            i++;
                        } else {
                            if (i2 > 0) {
                                sb.append(AbstractJsonLexerKt.COMMA);
                            }
                            a(sb.append("{\"t\":"), jVar.a);
                            sb.append(",\"c\":");
                            a(sb, String.valueOf(Math.max(0L, jVar.b)));
                            if (jVar.c > 0) {
                                sb.append(",\"q\":");
                                a(sb, String.valueOf(jVar.c));
                            }
                            if (jVar.d > 0) {
                                sb.append(",\"s\":");
                                a(sb, String.valueOf(jVar.d));
                            }
                            sb.append(AbstractJsonLexerKt.END_OBJ);
                            i2++;
                        }
                    }
                }
            }
            if (i > 0) {
                if (i2 > 0) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                }
                a(sb.append("{\"t\":"), "trunc");
                sb.append(",\"c\":");
                a(sb, String.valueOf(i));
                sb.append(AbstractJsonLexerKt.END_OBJ);
                i2++;
            }
            if (i2 == 0) {
                return null;
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d  */
    public static String a(com.smartdigimkt.w4.a aVar, com.smartdigimkt.b3.k kVar, boolean z, int i, boolean z2, String str, String str2) {
        long jA;
        long jMax;
        if (aVar != null) {
            try {
                jA = com.smartdigimkt.w4.a.a(aVar.a, aVar.h);
            } catch (Throwable unused) {
                return null;
            }
        } else {
            jA = -1;
        }
        if (aVar != null) {
            long j = aVar.g;
            if (j > 0) {
                long j2 = aVar.a;
                if (j2 > 0) {
                    jMax = Math.max(0L, j - j2);
                } else {
                    jMax = 0;
                }
            } else {
                jMax = 0;
            }
        } else {
            jMax = 0;
        }
        long jA2 = aVar != null ? com.smartdigimkt.w4.a.a(aVar.b, aVar.c) : -1L;
        long jA3 = aVar != null ? com.smartdigimkt.w4.a.a(aVar.d, aVar.f) : -1L;
        long jA4 = aVar != null ? com.smartdigimkt.w4.a.a(aVar.d, aVar.e) : -1L;
        long jA5 = aVar != null ? com.smartdigimkt.w4.a.a(aVar.e, aVar.f) : -1L;
        long jA6 = kVar != null ? com.smartdigimkt.b3.k.a(kVar.a, kVar.c) : -1L;
        long jA7 = kVar != null ? com.smartdigimkt.b3.k.a(kVar.c, kVar.b) : -1L;
        long jB = aVar != null ? aVar.b(jA6, jA7) : 0L;
        StringBuilder sb = new StringBuilder(MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
        sb.append("{\"r\":").append(z ? 1 : 0);
        sb.append(",\"mode\":").append(i);
        if (jA >= 0) {
            sb.append(",\"total\":").append(jA);
        }
        if (jMax > 0) {
            sb.append(",\"init\":").append(jMax);
        }
        if (jA2 >= 0) {
            sb.append(",\"strategy\":").append(jA2);
        }
        if (jA3 >= 0) {
            sb.append(",\"bid\":").append(jA3);
        }
        if (jA4 >= 0) {
            sb.append(",\"tk\":").append(jA4);
        }
        if (jA5 >= 0) {
            sb.append(",\"req\":").append(jA5);
        }
        if (jA6 >= 0) {
            sb.append(",\"od\":").append(jA6);
        }
        if (jA7 >= 0) {
            sb.append(",\"mat\":").append(jA7);
        }
        if (jB > 0) {
            sb.append(",\"gap\":").append(jB);
        }
        if (z2) {
            sb.append(",\"first\":1");
        }
        if (!z) {
            if (str != null) {
                a(sb.append(",\"ec\":"), str);
            }
            if (str2 != null) {
                a(sb.append(",\"em\":"), str2);
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public static String a(com.smartdigimkt.b3.k kVar) {
        if (kVar == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(256);
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            int i = 0;
            int i2 = 0;
            for (com.smartdigimkt.b3.j jVar : new ArrayList(kVar.l)) {
                if (jVar != null) {
                    String str = jVar.a;
                    if ("img".equals(str) || "minor".equals(str) || "internal".equals(str) || MediaFormat.KEY_VIDEO.equals(str) || "h5zip".equals(str) || "unzip".equals(str) || "wbv".equals(str)) {
                        if (i2 >= 50) {
                            i++;
                        } else {
                            if (i2 > 0) {
                                sb.append(AbstractJsonLexerKt.COMMA);
                            }
                            a(sb.append("{\"t\":"), jVar.a);
                            sb.append(",\"c\":").append(Math.max(0L, jVar.b));
                            if (jVar.c > 0) {
                                sb.append(",\"q\":").append(jVar.c);
                            }
                            if (jVar.d > 0) {
                                sb.append(",\"s\":").append(jVar.d);
                            }
                            sb.append(AbstractJsonLexerKt.END_OBJ);
                            i2++;
                        }
                    }
                }
            }
            if (i > 0) {
                if (i2 > 0) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                }
                a(sb.append("{\"t\":"), "trunc");
                sb.append(",\"c\":").append(i);
                sb.append(AbstractJsonLexerKt.END_OBJ);
                i2++;
            }
            if (i2 == 0) {
                return null;
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                sb.append("\\f");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    default:
                        if (cCharAt < ' ') {
                            StringBuilder sbAppend = sb.append("\\u00");
                            char[] cArr = a;
                            sbAppend.append(cArr[(cCharAt >> 4) & 15]).append(cArr[cCharAt & 15]);
                        } else {
                            sb.append(cCharAt);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        sb.append('\"');
    }
}
