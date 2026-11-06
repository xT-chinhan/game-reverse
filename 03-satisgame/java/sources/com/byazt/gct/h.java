package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 878})
public class h {
    public String fs;
    public n l;
    public boolean n;
    public int q;
    public g qg;
    public List<g> s;
    public int w;
    public String x;

    public static boolean n() {
        return true;
    }

    public h(JSONObject jSONObject) {
        this.n = false;
        this.s = Collections.emptyList();
        this.q = 0;
        if (jSONObject == null) {
            return;
        }
        this.n = jSONObject.optBoolean("use_interact_webview", false);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_playable_client");
        if (jSONObjectOptJSONObject != null) {
            this.qg = new g(jSONObjectOptJSONObject.optJSONObject("components"), 1);
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("multi_components");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    g gVar = new g(jSONArrayOptJSONArray.optJSONObject(i), 1);
                    if (gVar.k()) {
                        arrayList.add(gVar);
                    }
                }
                this.s = Collections.unmodifiableList(arrayList);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(com.anythink.core.common.l.f.R);
            if (jSONObjectOptJSONObject2 != null) {
                this.q = jSONObjectOptJSONObject2.optInt("switch_strategy", 0);
            }
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("easy_playable");
        if (jSONObjectOptJSONObject3 != null) {
            this.l = new n(jSONObjectOptJSONObject3.optJSONObject("components"), 2);
        }
        this.w = jSONObject.optInt("style_category");
        this.x = jSONObject.optString("exp_id");
        this.fs = jSONObject.optString("group_id");
    }

    public static boolean n(pk pkVar) {
        return qg(pkVar) || q(pkVar);
    }

    public static boolean qg(pk pkVar) {
        return s(pkVar) || oa(pkVar);
    }

    public static boolean s(pk pkVar) {
        h hVarXm;
        g gVar;
        return (pkVar == null || (hVarXm = pkVar.xm()) == null || (gVar = hVarXm.qg) == null || !gVar.k()) ? false : true;
    }

    public static boolean q(pk pkVar) {
        h hVarXm;
        n nVar;
        return (pkVar == null || (hVarXm = pkVar.xm()) == null || !hVarXm.n || (nVar = hVarXm.l) == null || !nVar.rv()) ? false : true;
    }

    public static String l(pk pkVar) {
        h hVarXm;
        g gVar;
        if (pkVar == null || (hVarXm = pkVar.xm()) == null || (gVar = hVarXm.qg) == null) {
            return null;
        }
        return gVar.l();
    }

    public static int w(pk pkVar) {
        h hVarXm;
        if (pkVar == null || (hVarXm = pkVar.xm()) == null) {
            return 0;
        }
        return hVarXm.w;
    }

    public static String x(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.xm().x;
    }

    public static String fs(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.xm().fs;
    }

    public static n rv(pk pkVar) {
        h hVarXm;
        if (pkVar == null || (hVarXm = pkVar.xm()) == null) {
            return null;
        }
        return hVarXm.l;
    }

    public static g tj(pk pkVar) {
        h hVarXm;
        if (pkVar == null || (hVarXm = pkVar.xm()) == null) {
            return null;
        }
        return hVarXm.qg;
    }

    public static List<g> cp(pk pkVar) {
        if (pkVar == null) {
            return Collections.emptyList();
        }
        h hVarXm = pkVar.xm();
        if (hVarXm == null) {
            return Collections.emptyList();
        }
        return hVarXm.s;
    }

    public static int d(pk pkVar) {
        h hVarXm;
        if (pkVar == null || (hVarXm = pkVar.xm()) == null) {
            return 0;
        }
        return hVarXm.q;
    }

    public static boolean oa(pk pkVar) {
        List<g> listCp = cp(pkVar);
        return (listCp == null || listCp.isEmpty()) ? false : true;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME})
    public static class n extends oa {
        public int l;
        public int q;
        public C0178n qg;
        public C0178n s;
        public double w;

        @Override // com.byazt.gct.oa
        public String l() {
            return "";
        }

        @Override // com.byazt.gct.oa
        public int s() {
            return 0;
        }

        public n(JSONObject jSONObject, int i) {
            if (jSONObject == null) {
                return;
            }
            this.qg = new C0178n(jSONObject.optJSONObject("vertical"));
            this.s = new C0178n(jSONObject.optJSONObject("horizontal"));
            this.q = com.byazt.rg.q.n(jSONObject.optString("preferred_size_width"));
            this.l = com.byazt.rg.q.n(jSONObject.optString("preferred_size_height"));
            this.w = com.byazt.rg.q.qg(jSONObject.optString("preferred_aspect_ratio"));
            this.n = i;
        }

        public boolean rv() {
            C0178n c0178n = this.s;
            if (c0178n != null && c0178n.n()) {
                return true;
            }
            C0178n c0178n2 = this.qg;
            return c0178n2 != null && c0178n2.n();
        }

        public String n(boolean z) {
            C0178n c0178n;
            if (z && (c0178n = this.qg) != null && c0178n.n()) {
                return this.qg.n;
            }
            C0178n c0178n2 = this.s;
            if (c0178n2 != null && c0178n2.n()) {
                return this.s.n;
            }
            C0178n c0178n3 = this.qg;
            return (c0178n3 == null || !c0178n3.n()) ? "" : this.qg.n;
        }

        @Override // com.byazt.gct.oa
        public int q() {
            C0178n c0178n = this.qg;
            if (c0178n != null) {
                return c0178n.qg;
            }
            C0178n c0178n2 = this.s;
            if (c0178n2 != null) {
                return c0178n2.qg;
            }
            return 0;
        }

        @Override // com.byazt.gct.oa
        public int w() {
            return this.q;
        }

        @Override // com.byazt.gct.oa
        public int x() {
            return this.l;
        }

        @Override // com.byazt.gct.oa
        public double fs() {
            return this.w;
        }

        /* JADX INFO: renamed from: com.byazt.gct.h$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 894})
        public static class C0178n {
            public String n;
            public int qg;

            public C0178n(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.n = jSONObject.optString("entry");
                this.qg = jSONObject.optInt("displayAreaAndroid");
            }

            public boolean n() {
                return !TextUtils.isEmpty(this.n);
            }
        }
    }
}
