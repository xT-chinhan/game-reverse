package com.smartdigimkt.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.smartdigimkt.china.formatbusiness.ui.BubbleVibrationFallLayer;
import com.smartdigimkt.sdk.R;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {
    public static boolean a(BaseSdkSplashATView baseSdkSplashATView) {
        return baseSdkSplashATView != null && baseSdkSplashATView.isAttachedToWindow();
    }

    public static void b(BaseSdkSplashATView baseSdkSplashATView, Runnable runnable) {
        if (baseSdkSplashATView == null || runnable == null || baseSdkSplashATView.getTag(R.id.sdm_bubble_delay_runnable_tag) != runnable) {
            return;
        }
        baseSdkSplashATView.setTag(R.id.sdm_bubble_delay_runnable_tag, null);
    }

    public static boolean c(BaseSdkSplashATView baseSdkSplashATView) {
        return baseSdkSplashATView != null && baseSdkSplashATView.isAttachedToWindow() && baseSdkSplashATView.getWindowVisibility() == 0;
    }

    public static void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public static void b(BaseSdkSplashATView baseSdkSplashATView) {
        if (baseSdkSplashATView == null) {
            return;
        }
        try {
            Object tag = baseSdkSplashATView.getTag(R.id.sdm_bubble_vm_pending_runnables);
            if (tag instanceof Runnable[]) {
                for (Runnable runnable : (Runnable[]) tag) {
                    if (runnable != null) {
                        baseSdkSplashATView.removeCallbacks(runnable);
                    }
                }
            }
            baseSdkSplashATView.setTag(R.id.sdm_bubble_vm_pending_runnables, null);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static boolean a(BaseSdkSplashATView baseSdkSplashATView, long j) {
        return baseSdkSplashATView.isSplashSkipCountReadyForBubbleVibration() || (baseSdkSplashATView.isAttachedToWindow() && !c(baseSdkSplashATView)) || (j > 0 && SystemClock.elapsedRealtime() >= j);
    }

    public static Runnable a(BaseSdkSplashATView baseSdkSplashATView, com.smartdigimkt.a3.a aVar, p pVar) {
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.d dVar;
        if (baseSdkSplashATView == null || aVar == null || aVar.s == null) {
            return null;
        }
        String strA = com.smartdigimkt.z.c0.a(aVar);
        boolean z = !TextUtils.isEmpty(strA);
        if (!z && ((eVar = aVar.s) == null || (dVar = eVar.R1) == null || !com.smartdigimkt.b3.h.a(2, dVar) || !TextUtils.isEmpty(com.smartdigimkt.z.c0.a(aVar)))) {
            baseSdkSplashATView.setTag(R.id.sdm_bubble_delay_runnable_tag, null);
            return null;
        }
        l lVar = new l(baseSdkSplashATView, runnableArr, new long[]{-1}, aVar, pVar, z, strA);
        Runnable[] runnableArr = {lVar};
        baseSdkSplashATView.setTag(R.id.sdm_bubble_delay_runnable_tag, lVar);
        baseSdkSplashATView.postDelayed(runnableArr[0], 1000L);
        return runnableArr[0];
    }

    public static void a(Context context, BaseSdkSplashATView baseSdkSplashATView, int i, Runnable runnable, Runnable runnable2, int i2, Runnable runnable3) {
        Bitmap bitmap;
        if ((runnable3 != null && baseSdkSplashATView != null && baseSdkSplashATView.getTag(R.id.sdm_bubble_delay_runnable_tag) != runnable3) || context == null || baseSdkSplashATView == null) {
            return;
        }
        if (!a(baseSdkSplashATView)) {
            b(baseSdkSplashATView, runnable3);
            return;
        }
        int iA = com.smartdigimkt.r4.k.a(context, "myoffer_bubble_vibration_fallback_icon", "drawable");
        Bitmap bitmapDecodeResource = iA != 0 ? BitmapFactory.decodeResource(context.getResources(), iA) : null;
        if (bitmapDecodeResource == null || bitmapDecodeResource.isRecycled() || i <= 0 || (bitmapDecodeResource.getWidth() == i && bitmapDecodeResource.getHeight() == i)) {
            bitmap = bitmapDecodeResource;
        } else {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeResource, i, i, true);
            if (bitmapCreateScaledBitmap != bitmapDecodeResource && !bitmapDecodeResource.isRecycled()) {
                bitmapDecodeResource.recycle();
            }
            bitmap = bitmapCreateScaledBitmap;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            baseSdkSplashATView.post(new m(runnable3, baseSdkSplashATView, bitmap, runnable, runnable2, i2));
        } else {
            b(baseSdkSplashATView, runnable3);
        }
    }

    public static void a(BaseSdkSplashATView baseSdkSplashATView, Bitmap bitmap, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        if (baseSdkSplashATView == null) {
            a(bitmap);
            return;
        }
        if (!a(baseSdkSplashATView)) {
            a(bitmap);
            b(baseSdkSplashATView, runnable3);
            return;
        }
        for (int i = 0; i < baseSdkSplashATView.getChildCount(); i++) {
            if (baseSdkSplashATView.getChildAt(i) instanceof BubbleVibrationFallLayer) {
                a(bitmap);
                b(baseSdkSplashATView, runnable3);
                return;
            }
        }
        BubbleVibrationFallLayer bubbleVibrationFallLayer = new BubbleVibrationFallLayer(baseSdkSplashATView.getContext());
        bubbleVibrationFallLayer.setClickActions(runnable, runnable2);
        bubbleVibrationFallLayer.setSplashChromePassthroughHost(baseSdkSplashATView);
        baseSdkSplashATView.addView(bubbleVibrationFallLayer, new ViewGroup.LayoutParams(-1, -1));
        bubbleVibrationFallLayer.startWithBitmap(bitmap);
        View viewFindViewById = baseSdkSplashATView.findViewById(com.smartdigimkt.r4.k.a(baseSdkSplashATView.getContext(), "myoffer_feedback_ll_id", "id"));
        if (viewFindViewById != null) {
            baseSdkSplashATView.bringChildToFront(viewFindViewById);
        }
        View viewFindViewById2 = baseSdkSplashATView.findViewById(com.smartdigimkt.r4.k.a(baseSdkSplashATView.getContext(), "myoffer_splash_skip_area", "id"));
        if (viewFindViewById2 != null) {
            baseSdkSplashATView.bringChildToFront(viewFindViewById2);
        }
    }

    public static void a(Context context, BaseSdkSplashATView baseSdkSplashATView) {
        if (context == null || baseSdkSplashATView == null) {
            return;
        }
        try {
            Vibrator vibrator = (Vibrator) context.getApplicationContext().getSystemService("vibrator");
            if (vibrator != null && vibrator.hasVibrator()) {
                b(baseSdkSplashATView);
                a(vibrator);
                Runnable nVar = new n(vibrator);
                Runnable oVar = new o(vibrator);
                baseSdkSplashATView.postDelayed(nVar, 1300L);
                baseSdkSplashATView.postDelayed(oVar, 2600L);
                baseSdkSplashATView.setTag(R.id.sdm_bubble_vm_pending_runnables, new Runnable[]{nVar, oVar});
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void a(Vibrator vibrator) {
        if (vibrator == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(1000L, -1));
            } else {
                vibrator.vibrate(1000L);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            Vibrator vibrator = (Vibrator) context.getApplicationContext().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.cancel();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void a(BaseSdkSplashATView baseSdkSplashATView, Runnable runnable) {
        if (baseSdkSplashATView == null) {
            return;
        }
        b(baseSdkSplashATView);
        Runnable runnable2 = baseSdkSplashATView.getTag(R.id.sdm_bubble_delay_runnable_tag) instanceof Runnable ? (Runnable) baseSdkSplashATView.getTag(R.id.sdm_bubble_delay_runnable_tag) : null;
        if (runnable != null) {
            baseSdkSplashATView.removeCallbacks(runnable);
            if (runnable2 == runnable) {
                baseSdkSplashATView.setTag(R.id.sdm_bubble_delay_runnable_tag, null);
                return;
            }
            return;
        }
        if (runnable2 != null) {
            baseSdkSplashATView.removeCallbacks(runnable2);
            baseSdkSplashATView.setTag(R.id.sdm_bubble_delay_runnable_tag, null);
        }
    }
}
