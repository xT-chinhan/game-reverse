package com.bytedance.sdk.component.hi.ms;

import android.text.TextUtils;
import com.bytedance.sdk.component.hi.d.ah;
import com.bytedance.sdk.component.hi.d.d;
import com.bytedance.sdk.component.hi.d.ka;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements d {
    private Map<String, Object> ah;
    private int c;
    private ah d;
    private com.bytedance.sdk.component.hi.ms.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1243ms;
    private JSONObject xr;

    public static class ms {
        private JSONObject ab;
        private StringBuilder ah;
        private ah c;
        private JSONObject d;
        private Map<String, Object> ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f1245ms = 1;
        private String xr;

        public ms(String str) {
            this.xr = str;
        }

        public ms ms(JSONObject jSONObject) {
            this.d = jSONObject;
            return this;
        }

        public ms ms(Map<String, Object> map) {
            this.ka = map;
            return this;
        }

        public ms ms(ah ahVar) {
            this.c = ahVar;
            return this;
        }

        public ms xr(JSONObject jSONObject) {
            this.ab = jSONObject;
            return this;
        }

        public xr ms() {
            return new xr(this);
        }
    }

    private xr(ms msVar) {
        this.c = 1;
        this.c = msVar.f1245ms;
        if (msVar.f1245ms != 2) {
            this.f1243ms = msVar.xr;
            if (msVar.ab != null) {
                com.bytedance.sdk.component.hi.ah.xr.INSTANCE.ms(msVar.ab);
            }
        } else {
            this.ka = new com.bytedance.sdk.component.hi.ms.ms(msVar.ah, msVar.d, (Map<String, Object>) msVar.ka);
            this.c = 2;
        }
        this.xr = msVar.d;
        this.ah = msVar.ka;
        this.d = msVar.c;
    }

    public void ms() {
        com.bytedance.sdk.component.hi.ah.ah ahVarMs;
        if (this.c == 2) {
            ah ahVar = this.d;
            if (ahVar != null) {
                ahVar.ms(this.ka);
            }
            this.ka.c();
            return;
        }
        if (TextUtils.isEmpty(this.f1243ms) || (ahVarMs = com.bytedance.sdk.component.hi.ah.xr.INSTANCE.ms(this.f1243ms)) == null) {
            return;
        }
        ms(ahVarMs.ms(), this.ah);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.component.hi.ah.ms msVar, Map<String, Object> map) {
        if (msVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        com.bytedance.sdk.component.hi.ms.ms msVar2 = new com.bytedance.sdk.component.hi.ms.ms(msVar, this.xr, map);
        msVar2.ms(this.f1243ms);
        msVar2.ms(this);
        ah ahVar = this.d;
        if (ahVar != null) {
            ahVar.ms(msVar2);
        }
        msVar2.c();
        for (com.bytedance.sdk.component.hi.ah.ms msVar3 : com.bytedance.sdk.component.hi.ah.xr.INSTANCE.ms(this.f1243ms).ah(msVar, msVar2.ah(), map)) {
            if (msVar3 != null) {
                ms(msVar3, map);
            }
        }
    }

    @Override // com.bytedance.sdk.component.hi.d.d
    public ka xr() {
        return new ka() { // from class: com.bytedance.sdk.component.hi.ms.xr.1
            @Override // com.bytedance.sdk.component.hi.d.ka
            public void ms(com.bytedance.sdk.component.hi.ms.ms msVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.hi.ah.ms> it = com.bytedance.sdk.component.hi.ah.xr.INSTANCE.ms(xr.this.f1243ms).ms(msVar.ab(), msVar.ah(), map).iterator();
                while (it.hasNext()) {
                    xr.this.ms(it.next(), map);
                }
            }

            @Override // com.bytedance.sdk.component.hi.d.ka
            public void xr(com.bytedance.sdk.component.hi.ms.ms msVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.hi.ah.ms> it = com.bytedance.sdk.component.hi.ah.xr.INSTANCE.ms(xr.this.f1243ms).xr(msVar.ab(), msVar.ah(), map).iterator();
                while (it.hasNext()) {
                    xr.this.ms(it.next(), map);
                }
            }
        };
    }
}
