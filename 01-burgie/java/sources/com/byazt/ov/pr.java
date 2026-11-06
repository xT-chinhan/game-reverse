package com.byazt.ov;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.af.vk;
import com.byazt.ca.yb;
import com.byazt.hg.of;
import com.byazt.sd.iu;
import com.byazt.wb.hn;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 37})
public class pr implements com.byazt.ni.pr {
    public Map<String, Object> aj;
    public final String c;
    public String fw;
    public final Context hw;
    public final JSONObject k;
    public final int uc;
    public Map<String, Object> vk;
    public final vk w;
    public boolean x;
    public com.byazt.ga.hw zo;
    public boolean pr = false;
    public final Map<String, Object> hn = new HashMap();

    public pr(vk vkVar, Context context, String str, int i, Map<String, Object> map, Map<String, Object> map2, JSONObject jSONObject) {
        this.w = vkVar;
        this.hw = context;
        this.c = str;
        this.uc = i;
        this.aj = map;
        this.vk = map2;
        this.k = jSONObject;
    }

    @Override // com.byazt.ni.pr
    public boolean pr(Map<String, Object> map) {
        vk vkVar = this.w;
        if (vkVar == null) {
            com.byazt.lx.hw.pr(this.aj, hn.x);
            return false;
        }
        return pr(com.byazt.lx.pr.pr(this.pr, com.byazt.lx.hw.pr(vkVar, this.aj), this.x, this.hn));
    }

    public void pr(com.byazt.ga.hw hwVar) {
        this.zo = hwVar;
    }

    public boolean pr(Class cls) {
        this.pr = false;
        com.byazt.xk.hw.pr().pr("landing_page", "native", 0, pr());
        if (this.w.aj() == 2) {
            return hw(this.w.zo());
        }
        com.byazt.ga.hw hwVar = this.zo;
        if (hwVar != null && new hw(hwVar).pr(new HashMap())) {
            return true;
        }
        Intent intent = new Intent(this.hw, (Class<?>) cls);
        if (!(this.hw instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", this.w.fw());
        pr(intent);
        com.byazt.ca.pr.pr(this.hw, intent, new com.byazt.ca.pr.InterfaceC0030pr() { // from class: com.byazt.ov.pr.1
            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr() {
                pr.this.aj.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr(Throwable th) {
            }
        });
        return true;
    }

    private JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ext", this.w.B_());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.w.c()));
            jSONObject.putOpt("req_id", this.w.ny());
            jSONObject.putOpt("uchain", Boolean.TRUE);
            jSONObject.putOpt("uchain_old", Boolean.TRUE);
            jSONObject.putOpt("interaction_type", Integer.valueOf(this.w.aj()));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    private boolean hw(String str) {
        if (!yb.pr(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(this.hw instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.byazt.ca.pr.pr(this.hw, intent, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void pr(String str) {
        this.fw = str;
    }

    private void pr(Intent intent) {
        if (this.w == null) {
            return;
        }
        Map<String, Object> map = this.aj;
        if (map != null) {
            this.hn.putAll(map);
        }
        Map<String, Object> map2 = this.vk;
        if (map2 != null) {
            this.hn.putAll(map2);
        }
        this.hn.remove(d.R);
        if (TextUtils.isEmpty(this.fw)) {
            this.fw = this.w.zo();
        }
        this.hn.put(BreakpointSQLiteKey.URL, this.fw);
        this.hn.put("gecko_id", this.w.hn());
        this.hn.put("web_title", this.w.A_());
        this.hn.put("sdk_version", Integer.valueOf(iu.x));
        this.hn.put("adid", this.w.x());
        this.hn.put("log_extra", this.w.B_());
        this.hn.put("icon_url", this.w.hw());
        this.hn.put("event_tag", this.c);
        int i = this.uc;
        int i2 = -1;
        if (i != -1) {
            this.hn.put("landing_page_source", Integer.valueOf(i));
        }
        this.hn.put("is_outer_click", Boolean.TRUE);
        vk vkVar = this.w;
        if (vkVar instanceof of) {
            ls.pr(this.hn, (of) vkVar);
        } else {
            JSONObject jSONObject = this.k;
            if (jSONObject != null) {
                ls.pr(this.hn, jSONObject, vkVar.cz());
            }
        }
        Object objRemove = this.hn.remove("landing_page_source");
        if (!(objRemove == null || TextUtils.isEmpty(objRemove.toString()))) {
            try {
                i2 = Integer.parseInt(objRemove.toString());
            } catch (Exception e) {
            }
        }
        intent.putExtra("landing_page_source", i2);
        for (Map.Entry<String, Object> entry : this.hn.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && !"log_extra".equals(key)) {
                intent.putExtra(key, value.toString());
            }
        }
        intent.putExtra("web_dl_factors", com.byazt.lx.hw.hw(this.aj));
    }
}
