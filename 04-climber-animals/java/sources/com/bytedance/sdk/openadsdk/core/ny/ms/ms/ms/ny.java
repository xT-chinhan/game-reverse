package com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.ce;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ny implements com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms {
    private Map<String, Object> ab;
    private Context ah;
    private ce c;
    private boolean d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms f3146ms;
    private int ny;
    private com.bytedance.sdk.component.hi.ms.ms x;
    private lm xr;

    public ny(ce ceVar, Context context, boolean z, String str, Map<String, Object> map, com.bytedance.sdk.component.hi.ms.ms msVar, int i) {
        this.c = ceVar;
        this.ah = context;
        this.d = z;
        this.ka = str;
        this.ab = map;
        this.x = msVar;
        this.ny = i;
    }

    public void ms(lm lmVar) {
        this.xr = lmVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
    public boolean ms(final Map<String, Object> map) {
        boolean zMs = !ch.ms() ? new ch(this.xr, this.ah).ms(this.ka).ms(this.ny).xr(this.d).ms(new ch.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ny.1
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.ms
            public void ms() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.ms
            public void xr() {
                if (ny.this.f3146ms != null ? ny.this.f3146ms.ms(map) : false) {
                    return;
                }
                ny.this.x.xr(ny.this.ab);
            }
        }) : false;
        ch.ms(false);
        if (zMs) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar = this.f3146ms;
        return msVar != null && msVar.ms(map);
    }
}
