package com.byazt.ci;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.byazt.gct.fs;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.vf.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 21})
public class x {
    public static final Map<String, AtomicBoolean> s = new ConcurrentHashMap();
    public n n;
    public final com.byazt.ci.qg qg;

    public x(int i) {
        n nVarQg = qg(i);
        this.n = nVarQg;
        if (nVarQg.w == 1) {
            this.qg = new q();
        } else {
            this.qg = new s();
        }
    }

    public void n(String str, qg qgVar, boolean z, long j, int i) {
        try {
            com.byazt.ci.n nVar = rv.qg().pb() ? new com.byazt.ci.n() { // from class: com.byazt.ci.x.1
                @Override // com.byazt.ci.n
                public void n(qg qgVar2) {
                    try {
                        pk pkVarN = com.byazt.vgx.qg.n(new JSONObject(((k) com.byazt.qp.q.n("encrypt_service")).q(qgVar2.s)));
                        pkVarN.kx().q(3);
                        com.byazt.hm.n.s(pkVarN, com.byazt.wg.qg.AD_TAG_FEED);
                    } catch (Exception unused) {
                    }
                }
            } : null;
            synchronized (l(str)) {
                w wVar = new w();
                wVar.n = z;
                wVar.qg = (int) j;
                wVar.s = i;
                this.qg.n(str, qgVar, wVar, this.n, nVar);
            }
        } catch (Throwable unused) {
        }
    }

    public qg n(String str, boolean z, long j) {
        qg qgVarN;
        try {
            synchronized (l(str)) {
                qgVarN = this.qg.n(str, this.n, j, null);
                if (qgVarN != null && qgVarN.n() && z) {
                    this.qg.n(str, qgVarN.l, true);
                }
            }
            return qgVarN;
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<qg> n(String str, boolean z, long j, int i, double d) {
        ArrayList<qg> arrayList = new ArrayList();
        try {
            synchronized (l(str)) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < i; i2++) {
                    qg qgVarN = this.qg.n(str, this.n, j, arrayList2);
                    if (qgVarN == null || !qgVarN.n()) {
                        break;
                    }
                    arrayList2.add(qgVarN.l);
                    arrayList.add(qgVarN);
                }
                if (d > 0.0d) {
                    int iFloor = (int) Math.floor(((double) i) * d);
                    arrayList.size();
                    if (arrayList.size() < iFloor) {
                        return Collections.emptyList();
                    }
                }
                for (qg qgVar : arrayList) {
                    if (z) {
                        this.qg.n(str, qgVar.l, true);
                    }
                }
                return arrayList;
            }
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    public qg n(String str, long j, List<String> list) {
        qg qgVarN;
        try {
            synchronized (l(str)) {
                System.currentTimeMillis();
                qgVarN = this.qg.n(str, this.n, j, list);
                if (qgVarN != null && qgVarN.n()) {
                    System.currentTimeMillis();
                }
            }
            return qgVarN;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void n() {
        try {
            this.qg.n(this.n);
        } catch (Throwable unused) {
        }
    }

    public void n(String str) {
        try {
            this.qg.n(str);
        } catch (Throwable unused) {
        }
    }

    public void qg(String str) {
        com.byazt.ci.n nVar = rv.qg().tc() ? new com.byazt.ci.n() { // from class: com.byazt.ci.x.2
            @Override // com.byazt.ci.n
            public void n(qg qgVar) {
                try {
                    pk pkVarN = com.byazt.vgx.qg.n(new JSONObject(((k) com.byazt.qp.q.n("encrypt_service")).q(qgVar.s)));
                    pkVarN.kx().q(2);
                    com.byazt.hm.n.s(pkVarN, com.byazt.wg.qg.AD_TAG_FEED);
                } catch (Exception unused) {
                }
            }
        } : null;
        try {
            com.byazt.tk.k.qg("cache_tag", "广告类型 " + this.n.qg + " ---缓存清理中--- rit: " + str);
            this.qg.n(str, this.n, nVar);
        } catch (Throwable unused) {
        }
    }

    public void s(String str) {
        try {
            if (l(str).compareAndSet(false, true)) {
                System.currentTimeMillis();
                this.qg.qg(str);
                System.currentTimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void n(String str, String str2, boolean z) {
        try {
            synchronized (l(str)) {
                this.qg.n(str, str2, z);
            }
        } catch (Throwable unused) {
        }
    }

    public void n(String str, String str2) {
        try {
            synchronized (l(str)) {
                this.qg.n(str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean q(String str) {
        boolean zN;
        try {
            synchronized (l(str)) {
                zN = this.qg.n(str, this.n);
            }
            return zN;
        } catch (Throwable unused) {
            return false;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 1181})
    public static class qg {
        public String l;
        public long n;
        public int q = 7814;
        public long qg;
        public String s;

        public qg(String str, long j, long j2, String str2) {
            this.n = j;
            this.qg = j2;
            this.s = str;
            this.l = str2;
        }

        public boolean n() {
            return (TextUtils.isEmpty(this.s) || this.n == 0) ? false : true;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    public static class n {
        public final int l;
        public final String n;
        public final boolean q;
        public final int qg;
        public final int s;
        public final int w;
        public final int x;

        private n(C0148n c0148n) {
            this.n = c0148n.n;
            this.qg = c0148n.qg;
            this.s = c0148n.s;
            this.q = c0148n.q;
            this.w = c0148n.w;
            this.x = c0148n.x;
            this.l = c0148n.l;
        }

        public String n() {
            return this.n;
        }

        public int qg() {
            return this.qg;
        }

        public boolean s() {
            return this.q;
        }

        public int q() {
            return this.l;
        }

        public int l() {
            return this.x;
        }

        /* JADX INFO: renamed from: com.byazt.ci.x$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 1471})
        public static class C0148n {
            public int qg;
            public int s;
            public String n = "Default";
            public boolean q = true;
            public int l = 1;
            public int w = 0;
            public int x = 1;

            public C0148n n(String str) {
                this.n = str;
                return this;
            }

            public C0148n n(int i) {
                this.qg = i;
                return this;
            }

            public C0148n n(boolean z) {
                this.q = z;
                return this;
            }

            public C0148n qg(int i) {
                this.w = i;
                return this;
            }

            public C0148n s(int i) {
                this.x = i;
                return this;
            }

            public C0148n q(int i) {
                this.l = i;
                return this;
            }

            public n n() {
                return new n(this);
            }
        }
    }

    private n qg(int i) {
        String str;
        fs.s sVarN = fs.n(i);
        switch (i) {
            case 1:
                str = i.o.c;
                break;
            case 2:
            default:
                str = "Default";
                break;
            case 3:
            case 4:
                str = i.o.e;
                break;
            case 5:
                str = "Feed";
                break;
            case 6:
                str = "Stream";
                break;
            case 7:
                str = "Reward";
                break;
            case 8:
                str = "Full";
                break;
            case 9:
                str = "Draw";
                break;
        }
        if (sVarN == null) {
            return new n.C0148n().n();
        }
        return new n.C0148n().n(str).n(i).n(sVarN.fs()).qg(sVarN.l()).s(sVarN.qg()).q(sVarN.s()).n();
    }

    private AtomicBoolean l(String str) {
        Map<String, AtomicBoolean> map = s;
        if (!map.containsKey(str)) {
            map.put(str, new AtomicBoolean(false));
        }
        return map.get(str);
    }

    public void n(int i) {
        this.n = qg(i);
    }
}
