package com.byazt.ug;

import android.os.Handler;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 5})
public class q {
    public Handler n;
    public com.byazt.vl.l qg;
    public AtomicBoolean s = new AtomicBoolean(false);
    public AtomicBoolean q = new AtomicBoolean(false);

    public q(Handler handler) {
        this.n = handler;
    }

    public void n(com.byazt.vl.l lVar) {
        this.qg = lVar;
    }

    public boolean n() {
        return this.q.get();
    }

    public void n(boolean z) {
        this.q.set(z);
    }

    public void n(final int i, final long j, long j2, final l.n nVar) {
        this.q.set(false);
        if (nVar == null) {
            return;
        }
        if (!com.byazt.rz.l.w(i) || !com.byazt.rz.l.l(i)) {
            nVar.n();
            return;
        }
        long jS = com.byazt.rz.l.s(i);
        this.s.set(false);
        final String downloadUrl = this.qg.qg.getDownloadUrl();
        com.byazt.h.qg qgVarQg = com.byazt.vl.w.n().qg(downloadUrl);
        if (qgVarQg == null) {
            qgVarQg = new com.byazt.h.qg(this.qg.qg, this.qg.s, this.qg.q, 0);
            com.byazt.vl.w.n().n(qgVarQg);
        }
        final com.byazt.h.qg qgVar = qgVarQg;
        qgVar.l(false);
        if (d.oa() != null) {
            d.oa();
            qgVar.qg();
        }
        com.byazt.nb.q.n().n(qgVar.n());
        boolean zQ = com.byazt.rz.l.q(i);
        if (j2 > 0) {
            n(i, downloadUrl, j2, qgVar, j, nVar);
        } else if (zQ) {
            n(downloadUrl, qgVar, new l.qg() { // from class: com.byazt.ug.q.1
                @Override // com.byazt.ug.l.qg
                public void n(long j3) throws Throwable {
                    q.this.n(i, downloadUrl, j3, qgVar, j, nVar);
                }
            });
        } else {
            jS = 0;
        }
        this.n.postDelayed(new Runnable() { // from class: com.byazt.ug.q.2
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.s.get()) {
                    return;
                }
                q.this.s.set(true);
                nVar.n();
            }
        }, jS);
    }

    private void n(String str, com.byazt.h.qg qgVar, final l.qg qgVar2) {
        if (qgVar2 == null) {
            return;
        }
        com.byazt.r.qg.n(str, new com.byazt.m.tj() { // from class: com.byazt.ug.q.3
            @Override // com.byazt.m.tj
            public void n(Map<String, String> map) {
                if (q.this.s.get()) {
                    return;
                }
                q.this.s.set(true);
                long jN = q.this.n(map);
                if (jN > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(jN));
                        jSONObject.putOpt("available_space", Long.valueOf(q.q()));
                    } catch (JSONException unused) {
                    }
                }
                qgVar2.n(jN);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long n(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return 0L;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if ("content-length".equalsIgnoreCase(key)) {
                    return Long.parseLong(value);
                }
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, long j, final com.byazt.h.qg qgVar, long j2, final l.n nVar) throws Throwable {
        this.s.set(true);
        boolean zN = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j));
            } catch (JSONException unused) {
            }
            long jLongValue = (Double.valueOf((com.byazt.rz.l.n(i) + 1.0d) * j).longValue() + com.byazt.rz.l.qg(i)) - j2;
            long jQ = q();
            if (jQ < jLongValue) {
                n(qgVar, jSONObject, jLongValue, jQ);
                n(qgVar);
                long jQ2 = q();
                if (jQ2 < jLongValue) {
                    qgVar.q(true);
                    final String strN = qgVar.n();
                    com.byazt.nb.q.n().n(strN, new com.byazt.nb.l() { // from class: com.byazt.ug.q.4
                    });
                    zN = n(i, qgVar, str, jLongValue);
                    if (zN) {
                        qgVar.l(true);
                    }
                } else {
                    qg(qgVar, jSONObject, jQ, jQ2);
                }
            }
        }
        if (zN) {
            return;
        }
        this.n.post(new Runnable() { // from class: com.byazt.ug.q.5
            @Override // java.lang.Runnable
            public void run() {
                nVar.n();
            }
        });
    }

    private boolean n(int i, com.byazt.h.qg qgVar, String str, long j) {
        if (!com.byazt.rz.l.w(i)) {
            return false;
        }
        if (d.oa() != null) {
            return d.oa().n(i, str, true, j);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException unused) {
        }
        com.byazt.vj.n.n().n("cleanspace_window_show", jSONObject, qgVar);
        return false;
    }

    public static boolean n(final DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        boolean zN = false;
        if (!com.byazt.rz.l.w(id)) {
            return false;
        }
        if (d.oa() != null && (zN = d.oa().n(id, downloadInfo.getUrl(), false, j))) {
            com.byazt.nb.q.n().n(downloadInfo.getUrl(), new com.byazt.nb.l() { // from class: com.byazt.ug.q.6
            });
        }
        return zN;
    }

    public static JSONObject n(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void n(int i) {
        if (com.byazt.rz.l.w(i) && d.oa() != null && d.oa().qg()) {
            d.oa();
        }
    }

    public static long qg() {
        if (d.oa() != null) {
            return d.oa().n();
        }
        return 0L;
    }

    private static void n(com.byazt.h.qg qgVar) throws Throwable {
        long jQ = q();
        if (d.oa() != null) {
            d.oa();
        }
        com.byazt.nb.s.n();
        com.byazt.nb.s.qg();
        if (com.byazt.rz.l.x(qgVar.um())) {
            com.byazt.nb.s.n(d.getContext());
        }
        long jQ2 = q();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(jQ2 - jQ));
        } catch (JSONException unused) {
        }
        com.byazt.vj.n.n().n("clean_quite_finish", jSONObject, qgVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long q() {
        return com.byazt.rz.oa.qg(0L);
    }

    private void n(com.byazt.h.qg qgVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException unused) {
        }
        com.byazt.vj.n.n().n("clean_space_no_enough_for_download", jSONObject, qgVar);
    }

    private void qg(com.byazt.h.qg qgVar, JSONObject jSONObject, long j, long j2) {
        qgVar.d("1");
        com.byazt.vl.rv.n().n(qgVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException unused) {
        }
        com.byazt.vj.n.n().n("cleanspace_download_after_quite_clean", jSONObject, qgVar);
    }
}
