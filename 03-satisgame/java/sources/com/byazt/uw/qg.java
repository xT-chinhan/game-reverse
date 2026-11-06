package com.byazt.uw;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.k;
import com.byazt.af.x;
import com.byazt.hb.fs;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1462, 26})
public final class qg {
    public final s n;
    public final List<q> qg;

    public static int n(String str) {
        if ("line".equals(str)) {
            return 1;
        }
        if ("rectangle".equals(str)) {
            return 2;
        }
        if ("circle".equals(str)) {
            return 3;
        }
        return "sphere".equals(str) ? 4 : 0;
    }

    public static int qg(String str) {
        if ("outline".equals(str)) {
            return 1;
        }
        return "surface".equals(str) ? 2 : 0;
    }

    public static int s(String str) {
        if ("rect".equals(str)) {
            return 1;
        }
        return "star".equals(str) ? 2 : 0;
    }

    public static int q(String str) {
        if ("additive".equals(str)) {
            return 1;
        }
        if ("backToFront".equals(str) || "oldestFirst".equals(str)) {
            return 3;
        }
        return "oldestLast".equals(str) ? 4 : 0;
    }

    private qg(s sVar, List<q> list) {
        this.n = sVar;
        this.qg = list;
    }

    public s n() {
        return this.n;
    }

    public List<q> qg() {
        return this.qg;
    }

    public boolean s() {
        List<q> list = this.qg;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static qg n(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return n(context, new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static qg n(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        s sVarN = s.n(jSONObject.optJSONObject("layer"));
        List<q> listN = n(context, jSONObject.optJSONArray("particles"));
        if (listN.isEmpty()) {
            return null;
        }
        return new qg(sVarN, listN);
    }

    private static List<q> n(Context context, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(q.n(context, jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }

    @com.byazt.cp.n(n = {0, 1, 1462, 47})
    public static final class s {
        public final C0368qg fs;
        public final int l;
        public final String n;
        public final int q;
        public final String qg;
        public final C0368qg rv;
        public final String s;
        public final C0368qg tj;
        public final int w;
        public final C0368qg x;

        private s(String str, String str2, String str3, C0368qg c0368qg, C0368qg c0368qg2, C0368qg c0368qg3, C0368qg c0368qg4) {
            this.n = str;
            this.qg = str2;
            this.s = str3;
            this.q = qg.n(str);
            this.l = qg.qg(str2);
            this.w = qg.q(str3);
            this.x = c0368qg;
            this.fs = c0368qg2;
            this.rv = c0368qg3;
            this.tj = c0368qg4;
        }

        public static s n(JSONObject jSONObject) {
            if (jSONObject == null) {
                return n();
            }
            String strOptString = jSONObject.optString("emitterShape", "point");
            String strOptString2 = jSONObject.optString("emitterMode", "points");
            String strOptString3 = jSONObject.optString("renderMode", "unordered");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("emitterPosition");
            C0368qg c0368qgN = C0368qg.n(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt(x.n) : null, new C0368qg(0.5f, true));
            C0368qg c0368qgN2 = C0368qg.n(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt("y") : null, new C0368qg(0.0f, true));
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("emitterSize");
            return new s(strOptString, strOptString2, strOptString3, c0368qgN, c0368qgN2, C0368qg.n(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.opt("w") : null, new C0368qg(1.0f, true)), C0368qg.n(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.opt("h") : null, new C0368qg(1.0f, true)));
        }

        private static s n() {
            return new s("point", "points", "unordered", new C0368qg(0.5f, true), new C0368qg(0.0f, true), new C0368qg(1.0f, true), new C0368qg(1.0f, true));
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1462, 1474})
    public static final class q {
        public final float cp;
        public final n d;
        public final float fs;
        public final float l;
        public final String n;
        public final float q;
        public final float qg;
        public final float rv;
        public final float s;
        public final float tj;
        public final float w;
        public final float x;

        private q(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, n nVar) {
            this.n = str;
            this.qg = f;
            this.s = f2;
            this.q = f3;
            this.l = f4;
            this.w = f5;
            this.x = f6;
            this.fs = f7;
            this.rv = f8;
            this.tj = f9;
            this.cp = f10;
            this.d = nVar;
        }

        public static q n(Context context, JSONObject jSONObject) {
            return new q(jSONObject.optString(TapEventParamConstants.PARAM_NAME, ""), (float) jSONObject.optDouble("birthRate", 1.0d), (float) jSONObject.optDouble("lifetime", 1.0d), (float) jSONObject.optDouble("lifetimeRange", 0.0d), (float) jSONObject.optDouble("scale", 1.0d), (float) jSONObject.optDouble("scaleRange", 0.0d), (float) jSONObject.optDouble("velocity", 0.0d), (float) jSONObject.optDouble("velocityRange", 0.0d), (float) jSONObject.optDouble("emissionRange", 0.0d), (float) jSONObject.optDouble("alphaRange", 0.0d), (float) jSONObject.optDouble("alphaSpeed", 0.0d), n.n(context, jSONObject.optJSONObject(k.D)));
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1462, 48})
    public static final class n {
        public final int l;
        public final String n;
        public final float q;
        public final int qg;
        public final float s;

        private n(String str, float f, float f2, int i) {
            this.n = str;
            this.qg = qg.s(str);
            this.s = f;
            this.q = f2;
            this.l = i;
        }

        public static n n(Context context, JSONObject jSONObject) {
            if (jSONObject == null) {
                return new n("circle", fs.n(context, 6.0f), fs.n(context, 6.0f), -1);
            }
            return new n(jSONObject.optString("shape", "circle"), fs.n(context, (float) jSONObject.optDouble("width", 6.0d)), fs.n(context, (float) jSONObject.optDouble("height", 6.0d)), com.byazt.hb.n.n(jSONObject.optString("color", "#FFFFFF"), -1));
        }
    }

    /* JADX INFO: renamed from: com.byazt.uw.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1462, 201})
    public static final class C0368qg {
        public final float n;
        public final boolean qg;

        public C0368qg(float f, boolean z) {
            this.n = f;
            this.qg = z;
        }

        public static C0368qg n(Object obj, C0368qg c0368qg) {
            if (obj == null) {
                return c0368qg;
            }
            if (obj instanceof Number) {
                return new C0368qg(((Number) obj).floatValue(), false);
            }
            String strTrim = obj.toString().trim();
            if (TextUtils.isEmpty(strTrim)) {
                return c0368qg;
            }
            try {
                if (strTrim.endsWith("%")) {
                    return new C0368qg(Float.parseFloat(strTrim.substring(0, strTrim.length() - 1)) / 100.0f, true);
                }
                return new C0368qg(Float.parseFloat(strTrim), false);
            } catch (NumberFormatException unused) {
                return c0368qg;
            }
        }

        public float n(float f) {
            return this.qg ? f * this.n : this.n;
        }
    }
}
