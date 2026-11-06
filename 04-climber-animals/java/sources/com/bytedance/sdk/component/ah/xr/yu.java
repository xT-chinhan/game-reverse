package com.bytedance.sdk.component.ah.xr;

import java.net.URL;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public final class yu {
    private volatile d ab;
    final qv ah;
    public le c;
    final op d;
    final Object ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final y f1150ms;
    final String xr;

    yu(ms msVar) {
        this.f1150ms = msVar.f1151ms;
        this.xr = msVar.xr;
        this.ah = msVar.ah.ms();
        this.d = msVar.d;
        this.ka = msVar.ka != null ? msVar.ka : this;
        if (msVar.c != null) {
            this.c = msVar.c;
        } else {
            this.c = new le();
        }
    }

    public y ms() {
        return this.f1150ms;
    }

    public String xr() {
        return this.xr;
    }

    public qv ah() {
        return this.ah;
    }

    public String ms(String str) {
        return this.ah.ms(str);
    }

    public op d() {
        return this.d;
    }

    public Object ka() {
        return this.ka;
    }

    public ms c() {
        return new ms(this);
    }

    public d ab() {
        d dVar = this.ab;
        if (dVar != null) {
            return dVar;
        }
        d dVarMs = d.ms(this.ah);
        this.ab = dVarMs;
        return dVarMs;
    }

    public boolean x() {
        return this.f1150ms.d();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Request{method=").append(this.xr).append(", url=").append(this.f1150ms).append(", tag=");
        Object obj = this.ka;
        if (obj == this) {
            obj = null;
        }
        return sbAppend.append(obj).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    public static class ms {
        qv.ms ah;
        le c;
        op d;
        Object ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        y f1151ms;
        String xr;

        public ms() {
            this.xr = "GET";
            this.ah = new qv.ms();
        }

        ms(yu yuVar) {
            this.f1151ms = yuVar.f1150ms;
            this.xr = yuVar.xr;
            this.d = yuVar.d;
            this.ka = yuVar.ka;
            this.ah = yuVar.ah.xr();
            this.c = yuVar.c;
        }

        public ms ms(y yVar) {
            if (yVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f1151ms = yVar;
            return this;
        }

        public ms ms(URL url) {
            if (url == null) {
                throw new NullPointerException("url == null");
            }
            y yVarMs = y.ms(url);
            if (yVarMs == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(url)));
            }
            return ms(yVarMs);
        }

        public ms ms(String str, String str2) {
            this.ah.ah(str, str2);
            return this;
        }

        public ms ms(String str) {
            this.ah.xr(str);
            return this;
        }

        public ms ms(qv qvVar) {
            this.ah = qvVar.xr();
            return this;
        }

        public ms ms(d dVar) {
            String string = dVar.toString();
            return string.isEmpty() ? ms("Cache-Control") : ms("Cache-Control", string);
        }

        public ms delete(op opVar) {
            return ms("DELETE", opVar);
        }

        public ms delete() {
            return delete(com.bytedance.sdk.component.ah.xr.ms.ah.d);
        }

        public ms ms(String str, op opVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (opVar != null && !com.bytedance.sdk.component.ah.xr.ms.ah.c.ah(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (opVar == null && com.bytedance.sdk.component.ah.xr.ms.ah.c.xr(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.xr = str;
            this.d = opVar;
            return this;
        }

        public ms ms(Object obj) {
            this.ka = obj;
            return this;
        }

        public yu ms() {
            if (this.f1151ms == null) {
                throw new IllegalStateException("url == null");
            }
            return new yu(this);
        }
    }
}
