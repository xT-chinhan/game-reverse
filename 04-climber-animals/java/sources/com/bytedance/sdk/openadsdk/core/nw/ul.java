package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ul {
    private String ab;
    private int ah;
    private String c;
    private int ch;
    private int d;
    private int hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3102ms;
    private int ny;
    private int sl;
    private String x;
    private String xr;
    private boolean zb;

    public ul(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("live_ad")) == null) {
            return;
        }
        this.zb = true;
        ms(jSONObjectOptJSONObject.optInt("live_show_time", 60));
        this.xr = jSONObjectOptJSONObject.optString("live_author_nickname");
        this.ah = jSONObjectOptJSONObject.optInt("live_author_follower_count", -1);
        this.d = jSONObjectOptJSONObject.optInt("live_watch_count", -1);
        this.ka = jSONObjectOptJSONObject.optString("live_description");
        this.c = jSONObjectOptJSONObject.optString("live_feed_url");
        this.ab = jSONObjectOptJSONObject.optString("live_cover_image_url");
        this.x = jSONObjectOptJSONObject.optString("live_avatar_url");
        this.ny = jSONObjectOptJSONObject.optInt("live_avatar_width");
        this.ch = jSONObjectOptJSONObject.optInt("live_avatar_height");
        this.hi = jSONObjectOptJSONObject.optInt("live_cover_width");
        this.sl = jSONObjectOptJSONObject.optInt("live_cover_height");
    }

    public boolean ms() {
        return this.zb;
    }

    public void ms(JSONObject jSONObject) {
        if (this.zb) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("live_show_time", this.f3102ms);
                jSONObject2.put("live_author_nickname", this.xr);
                jSONObject2.put("live_author_follower_count", this.ah);
                jSONObject2.put("live_watch_count", this.d);
                jSONObject2.put("live_description", this.ka);
                jSONObject2.put("live_feed_url", this.c);
                jSONObject2.put("live_cover_image_url", this.ab);
                jSONObject2.put("live_avatar_url", this.x);
                jSONObject2.put("live_cover_width", this.hi);
                jSONObject2.put("live_cover_height", this.sl);
                jSONObject2.put("live_avatar_width", this.ny);
                jSONObject2.put("live_avatar_height", this.ch);
                jSONObject.put("live_ad", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private static ul u(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.ws();
    }

    public static boolean ms(lm lmVar) {
        ul ulVarU = u(lmVar);
        if (ulVarU == null) {
            return false;
        }
        return ulVarU.zb;
    }

    public static int xr(lm lmVar) {
        ul ulVarU = u(lmVar);
        if (ulVarU == null) {
            return 0;
        }
        return ulVarU.f3102ms;
    }

    public void ms(int i) {
        if (i <= 0 || i > 300) {
            i = 60;
        }
        this.f3102ms = i;
    }

    public static String ah(lm lmVar) {
        ul ulVarU = u(lmVar);
        return ulVarU == null ? "" : ulVarU.xr;
    }

    public static int d(lm lmVar) {
        ul ulVarU = u(lmVar);
        if (ulVarU == null) {
            return 0;
        }
        return ulVarU.ah;
    }

    public static int ka(lm lmVar) {
        ul ulVarU = u(lmVar);
        if (ulVarU == null) {
            return 0;
        }
        return ulVarU.d;
    }

    public static String c(lm lmVar) {
        ul ulVarU = u(lmVar);
        return ulVarU == null ? "" : ulVarU.ka;
    }

    public static String ab(lm lmVar) {
        ul ulVarU = u(lmVar);
        return ulVarU == null ? "" : ulVarU.c;
    }

    public static String x(lm lmVar) {
        ul ulVarU = u(lmVar);
        return ulVarU == null ? "" : ulVarU.ab;
    }

    public static String ny(lm lmVar) {
        ul ulVarU = u(lmVar);
        return ulVarU == null ? "" : ulVarU.x;
    }

    public static int ch(lm lmVar) {
        ul ulVarU = u(lmVar);
        if (ulVarU == null) {
            return 0;
        }
        return ulVarU.ny;
    }

    public static int hi(lm lmVar) {
        ul ulVarU = u(lmVar);
        if (ulVarU == null) {
            return 0;
        }
        return ulVarU.ch;
    }

    public static int sl(lm lmVar) {
        ul ulVarU = u(lmVar);
        if (ulVarU == null) {
            return 0;
        }
        return ulVarU.hi;
    }

    public static int zb(lm lmVar) {
        ul ulVarU = u(lmVar);
        if (ulVarU == null) {
            return 0;
        }
        return ulVarU.sl;
    }
}
