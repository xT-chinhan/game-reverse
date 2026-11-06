package com.kwad.sdk.collector.a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.aa;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {
    private C0480a avj;

    public a(List<String> list) {
        C0480a c0480a = new C0480a(list);
        this.avj = c0480a;
        putBody("targetAppInfo", c0480a.toJson());
        putBody("sdkVersion", BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.AT();
    }

    /* JADX INFO: renamed from: com.kwad.sdk.collector.a.a$a, reason: collision with other inner class name */
    static class C0480a {
        private List<String> avk;

        public C0480a(List<String> list) {
            this.avk = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "packageName", this.avk);
            return jSONObject;
        }
    }
}
