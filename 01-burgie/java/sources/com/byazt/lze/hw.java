package com.byazt.lze;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.ca.yb;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.C;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 936, 13})
public class hw implements com.byazt.lf.hn {
    public final com.byazt.af.hn pr = new com.byazt.af.hn();

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, final Map<String, Object> map2, final com.byazt.hws.pr prVar) {
        com.byazt.lx.hw.pr(this.pr, prVar.hn(), map, map2);
        if (this.pr.w()) {
            return true;
        }
        if (this.pr.k()) {
            prVar.hw(map2, null);
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ext", this.pr.B_());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.pr.c()));
            jSONObject.putOpt("req_id", this.pr.ny());
            jSONObject.putOpt("uchain", Boolean.TRUE);
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().pr("landing_page", "native", 0, jSONObject);
        if (this.pr.aj() == 2) {
            boolean zPr = pr();
            if (zPr) {
                com.byazt.lx.hw.pr(map2, com.byazt.wb.hn.hn);
                prVar.hw(map2);
            } else {
                prVar.hw(map2, null);
            }
            return zPr;
        }
        if (this.pr.m() != null && new com.byazt.ov.hw(this.pr.m()).pr(new HashMap())) {
            com.byazt.lx.hw.pr(map2, com.byazt.wb.hn.hn);
            prVar.hw(map2);
            return true;
        }
        Intent intent = new Intent(this.pr.getContext(), com.byazt.lx.pr.pr(this.pr.nt(), com.byazt.lx.hw.pr(this.pr, map2), this.pr.yb(), map2));
        if (!(this.pr.getContext() instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", this.pr.fw());
        intent.putExtra("event_tag", this.pr.g());
        if (map == null) {
            ho.hw("UChain_LP", "param == null");
            map = new HashMap<>();
        }
        map.putAll(map2);
        map.remove(d.R);
        Object objRemove = map.remove("landing_page_source");
        ls.pr(map, com.byazt.lx.hw.pr(this.pr, map2));
        int i = -1;
        if (!(objRemove == null || TextUtils.isEmpty(objRemove.toString()))) {
            try {
                i = Integer.parseInt(objRemove.toString());
            } catch (Exception e2) {
            }
        }
        intent.putExtra("landing_page_source", i);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && !"log_extra".equals(key)) {
                intent.putExtra(key, value.toString());
            }
        }
        intent.putExtra("web_dl_factors", com.byazt.lx.hw.hw(map2));
        com.byazt.ca.pr.pr(this.pr.getContext(), intent, new com.byazt.ca.pr.InterfaceC0030pr() { // from class: com.byazt.lze.hw.1
            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr() {
                com.byazt.lx.hw.pr((Map<String, Object>) map2, com.byazt.wb.hn.hn);
                prVar.hw(map2);
                map2.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr(Throwable th) {
                prVar.hw(map2, null);
            }
        });
        return true;
    }

    private boolean pr() {
        if (!yb.pr(this.pr.ho())) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(this.pr.ho()));
            if (!(this.pr.getContext() instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.byazt.ca.pr.pr(this.pr.getContext(), intent, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
