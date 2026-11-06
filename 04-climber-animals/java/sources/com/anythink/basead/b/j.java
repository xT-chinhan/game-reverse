package com.anythink.basead.b;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.bl;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.q;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    protected static void a(int i, bj bjVar, com.anythink.basead.d.j jVar) {
        String strD;
        String[] strArrH;
        bl blVarAG = bjVar.aG();
        if (blVarAG == null) {
            return;
        }
        Map<String, Object> mapC = q.c(blVarAG.c());
        try {
            switch (i) {
                case 1:
                    strArrH = blVarAG.h();
                    break;
                case 2:
                    strArrH = blVarAG.i();
                    break;
                case 3:
                    strArrH = blVarAG.j();
                    break;
                case 4:
                    strArrH = blVarAG.k();
                    break;
                case 5:
                    strArrH = blVarAG.l();
                    break;
                case 6:
                    strArrH = blVarAG.q();
                    break;
                case 7:
                    strArrH = blVarAG.r();
                    break;
                case 8:
                    strArrH = blVarAG.f();
                    break;
                case 9:
                    strArrH = blVarAG.g();
                    break;
                case 10:
                    strArrH = blVarAG.d();
                    break;
                case 11:
                    strArrH = blVarAG.m();
                    break;
                case 12:
                    strArrH = blVarAG.o();
                    break;
                case 13:
                    strArrH = blVarAG.p();
                    break;
                case 14:
                    strArrH = blVarAG.n();
                    break;
                case 15:
                    strArrH = blVarAG.R();
                    break;
                case 16:
                    strArrH = blVarAG.S();
                    break;
                case 17:
                    strArrH = blVarAG.T();
                    break;
                case 18:
                    strArrH = blVarAG.s();
                    break;
                case 19:
                    strArrH = blVarAG.t();
                    break;
                case 20:
                    strArrH = blVarAG.U();
                    break;
                case 21:
                    strArrH = blVarAG.u();
                    break;
                case 22:
                default:
                    strArrH = null;
                    break;
                case 23:
                    strArrH = blVarAG.V();
                    break;
                case 24:
                    strArrH = blVarAG.W();
                    break;
                case 25:
                    strArrH = blVarAG.X();
                    break;
                case 26:
                    strArrH = blVarAG.Y();
                    break;
                case 27:
                    strArrH = blVarAG.Z();
                    break;
                case 28:
                    strArrH = blVarAG.w();
                    break;
                case 29:
                    strArrH = blVarAG.v();
                    break;
                case 30:
                    strArrH = blVarAG.x();
                    break;
                case 31:
                    strArrH = blVarAG.y();
                    break;
                case 32:
                    com.anythink.basead.d.k kVar = jVar.j;
                    Map<Integer, String[]> mapZ = blVarAG.z();
                    strArrH = (kVar != null && mapZ != null) ? mapZ.get(Integer.valueOf(kVar.i)) : null;
                    break;
                case 33:
                    strArrH = blVarAG.a();
                    break;
                case 34:
                    strArrH = blVarAG.b();
                    break;
                case 35:
                    strArrH = blVarAG.ap();
                    break;
                case 36:
                    strArrH = blVarAG.e();
                    break;
            }
            if (strArrH != null) {
                boolean zAe = (i == 8 || i == 9) ? bjVar.r().ae() : false;
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i2 = 0;
                for (int length = strArrH.length; i2 < length; length = length) {
                    String str = strArrH[i2];
                    if (!TextUtils.isEmpty(str)) {
                        com.anythink.basead.i.e eVar = new com.anythink.basead.i.e(i, a(str, jVar, jCurrentTimeMillis, (w) bjVar, false), bjVar, mapC);
                        eVar.a(zAe);
                        eVar.a(0, (com.anythink.core.common.m.q) null);
                    }
                    i2++;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        switch (i) {
            case 1:
                strD = blVarAG.D();
                break;
            case 2:
                strD = blVarAG.E();
                break;
            case 3:
                strD = blVarAG.F();
                break;
            case 4:
                strD = blVarAG.G();
                break;
            case 5:
                strD = blVarAG.H();
                break;
            case 6:
                strD = blVarAG.M();
                break;
            case 7:
                strD = blVarAG.N();
                break;
            case 8:
                strD = blVarAG.B();
                break;
            case 9:
                strD = blVarAG.C();
                break;
            case 10:
                strD = blVarAG.A();
                break;
            case 11:
                strD = blVarAG.I();
                break;
            case 12:
                strD = blVarAG.K();
                break;
            case 13:
                strD = blVarAG.L();
                break;
            case 14:
                strD = blVarAG.J();
                break;
            case 15:
                strD = blVarAG.aa();
                break;
            case 16:
                strD = blVarAG.ab();
                break;
            case 17:
                strD = blVarAG.ac();
                break;
            case 18:
                strD = blVarAG.O();
                break;
            case 19:
                strD = blVarAG.P();
                break;
            case 20:
                strD = blVarAG.ad();
                break;
            case 21:
                strD = blVarAG.Q();
                break;
            case 22:
            case 32:
            default:
                strD = "";
                break;
            case 23:
                strD = blVarAG.ae();
                break;
            case 24:
                strD = blVarAG.af();
                break;
            case 25:
                strD = blVarAG.ag();
                break;
            case 26:
                strD = blVarAG.ah();
                break;
            case 27:
                strD = blVarAG.ai();
                break;
            case 28:
                strD = blVarAG.ak();
                break;
            case 29:
                strD = blVarAG.aj();
                break;
            case 30:
                strD = blVarAG.al();
                break;
            case 31:
                strD = blVarAG.am();
                break;
            case 33:
                strD = blVarAG.an();
                break;
            case 34:
                strD = blVarAG.ao();
                break;
            case 35:
                strD = blVarAG.aq();
                break;
        }
        if (a(strD)) {
            return;
        }
        com.anythink.basead.i.f fVar = new com.anythink.basead.i.f(i, bjVar, strD, mapC);
        fVar.a(jVar.d);
        fVar.a(0, (com.anythink.core.common.m.q) null);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0003. Please report as an issue. */
    private static void a(int i, bj bjVar, bl blVar, Map<String, Object> map, com.anythink.basead.d.j jVar) {
        String[] strArrH;
        String[] strArr;
        String[] strArrA;
        try {
            switch (i) {
                case 1:
                    strArrH = blVar.h();
                    strArr = strArrH;
                    break;
                case 2:
                    strArrH = blVar.i();
                    strArr = strArrH;
                    break;
                case 3:
                    strArrH = blVar.j();
                    strArr = strArrH;
                    break;
                case 4:
                    strArrH = blVar.k();
                    strArr = strArrH;
                    break;
                case 5:
                    strArrH = blVar.l();
                    strArr = strArrH;
                    break;
                case 6:
                    strArrH = blVar.q();
                    strArr = strArrH;
                    break;
                case 7:
                    strArrH = blVar.r();
                    strArr = strArrH;
                    break;
                case 8:
                    strArrH = blVar.f();
                    strArr = strArrH;
                    break;
                case 9:
                    strArrH = blVar.g();
                    strArr = strArrH;
                    break;
                case 10:
                    strArrH = blVar.d();
                    strArr = strArrH;
                    break;
                case 11:
                    strArrH = blVar.m();
                    strArr = strArrH;
                    break;
                case 12:
                    strArrH = blVar.o();
                    strArr = strArrH;
                    break;
                case 13:
                    strArrH = blVar.p();
                    strArr = strArrH;
                    break;
                case 14:
                    strArrH = blVar.n();
                    strArr = strArrH;
                    break;
                case 15:
                    strArrH = blVar.R();
                    strArr = strArrH;
                    break;
                case 16:
                    strArrH = blVar.S();
                    strArr = strArrH;
                    break;
                case 17:
                    strArrH = blVar.T();
                    strArr = strArrH;
                    break;
                case 18:
                    strArrH = blVar.s();
                    strArr = strArrH;
                    break;
                case 19:
                    strArrH = blVar.t();
                    strArr = strArrH;
                    break;
                case 20:
                    strArrH = blVar.U();
                    strArr = strArrH;
                    break;
                case 21:
                    strArrH = blVar.u();
                    strArr = strArrH;
                    break;
                case 22:
                default:
                    strArr = null;
                    break;
                case 23:
                    strArrH = blVar.V();
                    strArr = strArrH;
                    break;
                case 24:
                    strArrH = blVar.W();
                    strArr = strArrH;
                    break;
                case 25:
                    strArrH = blVar.X();
                    strArr = strArrH;
                    break;
                case 26:
                    strArrH = blVar.Y();
                    strArr = strArrH;
                    break;
                case 27:
                    strArrH = blVar.Z();
                    strArr = strArrH;
                    break;
                case 28:
                    strArrH = blVar.w();
                    strArr = strArrH;
                    break;
                case 29:
                    strArrH = blVar.v();
                    strArr = strArrH;
                    break;
                case 30:
                    strArrH = blVar.x();
                    strArr = strArrH;
                    break;
                case 31:
                    strArrH = blVar.y();
                    strArr = strArrH;
                    break;
                case 32:
                    com.anythink.basead.d.k kVar = jVar.j;
                    Map<Integer, String[]> mapZ = blVar.z();
                    if (kVar == null || mapZ == null) {
                        strArr = null;
                    } else {
                        strArrH = mapZ.get(Integer.valueOf(kVar.i));
                        strArr = strArrH;
                    }
                    break;
                case 33:
                    strArrA = blVar.a();
                    strArr = strArrA;
                    break;
                case 34:
                    strArrA = blVar.b();
                    strArr = strArrA;
                    break;
                case 35:
                    strArrA = blVar.ap();
                    strArr = strArrA;
                    break;
                case 36:
                    strArrA = blVar.e();
                    strArr = strArrA;
                    break;
            }
            if (strArr != null) {
                boolean zAe = (i == 8 || i == 9) ? bjVar.r().ae() : false;
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        com.anythink.basead.i.e eVar = new com.anythink.basead.i.e(i, a(str, jVar, jCurrentTimeMillis, (w) bjVar, false), bjVar, map);
                        eVar.a(zAe);
                        eVar.a(0, (com.anythink.core.common.m.q) null);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(int i, com.anythink.basead.d.j jVar, bj bjVar, bl blVar, Map<String, Object> map) {
        String strD;
        switch (i) {
            case 1:
                strD = blVar.D();
                break;
            case 2:
                strD = blVar.E();
                break;
            case 3:
                strD = blVar.F();
                break;
            case 4:
                strD = blVar.G();
                break;
            case 5:
                strD = blVar.H();
                break;
            case 6:
                strD = blVar.M();
                break;
            case 7:
                strD = blVar.N();
                break;
            case 8:
                strD = blVar.B();
                break;
            case 9:
                strD = blVar.C();
                break;
            case 10:
                strD = blVar.A();
                break;
            case 11:
                strD = blVar.I();
                break;
            case 12:
                strD = blVar.K();
                break;
            case 13:
                strD = blVar.L();
                break;
            case 14:
                strD = blVar.J();
                break;
            case 15:
                strD = blVar.aa();
                break;
            case 16:
                strD = blVar.ab();
                break;
            case 17:
                strD = blVar.ac();
                break;
            case 18:
                strD = blVar.O();
                break;
            case 19:
                strD = blVar.P();
                break;
            case 20:
                strD = blVar.ad();
                break;
            case 21:
                strD = blVar.Q();
                break;
            case 22:
            case 32:
            default:
                strD = "";
                break;
            case 23:
                strD = blVar.ae();
                break;
            case 24:
                strD = blVar.af();
                break;
            case 25:
                strD = blVar.ag();
                break;
            case 26:
                strD = blVar.ah();
                break;
            case 27:
                strD = blVar.ai();
                break;
            case 28:
                strD = blVar.ak();
                break;
            case 29:
                strD = blVar.aj();
                break;
            case 30:
                strD = blVar.al();
                break;
            case 31:
                strD = blVar.am();
                break;
            case 33:
                strD = blVar.an();
                break;
            case 34:
                strD = blVar.ao();
                break;
            case 35:
                strD = blVar.aq();
                break;
        }
        if (a(strD)) {
            return;
        }
        com.anythink.basead.i.f fVar = new com.anythink.basead.i.f(i, bjVar, strD, map);
        fVar.a(jVar.d);
        fVar.a(0, (com.anythink.core.common.m.q) null);
    }

    private static String a(String str, com.anythink.basead.d.j jVar, long j, w wVar) {
        return a(str, jVar, j, wVar, false);
    }

    public static String a(String str, com.anythink.basead.d.j jVar, long j, w wVar, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (jVar.i != null) {
            str = a(str, jVar, wVar, z);
        }
        if (jVar.j != null) {
            str = a(str, jVar.j);
        }
        if (jVar.k != null) {
            str = a(str, jVar.k);
        }
        if (jVar.r != null) {
            str = a(str, jVar.r);
        }
        long j2 = j / 1000;
        String strReplaceAll = str.replaceAll("\\{__REQ_WIDTH__\\}", jVar.e == 0 ? "__REQ_WIDTH__" : new StringBuilder().append(jVar.e).toString()).replaceAll("\\{__REQ_HEIGHT__\\}", jVar.f == 0 ? "__REQ_HEIGHT__" : new StringBuilder().append(jVar.f).toString()).replaceAll("__WIDTH__", new StringBuilder().append(jVar.g).toString()).replaceAll("__HEIGHT__", new StringBuilder().append(jVar.h).toString()).replaceAll("\\{__PLAY_SEC__\\}", "0").replaceAll("__S_SCREEN_X__", new StringBuilder().append(jVar.n).toString()).replaceAll("__S_SCREEN_Y__", new StringBuilder().append(jVar.o).toString());
        Context contextG = t.b().g();
        if (contextG != null) {
            strReplaceAll = strReplaceAll.replaceAll("__WIDTH_DT__", new StringBuilder().append(q.b(contextG, jVar.g)).toString()).replaceAll("__HEIGHT_DT__", new StringBuilder().append(q.b(contextG, jVar.h)).toString()).replaceAll("__S_SCREEN_X_DT__", new StringBuilder().append(q.b(contextG, jVar.n)).toString()).replaceAll("__S_SCREEN_Y_DT__", new StringBuilder().append(q.b(contextG, jVar.o)).toString());
        }
        if (jVar.i == null) {
            strReplaceAll = strReplaceAll.replaceAll("__TS__", String.valueOf(j2)).replaceAll("__TS_MSEC__", String.valueOf(j)).replaceAll("__END_TS__", String.valueOf(j2)).replaceAll("__END_TS_MSEC__", String.valueOf(j));
        }
        long jCurrentTimeMillis = jVar.q;
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 < 500) {
            jCurrentTimeMillis2 = new Random().nextInt(500) + 500;
        }
        return strReplaceAll.replaceAll("__SHOW_T__", String.valueOf(jCurrentTimeMillis2)).replaceAll("__M_SHOW_RATIO__", (jVar.p <= 0 || jVar.p > 100) ? "__M_SHOW_RATIO__" : new StringBuilder().append(jVar.p).toString()).replaceAll("__DENSITY__", m.p(t.b().g())).replaceAll("\\{", "").replaceAll("\\}", "");
    }

    private static String a(String str, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            try {
                str = str.replace(key, entry.getValue().toString());
                new StringBuilder("replaceAdxNoticeMap, replaceKey -> ").append(key).append(", replaceValue: ");
            } catch (Throwable th) {
                th.getMessage();
                th.printStackTrace();
            }
        }
        return str;
    }

    private static String a(String str, com.anythink.basead.d.k kVar) {
        return str.replaceAll("\\{__VIDEO_TIME__\\}", new StringBuilder().append(kVar.a).toString()).replaceAll("\\{__BEGIN_TIME__\\}", new StringBuilder().append(kVar.b).toString()).replaceAll("\\{__END_TIME__\\}", new StringBuilder().append(kVar.c).toString()).replaceAll("\\{__PLAY_FIRST_FRAME__\\}", new StringBuilder().append(kVar.d).toString()).replaceAll("\\{__PLAY_LAST_FRAME__\\}", new StringBuilder().append(kVar.e).toString()).replaceAll("\\{__SCENE__\\}", new StringBuilder().append(kVar.l).toString()).replaceAll("\\{__TYPE__\\}", new StringBuilder().append(kVar.o).toString()).replaceAll("\\{__BEHAVIOR__\\}", new StringBuilder().append(kVar.r).toString()).replaceAll("\\{__STATUS__\\}", new StringBuilder().append(kVar.u).toString()).replaceAll("__TS__", new StringBuilder().append(kVar.f / 1000).toString()).replaceAll("__TS_MSEC__", new StringBuilder().append(kVar.f).toString()).replaceAll("__END_TS__", new StringBuilder().append(kVar.g / 1000).toString()).replaceAll("__END_TS_MSEC__", new StringBuilder().append(kVar.g).toString()).replaceAll("\\{__PLAY_SEC__\\}", new StringBuilder().append(kVar.h / 1000).toString()).replaceAll("\\{__PLAY_MSEC__\\}", new StringBuilder().append(kVar.h).toString());
    }

    private static String a(String str, com.anythink.basead.d.b bVar) {
        return bVar.b > 0 ? str.replaceAll("__DP_APP_INSTALL__", String.valueOf(bVar.b)) : str.replaceAll("\\{__CLICK_ID__\\}", bVar.a == null ? "" : bVar.a);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x023f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:104:0x024a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0256 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:109:0x0272  */
    /* JADX WARN: Code duplicated, block: B:112:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:113:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:116:0x02af  */
    /* JADX WARN: Code duplicated, block: B:124:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:127:0x02cb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:133:0x049d  */
    /* JADX WARN: Code duplicated, block: B:135:0x04af  */
    /* JADX WARN: Code duplicated, block: B:137:0x04b4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:151:0x0677  */
    /* JADX WARN: Code duplicated, block: B:155:0x0751  */
    /* JADX WARN: Code duplicated, block: B:157:0x07f2  */
    /* JADX WARN: Code duplicated, block: B:159:0x080c  */
    /* JADX WARN: Code duplicated, block: B:160:0x08af  */
    /* JADX WARN: Code duplicated, block: B:162:0x095a  */
    /* JADX WARN: Code duplicated, block: B:166:0x0a3c  */
    /* JADX WARN: Code duplicated, block: B:169:0x0a49  */
    /* JADX WARN: Code duplicated, block: B:170:0x0a52  */
    /* JADX WARN: Code duplicated, block: B:173:0x0a62  */
    /* JADX WARN: Code duplicated, block: B:174:0x0a65  */
    /* JADX WARN: Code duplicated, block: B:177:0x0a7b  */
    /* JADX WARN: Code duplicated, block: B:180:0x0a82  */
    /* JADX WARN: Code duplicated, block: B:183:0x0a8b  */
    /* JADX WARN: Code duplicated, block: B:186:0x0aee  */
    /* JADX WARN: Code duplicated, block: B:188:0x0af2  */
    /* JADX WARN: Code duplicated, block: B:199:0x0b69  */
    /* JADX WARN: Code duplicated, block: B:201:0x0b92  */
    /* JADX WARN: Code duplicated, block: B:204:0x0bc0  */
    /* JADX WARN: Code duplicated, block: B:206:0x0bc8  */
    /* JADX WARN: Code duplicated, block: B:208:0x0bd7  */
    /* JADX WARN: Code duplicated, block: B:211:0x0be6  */
    /* JADX WARN: Code duplicated, block: B:212:0x0be9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    private static String a(String str, com.anythink.basead.d.j jVar, w wVar, boolean z) {
        String strEncode;
        String strEncode2;
        String str2;
        String str3;
        String str4;
        boolean z2;
        boolean z3;
        String string;
        String strReplaceAll;
        String strReplaceAll2;
        char c;
        boolean z4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Context context;
        com.anythink.basead.b.e.b bVar;
        String str10;
        String strReplaceAll3;
        String str11;
        String str12;
        String str13;
        String strReplaceAll4;
        String str14;
        String str15;
        String str16;
        Context context2;
        String str17;
        String str18;
        com.anythink.basead.d.a aVar;
        String strReplaceAll5;
        String str19;
        String str20;
        String str21;
        String str22;
        String strA;
        String strReplaceAll6;
        String strReplaceAll7;
        String str23;
        long j;
        long jNextInt;
        long jCurrentTimeMillis;
        String strReplaceAll8;
        boolean z5;
        int i;
        String strReplaceAll9;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        int iAi;
        boolean z6;
        float[] fArr;
        com.anythink.basead.d.a aVar2 = jVar.i;
        int i2 = jVar.g;
        int i3 = jVar.h;
        Context contextG = t.b().g();
        com.anythink.basead.b.e.b bVarA = com.anythink.basead.b.e.a.a().a(wVar instanceof r ? ((r) wVar).aC() : "");
        JSONObject jSONObject = new JSONObject();
        try {
            if (aVar2.o != null) {
                jSONObject.put("down_x", aVar2.o.e);
                jSONObject.put("down_y", aVar2.o.f);
                jSONObject.put("up_x", aVar2.o.g);
                jSONObject.put("up_y", aVar2.o.h);
            } else {
                jSONObject.put("down_x", aVar2.e);
                jSONObject.put("down_y", aVar2.f);
                jSONObject.put("up_x", aVar2.g);
                jSONObject.put("up_y", aVar2.h);
            }
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        if (aVar2.o != null) {
            float f = i2;
            jSONObject2.put("down_x", (int) ((aVar2.o.e / f) * 1000.0f));
            float f2 = i3;
            jSONObject2.put("down_y", (int) ((aVar2.o.f / f2) * 1000.0f));
            jSONObject2.put("up_x", (int) ((aVar2.o.g / f) * 1000.0f));
            jSONObject2.put("up_y", (int) ((aVar2.o.h / f2) * 1000.0f));
        } else {
            float f3 = i2;
            jSONObject2.put("down_x", (int) ((aVar2.e / f3) * 1000.0f));
            float f4 = i3;
            jSONObject2.put("down_y", (int) ((aVar2.f / f4) * 1000.0f));
            jSONObject2.put("up_x", (int) ((aVar2.g / f3) * 1000.0f));
            jSONObject2.put("up_y", (int) ((aVar2.h / f4) * 1000.0f));
        }
        try {
            strEncode = URLEncoder.encode(jSONObject.toString(), "utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            strEncode = "{}";
        }
        String str29 = strEncode;
        try {
            strEncode2 = URLEncoder.encode(jSONObject2.toString(), "utf-8");
        } catch (Throwable th2) {
            th2.printStackTrace();
            strEncode2 = "{}";
        }
        String str30 = strEncode2;
        boolean z7 = str.contains("__SLD__") || str.contains("__DOWN_X__") || str.contains("__RE_DOWN_X__") || str.contains("__DOWN_Y__") || str.contains("__RE_DOWN_Y__") || str.contains("__UP_X__") || str.contains("__RE_UP_X__") || str.contains("__UP_Y__") || str.contains("__RE_UP_Y__") || str.contains("__DOWN_X_DT__") || str.contains("__RE_DOWN_X_DT__") || str.contains("__DOWN_Y_DT__") || str.contains("__RE_DOWN_Y_DT__") || str.contains("__UP_X_DT__") || str.contains("__RE_UP_X_DT__") || str.contains("__UP_Y_DT__") || str.contains("__RE_UP_Y_DT__");
        if (!str.contains("__C_SLD__") && !str.contains("__C_DOWN_X__") && !str.contains("__RE_C_DOWN_X__") && !str.contains("__C_DOWN_Y__") && !str.contains("__RE_C_DOWN_Y__") && !str.contains("__C_UP_X__") && !str.contains("__RE_C_UP_X__") && !str.contains("__C_UP_Y__") && !str.contains("__RE_C_UP_Y__") && !str.contains("__C_DOWN_X_DT__") && !str.contains("__RE_C_DOWN_X_DT__") && !str.contains("__C_DOWN_Y_DT__") && !str.contains("__RE_C_DOWN_Y_DT__") && !str.contains("__C_UP_X_DT__") && !str.contains("__RE_C_UP_X_DT__")) {
            str2 = "__C_UP_Y_DT__";
            if (!str.contains(str2)) {
                str3 = "__RE_C_UP_X_DT__";
                str4 = "__RE_C_UP_Y_DT__";
                if (!str.contains(str4)) {
                    z2 = false;
                }
                if (z7 || !z2) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r22v0 com.anythink.basead.d.a
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                    */
                /*
                    Method dump skipped, instruction units count: 3076
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.b.j.a(java.lang.String, com.anythink.basead.d.j, com.anythink.core.common.h.w, boolean):java.lang.String");
            }

            private static boolean a(String str) {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                try {
                    return new JSONObject(str).length() <= 0;
                } catch (Throwable unused) {
                }
            }

            private static String a(com.anythink.basead.b.e.b bVar, String str, String str2) {
                return bVar != null ? bVar.a(str, str2) : str2;
            }
        }
