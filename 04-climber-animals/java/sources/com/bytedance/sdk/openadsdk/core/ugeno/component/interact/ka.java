package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.common.d.j;
import com.bytedance.adsdk.ugeno.ah.qv;
import com.bytedance.sdk.component.adexpress.xr.u;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.op;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends xr {
    private boolean ab;
    private View c;
    private final ab ch;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.d ka;
    private final com.bytedance.sdk.openadsdk.core.b.xr ny;
    private int x;

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xr
    protected int ms() {
        return 1;
    }

    public ka(lm lmVar, boolean z, ms msVar, ah ahVar) {
        super(lmVar, msVar, ahVar);
        this.ab = false;
        this.x = 2;
        this.ch = new ab() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ka.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void ms() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void ms(boolean z2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void xr() {
                ka.this.ab = true;
                ka.this.ka();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void ah() {
                ka.this.ab = false;
                if (ka.this.c != null) {
                    ka.this.c.setVisibility(8);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void d() {
                if (op.ms() && ka.this.ny != null) {
                    ka.this.ny.ms(ka.this.f3460ms);
                }
            }
        };
        this.ny = new com.bytedance.sdk.openadsdk.core.b.xr(lmVar);
        this.d = z;
    }

    public boolean ah() {
        return op.ms(this.f3460ms);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xr
    public boolean ms(int i, int i2) {
        return op.c(this.f3460ms).ms(i, i2);
    }

    public void ms(final ViewGroup viewGroup, final View view, final boolean z) {
        if (viewGroup == null) {
            HashMap map = new HashMap();
            map.put(j.w.E, Integer.valueOf(ms()));
            map.put("error_code", 100);
            this.ah.ms(false, (Map<String, Object>) map);
            return;
        }
        String strD = op.c(this.f3460ms).d();
        String strKa = op.c(this.f3460ms).ka();
        this.x = op.c(this.f3460ms).ms();
        JSONObject jSONObjectXr = com.bytedance.sdk.openadsdk.core.ugeno.ch.xr(strD, strKa);
        if (jSONObjectXr != null && jSONObjectXr.length() > 0) {
            ms(jSONObjectXr, viewGroup, view, z);
        } else {
            com.bytedance.sdk.openadsdk.core.ugeno.ch.ms(strD, strKa, new com.bytedance.sdk.openadsdk.core.ugeno.ah() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ka.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.ah
                public void ms(String str) {
                    try {
                        ka.this.ms(new JSONObject(str), viewGroup, view, z);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final JSONObject jSONObject, final ViewGroup viewGroup, final View view, final boolean z) {
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ka.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectMs;
                if (ka.this.f3460ms == null) {
                    return;
                }
                if (ka.this.x == 3) {
                    jSONObjectMs = com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ms(ka.this.f3460ms, com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ms(view), jSONObject, ka.this.d);
                } else {
                    jSONObjectMs = jSONObject;
                }
                com.bytedance.sdk.openadsdk.core.ugeno.express.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.xr.ms();
                msVar.ka(com.bytedance.sdk.openadsdk.core.ugeno.ch.ms(ka.this.f3460ms, viewGroup, ka.this.d));
                msVar.ms(jSONObjectMs);
                msVar.ms((qv) new t());
                int height = viewGroup.getHeight();
                int width = viewGroup.getWidth();
                msVar.xr(height);
                msVar.ms(width);
                msVar.ms(com.bytedance.sdk.openadsdk.core.ch.ub().ka());
                msVar.ch(ka.this.f3460ms.ka());
                com.bytedance.sdk.openadsdk.core.ugeno.express.xr xrVarMs = msVar.ms();
                if (ka.this.x == 3) {
                    ka.this.ka = new com.bytedance.sdk.openadsdk.core.ugeno.express.c(re.getContext(), ka.this.f3460ms, xrVarMs, viewGroup);
                } else {
                    ka.this.ka = new com.bytedance.sdk.openadsdk.core.ugeno.express.d(re.getContext(), ka.this.f3460ms, xrVarMs, viewGroup);
                }
                ka.this.ka.ms(new com.bytedance.sdk.component.adexpress.xr.x() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ka.3.1
                    @Override // com.bytedance.sdk.component.adexpress.xr.x
                    public void ms(View view2, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
                        ka.this.xr.ms(view2, i, ahVar);
                    }

                    @Override // com.bytedance.sdk.component.adexpress.xr.x
                    public void ms(View view2, int i, com.bytedance.sdk.component.adexpress.ah ahVar, int i2) {
                        ka.this.xr.ms(view2, i, ahVar);
                    }
                });
                ka.this.ka.ms(new x() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ka.3.2
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.x
                    public void ms() {
                        if (ka.this.c != null) {
                            ka.this.c.setVisibility(8);
                            try {
                                if (ka.this.c.getParent() != null) {
                                    ((ViewGroup) ka.this.c.getParent()).removeView(ka.this.c);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
                ka.this.ah.ms(ka.this.ms());
                ka.this.ka.ms(new com.bytedance.sdk.component.adexpress.xr.ab() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ka.3.3
                    @Override // com.bytedance.sdk.component.adexpress.xr.ab
                    public void ms(View view2, u uVar) {
                        View childAt;
                        if (view2 == null) {
                            return;
                        }
                        ka.this.c = view2;
                        ka.this.c.setVisibility(8);
                        boolean z2 = false;
                        if ((ka.this.c instanceof ViewGroup) && ((ViewGroup) ka.this.c).getChildCount() > 0 && (childAt = ((ViewGroup) ka.this.c).getChildAt(0)) != null && childAt.getVisibility() == 8) {
                            z2 = true;
                        }
                        ka.this.ms(viewGroup, view, ka.this.c, z, z2, ka.this.ka.d(), ka.this.ny);
                        ka.this.ka();
                    }

                    @Override // com.bytedance.sdk.component.adexpress.xr.ab
                    public void ms(int i, String str) {
                        ka.this.xr.ms(viewGroup);
                        HashMap map = new HashMap();
                        map.put("error_code", Integer.valueOf(i));
                        map.put("error_msg", str);
                        map.put(j.w.E, Integer.valueOf(ka.this.ms()));
                        ka.this.ah.ms(false, (Map<String, Object>) map);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        View view = this.c;
        if (view == null || !this.ab) {
            return;
        }
        view.setVisibility(0);
    }

    public void d() {
        this.c = null;
        com.bytedance.sdk.openadsdk.core.ugeno.express.d dVar = this.ka;
        if (dVar != null) {
            dVar.hi();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xr
    public ab xr() {
        return this.ch;
    }

    public void ms(com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr xrVar) {
        this.ny.ms(xrVar);
    }
}
