package com.anythink.china.c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e extends com.anythink.core.common.res.image.b {
    private final File a;
    private a b;
    private final f.a c;

    public interface a {
        void a(File file, f.a aVar);

        void a(File file, f.a aVar, String str);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    public e(String str, File file, f.a aVar) {
        super(str);
        this.a = file;
        this.c = aVar;
    }

    public final void a(a aVar) {
        this.b = aVar;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.a.getAbsolutePath());
            byte[] bArr = new byte[1048576];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                    fileOutputStream.flush();
                } else {
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(Runnable runnable) {
        com.anythink.core.common.u.b.c.a().c(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cf, runnable));
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(this.a, this.c);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(this.a, this.c, str);
        }
    }
}
