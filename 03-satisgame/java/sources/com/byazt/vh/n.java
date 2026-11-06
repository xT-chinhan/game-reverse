package com.byazt.vh;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1778, 19})
public class n {
    public long l;
    public String n;
    public long q;
    public float qg;
    public List<C0370n> s;
    public String w;

    public String n() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    public void n(float f) {
        this.qg = f;
    }

    public float qg() {
        return this.qg;
    }

    public List<C0370n> s() {
        return this.s;
    }

    public void n(List<C0370n> list) {
        this.s = list;
    }

    public long q() {
        return this.q;
    }

    public void n(long j) {
        this.q = j;
    }

    public long l() {
        return this.l;
    }

    public void qg(long j) {
        this.l = j;
    }

    public String w() {
        return this.w;
    }

    public void qg(String str) {
        this.w = str;
    }

    public static n n(String str, com.byazt.ih.s sVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return n(new JSONObject(str), sVar);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static n n(JSONObject jSONObject, com.byazt.ih.s sVar) {
        return n(jSONObject, null, sVar);
    }

    public static n n(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.ih.s sVar) {
        if (jSONObject == null) {
            return null;
        }
        n nVar = new n();
        nVar.n(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            nVar.n(-1.0f);
        } else {
            try {
                nVar.n(Float.parseFloat(strOptString));
            } catch (NumberFormatException unused) {
                nVar.n(0.0f);
            }
        }
        nVar.n(jSONObject.optLong(MediationConstant.EXTRA_DURATION, 0L));
        nVar.qg(com.byazt.hb.s.n(com.byazt.mcb.qg.n(jSONObject.optString("startDelay"), sVar.tj()), 0L));
        nVar.qg(jSONObject.optString("loopMode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.byazt.hb.qg.n(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0370n.n(jSONObjectOptJSONObject, sVar));
            }
            nVar.n(arrayList);
        }
        return nVar;
    }

    /* JADX INFO: renamed from: com.byazt.vh.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1778, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0370n {
        public float[] fs;
        public String l;
        public long n;
        public long q;
        public float qg;
        public String rv;
        public String s;
        public String tj;
        public float w;
        public float x;

        public long n() {
            return this.n;
        }

        public void n(long j) {
            this.n = j;
        }

        public float qg() {
            return this.qg;
        }

        public void n(float f) {
            this.qg = f;
        }

        public String s() {
            return this.s;
        }

        public void n(String str) {
            this.s = str;
        }

        public long q() {
            return this.q;
        }

        public void qg(long j) {
            this.q = j;
        }

        public String getType() {
            return this.l;
        }

        public void qg(String str) {
            this.l = str;
        }

        public float l() {
            return this.w;
        }

        public void qg(float f) {
            this.w = f;
        }

        public float w() {
            return this.x;
        }

        public void s(float f) {
            this.x = f;
        }

        public float[] x() {
            return this.fs;
        }

        public void n(float[] fArr) {
            this.fs = fArr;
        }

        public String fs() {
            return this.rv;
        }

        public String rv() {
            return this.tj;
        }

        public void s(String str) {
            this.tj = str;
        }

        public void q(String str) {
            this.rv = str;
        }

        public static C0370n n(JSONObject jSONObject, com.byazt.ih.s sVar) {
            if (jSONObject == null) {
                return null;
            }
            C0370n c0370n = new C0370n();
            c0370n.n(jSONObject.optLong(MediationConstant.EXTRA_DURATION));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0370n.n(-1.0f);
            } else {
                try {
                    c0370n.n(Float.parseFloat(strOptString));
                } catch (NumberFormatException unused) {
                    c0370n.n(0.0f);
                }
            }
            c0370n.n(jSONObject.optString("loopMode"));
            c0370n.qg(jSONObject.optString("type"));
            if (TextUtils.equals(c0370n.getType(), "ripple")) {
                c0370n.s(jSONObject.optString("rippleColor"));
            }
            View viewRv = sVar.rv();
            Context context = viewRv != null ? viewRv.getContext() : null;
            if (TextUtils.equals(c0370n.getType(), "backgroundColor")) {
                String strN = com.byazt.mcb.qg.n(jSONObject.optString("valueTo"), sVar.tj());
                int iN = com.byazt.hb.n.n(jSONObject.optString("valueFrom"));
                int iN2 = com.byazt.hb.n.n(strN);
                c0370n.qg(iN);
                c0370n.s(iN2);
            } else if ((TextUtils.equals(c0370n.getType(), "translateX") || TextUtils.equals(c0370n.getType(), "translateY")) && context != null) {
                try {
                    float fN = com.byazt.hb.fs.n(context, (float) jSONObject.optDouble("valueFrom"));
                    float fN2 = com.byazt.hb.fs.n(context, (float) jSONObject.optDouble("valueTo"));
                    c0370n.qg(fN);
                    c0370n.s(fN2);
                } catch (Exception unused2) {
                    com.byazt.tk.k.qg("animation", "animation ");
                }
            } else {
                c0370n.qg((float) jSONObject.optDouble("valueFrom"));
                c0370n.s((float) jSONObject.optDouble("valueTo"));
            }
            c0370n.q(jSONObject.optString("interpolator"));
            c0370n.qg(com.byazt.hb.s.n(com.byazt.mcb.qg.n(jSONObject.optString("startDelay"), sVar.tj()), 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                int i = 0;
                if ((TextUtils.equals(c0370n.getType(), "translateX") || TextUtils.equals(c0370n.getType(), "translateY")) && context != null) {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = com.byazt.hb.fs.n(context, (float) n.n(jSONArrayOptJSONArray.optString(i), sVar.tj()));
                        i++;
                    }
                } else {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = (float) n.n(jSONArrayOptJSONArray.optString(i), sVar.tj());
                        i++;
                    }
                }
                c0370n.n(fArr);
            }
            return c0370n;
        }
    }

    public static double n(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.byazt.hb.s.n(com.byazt.mcb.qg.n((String) obj, jSONObject), 0.0d);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Long) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }
}
