package com.bytedance.sdk.openadsdk.core.ugeno.express;

import com.bytedance.adsdk.ugeno.ah.qv;
import com.bytedance.sdk.component.adexpress.xr.zb;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends zb {
    private float ah;
    private float d;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private JSONObject f3512ms;
    private qv xr;

    public xr(ms msVar) {
        super(msVar);
        this.f3512ms = msVar.f3513ms;
        this.xr = msVar.xr;
        this.ah = msVar.ah;
        this.d = msVar.d;
        this.ka = msVar.ka;
    }

    public float g() {
        return this.ah;
    }

    public float of() {
        return this.d;
    }

    public JSONObject p() {
        return this.f3512ms;
    }

    public qv pc() {
        return this.xr;
    }

    public boolean jw() {
        return this.ka;
    }

    public static class ms extends zb.ms {
        private float ah;
        private float d;
        private boolean ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private JSONObject f3513ms;
        private qv xr;

        public ms ka(JSONObject jSONObject) {
            this.f3513ms = jSONObject;
            return this;
        }

        public ms ms(qv qvVar) {
            this.xr = qvVar;
            return this;
        }

        public ms ms(float f) {
            this.ah = f;
            return this;
        }

        public ms xr(float f) {
            this.d = f;
            return this;
        }

        public ms d(boolean z) {
            this.ka = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.xr.zb.ms
        /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
        public xr ms() {
            return new xr(this);
        }
    }
}
