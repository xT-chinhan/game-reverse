package com.efs.sdk.base.core.util.a;

import android.support.annotation.Nullable;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.efs.sdk.base.core.util.concurrent.c<HttpResponse> {
    String a;
    Map<String, String> b;
    public byte[] c;
    public File d;
    public String e;
    public Map<String, String> f;
    public boolean g = false;

    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    @Override // com.efs.sdk.base.core.util.concurrent.c
    @Nullable
    public final /* synthetic */ HttpResponse a() {
        switch (this.e) {
            case "get":
                return HttpEnv.getInstance().getHttpUtil().get(this.a, this.b);
            case "post":
                if (this.c != null && this.c.length > 0) {
                    if (this.g) {
                        return HttpEnv.getInstance().getHttpUtil().postAsFile(this.a, this.b, this.c);
                    }
                    return HttpEnv.getInstance().getHttpUtil().post(this.a, this.b, this.c);
                }
                return HttpEnv.getInstance().getHttpUtil().post(this.a, this.b, this.d);
            default:
                Log.e("efs.util.http", "request not support method '" + this.e + "'");
                return null;
        }
    }
}
