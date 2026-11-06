package com.byazt.aun;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 898, 19})
public class n {
    public double cd;
    public boolean d;
    public Object fs;
    public String n;
    public long oa;
    public long py;
    public String q;
    public String qg;
    public String s;
    public long sz;
    public Boolean tj;
    public Object x;
    public List<Long> l = new CopyOnWriteArrayList();
    public Map<String, JSONObject> w = new ConcurrentHashMap();
    public StringBuilder rv = new StringBuilder();
    public List<s.n> cp = new CopyOnWriteArrayList();
    public long k = 0;
    public List<C0130n> cy = new CopyOnWriteArrayList();
    public List<C0130n> hd = new CopyOnWriteArrayList();
    public List<qg> um = new CopyOnWriteArrayList();
    public boolean a = true;

    public void n(long j) {
        n(j, false);
    }

    public void n(long j, boolean z) {
        if (this.d && z) {
            long j2 = (j / 1000) / this.oa;
            if (j2 > this.k) {
                qg();
                List<C0130n> listQg = qg(j2);
                if (listQg != null && !listQg.isEmpty()) {
                    s.n nVarN = n(j2, this.py);
                    qg(listQg, nVarN);
                    s.n(nVarN);
                }
                List<Long> listS = s(j2);
                if (listS != null && !listS.isEmpty()) {
                    s.n nVarN2 = n(j2, this.py);
                    n(listS, nVarN2);
                    s.n(nVarN2);
                }
                List<C0130n> listQ = q(j2);
                if (listQ != null && !listQ.isEmpty()) {
                    s.n nVarN3 = n(j2, this.py);
                    s(listQ, nVarN3);
                    s.n(nVarN3);
                }
                List<qg> listL = l(j2);
                if (listL != null && !listL.isEmpty()) {
                    s.n nVarN4 = n(j2, this.py);
                    q(listL, nVarN4);
                    s.n(nVarN4);
                }
                this.k = j2;
            }
        }
        this.py = j;
    }

    public long n() {
        return this.py;
    }

    private s.n n(long j, long j2) {
        for (s.n nVar : this.cp) {
            if (nVar.l == j) {
                return nVar;
            }
        }
        s.n nVar2 = new s.n();
        nVar2.n = UUID.randomUUID().toString();
        nVar2.qg = this.q;
        nVar2.s = 0;
        nVar2.q = this.qg;
        nVar2.l = j;
        nVar2.w = this.oa;
        nVar2.x = this.s;
        nVar2.rv = this.n;
        nVar2.d = j2;
        this.cp.add(nVar2);
        return nVar2;
    }

    public void qg() {
        if (this.d) {
            long jCurrentTimeMillis = ((System.currentTimeMillis() / 1000) - this.sz) / this.oa;
            for (s.n nVar : this.cp) {
                if (nVar.l <= jCurrentTimeMillis) {
                    this.cp.remove(nVar);
                }
            }
        }
    }

    public void s() {
        qg();
    }

    public void q() {
        List<C0130n> list = this.cy;
        if (list != null && !list.isEmpty()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - (this.sz * 1000);
            for (C0130n c0130n : this.cy) {
                if (c0130n != null && c0130n.n < jCurrentTimeMillis) {
                    this.cy.remove(c0130n);
                }
            }
        }
        List<Long> list2 = this.l;
        if (list2 != null && !list2.isEmpty()) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - (this.sz * 1000);
            for (Long l : this.l) {
                if (l != null && l.longValue() < jCurrentTimeMillis2) {
                    this.l.remove(l);
                }
            }
        }
        List<C0130n> list3 = this.hd;
        if (list3 != null && !list3.isEmpty()) {
            long jCurrentTimeMillis3 = System.currentTimeMillis() - (this.sz * 1000);
            for (C0130n c0130n2 : this.hd) {
                if (c0130n2 != null && c0130n2.n < jCurrentTimeMillis3) {
                    this.hd.remove(c0130n2);
                }
            }
        }
        List<qg> list4 = this.um;
        if (list4 != null && !list4.isEmpty()) {
            long jCurrentTimeMillis4 = System.currentTimeMillis() - (this.sz * 1000);
            for (qg qgVar : this.um) {
                if (qgVar != null && qgVar.n < jCurrentTimeMillis4) {
                    this.um.remove(qgVar);
                }
            }
        }
        l();
    }

    private void l() {
        while (!this.cy.isEmpty()) {
            List<C0130n> listW = w();
            if (listW != null && !listW.isEmpty()) {
                long j = (listW.get(0).n / 1000) / this.oa;
                s.n nVarN = n(j, System.currentTimeMillis());
                qg(listW, nVarN);
                s.n(nVarN);
                if (j > this.k) {
                    this.k = j;
                }
            }
        }
        while (true) {
            List<Long> list = this.l;
            if (list == null || list.isEmpty()) {
                break;
            }
            List<Long> listX = x();
            if (listX != null && !listX.isEmpty()) {
                long jLongValue = (listX.get(0).longValue() / 1000) / this.oa;
                s.n nVarN2 = n(jLongValue, System.currentTimeMillis());
                n(listX, nVarN2);
                s.n(nVarN2);
                if (jLongValue > this.k) {
                    this.k = jLongValue;
                }
            }
        }
        while (true) {
            List<C0130n> list2 = this.hd;
            if (list2 == null || list2.isEmpty()) {
                break;
            }
            List<C0130n> listFs = fs();
            if (listFs != null && !listFs.isEmpty()) {
                long j2 = (listFs.get(0).n / 1000) / this.oa;
                s.n nVarN3 = n(j2, System.currentTimeMillis());
                s(listFs, nVarN3);
                s.n(nVarN3);
                if (j2 > this.k) {
                    this.k = j2;
                }
            }
        }
        while (true) {
            List<qg> list3 = this.um;
            if (list3 == null || list3.isEmpty()) {
                return;
            }
            List<qg> listRv = rv();
            if (listRv != null && !listRv.isEmpty()) {
                long j3 = (listRv.get(0).n / 1000) / this.oa;
                s.n nVarN4 = n(j3, System.currentTimeMillis());
                q(listRv, nVarN4);
                s.n(nVarN4);
                if (j3 > this.k) {
                    this.k = j3;
                }
            }
        }
    }

    private List<C0130n> w() {
        if (this.cy.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long j = (this.cy.get(0).n / 1000) / this.oa;
        for (C0130n c0130n : this.cy) {
            if (c0130n != null && (c0130n.n / 1000) / this.oa == j) {
                arrayList.add(c0130n);
                this.cy.remove(c0130n);
            }
        }
        return arrayList;
    }

    private List<C0130n> qg(long j) {
        if (this.cy.isEmpty()) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (C0130n c0130n : this.cy) {
            if ((c0130n.n / 1000) / this.oa == j) {
                copyOnWriteArrayList.add(c0130n);
                this.cy.remove(c0130n);
            }
        }
        return copyOnWriteArrayList;
    }

    private List<Long> s(long j) {
        List<Long> list = this.l;
        if (list == null || list.isEmpty()) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (Long l : this.l) {
            if (l != null && (l.longValue() / 1000) / this.oa == j) {
                copyOnWriteArrayList.add(l);
                this.l.remove(l);
            }
        }
        return copyOnWriteArrayList;
    }

    private List<Long> x() {
        List<Long> list = this.l;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Long l = this.l.get(0);
        if (l == null) {
            return arrayList;
        }
        long jLongValue = (l.longValue() / 1000) / this.oa;
        for (Long l2 : this.l) {
            if (l2 != null && (l2.longValue() / 1000) / this.oa == jLongValue) {
                arrayList.add(l2);
                this.l.remove(l2);
            }
        }
        return arrayList;
    }

    private void n(List<Long> list, s.n nVar) {
        if (list == null || list.isEmpty() || nVar == null || !"count".equals(nVar.rv)) {
            return;
        }
        long jLongValue = nVar.d;
        long j = 0;
        for (Long l : list) {
            if (l != null) {
                j++;
                if (l.longValue() > jLongValue) {
                    jLongValue = l.longValue();
                }
            }
        }
        nVar.tj += j;
        nVar.d = jLongValue;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void qg(List<C0130n> list, s.n nVar) {
        String str;
        if (list == null || list.isEmpty() || nVar == null || (str = nVar.rv) == null) {
            return;
        }
        long j = nVar.tj;
        double d = nVar.fs;
        long j2 = nVar.d;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 96978:
                if (str.equals("avg")) {
                    b = 0;
                }
                break;
            case 107876:
                if (str.equals("max")) {
                    b = 1;
                }
                break;
            case 108114:
                if (str.equals("min")) {
                    b = 2;
                }
                break;
            case 114251:
                if (str.equals("sum")) {
                    b = 3;
                }
                break;
        }
        double d2 = 0.0d;
        long j3 = 0;
        switch (b) {
            case 0:
                long j4 = 0;
                for (C0130n c0130n : list) {
                    if (c0130n != null) {
                        d2 += c0130n.qg;
                        j4++;
                        if (c0130n.n > j2) {
                            j2 = c0130n.n;
                        }
                    }
                }
                long j5 = j + j4;
                if (j5 > 0) {
                    nVar.fs = ((d * j) + d2) / j5;
                }
                nVar.tj = j5;
                break;
            case 1:
                if (j <= 0) {
                    d = Double.NEGATIVE_INFINITY;
                }
                for (C0130n c0130n2 : list) {
                    if (c0130n2 != null) {
                        if (c0130n2.qg > d) {
                            d = c0130n2.qg;
                        }
                        j3++;
                        if (c0130n2.n > j2) {
                            j2 = c0130n2.n;
                        }
                    }
                }
                nVar.fs = d;
                nVar.tj = j + j3;
                break;
            case 2:
                if (j <= 0) {
                    d = Double.POSITIVE_INFINITY;
                }
                for (C0130n c0130n3 : list) {
                    if (c0130n3 != null) {
                        if (c0130n3.qg < d) {
                            d = c0130n3.qg;
                        }
                        j3++;
                        if (c0130n3.n > j2) {
                            j2 = c0130n3.n;
                        }
                    }
                }
                nVar.fs = d;
                nVar.tj = j + j3;
                break;
            case 3:
                Iterator<C0130n> it = list.iterator();
                while (it.hasNext()) {
                    C0130n next = it.next();
                    if (next != null) {
                        Iterator<C0130n> it2 = it;
                        long j6 = j;
                        d2 += next.qg;
                        j3++;
                        if (next.n > j2) {
                            j2 = next.n;
                        }
                        it = it2;
                        j = j6;
                    }
                }
                nVar.fs = d + d2;
                nVar.tj = j + j3;
                break;
            default:
                return;
        }
        nVar.d = j2;
    }

    /* JADX INFO: renamed from: com.byazt.aun.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 898, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0130n {
        public final long n;
        public final double qg;

        public C0130n(long j, double d) {
            this.n = j;
            this.qg = d;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 898, 226})
    public static class qg {
        public final long n;
        public final Object qg;
        public final double s;

        public qg(long j, Object obj, double d) {
            this.n = j;
            this.qg = obj;
            this.s = d;
        }
    }

    private List<C0130n> q(long j) {
        List<C0130n> list = this.hd;
        if (list == null || list.isEmpty()) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (C0130n c0130n : this.hd) {
            if (c0130n != null && (c0130n.n / 1000) / this.oa == j) {
                copyOnWriteArrayList.add(c0130n);
                this.hd.remove(c0130n);
            }
        }
        return copyOnWriteArrayList;
    }

    private List<C0130n> fs() {
        List<C0130n> list = this.hd;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        C0130n c0130n = this.hd.get(0);
        if (c0130n == null) {
            return arrayList;
        }
        long j = (c0130n.n / 1000) / this.oa;
        for (C0130n c0130n2 : this.hd) {
            if (c0130n2 != null && (c0130n2.n / 1000) / this.oa == j) {
                arrayList.add(c0130n2);
                this.hd.remove(c0130n2);
            }
        }
        return arrayList;
    }

    private void s(List<C0130n> list, s.n nVar) {
        if (list == null || list.isEmpty() || nVar == null || !"quantile".equals(nVar.rv)) {
            return;
        }
        List<Double> listN = n(nVar.cp);
        long j = nVar.d;
        long j2 = 0;
        for (C0130n c0130n : list) {
            if (c0130n != null) {
                listN.add(Double.valueOf(c0130n.qg));
                j2++;
                if (c0130n.n > j) {
                    j = c0130n.n;
                }
            }
        }
        nVar.cp = n(listN);
        nVar.tj += j2;
        nVar.d = j;
    }

    public static List<Double> n(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Double.valueOf(jSONArray.optDouble(i, 0.0d)));
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static String n(List<Double> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (Double d : list) {
                if (d != null) {
                    try {
                        jSONArray.put(d.doubleValue());
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return jSONArray.toString();
    }

    private List<qg> l(long j) {
        List<qg> list = this.um;
        if (list == null || list.isEmpty()) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (qg qgVar : this.um) {
            if (qgVar != null && (qgVar.n / 1000) / this.oa == j) {
                copyOnWriteArrayList.add(qgVar);
                this.um.remove(qgVar);
            }
        }
        return copyOnWriteArrayList;
    }

    private List<qg> rv() {
        List<qg> list = this.um;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        qg qgVar = this.um.get(0);
        if (qgVar == null) {
            return arrayList;
        }
        long j = (qgVar.n / 1000) / this.oa;
        for (qg qgVar2 : this.um) {
            if (qgVar2 != null && (qgVar2.n / 1000) / this.oa == j) {
                arrayList.add(qgVar2);
                this.um.remove(qgVar2);
            }
        }
        return arrayList;
    }

    private void q(List<qg> list, s.n nVar) {
        if (list == null || list.isEmpty() || nVar == null || !"sequence".equals(nVar.rv)) {
            return;
        }
        List<qg> listQg = qg(nVar.cp);
        long j = nVar.d;
        for (qg qgVar : list) {
            if (qgVar != null) {
                listQg.add(qgVar);
                if (qgVar.n > j) {
                    j = qgVar.n;
                }
            }
        }
        nVar.cp = qg(listQg);
        nVar.tj = listQg.size();
        nVar.d = j;
    }

    public static List<qg> qg(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONArray jSONArrayOptJSONArray = jSONArray.optJSONArray(i);
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() >= 3) {
                        arrayList.add(new qg(jSONArrayOptJSONArray.optLong(0, 0L), jSONArrayOptJSONArray.opt(1), jSONArrayOptJSONArray.optDouble(2, 0.0d)));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static String qg(List<qg> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (qg qgVar : list) {
                if (qgVar != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(qgVar.n);
                    jSONArray2.put(qgVar.qg);
                    try {
                        jSONArray2.put(qgVar.s);
                        jSONArray.put(jSONArray2);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return jSONArray.toString();
    }
}
