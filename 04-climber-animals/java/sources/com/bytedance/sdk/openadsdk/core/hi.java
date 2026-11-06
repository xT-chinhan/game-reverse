package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class hi {
    private String ab;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ah ah;
    private View c;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.c d;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.ka ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f2568ms;
    private final lm xr;

    public hi(Context context, lm lmVar, View view, String str) {
        this.ab = "rewarded_video";
        this.xr = lmVar;
        this.f2568ms = context;
        this.c = view;
        if (TextUtils.isEmpty(str)) {
            this.ab = com.bytedance.sdk.openadsdk.core.jw.f.xr(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar));
        } else {
            this.ab = str;
        }
        if (lmVar.jr() == 4) {
            this.ah = com.bytedance.sdk.openadsdk.core.hi.ka.ms(context, lmVar, this.ab, false);
        }
        String str2 = this.ab;
        com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.c(context, lmVar, str2, com.bytedance.sdk.openadsdk.core.jw.f.xr(str2));
        this.d = cVar;
        cVar.ms(this.c);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.d.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ah);
        String str3 = this.ab;
        com.bytedance.sdk.openadsdk.core.nativeexpress.ka kaVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.ka(context, lmVar, str3, com.bytedance.sdk.openadsdk.core.jw.f.xr(str3));
        this.ka = kaVar;
        kaVar.ms(this.c);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.ka.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ah);
    }

    public void ms(int i, com.bytedance.sdk.openadsdk.core.nw.i iVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.ka kaVar;
        if (i == -1 || iVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nw.hi hiVar = new com.bytedance.sdk.openadsdk.core.nw.hi();
        hiVar.ms(iVar.f3057ms);
        hiVar.xr(iVar.xr);
        hiVar.ah(iVar.ah);
        hiVar.d(iVar.d);
        hiVar.ms(iVar.ub);
        hiVar.ms(iVar.ao);
        if (i != 1) {
            if (i == 2 && (kaVar = this.ka) != null) {
                kaVar.ms(iVar);
                this.ka.ms(hiVar);
                this.ka.ms(this.c, hiVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar = this.d;
        if (cVar != null) {
            cVar.ms(iVar);
            this.d.ms(hiVar);
            this.d.ms(this.c, hiVar);
        }
    }
}
