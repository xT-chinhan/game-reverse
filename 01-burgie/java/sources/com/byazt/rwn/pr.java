package com.byazt.rwn;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ld.b;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.ld.ve;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 568, 37})
public class pr {
    public static volatile pr pr;
    public Context hw;

    private pr() {
    }

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    public void pr(Context context) {
        if (context == null || this.hw != null) {
            return;
        }
        this.hw = context.getApplicationContext();
    }

    public void pr(com.byazt.dx.uc.hw hwVar, String str, aj ajVar) {
        if (ajVar == null) {
            return;
        }
        if (uc.pr().hn()) {
            ajVar.pr();
            return;
        }
        if (hwVar == null || hwVar.zo == null) {
            ajVar.pr();
            return;
        }
        String strPr = hwVar.zo.pr();
        if (TextUtils.isEmpty(strPr)) {
            ajVar.pr();
            return;
        }
        String strHn = zo.pr().hn(strPr);
        if (TextUtils.isEmpty(strHn)) {
            ajVar.pr();
            return;
        }
        String strPr2 = pr(str);
        if (TextUtils.isEmpty(strPr2)) {
            ajVar.pr();
        } else if (!new File(strHn, strPr2).exists()) {
            ajVar.pr();
        } else {
            pr(strPr, strHn, strPr2, ajVar);
        }
    }

    private String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http")) {
            try {
                String lastPathSegment = Uri.parse(str).getLastPathSegment();
                if (!TextUtils.isEmpty(lastPathSegment)) {
                    return lastPathSegment;
                }
                int iLastIndexOf = str.lastIndexOf(47);
                if (iLastIndexOf >= 0 && iLastIndexOf < str.length() - 1) {
                    return str.substring(iLastIndexOf + 1);
                }
            } catch (Exception e) {
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zo.pr().hw(str);
    }

    private void pr(final String str, String str2, String str3, final aj ajVar) {
        ((b) com.byazt.zs.uc.pr("local_img_loader")).pr(pr(str2, str3)).hn(str2).x(true).hn(false).pr(Bitmap.Config.ARGB_8888).hn(2).pr(new rc() { // from class: com.byazt.rwn.pr.1
            @Override // com.byazt.ld.rc
            public void pr(nt ntVar) {
                Bitmap bitmap = ntVar != null ? (Bitmap) ntVar.hn() : null;
                if (bitmap != null && !bitmap.isRecycled()) {
                    pr.this.hw(str);
                    ajVar.pr(bitmap);
                } else {
                    ajVar.pr();
                }
            }

            @Override // com.byazt.ld.rc
            public void pr(int i, String str4, Throwable th) {
                ajVar.pr();
            }
        });
    }

    private static ve pr(final String str, final String str2) {
        return new ve() { // from class: com.byazt.rwn.pr.2
            @Override // com.byazt.ld.ve
            public String pr() {
                return str;
            }

            @Override // com.byazt.ld.ve
            public String hw() {
                return str2;
            }

            @Override // com.byazt.ld.ve
            public int hn() {
                return 1048576;
            }

            @Override // com.byazt.ld.ve
            public int x() {
                return 0;
            }

            @Override // com.byazt.ld.ve
            public SparseArray<Object> c() {
                return null;
            }
        };
    }
}
