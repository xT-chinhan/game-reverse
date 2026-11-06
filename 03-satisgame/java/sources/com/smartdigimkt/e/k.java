package com.smartdigimkt.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements com.smartdigimkt.i3.l {
    public final /* synthetic */ Context a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Runnable c;
    public final /* synthetic */ Runnable d;
    public final /* synthetic */ int e;
    public final /* synthetic */ l f;

    public k(l lVar, Context context, int i, i iVar, h hVar, int i2) {
        this.f = lVar;
        this.a = context;
        this.b = i;
        this.c = iVar;
        this.d = hVar;
        this.e = i2;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (this.f.a.getTag(R.id.sdm_bubble_delay_runnable_tag) != this.f.b[0]) {
            return;
        }
        if (bitmap == null || bitmap.isRecycled() || !TextUtils.equals(str, this.f.g)) {
            Context context = this.a;
            l lVar = this.f;
            q.a(context, lVar.a, this.b, this.c, this.d, this.e, lVar.b[0]);
            return;
        }
        if (!q.a(this.f.a)) {
            l lVar2 = this.f;
            q.b(lVar2.a, lVar2.b[0]);
            return;
        }
        Bitmap bitmapCopy = null;
        if (!bitmap.isRecycled()) {
            try {
                Bitmap.Config config = bitmap.getConfig();
                if (config == null) {
                    config = Bitmap.Config.ARGB_8888;
                }
                bitmapCopy = bitmap.copy(config, false);
            } catch (OutOfMemoryError unused) {
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        if (bitmapCopy != null) {
            this.f.a.post(new j(this, bitmapCopy));
            return;
        }
        Context context2 = this.a;
        l lVar3 = this.f;
        q.a(context2, lVar3.a, this.b, this.c, this.d, this.e, lVar3.b[0]);
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
        Context context = this.a;
        l lVar = this.f;
        q.a(context, lVar.a, this.b, this.c, this.d, this.e, lVar.b[0]);
    }
}
