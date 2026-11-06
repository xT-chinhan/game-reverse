package com.byazt.hg;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME})
public class b {
    public pr c;
    public String fw;
    public List<bh> hn;
    public bh hw;
    public boolean pr;
    public int uc;
    public int x;
    public String zo;

    public b(JSONObject jSONObject) {
        this.pr = false;
        this.hn = Collections.emptyList();
        this.x = 0;
        if (jSONObject != null) {
            this.pr = jSONObject.optBoolean("use_interact_webview", false);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_playable_client");
            if (jSONObjectOptJSONObject != null) {
                this.hw = new bh(jSONObjectOptJSONObject.optJSONObject("components"), 1);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("multi_components");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        bh bhVar = new bh(jSONArrayOptJSONArray.optJSONObject(i), 1);
                        if (bhVar.k()) {
                            arrayList.add(bhVar);
                        }
                    }
                    this.hn = Collections.unmodifiableList(arrayList);
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject2 != null) {
                    this.x = jSONObjectOptJSONObject2.optInt("switch_strategy", 0);
                }
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("easy_playable");
            if (jSONObjectOptJSONObject3 != null) {
                this.c = new pr(jSONObjectOptJSONObject3.optJSONObject("components"), 2);
            }
            this.uc = jSONObject.optInt("style_category");
            this.fw = jSONObject.optString("exp_id");
            this.zo = jSONObject.optString("group_id");
        }
    }

    public static boolean pr(of ofVar) {
        return hw(ofVar) || x(ofVar);
    }

    public static boolean hw(of ofVar) {
        return hn(ofVar) || k(ofVar);
    }

    public static boolean hn(of ofVar) {
        b bVarLi;
        bh bhVar;
        if (ofVar == null || (bVarLi = ofVar.li()) == null || (bhVar = bVarLi.hw) == null || !bhVar.k()) {
            return false;
        }
        return true;
    }

    public static boolean x(of ofVar) {
        b bVarLi;
        pr prVar;
        if (ofVar == null || (bVarLi = ofVar.li()) == null || !bVarLi.pr || (prVar = bVarLi.c) == null || !prVar.uc()) {
            return false;
        }
        return true;
    }

    public static int c(of ofVar) {
        b bVarLi;
        if (ofVar == null || (bVarLi = ofVar.li()) == null) {
            return 0;
        }
        return bVarLi.uc;
    }

    public static String uc(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.li().fw;
    }

    public static String fw(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.li().zo;
    }

    public static boolean pr() {
        return true;
    }

    public static pr zo(of ofVar) {
        b bVarLi;
        if (ofVar == null || (bVarLi = ofVar.li()) == null) {
            return null;
        }
        return bVarLi.c;
    }

    public static bh aj(of ofVar) {
        b bVarLi;
        if (ofVar == null || (bVarLi = ofVar.li()) == null) {
            return null;
        }
        return bVarLi.hw;
    }

    public static List<bh> vk(of ofVar) {
        if (ofVar == null) {
            return Collections.emptyList();
        }
        b bVarLi = ofVar.li();
        if (bVarLi == null) {
            return Collections.emptyList();
        }
        return bVarLi.hn;
    }

    public static int w(of ofVar) {
        b bVarLi;
        if (ofVar == null || (bVarLi = ofVar.li()) == null) {
            return 0;
        }
        return bVarLi.x;
    }

    public static boolean k(of ofVar) {
        List<bh> listVk = vk(ofVar);
        return (listVk == null || listVk.isEmpty()) ? false : true;
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS})
    public static class pr extends m {
        public C0085pr hn;
        public C0085pr hw;

        public pr(JSONObject jSONObject, int i) {
            if (jSONObject == null) {
                return;
            }
            this.hw = new C0085pr(jSONObject.optJSONObject("vertical"));
            this.hn = new C0085pr(jSONObject.optJSONObject("horizontal"));
            this.pr = i;
        }

        public boolean uc() {
            C0085pr c0085pr = this.hn;
            if (c0085pr != null && c0085pr.pr()) {
                return true;
            }
            C0085pr c0085pr2 = this.hw;
            return c0085pr2 != null && c0085pr2.pr();
        }

        public String pr(boolean z) {
            C0085pr c0085pr;
            if (z && (c0085pr = this.hw) != null && c0085pr.pr()) {
                return this.hw.pr;
            }
            C0085pr c0085pr2 = this.hn;
            if (c0085pr2 != null && c0085pr2.pr()) {
                return this.hn.pr;
            }
            C0085pr c0085pr3 = this.hw;
            if (c0085pr3 != null && c0085pr3.pr()) {
                return this.hw.pr;
            }
            return "";
        }

        @Override // com.byazt.hg.m
        public int hn() {
            return 0;
        }

        @Override // com.byazt.hg.m
        public int x() {
            C0085pr c0085pr = this.hw;
            if (c0085pr != null) {
                return c0085pr.hw;
            }
            C0085pr c0085pr2 = this.hn;
            if (c0085pr2 != null) {
                return c0085pr2.hw;
            }
            return 0;
        }

        @Override // com.byazt.hg.m
        public String c() {
            return "";
        }

        /* JADX INFO: renamed from: com.byazt.hg.b$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 2016})
        public static class C0085pr {
            public int hw;
            public String pr;

            public C0085pr(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.pr = jSONObject.optString("entry");
                this.hw = jSONObject.optInt("displayAreaAndroid");
            }

            public boolean pr() {
                return !TextUtils.isEmpty(this.pr);
            }
        }
    }
}
