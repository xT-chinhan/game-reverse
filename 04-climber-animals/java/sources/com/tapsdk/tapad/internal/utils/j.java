package com.tapsdk.tapad.internal.utils;

import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    static class a implements View.OnSystemUiVisibilityChangeListener {
        final /* synthetic */ Window a;

        a(Window window) {
            this.a = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            this.a.getDecorView().setSystemUiVisibility(5894);
        }
    }

    public static void a(Window window) {
        if (window != null) {
            window.clearFlags(8);
        }
    }

    public static void b(Window window) {
        if (window != null) {
            window.setFlags(8, 8);
        }
    }

    public static void c(Window window) {
        if (window != null) {
            window.getDecorView().setSystemUiVisibility(2);
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new a(window));
        }
    }
}
