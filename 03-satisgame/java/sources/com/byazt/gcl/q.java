package com.byazt.gcl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.anythink.core.common.res.d;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 61, 5})
public class q {
    public static int n = -1;
    public static final HashSet<String> qg;
    public static final HashSet<String> s;

    private static boolean n() {
        return false;
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        qg = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        s = hashSet2;
    }

    public static void n(final Context context, final com.byazt.uad.q qVar) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.gcl.q.1
            @Override // java.lang.Runnable
            public void run() {
                q.qg(context, qVar);
            }
        });
    }

    public static void qg(Context context, com.byazt.uad.q qVar) {
        if (context == null || qVar == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            try {
                if (n()) {
                    qVar.loadUrl(d.a);
                }
                if (n > 0) {
                    View rootView = qVar.getView().getRootView();
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

    public static void n(final com.byazt.uad.q qVar) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.gcl.q.2
            @Override // java.lang.Runnable
            public void run() {
                q.s(qVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(com.byazt.uad.q qVar) {
        if (qVar == null) {
            return;
        }
        qVar.setWebChromeClient(null);
        qVar.setWebViewClient(null);
        View view = qVar.getView();
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
        qVar.removeAllViews();
        try {
            qVar.destroy();
        } catch (Throwable unused) {
        }
    }
}
