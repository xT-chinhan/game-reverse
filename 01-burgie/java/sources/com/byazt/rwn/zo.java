package com.byazt.rwn;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.dx.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 568, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static volatile zo pr;
    public Context hn;
    public int x = 30;
    public final ho<String, Boolean> hw = new ho<String, Boolean>(30) { // from class: com.byazt.rwn.zo.1
        @Override // com.byazt.dx.ho
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int hw(String str, Boolean bool) {
            return 1;
        }

        @Override // com.byazt.dx.ho
        public void pr(boolean z, String str, Boolean bool, Boolean bool2) {
            super.pr(z, str, bool, bool2);
            if (z) {
                zo.this.c(str);
            }
        }
    };

    private zo() {
    }

    public static zo pr() {
        if (pr == null) {
            synchronized (zo.class) {
                if (pr == null) {
                    pr = new zo();
                }
            }
        }
        return pr;
    }

    public void pr(Context context) {
        if (context == null || this.hn != null) {
            return;
        }
        this.hn = context.getApplicationContext();
        com.byazt.xlm.c.hw(new com.byazt.xlm.fw("lotizipurl") { // from class: com.byazt.rwn.zo.2
            @Override // java.lang.Runnable
            public void run() {
                zo.this.hn();
            }
        });
    }

    public void pr(int i) {
        if (i > 0) {
            this.x = i;
            this.hw.pr(i);
        }
    }

    public void pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strX = x(str);
        if (this.hw.pr(strX, 5)) {
            return;
        }
        this.hw.pr(strX, Boolean.TRUE);
        hw();
    }

    public void hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strX = x(str);
        if (!this.hw.pr(strX, 5) && this.hw.pr(strX) != null) {
            this.hw.pr(strX, Boolean.TRUE);
            hw();
        }
    }

    public String hn(String str) {
        File fileHw;
        if (this.hn == null || TextUtils.isEmpty(str) || (fileHw = com.byazt.mg.hw.hw(this.hn)) == null) {
            return null;
        }
        return new File(fileHw, "tt_lottie_imgcac" + File.separator + x(str)).getAbsolutePath();
    }

    public static String x(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return com.byazt.ca.c.hw(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        File fileHw;
        if (this.hn == null || TextUtils.isEmpty(str) || (fileHw = com.byazt.mg.hw.hw(this.hn)) == null) {
            return;
        }
        File file = new File(fileHw, "tt_lottie_imgcac" + File.separator + str);
        if (file.exists() && file.isDirectory()) {
            com.byazt.ca.fw.hn(file);
        }
    }

    private void hw() {
        hw hwVarHw = uc.pr().hw();
        if (hwVarHw == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.hw.pr().keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        hwVarHw.hw("lottie_url_caches", "csj_lottie_zip_url_cache", TextUtils.join(",", arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        String[] strArrSplit;
        hw hwVarHw = uc.pr().hw();
        if (hwVarHw == null) {
            return;
        }
        String strPr = hwVarHw.pr("lottie_url_caches", "csj_lottie_zip_url_cache", null);
        if (!TextUtils.isEmpty(strPr) && (strArrSplit = strPr.split(",")) != null && strArrSplit.length > 0) {
            for (String str : strArrSplit) {
                if (!TextUtils.isEmpty(str)) {
                    this.hw.pr(str, Boolean.TRUE);
                }
            }
        }
    }
}
