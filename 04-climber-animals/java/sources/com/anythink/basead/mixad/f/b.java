package com.anythink.basead.mixad.f;

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
    private static final String g = "b";
    private List<View> h;
    private View i;
    private View j;
    private View k;
    private float l;
    private float m;
    private float n;
    private float o;
    private int p;

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
        this.p = a;
    }

    public final void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.p = f;
            this.m = (int) motionEvent.getRawX();
            this.o = (int) motionEvent.getRawY();
            this.l = (int) motionEvent.getX();
            this.n = (int) motionEvent.getY();
            return;
        }
        if (action == 1 || action == 3) {
            Object[] objArr = new Object[4];
            Float.valueOf(this.m);
            Float.valueOf(this.o);
            Float.valueOf(this.l);
            Float.valueOf(this.n);
            try {
                float f2 = this.m;
                float f3 = this.o;
                if (a(f2, f3, this.i)) {
                    this.p = c;
                    return;
                }
                if (a(f2, f3, this.j)) {
                    this.p = d;
                    return;
                }
                if (a(f2, f3, this.k)) {
                    this.p = e;
                    return;
                }
                List<View> list = this.h;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (int i = 0; i < this.h.size(); i++) {
                    if (a(f2, f3, this.h.get(i))) {
                        this.p = b;
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(float f2, float f3) {
        if (a(f2, f3, this.i)) {
            this.p = c;
            return;
        }
        if (a(f2, f3, this.j)) {
            this.p = d;
            return;
        }
        if (a(f2, f3, this.k)) {
            this.p = e;
            return;
        }
        List<View> list = this.h;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.h.size(); i++) {
            if (a(f2, f3, this.h.get(i))) {
                this.p = b;
                return;
            }
        }
    }

    public final int a() {
        return this.p;
    }

    private static boolean a(float f2, float f3, View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float f4 = iArr[0];
        float f5 = iArr[1];
        float width = view.getWidth() + f4;
        float height = view.getHeight() + f5;
        Object[] objArr = new Object[7];
        Float.valueOf(f4);
        Float.valueOf(f5);
        Float.valueOf(width);
        Float.valueOf(height);
        Float.valueOf(f2);
        Float.valueOf(f3);
        return f2 >= f4 && f2 <= width && f3 >= f5 && f3 <= height;
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
            bVar.h = this.a;
            bVar.i = this.b;
            bVar.j = this.c;
            bVar.k = this.d;
            return bVar;
        }
    }
}
