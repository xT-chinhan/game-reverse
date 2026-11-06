package com.byazt.vk;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.pp.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_VOICE_IN_PREPARE, 101})
public class fs {
    public static volatile fs n;
    public int q = 30;
    public final k<String, Boolean> qg = new k<String, Boolean>(this.q) { // from class: com.byazt.vk.fs.1
        @Override // com.byazt.pp.k
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int qg(String str, Boolean bool) {
            return 1;
        }

        @Override // com.byazt.pp.k
        public void n(boolean z, String str, Boolean bool, Boolean bool2) {
            super.n(z, str, bool, bool2);
            if (z) {
                fs.this.l(str);
            }
        }
    };
    public Context s;

    private fs() {
    }

    public static fs n() {
        if (n == null) {
            synchronized (fs.class) {
                if (n == null) {
                    n = new fs();
                }
            }
        }
        return n;
    }

    public void n(Context context) {
        if (context == null || this.s != null) {
            return;
        }
        this.s = context.getApplicationContext();
        com.byazt.qit.l.qg(new com.byazt.qit.x("lotizipurl") { // from class: com.byazt.vk.fs.2
            @Override // java.lang.Runnable
            public void run() {
                fs.this.s();
            }
        });
    }

    public void n(int i) {
        if (i > 0) {
            this.q = i;
            this.qg.n(i);
        }
    }

    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strQ = q(str);
        if (this.qg.n(strQ, 5)) {
            return;
        }
        this.qg.n(strQ, Boolean.TRUE);
        qg();
    }

    public void qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strQ = q(str);
        if (this.qg.n(strQ, 5) || this.qg.n(strQ) == null) {
            return;
        }
        this.qg.n(strQ, Boolean.TRUE);
        qg();
    }

    public String s(String str) {
        File fileS;
        if (this.s == null || TextUtils.isEmpty(str) || (fileS = com.byazt.qyu.qg.s(this.s)) == null) {
            return null;
        }
        return new File(fileS, "tt_lottie_imgcac" + File.separator + q(str)).getAbsolutePath();
    }

    public static String q(String str) {
        return TextUtils.isEmpty(str) ? "" : com.byazt.tk.l.qg(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        File fileS;
        if (this.s == null || TextUtils.isEmpty(str) || (fileS = com.byazt.qyu.qg.s(this.s)) == null) {
            return;
        }
        File file = new File(fileS, "tt_lottie_imgcac" + File.separator + str);
        if (file.exists() && file.isDirectory()) {
            com.byazt.tk.x.s(file);
        }
    }

    private void qg() {
        qg qgVarQg = w.n().qg();
        if (qgVarQg == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.qg.n().keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        qgVarQg.qg("lottie_url_caches", "csj_lottie_zip_url_cache", TextUtils.join(",", arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        String[] strArrSplit;
        qg qgVarQg = w.n().qg();
        if (qgVarQg == null) {
            return;
        }
        String strN = qgVarQg.n("lottie_url_caches", "csj_lottie_zip_url_cache", null);
        if (TextUtils.isEmpty(strN) || (strArrSplit = strN.split(",")) == null || strArrSplit.length <= 0) {
            return;
        }
        for (String str : strArrSplit) {
            if (!TextUtils.isEmpty(str)) {
                this.qg.n(str, Boolean.TRUE);
            }
        }
    }
}
