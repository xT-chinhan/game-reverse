package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class xr {
    public Drawable ab;
    public String ah;
    public boolean c;
    public int ch;
    public String d;
    public String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public Context f4329ms;
    public View ny;
    public InterfaceC0531xr x;
    public String xr;

    /* JADX INFO: renamed from: com.ss.android.download.api.model.xr$xr, reason: collision with other inner class name */
    public interface InterfaceC0531xr {
        void ah(DialogInterface dialogInterface);

        void ms(DialogInterface dialogInterface);

        void xr(DialogInterface dialogInterface);
    }

    private xr(ms msVar) {
        this.c = true;
        this.f4329ms = msVar.ah;
        this.xr = msVar.d;
        this.ah = msVar.ka;
        this.d = msVar.c;
        this.ka = msVar.ab;
        this.c = msVar.x;
        this.ab = msVar.ny;
        this.x = msVar.ch;
        this.ny = msVar.f4330ms;
        this.ch = msVar.xr;
    }

    public static final class ms {
        private String ab;
        private Context ah;
        private String c;
        private InterfaceC0531xr ch;
        private String d;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public View f4330ms;
        private Drawable ny;
        private boolean x;
        public int xr;

        public ms(Context context) {
            this.ah = context;
        }

        public ms ms(String str) {
            this.d = str;
            return this;
        }

        public ms xr(String str) {
            this.ka = str;
            return this;
        }

        public ms ah(String str) {
            this.c = str;
            return this;
        }

        public ms d(String str) {
            this.ab = str;
            return this;
        }

        public ms ms(boolean z) {
            this.x = z;
            return this;
        }

        public ms ms(Drawable drawable) {
            this.ny = drawable;
            return this;
        }

        public ms ms(InterfaceC0531xr interfaceC0531xr) {
            this.ch = interfaceC0531xr;
            return this;
        }

        public ms ms(int i) {
            this.xr = i;
            return this;
        }

        public xr ms() {
            return new xr(this);
        }
    }
}
