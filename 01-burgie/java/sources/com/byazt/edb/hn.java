package com.byazt.edb;

import android.net.Uri;
import android.os.Handler;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 444, 20})
public class hn {
    public final Handler hn;
    public final Handler hw;
    public final com.byazt.tuy.zo<String, hw> pr;

    public interface pr {
        void pr(String str, List<InetAddress> list);
    }

    /* JADX INFO: renamed from: com.byazt.edb.hn$hn, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 444, MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET})
    private static class C0050hn {
        public static final hn pr = new hn();
    }

    private hn() {
        this.pr = new com.byazt.tuy.zo<>(4, 16, false);
        this.hw = new Handler(com.byazt.udn.hw.pr());
        this.hn = new Handler(com.byazt.gi.c.pr());
    }

    public static hn pr() {
        return C0050hn.pr;
    }

    public void pr(final String str, final pr prVar, final long j) {
        this.hw.post(new Runnable() { // from class: com.byazt.edb.hn.1
            @Override // java.lang.Runnable
            public void run() {
                hn.this.hw(str, prVar, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final String str, final pr prVar, long j) {
        final hw hwVar;
        uc ucVarNy;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.pr) {
                hwVar = this.pr.get(host);
            }
            if (hwVar != null) {
                if (System.currentTimeMillis() - hwVar.hw < com.byazt.ew.pr.hn().pr("dns_expire_min", 10) * 60 * 1000) {
                    if (prVar != null) {
                        prVar.pr(str, hwVar.pr);
                        return;
                    }
                    return;
                }
            }
            Runnable runnable = new Runnable() { // from class: com.byazt.edb.hn.2
                @Override // java.lang.Runnable
                public void run() {
                    pr prVar2 = prVar;
                    if (prVar2 != null) {
                        String str2 = str;
                        hw hwVar2 = hwVar;
                        prVar2.pr(str2, hwVar2 == null ? null : hwVar2.pr);
                    }
                }
            };
            this.hn.postDelayed(runnable, j);
            List<InetAddress> listPr = null;
            if (com.byazt.ew.pr.hn().pr("use_host_dns", 1) == 1 && (ucVarNy = com.byazt.lj.hn.ny()) != null) {
                try {
                    listPr = ucVarNy.pr(host);
                } catch (Throwable th) {
                }
            }
            if (listPr == null || listPr.isEmpty()) {
                try {
                    listPr = com.byazt.lj.hn.fo().pr(host);
                } catch (Throwable th2) {
                }
            }
            if (listPr == null || listPr.isEmpty()) {
                if (hwVar != null) {
                    listPr = hwVar.pr;
                }
            } else {
                pr(host, listPr);
            }
            this.hn.removeCallbacks(runnable);
            if (prVar != null) {
                prVar.pr(str, listPr);
            }
        } catch (Throwable th3) {
        }
    }

    private void pr(String str, List<InetAddress> list) {
        synchronized (this.pr) {
            hw hwVar = this.pr.get(str);
            if (hwVar == null) {
                hwVar = new hw();
                this.pr.put(str, hwVar);
            }
            hwVar.pr = list;
            hwVar.hw = System.currentTimeMillis();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 444, 506})
    private static class hw {
        public long hw;
        public List<InetAddress> pr;

        private hw() {
        }
    }
}
