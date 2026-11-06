package com.byazt.hb;

import android.text.TextUtils;
import com.byazt.ca.g;
import com.byazt.ca.gz;
import com.byazt.ca.ho;
import com.byazt.hcx.m;
import com.byazt.sd.a;
import com.byazt.xlm.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1397, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static volatile c pr;
    public String hn;
    public String hw;
    public AtomicBoolean x = new AtomicBoolean(false);

    public static c pr() {
        if (pr == null) {
            synchronized (c.class) {
                if (pr == null) {
                    pr = new c();
                }
            }
        }
        return pr;
    }

    public void hw() {
        new com.byazt.iq.hw(131072).pr(new Runnable() { // from class: com.byazt.hb.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.c();
            }
        });
    }

    public void pr(String str) {
        try {
            String strHn = hn();
            if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(strHn)) {
                new com.byazt.iq.hw(262144).pr(new Runnable() { // from class: com.byazt.hb.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.c();
                    }
                });
            }
        } catch (Throwable th) {
            ho.hw("LocalDrawableResCacheManager", "doUpdateWhenSetting reszip failed：" + th.getMessage());
        }
    }

    public String hn() {
        String strH = a.hw().h();
        if (TextUtils.isEmpty(strH)) {
            return "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/3f0fb79faf3171023734d003d2a64219-MjAyNjAxMTg.zip";
        }
        return strH;
    }

    public String x() {
        String strHn = hn();
        String str = this.hw;
        if (str != null && str.equalsIgnoreCase(strHn)) {
            return this.hn;
        }
        String strPr = com.byazt.cb.hn.pr(strHn);
        this.hn = strPr;
        this.hw = strHn;
        return strPr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            String strHn = hn();
            if (hw(strHn)) {
                hn(strHn);
            }
        } catch (Throwable th) {
            ho.hw("LocalDrawableResCacheManager", "processUpdate reszip failed：" + th.getMessage());
        }
    }

    private boolean hw(String str) {
        File[] fileArrListFiles;
        String strHw = com.byazt.ca.c.hw(str);
        if (TextUtils.isEmpty(strHw)) {
            return false;
        }
        File file = new File(g.pr(a.getContext()), strHw);
        return !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0;
    }

    private void hn(final String str) {
        if (this.x.get()) {
            return;
        }
        this.x.set(true);
        com.byazt.xlm.c.hw(new fw("downloadZip") { // from class: com.byazt.hb.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.x(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final String str) {
        final String strHw = com.byazt.ca.c.hw(str);
        if (TextUtils.isEmpty(strHw)) {
            return;
        }
        com.byazt.tf.hn.pr(str, g.pr(a.getContext()).getAbsolutePath(), strHw + ".temp").pr(new com.byazt.hcx.fw() { // from class: com.byazt.hb.c.4
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                c.this.x.set(false);
                String strHw2 = com.byazt.ca.c.hw(c.this.hn());
                if (!TextUtils.isEmpty(strHw2) && !strHw2.equalsIgnoreCase(strHw)) {
                    return;
                }
                if (mVar.fw() && mVar.vk() != null && mVar.vk().exists()) {
                    try {
                        File filePr = g.pr(a.getContext());
                        mVar.vk().getAbsolutePath();
                        File file = new File(filePr.getAbsolutePath(), strHw);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        gz.pr(mVar.vk().getAbsolutePath(), file.getAbsolutePath());
                        File[] fileArrListFiles = filePr.listFiles();
                        if (fileArrListFiles != null) {
                            for (File file2 : fileArrListFiles) {
                                if (!strHw.equalsIgnoreCase(file2.getName()) || !file2.isDirectory()) {
                                    com.byazt.ca.fw.hn(file2);
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        ho.pr("LocalDrawableResCacheManager", "unzip reszip failed：", th);
                        return;
                    }
                }
                ho.hw("LocalDrawableResCacheManager", "download reszip failed 1：" + str);
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str2, Throwable th) {
                c.this.x.set(false);
                ho.hw("LocalDrawableResCacheManager", "download resources failed 2：" + str);
            }
        });
    }
}
