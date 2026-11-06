package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.runtime.bundle.BundleId;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public String A;
    public String F;
    public String G;
    public HashMap K;
    public HashMap L;
    public String P;
    public String Q;
    public String R;
    public String S;
    public c T;
    public int U;
    public long V;
    public int[] f;
    public String u;
    public String v;
    public String w;
    public String y;
    public String z;
    public boolean a = false;
    public int b = -1;
    public int c = 100;
    public int d = 100;
    public int e = 100;
    public int g = 2;
    public int h = 1;
    public int i = 45;
    public int j = 2;
    public int k = 100;
    public int l = DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
    public float m = 10.0f;
    public int n = 2;
    public int o = 100;
    public int p = 3;
    public int q = 0;
    public int r = 40;
    public int s = 4;
    public int t = 0;
    public int x = 1;
    public int B = 0;
    public int C = 0;
    public int D = 0;
    public int E = 0;
    public int H = 1;
    public final d I = new d();
    public int J = -1;
    public int M = -1;
    public boolean N = true;
    public boolean O = false;

    public final boolean a() {
        int i = this.q;
        return i == 1 || i == 4 || i == 2 || i == 5;
    }

    public final boolean b() {
        int i = this.q;
        return i == 1 || i == 4;
    }

    public final boolean c() {
        int i = this.q;
        return i == 3 || i == 4 || i == 5;
    }

    public final void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = new JSONObject(jSONArray.optJSONObject(i).optString(Constants.VALUE_FIELD));
                    int iOptInt = jSONObject.optInt("act");
                    int iOptInt2 = jSONObject.optInt("ratio", 100);
                    switch (iOptInt) {
                        case 1:
                            this.a = true;
                            int iOptInt3 = jSONObject.optInt(an.aG, this.d);
                            this.d = iOptInt3;
                            if (iOptInt3 < 0 || iOptInt3 > 100) {
                                this.d = 100;
                            }
                            this.e = iOptInt2;
                            break;
                        case 2:
                            this.a = true;
                            this.b = jSONObject.optInt(an.ax, this.b);
                            this.c = iOptInt2;
                            break;
                        case 3:
                            this.a = true;
                            this.q = 2;
                            this.i = jSONObject.optInt(an.av, this.i);
                            this.j = jSONObject.optInt("tws", this.j);
                            this.k = iOptInt2;
                            break;
                        case 4:
                            this.a = true;
                            this.q = 1;
                            this.o = iOptInt2;
                            this.l = jSONObject.optInt("d", this.l);
                            this.n = jSONObject.optInt(an.aF, this.n);
                            this.m = (float) jSONObject.optDouble("ma", this.m);
                            break;
                        default:
                            a(jSONObject);
                            break;
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
        }
    }

    public final void b(String str) {
        if (this.O || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.p = jSONObject.optInt("overallStyle", this.p);
            this.L = new HashMap();
            this.K = new HashMap();
            int iOptInt = jSONObject.optInt("endBtnAnimation", 0);
            if (iOptInt >= 3 && iOptInt <= 5) {
                this.L.put(-1, Integer.valueOf(iOptInt - 2));
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("fullScreenAnimation");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    int iA = gj.a((Object) next, -999);
                    if (iA != -999) {
                        int iOptInt2 = jSONObjectOptJSONObject.optInt(next);
                        if (iOptInt2 >= 3 && iOptInt2 <= 5) {
                            this.L.put(Integer.valueOf(iA), Integer.valueOf(iOptInt2 - 2));
                        } else if (iOptInt2 == 1 || iOptInt2 == 2) {
                            this.K.put(Integer.valueOf(iA), new a(iOptInt2));
                        } else if (iOptInt2 == 6) {
                            this.K.put(Integer.valueOf(iA), new a(3));
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public final void a(JSONObject jSONObject) {
        String str;
        String str2;
        int iOptInt;
        JSONArray jSONArray;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        e eVar = this;
        try {
            eVar.O = true;
            eVar.p = jSONObject.optInt("ctp", eVar.p);
            eVar.q = jSONObject.optInt("ac", eVar.q);
            eVar.i = jSONObject.optInt(an.av, eVar.i);
            eVar.j = jSONObject.optInt("tws", eVar.j);
            eVar.l = jSONObject.optInt("d", eVar.l);
            eVar.n = jSONObject.optInt(an.aF, eVar.n);
            eVar.m = (float) jSONObject.optDouble("ma", eVar.m);
            eVar.r = jSONObject.optInt("sld", eVar.r);
            eVar.s = jSONObject.optInt("slt", eVar.s);
            eVar.t = jSONObject.optInt("ict", eVar.t);
            eVar.u = jSONObject.optString("ccdt", eVar.u);
            eVar.v = jSONObject.optString("rcdt");
            eVar.F = jSONObject.optString("rdct", "关闭");
            eVar.G = jSONObject.optString("rdpct", "关闭");
            d dVar = eVar.I;
            dVar.a = jSONObject.optString("edgt");
            dVar.b = sg.a(jSONObject.optJSONArray("edgtn"));
            dVar.c = jSONObject.optInt("ertr", 1);
            dVar.d = jSONObject.optString("edgpt");
            dVar.e = jSONObject.optString("edgnt");
            eVar.J = jSONObject.optInt("crwt", eVar.J);
            eVar.M = jSONObject.optInt("ped", eVar.M);
            eVar.N = jSONObject.optBoolean("nsdpb", eVar.N);
            eVar.w = jSONObject.optString("rcdi");
            eVar.B = jSONObject.optInt("rcdat", eVar.B);
            eVar.C = jSONObject.optInt("pcdat", eVar.C);
            eVar.z = jSONObject.optString("pcdt");
            eVar.A = jSONObject.optString("pcdi");
            jSONObject.optString("ebft");
            eVar.y = jSONObject.optString("rcdc");
            eVar.D = jSONObject.optInt("ndrt", eVar.D);
            eVar.E = jSONObject.optInt("clsrw", eVar.E);
            eVar.H = jSONObject.optInt("clba", eVar.H);
            eVar.x = jSONObject.optInt("rclba", eVar.x);
            eVar.U = jSONObject.optInt("wit", 0);
            eVar.V = jSONObject.optInt("nrt", 15);
            eVar.f = a(jSONObject.optString("clpx", null), eVar.f);
            eVar.g = jSONObject.optInt("clp", eVar.g);
            eVar.h = jSONObject.optInt("clc", eVar.h);
            eVar.P = jSONObject.optString(BundleKey.TITLE, "");
            String str8 = "rtitle";
            eVar.Q = jSONObject.optString(str8, "");
            eVar.R = jSONObject.optString("otf", "");
            String str9 = "dbt";
            eVar.S = jSONObject.optString(str9, "");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("rwddg");
            String str10 = "edgnt";
            String str11 = "edgpt";
            String str12 = "ertr";
            String str13 = "edgtn";
            if (jSONObjectOptJSONObject == null) {
                str = "otf";
                str2 = "edgt";
                str9 = str9;
            } else {
                c cVar = new c();
                eVar.T = cVar;
                str2 = "edgt";
                cVar.a = jSONObjectOptJSONObject.optString("desc");
                eVar.T.b = jSONObjectOptJSONObject.optString("dgiu", "");
                str = "otf";
                eVar.T.c = jSONObjectOptJSONObject.optInt(com.umeng.analytics.pro.d.W, -1);
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("b1");
                if (jSONObjectOptJSONObject2 != null) {
                    c cVar2 = eVar.T;
                    b bVar = new b();
                    cVar2.d = bVar;
                    bVar.a = jSONObjectOptJSONObject2.optInt(BundleId.STYLE, 0);
                    eVar.T.d.b = jSONObjectOptJSONObject2.optString("n", "");
                    eVar.T.d.c = jSONObjectOptJSONObject2.optInt("action", -1);
                    eVar.T.d.d = jSONObjectOptJSONObject2.optString(BreakpointSQLiteKey.URL, "");
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("b2");
                if (jSONObjectOptJSONObject3 != null) {
                    c cVar3 = eVar.T;
                    b bVar2 = new b();
                    cVar3.e = bVar2;
                    bVar2.a = jSONObjectOptJSONObject3.optInt(BundleId.STYLE, 1);
                    eVar.T.e.b = jSONObjectOptJSONObject3.optString("n", "");
                    eVar.T.e.c = jSONObjectOptJSONObject3.optInt("action", -2);
                    eVar.T.e.d = jSONObjectOptJSONObject3.optString(BreakpointSQLiteKey.URL, "");
                }
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("fsa");
            eVar.K = new HashMap();
            if (jSONArrayOptJSONArray != null) {
                int i = 0;
                while (i < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject4 == null) {
                        jSONArray = jSONArrayOptJSONArray;
                        str3 = str10;
                        str4 = str12;
                        str5 = str2;
                        str6 = str11;
                        str7 = str13;
                    } else {
                        a aVar = new a();
                        jSONArray = jSONArrayOptJSONArray;
                        int iOptInt2 = jSONObjectOptJSONObject4.optInt("type", 0);
                        aVar.a = iOptInt2;
                        if (iOptInt2 == 0) {
                            str3 = str10;
                            str4 = str12;
                            str5 = str2;
                            str6 = str11;
                            str7 = str13;
                        } else {
                            int iOptInt3 = jSONObjectOptJSONObject4.optInt(com.umeng.analytics.pro.d.W, 0);
                            aVar.c = iOptInt3;
                            if (iOptInt3 == 0) {
                                str3 = str10;
                                str4 = str12;
                                str5 = str2;
                                str6 = str11;
                                str7 = str13;
                            } else {
                                aVar.b = jSONObjectOptJSONObject4.optInt("st", 0);
                                aVar.d = jSONObjectOptJSONObject4.optInt("mdg", 0);
                                aVar.e = jSONObjectOptJSONObject4.optInt("ict", aVar.e);
                                aVar.f = jSONObjectOptJSONObject4.optString("dgtu", "");
                                aVar.g = jSONObjectOptJSONObject4.optString("dgiu", "");
                                aVar.h = jSONObjectOptJSONObject4.optString("desc", "");
                                aVar.i = sg.a(jSONObjectOptJSONObject4.optJSONArray(BundleKey.TITLE));
                                aVar.j = sg.a(jSONObjectOptJSONObject4.optJSONArray(str8));
                                aVar.q = jSONObjectOptJSONObject4.optInt("wit", 0);
                                try {
                                    aVar.r = jSONObjectOptJSONObject4.optInt("nrt", 15);
                                    aVar.k = jSONObjectOptJSONObject4.optInt("cls", 0);
                                    int iOptInt4 = jSONObjectOptJSONObject4.optInt("clsst", 0);
                                    aVar.l = iOptInt4;
                                    int i2 = aVar.c;
                                    if (i2 != -1 && iOptInt4 >= i2) {
                                        aVar.k = 0;
                                    }
                                    aVar.m = jSONObjectOptJSONObject4.optInt("dccd", 0);
                                    aVar.n = jSONObjectOptJSONObject4.optString("dccdt", "继续看广告");
                                    String str14 = str9;
                                    aVar.o = jSONObjectOptJSONObject4.optString(str14);
                                    String str15 = str;
                                    aVar.p = jSONObjectOptJSONObject4.optString(str15);
                                    aVar.t = jSONObjectOptJSONObject4.optString("repct");
                                    str9 = str14;
                                    aVar.s = jSONObjectOptJSONObject4.optInt("repc", 0);
                                    d dVar2 = aVar.u;
                                    str = str15;
                                    String str16 = str2;
                                    dVar2.a = jSONObjectOptJSONObject4.optString(str16);
                                    String str17 = str13;
                                    str7 = str17;
                                    dVar2.b = sg.a(jSONObjectOptJSONObject4.optJSONArray(str17));
                                    str5 = str16;
                                    String str18 = str12;
                                    dVar2.c = jSONObjectOptJSONObject4.optInt(str18, 1);
                                    str6 = str11;
                                    dVar2.d = jSONObjectOptJSONObject4.optString(str6);
                                    str3 = str10;
                                    str4 = str18;
                                    dVar2.e = jSONObjectOptJSONObject4.optString(str3);
                                    aVar.v = jSONObjectOptJSONObject4.optInt("push", 0);
                                    aVar.w = jSONObjectOptJSONObject4.optInt("eani", 0);
                                    eVar = this;
                                    eVar.K.put(Integer.valueOf(aVar.b), aVar);
                                } catch (Exception e) {
                                    return;
                                }
                            }
                        }
                    }
                    i++;
                    str11 = str6;
                    str8 = str8;
                    str13 = str7;
                    str2 = str5;
                    str12 = str4;
                    str10 = str3;
                    jSONArrayOptJSONArray = jSONArray;
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("bta");
            eVar.L = new HashMap();
            if (jSONArrayOptJSONArray2 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i3);
                    if (jSONObjectOptJSONObject5 != null && (iOptInt = jSONObjectOptJSONObject5.optInt("type", 0)) != 0) {
                        eVar.L.put(Integer.valueOf(jSONObjectOptJSONObject5.optInt("st", 0)), Integer.valueOf(iOptInt));
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    public static int[] a(String str, int[] iArr) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.trim().replace("×", "*").replace("X", "*").replace("x", "*").split("\\*");
                if (strArrSplit.length == 2) {
                    int i = Integer.parseInt(strArrSplit[0].trim());
                    int i2 = Integer.parseInt(strArrSplit[1].trim());
                    if (i > 0 && i2 > 0) {
                        return new int[]{hk.a(jd.a, i / 2.0f), hk.a(jd.a, i2 / 2.0f)};
                    }
                }
            } catch (Throwable th) {
            }
        }
        return iArr;
    }

    public final int a(int i) {
        Integer num;
        HashMap map = this.L;
        if (map == null || (num = (Integer) map.get(Integer.valueOf(i))) == null) {
            return 0;
        }
        return num.intValue();
    }
}
