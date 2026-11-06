package com.byazt.hg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.compliance.constants.BundleKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
public class qi {
    public hw aj;
    public String c;
    public JSONArray fw;
    public boolean hn;
    public boolean hw;
    public String pr;
    public String uc;
    public pr vk;
    public String x;
    public int zo;

    public static qi pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        qi qiVar = new qi();
        qiVar.pr = jSONObject.optString("promotion_id");
        qiVar.hw = jSONObject.optBoolean("is_silent_auth", false);
        qiVar.hn = jSONObject.optBoolean("enable_playable_auth", false);
        qiVar.x = jSONObject.optString("aweme_agreements");
        qiVar.c = jSONObject.optString("aweme_privacy");
        qiVar.uc = jSONObject.optString("live_csj_libra_param");
        qiVar.fw = jSONObject.optJSONArray("tasks");
        qiVar.zo = jSONObject.optInt("live_playable");
        qiVar.vk = pr.pr(jSONObject.optJSONObject("product"));
        qiVar.aj = hw.pr(jSONObject.optJSONObject("coupon"));
        return qiVar;
    }

    public JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotion_id", this.pr);
            jSONObject.put("is_silent_auth", this.hw);
            jSONObject.put("enable_playable_auth", this.hn);
            jSONObject.put("aweme_agreements", this.x);
            jSONObject.put("aweme_privacy", this.c);
            jSONObject.put("live_csj_libra_param", this.uc);
            jSONObject.put("tasks", this.fw);
            jSONObject.put("live_playable", this.zo);
            pr prVar = this.vk;
            if (prVar != null) {
                jSONObject.put("product", prVar.c());
            }
            hw hwVar = this.aj;
            if (hwVar != null) {
                jSONObject.put("coupon", hwVar.hn());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String hw() {
        return this.pr;
    }

    public boolean hn() {
        return this.hw;
    }

    public boolean x() {
        return this.hn;
    }

    public String c() {
        return this.x;
    }

    public String uc() {
        return this.c;
    }

    public String fw() {
        return this.uc;
    }

    public JSONArray zo() {
        return this.fw;
    }

    public boolean aj() {
        return this.zo == 2 && this.hn;
    }

    public hw vk() {
        return this.aj;
    }

    public pr w() {
        return this.vk;
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 2276})
    public static class hw {
        public int hw;
        public int pr;

        public static hw pr(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            hw hwVar = new hw();
            hwVar.pr = jSONObject.optInt(IAction.BuyKey.CostAmount);
            hwVar.hw = jSONObject.optInt("threshold");
            return hwVar;
        }

        public int pr() {
            return this.pr;
        }

        public int hw() {
            return this.hw;
        }

        public JSONObject hn() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IAction.BuyKey.CostAmount, this.pr);
                jSONObject.put("threshold", this.hw);
            } catch (JSONException e) {
            }
            return jSONObject;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 2265})
    public static class pr {
        public double hn;
        public String hw;
        public String pr;
        public double x;

        public static pr pr(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            pr prVar = new pr();
            prVar.pr = jSONObject.optString(BundleKey.TITLE);
            prVar.hw = jSONObject.optString(ImageViewManager.NAME);
            prVar.x = jSONObject.optDouble(IAction.PurchaseKey.Price);
            prVar.hn = jSONObject.optDouble("origin_price");
            return prVar;
        }

        public String pr() {
            return this.pr;
        }

        public String hw() {
            return this.hw;
        }

        public double hn() {
            return this.hn;
        }

        public double x() {
            return this.x;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BundleKey.TITLE, this.pr);
                jSONObject.put(ImageViewManager.NAME, this.hw);
                jSONObject.put(IAction.PurchaseKey.Price, this.x);
                jSONObject.put("origin_price", this.hn);
            } catch (JSONException e) {
            }
            return jSONObject;
        }
    }
}
