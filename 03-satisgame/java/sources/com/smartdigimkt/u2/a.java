package com.smartdigimkt.u2;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.b3.i;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z2.d;
import com.smartdigimkt.z2.p;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public final p a;
    public final int b;
    public final Object c;
    public final ConcurrentHashMap d;
    public final ConcurrentHashMap e;

    public a(Context context) {
        p pVarA = p.a(d.a(context));
        this.a = pVarA;
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        Object obj = new Object();
        this.c = obj;
        int iA = a();
        this.b = iA;
        synchronized (obj) {
            ArrayList arrayListA = pVarA.a(iA);
            if (!arrayListA.isEmpty()) {
                for (int i = 0; i < arrayListA.size(); i++) {
                    i iVar = (i) arrayListA.get(i);
                    this.e.put(iVar.b, iVar);
                }
            }
        }
    }

    public abstract int a();

    public final void a(String str, int i, int i2) {
        synchronized (this.c) {
            if (!TextUtils.isEmpty(str)) {
                i iVarA = this.a.a(this.b, (i) this.e.get(str), str, i, i2);
                if (iVarA != null) {
                    SDKContext.getInstance().j();
                    this.e.put(str, iVarA);
                }
            }
        }
    }

    public final void a(String str, long j) {
        synchronized (this.c) {
            if (!TextUtils.isEmpty(str)) {
                i iVarA = this.a.a(this.b, (i) this.e.get(str), str, j);
                if (iVarA != null) {
                    SDKContext.getInstance().j();
                    this.e.put(str, iVarA);
                }
            }
        }
    }

    public final void a(String str, String str2) {
        synchronized (this.c) {
            this.d.put(str, str2);
            this.a.b(this.b, str, str2);
        }
    }

    public final ArrayList a(ArrayList arrayList) {
        synchronized (this.c) {
            ArrayList arrayList2 = new ArrayList();
            if (arrayList.isEmpty()) {
                return arrayList2;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                String str = (String) arrayList.get(i);
                if (!TextUtils.isEmpty(str)) {
                    String str2 = (String) this.d.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        i iVar = (i) this.e.get(str2);
                        SDKContext.getInstance().j();
                        if (iVar != null && System.currentTimeMillis() < iVar.c) {
                            SDKContext.getInstance().getClass();
                            arrayList2.add(iVar);
                        }
                    }
                }
            }
            return arrayList2;
        }
    }
}
