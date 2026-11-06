package com.byazt.bf;

import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 21})
public class x extends q {
    public final String fs;
    public final String rv;
    public n tj;
    public List<l> w;
    public String x;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    private static class n {
        public String n;
        public String qg;
        public String s;

        public n(String str, String str2, String str3) {
            this.n = str;
            this.qg = str2;
            this.s = str3;
        }
    }

    public x(String str, String str2, String str3, String str4, int i, String str5) {
        super(str, str2, str3, str4, i);
        this.fs = "count";
        this.rv = "effective_time";
        this.x = str5;
        if (!TextUtils.isEmpty(str2)) {
            this.tj = new n("freq", "span", a.C0017a.o);
        } else {
            this.tj = new n("waterfall_show_freq", "waterfall_show_span", "waterfall_show_rule_id");
        }
    }

    public String rv() {
        try {
            JSONArray jSONArray = new JSONArray(this.x);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                jSONObject.put("count", 0);
                jSONObject.put("effective_time", w.n(jSONObject.getLong(this.tj.qg)));
            }
            this.x = jSONArray.toString();
        } catch (JSONException unused) {
        }
        return this.x;
    }

    public String tj() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (l lVar : cp()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(this.tj.n, lVar.n());
                jSONObject.put(this.tj.qg, lVar.qg());
                jSONObject.put(this.tj.s, lVar.s());
                jSONObject.put("count", lVar.l());
                jSONObject.put("effective_time", lVar.q());
                jSONArray.put(jSONObject);
            }
            this.x = jSONArray.toString();
        } catch (JSONException unused) {
        }
        return this.x;
    }

    public synchronized List<l> cp() {
        x xVarTj;
        List<l> list = this.w;
        if (list != null && list.size() != 0) {
            return this.w;
        }
        this.w = new ArrayList();
        if (this.x == null && (xVarTj = oa.n().tj(this.n)) != null) {
            this.x = xVarTj.x;
        }
        if (TextUtils.isEmpty(this.x)) {
            return this.w;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.x);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                l lVar = new l();
                String string = jSONObject.getString(this.tj.s);
                if (jSONObject != null && !TextUtils.isEmpty(string)) {
                    lVar.n(jSONObject.optInt(this.tj.n));
                    lVar.n(jSONObject.optLong(this.tj.qg));
                    lVar.n(string);
                    if (jSONObject.has("count")) {
                        lVar.qg(jSONObject.optInt("count"));
                    }
                    if (jSONObject.has("effective_time")) {
                        lVar.qg(jSONObject.optLong("effective_time"));
                    }
                    this.w.add(lVar);
                }
            }
        } catch (JSONException unused) {
        }
        if (this.w.size() > 0) {
            Collections.sort(this.w, new Comparator<l>() { // from class: com.byazt.bf.x.1
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public int compare(l lVar2, l lVar3) {
                    long jQg = lVar2.qg() - lVar3.qg();
                    if (jQg == 0) {
                        return 0;
                    }
                    return jQg > 0 ? 1 : -1;
                }
            });
        }
        return this.w;
    }

    public void n(String str, int i) {
        for (l lVar : cp()) {
            if (TextUtils.equals(lVar.s(), str)) {
                lVar.qg(i);
                return;
            }
        }
    }

    public void n(String str, long j) {
        for (l lVar : cp()) {
            if (TextUtils.equals(lVar.s(), str)) {
                lVar.qg(j);
                return;
            }
        }
    }

    @Override // com.byazt.bf.q
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.n + "', showRulesVersion='" + this.s + "', timingMode=" + this.l + "}IntervalFreqctlBean{freqctlRules=" + this.w + ", freqctlRulesJson='" + this.x + "'}";
    }
}
