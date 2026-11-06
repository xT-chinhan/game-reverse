package com.smartdigimkt.b2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.GuideToClickView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends f {
    public GuideToClickView i;
    public boolean j = false;
    public boolean k = false;

    @Override // com.smartdigimkt.b2.f
    public final void a(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, e eVar) {
        super.a(context, cVar, aVar, viewGroup, relativeLayout, view, i, eVar);
        GuideToClickView guideToClickView = new GuideToClickView(this.a);
        this.i = guideToClickView;
        guideToClickView.setOnClickListener(new h(this));
    }

    @Override // com.smartdigimkt.b2.f
    public final void a(int i, HashMap map) {
        GuideToClickView guideToClickView;
        GuideToClickView guideToClickView2;
        if (i == 103) {
            Object obj = map.get("key_has_endcard_improve");
            if ((obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) || this.e != 1 || this.j || !this.k || (guideToClickView = this.i) == null || this.f == null || guideToClickView == null) {
                return;
            }
            com.smartdigimkt.o3.d.a(guideToClickView);
            this.f.addView(this.i, new RelativeLayout.LayoutParams(-1, -1));
            return;
        }
        if (i == 113) {
            this.j = true;
            GuideToClickView guideToClickView3 = this.i;
            if (guideToClickView3 != null) {
                guideToClickView3.setVisibility(8);
                return;
            }
            return;
        }
        if (i != 116) {
            if (i == 107 || i == 108) {
                this.k = true;
                return;
            }
            return;
        }
        if (this.e != 3 || this.f == null || (guideToClickView2 = this.i) == null) {
            return;
        }
        com.smartdigimkt.o3.d.a(guideToClickView2);
        this.f.addView(this.i, new RelativeLayout.LayoutParams(-1, -1));
    }
}
