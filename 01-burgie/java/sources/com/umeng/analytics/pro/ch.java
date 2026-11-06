package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: TIOStreamTransport.java */
/* JADX INFO: loaded from: classes3.dex */
public class ch extends cj {
    protected InputStream a;
    protected OutputStream b;

    protected ch() {
        this.a = null;
        this.b = null;
    }

    public ch(InputStream inputStream) {
        this.a = null;
        this.b = null;
        this.a = inputStream;
    }

    public ch(OutputStream outputStream) {
        this.a = null;
        this.b = null;
        this.b = outputStream;
    }

    public ch(InputStream inputStream, OutputStream outputStream) {
        this.a = null;
        this.b = null;
        this.a = inputStream;
        this.b = outputStream;
    }

    @Override // com.umeng.analytics.pro.cj
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cj
    public void b() throws ck {
    }

    @Override // com.umeng.analytics.pro.cj
    public void c() {
        if (this.a != null) {
            try {
                this.a.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.a = null;
        }
        if (this.b != null) {
            try {
                this.b.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.b = null;
        }
    }

    @Override // com.umeng.analytics.pro.cj
    public int a(byte[] bArr, int i, int i2) throws ck {
        if (this.a == null) {
            throw new ck(1, "Cannot read from null inputStream");
        }
        try {
            int i3 = this.a.read(bArr, i, i2);
            if (i3 < 0) {
                throw new ck(4);
            }
            return i3;
        } catch (IOException e) {
            throw new ck(0, e);
        }
    }

    @Override // com.umeng.analytics.pro.cj
    public void b(byte[] bArr, int i, int i2) throws ck {
        if (this.b == null) {
            throw new ck(1, "Cannot write to null outputStream");
        }
        try {
            this.b.write(bArr, i, i2);
        } catch (IOException e) {
            throw new ck(0, e);
        }
    }

    @Override // com.umeng.analytics.pro.cj
    public void d() throws ck {
        if (this.b == null) {
            throw new ck(1, "Cannot flush null outputStream");
        }
        try {
            this.b.flush();
        } catch (IOException e) {
            throw new ck(0, e);
        }
    }
}
