package com.bytedance.adsdk.ugeno.ah;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private List<C0191ms> ah;
    private String c;
    private long d;
    private long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f331ms;
    private float xr;

    public String ms() {
        return this.f331ms;
    }

    public void ms(String str) {
        this.f331ms = str;
    }

    public void ms(float f) {
        this.xr = f;
    }

    public float xr() {
        return this.xr;
    }

    public List<C0191ms> ah() {
        return this.ah;
    }

    public void ms(List<C0191ms> list) {
        this.ah = list;
    }

    public long d() {
        return this.d;
    }

    public void ms(long j) {
        this.d = j;
    }

    public long ka() {
        return this.ka;
    }

    public void xr(long j) {
        this.ka = j;
    }

    public String c() {
        return this.c;
    }

    public void xr(String str) {
        this.c = str;
    }

    public static ms ms(String str, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ms(new JSONObject(str), ahVar);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return null;
        }
    }

    public static ms ms(JSONObject jSONObject, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        return ms(jSONObject, null, ahVar);
    }

    public static ms ms(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        if (jSONObject == null) {
            return null;
        }
        ms msVar = new ms();
        msVar.ms(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            msVar.ms(-1.0f);
        } else {
            try {
                msVar.ms(Float.parseFloat(strOptString));
            } catch (NumberFormatException unused) {
                msVar.ms(0.0f);
            }
        }
        msVar.ms(jSONObject.optLong("duration", 0L));
        msVar.xr(com.bytedance.adsdk.ugeno.c.ah.ms(com.bytedance.adsdk.ugeno.d.xr.ms(jSONObject.optString("startDelay"), ahVar.ch()), 0L));
        msVar.xr(jSONObject.optString("loopMode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.c.xr.ms(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0191ms.ms(jSONObjectOptJSONObject, ahVar));
            }
            msVar.ms(arrayList);
        }
        return msVar;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.ah.ms$ms, reason: collision with other inner class name */
    public static class C0191ms {
        private float ab;
        private String ah;
        private float c;
        private String ch;
        private long d;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private long f332ms;
        private String ny;
        private float[] x;
        private float xr;

        public long ms() {
            return this.f332ms;
        }

        public void ms(long j) {
            this.f332ms = j;
        }

        public float xr() {
            return this.xr;
        }

        public void ms(float f) {
            this.xr = f;
        }

        public String ah() {
            return this.ah;
        }

        public void ms(String str) {
            this.ah = str;
        }

        public long d() {
            return this.d;
        }

        public void xr(long j) {
            this.d = j;
        }

        public String getType() {
            return this.ka;
        }

        public void xr(String str) {
            this.ka = str;
        }

        public float ka() {
            return this.c;
        }

        public void xr(float f) {
            this.c = f;
        }

        public float c() {
            return this.ab;
        }

        public void ah(float f) {
            this.ab = f;
        }

        public float[] ab() {
            return this.x;
        }

        public void ms(float[] fArr) {
            this.x = fArr;
        }

        public String x() {
            return this.ny;
        }

        public String ny() {
            return this.ch;
        }

        public void ah(String str) {
            this.ch = str;
        }

        public void d(String str) {
            this.ny = str;
        }

        public static C0191ms ms(JSONObject jSONObject, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
            if (jSONObject == null) {
                return null;
            }
            C0191ms c0191ms = new C0191ms();
            c0191ms.ms(jSONObject.optLong("duration"));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0191ms.ms(-1.0f);
            } else {
                try {
                    c0191ms.ms(Float.parseFloat(strOptString));
                } catch (NumberFormatException unused) {
                    c0191ms.ms(0.0f);
                }
            }
            c0191ms.ms(jSONObject.optString("loopMode"));
            c0191ms.xr(jSONObject.optString("type"));
            if (TextUtils.equals(c0191ms.getType(), "ripple")) {
                c0191ms.ah(jSONObject.optString("rippleColor"));
            }
            View viewNy = ahVar.ny();
            Context context = viewNy != null ? viewNy.getContext() : null;
            if (TextUtils.equals(c0191ms.getType(), "backgroundColor")) {
                String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObject.optString("valueTo"), ahVar.ch());
                int iMs = com.bytedance.adsdk.ugeno.c.ms.ms(jSONObject.optString("valueFrom"));
                int iMs2 = com.bytedance.adsdk.ugeno.c.ms.ms(strMs);
                c0191ms.xr(iMs);
                c0191ms.ah(iMs2);
            } else if ((TextUtils.equals(c0191ms.getType(), "translateX") || TextUtils.equals(c0191ms.getType(), "translateY")) && context != null) {
                try {
                    float fMs = com.bytedance.adsdk.ugeno.c.x.ms(context, (float) jSONObject.optDouble("valueFrom"));
                    float fMs2 = com.bytedance.adsdk.ugeno.c.x.ms(context, (float) jSONObject.optDouble("valueTo"));
                    c0191ms.xr(fMs);
                    c0191ms.ah(fMs2);
                } catch (Exception unused2) {
                    com.bytedance.sdk.component.utils.sl.d("animation", "animation ");
                }
            } else {
                c0191ms.xr((float) jSONObject.optDouble("valueFrom"));
                c0191ms.ah((float) jSONObject.optDouble("valueTo"));
            }
            c0191ms.d(jSONObject.optString("interpolator"));
            c0191ms.xr(com.bytedance.adsdk.ugeno.c.ah.ms(com.bytedance.adsdk.ugeno.d.xr.ms(jSONObject.optString("startDelay"), ahVar.ch()), 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                int i = 0;
                if ((TextUtils.equals(c0191ms.getType(), "translateX") || TextUtils.equals(c0191ms.getType(), "translateY")) && context != null) {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = com.bytedance.adsdk.ugeno.c.x.ms(context, (float) ms.ms(jSONArrayOptJSONArray.optString(i), ahVar.ch()));
                        i++;
                    }
                } else {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = (float) ms.ms(jSONArrayOptJSONArray.optString(i), ahVar.ch());
                        i++;
                    }
                }
                c0191ms.ms(fArr);
            }
            return c0191ms;
        }
    }

    public static double ms(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.bytedance.adsdk.ugeno.c.ah.ms(com.bytedance.adsdk.ugeno.d.xr.ms((String) obj, jSONObject), 0.0d);
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
