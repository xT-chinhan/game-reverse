package com.byazt.ed;

import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.gwu.x;
import com.byazt.nf.rv;
import com.byazt.vf.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 854, 18})
public class l {
    private static boolean n(int i) {
        return i == 3 || i == 7 || i == 8;
    }

    public static void n(com.byazt.gct.n nVar, int i, int i2, String str) {
        if (nVar == null || nVar.qg() == null || i2 <= 0) {
            return;
        }
        List<pk> listQg = nVar.qg();
        int size = listQg.size();
        try {
            x xVarS = com.byazt.lk.l.s(str, i + "_prefetch_new");
            delete(i, i2, xVarS, size);
            for (pk pkVar : listQg) {
                String strHa = pkVar.ha();
                String strS = ((k) com.byazt.qp.q.n("encrypt_service")).s(pkVar.pv().toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pre_fetch_time", System.currentTimeMillis());
                jSONObject.put("message", strS);
                xVarS.n(strHa, jSONObject.toString());
            }
        } catch (Throwable unused) {
        }
    }

    private static void delete(int i, int i2, x xVar, int i3) {
        if (xVar == null) {
            return;
        }
        try {
            Map all = xVar.getAll();
            if (all != null && all.size() != 0) {
                int size = all.size();
                if (n(i)) {
                    if (size > 1) {
                        xVar.n();
                        return;
                    }
                    return;
                }
                if (i3 >= i2) {
                    xVar.n();
                    return;
                }
                int i4 = size + i3;
                if (i4 > i2) {
                    PriorityQueue priorityQueue = new PriorityQueue();
                    for (Map.Entry entry : all.entrySet()) {
                        String str = (String) entry.getValue();
                        JSONObject jSONObject = (str == null || !str.contains("pre_fetch_time")) ? null : new JSONObject(str);
                        if (jSONObject != null) {
                            priorityQueue.add(new n((String) entry.getKey(), jSONObject.optLong("pre_fetch_time")));
                        }
                    }
                    int size2 = priorityQueue.size();
                    int i5 = i4 - i2;
                    if (size2 == 0 || size2 < i5) {
                        xVar.n();
                        return;
                    }
                    for (int i6 = 0; i6 < i5; i6++) {
                        n nVar = (n) priorityQueue.poll();
                        if (nVar != null) {
                            xVar.n(nVar.qg);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static pk n(String str, int i, String str2) {
        if (rv.qg().y() <= 0) {
            return null;
        }
        x xVarS = com.byazt.lk.l.s(str2, i + "_prefetch_new");
        String strQg = xVarS.qg(str, "");
        if (!TextUtils.isEmpty(strQg)) {
            try {
                if (strQg.contains("pre_fetch_time")) {
                    strQg = new JSONObject(strQg).optString("message");
                }
                pk pkVarN = com.byazt.vgx.qg.n(new JSONObject(((k) com.byazt.qp.q.n("encrypt_service")).q(strQg)));
                xVarS.n(str);
                return pkVarN;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @com.byazt.cp.n(n = {0, 1, 854, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    static class n implements Comparable<n> {
        public long n;
        public String qg;

        public n(String str, long j) {
            this.qg = str;
            this.n = j;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compareTo(n nVar) {
            if (nVar == null) {
                return 1;
            }
            long j = this.n;
            long j2 = nVar.n;
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        }
    }
}
