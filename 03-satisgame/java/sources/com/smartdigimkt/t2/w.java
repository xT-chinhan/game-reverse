package com.smartdigimkt.t2;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Runnable {
    public final /* synthetic */ z a;

    public w(z zVar) {
        this.a = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.d = true;
            new ArrayList();
            z zVar = this.a;
            zVar.f = zVar.b.c();
            z zVar2 = this.a;
            String str = zVar2.a;
            if (zVar2.f > zVar2.e) {
                ArrayList<v> arrayListD = zVar2.b.d();
                String str2 = this.a.a;
                arrayListD.size();
                for (v vVar : arrayListD) {
                    try {
                        File file = new File(vVar.b);
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (!TextUtils.isEmpty(vVar.a)) {
                            String str3 = vVar.a;
                            this.a.c.remove(str3);
                            com.smartdigimkt.l3.d dVarA = com.smartdigimkt.l3.d.a();
                            if (dVarA.a != null && !TextUtils.isEmpty(str3)) {
                                dVarA.a.remove(str3);
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                String str4 = this.a.a;
            }
        } catch (Throwable unused3) {
        }
        this.a.d = false;
    }
}
