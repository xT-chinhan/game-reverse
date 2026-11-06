package com.byazt.gn;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.byazt.nf.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 19})
public final class n {
    public static volatile double n = 50.0d;
    public static volatile double qg = 0.125d;
    public static final List<WeakReference<com.byazt.ih.s>> s = new ArrayList();
    public static final Handler q = new Handler(Looper.getMainLooper());
    public static final Map<com.byazt.ih.s, Boolean> l = new WeakHashMap();
    public static final Map<com.byazt.ih.s, Runnable> w = new WeakHashMap();

    private static int n(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    public static void n(com.byazt.ih.s sVar) {
        if (sVar == null) {
            return;
        }
        q(sVar);
        l(sVar);
    }

    public static void qg(com.byazt.ih.s sVar) {
        if (sVar == null) {
            return;
        }
        List<WeakReference<com.byazt.ih.s>> list = s;
        synchronized (list) {
            Iterator<WeakReference<com.byazt.ih.s>> it = list.iterator();
            while (it.hasNext()) {
                com.byazt.ih.s sVar2 = it.next().get();
                if (sVar2 == null || sVar2 == sVar) {
                    it.remove();
                }
            }
        }
        w(sVar);
    }

    public static void n() {
        try {
            List<WeakReference<com.byazt.ih.s>> list = s;
            synchronized (list) {
                Iterator<WeakReference<com.byazt.ih.s>> it = list.iterator();
                while (it.hasNext()) {
                    com.byazt.ih.s sVar = it.next().get();
                    if (sVar == null) {
                        it.remove();
                    } else {
                        l(sVar);
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static void q(com.byazt.ih.s sVar) {
        List<WeakReference<com.byazt.ih.s>> list = s;
        synchronized (list) {
            Iterator<WeakReference<com.byazt.ih.s>> it = list.iterator();
            while (it.hasNext()) {
                com.byazt.ih.s sVar2 = it.next().get();
                if (sVar2 == null) {
                    it.remove();
                } else if (sVar2 == sVar) {
                    return;
                }
            }
            s.add(new WeakReference<>(sVar));
        }
    }

    private static void l(final com.byazt.ih.s sVar) {
        Map<com.byazt.ih.s, Runnable> map = w;
        synchronized (map) {
            Runnable runnable = map.get(sVar);
            if (runnable != null) {
                q.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.byazt.gn.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.qg(sVar, this);
                    n.s(sVar);
                }
            };
            map.put(sVar, runnable2);
            q.postDelayed(runnable2, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(com.byazt.ih.s sVar, Runnable runnable) {
        Map<com.byazt.ih.s, Runnable> map = w;
        synchronized (map) {
            if (map.get(sVar) == runnable) {
                map.remove(sVar);
            }
        }
    }

    private static void w(com.byazt.ih.s sVar) {
        Map<com.byazt.ih.s, Runnable> map = w;
        synchronized (map) {
            Runnable runnableRemove = map.remove(sVar);
            if (runnableRemove != null) {
                q.removeCallbacks(runnableRemove);
            }
        }
    }

    public static void s(com.byazt.ih.s sVar) {
        if (sVar == null) {
            return;
        }
        try {
            qg();
            ArrayList arrayList = new ArrayList();
            n(sVar, arrayList);
            arrayList.size();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                fs((com.byazt.ih.s) it.next());
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static void qg() {
        try {
            com.byazt.ivn.w wVarQg = rv.qg();
            if (wVarQg == null) {
                return;
            }
            int iKk = wVarQg.kk();
            if (iKk > 0) {
                n = iKk;
            }
            int iBr = wVarQg.br();
            if (iBr > 0) {
                qg = 1.0d / ((double) iBr);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static void n(com.byazt.ih.s sVar, List<com.byazt.ih.s> list) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        if (x(sVar)) {
            list.add(sVar);
        }
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            n(it.next(), list);
        }
    }

    private static boolean x(com.byazt.ih.s sVar) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        if (sVar == null) {
            return false;
        }
        try {
            JSONObject jSONObjectM = sVar.m();
            if (jSONObjectM != null && (jSONArrayOptJSONArray = jSONObjectM.optJSONArray("events")) != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("handlers")) != null) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            Object objOpt = jSONArrayOptJSONArray2.opt(i2);
                            if (objOpt instanceof String) {
                                if ("global://close".equals(objOpt) || "global://skip".equals(objOpt)) {
                                    return true;
                                }
                            } else if (objOpt instanceof JSONObject) {
                                JSONObject jSONObject = (JSONObject) objOpt;
                                String strOptString = jSONObject.optString(TapEventParamConstants.PARAM_NAME, null);
                                String strOptString2 = jSONObject.optString("scheme", "global");
                                if ((ILivePush.ClickType.CLOSE.equals(strOptString) || "skip".equals(strOptString)) && "global".equals(strOptString2)) {
                                    return true;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static void fs(com.byazt.ih.s sVar) {
        if (sVar == null || sVar.rv() == null || cp(sVar)) {
            return;
        }
        try {
            int iDf = sVar.df();
            if (Color.alpha(iDf) < 16) {
                Integer.toHexString(iDf);
                return;
            }
            C0182n c0182nN = n(sVar, iDf);
            if (c0182nN == null) {
                return;
            }
            Integer.toHexString(iDf);
            if (c0182nN.n() >= qg) {
                tj(sVar);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static C0182n n(com.byazt.ih.s sVar, int i) {
        C0182n c0182nN;
        com.byazt.ih.s sVar2 = sVar;
        for (com.byazt.ih.n nVarLh = sVar.lh(); nVarLh != null; nVarLh = nVarLh.lh()) {
            List<com.byazt.ih.s<View>> listX = nVarLh.x();
            if (listX != null) {
                int iIndexOf = listX.indexOf(sVar2);
                if (iIndexOf < 0) {
                    iIndexOf = listX.size();
                }
                for (int i2 = iIndexOf - 1; i2 >= 0; i2--) {
                    com.byazt.ih.s<View> sVar3 = listX.get(i2);
                    if (sVar3 != null && sVar3 != sVar2 && rv(sVar3) && n(sVar.rv(), sVar3.rv()) && (c0182nN = n(sVar3, sVar.rv(), i)) != null && c0182nN.n > 0) {
                        return c0182nN;
                    }
                }
            }
            C0182n c0182nN2 = n(nVarLh, sVar.rv(), i);
            if (c0182nN2 != null && c0182nN2.n > 0) {
                return c0182nN2;
            }
            sVar2 = nVarLh;
        }
        return null;
    }

    private static boolean rv(com.byazt.ih.s sVar) {
        try {
            JSONObject jSONObjectM = sVar.m();
            if (jSONObjectM == null) {
                return false;
            }
            return "absolute".equalsIgnoreCase(jSONObjectM.optString("position", null));
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean n(View view, View view2) {
        if (view == null || view2 == null) {
            return false;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        view2.getLocationOnScreen(iArr2);
        int i = iArr[0];
        Rect rect = new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight());
        int i2 = iArr2[0];
        return Rect.intersects(rect, new Rect(i2, iArr2[1], view2.getWidth() + i2, iArr2[1] + view2.getHeight()));
    }

    private static C0182n n(com.byazt.ih.s sVar, View view, int i) {
        Bitmap bitmapN;
        C0182n c0182nN;
        C0182n c0182nN2;
        if (sVar != null && sVar.rv() != null) {
            View viewRv = sVar.rv();
            Bitmap bitmapN2 = n(viewRv.getBackground(), viewRv.getWidth(), viewRv.getHeight());
            if (bitmapN2 != null && view != null && (c0182nN2 = n(viewRv, bitmapN2, view, i)) != null && c0182nN2.n > 0) {
                return c0182nN2;
            }
            ImageView imageViewQg = qg(viewRv, view);
            if (imageViewQg != null && view != null && (bitmapN = n(imageViewQg)) != null && (c0182nN = n(imageViewQg, bitmapN, view, i)) != null && c0182nN.n > 0) {
                return c0182nN;
            }
            int iDf = sVar.df();
            if (Color.alpha(iDf) >= 16) {
                C0182n c0182n = new C0182n();
                c0182n.n = 1;
                c0182n.qg = n(iDf, i, n) ? 1 : 0;
                return c0182n;
            }
        }
        return null;
    }

    private static ImageView qg(View view, View view2) {
        Rect rect = null;
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view2 != null) {
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i = iArr[0];
            rect = new Rect(i, iArr[1], view2.getWidth() + i, iArr[1] + view2.getHeight());
        }
        ImageView[] imageViewArr = new ImageView[1];
        n((ViewGroup) view, view2, rect, imageViewArr, new long[1]);
        return imageViewArr[0];
    }

    private static void n(ViewGroup viewGroup, View view, Rect rect, ImageView[] imageViewArr, long[] jArr) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != view) {
                if (childAt instanceof ImageView) {
                    ImageView imageView = (ImageView) childAt;
                    if ((view == null || s(imageView, view)) && imageView.getDrawable() != null && imageView.getWidth() > 0 && imageView.getHeight() > 0 && n(imageView, rect)) {
                        long width = ((long) imageView.getWidth()) * ((long) imageView.getHeight());
                        if (width > jArr[0]) {
                            jArr[0] = width;
                            imageViewArr[0] = imageView;
                        }
                    }
                }
                if (childAt instanceof ViewGroup) {
                    n((ViewGroup) childAt, view, rect, imageViewArr, jArr);
                }
            }
        }
    }

    private static boolean s(View view, View view2) {
        if (view != null && view2 != null && view != view2) {
            try {
                List<View> listN = n(view);
                List<View> listN2 = n(view2);
                int size = listN.size() - 1;
                int size2 = listN2.size() - 1;
                if (listN.get(size) != listN2.get(size2)) {
                    return false;
                }
                View view3 = null;
                while (size >= 0 && size2 >= 0 && listN.get(size) == listN2.get(size2)) {
                    view3 = listN.get(size);
                    size--;
                    size2--;
                }
                if (size < 0) {
                    return true;
                }
                if (size2 >= 0 && (view3 instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    int iN = n(viewGroup, listN.get(size));
                    int iN2 = n(viewGroup, listN2.get(size2));
                    return iN >= 0 && iN2 >= 0 && iN < iN2;
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return false;
    }

    private static List<View> n(View view) {
        ArrayList arrayList = new ArrayList();
        while (view != null) {
            arrayList.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return arrayList;
    }

    private static int n(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }

    private static boolean n(View view, Rect rect) {
        if (rect == null) {
            return true;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return Rect.intersects(new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight()), rect);
    }

    private static Bitmap n(ImageView imageView) {
        if (imageView != null && imageView.getWidth() > 0 && imageView.getHeight() > 0) {
            float width = imageView.getWidth();
            float height = imageView.getHeight();
            float fMin = Math.min(1.0f, Math.min(64.0f / width, 64.0f / height));
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(1, (int) (width * fMin)), Math.max(1, (int) (height * fMin)), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.scale(fMin, fMin);
                imageView.draw(canvas);
                return bitmapCreateBitmap;
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return null;
    }

    private static Bitmap n(Drawable drawable, int i, int i2) {
        Bitmap bitmapN;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            try {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && (bitmapN = n(bitmap)) != null) {
                    return bitmapN;
                }
            } catch (Throwable unused) {
            }
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            i = intrinsicWidth;
            i2 = intrinsicHeight;
        }
        if (i > 0 && i2 > 0) {
            if (i > 64 || i2 > 64) {
                float f = i;
                float f2 = i2;
                float fMin = Math.min(64.0f / f, 64.0f / f2);
                i = Math.max(1, (int) (f * fMin));
                i2 = Math.max(1, (int) (f2 * fMin));
            }
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Rect rect = new Rect(drawable.getBounds());
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                drawable.setBounds(rect);
                return bitmapCreateBitmap;
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return null;
    }

    private static Bitmap n(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            return (Build.VERSION.SDK_INT < 26 || bitmap.getConfig() != Bitmap.Config.HARDWARE) ? bitmap : bitmap.copy(Bitmap.Config.ARGB_8888, false);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    private static C0182n n(View view, Bitmap bitmap, View view2, int i) {
        try {
            double d = n;
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr);
            view2.getLocationOnScreen(iArr2);
            int width = view.getWidth();
            int height = view.getHeight();
            if (width > 0 && height > 0) {
                float width2 = bitmap.getWidth() / width;
                float height2 = bitmap.getHeight() / height;
                int i2 = 0;
                int i3 = iArr2[0] - iArr[0];
                int i4 = iArr2[1] - iArr[1];
                int width3 = view2.getWidth() + i3;
                int height3 = view2.getHeight() + i4;
                int i5 = width - 1;
                int iN = n(i3, 0, i5);
                int i6 = height - 1;
                int iN2 = n(i4, 0, i6);
                int iN3 = n(width3, 0, i5);
                int iN4 = n(height3, 0, i6);
                C0182n c0182n = new C0182n();
                if (iN3 > iN && iN4 > iN2) {
                    int i7 = 0;
                    while (true) {
                        if (i7 > 7) {
                            return c0182n;
                        }
                        int i8 = i2;
                        for (int i9 = 7; i8 <= i9; i9 = 7) {
                            int i10 = iN3;
                            int pixel = bitmap.getPixel(n((int) ((iN + (((iN3 - iN) * i7) / 7)) * width2), 0, bitmap.getWidth() - 1), n((int) ((iN2 + (((iN4 - iN2) * i8) / 7)) * height2), 0, bitmap.getHeight() - 1));
                            if (Color.alpha(pixel) >= 16) {
                                c0182n.n++;
                                if (n(pixel, i, d)) {
                                    c0182n.qg++;
                                }
                            }
                            i8++;
                            iN3 = i10;
                        }
                        i7++;
                        i2 = 0;
                    }
                }
                int pixel2 = bitmap.getPixel(n(bitmap.getWidth() / 2, 0, bitmap.getWidth() - 1), n(bitmap.getHeight() / 2, 0, bitmap.getHeight() - 1));
                if (Color.alpha(pixel2) >= 16) {
                    c0182n.n = 1;
                    c0182n.qg = n(pixel2, i, d) ? 1 : 0;
                }
                return c0182n;
            }
            return null;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    private static boolean n(int i, int i2, double d) {
        double dRed = Color.red(i) - Color.red(i2);
        double dGreen = Color.green(i) - Color.green(i2);
        double dBlue = Color.blue(i) - Color.blue(i2);
        return ((dRed * dRed) + (dGreen * dGreen)) + (dBlue * dBlue) <= d * d;
    }

    private static void tj(com.byazt.ih.s sVar) {
        if (sVar == null || sVar.rv() == null) {
            return;
        }
        oa(sVar);
        n(sVar, -1, true);
        d(sVar);
    }

    private static boolean cp(com.byazt.ih.s sVar) {
        boolean zEquals;
        Map<com.byazt.ih.s, Boolean> map = l;
        synchronized (map) {
            zEquals = Boolean.TRUE.equals(map.get(sVar));
        }
        return zEquals;
    }

    private static void d(com.byazt.ih.s sVar) {
        Map<com.byazt.ih.s, Boolean> map = l;
        synchronized (map) {
            map.put(sVar, Boolean.TRUE);
        }
    }

    private static void oa(com.byazt.ih.s sVar) {
        View viewRv = sVar.rv();
        if (viewRv == null) {
            return;
        }
        try {
            viewRv.setAlpha(1.0f);
        } catch (Throwable th) {
            th.getMessage();
        }
        Drawable background = viewRv.getBackground();
        if (!(background instanceof GradientDrawable)) {
            if (background != null) {
                background.getClass().getSimpleName();
                return;
            }
            return;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        try {
            gradientDrawable.setColor((sVar.df() & ViewCompat.MEASURED_SIZE_MASK) | ViewCompat.MEASURED_STATE_MASK);
        } catch (Throwable th2) {
            th2.getMessage();
        }
        try {
            gradientDrawable.setStroke(Math.max(1, (int) com.byazt.hb.fs.n(viewRv.getContext(), 1.0f)), -1);
        } catch (Throwable th3) {
            th3.getMessage();
        }
    }

    private static void n(com.byazt.ih.s sVar, int i, boolean z) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        if (!z) {
            qg(sVar, i);
        }
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            n((com.byazt.ih.s) it.next(), i, false);
        }
    }

    private static void qg(com.byazt.ih.s sVar, int i) {
        if (sVar instanceof com.byazt.ud.qg) {
            try {
                ((com.byazt.ud.qg) sVar).w(i);
                return;
            } catch (Throwable th) {
                th.getMessage();
            }
        } else if (sVar instanceof com.byazt.ud.n) {
            try {
                ((com.byazt.ud.n) sVar).w(i);
                return;
            } catch (Throwable th2) {
                th2.getMessage();
            }
        } else if (sVar instanceof com.byazt.zy.n) {
            try {
                ((com.byazt.zy.n) sVar).w(i);
                return;
            } catch (Throwable th3) {
                th3.getMessage();
            }
        }
        View viewRv = sVar.rv();
        if (viewRv instanceof TextView) {
            try {
                ((TextView) viewRv).setTextColor(i);
                return;
            } catch (Throwable th4) {
                th4.getMessage();
            }
        }
        if (viewRv instanceof ImageView) {
            try {
                ((ImageView) viewRv).setColorFilter(i);
                viewRv.setAlpha(1.0f);
            } catch (Throwable th5) {
                th5.getMessage();
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.gn.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0182n {
        public int n;
        public int qg;

        private C0182n() {
        }

        public double n() {
            int i = this.n;
            if (i > 0) {
                return ((double) this.qg) / ((double) i);
            }
            return 0.0d;
        }
    }
}
