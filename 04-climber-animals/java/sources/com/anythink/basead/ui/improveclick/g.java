package com.anythink.basead.ui.improveclick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;
    public static final int f = 16;
    public static final int g = 32;
    public static final int h = 64;

    public static final class a {
        public static final String a = "screen_style";
        public static final String b = "shake_view_extra_container";
        public static final String c = "native_ad_event_listener";
        public static final String d = "video_length";
        public static final String e = "material_direction";
        public static final String f = "click_type";
        public static final String g = "click_area";
        public static final String h = "cta_text";
        public static final String i = "video_play_fail_message";
        public static final String j = "video_reset_player_view_type";
        public static final String k = "video_progress";
    }

    private static List<c> a(int i, Context context, w wVar, x xVar, ViewGroup viewGroup, int i2, c.a aVar) {
        ViewGroup viewGroup2 = viewGroup;
        ArrayList arrayList = new ArrayList();
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup2.findViewById(q.a(context, "myoffer_guide2click_container", "id"));
        View viewFindViewById = viewGroup2.findViewById(q.a(context, "myoffer_guide2click_mask", "id"));
        View viewFindViewById2 = viewGroup2.findViewById(q.a(viewGroup.getContext(), "myoffer_rl_root", "id"));
        if (viewFindViewById2 != null && (viewFindViewById2 instanceof ViewGroup)) {
            viewGroup2 = (ViewGroup) viewFindViewById2;
        } else {
            View viewFindViewById3 = viewGroup2.findViewById(q.a(viewGroup.getContext(), "myoffer_splash_root", "id"));
            if (viewFindViewById3 != null && (viewFindViewById3 instanceof ViewGroup)) {
                viewGroup2 = (ViewGroup) viewFindViewById3;
            }
        }
        if ((i & 16) == 16) {
            d dVar = new d();
            dVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i2, aVar);
            arrayList.add(dVar);
        }
        if ((i & 1) == 1) {
            j jVar = new j();
            jVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i2, aVar);
            arrayList.add(jVar);
        }
        if ((i & 2) == 2) {
            e eVar = new e();
            eVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i2, aVar);
            arrayList.add(eVar);
        }
        if ((i & 4) == 4) {
            k kVar = new k();
            kVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i2, aVar);
            arrayList.add(kVar);
        }
        if (relativeLayout != null && (i & 8) == 8) {
            f fVar = new f();
            fVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i2, aVar);
            arrayList.add(fVar);
        }
        if (relativeLayout != null && (i & 32) == 32) {
            h hVar = new h();
            hVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i2, aVar);
            arrayList.add(hVar);
        }
        if ((i & 64) == 64) {
            b bVar = new b();
            bVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i2, aVar);
            arrayList.add(bVar);
        }
        return arrayList;
    }
}
