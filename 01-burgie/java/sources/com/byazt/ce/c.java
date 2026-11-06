package com.byazt.ce;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends hn {
    public static volatile c hw;
    public static File pr;
    public AtomicBoolean hn = new AtomicBoolean(true);
    public AtomicBoolean x = new AtomicBoolean(false);
    public boolean c = false;
    public AtomicBoolean uc = new AtomicBoolean(false);
    public AtomicInteger fw = new AtomicInteger(0);
    public AtomicLong zo = new AtomicLong();

    public static c hw() {
        if (hw == null) {
            synchronized (c.class) {
                if (hw == null) {
                    hw = new c();
                }
            }
        }
        return hw;
    }

    private c() {
        zo();
    }

    private void zo() {
        com.byazt.js.c.hw(new com.byazt.xlm.fw(TrackAction.INIT) { // from class: com.byazt.ce.c.1
            @Override // java.lang.Runnable
            public void run() {
                zo.pr();
                c.this.hn.set(false);
                c.this.hn();
                c.this.uc();
                com.byazt.vkw.c cVar = (com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process");
                if (com.byazt.bg.pr.pr().hn() != null && cVar.pr()) {
                    com.byazt.bg.pr.pr().hn().hw().post(new Runnable() { // from class: com.byazt.ce.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (com.byazt.bg.pr.pr().hn() != null) {
                                com.byazt.bg.pr.pr();
                            }
                        }
                    });
                }
            }
        }, 10);
    }

    public void hn() {
        com.byazt.hfm.pr prVarHw = zo.hw();
        if (prVarHw == null || !prVarHw.uc()) {
            return;
        }
        boolean zPr = pr(prVarHw);
        if (!zPr) {
            zo.x();
        }
        this.c = zPr;
    }

    public boolean pr(com.byazt.hfm.pr prVar) {
        if (prVar == null) {
            return false;
        }
        return pr(prVar.pr()) || pr(prVar.c()) || pr(prVar.getResources());
    }

    public boolean x() {
        return this.c;
    }

    public com.byazt.hfm.pr c() {
        return zo.hw();
    }

    @Override // com.byazt.ce.hn
    public File pr() {
        return fw();
    }

    public void uc() {
        pr(false);
    }

    public void pr(boolean z) {
        boolean zPr;
        boolean z2;
        if (this.hn.get()) {
            return;
        }
        try {
            if (this.x.get()) {
                if (z) {
                    this.fw.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z3 = true;
            this.x.set(true);
            com.byazt.hfm.pr prVarHn = com.byazt.bg.pr.pr().hn().hn();
            com.byazt.hfm.pr prVarHw = zo.hw();
            if (prVarHn != null && prVarHn.uc()) {
                if (!zo.hw(prVarHn)) {
                    this.x.set(false);
                    this.zo.set(System.currentTimeMillis());
                    return;
                }
                if (com.byazt.bg.pr.pr().hn() != null) {
                    com.byazt.bg.pr.pr().hn().hw().post(new Runnable() { // from class: com.byazt.ce.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.kq.c.pr().hw();
                        }
                    });
                }
                zo.pr(prVarHn);
                if (prVarHn.c() != null && !TextUtils.isEmpty(prVarHn.c().pr())) {
                    zPr = pr(prVarHn.c().pr());
                } else {
                    zPr = false;
                }
                List<com.byazt.hfm.pr.C0084pr> listPr = null;
                if (prVarHn.pr().size() == 0) {
                    z2 = zPr;
                } else {
                    listPr = pr(prVarHn, prVarHw);
                    z2 = listPr != null;
                }
                if (!zPr) {
                    List<com.byazt.hfm.pr.C0084pr> listHw = hw(prVarHn, prVarHw);
                    if (listPr != null && listHw != null) {
                        listPr.addAll(listHw);
                    } else {
                        listPr = listHw;
                    }
                    if (listHw == null) {
                        z3 = false;
                    }
                    if (listHw == null) {
                        this.x.set(false);
                    }
                    z2 = z3;
                }
                if (z2 && pr(prVarHn)) {
                    zo.pr(prVarHn);
                    zo.hn();
                    hw(listPr);
                }
                hn();
                this.x.set(false);
                this.zo.set(System.currentTimeMillis());
                aj();
                return;
            }
            this.x.set(false);
            pr(109);
        } catch (Throwable th) {
        }
    }

    private void aj() {
        if (this.fw.getAndSet(0) > 0 && System.currentTimeMillis() - this.zo.get() > 600000) {
            uc();
        }
    }

    public static File fw() {
        if (pr == null) {
            try {
                File file = new File(new File(x.pr(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                pr = file;
            } catch (Throwable th) {
                ho.pr("TemplateManager", "getTemplateDir error", th);
            }
        }
        return pr;
    }
}
