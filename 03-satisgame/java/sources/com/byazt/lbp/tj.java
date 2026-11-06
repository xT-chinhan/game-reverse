package com.byazt.lbp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "open_video_detail_page_direct", qg = "ALL")
    public boolean fs;

    @com.byazt.phr.n(n = "is_open_web_page", qg = "ALL")
    public boolean l;

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk n;

    @com.byazt.phr.n(n = "interaction_type", qg = "ALL")
    public int q;

    @com.byazt.phr.n(n = "context", qg = "ALL")
    public Context qg;

    @com.byazt.phr.n(n = "is_from_video_layout", qg = "ALL")
    public boolean rv;

    @com.byazt.phr.n(n = ImagesContract.URL, qg = "ALL")
    public String s;

    @com.byazt.phr.n(n = "event_tag", qg = "CONTEXT")
    public String tj;

    @com.byazt.phr.n(n = "convert_from_landing_page", qg = "ALL")
    public boolean w;

    @com.byazt.phr.n(n = "pip_controller", qg = "ALL")
    public com.byazt.zx.qg x;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, final Map<String, Object> map2, final com.byazt.dm.n nVar) {
        if (this.l) {
            return true;
        }
        if (this.w) {
            nVar.n(map2, (com.byazt.bds.n) null);
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
        if (this.q == 2) {
            boolean zN = n();
            if (zN) {
                nVar.n(map2);
            } else {
                nVar.n(map2, (com.byazt.bds.n) null);
            }
            return zN;
        }
        if (this.x != null && new com.byazt.xwj.qg(this.x).n(new HashMap())) {
            nVar.n(map2);
            return true;
        }
        Intent intent = new Intent(this.qg, com.byazt.ukb.n.n(this.fs, this.n, this.rv, map2));
        if (!(this.qg instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("event_tag", this.tj);
        pk pkVar = this.n;
        if (pkVar != null) {
            intent.putExtra("get_phone_num_status", pkVar.x());
        }
        if (map == null) {
            com.byazt.tk.k.qg("UChain_LP", "param == null");
            map = new HashMap<>();
        }
        map.putAll(map2);
        map.remove("context");
        map.remove("activity_type");
        Object objRemove = map.remove("landing_page_source");
        com.byazt.vgx.w.n(map, this.n);
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
        com.byazt.tk.n.n(this.qg, intent, new com.byazt.tk.n.InterfaceC0352n() { // from class: com.byazt.lbp.tj.1
            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n() {
                nVar.n(map2);
                map2.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n(Throwable th) {
                nVar.n(map2, (com.byazt.bds.n) null);
                com.byazt.ikv.qg.q(tj.this.n.py(), pk.class);
            }
        });
        return true;
    }

    private boolean n() {
        if (!com.byazt.tk.hd.n(this.s)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(this.s));
            if (!(this.qg instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.byazt.tk.n.n(this.qg, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
