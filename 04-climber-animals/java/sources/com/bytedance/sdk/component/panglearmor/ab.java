package com.bytedance.sdk.component.panglearmor;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    private String ah;
    private boolean d;
    private x ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f1301ms;
    private String xr;

    public Context ms() {
        return this.f1301ms;
    }

    public String xr() {
        return this.xr;
    }

    public boolean ah() {
        return this.d;
    }

    public x d() {
        return this.ka;
    }

    public static class ms {
        private final String ah;
        private boolean d = false;
        private x ka = null;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final Context f1302ms;
        private final String xr;

        public ms(Context context, String str, String str2) {
            this.f1302ms = context;
            this.ah = str2;
            this.xr = str;
        }

        public void ms(x xVar) {
            this.ka = xVar;
        }

        public ms ms(boolean z) {
            this.d = z;
            return this;
        }

        public ab ms() {
            ab abVar = new ab();
            abVar.f1301ms = this.f1302ms;
            abVar.xr = this.xr;
            abVar.ah = this.ah;
            abVar.ka = this.ka;
            abVar.d = this.d;
            return abVar;
        }
    }
}
