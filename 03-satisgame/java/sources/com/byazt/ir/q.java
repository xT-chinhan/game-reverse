package com.byazt.ir;

import android.text.TextUtils;
import com.byazt.bf.cp;
import com.byazt.bf.d;
import com.byazt.bf.oa;
import com.byazt.rb.l;
import com.byazt.ws.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODE_SECOND_VIDEO_FRAME_TIME, 5})
public class q {
    public static volatile q n;
    public volatile Map<Integer, com.byazt.gwu.s> qg = new ConcurrentHashMap();
    public Map<String, com.byazt.ws.qg> s = new ConcurrentHashMap();
    public int q = -1;

    private q() {
    }

    public static q n() {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new q();
                }
            }
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gwu.s n(int i) {
        com.byazt.gwu.s sVar = this.qg.get(Integer.valueOf(i));
        if (sVar != null) {
            return sVar;
        }
        com.byazt.gwu.s sVarN = com.byazt.ri.n.n(i);
        this.qg.put(Integer.valueOf(i), sVarN);
        return sVarN;
    }

    private void qg(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        try {
            this.s.clear();
            com.byazt.yc.q.qg.clear();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!z) {
                    jSONObject.put("save_time", System.currentTimeMillis());
                }
                com.byazt.ws.qg qgVarN = com.byazt.ws.qg.n(jSONObject, false);
                if (qgVarN != null && !TextUtils.isEmpty(qgVarN.f())) {
                    this.s.put(qgVarN.f(), qgVarN);
                    concurrentHashMap.put(qgVarN.f(), jSONObject.toString());
                }
            }
            n(concurrentHashMap, z2);
            com.byazt.yc.q.n();
            qg(jSONArray.length());
        } catch (JSONException unused) {
        }
    }

    public void n(JSONArray jSONArray, boolean z, boolean z2) {
        qg(jSONArray, z, z2);
        n(jSONArray);
    }

    private void qg(int i) {
        this.q = i;
        if (com.byazt.qt.qg.n().s()) {
            l.q(new Runnable() { // from class: com.byazt.ir.q.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.ri.n.n().n("prime_rit_count", q.this.q);
                }
            });
        } else {
            com.byazt.ri.n.n().n("prime_rit_count", this.q);
        }
    }

    private void n(final JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        l.q(new Runnable() { // from class: com.byazt.ir.q.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gi.qg.n().n(jSONArray);
            }
        });
    }

    public com.byazt.ws.qg n(String str, int i, int i2) {
        com.byazt.ws.qg qgVarN;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.byazt.ws.qg qgVarX = this.s.get(str);
        if (qgVarX == null && (qgVarX = com.byazt.ws.qg.x(n(i, str))) != null) {
            this.s.put(str, qgVarX);
        }
        return (i2 == 102 || (qgVarN = com.byazt.cby.q.n(qgVarX, i2)) == null) ? qgVarX : qgVarN;
    }

    public String n(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(5);
            arrayList.add(7);
            arrayList.add(8);
            arrayList.add(9);
            arrayList.add(10);
        } else {
            arrayList.add(Integer.valueOf(i));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String string = n(((Integer) it.next()).intValue()).getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return null;
    }

    public void qg() {
        Map<String, com.byazt.ws.qg> map = this.s;
        if (map != null) {
            map.clear();
        }
    }

    public boolean s() {
        if (this.q == -1) {
            this.q = com.byazt.ri.n.n().getInt("prime_rit_count", -1);
        }
        return this.q <= 0;
    }

    private void n(final Map<String, String> map, final boolean z) {
        if (map == null || map.isEmpty()) {
            return;
        }
        l.q(new Runnable() { // from class: com.byazt.ir.q.3
            @Override // java.lang.Runnable
            public void run() {
                if (!z && !com.byazt.qt.n.d().tj()) {
                    q.this.q();
                }
                for (Map.Entry entry : map.entrySet()) {
                    try {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        com.byazt.ws.qg qgVar = (com.byazt.ws.qg) q.this.s.get(str);
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && qgVar != null) {
                            q.this.n(qgVar.fi()).n(str, str2);
                            q.this.n(qgVar);
                        }
                    } catch (Throwable unused) {
                    }
                }
                map.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Iterator it = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).iterator();
        while (it.hasNext()) {
            n(((Integer) it.next()).intValue()).n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.ws.qg qgVar) {
        if (qgVar == null || qgVar.f() == null) {
            return;
        }
        if (qgVar.oa()) {
            if (oa.n().n(qgVar.d())) {
                oa.n().qg(qgVar.d());
            }
            if (oa.n().n(qgVar.cp())) {
                oa.n().qg(qgVar.cp());
            }
        } else {
            oa.n().q(qgVar.f());
            oa.n().rv(qgVar.f());
        }
        for (tj tjVar : qgVar.y()) {
            if (tjVar.q()) {
                if (d.n().n(tjVar.s())) {
                    d.n().qg(tjVar.s());
                }
                if (cp.n().n(tjVar.qg())) {
                    cp.n().qg(tjVar.qg());
                }
            } else {
                d.n().delete(qgVar.f(), tjVar.cd());
                cp.n().delete(qgVar.f(), tjVar.cd());
            }
        }
    }
}
