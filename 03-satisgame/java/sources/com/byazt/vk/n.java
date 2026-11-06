package com.byazt.vk;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.si.cy;
import com.byazt.si.h;
import com.byazt.si.m;
import com.byazt.si.ur;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_VOICE_IN_PREPARE, 19})
public class n {
    public static volatile n n;
    public Context qg;

    private n() {
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public void n(Context context) {
        if (context == null || this.qg != null) {
            return;
        }
        this.qg = context.getApplicationContext();
    }

    public void n(com.byazt.pp.w.qg qgVar, String str, rv rvVar) {
        if (rvVar == null) {
            return;
        }
        if (w.n().s()) {
            rvVar.n();
            return;
        }
        if (qgVar == null || qgVar.fs == null) {
            rvVar.n();
            return;
        }
        String strN = qgVar.fs.n();
        if (TextUtils.isEmpty(strN)) {
            rvVar.n();
            return;
        }
        String strS = fs.n().s(strN);
        if (TextUtils.isEmpty(strS)) {
            rvVar.n();
            return;
        }
        String strN2 = n(str);
        if (TextUtils.isEmpty(strN2)) {
            rvVar.n();
        } else if (!new File(strS, strN2).exists()) {
            rvVar.n();
        } else {
            n(strN, strS, strN2, rvVar);
        }
    }

    private String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("http")) {
            return str;
        }
        try {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            if (!TextUtils.isEmpty(lastPathSegment)) {
                return lastPathSegment;
            }
            int iLastIndexOf = str.lastIndexOf(47);
            return (iLastIndexOf < 0 || iLastIndexOf >= str.length() + (-1)) ? str : str.substring(iLastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fs.n().qg(str);
    }

    private void n(final String str, String str2, String str3, final rv rvVar) {
        ((h) com.byazt.qp.q.n("local_img_loader")).n(n(str2, str3)).s(str2).q(true).s(false).n(Bitmap.Config.ARGB_8888).s(2).n(new m() { // from class: com.byazt.vk.n.1
            @Override // com.byazt.si.m
            public void n(cy cyVar) {
                Bitmap bitmap = cyVar != null ? (Bitmap) cyVar.s() : null;
                if (bitmap != null && !bitmap.isRecycled()) {
                    n.this.qg(str);
                    rvVar.n(bitmap);
                } else {
                    rvVar.n();
                }
            }

            @Override // com.byazt.si.m
            public void n(int i, String str4, Throwable th) {
                rvVar.n();
            }
        });
    }

    private static ur n(final String str, final String str2) {
        return new ur() { // from class: com.byazt.vk.n.2
            @Override // com.byazt.si.ur
            public SparseArray<Object> l() {
                return null;
            }

            @Override // com.byazt.si.ur
            public int q() {
                return 0;
            }

            @Override // com.byazt.si.ur
            public int s() {
                return 1048576;
            }

            @Override // com.byazt.si.ur
            public String n() {
                return str;
            }

            @Override // com.byazt.si.ur
            public String qg() {
                return str2;
            }
        };
    }
}
