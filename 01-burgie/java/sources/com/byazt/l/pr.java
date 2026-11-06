package com.byazt.l;

import android.text.TextUtils;
import com.byazt.i.x;
import com.byazt.j.hn;
import com.byazt.n.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 767, 37})
public final class pr {
    public static final boolean pr = com.byazt.o.hw.hw();
    public C0118pr hn;
    public HashMap<String, Boolean> hw;

    private pr() {
        this.hw = new HashMap<>();
        hw();
    }

    public static pr pr() {
        return hw.pr;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 767, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private static class hw {
        public static final pr pr = new pr();
    }

    public boolean hw() {
        if (this.hn != null) {
            return true;
        }
        hn hnVarHn = hn();
        if (hnVarHn == null) {
            return false;
        }
        x.pr(true);
        x.pr(1);
        try {
            C0118pr c0118pr = new C0118pr();
            this.hn = c0118pr;
            c0118pr.setName("csj_v_c_preloader");
            this.hn.start();
            x.pr(hnVarHn, com.byazt.y.hw.getContext());
            com.byazt.i.hn.pr();
            com.byazt.i.hn.pr().pr(10485759);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean pr(uc ucVar) {
        if (hw()) {
            this.hn.pr(ucVar);
            return true;
        }
        return false;
    }

    private static hn hn() {
        hn hnVar = null;
        File file = new File(com.byazt.ca.uc.hw(com.byazt.y.hw.getContext(), false, null), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            hn hnVar2 = new hn(file);
            try {
                hnVar2.pr(104857600L);
                return hnVar2;
            } catch (IOException e) {
                hnVar = hnVar2;
                return hnVar;
            }
        } catch (IOException e2) {
        }
    }

    /* JADX INFO: renamed from: com.byazt.l.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 767, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    class C0118pr extends com.byazt.fr.hn {
        public Queue<C0119pr> c;
        public boolean hn;
        public Queue<C0119pr> hw;
        public final Queue<C0119pr> x;

        public C0118pr() {
            super("VideoCachePreloader$PreLoadThread");
            this.x = new ArrayBlockingQueue(10);
            this.hw = new LinkedBlockingQueue();
            this.hn = true;
            this.c = new LinkedBlockingQueue();
        }

        private C0119pr pr(int i, uc ucVar) {
            this.x.size();
            C0119pr c0119prPoll = this.x.poll();
            if (c0119prPoll == null) {
                c0119prPoll = new C0119pr();
            }
            c0119prPoll.pr = i;
            c0119prPoll.uc = ucVar;
            return c0119prPoll;
        }

        private void pr(C0119pr c0119pr) {
            c0119pr.hn = null;
            c0119pr.hw = null;
            c0119pr.pr = -1;
            c0119pr.uc = null;
            this.x.offer(c0119pr);
        }

        private synchronized void hw(C0119pr c0119pr) {
            this.c.add(c0119pr);
            notify();
        }

        private void hn(C0119pr c0119pr) {
            if (c0119pr == null) {
                return;
            }
            this.hw.offer(c0119pr);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.hn) {
                synchronized (this) {
                    if (!this.c.isEmpty()) {
                        pr();
                    }
                    while (!this.hw.isEmpty()) {
                        C0119pr c0119prPoll = this.hw.poll();
                        if (c0119prPoll != null) {
                            switch (c0119prPoll.pr) {
                                case 0:
                                    if (c0119prPoll.hn != null && c0119prPoll.hn.length > 0) {
                                        ArrayList arrayList = new ArrayList();
                                        for (String str : c0119prPoll.hn) {
                                            if (com.byazt.a.pr.pr(str)) {
                                                arrayList.add(str);
                                            }
                                        }
                                        com.byazt.i.hn.pr().pr(false, TextUtils.isEmpty(c0119prPoll.c) ? false : true, c0119prPoll.x, c0119prPoll.hw, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                    }
                                    break;
                                case 1:
                                    com.byazt.i.hn.pr().pr(c0119prPoll.hw);
                                    break;
                                case 2:
                                    com.byazt.i.hn.pr().hw();
                                    break;
                                case 3:
                                    com.byazt.i.hn.pr().hw();
                                    if (x.hw() != null) {
                                        x.hw().pr();
                                    }
                                    if (x.pr() != null) {
                                        x.pr().pr();
                                    }
                                    break;
                                case 4:
                                    com.byazt.i.hn.pr().hw();
                                    this.hn = false;
                                    break;
                            }
                            pr(c0119prPoll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

        private void pr() {
            while (true) {
                C0119pr c0119prPoll = this.c.poll();
                if (c0119prPoll != null) {
                    c0119prPoll.hw = c0119prPoll.uc.ny();
                    c0119prPoll.hn = new String[]{c0119prPoll.uc.ny()};
                    c0119prPoll.x = c0119prPoll.uc.fw();
                    c0119prPoll.c = c0119prPoll.uc.fo();
                    if (!TextUtils.isEmpty(c0119prPoll.uc.fo())) {
                        c0119prPoll.hw = c0119prPoll.uc.fo();
                    }
                    c0119prPoll.uc = null;
                    hn(c0119prPoll);
                } else {
                    return;
                }
            }
        }

        public void pr(uc ucVar) {
            hw(pr(0, ucVar));
        }

        /* JADX INFO: renamed from: com.byazt.l.pr$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 767, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL})
        private class C0119pr {
            public String c;
            public String[] hn;
            public String hw;
            public int pr;
            public uc uc;
            public int x;

            public C0119pr() {
            }
        }
    }
}
