package com.anythink.core.common.r;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.t;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private final Context a;
    private final String b;
    private final int c;
    private final int d;

    /* synthetic */ c(Context context, String str, int i, int i2, byte b) {
        this(context, str, i, i2);
    }

    private c(Context context, String str, int i, int i2) {
        this.a = context;
        this.b = str;
        this.c = i;
        this.d = i2;
    }

    public final Context a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public static class a {
        private Context a;
        private String b;
        private int c;
        private int d;

        public final a a(Context context) {
            this.a = context;
            return this;
        }

        public final a a(String str) {
            this.b = str;
            return this;
        }

        public final a a(int i) {
            this.c = i;
            return this;
        }

        public final a b(int i) {
            this.d = i;
            return this;
        }

        private void b() {
            if (TextUtils.isEmpty(this.b) || !this.b.equalsIgnoreCase(t.b.f)) {
                return;
            }
            this.c = 0;
        }

        public final c a() {
            if (!TextUtils.isEmpty(this.b) && this.b.equalsIgnoreCase(t.b.f)) {
                this.c = 0;
            }
            return new c(this.a, this.b, this.c, this.d, (byte) 0);
        }
    }
}
