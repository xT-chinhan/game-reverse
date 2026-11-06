package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public a a;
    public c b = new c();
    public byte[] c;
    public File d;

    public b(String str, byte b) {
        this.a = new a(str, b);
    }

    public final long a() {
        d();
        return this.a.f;
    }

    private void d() {
        if (this.a.c == 0 && this.c != null) {
            this.a.f = this.c.length;
        } else if (this.a.c == 1 && this.d.exists()) {
            this.a.f = this.d.length();
        }
    }

    public final boolean b() {
        return !"none".equals(this.a.d);
    }

    public final void a(String str) {
        this.a.d = str;
    }

    public final void a(int i) {
        this.a.e = i;
        d();
    }

    public final void b(int i) {
        this.a.c = i;
    }

    public final void a(byte[] bArr) {
        this.c = bArr;
        d();
    }

    public final void c() {
        this.b.a = true;
    }

    public static b a(ILogProtocol iLogProtocol) {
        b bVar;
        try {
            bVar = new b(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
            try {
                switch (iLogProtocol.getBodyType()) {
                    case 0:
                        bVar.b(0);
                        bVar.a(iLogProtocol.generate());
                        break;
                    case 1:
                        bVar.b(1);
                        bVar.d = new File(iLogProtocol.getFilePath());
                        break;
                    default:
                        Log.w("efs.base", "Can not support body type: " + iLogProtocol.getBodyType());
                        break;
                }
            } catch (Exception e) {
                e = e;
                Log.e("efs.base", "log send error", e);
            }
        } catch (Exception e2) {
            e = e2;
            bVar = null;
        }
        return bVar;
    }
}
