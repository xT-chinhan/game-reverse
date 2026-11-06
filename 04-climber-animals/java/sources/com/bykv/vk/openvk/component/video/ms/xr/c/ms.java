package com.bykv.vk.openvk.component.video.ms.xr.c;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.c.ah;
import com.bykv.vk.openvk.component.video.ms.xr.c;
import com.bykv.vk.openvk.component.video.ms.xr.d;
import com.bykv.vk.openvk.component.video.ms.xr.ka;
import com.bytedance.sdk.component.utils.sl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final boolean f70ms = ah.xr();
    private C0182ms ah;
    private HashMap<String, Boolean> xr;

    private ms() {
        this.xr = new HashMap<>();
        xr();
    }

    public static ms ms() {
        return xr.f73ms;
    }

    private static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final ms f73ms = new ms();
    }

    public boolean xr() {
        if (this.ah != null) {
            return true;
        }
        com.bykv.vk.openvk.component.video.ms.xr.ms.ah ahVarAh = ah();
        if (ahVarAh == null) {
            return false;
        }
        ka.ms(true);
        ka.xr(true);
        ka.ms(1);
        c.ms().d();
        try {
            C0182ms c0182ms = new C0182ms();
            this.ah = c0182ms;
            c0182ms.setName("csj_video_cache_preloader");
            this.ah.start();
            ka.ms(ahVarAh, com.bykv.vk.openvk.component.video.api.ah.getContext());
            d.ah();
            d.ah().ms(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean ms(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        if (!xr()) {
            return false;
        }
        this.ah.ms(dVar);
        return true;
    }

    public String xr(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        if (dVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(dVar.h());
        return c.ms().ms(false, z, z ? dVar.h() : dVar.ao(), dVar.ao());
    }

    private static com.bykv.vk.openvk.component.video.ms.xr.ms.ah ah() {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xr.xr(com.bykv.vk.openvk.component.video.api.ah.getContext()), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        com.bykv.vk.openvk.component.video.ms.xr.ms.ah ahVar = null;
        try {
            com.bykv.vk.openvk.component.video.ms.xr.ms.ah ahVar2 = new com.bykv.vk.openvk.component.video.ms.xr.ms.ah(file);
            try {
                ahVar2.ms(104857600L);
                return ahVar2;
            } catch (IOException e) {
                e = e;
                ahVar = ahVar2;
                sl.ms(e);
                return ahVar;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.ms.xr.c.ms$ms, reason: collision with other inner class name */
    class C0182ms extends com.bytedance.sdk.component.ch.d.ah {
        private boolean ah;
        private final Queue<C0183ms> d;
        private Queue<C0183ms> ka;
        private Queue<C0183ms> xr;

        public C0182ms() {
            super("VideoCachePreloader$PreLoadThread");
            this.d = new ArrayBlockingQueue(10);
            this.xr = new LinkedBlockingQueue();
            this.ah = true;
            this.ka = new LinkedBlockingQueue();
        }

        private C0183ms ms(int i, com.bykv.vk.openvk.component.video.api.ah.d dVar) {
            this.d.size();
            C0183ms c0183msPoll = this.d.poll();
            if (c0183msPoll == null) {
                c0183msPoll = new C0183ms();
            }
            c0183msPoll.f72ms = i;
            c0183msPoll.c = dVar;
            return c0183msPoll;
        }

        private void ms(C0183ms c0183ms) {
            c0183ms.ah = null;
            c0183ms.xr = null;
            c0183ms.f72ms = -1;
            c0183ms.c = null;
            this.d.offer(c0183ms);
        }

        private synchronized void xr(C0183ms c0183ms) {
            this.ka.add(c0183ms);
            notify();
        }

        private void ah(C0183ms c0183ms) {
            if (c0183ms == null) {
                return;
            }
            this.xr.offer(c0183ms);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.ah) {
                synchronized (this) {
                    if (!this.ka.isEmpty()) {
                        ms();
                    }
                    while (!this.xr.isEmpty()) {
                        C0183ms c0183msPoll = this.xr.poll();
                        if (c0183msPoll != null) {
                            int i = c0183msPoll.f72ms;
                            if (i != 0) {
                                if (i == 1) {
                                    d.ah().ms(c0183msPoll.xr);
                                } else if (i == 2) {
                                    d.ah().d();
                                } else if (i == 3) {
                                    d.ah().d();
                                    if (ka.xr() != null) {
                                        ka.xr().ms();
                                    }
                                    if (ka.ms() != null) {
                                        ka.ms().ms();
                                    }
                                } else if (i == 4) {
                                    d.ah().d();
                                    this.ah = false;
                                }
                            } else if (c0183msPoll.ah != null && c0183msPoll.ah.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : c0183msPoll.ah) {
                                    if (com.bykv.vk.openvk.component.video.ms.ah.ms.ms(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.ah().ms(false, !TextUtils.isEmpty(c0183msPoll.ka), c0183msPoll.d, c0183msPoll.xr, (String[]) arrayList.toArray(new String[arrayList.size()]));
                            }
                            ms(c0183msPoll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        sl.ms(e);
                    }
                }
            }
        }

        private void ms() {
            while (true) {
                C0183ms c0183msPoll = this.ka.poll();
                if (c0183msPoll == null) {
                    return;
                }
                c0183msPoll.xr = c0183msPoll.c.ao();
                c0183msPoll.ah = new String[]{c0183msPoll.c.ao()};
                int iXr = c0183msPoll.c.xr();
                if (iXr <= 0) {
                    iXr = c0183msPoll.c.c();
                }
                c0183msPoll.d = iXr;
                c0183msPoll.ka = c0183msPoll.c.h();
                if (!TextUtils.isEmpty(c0183msPoll.c.h())) {
                    c0183msPoll.xr = c0183msPoll.c.h();
                }
                c0183msPoll.c = null;
                ah(c0183msPoll);
            }
        }

        public void ms(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
            xr(ms(0, dVar));
        }

        /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.ms.xr.c.ms$ms$ms, reason: collision with other inner class name */
        private class C0183ms {
            public String[] ah;
            public com.bykv.vk.openvk.component.video.api.ah.d c;
            public int d;
            public String ka;

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public int f72ms;
            public String xr;

            public C0183ms() {
            }
        }
    }
}
