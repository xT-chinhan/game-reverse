package com.byazt.rwn;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import com.byazt.ca.gz;
import com.byazt.hcx.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 568, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public Context pr;

    public c(Context context) {
        this.pr = context.getApplicationContext();
    }

    public void pr(final x xVar, final fw fwVar) {
        if (xVar == null || TextUtils.isEmpty(xVar.pr())) {
            pr(fwVar, xVar, 1001, "Invalid zip config");
            return;
        }
        if (this.pr == null) {
            pr(fwVar, xVar, 1002, "Context is null");
            return;
        }
        String strPr = xVar.pr();
        final String strHn = zo.pr().hn(strPr);
        if (TextUtils.isEmpty(strHn)) {
            pr(fwVar, xVar, 1003, "Invalid cache path");
            return;
        }
        if (!pr(this.pr)) {
            pr(fwVar, xVar, 1004, "Insufficient disk space");
            return;
        }
        try {
            File file = new File(com.byazt.mg.hw.hw(this.pr), "tt_lottie_temp");
            if (!file.exists()) {
                file.mkdirs();
            }
            final String strHw = com.byazt.ca.c.hw(strPr);
            final File file2 = new File(file, strHw);
            com.byazt.ptr.hw.pr(strPr, file, strHw, new com.byazt.ptr.hw.pr() { // from class: com.byazt.rwn.c.1
                @Override // com.byazt.ptr.hw.pr
                public void pr(m mVar) {
                    c.this.pr(xVar, file2, strHn, strHw, fwVar);
                }

                @Override // com.byazt.ptr.hw.pr
                public void pr(Throwable th) {
                    c.this.pr(fwVar, xVar, 1005, th != null ? th.getMessage() : "Unknown error");
                    c.this.pr(file2);
                }
            });
        } catch (Exception e) {
            com.byazt.ptr.uc.pr("Download zip failed: " + e.getMessage(), e);
            pr(fwVar, xVar, 1005, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(x xVar, File file, String str, String str2, fw fwVar) {
        try {
            if (!file.exists()) {
                pr(fwVar, xVar, 1006, "Downloaded file not found");
                return;
            }
            if (!TextUtils.isEmpty(xVar.hw()) && !TextUtils.equals(com.byazt.ca.c.pr(file), xVar.hw())) {
                pr(file);
                pr(fwVar, xVar, 1007, "MD5 verification failed");
                return;
            }
            File file2 = new File(str);
            if (file2.exists()) {
                com.byazt.ca.fw.hn(file2);
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
            gz.pr(file.getAbsolutePath(), file2.getAbsolutePath());
            zo.pr().pr(xVar.pr());
            pr(file);
            pr(fwVar, xVar);
        } catch (Exception e) {
            com.byazt.ptr.uc.pr("Handle download success failed: " + e.getMessage(), e);
            pr(file);
            pr(fwVar, xVar, 1008, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(File file) {
        if (file != null && file.exists()) {
            file.delete();
        }
    }

    private boolean pr(Context context) {
        try {
            File fileHw = com.byazt.mg.hw.hw(context);
            if (fileHw == null) {
                return false;
            }
            StatFs statFs = new StatFs(fileHw.getPath());
            if (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() >= 10485760) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private void pr(fw fwVar, x xVar) {
        if (fwVar != null) {
            fwVar.pr(xVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(fw fwVar, x xVar, int i, String str) {
        if (fwVar != null) {
            fwVar.pr(xVar, i, str);
        }
    }
}
