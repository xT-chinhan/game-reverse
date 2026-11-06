package com.byazt.m;

import android.net.Uri;
import android.os.Handler;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compilance.constants.ComplianceMessage;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, 8})
public class s {
    public final com.byazt.ta.fs<String, qg> n;
    public final Handler qg;
    public final Handler s;

    public interface n {
        void n(String str, List<InetAddress> list);
    }

    /* JADX INFO: renamed from: com.byazt.m.s$s, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR})
    private static class C0243s {
        public static final s n = new s();
    }

    private s() {
        this.n = new com.byazt.ta.fs<>(4, 16, false);
        this.qg = new Handler(com.byazt.r.qg.n());
        this.s = new Handler(com.byazt.l.l.n());
    }

    public static s n() {
        return C0243s.n;
    }

    public void n(final String str, final n nVar, final long j) {
        this.qg.post(new Runnable() { // from class: com.byazt.m.s.1
            @Override // java.lang.Runnable
            public void run() {
                s.this.qg(str, nVar, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final String str, final n nVar, long j) {
        final qg qgVar;
        List<InetAddress> listN;
        w wVarOu;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.n) {
                qgVar = this.n.get(host);
            }
            if (qgVar != null) {
                if (System.currentTimeMillis() - qgVar.qg < com.byazt.f.n.s().n("dns_expire_min", 10) * 60 * 1000) {
                    if (nVar != null) {
                        nVar.n(str, qgVar.n);
                        return;
                    }
                    return;
                }
            }
            Runnable runnable = new Runnable() { // from class: com.byazt.m.s.2
                @Override // java.lang.Runnable
                public void run() {
                    n nVar2 = nVar;
                    if (nVar2 != null) {
                        String str2 = str;
                        qg qgVar2 = qgVar;
                        nVar2.n(str2, qgVar2 == null ? null : qgVar2.n);
                    }
                }
            };
            this.s.postDelayed(runnable, j);
            if (com.byazt.f.n.s().n("use_host_dns", 1) != 1 || (wVarOu = com.byazt.xv.s.ou()) == null) {
                listN = null;
            } else {
                try {
                    listN = wVarOu.n(host);
                } catch (Throwable unused) {
                    listN = null;
                }
            }
            if (listN == null || listN.isEmpty()) {
                try {
                    listN = com.byazt.xv.s.wm().n(host);
                } catch (Throwable unused2) {
                }
            }
            if (listN != null && !listN.isEmpty()) {
                n(host, listN);
            } else if (qgVar != null) {
                listN = qgVar.n;
            }
            this.s.removeCallbacks(runnable);
            if (nVar != null) {
                nVar.n(str, listN);
            }
        } catch (Throwable unused3) {
        }
    }

    private void n(String str, List<InetAddress> list) {
        synchronized (this.n) {
            qg qgVar = this.n.get(str);
            if (qgVar == null) {
                qgVar = new qg();
                this.n.put(str, qgVar);
            }
            qgVar.n = list;
            qgVar.qg = System.currentTimeMillis();
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, 782})
    private static class qg {
        public List<InetAddress> n;
        public long qg;

        private qg() {
        }
    }
}
