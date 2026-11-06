package com.smartdigimkt.f;

import android.os.Build;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends com.smartdigimkt.k3.d {
    public final File k;
    public p l;
    public final q m;

    public n(String str, File file, q qVar) {
        super(str);
        this.k = file;
        this.m = qVar;
    }

    @Override // com.smartdigimkt.k3.d
    public final boolean a(InputStream inputStream) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.k.getAbsolutePath());
            try {
                if (Build.VERSION.SDK_INT >= 34 && !this.k.setReadOnly()) {
                    throw new IOException("Cannot mark plugin read-only");
                }
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.close();
                        return true;
                    }
                    fileOutputStream.write(bArr, 0, i);
                    fileOutputStream.flush();
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th3.getMessage();
            if (this.k.exists()) {
                this.k.delete();
            }
            return false;
        }
    }

    @Override // com.smartdigimkt.k3.d
    public final Map b() {
        return null;
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(com.smartdigimkt.k3.c cVar) {
        com.smartdigimkt.q3.f.a().a(cVar, 2);
    }

    @Override // com.smartdigimkt.k3.d
    public final void a() {
        p pVar = this.l;
        if (pVar != null) {
            File file = this.k;
            q qVar = this.m;
            Objects.toString(file);
            if (file == null || qVar == null) {
                return;
            }
            if (file.exists() && qVar.e == file.length() && qVar.c.equals(j.a(file.getAbsolutePath()))) {
                try {
                    file.renameTo(new File(file.getAbsolutePath().replace(".tmp", ".jar")));
                    pVar.b.a(qVar);
                    JSONObject jSONObject = qVar.h;
                    String string = jSONObject != null ? jSONObject.toString() : "";
                    String.valueOf(com.anythink.core.common.g.c.a);
                    com.smartdigimkt.n3.k.a("2", "", string, "1", "", pVar.a);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            file.exists();
            qVar.c.equals(j.a(file.getAbsolutePath()));
            file.length();
            pVar.b.a((q) null);
            JSONObject jSONObject2 = qVar.h;
            String string2 = jSONObject2 != null ? jSONObject2.toString() : "";
            String str = "file.exists():" + file.exists() + ",md5Check:" + qVar.c.equals(j.a(file.getAbsolutePath())) + ",fileLength:" + (qVar.e == file.length());
            String.valueOf(com.anythink.core.common.g.c.a);
            com.smartdigimkt.n3.k.a("2", "", string2, "2", str, pVar.a);
        }
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(String str) {
        p pVar = this.l;
        if (pVar != null) {
            File file = this.k;
            q qVar = this.m;
            Objects.toString(file);
            if (file == null || qVar == null) {
                return;
            }
            try {
                if (file.exists()) {
                    file.delete();
                }
                pVar.b.a((q) null);
                JSONObject jSONObject = qVar.h;
                String string = jSONObject != null ? jSONObject.toString() : "";
                String.valueOf(com.anythink.core.common.g.c.a);
                com.smartdigimkt.n3.k.a("2", "", string, "2", str, pVar.a);
            } catch (Throwable unused) {
            }
        }
    }
}
