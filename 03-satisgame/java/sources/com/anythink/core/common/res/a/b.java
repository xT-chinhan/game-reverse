package com.anythink.core.common.res.a;

import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.res.d;
import com.anythink.core.common.res.e;
import com.anythink.core.common.u.b.c;
import com.anythink.core.common.u.n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b extends com.anythink.core.common.res.image.b {
    e a;
    a b;
    String c;

    public interface a {
        void a();

        void a(e eVar, String str);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    public b(e eVar) {
        super(eVar.h);
        this.a = eVar;
        if (eVar != null) {
            this.c = d.a(s.b().g()).b(eVar.g, n.a(eVar.h));
        }
    }

    private void a(a aVar) {
        this.b = aVar;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        if (TextUtils.isEmpty(this.c)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            String strA = d.a(s.b().g()).a(this.a.g);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            File file = new File(strA);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(this.c);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, i);
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            th.printStackTrace();
            if (fileOutputStream == null) {
                return false;
            }
            try {
                return false;
            } catch (Throwable th4) {
                return false;
            }
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(Runnable runnable) {
        c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bb, runnable));
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(this.a, str);
        }
    }
}
