package com.onevcat.uniwebview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class X extends FrameLayout {
    public final Y a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(Context context, Y inspector) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inspector, "inspector");
        this.a = inspector;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (((N) this.a).l) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        N n = (N) this.a;
        if (n.l && motionEvent != null && n.e.getHeight() > 0 && n.e.getWidth() > 0) {
            Bitmap bitmapA = n.a((Rect) null);
            if (motionEvent.getY() > 0.0f && motionEvent.getY() < bitmapA.getHeight() && motionEvent.getX() > 0.0f && motionEvent.getX() < bitmapA.getWidth()) {
                int pixel = bitmapA.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                int iRed = Color.red(pixel);
                int iGreen = Color.green(pixel);
                int iBlue = Color.blue(pixel);
                int iAlpha = Color.alpha(pixel);
                C0731l c0731l = C0731l.b;
                String message = "Clicking on color: (" + iRed + ", " + iGreen + ", " + iBlue + ") @ " + iAlpha;
                c0731l.getClass();
                Intrinsics.checkNotNullParameter(message, "message");
                c0731l.a(EnumC0728k.VERBOSE, message);
                if (iAlpha == 0) {
                    return super.onTouchEvent(motionEvent);
                }
            }
        }
        return ((N) this.a).p.onTouchEvent(motionEvent);
    }
}
