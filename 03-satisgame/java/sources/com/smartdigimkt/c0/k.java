package com.smartdigimkt.c0;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.h0.m;
import com.smartdigimkt.h0.n;
import com.smartdigimkt.r4.o;
import com.smartdigimkt.sdk.core.SDKContext;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static String a(com.smartdigimkt.f0.g gVar, String str, String str2) {
        HashMap map;
        com.smartdigimkt.f0.f fVar;
        if (gVar == null || (map = gVar.a) == null || (fVar = (com.smartdigimkt.f0.f) map.get(str)) == null) {
            return str2;
        }
        int i = fVar.b;
        if (i != 2) {
            return i != 3 ? fVar.a : Matcher.quoteReplacement(fVar.c);
        }
        return "";
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("__C_SLD__") || str.contains("__C_DOWN_X__") || str.contains("__RE_C_DOWN_X__") || str.contains("__C_DOWN_Y__") || str.contains("__RE_C_DOWN_Y__") || str.contains("__C_UP_X__") || str.contains("__RE_C_UP_X__") || str.contains("__C_UP_Y__") || str.contains("__RE_C_UP_Y__") || str.contains("__C_DOWN_X_DT__") || str.contains("__RE_C_DOWN_X_DT__") || str.contains("__C_DOWN_Y_DT__") || str.contains("__RE_C_DOWN_Y_DT__") || str.contains("__C_UP_X_DT__") || str.contains("__RE_C_UP_X_DT__") || str.contains("__C_UP_Y_DT__") || str.contains("__RE_C_UP_Y_DT__");
    }

    public static String a(String str, String str2, String str3, LinkedHashMap linkedHashMap) {
        if (str3 == null) {
            str3 = "";
        }
        if (linkedHashMap != null && str.contains(str2)) {
            linkedHashMap.put(str2, str3);
        }
        return str.replaceAll(Pattern.quote(str2), Matcher.quoteReplacement(str3));
    }

    public static String a(String str, m mVar, long j, com.smartdigimkt.b3.c cVar, boolean z, LinkedHashMap linkedHashMap) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (mVar != null && mVar.p) {
            return str;
        }
        if (mVar.g != null) {
            str = a(str, mVar, cVar, z, linkedHashMap);
        }
        n nVar = mVar.h;
        if (nVar != null) {
            str = a(a(a(a(a(a(a(a(a(a(a(str, "{__VIDEO_TIME__}", nVar.a + "", linkedHashMap), "{__BEGIN_TIME__}", nVar.b + "", linkedHashMap), "{__END_TIME__}", nVar.c + "", linkedHashMap), "{__PLAY_FIRST_FRAME__}", j.a(new StringBuilder(), nVar.d, ""), linkedHashMap), "{__PLAY_LAST_FRAME__}", j.a(new StringBuilder(), nVar.e, ""), linkedHashMap), "{__SCENE__}", j.a(new StringBuilder(), nVar.h, ""), linkedHashMap), "{__TYPE__}", j.a(new StringBuilder(), nVar.i, ""), linkedHashMap), "{__BEHAVIOR__}", j.a(new StringBuilder(), nVar.j, ""), linkedHashMap), "{__STATUS__}", j.a(new StringBuilder(), nVar.k, ""), linkedHashMap), "{__PLAY_SEC__}", (nVar.f / 1000) + "", linkedHashMap), "{__PLAY_MSEC__}", nVar.f + "", linkedHashMap);
        }
        com.smartdigimkt.h0.b bVar = mVar.i;
        if (bVar != null) {
            String str2 = bVar.a;
            if (str2 == null) {
                str2 = "";
            }
            str = a(str, "{__CLICK_ID__}", str2, linkedHashMap);
            int i = bVar.b;
            if (i > 0) {
                str = a(str, "__DP_APP_INSTALL__", String.valueOf(i), linkedHashMap);
            }
        }
        HashMap map = mVar.o;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    String string = entry.getValue().toString();
                    if (linkedHashMap != null && str.contains(str3)) {
                        linkedHashMap.put(str3, string);
                    }
                    str = str.replaceAll(Pattern.quote(str3), Matcher.quoteReplacement(string));
                } catch (Throwable th) {
                    th.getMessage();
                    th.printStackTrace();
                }
            }
        }
        long j2 = j / 1000;
        String strA = a(a(a(a(a(a(a(str, "{__REQ_WIDTH__}", "__REQ_WIDTH__", linkedHashMap), "{__REQ_HEIGHT__}", "__REQ_HEIGHT__", linkedHashMap), "__WIDTH__", j.a(new StringBuilder(), mVar.e, ""), linkedHashMap), "__HEIGHT__", j.a(new StringBuilder(), mVar.f, ""), linkedHashMap), "{__PLAY_SEC__}", "0", linkedHashMap), "__S_SCREEN_X__", j.a(new StringBuilder(), mVar.l, ""), linkedHashMap), "__S_SCREEN_Y__", j.a(new StringBuilder(), mVar.m, ""), linkedHashMap);
        Context contextD = SDKContext.getInstance().d();
        if (contextD != null) {
            strA = a(a(a(a(strA, "__WIDTH_DT__", i.a(contextD, mVar.e, new StringBuilder(), ""), linkedHashMap), "__HEIGHT_DT__", i.a(contextD, mVar.f, new StringBuilder(), ""), linkedHashMap), "__S_SCREEN_X_DT__", i.a(contextD, mVar.l, new StringBuilder(), ""), linkedHashMap), "__S_SCREEN_Y_DT__", i.a(contextD, mVar.m, new StringBuilder(), ""), linkedHashMap);
        }
        if (mVar.g == null) {
            strA = a(a(a(a(strA, "__TS__", j2 + "", linkedHashMap), "__TS_MSEC__", j + "", linkedHashMap), "__END_TS__", j2 + "", linkedHashMap), "__END_TS_MSEC__", j + "", linkedHashMap);
        }
        long jCurrentTimeMillis = mVar.n;
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 < 500) {
            jCurrentTimeMillis2 = new Random().nextInt(500) + 500;
        }
        return a(a(a(strA, "__SHOW_T__", jCurrentTimeMillis2 + "", linkedHashMap), "__M_SHOW_RATIO__", "100", linkedHashMap), "__DENSITY__", com.smartdigimkt.r4.h.q(SDKContext.getInstance().d()), linkedHashMap).replaceAll("\\{", "").replaceAll("\\}", "");
    }

    /* JADX WARN: Code duplicated, block: B:128:0x069c  */
    /* JADX WARN: Code duplicated, block: B:129:0x06c2  */
    /* JADX WARN: Code duplicated, block: B:132:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:133:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:136:0x0710  */
    /* JADX WARN: Code duplicated, block: B:137:0x0713  */
    /* JADX WARN: Code duplicated, block: B:140:0x0729  */
    /* JADX WARN: Code duplicated, block: B:143:0x0731  */
    /* JADX WARN: Code duplicated, block: B:150:0x07ad  */
    /* JADX WARN: Code duplicated, block: B:153:0x07d0  */
    /* JADX WARN: Code duplicated, block: B:166:0x0839  */
    /* JADX WARN: Code duplicated, block: B:168:0x085d  */
    /* JADX WARN: Code duplicated, block: B:171:0x088b  */
    /* JADX WARN: Code duplicated, block: B:173:0x0895  */
    /* JADX WARN: Code duplicated, block: B:175:0x08cd  */
    /* JADX WARN: Code duplicated, block: B:176:0x08d2  */
    /* JADX WARN: Code duplicated, block: B:178:0x08dc  */
    /* JADX WARN: Code duplicated, block: B:179:0x0915  */
    /* JADX WARN: Code duplicated, block: B:182:0x095b  */
    /* JADX WARN: Code duplicated, block: B:184:0x0961  */
    /* JADX WARN: Code duplicated, block: B:185:0x0968  */
    /* JADX WARN: Code duplicated, block: B:186:0x096c  */
    /* JADX WARN: Code duplicated, block: B:189:0x0978  */
    /* JADX WARN: Code duplicated, block: B:190:0x097b  */
    /* JADX WARN: Code duplicated, block: B:193:0x09ce  */
    /* JADX WARN: Code duplicated, block: B:194:0x09d1  */
    /* JADX WARN: Code duplicated, block: B:197:0x09d7  */
    /* JADX WARN: Code duplicated, block: B:198:0x09da  */
    public static String a(String str, m mVar, com.smartdigimkt.b3.c cVar, boolean z, LinkedHashMap linkedHashMap) {
        String strEncode;
        String strEncode2;
        String str2;
        String str3;
        String strA;
        String strA2;
        String str4;
        String strA3;
        String strA4;
        String str5;
        String str6;
        String str7;
        String str8;
        com.smartdigimkt.f0.g gVar;
        String strA5;
        String strA6;
        String strA7;
        String strA8;
        String strA9;
        String strA10;
        String strA11;
        com.smartdigimkt.h0.a aVar;
        String str9;
        String strReplaceAll;
        String str10;
        long j;
        long j2;
        long jCurrentTimeMillis;
        String strA12;
        int i;
        String strA13;
        String strA14;
        String strA15;
        String strA16;
        String strA17;
        String str11;
        String str12;
        String strA18;
        String str13;
        String str14;
        boolean z2;
        String str15;
        String str16;
        long j3;
        String strA19;
        float[] fArr;
        com.smartdigimkt.h0.a aVar2 = mVar.g;
        int i2 = mVar.e;
        int i3 = mVar.f;
        Context contextD = SDKContext.getInstance().d();
        String str17 = cVar instanceof com.smartdigimkt.b3.b ? ((com.smartdigimkt.b3.b) cVar).c0 : "";
        String str18 = com.smartdigimkt.f0.e.g;
        HashMap map = com.smartdigimkt.f0.d.a.e;
        com.smartdigimkt.f0.g gVar2 = map != null ? (com.smartdigimkt.f0.g) map.get(str17) : null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_x", aVar2.e);
            jSONObject.put("down_y", aVar2.f);
            jSONObject.put("up_x", aVar2.g);
            jSONObject.put("up_y", aVar2.h);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            float f = i2;
            jSONObject2.put("down_x", (int) ((aVar2.e / f) * 1000.0f));
            float f2 = i3;
            jSONObject2.put("down_y", (int) ((aVar2.f / f2) * 1000.0f));
            jSONObject2.put("up_x", (int) ((aVar2.g / f) * 1000.0f));
            jSONObject2.put("up_y", (int) ((aVar2.h / f2) * 1000.0f));
        } catch (Throwable unused2) {
        }
        try {
            strEncode = URLEncoder.encode(jSONObject.toString(), "utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            strEncode = "{}";
        }
        String str19 = strEncode;
        try {
            strEncode2 = URLEncoder.encode(jSONObject2.toString(), "utf-8");
        } catch (Throwable th2) {
            th2.printStackTrace();
            strEncode2 = "{}";
        }
        a(str);
        b(str);
        String strA20 = j.a(new StringBuilder(), aVar2.s, "");
        String strA21 = a(str, "__SLD__", strA20, linkedHashMap);
        String strA22 = j.a(new StringBuilder(), aVar2.s, "");
        String strA23 = a(strA21, "__C_SLD__", strA22, linkedHashMap);
        int i4 = aVar2.s;
        if (i4 == 0) {
            str2 = "1";
        } else if (i4 == 2) {
            str2 = "2";
        } else if (i4 == 1) {
            str2 = "3";
        } else {
            str2 = i4 == 5 ? "5" : "0";
        }
        String strA24 = a(strA23, "__SLD_OPPO__", str2, linkedHashMap);
        int i5 = aVar2.t;
        if (aVar2.s != 0) {
            str3 = "";
        } else if (i5 == 1 || i5 == 52 || i5 == 59 || i5 == 53 || i5 == 6 || i5 == 24 || i5 == 25 || i5 == 36 || i5 == 40 || i5 == 41) {
            str3 = "BUTTON";
        } else if (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 11 || i5 == 13 || i5 == 14 || i5 == 21 || i5 == 23) {
            str3 = (cVar == null || TextUtils.isEmpty(cVar.i)) ? "PICTURE" : "VIDEO";
        } else {
            str3 = "OTHER";
        }
        if (!TextUtils.isEmpty(strA24) && !TextUtils.isEmpty(str3)) {
            strA24 = a(strA24, "__C_AREA__", str3, linkedHashMap);
        }
        int i6 = aVar2.i ? 1 : 2;
        boolean z3 = aVar2.a > 0 || aVar2.b > 0 || aVar2.c > 0 || aVar2.d > 0;
        int i7 = aVar2.s;
        if ((i7 != 0 && i7 != 1) || !z3) {
            String strA25 = a(gVar2, "__DOWN_X__", "-999");
            String strA26 = a(gVar2, "__DOWN_Y__", "-999");
            strA4 = a(gVar2, "__UP_X__", "-999");
            strA2 = a(gVar2, "__UP_Y__", "-999");
            str4 = strA25;
            String strA27 = a(a(a(a(a(a(a(a(strA24, "__DOWN_X__", strA25, linkedHashMap), "__DOWN_Y__", strA26, linkedHashMap), "__UP_X__", strA4, linkedHashMap), "__UP_Y__", strA2, linkedHashMap), "__RE_DOWN_X__", a(gVar2, "__RE_DOWN_X__", "-999"), linkedHashMap), "__RE_DOWN_Y__", a(gVar2, "__RE_DOWN_Y__", "-999"), linkedHashMap), "__RE_UP_X__", a(gVar2, "__RE_UP_X__", "-999"), linkedHashMap), "__RE_UP_Y__", a(gVar2, "__RE_UP_Y__", "-999"), linkedHashMap);
            try {
                String strEncode3 = URLEncoder.encode("{}", "utf-8");
                strA27 = a(a(strA27, "{ABSOLUTE_COORD}", strEncode3, linkedHashMap), "{RELATIVE_COORD}", strEncode3, linkedHashMap);
            } catch (Throwable unused3) {
            }
            strA3 = a(a(a(a(a(a(a(a(strA27, "__DOWN_X_DT__", a(gVar2, "__DOWN_X_DT__", "-999"), linkedHashMap), "__DOWN_Y_DT__", a(gVar2, "__DOWN_Y_DT__", "-999"), linkedHashMap), "__UP_X_DT__", a(gVar2, "__UP_X_DT__", "-999"), linkedHashMap), "__UP_Y_DT__", a(gVar2, "__UP_Y_DT__", "-999"), linkedHashMap), "__RE_DOWN_X_DT__", a(gVar2, "__RE_DOWN_X_DT__", "-999"), linkedHashMap), "__RE_DOWN_Y_DT__", a(gVar2, "__RE_DOWN_Y_DT__", "-999"), linkedHashMap), "__RE_UP_X_DT__", a(gVar2, "__RE_UP_X_DT__", "-999"), linkedHashMap), "__RE_UP_Y_DT__", a(gVar2, "__RE_UP_Y_DT__", "-999"), linkedHashMap);
            strA = strA26;
        } else {
            String strA28 = j.a(new StringBuilder(), aVar2.a, "");
            strA = j.a(new StringBuilder(), aVar2.b, "");
            String strA29 = j.a(new StringBuilder(), aVar2.c, "");
            strA2 = j.a(new StringBuilder(), aVar2.d, "");
            str4 = strA28;
            strA3 = a(a(a(a(a(a(a(a(a(a(strA24, "__DOWN_X__", strA28, linkedHashMap), "__DOWN_Y__", strA, linkedHashMap), "__UP_X__", strA29, linkedHashMap), "__UP_Y__", strA2, linkedHashMap), "__RE_DOWN_X__", j.a(new StringBuilder(), aVar2.e, ""), linkedHashMap), "__RE_DOWN_Y__", j.a(new StringBuilder(), aVar2.f, ""), linkedHashMap), "__RE_UP_X__", j.a(new StringBuilder(), aVar2.g, ""), linkedHashMap), "__RE_UP_Y__", j.a(new StringBuilder(), aVar2.h, ""), linkedHashMap), "{ABSOLUTE_COORD}", str19, linkedHashMap), "{RELATIVE_COORD}", strEncode2, linkedHashMap);
            if (contextD != null) {
                strA3 = a(a(a(a(a(a(a(a(strA3, "__DOWN_X_DT__", i.a(contextD, aVar2.a, new StringBuilder(), ""), linkedHashMap), "__DOWN_Y_DT__", i.a(contextD, aVar2.b, new StringBuilder(), ""), linkedHashMap), "__UP_X_DT__", i.a(contextD, aVar2.c, new StringBuilder(), ""), linkedHashMap), "__UP_Y_DT__", i.a(contextD, aVar2.d, new StringBuilder(), ""), linkedHashMap), "__RE_DOWN_X_DT__", i.a(contextD, aVar2.e, new StringBuilder(), ""), linkedHashMap), "__RE_DOWN_Y_DT__", i.a(contextD, aVar2.f, new StringBuilder(), ""), linkedHashMap), "__RE_UP_X_DT__", i.a(contextD, aVar2.g, new StringBuilder(), ""), linkedHashMap), "__RE_UP_Y_DT__", i.a(contextD, aVar2.h, new StringBuilder(), ""), linkedHashMap);
            }
            strA4 = strA29;
        }
        String str20 = str4;
        int i8 = aVar2.s;
        String str21 = strA2;
        String str22 = strA4;
        String str23 = strA;
        int i9 = i6;
        String str24 = "";
        com.smartdigimkt.h0.a aVar3 = aVar2;
        if (i8 != 2) {
            if (i8 == 5) {
                str8 = "__RE_C_DOWN_X_DT__";
                gVar = gVar2;
                str7 = "__RE_C_DOWN_Y_DT__";
                str6 = "__RE_C_UP_Y_DT__";
                str5 = "-999";
            } else if (!z3) {
                strA8 = a(gVar2, "__C_DOWN_X__", "-999");
                strA6 = a(gVar2, "__C_DOWN_Y__", "-999");
                strA5 = a(gVar2, "__C_UP_X__", "-999");
                strA7 = a(gVar2, "__C_UP_Y__", "-999");
                strA9 = a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(strA3, "__C_DOWN_X__", strA8, linkedHashMap), "__C_DOWN_Y__", strA6, linkedHashMap), "__C_UP_X__", strA5, linkedHashMap), "__C_UP_Y__", strA7, linkedHashMap), "__RE_C_DOWN_X__", a(gVar2, "__RE_C_DOWN_X__", "-999"), linkedHashMap), "__RE_C_DOWN_Y__", a(gVar2, "__RE_C_DOWN_Y__", "-999"), linkedHashMap), "__RE_C_UP_X__", a(gVar2, "__RE_C_UP_X__", "-999"), linkedHashMap), "__RE_C_UP_Y__", a(gVar2, "__RE_C_UP_Y__", "-999"), linkedHashMap), "__C_DOWN_X_DT__", a(gVar2, "__C_DOWN_X_DT__", "-999"), linkedHashMap), "__C_DOWN_Y_DT__", a(gVar2, "__C_DOWN_Y_DT__", "-999"), linkedHashMap), "__C_UP_X_DT__", a(gVar2, "__C_UP_X_DT__", "-999"), linkedHashMap), "__C_UP_Y_DT__", a(gVar2, "__C_UP_Y_DT__", "-999"), linkedHashMap), "__RE_C_DOWN_X_DT__", a(gVar2, "__RE_C_DOWN_X_DT__", "-999"), linkedHashMap), "__RE_C_DOWN_Y_DT__", a(gVar2, "__RE_C_DOWN_Y_DT__", "-999"), linkedHashMap), "__RE_C_UP_X_DT__", a(gVar2, "__RE_C_UP_X_DT__", "-999"), linkedHashMap), "__RE_C_UP_Y_DT__", a(gVar2, "__RE_C_UP_Y_DT__", "-999"), linkedHashMap);
                str5 = "-999";
                gVar = gVar2;
            } else {
                com.smartdigimkt.f0.g gVar3 = gVar2;
                str5 = "-999";
                String strA30 = j.a(new StringBuilder(), aVar3.a, str24);
                strA6 = j.a(new StringBuilder(), aVar3.b, str24);
                String strA31 = j.a(new StringBuilder(), aVar3.c, str24);
                strA7 = j.a(new StringBuilder(), aVar3.d, str24);
                strA9 = a(a(a(a(a(a(a(a(strA3, "__C_DOWN_X__", strA30, linkedHashMap), "__C_DOWN_Y__", strA6, linkedHashMap), "__C_UP_X__", strA31, linkedHashMap), "__C_UP_Y__", strA7, linkedHashMap), "__RE_C_DOWN_X__", j.a(new StringBuilder(), aVar3.e, str24), linkedHashMap), "__RE_C_DOWN_Y__", j.a(new StringBuilder(), aVar3.f, str24), linkedHashMap), "__RE_C_UP_X__", j.a(new StringBuilder(), aVar3.g, str24), linkedHashMap), "__RE_C_UP_Y__", j.a(new StringBuilder(), aVar3.h, str24), linkedHashMap);
                if (contextD != null) {
                    strA9 = a(a(a(a(a(a(a(a(strA9, "__C_DOWN_X_DT__", i.a(contextD, aVar3.a, new StringBuilder(), str24), linkedHashMap), "__C_DOWN_Y_DT__", i.a(contextD, aVar3.b, new StringBuilder(), str24), linkedHashMap), "__C_UP_X_DT__", i.a(contextD, aVar3.c, new StringBuilder(), str24), linkedHashMap), "__C_UP_Y_DT__", i.a(contextD, aVar3.d, new StringBuilder(), str24), linkedHashMap), "__RE_C_DOWN_X_DT__", i.a(contextD, aVar3.e, new StringBuilder(), str24), linkedHashMap), "__RE_C_DOWN_Y_DT__", i.a(contextD, aVar3.f, new StringBuilder(), str24), linkedHashMap), "__RE_C_UP_X_DT__", i.a(contextD, aVar3.g, new StringBuilder(), str24), linkedHashMap), "__RE_C_UP_Y_DT__", i.a(contextD, aVar3.h, new StringBuilder(), str24), linkedHashMap);
                }
                str24 = str24;
                aVar3 = aVar3;
                strA5 = strA31;
                strA8 = strA30;
                gVar = gVar3;
            }
            strA10 = a(strA9, "{__DPLINK_TYPE__}", String.valueOf(i9), linkedHashMap);
            strA11 = com.smartdigimkt.f.i.a(new StringBuilder(), o.g, "_ptype");
            aVar = aVar3;
            if (aVar.i) {
                str9 = str24;
                strA10 = strA10.replaceAll("&" + strA11 + "=\\{" + strA11 + "\\}", str9);
            } else {
                str9 = str24;
            }
            if (aVar.j == -1) {
                strReplaceAll = strA10.replaceAll("&" + strA11 + "=\\{" + strA11 + "\\}", str9);
            } else {
                strReplaceAll = strA10.replaceAll("\\{" + strA11 + "\\}", String.valueOf(aVar.j));
            }
            if (aVar.i) {
                str10 = "1";
            } else {
                str10 = "0";
            }
            String strReplaceAll2 = strReplaceAll.replaceAll("\\{opdptype\\}", str10);
            j = aVar.k;
            j2 = aVar.l;
            jCurrentTimeMillis = System.currentTimeMillis();
            if (j <= 0) {
                j = jCurrentTimeMillis;
            }
            if (j2 <= 0) {
                j2 = jCurrentTimeMillis;
            }
            String strValueOf = String.valueOf(j);
            String strValueOf2 = String.valueOf(j2);
            String str25 = strA8;
            strA12 = a(a(strReplaceAll2, "__TS__", (j / 1000) + str9, linkedHashMap), "__TS_MSEC__", j + str9, linkedHashMap);
            i = aVar.s;
            if (i == 2 && i != 5) {
                strA13 = a(a(strA12, "__END_TS__", (j2 / 1000) + str9, linkedHashMap), "__END_TS_MSEC__", j2 + str9, linkedHashMap);
            } else {
                strA13 = a(a(strA12, "__END_TS__", a(gVar, "__END_TS__", "__END_TS__"), linkedHashMap), "__END_TS_MSEC__", a(gVar, "__END_TS_MSEC__", "__END_TS_MSEC__"), linkedHashMap);
            }
            if (aVar.s == 2) {
                fArr = aVar.m;
                if (fArr == null && fArr.length == 3) {
                    if (fArr[0] > 0.0f || fArr[1] > 0.0f || fArr[2] > 0.0f) {
                        strA14 = j.a(new StringBuilder(), (int) (fArr[0] * 100.0f), str9);
                        strA15 = j.a(new StringBuilder(), (int) (fArr[1] * 100.0f), str9);
                        String strA32 = j.a(new StringBuilder(), (int) (fArr[2] * 100.0f), str9);
                        strA17 = a(a(a(strA13, "__M_X_ACC__", strA14, linkedHashMap), "__M_Y_ACC__", strA15, linkedHashMap), "__M_Z_ACC__", strA32, linkedHashMap);
                        strA16 = strA32;
                        str5 = str5;
                    }
                }
                strA14 = a(gVar, "__M_X_ACC__", str5);
                strA15 = a(gVar, "__M_Y_ACC__", str5);
                strA16 = a(gVar, "__M_Z_ACC__", str5);
                strA17 = a(a(a(strA13, "__M_X_ACC__", strA14, linkedHashMap), "__M_Y_ACC__", strA15, linkedHashMap), "__M_Z_ACC__", strA16, linkedHashMap);
            } else {
                str5 = str5;
                strA14 = a(gVar, "__M_X_ACC__", "__M_X_ACC__");
                strA15 = a(gVar, "__M_Y_ACC__", "__M_Y_ACC__");
                strA16 = a(gVar, "__M_Z_ACC__", "__M_Z_ACC__");
                strA17 = a(a(a(strA13, "__M_X_ACC__", strA14, linkedHashMap), "__M_Y_ACC__", strA15, linkedHashMap), "__M_Z_ACC__", strA16, linkedHashMap);
            }
            if (aVar.s == 5) {
                str11 = strA14;
                str12 = strA15;
                if (aVar.q > 0) {
                    String strA33 = a(a(a(a(strA17, "__TURN_X__", String.valueOf(aVar.n), linkedHashMap), "__TURN_Y__", String.valueOf(aVar.o), linkedHashMap), "__TURN_Z__", String.valueOf(aVar.p), linkedHashMap), "__TURN_T__", String.valueOf(aVar.q), linkedHashMap);
                    j3 = aVar.r;
                    if (j3 >= 0) {
                        strA19 = String.valueOf(j3);
                    } else {
                        strA19 = a(gVar, "__TURN_T_5__", str5);
                    }
                    strA18 = a(strA33, "__TURN_T_5__", strA19, linkedHashMap);
                } else {
                    strA18 = a(a(a(a(a(strA17, "__TURN_X__", a(gVar, "__TURN_X__", str5), linkedHashMap), "__TURN_Y__", a(gVar, "__TURN_Y__", str5), linkedHashMap), "__TURN_Z__", a(gVar, "__TURN_Z__", str5), linkedHashMap), "__TURN_T__", a(gVar, "__TURN_T__", str5), linkedHashMap), "__TURN_T_5__", a(gVar, "__TURN_T_5__", str5), linkedHashMap);
                }
            } else {
                str11 = strA14;
                str12 = strA15;
                strA18 = a(a(a(a(a(strA17, "__TURN_X__", a(gVar, "__TURN_X__", "__TURN_X__"), linkedHashMap), "__TURN_Y__", a(gVar, "__TURN_Y__", "__TURN_Y__"), linkedHashMap), "__TURN_Z__", a(gVar, "__TURN_Z__", "__TURN_Z__"), linkedHashMap), "__TURN_T__", a(gVar, "__TURN_T__", "__TURN_T__"), linkedHashMap), "__TURN_T_5__", a(gVar, "__TURN_T_5__", "__TURN_T_5__"), linkedHashMap);
            }
            if (cVar != null) {
                str13 = cVar.a;
                if (cVar instanceof com.smartdigimkt.b3.l) {
                    str14 = ((com.smartdigimkt.b3.l) cVar).c0;
                } else {
                    str14 = str9;
                }
            } else {
                str13 = str9;
                str14 = str13;
            }
            String str26 = mVar.b;
            String str27 = mVar.c;
            com.smartdigimkt.a3.a aVar4 = mVar.a;
            if (gVar != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(null, String.valueOf(66));
            cVar2.a = "1004731";
            cVar2.b = str26;
            cVar2.c = str27;
            cVar2.a(aVar4);
            cVar2.l = str14;
            cVar2.m = str13;
            cVar2.n = strA22;
            cVar2.o = str25;
            cVar2.p = strA6;
            cVar2.q = strA5;
            cVar2.r = strA7;
            cVar2.s = strValueOf;
            cVar2.t = strValueOf2;
            cVar2.u = str;
            cVar2.v = String.valueOf(2);
            cVar2.w = strA20;
            cVar2.x = str20;
            cVar2.y = str23;
            cVar2.z = str22;
            cVar2.A = str21;
            if (z2) {
                str15 = "2";
            } else {
                str15 = "1";
            }
            cVar2.B = str15;
            if (z) {
                str16 = "1";
            } else {
                str16 = "2";
            }
            cVar2.C = str16;
            cVar2.D = str11;
            cVar2.E = str12;
            cVar2.F = strA16;
            com.smartdigimkt.n3.k.a(cVar2);
            return strA18;
        }
        str5 = "-999";
        str6 = "__RE_C_UP_Y_DT__";
        str7 = "__RE_C_DOWN_Y_DT__";
        str8 = "__RE_C_DOWN_X_DT__";
        gVar = gVar2;
        String strA34 = a(gVar, "__C_DOWN_X__", "__C_DOWN_X__");
        String strA35 = a(gVar, "__C_DOWN_Y__", "__C_DOWN_Y__");
        strA5 = a(gVar, "__C_UP_X__", "__C_UP_X__");
        String strA36 = a(gVar, "__C_UP_Y__", "__C_UP_Y__");
        String str28 = str8;
        String strA37 = a(a(a(a(a(a(a(a(a(a(a(a(a(strA3, "__C_DOWN_X__", strA34, linkedHashMap), "__C_DOWN_Y__", strA35, linkedHashMap), "__C_UP_X__", strA5, linkedHashMap), "__C_UP_Y__", strA36, linkedHashMap), "__RE_C_DOWN_X__", a(gVar, "__RE_C_DOWN_X__", "__RE_C_DOWN_X__"), linkedHashMap), "__RE_C_DOWN_Y__", a(gVar, "__RE_C_DOWN_Y__", "__RE_C_DOWN_Y__"), linkedHashMap), "__RE_C_UP_X__", a(gVar, "__RE_C_UP_X__", "__RE_C_UP_X__"), linkedHashMap), "__RE_C_UP_Y__", a(gVar, "__RE_C_UP_Y__", "__RE_C_UP_Y__"), linkedHashMap), "__C_DOWN_X_DT__", a(gVar, "__C_DOWN_X_DT__", "__C_DOWN_X_DT__"), linkedHashMap), "__C_DOWN_Y_DT__", a(gVar, "__C_DOWN_Y_DT__", "__C_DOWN_Y_DT__"), linkedHashMap), "__C_UP_X_DT__", a(gVar, "__C_UP_X_DT__", "__C_UP_X_DT__"), linkedHashMap), "__C_UP_Y_DT__", a(gVar, "__C_UP_Y_DT__", "__C_UP_Y_DT__"), linkedHashMap), str28, a(gVar, str28, str28), linkedHashMap);
        String str29 = str7;
        String strA38 = a(a(strA37, str29, a(gVar, str29, str29), linkedHashMap), "__RE_C_UP_X_DT__", a(gVar, "__RE_C_UP_X_DT__", "__RE_C_UP_X_DT__"), linkedHashMap);
        String str30 = str6;
        strA9 = a(strA38, str30, a(gVar, str30, str30), linkedHashMap);
        strA7 = strA36;
        strA8 = strA34;
        strA6 = strA35;
        strA10 = a(strA9, "{__DPLINK_TYPE__}", String.valueOf(i9), linkedHashMap);
        strA11 = com.smartdigimkt.f.i.a(new StringBuilder(), o.g, "_ptype");
        aVar = aVar3;
        if (aVar.i) {
            str9 = str24;
            strA10 = strA10.replaceAll("&" + strA11 + "=\\{" + strA11 + "\\}", str9);
        } else {
            str9 = str24;
        }
        if (aVar.j == -1) {
            strReplaceAll = strA10.replaceAll("&" + strA11 + "=\\{" + strA11 + "\\}", str9);
        } else {
            strReplaceAll = strA10.replaceAll("\\{" + strA11 + "\\}", String.valueOf(aVar.j));
        }
        if (aVar.i) {
            str10 = "1";
        } else {
            str10 = "0";
        }
        String strReplaceAll3 = strReplaceAll.replaceAll("\\{opdptype\\}", str10);
        j = aVar.k;
        j2 = aVar.l;
        jCurrentTimeMillis = System.currentTimeMillis();
        if (j <= 0) {
            j = jCurrentTimeMillis;
        }
        if (j2 <= 0) {
            j2 = jCurrentTimeMillis;
        }
        String strValueOf3 = String.valueOf(j);
        String strValueOf4 = String.valueOf(j2);
        String str210 = strA8;
        strA12 = a(a(strReplaceAll3, "__TS__", (j / 1000) + str9, linkedHashMap), "__TS_MSEC__", j + str9, linkedHashMap);
        i = aVar.s;
        if (i == 2) {
            strA13 = a(a(strA12, "__END_TS__", a(gVar, "__END_TS__", "__END_TS__"), linkedHashMap), "__END_TS_MSEC__", a(gVar, "__END_TS_MSEC__", "__END_TS_MSEC__"), linkedHashMap);
        } else {
            strA13 = a(a(strA12, "__END_TS__", a(gVar, "__END_TS__", "__END_TS__"), linkedHashMap), "__END_TS_MSEC__", a(gVar, "__END_TS_MSEC__", "__END_TS_MSEC__"), linkedHashMap);
        }
        if (aVar.s == 2) {
            fArr = aVar.m;
            if (fArr == null) {
                strA14 = a(gVar, "__M_X_ACC__", str5);
                strA15 = a(gVar, "__M_Y_ACC__", str5);
                strA16 = a(gVar, "__M_Z_ACC__", str5);
                strA17 = a(a(a(strA13, "__M_X_ACC__", strA14, linkedHashMap), "__M_Y_ACC__", strA15, linkedHashMap), "__M_Z_ACC__", strA16, linkedHashMap);
            } else {
                strA14 = a(gVar, "__M_X_ACC__", str5);
                strA15 = a(gVar, "__M_Y_ACC__", str5);
                strA16 = a(gVar, "__M_Z_ACC__", str5);
                strA17 = a(a(a(strA13, "__M_X_ACC__", strA14, linkedHashMap), "__M_Y_ACC__", strA15, linkedHashMap), "__M_Z_ACC__", strA16, linkedHashMap);
            }
        } else {
            str5 = str5;
            strA14 = a(gVar, "__M_X_ACC__", "__M_X_ACC__");
            strA15 = a(gVar, "__M_Y_ACC__", "__M_Y_ACC__");
            strA16 = a(gVar, "__M_Z_ACC__", "__M_Z_ACC__");
            strA17 = a(a(a(strA13, "__M_X_ACC__", strA14, linkedHashMap), "__M_Y_ACC__", strA15, linkedHashMap), "__M_Z_ACC__", strA16, linkedHashMap);
        }
        if (aVar.s == 5) {
            str11 = strA14;
            str12 = strA15;
            if (aVar.q > 0) {
                String strA39 = a(a(a(a(strA17, "__TURN_X__", String.valueOf(aVar.n), linkedHashMap), "__TURN_Y__", String.valueOf(aVar.o), linkedHashMap), "__TURN_Z__", String.valueOf(aVar.p), linkedHashMap), "__TURN_T__", String.valueOf(aVar.q), linkedHashMap);
                j3 = aVar.r;
                if (j3 >= 0) {
                    strA19 = String.valueOf(j3);
                } else {
                    strA19 = a(gVar, "__TURN_T_5__", str5);
                }
                strA18 = a(strA39, "__TURN_T_5__", strA19, linkedHashMap);
            } else {
                strA18 = a(a(a(a(a(strA17, "__TURN_X__", a(gVar, "__TURN_X__", str5), linkedHashMap), "__TURN_Y__", a(gVar, "__TURN_Y__", str5), linkedHashMap), "__TURN_Z__", a(gVar, "__TURN_Z__", str5), linkedHashMap), "__TURN_T__", a(gVar, "__TURN_T__", str5), linkedHashMap), "__TURN_T_5__", a(gVar, "__TURN_T_5__", str5), linkedHashMap);
            }
        } else {
            str11 = strA14;
            str12 = strA15;
            strA18 = a(a(a(a(a(strA17, "__TURN_X__", a(gVar, "__TURN_X__", "__TURN_X__"), linkedHashMap), "__TURN_Y__", a(gVar, "__TURN_Y__", "__TURN_Y__"), linkedHashMap), "__TURN_Z__", a(gVar, "__TURN_Z__", "__TURN_Z__"), linkedHashMap), "__TURN_T__", a(gVar, "__TURN_T__", "__TURN_T__"), linkedHashMap), "__TURN_T_5__", a(gVar, "__TURN_T_5__", "__TURN_T_5__"), linkedHashMap);
        }
        if (cVar != null) {
            str13 = cVar.a;
            if (cVar instanceof com.smartdigimkt.b3.l) {
                str14 = ((com.smartdigimkt.b3.l) cVar).c0;
            } else {
                str14 = str9;
            }
        } else {
            str13 = str9;
            str14 = str13;
        }
        String str211 = mVar.b;
        String str212 = mVar.c;
        com.smartdigimkt.a3.a aVar5 = mVar.a;
        if (gVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        com.smartdigimkt.f3.c cVar3 = new com.smartdigimkt.f3.c(null, String.valueOf(66));
        cVar3.a = "1004731";
        cVar3.b = str211;
        cVar3.c = str212;
        cVar3.a(aVar5);
        cVar3.l = str14;
        cVar3.m = str13;
        cVar3.n = strA22;
        cVar3.o = str210;
        cVar3.p = strA6;
        cVar3.q = strA5;
        cVar3.r = strA7;
        cVar3.s = strValueOf3;
        cVar3.t = strValueOf4;
        cVar3.u = str;
        cVar3.v = String.valueOf(2);
        cVar3.w = strA20;
        cVar3.x = str20;
        cVar3.y = str23;
        cVar3.z = str22;
        cVar3.A = str21;
        if (z2) {
            str15 = "2";
        } else {
            str15 = "1";
        }
        cVar3.B = str15;
        if (z) {
            str16 = "1";
        } else {
            str16 = "2";
        }
        cVar3.C = str16;
        cVar3.D = str11;
        cVar3.E = str12;
        cVar3.F = strA16;
        com.smartdigimkt.n3.k.a(cVar3);
        return strA18;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("__SLD__") || str.contains("__DOWN_X__") || str.contains("__RE_DOWN_X__") || str.contains("__DOWN_Y__") || str.contains("__RE_DOWN_Y__") || str.contains("__UP_X__") || str.contains("__RE_UP_X__") || str.contains("__UP_Y__") || str.contains("__RE_UP_Y__") || str.contains("__DOWN_X_DT__") || str.contains("__RE_DOWN_X_DT__") || str.contains("__DOWN_Y_DT__") || str.contains("__RE_DOWN_Y_DT__") || str.contains("__UP_X_DT__") || str.contains("__RE_UP_X_DT__") || str.contains("__UP_Y_DT__") || str.contains("__RE_UP_Y_DT__");
    }
}
