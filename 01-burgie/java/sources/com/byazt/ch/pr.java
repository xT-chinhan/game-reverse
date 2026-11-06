package com.byazt.ch;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME, 37})
public class pr {
    public long c;
    public List<C0034pr> hn;
    public float hw;
    public String pr;
    public String uc;
    public long x;

    public String pr() {
        return this.pr;
    }

    public void pr(String str) {
        this.pr = str;
    }

    public void pr(float f) {
        this.hw = f;
    }

    public float hw() {
        return this.hw;
    }

    public List<C0034pr> hn() {
        return this.hn;
    }

    public void pr(List<C0034pr> list) {
        this.hn = list;
    }

    public long x() {
        return this.x;
    }

    public void pr(long j) {
        this.x = j;
    }

    public long c() {
        return this.c;
    }

    public void hw(long j) {
        this.c = j;
    }

    public String uc() {
        return this.uc;
    }

    public void hw(String str) {
        this.uc = str;
    }

    public static pr pr(String str, com.byazt.ik.hn hnVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return pr(new JSONObject(str), hnVar);
        } catch (JSONException e) {
            return null;
        }
    }

    public static pr pr(JSONObject jSONObject, com.byazt.ik.hn hnVar) {
        return pr(jSONObject, null, hnVar);
    }

    public static pr pr(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.ik.hn hnVar) {
        if (jSONObject == null) {
            return null;
        }
        pr prVar = new pr();
        prVar.pr(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            prVar.pr(-1.0f);
        } else {
            try {
                prVar.pr(Float.parseFloat(strOptString));
            } catch (NumberFormatException e) {
                prVar.pr(0.0f);
            }
        }
        prVar.pr(jSONObject.optLong("duration", 0L));
        prVar.hw(com.byazt.aa.hn.pr(com.byazt.tn.hw.pr(jSONObject.optString("startDelay"), hnVar.vk()), 0L));
        prVar.hw(jSONObject.optString("loopMode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.byazt.aa.hw.pr(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0034pr.pr(jSONObjectOptJSONObject, hnVar));
            }
            prVar.pr(arrayList);
        }
        return prVar;
    }

    /* JADX INFO: renamed from: com.byazt.ch.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0034pr {
        public String aj;
        public String c;
        public float fw;
        public String hn;
        public float hw;
        public long pr;
        public float uc;
        public String vk;
        public long x;
        public float[] zo;

        public long pr() {
            return this.pr;
        }

        public void pr(long j) {
            this.pr = j;
        }

        public float hw() {
            return this.hw;
        }

        public void pr(float f) {
            this.hw = f;
        }

        public String hn() {
            return this.hn;
        }

        public void pr(String str) {
            this.hn = str;
        }

        public long x() {
            return this.x;
        }

        public void hw(long j) {
            this.x = j;
        }

        public String getType() {
            return this.c;
        }

        public void hw(String str) {
            this.c = str;
        }

        public float c() {
            return this.uc;
        }

        public void hw(float f) {
            this.uc = f;
        }

        public float uc() {
            return this.fw;
        }

        public void hn(float f) {
            this.fw = f;
        }

        public float[] fw() {
            return this.zo;
        }

        public void pr(float[] fArr) {
            this.zo = fArr;
        }

        public String zo() {
            return this.aj;
        }

        public String aj() {
            return this.vk;
        }

        public void hn(String str) {
            this.vk = str;
        }

        public void x(String str) {
            this.aj = str;
        }

        public static C0034pr pr(JSONObject jSONObject, com.byazt.ik.hn hnVar) {
            Context context = null;
            if (jSONObject == null) {
                return null;
            }
            C0034pr c0034pr = new C0034pr();
            c0034pr.pr(jSONObject.optLong("duration"));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0034pr.pr(-1.0f);
            } else {
                try {
                    c0034pr.pr(Float.parseFloat(strOptString));
                } catch (NumberFormatException e) {
                    c0034pr.pr(0.0f);
                }
            }
            c0034pr.pr(jSONObject.optString("loopMode"));
            c0034pr.hw(jSONObject.optString("type"));
            if (TextUtils.equals(c0034pr.getType(), "ripple")) {
                c0034pr.hn(jSONObject.optString("rippleColor"));
            }
            View viewAj = hnVar.aj();
            if (viewAj != null) {
                context = viewAj.getContext();
            }
            if (TextUtils.equals(c0034pr.getType(), "backgroundColor")) {
                String strPr = com.byazt.tn.hw.pr(jSONObject.optString("valueTo"), hnVar.vk());
                int iPr = com.byazt.aa.pr.pr(jSONObject.optString("valueFrom"));
                int iPr2 = com.byazt.aa.pr.pr(strPr);
                c0034pr.hw(iPr);
                c0034pr.hn(iPr2);
            } else if ((TextUtils.equals(c0034pr.getType(), "translateX") || TextUtils.equals(c0034pr.getType(), "translateY")) && context != null) {
                try {
                    float fPr = com.byazt.aa.zo.pr(context, (float) jSONObject.optDouble("valueFrom"));
                    float fPr2 = com.byazt.aa.zo.pr(context, (float) jSONObject.optDouble("valueTo"));
                    c0034pr.hw(fPr);
                    c0034pr.hn(fPr2);
                } catch (Exception e2) {
                    com.byazt.ca.ho.hw("animation", "animation ");
                }
            } else {
                c0034pr.hw((float) jSONObject.optDouble("valueFrom"));
                c0034pr.hn((float) jSONObject.optDouble("valueTo"));
            }
            c0034pr.x(jSONObject.optString("interpolator"));
            c0034pr.hw(com.byazt.aa.hn.pr(com.byazt.tn.hw.pr(jSONObject.optString("startDelay"), hnVar.vk()), 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                int i = 0;
                if ((TextUtils.equals(c0034pr.getType(), "translateX") || TextUtils.equals(c0034pr.getType(), "translateY")) && context != null) {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = com.byazt.aa.zo.pr(context, (float) pr.pr(jSONArrayOptJSONArray.optString(i), hnVar.vk()));
                        i++;
                    }
                } else {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = (float) pr.pr(jSONArrayOptJSONArray.optString(i), hnVar.vk());
                        i++;
                    }
                }
                c0034pr.pr(fArr);
            }
            return c0034pr;
        }
    }

    public static double pr(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.byazt.aa.hn.pr(com.byazt.tn.hw.pr((String) obj, jSONObject), 0.0d);
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
