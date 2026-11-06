package com.byazt.vk;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.byazt.qk.oa;
import com.byazt.tk.bb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_VOICE_IN_PREPARE, 18})
public class l {
    public Context n;

    public l(Context context) {
        this.n = context.getApplicationContext();
    }

    public void n(final q qVar, final x xVar) {
        if (qVar == null || TextUtils.isEmpty(qVar.n())) {
            n(xVar, qVar, 1001, "Invalid zip config");
            return;
        }
        if (this.n == null) {
            n(xVar, qVar, 1002, "Context is null");
            return;
        }
        String strN = qVar.n();
        final String strS = fs.n().s(strN);
        if (TextUtils.isEmpty(strS)) {
            n(xVar, qVar, 1003, "Invalid cache path");
            return;
        }
        if (!n(this.n)) {
            n(xVar, qVar, 1004, "Insufficient disk space");
            return;
        }
        try {
            File file = new File(com.byazt.qyu.qg.s(this.n), "tt_lottie_temp");
            if (!file.exists()) {
                file.mkdirs();
            }
            final String strQg = com.byazt.tk.l.qg(strN);
            final File file2 = new File(file, strQg);
            com.byazt.nu.qg.n(strN, file, strQg, new com.byazt.nu.qg.n() { // from class: com.byazt.vk.l.1
                @Override // com.byazt.nu.qg.n
                public void n(oa oaVar) {
                    l.this.n(qVar, file2, strS, strQg, xVar);
                }

                @Override // com.byazt.nu.qg.n
                public void n(Throwable th) {
                    l.this.n(xVar, qVar, 1005, th != null ? th.getMessage() : "Unknown error");
                    l.this.n(file2);
                }
            });
        } catch (Exception e) {
            com.byazt.nu.w.n("Download zip failed: " + e.getMessage(), e);
            n(xVar, qVar, 1005, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(q qVar, File file, String str, String str2, x xVar) {
        try {
            if (!file.exists()) {
                n(xVar, qVar, 1006, "Downloaded file not found");
                return;
            }
            if (!TextUtils.isEmpty(qVar.qg()) && !TextUtils.equals(com.byazt.tk.l.n(file), qVar.qg())) {
                n(file);
                n(xVar, qVar, 1007, "MD5 verification failed");
                return;
            }
            File file2 = new File(str);
            if (file2.exists()) {
                com.byazt.tk.x.s(file2);
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
            bb.n(file.getAbsolutePath(), file2.getAbsolutePath());
            fs.n().n(qVar.n());
            n(file);
            n(xVar, qVar);
        } catch (Exception e) {
            com.byazt.nu.w.n("Handle download success failed: " + e.getMessage(), e);
            n(file);
            n(xVar, qVar, PointerIconCompat.TYPE_TEXT, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    private boolean n(Context context) {
        try {
            File fileS = com.byazt.qyu.qg.s(context);
            if (fileS == null) {
                return false;
            }
            StatFs statFs = new StatFs(fileS.getPath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() >= 10485760;
        } catch (Exception unused) {
            return true;
        }
    }

    private void n(x xVar, q qVar) {
        if (xVar != null) {
            xVar.n(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(x xVar, q qVar, int i, String str) {
        if (xVar != null) {
            xVar.n(qVar, i, str);
        }
    }
}
