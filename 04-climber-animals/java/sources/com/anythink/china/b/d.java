package com.anythink.china.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d extends com.anythink.core.common.res.image.b {
    private final File a;
    private a b;
    private final e.a c;

    public interface a {
        void a(File file, e.a aVar);

        void a(File file, e.a aVar, String str, String str2);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    public d(String str, File file, e.a aVar) {
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
    protected final void a(com.anythink.core.common.v.b.d dVar) {
        com.anythink.core.common.v.b.b.a().a(dVar, 2);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(this.a, this.c);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str, String str2) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(this.a, this.c, str, str2);
        }
    }
}
