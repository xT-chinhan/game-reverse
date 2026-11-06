package com.smartdigimkt.j3;

import android.text.TextUtils;
import com.smartdigimkt.i3.n;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.r4.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.smartdigimkt.k3.d {
    public final o k;
    public e l;
    public final String m;

    public g(o oVar) {
        super(oVar.b);
        this.k = oVar;
        this.m = n.a().b(oVar.a, i.b(oVar.b));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0052 A[Catch: all -> 0x0056, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0056, blocks: (B:19:0x0045, B:27:0x0052), top: B:42:0x0007 }] */
    @Override // com.smartdigimkt.k3.d
    public final boolean a(InputStream inputStream) {
        FileOutputStream fileOutputStream;
        boolean z = false;
        try {
            if (!TextUtils.isEmpty(this.m)) {
                try {
                    try {
                        String strB = n.a().b(this.k.a);
                        if (TextUtils.isEmpty(strB)) {
                            return false;
                        }
                        File file = new File(strB);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        fileOutputStream = new FileOutputStream(this.m);
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                            }
                            fileOutputStream.close();
                            z = true;
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return z;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                    th.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return z;
    }

    @Override // com.smartdigimkt.k3.d
    public final Map b() {
        return null;
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(com.smartdigimkt.k3.c cVar) {
        com.smartdigimkt.q3.f.a().a(cVar, 4);
    }

    @Override // com.smartdigimkt.k3.d
    public final void a() {
        e eVar = this.l;
        if (eVar != null) {
            o oVar = this.k;
            eVar.getClass();
            String str = oVar.b;
            eVar.b.a(eVar.a.b);
        }
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(String str) {
        e eVar = this.l;
        if (eVar != null) {
            eVar.b.a(1, this.k.b, str);
        }
    }
}
