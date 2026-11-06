package com.byazt.njk;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.aa.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, 13})
public final class hw {
    public final List<x> hw;
    public final hn pr;

    public static int pr(String str) {
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

    public static int hw(String str) {
        if ("outline".equals(str)) {
            return 1;
        }
        return "surface".equals(str) ? 2 : 0;
    }

    public static int hn(String str) {
        if ("rect".equals(str)) {
            return 1;
        }
        if ("star".equals(str)) {
            return 2;
        }
        return 0;
    }

    public static int x(String str) {
        if ("additive".equals(str)) {
            return 1;
        }
        if ("backToFront".equals(str) || "oldestFirst".equals(str)) {
            return 3;
        }
        if ("oldestLast".equals(str)) {
            return 4;
        }
        return 0;
    }

    private hw(hn hnVar, List<x> list) {
        this.pr = hnVar;
        this.hw = list;
    }

    public hn pr() {
        return this.pr;
    }

    public List<x> hw() {
        return this.hw;
    }

    public boolean hn() {
        List<x> list = this.hw;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static hw pr(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return pr(context, new JSONObject(str));
        } catch (Exception e) {
            return null;
        }
    }

    public static hw pr(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hn hnVarPr = hn.pr(jSONObject.optJSONObject("layer"));
        List<x> listPr = pr(context, jSONObject.optJSONArray("particles"));
        if (listPr.isEmpty()) {
            return null;
        }
        return new hw(hnVarPr, listPr);
    }

    private static List<x> pr(Context context, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(x.pr(context, jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME})
    public static final class hn {
        public final C0139hw aj;
        public final int c;
        public final C0139hw fw;
        public final String hn;
        public final String hw;
        public final String pr;
        public final int uc;
        public final C0139hw vk;
        public final int x;
        public final C0139hw zo;

        private hn(String str, String str2, String str3, C0139hw c0139hw, C0139hw c0139hw2, C0139hw c0139hw3, C0139hw c0139hw4) {
            this.pr = str;
            this.hw = str2;
            this.hn = str3;
            this.x = hw.pr(str);
            this.c = hw.hw(str2);
            this.uc = hw.x(str3);
            this.fw = c0139hw;
            this.zo = c0139hw2;
            this.aj = c0139hw3;
            this.vk = c0139hw4;
        }

        public static hn pr(JSONObject jSONObject) {
            if (jSONObject == null) {
                return pr();
            }
            String strOptString = jSONObject.optString("emitterShape", "point");
            String strOptString2 = jSONObject.optString("emitterMode", "points");
            String strOptString3 = jSONObject.optString("renderMode", "unordered");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("emitterPosition");
            C0139hw c0139hwPr = C0139hw.pr(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt("x") : null, new C0139hw(0.5f, true));
            C0139hw c0139hwPr2 = C0139hw.pr(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt("y") : null, new C0139hw(0.0f, true));
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("emitterSize");
            return new hn(strOptString, strOptString2, strOptString3, c0139hwPr, c0139hwPr2, C0139hw.pr(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.opt("w") : null, new C0139hw(1.0f, true)), C0139hw.pr(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.opt(an.aG) : null, new C0139hw(1.0f, true)));
        }

        private static hn pr() {
            return new hn("point", "points", "unordered", new C0139hw(0.5f, true), new C0139hw(0.0f, true), new C0139hw(1.0f, true), new C0139hw(1.0f, true));
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, 1243})
    public static final class x {
        public final float aj;
        public final float c;
        public final float fw;
        public final float hn;
        public final float hw;
        public final pr k;
        public final String pr;
        public final float uc;
        public final float vk;
        public final float w;
        public final float x;
        public final float zo;

        private x(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, pr prVar) {
            this.pr = str;
            this.hw = f;
            this.hn = f2;
            this.x = f3;
            this.c = f4;
            this.uc = f5;
            this.fw = f6;
            this.zo = f7;
            this.aj = f8;
            this.vk = f9;
            this.w = f10;
            this.k = prVar;
        }

        public static x pr(Context context, JSONObject jSONObject) {
            return new x(jSONObject.optString(Common.System.NAME, ""), (float) jSONObject.optDouble("birthRate", 1.0d), (float) jSONObject.optDouble("lifetime", 1.0d), (float) jSONObject.optDouble("lifetimeRange", 0.0d), (float) jSONObject.optDouble("scale", 1.0d), (float) jSONObject.optDouble("scaleRange", 0.0d), (float) jSONObject.optDouble("velocity", 0.0d), (float) jSONObject.optDouble("velocityRange", 0.0d), (float) jSONObject.optDouble("emissionRange", 0.0d), (float) jSONObject.optDouble("alphaRange", 0.0d), (float) jSONObject.optDouble("alphaSpeed", 0.0d), pr.pr(context, jSONObject.optJSONObject("content")));
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static final class pr {
        public final int c;
        public final float hn;
        public final int hw;
        public final String pr;
        public final float x;

        private pr(String str, float f, float f2, int i) {
            this.pr = str;
            this.hw = hw.hn(str);
            this.hn = f;
            this.x = f2;
            this.c = i;
        }

        public static pr pr(Context context, JSONObject jSONObject) {
            if (jSONObject == null) {
                return new pr("circle", zo.pr(context, 6.0f), zo.pr(context, 6.0f), -1);
            }
            return new pr(jSONObject.optString("shape", "circle"), zo.pr(context, (float) jSONObject.optDouble("width", 6.0d)), zo.pr(context, (float) jSONObject.optDouble("height", 6.0d)), com.byazt.aa.pr.pr(jSONObject.optString("color", "#FFFFFF"), -1));
        }
    }

    /* JADX INFO: renamed from: com.byazt.njk.hw$hw, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, 497})
    public static final class C0139hw {
        public final boolean hw;
        public final float pr;

        public C0139hw(float f, boolean z) {
            this.pr = f;
            this.hw = z;
        }

        public static C0139hw pr(Object obj, C0139hw c0139hw) {
            if (obj == null) {
                return c0139hw;
            }
            if (obj instanceof Number) {
                return new C0139hw(((Number) obj).floatValue(), false);
            }
            String strTrim = obj.toString().trim();
            if (TextUtils.isEmpty(strTrim)) {
                return c0139hw;
            }
            try {
                if (strTrim.endsWith("%")) {
                    return new C0139hw(Float.parseFloat(strTrim.substring(0, strTrim.length() - 1)) / 100.0f, true);
                }
                return new C0139hw(Float.parseFloat(strTrim), false);
            } catch (NumberFormatException e) {
                return c0139hw;
            }
        }

        public float pr(float f) {
            return this.hw ? f * this.pr : this.pr;
        }
    }
}
