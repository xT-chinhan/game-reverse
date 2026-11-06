package com.byazt.ci;

import android.text.TextUtils;
import com.byazt.gct.fs;
import com.byazt.gct.pk;
import com.byazt.vf.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 18})
public class l {
    public final x rv;
    public static final l n = new l(7);
    public static final l qg = new l(8);
    public static final l s = new l(3);
    public static final l q = new l(1);
    public static final l l = new l(5);
    public static final l w = new l(9);
    public static final l x = new l(6);
    public static final l fs = new l(0);

    private l(int i) {
        this.rv = new x(i);
    }

    public static l n(int i) {
        if (i == 1) {
            return q;
        }
        if (i != 3) {
            switch (i) {
                case 5:
                    return l;
                case 6:
                    return x;
                case 7:
                    return n;
                case 8:
                    return qg;
                case 9:
                    return w;
                default:
                    return fs;
            }
        }
        return s;
    }

    public void n(com.byazt.zq.qg qgVar, pk pkVar, boolean z) {
        if (qgVar == null || pkVar == null) {
            return;
        }
        qgVar.q();
        if (fs.n(com.byazt.vgx.w.d(pkVar)).n("forbid_save_cache", new fs.qg.n().n(qgVar).n(pkVar).n())) {
            return;
        }
        if ((pkVar.pz() != null ? pkVar.pz().optInt("save_type") : 0) == 1) {
            return;
        }
        String strQ = qgVar.q();
        String strN = n(pkVar.pv());
        if (strN == null) {
            return;
        }
        String strS = ((k) com.byazt.qp.q.n("encrypt_service")).s(strN);
        long jCurrentTimeMillis = ((((System.currentTimeMillis() / 1000) / 60) / 60) / 3) + ((long) com.byazt.vgx.w.ou(pkVar));
        long jAj = pkVar.aj();
        int iUc = pkVar.uc();
        if (pkVar.ot() > 0) {
            jAj = Math.min(jAj, pkVar.ot());
        }
        this.rv.n(strQ, new x.qg(strS, pkVar.vx(), jAj * 1000, pkVar.cs()), z, jCurrentTimeMillis, iUc);
    }

    public pk n(String str, boolean z, long j) {
        x.qg qgVarN = this.rv.n(str, z, j);
        if (qgVarN == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(((k) com.byazt.qp.q.n("encrypt_service")).q(qgVarN.s));
            if (fs.n(this.rv.n.qg()).n("forbid_read_cache", new fs.qg.n().n(jSONObject).n())) {
                this.rv.n(str, qgVarN.l);
                return null;
            }
            pk pkVarN = com.byazt.vgx.qg.n(jSONObject);
            pkVarN.d(true);
            pkVarN.x(qgVarN.n);
            pkVarN.ln(qgVarN.l);
            pkVarN.kx().qg(2);
            return pkVarN;
        } catch (Exception unused) {
            return null;
        }
    }

    public List<pk> n(String str, boolean z, long j, int i, double d) {
        System.currentTimeMillis();
        List<x.qg> listN = this.rv.n(str, z, j, i, d);
        if (listN == null || listN.isEmpty()) {
            return Collections.emptyList();
        }
        listN.size();
        System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (x.qg qgVar : listN) {
            try {
                JSONObject jSONObject = new JSONObject(((k) com.byazt.qp.q.n("encrypt_service")).q(qgVar.s));
                if (fs.n(this.rv.n.qg()).n("forbid_read_cache", new fs.qg.n().n(jSONObject).n())) {
                    this.rv.n(str, qgVar.l);
                } else {
                    pk pkVarN = com.byazt.vgx.qg.n(jSONObject);
                    pkVarN.d(true);
                    pkVarN.x(qgVar.n);
                    pkVarN.ln(qgVar.l);
                    pkVarN.kx().qg(2);
                    arrayList.add(pkVarN);
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public void n(String str) {
        this.rv.n(str);
    }

    public void qg(String str) {
        this.rv.qg(str);
    }

    public void s(String str) {
        this.rv.s(str);
    }

    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.rv.n(str, str2);
    }

    public boolean q(String str) {
        return this.rv.q(str);
    }

    public long l(String str) {
        x.qg qgVarN = this.rv.n(str, false, 0L);
        if (qgVarN == null || !qgVarN.n()) {
            return 0L;
        }
        long jCurrentTimeMillis = qgVarN.qg - System.currentTimeMillis();
        if (jCurrentTimeMillis <= 0) {
            return 0L;
        }
        return jCurrentTimeMillis / 1000;
    }

    public void n(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.rv.n(str, str2, z);
    }

    public void n() {
        this.rv.n();
    }

    public static boolean n(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        return (pkVar.pz() != null ? pkVar.pz().optInt("save_type") : 0) != 1;
    }

    public static void qg(int i) {
        n(i).rv.n(i);
    }

    private static String n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        for (int i = 0; i < 3; i++) {
            try {
                return jSONObject.toString();
            } catch (ConcurrentModificationException unused) {
            } catch (Throwable unused2) {
                return null;
            }
        }
        return null;
    }
}
