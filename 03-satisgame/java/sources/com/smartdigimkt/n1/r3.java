package com.smartdigimkt.n1;

import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class r3 {
    public final ViewGroup a;
    public final ImageView b;
    public final int c;

    public r3(RelativeLayout relativeLayout) {
        this.a = relativeLayout;
        ImageView imageView = new ImageView(relativeLayout.getContext());
        this.b = imageView;
        imageView.setId(com.smartdigimkt.r4.k.a(relativeLayout.getContext(), "myoffer_loading_id", "id"));
        imageView.setImageResource(com.smartdigimkt.r4.k.a(relativeLayout.getContext(), "myoffer_loading", "drawable"));
        this.c = (int) TypedValue.applyDimension(1, 50.0f, relativeLayout.getResources().getDisplayMetrics());
    }
}
