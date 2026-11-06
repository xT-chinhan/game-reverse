package com.smartdigimkt.e0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.smartdigimkt.i3.l;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements l {
    public final /* synthetic */ Context a;
    public final /* synthetic */ g b;

    public a(g gVar, Context context) {
        this.b = gVar;
        this.a = context;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        Context context;
        View viewFindViewById;
        View view = this.b.c;
        if (view == null || (context = this.a) == null || (viewFindViewById = view.findViewById(k.a(context, "myoffer_letter_top", "id"))) == null) {
            return;
        }
        viewFindViewById.setBackground(new BitmapDrawable(this.a.getResources(), bitmap));
    }
}
