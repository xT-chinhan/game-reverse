package com.byazt.tk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 110})
public class sz {
    public static volatile File n;
    public static n qg;

    public interface n {
        String n();

        String qg();
    }

    public static void n(final Context context, final String str, final View view, int i) {
        n(context, str, new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.tk.sz.1
            @Override // com.byazt.qyj.n
            public void n(final Bitmap bitmap) {
                sz.qg(new Runnable() { // from class: com.byazt.tk.sz.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (view != null) {
                                view.setBackground(new BitmapDrawable(context.getResources(), bitmap));
                            }
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                });
            }
        }, i);
    }

    public static void n(final Context context, final String str, final ImageView imageView, int i) {
        n(context, str, new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.tk.sz.2
            @Override // com.byazt.qyj.n
            public void n(final Bitmap bitmap) {
                sz.qg(new Runnable() { // from class: com.byazt.tk.sz.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (imageView != null) {
                                imageView.setImageDrawable(new BitmapDrawable(context.getResources(), bitmap));
                            }
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                });
            }
        }, i);
    }

    public static void n(Context context, final String str, final com.byazt.qyj.n<Bitmap> nVar, final int i) {
        com.byazt.si.h hVar = (com.byazt.si.h) com.byazt.qp.q.n("local_img_loader");
        File file = !TextUtils.isEmpty(qg.qg()) ? new File(n(context), qg.qg()) : null;
        String absolutePath = file != null ? file.getAbsolutePath() : null;
        hVar.n(n(absolutePath, com.byazt.wvr.s.n(str))).s(absolutePath).q(true).s(true).n(Bitmap.Config.ARGB_8888).s(2).n(new com.byazt.si.m() { // from class: com.byazt.tk.sz.3
            @Override // com.byazt.si.m
            public void n(com.byazt.si.cy cyVar) {
                Bitmap bitmap = cyVar != null ? (Bitmap) cyVar.s() : null;
                if (bitmap != null) {
                    sz.qg(bitmap, (com.byazt.qyj.n<Bitmap>) nVar, i);
                } else {
                    sz.qg(str, (com.byazt.qyj.n<Bitmap>) nVar, i);
                }
            }

            @Override // com.byazt.si.m
            public void n(int i2, String str2, Throwable th) {
                sz.qg(str, (com.byazt.qyj.n<Bitmap>) nVar, i);
            }
        }, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(String str, final com.byazt.qyj.n<Bitmap> nVar, final int i) {
        n nVar2 = qg;
        ((com.byazt.si.ou) com.byazt.qp.q.n("img_service")).n(((nVar2 == null || TextUtils.isEmpty(nVar2.n())) ? null : qg.n()) + str).n(Bitmap.Config.ARGB_8888).s(2).n(new com.byazt.si.m() { // from class: com.byazt.tk.sz.4
            @Override // com.byazt.si.m
            public void n(int i2, String str2, Throwable th) {
            }

            @Override // com.byazt.si.m
            public void n(com.byazt.si.cy cyVar) {
                Bitmap bitmap = cyVar != null ? (Bitmap) cyVar.s() : null;
                if (bitmap != null) {
                    sz.qg(bitmap, (com.byazt.qyj.n<Bitmap>) nVar, i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(final Bitmap bitmap, final com.byazt.qyj.n<Bitmap> nVar, final int i) {
        if (bitmap.isRecycled()) {
            return;
        }
        qg(new Runnable() { // from class: com.byazt.tk.sz.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i2 = i;
                    if (i2 >= 160) {
                        bitmap.setDensity(i2);
                    }
                    nVar.n(bitmap);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        });
    }

    private static com.byazt.si.ur n(final String str, final String str2) {
        return new com.byazt.si.ur() { // from class: com.byazt.tk.sz.6
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
                return 524288;
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

    public static File n(Context context) {
        if (n == null) {
            try {
                File file = new File(w.qg(context, false, null), "tt_img_cac");
                file.mkdirs();
                n = file;
            } catch (Throwable th) {
                k.qg("LocalResCacheHelp", th.getMessage());
            }
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            rv.qg().post(runnable);
        }
    }

    public static void n(n nVar) {
        qg = nVar;
    }
}
