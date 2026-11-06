package com.byazt.re;

import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.gct.tj;
import com.byazt.iz.fs;
import com.byazt.nf.rv;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.qit.x;
import com.byazt.tk.k;
import com.byazt.za.NativeExpressView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 796, 19})
public class n {
    public String fs;
    public TTBaseVideoActivity l;
    public ITTInnerDownloadAdapter qg;
    public pk w;
    public String x;
    public final Map<String, ITTInnerDownloadAdapter> n = Collections.synchronizedMap(new HashMap());
    public final s q = new s();
    public View s = null;
    public long rv = 0;
    public long tj = 0;
    public long cp = 0;
    public long d = 0;
    public long oa = 0;
    public long sz = 0;
    public boolean cy = true;
    public boolean k = false;

    /* JADX INFO: renamed from: com.byazt.re.n$n, reason: collision with other inner class name */
    public interface InterfaceC0322n {
        void n(View view, tj tjVar);

        void n(String str, JSONObject jSONObject);
    }

    public interface qg {
        void n(boolean z);

        void n(boolean z, long j, long j2, String str, String str2);

        void n(boolean z, long j, String str, String str2);

        void n(boolean z, String str, String str2);

        void qg(boolean z, long j, long j2, String str, String str2);

        void s(boolean z, long j, long j2, String str, String str2);
    }

    public n(TTBaseVideoActivity tTBaseVideoActivity) {
        this.l = tTBaseVideoActivity;
    }

    public void n(pk pkVar, String str, String str2) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.w = pkVar;
        this.x = str;
        fs();
        this.fs = str2;
    }

    private void fs() {
        pk pkVar = this.w;
        if (pkVar == null || pkVar.rv() != 4) {
            return;
        }
        this.qg = fs.n(this.l, this.w, this.x);
    }

    public void n() {
        pk pkVar;
        if (this.qg == null && (pkVar = this.w) != null && pkVar.rv() == 4) {
            this.qg = fs.n(this.l, this.w, this.x);
        }
    }

    public ITTInnerDownloadAdapter qg() {
        return this.qg;
    }

    public boolean s() {
        return this.qg != null;
    }

    public void q() {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.qg;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.setActivity(this.l, false);
            this.qg.onResume();
        }
        for (Map.Entry<String, ITTInnerDownloadAdapter> entry : this.n.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().onResume();
            }
        }
    }

    public void l() {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.qg;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.onPause();
        }
        for (Map.Entry<String, ITTInnerDownloadAdapter> entry : this.n.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().onPause();
            }
        }
    }

    public void w() {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.qg;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.onDestroy();
        }
        for (Map.Entry<String, ITTInnerDownloadAdapter> entry : this.n.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().onDestroy();
            }
        }
        try {
            n(this.fs);
        } catch (Throwable th) {
            k.n("RewardFullDownloadManager", "remove from ITTAppDownloadListener throw Exception : ", th);
        }
    }

    private void n(String str) {
        com.byazt.qit.l.qg(new q("executeMultiProcessAppDownloadCallBack", str), 5);
    }

    public static com.byazt.nf.l n(int i) {
        return com.byazt.ptd.n.n(com.byazt.prx.n.n(rv.getContext()).n(i));
    }

    public void n(final qg qgVar) {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.qg;
        if (iTTInnerDownloadAdapter == null) {
            return;
        }
        iTTInnerDownloadAdapter.addAppDownloadListener(new AppDownloadListener() { // from class: com.byazt.re.n.1
            @Override // com.byazt.pmn.AppDownloadListener
            public void onIdle() {
                boolean z;
                if (System.currentTimeMillis() - n.this.rv > NativeExpressView.um) {
                    n.this.rv = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.n(z);
                }
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadActive(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - n.this.cp > NativeExpressView.um) {
                    n.this.cp = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.n(z2, j, j2, str, str2);
                }
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadPaused(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - n.this.tj > NativeExpressView.um) {
                    n.this.tj = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.qg(z2, j, j2, str, str2);
                }
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadFailed(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - n.this.d > NativeExpressView.um) {
                    n.this.d = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.s(z2, j, j2, str, str2);
                }
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadFinished(long j, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - n.this.oa > NativeExpressView.um) {
                    n.this.oa = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.n(z2, j, str, str2);
                }
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onInstalled(String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - n.this.sz > NativeExpressView.um) {
                    n.this.sz = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.n(z, str, str2);
                }
            }
        });
    }

    public void n(String str, boolean z) {
        if (this.n.containsKey(str)) {
            ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.n.get(str);
            if (iTTInnerDownloadAdapter != null) {
                if (z) {
                    iTTInnerDownloadAdapter.setCheckCompliance(com.byazt.oh.l.n(this.w));
                }
                if (iTTInnerDownloadAdapter instanceof com.byazt.oh.n) {
                    ((com.byazt.oh.n) iTTInnerDownloadAdapter).n().n(this.cy);
                }
                iTTInnerDownloadAdapter.changeDownloadStatus(com.byazt.vgx.w.h(this.w), false);
                return;
            }
            return;
        }
        ITTInnerDownloadAdapter iTTInnerDownloadAdapterN = fs.n(this.l, str, this.w, this.x);
        if (z) {
            iTTInnerDownloadAdapterN.setCheckCompliance(com.byazt.oh.l.n(this.w));
        }
        if (iTTInnerDownloadAdapterN instanceof com.byazt.oh.n) {
            ((com.byazt.oh.n) iTTInnerDownloadAdapterN).n().n(this.cy);
        }
        this.n.put(str, iTTInnerDownloadAdapterN);
        iTTInnerDownloadAdapterN.changeDownloadStatus(com.byazt.vgx.w.h(this.w), false);
    }

    public void n(final InterfaceC0322n interfaceC0322n) {
        this.qg.addOnEventLogHandler(1, new com.byazt.ms.n.InterfaceC0249n() { // from class: com.byazt.re.n.2
            @Override // com.byazt.ms.n.InterfaceC0249n
            public boolean n(int i, String str, String str2, String str3, Object obj) {
                if (i == 1 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    boolean z = str2.equals("rewarded_video") || str2.equals("fullscreen_interstitial_ad");
                    if (z && str3.equals("click_start")) {
                        interfaceC0322n.n(n.this.s, new tj());
                        n.this.s = null;
                        return true;
                    }
                    if (z) {
                        str3.hashCode();
                        if (str3.equals("click_continue")) {
                            com.byazt.hm.n.qg(n.this.w, str2, "click_play_continue", (Map<String, Object>) null);
                        } else if (str3.equals("click_pause")) {
                            com.byazt.hm.n.qg(n.this.w, str2, "click_play_pause", (Map<String, Object>) null);
                            return true;
                        }
                    }
                }
                return true;
            }
        });
    }

    public void n(View view, InterfaceC0322n interfaceC0322n, tj tjVar) {
        if (this.qg != null && view != null) {
            if (view.getId() == 2114387609) {
                interfaceC0322n.n("click_play_star_level", (JSONObject) null);
                return;
            }
            if (view.getId() == 2114387630) {
                interfaceC0322n.n("click_play_star_nums", (JSONObject) null);
                return;
            } else if (view.getId() == 2114387875) {
                interfaceC0322n.n("click_play_source", (JSONObject) null);
                return;
            } else {
                if (view.getId() == 2114387793) {
                    interfaceC0322n.n("click_play_logo", (JSONObject) null);
                    return;
                }
                return;
            }
        }
        interfaceC0322n.n(view, tjVar);
    }

    public s x() {
        return this.q;
    }

    public void n(com.byazt.cs.n.InterfaceC0149n interfaceC0149n) {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.qg;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.setVideoDataListener(interfaceC0149n);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 796, 1125})
    private static class q extends x {
        public final String n;

        public q(String str, String str2) {
            super(str);
            this.n = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                n.n(3).n(this.n, "recycleRes", 0L, 0L, "", "");
            } catch (Throwable th) {
                k.n("RewardFullDownloadManager", "executeAppDownloadCallback execute throw Exception : ", th);
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 796, 829})
    public class s implements DownloadListener {
        public boolean qg = true;

        public s() {
        }

        public void n(boolean z) {
            this.qg = z;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            n(this.qg);
            n.this.n(str, true);
            n.this.l.n(1);
        }
    }
}
