package com.byazt.kq;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.ca.aj;
import com.byazt.ee.z;
import com.byazt.fj.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static final byte[] c = new byte[0];
    public static int uc = 10;
    public static int fw = 10;
    public static volatile c aj = null;
    public final AtomicBoolean zo = new AtomicBoolean(false);
    public final List<SSWebView> pr = new ArrayList();
    public final List<SSWebView> hw = new ArrayList();
    public final WeakHashMap<com.byazt.son.x, hn> hn = new WeakHashMap<>();
    public final WeakHashMap<com.byazt.son.x, x> x = new WeakHashMap<>();

    private c() {
        com.byazt.bg.hn hnVarHn = com.byazt.bg.pr.pr().hn();
        if (hnVarHn != null) {
            uc = hnVarHn.uc();
            fw = hnVarHn.fw();
        }
    }

    public static c pr() {
        if (aj == null) {
            synchronized (c.class) {
                if (aj == null) {
                    aj = new c();
                }
            }
        }
        return aj;
    }

    public SSWebView pr(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (x() <= 0 || (sSWebViewRemove = this.hw.remove(0)) == null) {
            return null;
        }
        this.hw.size();
        return sSWebViewRemove;
    }

    public void pr(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.hw.size() >= fw) {
            sSWebView.destroy();
        } else if (!this.hw.contains(sSWebView)) {
            this.hw.add(sSWebView);
            this.hw.size();
        }
    }

    public void hw(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.S_();
        uc(sSWebView);
        pr(sSWebView);
    }

    public SSWebView hw(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (hn() <= 0 || (sSWebViewRemove = this.pr.remove(0)) == null) {
            return null;
        }
        hn();
        return sSWebViewRemove;
    }

    public void hn(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.S_();
        uc(sSWebView);
        x(sSWebView);
    }

    public void x(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.pr.size() >= uc) {
            sSWebView.destroy();
        } else if (!this.pr.contains(sSWebView)) {
            this.pr.add(sSWebView);
            hn();
        }
    }

    public boolean c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        sSWebView.destroy();
        return true;
    }

    public void hw() {
        for (SSWebView sSWebView : this.pr) {
            if (sSWebView != null) {
                sSWebView.destroy();
            }
        }
        this.pr.clear();
        for (SSWebView sSWebView2 : this.hw) {
            if (sSWebView2 != null) {
                sSWebView2.destroy();
            }
        }
        this.hw.clear();
        synchronized (this.x) {
            this.x.clear();
        }
    }

    public int hn() {
        return this.pr.size();
    }

    public int x() {
        return this.hw.size();
    }

    public int c() {
        return this.pr.size() + x();
    }

    public void pr(SSWebView sSWebView, hw hwVar) {
        if (sSWebView == null || hwVar == null) {
            return;
        }
        hn hnVar = this.hn.get(sSWebView);
        if (hnVar != null) {
            hnVar.pr(hwVar);
        } else {
            hnVar = new hn(hwVar);
            this.hn.put(sSWebView, hnVar);
        }
        sSWebView.addJavascriptInterface(hnVar, "SDK_INJECT_GLOBAL");
    }

    public void uc(SSWebView sSWebView) {
        hn hnVar;
        if (sSWebView != null && (hnVar = this.hn.get(sSWebView)) != null) {
            hnVar.pr(null);
        }
    }

    private static void pr(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            aj.hw().post(runnable);
        }
    }

    public void pr(final com.byazt.son.x xVar, z zVar, final String str) {
        final x xVar2;
        if (xVar == null || zVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.x) {
            xVar2 = this.x.get(xVar);
            if (xVar2 != null) {
                xVar2.pr(zVar);
            } else {
                xVar2 = new x(zVar);
                this.x.put(xVar, xVar2);
            }
        }
        pr(new Runnable() { // from class: com.byazt.kq.c.1
            @Override // java.lang.Runnable
            public void run() {
                xVar.addJavascriptInterface(xVar2, str);
            }
        });
    }

    public void pr(final com.byazt.son.x xVar, final String str) {
        if (xVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.x) {
            x xVar2 = this.x.get(xVar);
            if (xVar2 != null) {
                xVar2.pr(null);
            }
        }
        pr(new Runnable() { // from class: com.byazt.kq.c.2
            @Override // java.lang.Runnable
            public void run() {
                xVar.removeJavascriptInterface(str);
            }
        });
    }
}
