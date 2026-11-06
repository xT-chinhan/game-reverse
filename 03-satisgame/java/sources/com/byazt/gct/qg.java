package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 26})
public class qg {
    public long cp;
    public JSONObject d;
    public long fs;
    public ArrayList<Integer> l;
    public String n;
    public String q;
    public int qg;
    public long rv;
    public int s = 1;
    public long tj;
    public com.byazt.zq.qg w;
    public int x;

    public String n() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    public int qg() {
        return this.qg;
    }

    public void n(int i) {
        this.qg = i;
    }

    public int s() {
        return this.x;
    }

    public void qg(int i) {
        this.x = i;
    }

    public String q() {
        return this.q;
    }

    public void qg(String str) {
        this.q = str;
    }

    public JSONObject l() {
        return this.d;
    }

    public void n(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public int w() {
        return this.s;
    }

    public void s(int i) {
        this.s = i;
    }

    public com.byazt.zq.qg x() {
        return this.w;
    }

    public void n(com.byazt.zq.qg qgVar) {
        this.w = qgVar;
    }

    public ArrayList<Integer> fs() {
        return this.l;
    }

    public void n(ArrayList<Integer> arrayList) {
        this.l = arrayList;
    }

    public static void n(qg qgVar) {
        int iQg;
        if (qgVar == null || qgVar.x() == null || qgVar.x().j() || (iQg = qgVar.qg()) >= 0 || iQg == -8) {
            return;
        }
        com.byazt.eji.s.n().n("rd_client_custom_error", (String) null, (String) null, qgVar.x().a(), new com.byazt.rs.n() { // from class: com.byazt.gct.qg.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObjectL = qg.this.l();
                if (jSONObjectL == null) {
                    jSONObjectL = new JSONObject();
                }
                jSONObjectL.put("from", qg.this.w());
                jSONObjectL.put("err_code", qg.this.qg());
                jSONObjectL.put("err_msg", qg.this.q());
                jSONObjectL.put("server_res_str", qg.this.n());
                if (qg.this.fs() != null && qg.this.fs().size() > 0) {
                    jSONObjectL.put("mate_unavailable_code_list", new JSONArray((Collection) qg.this.fs()).toString());
                }
                Object[] objArr = new Object[2];
                return jSONObjectL;
            }
        });
    }

    public long rv() {
        return this.fs;
    }

    public void n(long j) {
        this.fs = j;
    }

    public long tj() {
        return this.rv;
    }

    public void qg(long j) {
        this.rv = j;
    }

    public long cp() {
        return this.tj;
    }

    public void s(long j) {
        this.tj = j;
    }

    public long d() {
        return this.cp;
    }

    public void q(long j) {
        this.cp = j;
    }
}
