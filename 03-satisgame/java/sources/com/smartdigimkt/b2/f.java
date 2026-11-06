package com.smartdigimkt.b2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public Context a;
    public com.smartdigimkt.b3.c b;
    public com.smartdigimkt.a3.a c;
    public ViewGroup d;
    public int e;
    public RelativeLayout f;
    public View g;
    public e h;

    public abstract void a(int i, HashMap map);

    public void a(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, e eVar) {
        this.a = context;
        this.b = cVar;
        this.c = aVar;
        this.d = viewGroup;
        this.e = i;
        this.h = eVar;
        this.f = relativeLayout;
        this.g = view;
    }
}
