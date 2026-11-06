package com.mcto.sspsdk.component.imageview2;

import android.graphics.Bitmap;
import com.mcto.sspsdk.internal.gb;
import com.mcto.sspsdk.internal.r9;
import com.mcto.sspsdk.internal.x7;
import com.mcto.sspsdk.internal.y7;
import com.mcto.sspsdk.internal.z7;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ gb b;
    public final /* synthetic */ String c;
    public final /* synthetic */ z7 d;

    public a(z7 z7Var, String str, gb gbVar, String str2, long j) {
        this.d = z7Var;
        this.a = str;
        this.b = gbVar;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        y7 y7VarA;
        List<gb> list;
        byte[] bArr;
        x7 x7VarB;
        synchronized (this.d.b) {
            List arrayList = (List) this.d.c.get(this.a);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                this.d.c.put(this.a, arrayList);
                z = true;
            } else {
                z = false;
            }
            arrayList.add(this.b);
        }
        if (z) {
            try {
                y7VarA = z7.a(this.d, this.a, this.c);
                if (y7VarA == null && (x7VarB = z7.b(this.d, this.c, this.a)) != null && x7VarB.a) {
                    y7VarA = z7.a(this.d, this.a, this.c);
                }
            } catch (Throwable th) {
                r9.a("ssp_ImageView2", "loadClassified failed: " + this.c, th);
                y7VarA = null;
            }
            synchronized (this.d.b) {
                list = (List) this.d.c.remove(this.a);
            }
            if (list != null) {
                for (gb gbVar : list) {
                    if (y7VarA != null) {
                        try {
                            Bitmap bitmap = y7VarA.a;
                            if (bitmap != null) {
                                if (gbVar.a.equals(gbVar.b.m)) {
                                    gbVar.b.a(bitmap);
                                }
                            }
                        } catch (Throwable th2) {
                        }
                    }
                    if (y7VarA == null || (bArr = y7VarA.b) == null) {
                        if (gbVar.a.equals(gbVar.b.m)) {
                            QYImageView2.b(gbVar.b, 0);
                        }
                    } else if (gbVar.a.equals(gbVar.b.m)) {
                        QYImageView2.a(gbVar.b, bArr, gbVar.a);
                    }
                }
            }
        }
    }
}
