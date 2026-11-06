package com.smartdigimkt.k3;

import android.graphics.Bitmap;
import com.smartdigimkt.i3.h;
import com.smartdigimkt.i3.k;
import com.smartdigimkt.i3.l;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.n;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.i;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {
    public final o k;
    public k l;

    public b(o oVar) {
        super(oVar.b);
        this.k = oVar;
    }

    @Override // com.smartdigimkt.k3.d
    public final boolean a(InputStream inputStream) {
        n nVarA = n.a();
        o oVar = this.k;
        return nVarA.a(oVar.a, i.b(oVar.b), inputStream);
    }

    @Override // com.smartdigimkt.k3.d
    public final Map b() {
        return null;
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(c cVar) {
        f.a().a(cVar, 4);
    }

    @Override // com.smartdigimkt.k3.d
    public final void a() {
        k kVar = this.l;
        if (kVar != null) {
            o oVar = this.k;
            kVar.getClass();
            String str = oVar.b;
            Bitmap bitmapA = kVar.d.a(oVar, kVar.a, kVar.b);
            if (bitmapA != null && !bitmapA.isRecycled()) {
                kVar.d.a(oVar.b, bitmapA, kVar.a, kVar.b);
            }
            m.a(kVar.d, kVar.c.b, bitmapA);
        }
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(String str) {
        k kVar = this.l;
        if (kVar != null) {
            o oVar = this.k;
            m mVar = kVar.d;
            String str2 = oVar.b;
            synchronized (mVar.e) {
                try {
                    LinkedList<l> linkedList = (LinkedList) mVar.e.remove(str2);
                    if (linkedList != null) {
                        for (l lVar : linkedList) {
                            if (lVar != null) {
                                f.a().a(new h(lVar, str2, str));
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
