package com.byazt.dm;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.vip.s;
import com.byazt.xvf.l;
import com.byazt.xvf.q;
import com.byazt.xvf.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 19})
public class n {
    public int cp;
    public com.byazt.xvf.qg d;
    public String fs;
    public String l;
    public JSONObject n;
    public String q;
    public Map<String, Object> qg;
    public Map<String, Object> rv;
    public com.byazt.fm.n s;
    public boolean tj;
    public q w;
    public q x;

    public n(com.byazt.fm.n nVar, JSONObject jSONObject, Map<String, Object> map) {
        this.cp = 1;
        this.s = nVar;
        this.n = jSONObject;
        this.qg = map;
    }

    public n(String str, int i, JSONObject jSONObject, Map<String, Object> map) {
        this.cp = 1;
        if (i == 2) {
            this.fs = str;
        } else if (i == 3) {
            this.q = str;
        }
        this.cp = i;
        this.n = jSONObject;
        this.qg = map;
    }

    public Map<String, Object> n() {
        return this.qg;
    }

    public Map<String, Object> qg() {
        return this.rv;
    }

    public JSONObject s() {
        return this.n;
    }

    public void n(String str) {
        this.l = str;
    }

    public String q() {
        return this.l;
    }

    public q l() {
        return this.w;
    }

    public void n(q qVar) {
        if (qVar instanceof qg) {
            this.w = qVar;
        } else {
            this.x = qVar;
        }
    }

    public boolean w() {
        return this.tj;
    }

    public void n(boolean z) {
        this.tj = z;
    }

    private void rv() {
        if (this.cp != 2) {
            com.byazt.fm.n nVar = this.s;
            if (nVar == null) {
                return;
            } else {
                this.fs = nVar.qg();
            }
        }
        if (!TextUtils.isEmpty(this.fs)) {
            this.q = Uri.parse(this.fs).getHost();
        }
        if (!TextUtils.isEmpty(this.q)) {
            String str = this.q.split("/")[0];
            this.q = str;
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                iIndexOf = this.q.length();
            }
            this.q = this.q.substring(0, iIndexOf);
        }
        qg(this.fs);
    }

    private void qg(String str) {
        s(str);
        JSONObject jSONObjectN = s.n(str);
        if (jSONObjectN == null) {
            return;
        }
        tj();
        Iterator<String> itKeys = jSONObjectN.keys();
        this.rv = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                Object objOpt = jSONObjectN.opt(next);
                if (objOpt instanceof String) {
                    objOpt = n((String) objOpt, this.n);
                }
                this.rv.put(next, objOpt);
            }
        }
    }

    private static Object n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            return (str.startsWith("${") && str.endsWith("}")) ? com.byazt.sz.n.n(str.substring(2, str.length() - 1)).n(jSONObject) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public void n(com.byazt.xvf.qg qgVar) {
        this.d = qgVar;
    }

    public void x() {
        rv();
        cp();
        com.byazt.xvf.qg qgVar = this.d;
        if (qgVar != null) {
            qgVar.n();
        } else {
            com.byazt.jbj.n.n().n(this.q, this, new com.byazt.xvf.n() { // from class: com.byazt.dm.n.1
            });
        }
    }

    public void n(Map<String, Object> map) {
        l lVarS;
        l lVarS2;
        tj();
        q qVar = this.w;
        if (qVar != null && (lVarS2 = qVar.s()) != null) {
            lVarS2.n(this, map);
        }
        q qVar2 = this.x;
        if (qVar2 == null || (lVarS = qVar2.s()) == null) {
            return;
        }
        lVarS.n(this, map);
    }

    public void n(Map<String, Object> map, com.byazt.bds.n nVar) {
        l lVarS;
        l lVarS2;
        tj();
        q qVar = this.w;
        if (qVar != null && (lVarS2 = qVar.s()) != null) {
            lVarS2.n(this, this.qg, nVar);
        }
        q qVar2 = this.x;
        if (qVar2 == null || (lVarS = qVar2.s()) == null) {
            return;
        }
        lVarS.n(this, map, nVar);
    }

    public void qg(Map<String, Object> map) {
        l lVarS;
        l lVarS2;
        tj();
        q qVar = this.x;
        if (qVar != null && (lVarS2 = qVar.s()) != null) {
            lVarS2.n(this, map);
        }
        q qVar2 = this.w;
        if (qVar2 == null || (lVarS = qVar2.s()) == null) {
            return;
        }
        lVarS.n(this, map);
    }

    public void qg(Map<String, Object> map, com.byazt.bds.n nVar) {
        l lVarS;
        l lVarS2;
        tj();
        q qVar = this.x;
        if (qVar != null && (lVarS2 = qVar.s()) != null) {
            lVarS2.n(this, map, nVar);
        }
        q qVar2 = this.w;
        if (qVar2 == null || (lVarS = qVar2.s()) == null) {
            return;
        }
        lVarS.n(this, map, nVar);
    }

    private void s(String str) {
        w wVarQg;
        w wVarQg2;
        q qVar = this.w;
        if (qVar != null && (wVarQg2 = qVar.qg()) != null) {
            wVarQg2.n(str, this);
        }
        q qVar2 = this.x;
        if (qVar2 == null || (wVarQg = qVar2.qg()) == null) {
            return;
        }
        wVarQg.n(str, this);
    }

    private void tj() {
        w wVarQg;
        w wVarQg2;
        q qVar = this.w;
        if (qVar != null && (wVarQg2 = qVar.qg()) != null) {
            wVarQg2.n(this.n, this);
        }
        q qVar2 = this.x;
        if (qVar2 == null || (wVarQg = qVar2.qg()) == null) {
            return;
        }
        wVarQg.n(this.n, this);
    }

    private void cp() {
        w wVarQg;
        w wVarQg2;
        q qVar = this.w;
        if (qVar != null && (wVarQg2 = qVar.qg()) != null) {
            wVarQg2.n(this.qg, this);
        }
        q qVar2 = this.x;
        if (qVar2 == null || (wVarQg = qVar2.qg()) == null) {
            return;
        }
        wVarQg.n(this.qg, this);
    }

    public com.byazt.fm.n fs() {
        return this.s;
    }
}
