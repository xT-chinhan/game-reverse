package com.smartdigimkt.f3;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.d.f;
import com.anythink.core.e.l;
import com.smartdigimkt.sdk.core.SDKContext;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends e {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public JSONObject K;
    public String L;
    public int M = -1;
    public int N = -1;
    public int O = -1;
    public JSONObject P;
    public String Q;
    public String R;
    public String S;
    public int T;
    public String U;
    public boolean V;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public c() {
        SDKContext.getInstance().getClass();
        this.T = -1;
    }

    public final void a(com.smartdigimkt.a3.a aVar) {
        if (aVar != null) {
            this.b = aVar.g;
            this.c = aVar.b;
            this.f = String.valueOf(aVar.e);
            this.k = String.valueOf(aVar.d);
            this.Q = aVar.i;
            this.R = aVar.h;
            this.T = aVar.m;
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.anythink.core.common.f.e.a.b, this.a);
            jSONObject.put("requestid", this.b);
            jSONObject.put("unitid", this.c);
            jSONObject.put(f.c, this.d);
            jSONObject.put("sessionid", this.e);
            jSONObject.put("groupid", this.f);
            jSONObject.put("unitgroupid", this.g);
            jSONObject.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, this.h);
            jSONObject.put("asid", this.i);
            jSONObject.put("refresh", this.j);
            int i = this.O;
            if (i != -1) {
                jSONObject.put(com.anythink.core.common.l.f.bh, i);
            }
            jSONObject.put("traffic_group_id", this.k);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, this.l);
            jSONObject.put("msg1", this.m);
            jSONObject.put("msg2", this.n);
            jSONObject.put("msg3", this.o);
            jSONObject.put("msg4", this.p);
            jSONObject.put("msg5", this.q);
            jSONObject.put("msg6", this.r);
            jSONObject.put("msg7", this.s);
            jSONObject.put("msg8", this.t);
            jSONObject.put("msg9", this.u);
            jSONObject.put("msg10", this.v);
            jSONObject.put("msg11", this.w);
            jSONObject.put("msg12", this.x);
            jSONObject.put("msg13", this.y);
            jSONObject.put("msg14", this.z);
            jSONObject.put("msg15", this.A);
            jSONObject.put("msg16", this.B);
            jSONObject.put("msg17", this.C);
            jSONObject.put("msg18", this.D);
            jSONObject.put("msg19", this.E);
            jSONObject.put("msg20", this.F);
            jSONObject.put("msg21", (Object) null);
            jSONObject.put("msg22", (Object) null);
            jSONObject.put("msg23", (Object) null);
            jSONObject.put("msg24", (Object) null);
            jSONObject.put("msg25", (Object) null);
            jSONObject.put(l.a.T, this.I);
            jSONObject.put(com.anythink.core.common.l.f.aj, this.J);
            JSONObject jSONObject2 = this.K;
            if (jSONObject2 != null) {
                jSONObject.put(l.a.aa, jSONObject2);
            }
            jSONObject.put("real_p", this.L);
            int i2 = this.M;
            if (i2 != -1) {
                jSONObject.put("real_g", i2);
            }
            int i3 = this.N;
            if (i3 != -1) {
                jSONObject.put("real_t", i3);
            }
            JSONObject jSONObject3 = this.P;
            if (jSONObject3 != null) {
                jSONObject.put("adap_c", jSONObject3);
            }
            if (!TextUtils.isEmpty(this.Q)) {
                jSONObject.put("x_c", new JSONArray(this.Q));
            }
            if (!TextUtils.isEmpty(this.R)) {
                jSONObject.put("o_r", this.R);
            }
            if (!TextUtils.isEmpty(this.S)) {
                jSONObject.put("tp_bid_id_req_id", this.S);
            }
            if (!this.V) {
                jSONObject.put(com.anythink.core.common.l.f.bB, this.T);
            }
            if (!TextUtils.isEmpty(this.U)) {
                jSONObject.put("link_type", this.U);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public c(String str, String str2) {
        SDKContext.getInstance().getClass();
        this.T = -1;
        this.G = str;
        this.H = str2;
    }

    public final void a(a aVar) {
        String str;
        if (aVar != null) {
            this.b = aVar.c;
            this.c = aVar.b;
            this.G = aVar.d;
            this.j = String.valueOf(aVar.h);
            this.i = aVar.e;
            this.Q = aVar.n;
            if (TextUtils.isEmpty(aVar.r)) {
                str = aVar.c;
            } else {
                str = aVar.r;
            }
            this.R = str;
        }
    }
}
