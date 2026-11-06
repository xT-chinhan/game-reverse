package com.bytedance.sdk.component.x.xr;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.x.ms.ab;
import com.bytedance.sdk.component.x.ms.c;
import com.bytedance.sdk.component.x.ms.d;
import com.bytedance.sdk.component.x.ms.ka;
import com.bytedance.sdk.component.x.ms.ny;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ab {
    private static volatile com.bytedance.sdk.component.x.ms.ms.ms d;
    private ny ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ka f1572ms;
    private Context xr;

    public xr(com.bytedance.sdk.component.x.ms.ms msVar) {
        ms(msVar);
    }

    public xr() {
    }

    public static com.bytedance.sdk.component.x.ms.ms.ms c() {
        if (d == null) {
            synchronized (xr.class) {
                if (d == null) {
                    d = new com.bytedance.sdk.component.x.xr.ka.ms();
                }
            }
        }
        return d;
    }

    public void ms(ka kaVar) {
        xr(kaVar);
    }

    @Override // com.bytedance.sdk.component.x.ms.ab
    public ny d() {
        return this.ah;
    }

    public void xr(ka kaVar) {
        this.f1572ms = kaVar;
        this.xr = kaVar.getContext();
        this.ah = new com.bytedance.sdk.component.x.xr.xr.xr(this.f1572ms);
    }

    @Override // com.bytedance.sdk.component.x.ms.ab
    public d ka() {
        ka kaVar = this.f1572ms;
        if (kaVar == null) {
            return null;
        }
        return kaVar.d();
    }

    @Override // com.bytedance.sdk.component.x.ms.ab
    public ka ah() {
        ka kaVar = this.f1572ms;
        if (kaVar == null) {
            return null;
        }
        return kaVar;
    }

    @Override // com.bytedance.sdk.component.x.ms.ab
    public void ms(c cVar) {
        ka kaVar = this.f1572ms;
        if (kaVar != null) {
            if (cVar == null) {
                cVar = com.bytedance.sdk.component.x.xr.ms.ms.ms.xr.f1567ms;
            }
            kaVar.ms(cVar);
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ab
    public void ms(boolean z) {
        ka kaVar = this.f1572ms;
        if (kaVar != null) {
            kaVar.ms(z);
        }
    }

    private boolean ms(Context context, d dVar) {
        if (context == null || dVar == null) {
            return false;
        }
        if (dVar.x() == 1) {
            return dVar.ub();
        }
        try {
            return h.ms(context);
        } catch (Throwable th) {
            sl.ms(th);
            return true;
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ab
    public void ms() {
        final d dVarD;
        ka kaVar = this.f1572ms;
        if (kaVar == null || (dVarD = kaVar.d()) == null || this.f1572ms.getContext() == null || dVarD.c() == null) {
            return;
        }
        if (this.f1572ms.hi()) {
            if (ms(this.f1572ms.getContext(), dVarD)) {
                ny nyVar = this.ah;
                if (nyVar != null) {
                    nyVar.ms();
                    return;
                }
                return;
            }
            if (ab()) {
                dVarD.c().execute(new com.bytedance.sdk.component.x.xr.ka.xr("start") { // from class: com.bytedance.sdk.component.x.xr.xr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ka unused = xr.this.f1572ms;
                        xr.this.ms(dVarD.x());
                    }
                });
                return;
            } else {
                ms(dVarD.x());
                return;
            }
        }
        ny nyVar2 = this.ah;
        if (nyVar2 != null) {
            nyVar2.ms();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        if (i == 0 || i == 2) {
            com.bytedance.sdk.component.x.xr.xr.xr.ms.ms(this.f1572ms);
        } else if (i == 1) {
            com.bytedance.sdk.component.x.xr.xr.xr.xr.xr(this.f1572ms);
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ab
    public void ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        xr(xrVar);
    }

    private boolean ab() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void xr(final com.bytedance.sdk.component.x.ms.xr xrVar) {
        ka kaVar = this.f1572ms;
        if (kaVar == null || this.ah == null) {
            sl.d("log_error", "dispatch event configManager is null");
            return;
        }
        final d dVarD = kaVar.d();
        if (xrVar == null || dVarD == null || this.f1572ms.getContext() == null || dVarD.c() == null) {
            return;
        }
        if (this.f1572ms.hi()) {
            if (ms(this.f1572ms.getContext(), dVarD)) {
                this.ah.ms(xrVar);
                return;
            }
            ab();
            if (ab()) {
                dVarD.c().execute(new com.bytedance.sdk.component.x.xr.ka.xr("dispatchEvent") { // from class: com.bytedance.sdk.component.x.xr.xr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        xr.this.ms(xrVar, dVarD.x());
                    }
                });
                return;
            } else {
                ms(xrVar, dVarD.x());
                return;
            }
        }
        this.ah.ms(xrVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.component.x.ms.xr xrVar, int i) {
        if (i == 0 || i == 2) {
            com.bytedance.sdk.component.x.xr.xr.xr.ms.ms(xrVar, this.f1572ms);
        } else if (i == 1) {
            com.bytedance.sdk.component.x.xr.xr.xr.xr.ms(xrVar, this.f1572ms);
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ab
    public void ms(final String str, final List<String> list, final boolean z, Map<String, String> map, final JSONObject jSONObject) {
        ka kaVar = this.f1572ms;
        if (kaVar == null) {
            sl.d("log_error", "track configManager is null");
            return;
        }
        final d dVarD = kaVar.d();
        if (dVarD == null || this.f1572ms.getContext() == null || dVarD.c() == null || !dVarD.ch()) {
            return;
        }
        if (dVarD.x() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if (dVarD.x() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (!this.f1572ms.hi() || ms(this.f1572ms.getContext(), dVarD)) {
            com.bytedance.sdk.component.x.xr.c.ms.ms(this.f1572ms).ms(str, list, z, map, jSONObject);
        } else if (ab()) {
            dVarD.c().execute(new com.bytedance.sdk.component.x.xr.ka.xr("trackFailed") { // from class: com.bytedance.sdk.component.x.xr.xr.3
                @Override // java.lang.Runnable
                public void run() {
                    xr.this.ms(str, (List<String>) list, z, dVarD.x(), jSONObject);
                }
            });
        } else {
            ms(str, list, z, dVarD.x(), jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, List<String> list, boolean z, int i, JSONObject jSONObject) {
        if (i == 0) {
            com.bytedance.sdk.component.x.xr.xr.xr.ms.ms(str, list, z, this.f1572ms, jSONObject);
        } else if (i == 1) {
            com.bytedance.sdk.component.x.xr.xr.xr.xr.ms(str, list, z, this.f1572ms);
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ab
    public void ms(final String str) {
        ka kaVar = this.f1572ms;
        if (kaVar == null) {
            com.bytedance.sdk.component.x.xr.ah.ah.ah("log_error", "trackFailedUrls configManager is null", kaVar);
            return;
        }
        final d dVarD = kaVar.d();
        if (dVarD == null || this.f1572ms.getContext() == null || dVarD.c() == null || !dVarD.ch()) {
            return;
        }
        if (dVarD.x() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f1572ms.hi() || ms(this.f1572ms.getContext(), dVarD)) {
            com.bytedance.sdk.component.x.xr.c.ms.ms(this.f1572ms).ms(str);
        } else if (ab()) {
            dVarD.c().execute(new com.bytedance.sdk.component.x.xr.ka.xr("trackFailed") { // from class: com.bytedance.sdk.component.x.xr.xr.4
                @Override // java.lang.Runnable
                public void run() {
                    xr.this.ms(str, dVarD.x());
                }
            });
        } else {
            ms(str, dVarD.x());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, int i) {
        if (i == 0) {
            com.bytedance.sdk.component.x.xr.xr.xr.ms.ms(str, this.f1572ms);
        } else if (i == 1) {
            com.bytedance.sdk.component.x.xr.xr.xr.xr.ms(str, this.f1572ms);
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ab
    public void xr() {
        ny nyVar = this.ah;
        if (nyVar != null) {
            nyVar.xr();
        }
    }
}
