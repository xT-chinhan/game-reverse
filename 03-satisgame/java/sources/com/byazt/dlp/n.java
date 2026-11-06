package com.byazt.dlp;

import android.text.TextUtils;
import com.byazt.lp.s;
import com.byazt.nd.q;
import com.byazt.tk.w;
import com.byazt.zsl.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 511, 19})
public final class n {
    public static final boolean n = com.byazt.nl.qg.qg();
    public HashMap<String, Boolean> qg;
    public C0153n s;

    private n() {
        this.qg = new HashMap<>();
        qg();
    }

    public static n n() {
        return qg.n;
    }

    @com.byazt.cp.n(n = {0, 1, 511, 226})
    private static class qg {
        public static final n n = new n();
    }

    public boolean qg() {
        if (this.s != null) {
            return true;
        }
        s sVarS = s();
        if (sVarS == null) {
            return false;
        }
        q.n(true);
        q.n(1);
        try {
            C0153n c0153n = new C0153n();
            this.s = c0153n;
            c0153n.setName("csj_v_c_preloader");
            this.s.start();
            q.n(sVarS, com.byazt.iza.qg.getContext());
            com.byazt.nd.s.n();
            com.byazt.nd.s.n().n(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean n(l lVar) {
        if (!qg()) {
            return false;
        }
        this.s.n(lVar);
        return true;
    }

    private static s s() {
        s sVar = null;
        File file = new File(w.qg(com.byazt.iza.qg.getContext(), false, null), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            s sVar2 = new s(file);
            try {
                sVar2.n(104857600L);
                return sVar2;
            } catch (IOException unused) {
                sVar = sVar2;
                return sVar;
            }
        } catch (IOException unused2) {
        }
    }

    /* JADX INFO: renamed from: com.byazt.dlp.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 511, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    class C0153n extends com.byazt.xis.s {
        public Queue<C0154n> l;
        public final Queue<C0154n> q;
        public Queue<C0154n> qg;
        public boolean s;

        public C0153n() {
            super("VideoCachePreloader$PreLoadThread");
            this.q = new ArrayBlockingQueue(10);
            this.qg = new LinkedBlockingQueue();
            this.s = true;
            this.l = new LinkedBlockingQueue();
        }

        private C0154n n(int i, l lVar) {
            this.q.size();
            C0154n c0154nPoll = this.q.poll();
            if (c0154nPoll == null) {
                c0154nPoll = new C0154n();
            }
            c0154nPoll.n = i;
            c0154nPoll.w = lVar;
            return c0154nPoll;
        }

        private void n(C0154n c0154n) {
            c0154n.s = null;
            c0154n.qg = null;
            c0154n.n = -1;
            c0154n.w = null;
            this.q.offer(c0154n);
        }

        private synchronized void qg(C0154n c0154n) {
            this.l.add(c0154n);
            notify();
        }

        private void s(C0154n c0154n) {
            if (c0154n == null) {
                return;
            }
            this.qg.offer(c0154n);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.s) {
                synchronized (this) {
                    if (!this.l.isEmpty()) {
                        n();
                    }
                    while (!this.qg.isEmpty()) {
                        C0154n c0154nPoll = this.qg.poll();
                        if (c0154nPoll != null) {
                            int i = c0154nPoll.n;
                            if (i != 0) {
                                if (i == 1) {
                                    com.byazt.nd.s.n().n(c0154nPoll.qg);
                                } else if (i == 2) {
                                    com.byazt.nd.s.n().qg();
                                } else if (i == 3) {
                                    com.byazt.nd.s.n().qg();
                                    if (q.qg() != null) {
                                        q.qg().n();
                                    }
                                    if (q.n() != null) {
                                        q.n().n();
                                    }
                                } else if (i == 4) {
                                    com.byazt.nd.s.n().qg();
                                    this.s = false;
                                }
                            } else if (c0154nPoll.s != null && c0154nPoll.s.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : c0154nPoll.s) {
                                    if (com.byazt.cmv.n.n(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                com.byazt.nd.s.n().n(false, !TextUtils.isEmpty(c0154nPoll.l), c0154nPoll.q, c0154nPoll.qg, (String[]) arrayList.toArray(new String[arrayList.size()]));
                            }
                            n(c0154nPoll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }

        private void n() {
            while (true) {
                C0154n c0154nPoll = this.l.poll();
                if (c0154nPoll == null) {
                    return;
                }
                c0154nPoll.qg = c0154nPoll.w.ou();
                c0154nPoll.s = new String[]{c0154nPoll.w.ou()};
                c0154nPoll.q = c0154nPoll.w.x();
                c0154nPoll.l = c0154nPoll.w.wm();
                if (!TextUtils.isEmpty(c0154nPoll.w.wm())) {
                    c0154nPoll.qg = c0154nPoll.w.wm();
                }
                c0154nPoll.w = null;
                s(c0154nPoll);
            }
        }

        public void n(l lVar) {
            qg(n(0, lVar));
        }

        /* JADX INFO: renamed from: com.byazt.dlp.n$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 511, 512})
        private class C0154n {
            public String l;
            public int n;
            public int q;
            public String qg;
            public String[] s;
            public l w;

            public C0154n() {
            }
        }
    }
}
