package com.smartdigimkt.h1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.smartdigimkt.sdk.basead.ui.OwnNativeATView;
import com.smartdigimkt.t4.v;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {
    public final Context a;
    public final com.smartdigimkt.b3.l b;
    public final com.smartdigimkt.a3.a c;
    public final boolean d;
    public com.smartdigimkt.j1.a e;
    public volatile boolean f;
    public boolean g;
    public String h;
    public final int i;
    public int j;
    public int k;
    public JSONArray l;
    public long m;
    public boolean n = false;

    public p(Context context, com.smartdigimkt.b3.l lVar, com.smartdigimkt.a3.a aVar, boolean z) {
        com.smartdigimkt.b3.e eVar;
        this.i = 1;
        this.a = context.getApplicationContext();
        this.b = lVar;
        this.c = aVar;
        this.d = z;
        if (aVar != null && (eVar = aVar.s) != null) {
            int i = eVar.o;
        }
        this.i = (lVar == null || !lVar.h()) ? 2 : 1;
    }

    public abstract View a(Context context, v vVar);

    public final boolean a(boolean z, boolean z2) {
        com.smartdigimkt.b3.l lVar = this.b;
        if (lVar.p != 67) {
            return false;
        }
        if (!z2) {
            if (this.n) {
                return false;
            }
            this.n = true;
        }
        return lVar.a(z, z2);
    }

    public View b() {
        return null;
    }

    public abstract ViewGroup c();

    public final com.smartdigimkt.h0.m a() {
        com.smartdigimkt.h0.m mVar = new com.smartdigimkt.h0.m(this.c, "");
        OwnNativeATView ownNativeATView = ((k) this).q;
        if (ownNativeATView != null) {
            mVar.e = ownNativeATView.getWidth();
            mVar.f = ownNativeATView.getHeight();
            try {
                int[] iArr = new int[2];
                ownNativeATView.getLocationOnScreen(iArr);
                mVar.l = iArr[0];
                mVar.m = iArr[1];
            } catch (Throwable unused) {
            }
            long j = this.m;
            if (j > 0) {
                mVar.n = j;
            }
        }
        return mVar;
    }
}
