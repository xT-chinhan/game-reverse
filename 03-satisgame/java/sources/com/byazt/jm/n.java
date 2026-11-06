package com.byazt.jm;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.byazt.hb.fs;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 918, 19})
public final class n {
    public static volatile Handler n;

    interface qg {
        void n(Bitmap bitmap);
    }

    private static float n(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private n() {
    }

    /* JADX INFO: renamed from: com.byazt.jm.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 918, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    static final class C0224n {
        public final float n;
        public final float q;
        public final float qg;
        public final float s;

        public C0224n(float f, float f2, float f3, float f4) {
            this.n = f;
            this.qg = f2;
            this.s = f3;
            this.q = f4;
        }
    }

    public static C0224n n(String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length != 4) {
            return null;
        }
        try {
            float f = Float.parseFloat(strArrSplit[0].trim());
            float f2 = Float.parseFloat(strArrSplit[1].trim());
            float f3 = Float.parseFloat(strArrSplit[2].trim());
            float f4 = Float.parseFloat(strArrSplit[3].trim());
            if (Float.isNaN(f) || Float.isNaN(f2) || Float.isNaN(f3) || Float.isNaN(f4)) {
                return null;
            }
            float fN = n(f);
            float fN2 = n(f2);
            if (f3 <= 0.0f || f4 <= 0.0f) {
                return null;
            }
            if (fN + f3 > 1.0f) {
                f3 = 1.0f - fN;
            }
            if (fN2 + f4 > 1.0f) {
                f4 = 1.0f - fN2;
            }
            if (f3 <= 0.0f || f4 <= 0.0f) {
                return null;
            }
            return new C0224n(fN, fN2, f3, f4);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Bitmap n(Bitmap bitmap, C0224n c0224n) {
        if (bitmap != null && !bitmap.isRecycled() && c0224n != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                float f = width;
                int iRound = Math.round(c0224n.n * f);
                float f2 = height;
                int iRound2 = Math.round(c0224n.qg * f2);
                int iRound3 = Math.round(c0224n.s * f);
                int iRound4 = Math.round(c0224n.q * f2);
                if (iRound < 0) {
                    iRound = 0;
                }
                if (iRound2 < 0) {
                    iRound2 = 0;
                }
                if (iRound + iRound3 > width) {
                    iRound3 = width - iRound;
                }
                if (iRound2 + iRound4 > height) {
                    iRound4 = height - iRound2;
                }
                if (iRound3 > 0 && iRound4 > 0) {
                    try {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, iRound, iRound2, iRound3, iRound4);
                        return bitmapCreateBitmap == bitmap ? bitmap.copy(Bitmap.Config.ARGB_8888, false) : bitmapCreateBitmap;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return null;
    }

    public static Bitmap n(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap bitmapCreateBitmap;
        if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint(1);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                canvas.drawBitmap(bitmap2, (Rect) null, new Rect(0, 0, width, height), paint);
                paint.setXfermode(null);
                return bitmapCreateBitmap;
            } catch (Throwable unused) {
                if (bitmapCreateBitmap == null) {
                    return null;
                }
                bitmapCreateBitmap.recycle();
                return null;
            }
        } catch (Throwable unused2) {
            bitmapCreateBitmap = null;
        }
    }

    private static void n(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public static Handler n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    HandlerThread handlerThread = new HandlerThread("ugen-image-mask", 10);
                    handlerThread.start();
                    n = new Handler(handlerThread.getLooper());
                }
            }
        }
        return n;
    }

    public static void n(final Bitmap bitmap, final Bitmap bitmap2, final C0224n c0224n, final qg qgVar) {
        if (qgVar == null) {
            return;
        }
        n().post(new Runnable() { // from class: com.byazt.jm.n.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                final Bitmap bitmapQg = n.qg(bitmap, bitmap2, c0224n);
                fs.n(new Runnable() { // from class: com.byazt.jm.n.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        qgVar.n(bitmapQg);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x005e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0063  */
    public static Bitmap qg(Bitmap bitmap, Bitmap bitmap2, C0224n c0224n) throws Throwable {
        Bitmap bitmapN;
        Bitmap bitmap3;
        Bitmap bitmapQg = qg(bitmap);
        Bitmap bitmapQg2 = qg(bitmap2);
        Bitmap bitmap4 = null;
        if (c0224n != null) {
            try {
                bitmapN = n(bitmapQg, c0224n);
                bitmap3 = bitmapN;
            } catch (Throwable th) {
                th = th;
                n(bitmap4);
                if (bitmapQg != bitmap) {
                    n(bitmapQg);
                }
                if (bitmapQg2 != bitmap2) {
                    n(bitmapQg2);
                }
                throw th;
            }
        } else {
            bitmapN = bitmapQg;
            bitmap3 = null;
        }
        if (bitmapN == null) {
            n(bitmap3);
            if (bitmapQg != bitmap) {
                n(bitmapQg);
            }
            if (bitmapQg2 != bitmap2) {
                n(bitmapQg2);
            }
            return null;
        }
        if (bitmapQg2 == null) {
            if (bitmap3 != null) {
                n((Bitmap) null);
                if (bitmapQg != bitmap) {
                    n(bitmapQg);
                }
                if (bitmapQg2 != bitmap2) {
                    n(bitmapQg2);
                }
                return bitmap3;
            }
            n(bitmap3);
            if (bitmapQg != bitmap) {
                n(bitmapQg);
            }
            if (bitmapQg2 != bitmap2) {
                n(bitmapQg2);
            }
            return null;
        }
        try {
            Bitmap bitmapN2 = n(bitmapN, bitmapQg2);
            n(bitmap3);
            if (bitmapQg != bitmap) {
                n(bitmapQg);
            }
            if (bitmapQg2 != bitmap2) {
                n(bitmapQg2);
            }
            return bitmapN2;
        } catch (Throwable th2) {
            th = th2;
            bitmap4 = bitmap3;
            n(bitmap4);
            if (bitmapQg != bitmap) {
                n(bitmapQg);
            }
            if (bitmapQg2 != bitmap2) {
                n(bitmapQg2);
            }
            throw th;
        }
    }

    private static Bitmap qg(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || Build.VERSION.SDK_INT < 26 || bitmap.getConfig() != Bitmap.Config.HARDWARE) {
            return bitmap;
        }
        try {
            return bitmap.copy(Bitmap.Config.ARGB_8888, false);
        } catch (Throwable unused) {
            return bitmap;
        }
    }
}
