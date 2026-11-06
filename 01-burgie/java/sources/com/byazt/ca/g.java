package com.byazt.ca;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public static pr hw;
    public static volatile File pr;

    public interface pr {
        String hw();

        String pr();
    }

    public static void pr(final Context context, final String str, final View view, int i) {
        pr(context, str, new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.ca.g.1
            @Override // com.byazt.ezf.pr
            public void pr(final Bitmap bitmap) {
                g.hw(new Runnable() { // from class: com.byazt.ca.g.1.1
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

    public static void pr(final Context context, final String str, final ImageView imageView, int i) {
        pr(context, str, new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.ca.g.2
            @Override // com.byazt.ezf.pr
            public void pr(final Bitmap bitmap) {
                g.hw(new Runnable() { // from class: com.byazt.ca.g.2.1
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

    public static void pr(Context context, final String str, final com.byazt.ezf.pr<Bitmap> prVar, final int i) {
        File file;
        com.byazt.ld.b bVar = (com.byazt.ld.b) com.byazt.zs.uc.pr("local_img_loader");
        File filePr = pr(context);
        if (TextUtils.isEmpty(hw.hw())) {
            file = null;
        } else {
            file = new File(filePr, hw.hw());
        }
        String absolutePath = file != null ? file.getAbsolutePath() : null;
        bVar.pr(pr(absolutePath, com.byazt.cb.hn.pr(str))).hn(absolutePath).x(true).hn(true).pr(Bitmap.Config.ARGB_8888).hn(2).pr(new com.byazt.ld.rc() { // from class: com.byazt.ca.g.3
            @Override // com.byazt.ld.rc
            public void pr(com.byazt.ld.nt ntVar) {
                Bitmap bitmap = ntVar != null ? (Bitmap) ntVar.hn() : null;
                if (bitmap != null) {
                    g.hw(bitmap, (com.byazt.ezf.pr<Bitmap>) prVar, i);
                } else {
                    g.hw(str, (com.byazt.ezf.pr<Bitmap>) prVar, i);
                }
            }

            @Override // com.byazt.ld.rc
            public void pr(int i2, String str2, Throwable th) {
                g.hw(str, (com.byazt.ezf.pr<Bitmap>) prVar, i);
            }
        }, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(String str, final com.byazt.ezf.pr<Bitmap> prVar, final int i) {
        pr prVar2 = hw;
        ((com.byazt.ld.ny) com.byazt.zs.uc.pr("img_service")).pr(((prVar2 == null || TextUtils.isEmpty(prVar2.pr())) ? null : hw.pr()) + str).pr(Bitmap.Config.ARGB_8888).hn(2).pr(new com.byazt.ld.rc() { // from class: com.byazt.ca.g.4
            @Override // com.byazt.ld.rc
            public void pr(com.byazt.ld.nt ntVar) {
                Bitmap bitmap = ntVar != null ? (Bitmap) ntVar.hn() : null;
                if (bitmap != null) {
                    g.hw(bitmap, (com.byazt.ezf.pr<Bitmap>) prVar, i);
                }
            }

            @Override // com.byazt.ld.rc
            public void pr(int i2, String str2, Throwable th) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(final Bitmap bitmap, final com.byazt.ezf.pr<Bitmap> prVar, final int i) {
        if (!bitmap.isRecycled()) {
            hw(new Runnable() { // from class: com.byazt.ca.g.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int i2 = i;
                        if (i2 >= 160) {
                            bitmap.setDensity(i2);
                        }
                        prVar.pr(bitmap);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
            });
        }
    }

    private static com.byazt.ld.ve pr(final String str, final String str2) {
        return new com.byazt.ld.ve() { // from class: com.byazt.ca.g.6
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
                return 524288;
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

    public static File pr(Context context) {
        if (pr == null) {
            try {
                File file = new File(uc.hw(context, false, null), "tt_img_cac");
                file.mkdirs();
                pr = file;
            } catch (Throwable th) {
                ho.hw("LocalResCacheHelp", th.getMessage());
            }
        }
        return pr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            aj.hw().post(runnable);
        }
    }

    public static void pr(pr prVar) {
        hw = prVar;
    }
}
