package com.byazt.os;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 634, 26})
public class qg {
    public InterfaceC0286qg fs;
    public String l;
    public Context n;
    public String q;
    public String qg;
    public View rv;
    public String s;
    public int tj;
    public boolean w;
    public Drawable x;

    /* JADX INFO: renamed from: com.byazt.os.qg$qg, reason: collision with other inner class name */
    public interface InterfaceC0286qg {
        void n(DialogInterface dialogInterface);

        void qg(DialogInterface dialogInterface);

        void s(DialogInterface dialogInterface);
    }

    private qg(n nVar) {
        this.w = true;
        this.n = nVar.s;
        this.qg = nVar.q;
        this.s = nVar.l;
        this.q = nVar.w;
        this.l = nVar.x;
        this.w = nVar.fs;
        this.x = nVar.rv;
        this.fs = nVar.tj;
        this.rv = nVar.n;
        this.tj = nVar.qg;
    }

    @com.byazt.cp.n(n = {0, 1, 634, 48})
    public static final class n {
        public boolean fs;
        public String l;
        public View n;
        public String q;
        public int qg;
        public Drawable rv;
        public Context s;
        public InterfaceC0286qg tj;
        public String w;
        public String x;

        public n(Context context) {
            this.s = context;
        }

        public n n(String str) {
            this.q = str;
            return this;
        }

        public n qg(String str) {
            this.l = str;
            return this;
        }

        public n s(String str) {
            this.w = str;
            return this;
        }

        public n q(String str) {
            this.x = str;
            return this;
        }

        public n n(boolean z) {
            this.fs = z;
            return this;
        }

        public n n(Drawable drawable) {
            this.rv = drawable;
            return this;
        }

        public n n(InterfaceC0286qg interfaceC0286qg) {
            this.tj = interfaceC0286qg;
            return this;
        }

        public n n(int i) {
            this.qg = i;
            return this;
        }

        public qg n() {
            return new qg(this);
        }
    }
}
