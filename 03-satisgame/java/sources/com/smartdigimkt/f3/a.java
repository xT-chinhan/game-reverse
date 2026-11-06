package com.smartdigimkt.f3;

import android.text.TextUtils;
import android.view.View;
import com.anythink.core.common.k;
import com.anythink.core.common.l.f;
import com.anythink.core.e.l;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.smartdigimkt.b3.h;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.bridge.entity.AppInfoEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Cloneable {
    public int A0;
    public int B0;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public String K;
    public String L;
    public int N;
    public String O;
    public String Q;
    public double R;
    public double S;
    public double T;
    public String U;
    public String V;
    public int W;
    public String X;
    public int Z;
    public transient com.smartdigimkt.p3.e a;
    public int a0;
    public String b;
    public String b0;
    public String c;
    public double c0;
    public String d;
    public double d0;
    public String e;
    public long e0;
    public int f;
    public long f0;
    public int g;
    public long g0;
    public long h0;
    public long j0;
    public long k0;
    public int l;
    public long l0;
    public JSONObject m;
    public long m0;
    public String n;
    public boolean n0;
    public long o;
    public int o0;
    public long p;
    public int p0;
    public String q;
    public String q0;
    public String r;
    public long r0;
    public long s;
    public int s0;
    public long t;
    public long u;
    public int u0;
    public int x0;
    public int y;
    public int y0;
    public int z0;
    public int h = -1;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public boolean v = false;
    public String w = "";
    public int x = 0;
    public int z = 1;
    public int A = 13;
    public boolean B = false;
    public boolean C = false;
    public String J = "";
    public String M = "Adx";
    public int P = 66;
    public int Y = 1;
    public int i0 = 0;
    public String t0 = "";
    public String v0 = "";
    public String w0 = "";
    public String C0 = "";
    public String D0 = "";
    public String E0 = "";

    public final void a(View view, com.smartdigimkt.b3.c cVar, int i, boolean z) {
        com.smartdigimkt.b3.e eVar;
        this.y0 = view == null ? 0 : view.getWidth();
        this.z0 = view != null ? view.getHeight() : 0;
        this.A0 = i;
        this.B0 = z ? 1 : 0;
        if (cVar != null && (eVar = cVar.w) != null) {
            int i2 = eVar.s1;
            this.C0 = i2 > 0 ? String.valueOf(i2) : "";
        }
        long j = this.m0;
        this.D0 = j > 0 ? String.valueOf(j) : "";
    }

    public final void b(JSONObject jSONObject) {
        try {
            jSONObject.put("dd_ori_price", String.valueOf(this.d0));
            jSONObject.put(k.aP, String.valueOf(this.c0));
        } catch (Throwable unused) {
        }
    }

    public final void c(JSONObject jSONObject) throws JSONException {
        jSONObject.put("cl_imp", this.B0);
        jSONObject.put("material_type", this.A0);
        jSONObject.put("render_width", this.y0);
        jSONObject.put("render_height", this.z0);
        jSONObject.put("h5_template_id", this.C0);
        jSONObject.put("template_id", this.D0);
    }

    public final void d(JSONObject jSONObject, int i) {
        try {
            boolean z = this.n0 && h.a(this.l0);
            if (i != 1) {
                if (i != 2) {
                    if (i == 4) {
                        String strValueOf = "";
                        long j = this.l0;
                        if (j <= 0 || z) {
                            long j2 = this.m0;
                            if (j2 > 0) {
                                strValueOf = String.valueOf(j2);
                            }
                        } else {
                            strValueOf = String.valueOf(j);
                        }
                        jSONObject.put("template_id", strValueOf);
                        return;
                    }
                    if (i != 6 && i != 11) {
                        if (i != 13 && i != 29) {
                            if (i != 8 && i != 9) {
                                if (i != 24) {
                                    if (i != 25) {
                                        return;
                                    }
                                    long j3 = this.l0;
                                    if (j3 <= 0 || !h.a(j3) || this.n0) {
                                        return;
                                    }
                                    jSONObject.put("template_id", this.l0);
                                    int i2 = this.o0;
                                    if (i2 > 0) {
                                        jSONObject.put("r_t_t", i2);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
                long j4 = this.m0;
                if (j4 > 0) {
                    jSONObject.put("template_id", j4);
                    return;
                }
                return;
            }
            long j5 = this.l0;
            if (j5 <= 0 || z) {
                return;
            }
            jSONObject.put("template_id", j5);
        } catch (Throwable unused) {
        }
    }

    public final void b(JSONObject jSONObject, int i) {
        if (i != 6) {
            return;
        }
        try {
            if (this.B) {
                this.C = true;
                jSONObject.put("type", 28);
            }
        } catch (Throwable unused) {
        }
    }

    public final void c(JSONObject jSONObject, int i) {
        try {
            if (TextUtils.equals(this.d, "0")) {
                if (i == 1 || i == 4 || i == 30 || i == 6) {
                    int i2 = this.D;
                    if (i2 > 0) {
                        jSONObject.put("render_type", i2);
                    }
                    int i3 = this.E;
                    if (i3 > 0) {
                        jSONObject.put("template_type", i3);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x03f7 A[Catch: Exception -> 0x04ba, TryCatch #0 {Exception -> 0x04ba, blocks: (B:40:0x00e2, B:42:0x00ee, B:43:0x00fa, B:45:0x0102, B:46:0x0109, B:48:0x010d, B:49:0x0112, B:51:0x011b, B:52:0x0120, B:72:0x016c, B:73:0x01b5, B:74:0x01e4, B:78:0x0204, B:77:0x01fd, B:79:0x021f, B:80:0x0249, B:81:0x0277, B:106:0x03ce, B:108:0x03f7, B:110:0x0409, B:112:0x040d, B:113:0x0414, B:115:0x0418, B:116:0x041d, B:118:0x0421, B:119:0x0426, B:121:0x042f, B:122:0x0432, B:124:0x0448, B:125:0x045d, B:127:0x0465, B:128:0x046c, B:130:0x0470, B:131:0x0475, B:133:0x0479, B:134:0x047e, B:97:0x03a8, B:99:0x03b6, B:100:0x03bb, B:102:0x03bf, B:105:0x03c7, B:84:0x02ae, B:85:0x02e8, B:87:0x0336, B:88:0x033b, B:90:0x0348, B:91:0x035d, B:93:0x0365, B:94:0x036c, B:95:0x0374, B:135:0x0482, B:136:0x0487, B:137:0x04b5), top: B:148:0x00e2, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0418 A[Catch: Exception -> 0x04ba, TryCatch #0 {Exception -> 0x04ba, blocks: (B:40:0x00e2, B:42:0x00ee, B:43:0x00fa, B:45:0x0102, B:46:0x0109, B:48:0x010d, B:49:0x0112, B:51:0x011b, B:52:0x0120, B:72:0x016c, B:73:0x01b5, B:74:0x01e4, B:78:0x0204, B:77:0x01fd, B:79:0x021f, B:80:0x0249, B:81:0x0277, B:106:0x03ce, B:108:0x03f7, B:110:0x0409, B:112:0x040d, B:113:0x0414, B:115:0x0418, B:116:0x041d, B:118:0x0421, B:119:0x0426, B:121:0x042f, B:122:0x0432, B:124:0x0448, B:125:0x045d, B:127:0x0465, B:128:0x046c, B:130:0x0470, B:131:0x0475, B:133:0x0479, B:134:0x047e, B:97:0x03a8, B:99:0x03b6, B:100:0x03bb, B:102:0x03bf, B:105:0x03c7, B:84:0x02ae, B:85:0x02e8, B:87:0x0336, B:88:0x033b, B:90:0x0348, B:91:0x035d, B:93:0x0365, B:94:0x036c, B:95:0x0374, B:135:0x0482, B:136:0x0487, B:137:0x04b5), top: B:148:0x00e2, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0421 A[Catch: Exception -> 0x04ba, TryCatch #0 {Exception -> 0x04ba, blocks: (B:40:0x00e2, B:42:0x00ee, B:43:0x00fa, B:45:0x0102, B:46:0x0109, B:48:0x010d, B:49:0x0112, B:51:0x011b, B:52:0x0120, B:72:0x016c, B:73:0x01b5, B:74:0x01e4, B:78:0x0204, B:77:0x01fd, B:79:0x021f, B:80:0x0249, B:81:0x0277, B:106:0x03ce, B:108:0x03f7, B:110:0x0409, B:112:0x040d, B:113:0x0414, B:115:0x0418, B:116:0x041d, B:118:0x0421, B:119:0x0426, B:121:0x042f, B:122:0x0432, B:124:0x0448, B:125:0x045d, B:127:0x0465, B:128:0x046c, B:130:0x0470, B:131:0x0475, B:133:0x0479, B:134:0x047e, B:97:0x03a8, B:99:0x03b6, B:100:0x03bb, B:102:0x03bf, B:105:0x03c7, B:84:0x02ae, B:85:0x02e8, B:87:0x0336, B:88:0x033b, B:90:0x0348, B:91:0x035d, B:93:0x0365, B:94:0x036c, B:95:0x0374, B:135:0x0482, B:136:0x0487, B:137:0x04b5), top: B:148:0x00e2, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x042f A[Catch: Exception -> 0x04ba, TryCatch #0 {Exception -> 0x04ba, blocks: (B:40:0x00e2, B:42:0x00ee, B:43:0x00fa, B:45:0x0102, B:46:0x0109, B:48:0x010d, B:49:0x0112, B:51:0x011b, B:52:0x0120, B:72:0x016c, B:73:0x01b5, B:74:0x01e4, B:78:0x0204, B:77:0x01fd, B:79:0x021f, B:80:0x0249, B:81:0x0277, B:106:0x03ce, B:108:0x03f7, B:110:0x0409, B:112:0x040d, B:113:0x0414, B:115:0x0418, B:116:0x041d, B:118:0x0421, B:119:0x0426, B:121:0x042f, B:122:0x0432, B:124:0x0448, B:125:0x045d, B:127:0x0465, B:128:0x046c, B:130:0x0470, B:131:0x0475, B:133:0x0479, B:134:0x047e, B:97:0x03a8, B:99:0x03b6, B:100:0x03bb, B:102:0x03bf, B:105:0x03c7, B:84:0x02ae, B:85:0x02e8, B:87:0x0336, B:88:0x033b, B:90:0x0348, B:91:0x035d, B:93:0x0365, B:94:0x036c, B:95:0x0374, B:135:0x0482, B:136:0x0487, B:137:0x04b5), top: B:148:0x00e2, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0448 A[Catch: Exception -> 0x04ba, TryCatch #0 {Exception -> 0x04ba, blocks: (B:40:0x00e2, B:42:0x00ee, B:43:0x00fa, B:45:0x0102, B:46:0x0109, B:48:0x010d, B:49:0x0112, B:51:0x011b, B:52:0x0120, B:72:0x016c, B:73:0x01b5, B:74:0x01e4, B:78:0x0204, B:77:0x01fd, B:79:0x021f, B:80:0x0249, B:81:0x0277, B:106:0x03ce, B:108:0x03f7, B:110:0x0409, B:112:0x040d, B:113:0x0414, B:115:0x0418, B:116:0x041d, B:118:0x0421, B:119:0x0426, B:121:0x042f, B:122:0x0432, B:124:0x0448, B:125:0x045d, B:127:0x0465, B:128:0x046c, B:130:0x0470, B:131:0x0475, B:133:0x0479, B:134:0x047e, B:97:0x03a8, B:99:0x03b6, B:100:0x03bb, B:102:0x03bf, B:105:0x03c7, B:84:0x02ae, B:85:0x02e8, B:87:0x0336, B:88:0x033b, B:90:0x0348, B:91:0x035d, B:93:0x0365, B:94:0x036c, B:95:0x0374, B:135:0x0482, B:136:0x0487, B:137:0x04b5), top: B:148:0x00e2, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0465 A[Catch: Exception -> 0x04ba, TryCatch #0 {Exception -> 0x04ba, blocks: (B:40:0x00e2, B:42:0x00ee, B:43:0x00fa, B:45:0x0102, B:46:0x0109, B:48:0x010d, B:49:0x0112, B:51:0x011b, B:52:0x0120, B:72:0x016c, B:73:0x01b5, B:74:0x01e4, B:78:0x0204, B:77:0x01fd, B:79:0x021f, B:80:0x0249, B:81:0x0277, B:106:0x03ce, B:108:0x03f7, B:110:0x0409, B:112:0x040d, B:113:0x0414, B:115:0x0418, B:116:0x041d, B:118:0x0421, B:119:0x0426, B:121:0x042f, B:122:0x0432, B:124:0x0448, B:125:0x045d, B:127:0x0465, B:128:0x046c, B:130:0x0470, B:131:0x0475, B:133:0x0479, B:134:0x047e, B:97:0x03a8, B:99:0x03b6, B:100:0x03bb, B:102:0x03bf, B:105:0x03c7, B:84:0x02ae, B:85:0x02e8, B:87:0x0336, B:88:0x033b, B:90:0x0348, B:91:0x035d, B:93:0x0365, B:94:0x036c, B:95:0x0374, B:135:0x0482, B:136:0x0487, B:137:0x04b5), top: B:148:0x00e2, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0470 A[Catch: Exception -> 0x04ba, TryCatch #0 {Exception -> 0x04ba, blocks: (B:40:0x00e2, B:42:0x00ee, B:43:0x00fa, B:45:0x0102, B:46:0x0109, B:48:0x010d, B:49:0x0112, B:51:0x011b, B:52:0x0120, B:72:0x016c, B:73:0x01b5, B:74:0x01e4, B:78:0x0204, B:77:0x01fd, B:79:0x021f, B:80:0x0249, B:81:0x0277, B:106:0x03ce, B:108:0x03f7, B:110:0x0409, B:112:0x040d, B:113:0x0414, B:115:0x0418, B:116:0x041d, B:118:0x0421, B:119:0x0426, B:121:0x042f, B:122:0x0432, B:124:0x0448, B:125:0x045d, B:127:0x0465, B:128:0x046c, B:130:0x0470, B:131:0x0475, B:133:0x0479, B:134:0x047e, B:97:0x03a8, B:99:0x03b6, B:100:0x03bb, B:102:0x03bf, B:105:0x03c7, B:84:0x02ae, B:85:0x02e8, B:87:0x0336, B:88:0x033b, B:90:0x0348, B:91:0x035d, B:93:0x0365, B:94:0x036c, B:95:0x0374, B:135:0x0482, B:136:0x0487, B:137:0x04b5), top: B:148:0x00e2, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0479 A[Catch: Exception -> 0x04ba, TryCatch #0 {Exception -> 0x04ba, blocks: (B:40:0x00e2, B:42:0x00ee, B:43:0x00fa, B:45:0x0102, B:46:0x0109, B:48:0x010d, B:49:0x0112, B:51:0x011b, B:52:0x0120, B:72:0x016c, B:73:0x01b5, B:74:0x01e4, B:78:0x0204, B:77:0x01fd, B:79:0x021f, B:80:0x0249, B:81:0x0277, B:106:0x03ce, B:108:0x03f7, B:110:0x0409, B:112:0x040d, B:113:0x0414, B:115:0x0418, B:116:0x041d, B:118:0x0421, B:119:0x0426, B:121:0x042f, B:122:0x0432, B:124:0x0448, B:125:0x045d, B:127:0x0465, B:128:0x046c, B:130:0x0470, B:131:0x0475, B:133:0x0479, B:134:0x047e, B:97:0x03a8, B:99:0x03b6, B:100:0x03bb, B:102:0x03bf, B:105:0x03c7, B:84:0x02ae, B:85:0x02e8, B:87:0x0336, B:88:0x033b, B:90:0x0348, B:91:0x035d, B:93:0x0365, B:94:0x036c, B:95:0x0374, B:135:0x0482, B:136:0x0487, B:137:0x04b5), top: B:148:0x00e2, outer: #1 }] */
    public final JSONObject a(int i) {
        Object obj;
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i);
            jSONObject.put("is_only_adx", this.v ? 2 : 1);
            jSONObject.put("adx_sdk_ver", SDMSDK.getInstance().getSDKVersion());
            Object mediationVersion = "";
            if (this.v) {
                if (!TextUtils.isEmpty(this.w)) {
                    mediationVersion = this.w;
                } else {
                    AppInfoEntity appInfoEntity = com.smartdigimkt.r4.h.X;
                    if (appInfoEntity != null && !TextUtils.isEmpty(appInfoEntity.getMediationVersion())) {
                        mediationVersion = appInfoEntity.getMediationVersion();
                    }
                }
            }
            jSONObject.put("sdk_ver", mediationVersion);
            if (i == 10 || i == 11) {
                jSONObject.put("pl_s_sw", this.Y);
            }
            jSONObject.put(f.bn, this.b);
            jSONObject.put("req_id", this.c);
            if (!TextUtils.isEmpty(this.d)) {
                jSONObject.put(com.anythink.core.common.f.a.C0017a.d, Integer.parseInt(this.d));
            }
            jSONObject.put("ps_id", SDKContext.getInstance().f());
            String strB = SDKContext.getInstance().b(this.b);
            if (!TextUtils.isEmpty(strB)) {
                jSONObject.put("sessionid", strB);
            }
            jSONObject.put("asid", this.e);
            Object obj2 = this.m;
            if (obj2 != null) {
                jSONObject.put(l.a.aa, obj2);
            }
            jSONObject.put("wf2_mode", 2);
            if (!TextUtils.isEmpty(this.n)) {
                jSONObject.put("x_c", new JSONArray(this.n));
            }
            if (TextUtils.isEmpty(this.r)) {
                obj = this.c;
            } else {
                obj = this.r;
            }
            jSONObject.put("o_r", obj);
            try {
                jSONObject.put("nw_ver", this.L);
                int i7 = this.h;
                if (i7 != -1) {
                    jSONObject.put("refresh", i7);
                    jSONObject.put("refresh_v2", this.h);
                }
                if (!TextUtils.isEmpty(this.X)) {
                    jSONObject.put("tp_bid_id", this.X);
                }
                int i8 = this.N;
                if (i8 > 0) {
                    jSONObject.put("ads_list_type", i8);
                }
                jSONObject.put(f.bh, 1);
                int i9 = this.l;
                if (i9 > 0) {
                    jSONObject.put("s_type", i9);
                }
                jSONObject.put("network_pl_id", this.b);
                SDKContext.getInstance().getClass();
                jSONObject.put(f.bB, -1);
                if (i == 24) {
                    a(jSONObject, false);
                } else if (i == 25) {
                    jSONObject.put("unit_id", this.Q);
                    jSONObject.put("nw_firm_id", this.P);
                    jSONObject.put("auto_req", this.j);
                    jSONObject.put("bidtype", this.a0);
                    jSONObject.put("bidprice_cny", String.valueOf(this.S));
                    jSONObject.put("unit_type", this.Z);
                    b(jSONObject);
                    jSONObject.put("network_pl_id", this.b);
                    a(jSONObject);
                } else if (i != 29) {
                    if (i == 30) {
                        str = "material_type";
                    } else if (i == 1) {
                        jSONObject.put("unit_id", this.Q);
                        jSONObject.put("nw_firm_id", this.P);
                        jSONObject.put("auto_req", this.j);
                        jSONObject.put("bidtype", this.a0);
                        jSONObject.put("bidprice", String.valueOf(this.R));
                        jSONObject.put("bidprice_cny", String.valueOf(this.S));
                        jSONObject.put("unit_type", this.Z);
                        b(jSONObject);
                        a(jSONObject);
                    } else if (i == 2) {
                        jSONObject.put("unit_id", this.Q);
                        jSONObject.put("nw_firm_id", this.P);
                        jSONObject.put("auto_req", this.j);
                        jSONObject.put("status", this.i);
                        jSONObject.put("flag", this.k);
                        jSONObject.put("bidtype", this.a0);
                        jSONObject.put("bidprice", String.valueOf(this.R));
                        jSONObject.put("bidprice_cny", String.valueOf(this.S));
                        jSONObject.put("ft_t", this.g0);
                        jSONObject.put("filled_t", this.h0);
                        jSONObject.put("filledtime", this.f0);
                        jSONObject.put("data_ft", this.e0);
                        int i10 = this.i0;
                        if (i10 > 0) {
                            jSONObject.put("material_type", i10);
                        }
                        jSONObject.put("unit_type", this.Z);
                        if (!TextUtils.isEmpty(this.U)) {
                            jSONObject.put(k.aU, this.U);
                            jSONObject.put("e_c_key_id", this.W);
                            jSONObject.put(l.a.aA, this.b0);
                        }
                        if (!TextUtils.isEmpty(this.V)) {
                            jSONObject.put(k.aV, this.V);
                        }
                        a(jSONObject);
                        b(jSONObject);
                    } else if (i == 3) {
                        jSONObject.put("unit_id", this.Q);
                        jSONObject.put("nw_firm_id", this.P);
                        jSONObject.put("auto_req", this.j);
                        jSONObject.put("status", this.i);
                        jSONObject.put("flag", this.k);
                        jSONObject.put("bidtype", this.a0);
                        jSONObject.put("bidprice", String.valueOf(this.R));
                        jSONObject.put("bidprice_cny", String.valueOf(this.S));
                        jSONObject.put("unit_type", this.Z);
                        a(jSONObject);
                    } else if (i != 4) {
                        switch (i) {
                            case 6:
                                str = "material_type";
                                jSONObject.put("unit_id", this.Q);
                                jSONObject.put("nw_firm_id", this.P);
                                jSONObject.put("auto_req", this.j);
                                jSONObject.put("bidtype", this.a0);
                                jSONObject.put("bidprice_cny", String.valueOf(this.S));
                                jSONObject.put(k.aq, String.valueOf(this.T));
                                if (i == 6) {
                                    jSONObject.put("cl_s_type", this.z);
                                    jSONObject.put("cl_area", this.A);
                                    if (this.C && !this.B) {
                                        jSONObject.put("tk_x_cl_sent", "1");
                                    }
                                }
                                i2 = this.H;
                                if (i2 > 0) {
                                    jSONObject.put("render_type_video", i2);
                                }
                                i3 = this.I;
                                if (i3 > 0) {
                                    jSONObject.put("close_button_m", i3);
                                }
                                jSONObject.put("unit_type", this.Z);
                                i4 = this.i0;
                                if (i4 > 0) {
                                    jSONObject.put(str, i4);
                                }
                                b(jSONObject);
                                jSONObject.put("nv_tmpl_id", String.valueOf(this.y));
                                if (!TextUtils.isEmpty(this.U)) {
                                    jSONObject.put(k.aU, this.U);
                                    jSONObject.put("e_c_key_id", this.W);
                                    jSONObject.put(l.a.aA, this.b0);
                                }
                                if (!TextUtils.isEmpty(this.V)) {
                                    jSONObject.put(k.aV, this.V);
                                }
                                i5 = this.G;
                                if (i5 > 0) {
                                    jSONObject.put("cls_style", i5);
                                }
                                i6 = this.F;
                                if (i6 > 0) {
                                    jSONObject.put("iv_template_id", i6);
                                }
                                a(jSONObject);
                                break;
                            case 7:
                                jSONObject.put("unit_id", this.Q);
                                jSONObject.put("nw_firm_id", this.P);
                                jSONObject.put("auto_req", this.j);
                                jSONObject.put("bidtype", this.a0);
                                jSONObject.put("bidprice", String.valueOf(this.R));
                                jSONObject.put("bidprice_cny", String.valueOf(this.S));
                                jSONObject.put("unit_type", this.Z);
                                b(jSONObject);
                            case 8:
                            case 9:
                                jSONObject.put("unit_id", this.Q);
                                jSONObject.put("nw_firm_id", this.P);
                                jSONObject.put("auto_req", this.j);
                                jSONObject.put("bidtype", this.a0);
                                jSONObject.put("bidprice_cny", String.valueOf(this.S));
                                jSONObject.put("unit_type", this.Z);
                                b(jSONObject);
                                jSONObject.put("network_pl_id", this.b);
                                a(jSONObject);
                                break;
                            case 10:
                                jSONObject.put("isload", 1);
                                jSONObject.put("req_par", 0);
                                jSONObject.put("req_par_num", 1);
                                jSONObject.put("load_start_t", this.s);
                                jSONObject.put("req_st_t", this.t);
                                jSONObject.put("st_succ_t", this.u);
                                jSONObject.put("cache_st_type", 0);
                                break;
                            case 11:
                                jSONObject.put("auto_req", this.j);
                                jSONObject.put("bidrequesttime", this.o);
                                jSONObject.put("bidresponselist", TextUtils.isEmpty(this.q) ? "[]" : new JSONArray(this.q));
                                jSONObject.put("ft_t", this.g0);
                                jSONObject.put("bidresponsetime", this.p);
                                jSONObject.put("data_bidresponsetime", this.p);
                                a(jSONObject);
                                break;
                            case 12:
                                jSONObject.put("loadtime", this.f0);
                                jSONObject.put("unit_id", this.Q);
                                jSONObject.put("bidprice", String.valueOf(this.R));
                                jSONObject.put("bidprice_cny", String.valueOf(this.S));
                                jSONObject.put("load_t", this.h0);
                                jSONObject.put("req_par", 0);
                                jSONObject.put("req_par_num", 1);
                                break;
                            case 13:
                                jSONObject.put("unit_id", this.Q);
                                jSONObject.put("nw_firm_id", this.P);
                                jSONObject.put("bidtype", this.a0);
                                jSONObject.put("bidprice", String.valueOf(this.R));
                                jSONObject.put("bidprice_cny", String.valueOf(this.S));
                                jSONObject.put(k.aq, String.valueOf(this.T));
                                jSONObject.put("new_req_id", this.c);
                                jSONObject.put("auto_req", this.j);
                                jSONObject.put("req_id_match", 0);
                                jSONObject.put("unit_type", this.Z);
                                b(jSONObject);
                                a(jSONObject);
                                break;
                        }
                    } else {
                        str = "material_type";
                    }
                    jSONObject.put("cl_imp", this.f);
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("render_w_h", (Object) null);
                    }
                    int i11 = this.x;
                    if (i11 > 0) {
                        jSONObject.put("offer_install", i11);
                    }
                    if (i == 4) {
                        jSONObject.put("h5_template_id", this.E0);
                    }
                    jSONObject.put("unit_id", this.Q);
                    jSONObject.put("nw_firm_id", this.P);
                    jSONObject.put("auto_req", this.j);
                    jSONObject.put("bidtype", this.a0);
                    jSONObject.put("bidprice_cny", String.valueOf(this.S));
                    jSONObject.put(k.aq, String.valueOf(this.T));
                    if (i == 6) {
                        jSONObject.put("cl_s_type", this.z);
                        jSONObject.put("cl_area", this.A);
                        if (this.C) {
                            jSONObject.put("tk_x_cl_sent", "1");
                        }
                    }
                    i2 = this.H;
                    if (i2 > 0) {
                        jSONObject.put("render_type_video", i2);
                    }
                    i3 = this.I;
                    if (i3 > 0) {
                        jSONObject.put("close_button_m", i3);
                    }
                    jSONObject.put("unit_type", this.Z);
                    i4 = this.i0;
                    if (i4 > 0) {
                        jSONObject.put(str, i4);
                    }
                    b(jSONObject);
                    jSONObject.put("nv_tmpl_id", String.valueOf(this.y));
                    if (!TextUtils.isEmpty(this.U)) {
                        jSONObject.put(k.aU, this.U);
                        jSONObject.put("e_c_key_id", this.W);
                        jSONObject.put(l.a.aA, this.b0);
                    }
                    if (!TextUtils.isEmpty(this.V)) {
                        jSONObject.put(k.aV, this.V);
                    }
                    i5 = this.G;
                    if (i5 > 0) {
                        jSONObject.put("cls_style", i5);
                    }
                    i6 = this.F;
                    if (i6 > 0) {
                        jSONObject.put("iv_template_id", i6);
                    }
                    a(jSONObject);
                } else {
                    a(jSONObject, true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            a(jSONObject, i);
            c(jSONObject, i);
            b(jSONObject, i);
            d(jSONObject, i);
            if (i == 30) {
                c(jSONObject);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final a a() {
        try {
            return (a) clone();
        } catch (Throwable unused) {
            return this;
        }
    }

    public final void a(long j, com.smartdigimkt.b3.l lVar, com.smartdigimkt.a3.a aVar) {
        this.l0 = h.a(j, lVar, aVar);
        if (j <= 0) {
            j = 0;
        }
        this.m0 = j;
    }

    public final void a(JSONObject jSONObject, boolean z) throws JSONException {
        int i = this.p0;
        if (i == 1 || i == 2) {
            JSONObject jSONObject2 = new JSONObject();
            int i2 = this.s0;
            if (i2 <= 0) {
                i2 = 4;
            }
            jSONObject2.put("post_t", i2);
            jSONObject2.put("t", this.p0);
            long jCurrentTimeMillis = this.r0;
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            jSONObject2.put("ts", jCurrentTimeMillis);
            if (this.p0 == 2 && !TextUtils.isEmpty(this.t0)) {
                jSONObject2.put(MediationConstant.KEY_REASON, this.t0);
            }
            if (z) {
                jSONObject2.put("dsp_id", this.x0);
                if (this.p0 == 2 && "1".equals(this.t0)) {
                    int i3 = this.u0;
                    if (i3 > 0) {
                        jSONObject2.put("bidder", i3);
                    }
                    if (!TextUtils.isEmpty(this.v0)) {
                        jSONObject2.put("in_price", this.v0);
                    }
                    if (!TextUtils.isEmpty(this.w0)) {
                        jSONObject2.put("usd_price", this.w0);
                    }
                }
                jSONObject.put("notice", jSONObject2);
                return;
            }
            Object obj = TextUtils.isEmpty(this.q0) ? "0" : this.q0;
            jSONObject2.put(com.anythink.core.d.b.e.a.h, obj);
            jSONObject.put("notice", jSONObject2);
            jSONObject.put("bidprice", obj);
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            if (!TextUtils.isEmpty(this.J)) {
                jSONObject.put("deal_type", this.J);
            }
            if (TextUtils.isEmpty(this.K)) {
                return;
            }
            jSONObject.put("deal_id", this.K);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0061 A[Catch: all -> 0x0067, TRY_LEAVE, TryCatch #0 {all -> 0x0067, blocks: (B:7:0x000d, B:9:0x0013, B:11:0x001f, B:12:0x0025, B:14:0x002f, B:28:0x0061, B:17:0x003b, B:19:0x0049, B:24:0x0056), top: B:33:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    public final void a(JSONObject jSONObject, int i) {
        long jLongValue;
        com.smartdigimkt.n3.b bVarA = com.smartdigimkt.n3.b.a();
        try {
            if (i != 4) {
                if (i == 6 && this.P == 66) {
                    bVarA.getClass();
                    long j = this.k0 - this.j0;
                    if (j > 0) {
                        jSONObject.put("s_c_interval", j);
                        return;
                    }
                    return;
                }
                return;
            }
            if ("0".equals(this.d)) {
                return;
            }
            bVarA.getClass();
            if (!TextUtils.isEmpty(this.b)) {
                long j2 = this.j0;
                Long l = (Long) bVarA.a.get(this.b);
                if (l != null && l.longValue() != 0 && j2 != 0) {
                    jLongValue = j2 - l.longValue();
                }
                if (jLongValue > 0) {
                    jSONObject.put("pl_show_interval", jLongValue);
                }
            }
            jLongValue = 0;
            if (jLongValue > 0) {
                jSONObject.put("pl_show_interval", jLongValue);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
