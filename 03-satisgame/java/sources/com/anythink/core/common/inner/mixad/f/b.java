package com.anythink.core.common.inner.mixad.f;

import android.view.MotionEvent;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static int a = 0;
    public static int b = 1;
    public static int c = 2;
    public static int d = 3;
    public static int e = 4;
    public static int f = 5;
    public static int g = 1;
    public static int h = 2;
    private static final String i = "b";
    private List<View> j;
    private View k;
    private View l;
    private View m;
    private float n;
    private float o;
    private float p;
    private float q;
    private int r;

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
        this.r = a;
    }

    public final void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.r = f;
            this.o = (int) motionEvent.getRawX();
            this.q = (int) motionEvent.getRawY();
            this.n = (int) motionEvent.getX();
            this.p = (int) motionEvent.getY();
            return;
        }
        if (action == 1 || action == 3) {
            try {
                float f2 = this.o;
                float f3 = this.q;
                if (a(f2, f3, this.k)) {
                    this.r = c;
                    return;
                }
                if (a(f2, f3, this.l)) {
                    this.r = d;
                    return;
                }
                if (a(f2, f3, this.m)) {
                    this.r = e;
                    return;
                }
                List<View> list = this.j;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    if (a(f2, f3, this.j.get(i2))) {
                        this.r = b;
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(float f2, float f3) {
        if (a(f2, f3, this.k)) {
            this.r = c;
            return;
        }
        if (a(f2, f3, this.l)) {
            this.r = d;
            return;
        }
        if (a(f2, f3, this.m)) {
            this.r = e;
            return;
        }
        List<View> list = this.j;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            if (a(f2, f3, this.j.get(i2))) {
                this.r = b;
                return;
            }
        }
    }

    public final int a() {
        return this.r;
    }

    private static boolean a(float f2, float f3, View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float f4 = iArr[0];
        float f5 = iArr[1];
        return f2 >= f4 && f2 <= ((float) view.getWidth()) + f4 && f3 >= f5 && f3 <= ((float) view.getHeight()) + f5;
    }

    public static class a {
        private List<View> a;
        private View b;
        private View c;
        private View d;

        public final a a(List<View> list) {
            this.a = list;
            return this;
        }

        public final a a(View view) {
            this.b = view;
            return this;
        }

        public final a b(View view) {
            this.c = view;
            return this;
        }

        public final a c(View view) {
            this.d = view;
            return this;
        }

        public final b a() {
            b bVar = new b((byte) 0);
            bVar.j = this.a;
            bVar.k = this.b;
            bVar.l = this.c;
            bVar.m = this.d;
            return bVar;
        }
    }
}
