package com.anythink.core.common.u;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public final class al {
    private static boolean a = false;
    private static final Object b = new Object();
    private static TypedValue c;

    private static void a(final View view, final int i) {
        final View view2 = (View) view.getParent();
        if (view2 != null) {
            view2.post(new Runnable() { // from class: com.anythink.core.common.u.al.1
                @Override // java.lang.Runnable
                public final void run() {
                    Rect rect = new Rect();
                    view.getHitRect(rect);
                    rect.top -= i;
                    rect.bottom += i;
                    rect.left -= i;
                    rect.right += i;
                    view2.setTouchDelegate(new TouchDelegate(rect, view));
                }
            });
        }
    }

    public static void a(final View view, final float f) {
        final View view2 = (View) view.getParent();
        if (view2 != null) {
            view2.post(new Runnable() { // from class: com.anythink.core.common.u.al.2
                @Override // java.lang.Runnable
                public final void run() {
                    Rect rect = new Rect();
                    view.getHitRect(rect);
                    int iWidth = ((int) (rect.width() * (f - 1.0f))) / 2;
                    int iHeight = ((int) (rect.height() * (f - 1.0f))) / 2;
                    if (rect.top - iHeight < 0) {
                        rect.top = 0;
                    } else {
                        rect.top -= iHeight;
                    }
                    if (rect.bottom + iHeight > view2.getHeight()) {
                        rect.bottom = view2.getHeight();
                    } else {
                        rect.bottom += iHeight;
                    }
                    if (rect.left - iWidth < 0) {
                        rect.left = 0;
                    } else {
                        rect.left -= iWidth;
                    }
                    if (rect.right + iWidth > view2.getWidth()) {
                        rect.right = view2.getWidth();
                    } else {
                        rect.right += iWidth;
                    }
                    view2.setTouchDelegate(new TouchDelegate(rect, view));
                }
            });
        }
    }

    private static Path a(int i, int i2, int i3) {
        Path path = new Path();
        float f = i;
        path.moveTo(f, 0.0f);
        float f2 = i2 - i;
        path.lineTo(f2, 0.0f);
        float f3 = i2;
        path.quadTo(f3, 0.0f, f3, f);
        float f4 = i3 - i;
        path.lineTo(f3, f4);
        float f5 = i3;
        path.quadTo(f3, f5, f2, f5);
        path.lineTo(f, f5);
        path.quadTo(0.0f, f5, 0.0f, f4);
        path.lineTo(0.0f, f);
        path.quadTo(0.0f, 0.0f, f, 0.0f);
        path.close();
        return path;
    }

    public static void a(Canvas canvas, int i, int i2, int i3) {
        try {
            Paint paint = new Paint(1);
            paint.setColor(-1);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            Path path = new Path();
            float f = i3;
            path.moveTo(f, 0.0f);
            float f2 = i - i3;
            path.lineTo(f2, 0.0f);
            float f3 = i;
            path.quadTo(f3, 0.0f, f3, f);
            float f4 = i2 - i3;
            path.lineTo(f3, f4);
            float f5 = i2;
            path.quadTo(f3, f5, f2, f5);
            path.lineTo(f, f5);
            path.quadTo(0.0f, f5, 0.0f, f4);
            path.lineTo(0.0f, f);
            path.quadTo(0.0f, 0.0f, f, 0.0f);
            path.close();
            canvas2.drawPath(path, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Canvas canvas, int i, int i2, RectF rectF) {
        try {
            Paint paint = new Paint(1);
            paint.setColor(-1);
            paint.setStyle(Paint.Style.FILL);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawArc(rectF, 0.0f, 180.0f, true, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int[] a(int i, int i2, float f) {
        float f2 = i;
        float f3 = i2;
        if (f > f2 / f3) {
            i2 = (int) Math.ceil(f2 / f);
        } else {
            i = (int) Math.ceil(f3 * f);
        }
        return new int[]{i, i2};
    }

    public static void a(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static boolean b(View view, float f) {
        if (view != null) {
            Rect rect = new Rect();
            if (view.getLocalVisibleRect(rect) && rect.top >= 0 && rect.bottom <= view.getHeight() && rect.height() > view.getHeight() * f) {
                return true;
            }
        }
        return false;
    }

    private static void a(boolean z) {
        a = z;
    }

    private static boolean b(View view, com.anythink.core.common.u.a.f.b bVar) {
        if (view != null && view.getParent() != null && bVar != null) {
            Object parent = view.getParent();
            if ((parent instanceof View) && bVar.a((View) parent, view, 80, 0) && !a) {
                return true;
            }
        }
        return false;
    }

    private static Drawable a(Context context, int i) {
        if (context == null) {
            return null;
        }
        return context.getDrawable(i);
    }

    private static void a(View view, int i, int i2) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    public static void a(final ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        try {
            viewGroup.postDelayed(new Runnable() { // from class: com.anythink.core.common.u.al.3
                @Override // java.lang.Runnable
                public final void run() {
                    Rect rect = new Rect();
                    viewGroup.getGlobalVisibleRect(rect);
                    int iWidth = rect.width() * rect.height();
                    DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
                    if (((float) iWidth) / ((float) (displayMetrics.widthPixels * displayMetrics.heightPixels)) >= 0.8f) {
                        return;
                    }
                    Context contextG = com.anythink.core.common.d.s.b().g();
                    try {
                        String string = contextG.getString(p.a(contextG, "splash_ad_container_error", "string"));
                        if (TextUtils.isEmpty(string)) {
                            return;
                        }
                        Toast.makeText(contextG, string, 1).show();
                    } catch (Throwable unused) {
                    }
                }
            }, 500L);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(View view, com.anythink.core.common.u.a.f.b bVar) {
        if (view != null && view.getParent() != null && bVar != null) {
            Object parent = view.getParent();
            if ((parent instanceof View) && bVar.a((View) parent, view, 80, 0) && !a) {
                return true;
            }
        }
        return false;
    }
}
