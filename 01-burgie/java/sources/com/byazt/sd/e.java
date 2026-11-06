package com.byazt.sd;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 105})
public class e {
    public static final HashSet<String> hn;
    public static final HashSet<String> hw;
    public static int pr = -1;

    static {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        hw = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        hn = hashSet2;
    }

    public static void pr(final Context context, final com.byazt.son.x xVar) {
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.sd.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.hw(context, xVar);
            }
        });
    }

    public static void hw(Context context, com.byazt.son.x xVar) {
        if (context != null && xVar != null && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (activity.isFinishing()) {
                try {
                    if (pr()) {
                        xVar.loadUrl("about:blank");
                    }
                    if (pr > 0) {
                        View rootView = xVar.getView().getRootView();
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
                } catch (Exception e) {
                }
            }
        }
    }

    private static boolean pr() {
        if (Build.VERSION.SDK_INT <= 17) {
            return com.byazt.wt.z.a() || hw.contains(Build.MODEL) || hn.contains(Build.MODEL);
        }
        return false;
    }

    public static void pr(final com.byazt.son.x xVar) {
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.sd.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.hn(xVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(com.byazt.son.x xVar) {
        if (xVar == null) {
            return;
        }
        xVar.setWebChromeClient(null);
        xVar.setWebViewClient(null);
        View view = xVar.getView();
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
        xVar.removeAllViews();
        try {
            xVar.destroy();
        } catch (Throwable th) {
        }
    }
}
