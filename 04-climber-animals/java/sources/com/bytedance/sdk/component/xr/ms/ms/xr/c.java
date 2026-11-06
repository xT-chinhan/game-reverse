package com.bytedance.sdk.component.xr.ms.ms.xr;

import android.text.TextUtils;
import com.bytedance.sdk.component.ah.xr.le;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.h;
import com.bytedance.sdk.component.xr.ms.hi;
import com.bytedance.sdk.component.xr.ms.u;
import com.bytedance.sdk.component.xr.ms.zb;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ao {
    public long ah;
    public long d;
    le ka = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    HttpURLConnection f1610ms;
    u xr;

    public String toString() {
        return "";
    }

    public c(HttpURLConnection httpURLConnection, u uVar) {
        this.f1610ms = httpURLConnection;
        this.xr = uVar;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public long ms() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public long xr() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public int ah() {
        try {
            return this.f1610ms.getResponseCode();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public boolean d() {
        return ah() >= 200 && ah() < 300;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public String ka() throws IOException {
        return this.f1610ms.getResponseMessage();
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public h c() {
        try {
            return new ab(this.f1610ms);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public com.bytedance.sdk.component.xr.ms.c ab() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.f1610ms.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!"Content-Range".equalsIgnoreCase(entry.getKey()) || ah() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.xr.ms.c((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public String ms(String str) {
        return this.f1610ms.getHeaderField(str);
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public String ms(String str, String str2) {
        return !TextUtils.isEmpty(ms(str)) ? ms(str) : str2;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            c().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public zb x() {
        return zb.HTTP_1_1;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public hi ny() {
        return new hi(this.ka);
    }
}
