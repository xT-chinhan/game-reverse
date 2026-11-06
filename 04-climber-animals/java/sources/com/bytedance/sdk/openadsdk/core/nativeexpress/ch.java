package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch implements com.bytedance.adsdk.ugeno.ah.qv, com.bytedance.sdk.component.adexpress.xr.ny {
    private com.bytedance.sdk.openadsdk.u.x ab;
    private lm ah;
    private long c;
    private String d;
    private long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.c.ms f2957ms;
    private String xr;

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void d() {
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ka() {
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ms(boolean z) {
    }

    public ch(com.bytedance.sdk.openadsdk.c.ms msVar, String str, lm lmVar, String str2) {
        this.f2957ms = msVar;
        this.xr = str;
        this.d = str2;
        this.ah = lmVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void c() {
        this.f2957ms.ms();
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void xr(boolean z) {
        this.f2957ms.ms(z ? 1 : 0);
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void ab() {
        com.bytedance.sdk.openadsdk.u.x xVar = this.ab;
        if (xVar == null) {
            return;
        }
        xVar.c(yu.ms(this.ah));
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void x() {
        this.f2957ms.xr();
        com.bytedance.sdk.openadsdk.u.x xVar = this.ab;
        if (xVar == null) {
            return;
        }
        xVar.ab(yu.ms(this.ah));
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void ms(int i, String str) {
        this.f2957ms.ms(i, str);
        ny.ms(i, this.xr, this.d, this.ah);
        com.bytedance.sdk.openadsdk.u.x xVar = this.ab;
        if (xVar == null) {
            return;
        }
        xVar.ms(true, yu.ms(this.ah), 105);
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void ms(int i) {
        this.ka = System.currentTimeMillis();
        if (i == 3) {
            this.f2957ms.ms("dynamic_render2_start");
        } else {
            this.f2957ms.ms("dynamic_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void xr(int i) {
        if (i == 3) {
            this.f2957ms.xr("dynamic_sub_analysis2_start");
        } else {
            this.f2957ms.xr("dynamic_sub_analysis_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void ah(int i) {
        if (i == 3) {
            this.f2957ms.xr("dynamic_sub_analysis2_end");
        } else {
            this.f2957ms.xr("dynamic_sub_analysis_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void d(int i) {
        if (i == 3) {
            this.f2957ms.xr("dynamic_sub_render2_start");
        } else {
            this.f2957ms.xr("dynamic_sub_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void ka(int i) {
        if (i == 3) {
            this.f2957ms.xr("dynamic_sub_render2_end");
        } else {
            this.f2957ms.xr("dynamic_sub_render_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void c(int i) {
        final String str;
        this.c = System.currentTimeMillis();
        if (i == 3) {
            this.f2957ms.ah("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.f2957ms.ah("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.f2957ms.ms(true);
        com.bytedance.sdk.component.ch.ab.ah(new com.bytedance.sdk.component.ch.ny("dynamic_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ch.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.zb.ah.ab(ch.this.ah, ch.this.xr, str, null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void ms(int i, int i2, String str, boolean z) {
        this.f2957ms.ms(true);
        if (i == 3) {
            this.f2957ms.xr(i2, "dynamic_render2_error");
        } else {
            this.f2957ms.xr(i2, "dynamic_render_error");
        }
        ny.ms(i2, this.xr, this.d, this.ah);
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void ny() {
        this.f2957ms.ah();
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void ch() {
        this.f2957ms.ms(true);
        this.f2957ms.ka();
        com.bytedance.sdk.component.ch.ab.ah(new com.bytedance.sdk.component.ch.ny("native_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ch.2
            @Override // java.lang.Runnable
            public void run() {
                ny.ms(ch.this.xr, ch.this.d, ch.this.ah);
                com.bytedance.sdk.openadsdk.core.zb.ah.ab(ch.this.ah, ch.this.xr, "dynamic_backup_render", null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void hi() {
        this.f2957ms.ms(true);
        this.f2957ms.zb();
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void sl() {
        this.f2957ms.u();
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ny
    public void zb() {
        this.f2957ms.xr();
    }

    public void u() {
        this.f2957ms.ao();
        this.f2957ms.h();
    }

    public void ms(com.bytedance.sdk.openadsdk.u.x xVar) {
        this.ab = xVar;
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ms() {
        this.f2957ms.d("ugen_render_start");
        this.f2957ms.d("ugen_sub_analysis_start");
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void xr() {
        this.f2957ms.d("ugen_sub_analysis_end");
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ah() {
        this.f2957ms.d("ugen_sub_render_start");
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ms(com.bytedance.adsdk.ugeno.ah.h hVar) {
        if (hVar.ms() == 0) {
            this.f2957ms.d("ugen_sub_render_end");
            this.f2957ms.ka("ugen_render_success");
        } else {
            this.f2957ms.ah(hVar.ms(), "ugen_render_error");
        }
        this.f2957ms.ms(true);
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ms(JSONObject jSONObject) {
        this.f2957ms.ms(jSONObject);
    }
}
