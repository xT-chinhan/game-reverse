package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class az {
    private static final HashSet<String> ab;
    private static int ah;
    private static Handler c;
    private static int d;
    private static int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final boolean f1987ms;
    private static final HashSet<String> x;
    private static final boolean xr;

    static {
        f1987ms = com.bytedance.sdk.openadsdk.core.jw.w.ao();
        xr = ms();
        ah = -1;
        d = -1;
        ka = -1;
        c = null;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        ab = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        x = hashSet2;
    }

    public static void ms(final Context context, final com.bytedance.sdk.component.zb.ah ahVar) {
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.az.1
            @Override // java.lang.Runnable
            public void run() {
                az.xr(context, ahVar);
            }
        });
    }

    public static void xr(Context context, com.bytedance.sdk.component.zb.ah ahVar) {
        if (context == null || ahVar == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            try {
                ahVar.loadUrl(com.anythink.core.common.res.d.a);
                if (ka > 0) {
                    View rootView = ahVar.getView().getRootView();
                    if (rootView instanceof ViewGroup) {
                        View childAt = ((ViewGroup) rootView).getChildAt(0);
                        childAt.setDrawingCacheEnabled(true);
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                        childAt.setDrawingCacheEnabled(false);
                        ImageView imageView = new ImageView(activity);
                        imageView.setImageBitmap(bitmapCreateBitmap);
                        imageView.setVisibility(0);
                        ((ViewGroup) rootView).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static boolean ms() {
        return f1987ms;
    }

    public static void ms(final com.bytedance.sdk.component.zb.ah ahVar) {
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.az.2
            @Override // java.lang.Runnable
            public void run() {
                az.ah(ahVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(com.bytedance.sdk.component.zb.ah ahVar) {
        if (ahVar == null) {
            return;
        }
        ahVar.setWebChromeClient(null);
        ahVar.setWebViewClient(null);
        View view = ahVar.getView();
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
        ahVar.removeAllViews();
        try {
            ahVar.destroy();
        } catch (Throwable unused) {
        }
    }
}
