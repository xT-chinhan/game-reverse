package com.anythink.basead.ui.improveclick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    protected Context d;
    protected w e;
    protected x f;
    protected ViewGroup g;
    protected int h;
    RelativeLayout i;
    View j;
    protected a k;

    public interface a {
        void a(int i, int i2);
    }

    public interface b extends a {
        void a();

        void a(long j);

        void b();
    }

    abstract void a();

    abstract void a(int i, Map<String, Object> map);

    public void a(Context context, w wVar, x xVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, a aVar) {
        this.d = context;
        this.e = wVar;
        this.f = xVar;
        this.g = viewGroup;
        this.h = i;
        this.k = aVar;
        this.i = relativeLayout;
        this.j = view;
    }

    protected static boolean a(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get("key_has_endcard_improve")) == null || !(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }
}
