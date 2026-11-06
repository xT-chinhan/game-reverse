package com.byazt.vku;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 26})
public class qg implements com.byazt.jjq.s {
    public final com.byazt.llp.s n = new com.byazt.llp.s();

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, final Map<String, Object> map2, final com.byazt.dm.n nVar) {
        com.byazt.ukb.qg.n(this.n, nVar.s(), map, map2);
        if (this.n.cp()) {
            return true;
        }
        if (this.n.d()) {
            nVar.qg(map2, null);
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ext", this.n.F_());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.n.l()));
            jSONObject.putOpt("req_id", this.n.ou());
            jSONObject.putOpt("uchain", Boolean.TRUE);
        } catch (JSONException unused) {
        }
        com.byazt.eji.s.n().n("landing_page", "native", 0, jSONObject);
        if (this.n.rv() == 2) {
            boolean zN = n();
            if (zN) {
                com.byazt.ukb.qg.n(map2, com.byazt.wr.s.s);
                nVar.qg(map2);
            } else {
                nVar.qg(map2, null);
            }
            return zN;
        }
        if (this.n.oa() != null && new com.byazt.xwj.qg(this.n.oa()).n(new HashMap())) {
            com.byazt.ukb.qg.n(map2, com.byazt.wr.s.s);
            nVar.qg(map2);
            return true;
        }
        Intent intent = new Intent(this.n.getContext(), com.byazt.ukb.n.n(this.n.cy(), com.byazt.ukb.qg.n(this.n, map2), this.n.hd(), map2));
        if (!(this.n.getContext() instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", this.n.x());
        intent.putExtra("event_tag", this.n.sz());
        if (map == null) {
            k.qg("UChain_LP", "param == null");
            map = new HashMap<>();
        }
        map.putAll(map2);
        map.remove("context");
        Object objRemove = map.remove("landing_page_source");
        com.byazt.vgx.w.n(map, com.byazt.ukb.qg.n(this.n, map2));
        int i = -1;
        if (!(objRemove == null || TextUtils.isEmpty(objRemove.toString()))) {
            try {
                i = Integer.parseInt(objRemove.toString());
            } catch (Exception unused2) {
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
        intent.putExtra("web_dl_factors", com.byazt.ukb.qg.qg(map2));
        com.byazt.tk.n.n(this.n.getContext(), intent, new com.byazt.tk.n.InterfaceC0352n() { // from class: com.byazt.vku.qg.1
            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n() {
                com.byazt.ukb.qg.n((Map<String, Object>) map2, com.byazt.wr.s.s);
                nVar.qg(map2);
                map2.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n(Throwable th) {
                nVar.qg(map2, null);
            }
        });
        return true;
    }

    private boolean n() {
        if (!hd.n(this.n.k())) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(this.n.k()));
            if (!(this.n.getContext() instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.byazt.tk.n.n(this.n.getContext(), intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
