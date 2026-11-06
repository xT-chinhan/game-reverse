package com.bytedance.sdk.component.x.xr.d.ms;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.sl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.component.x.ms.xr {
    private long ab;
    private byte ah;
    private long c;
    private byte ch;
    private byte d;
    private String hi;
    private long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected JSONObject f1553ms;
    private String ny;
    private int sl;
    private String x;
    private xr xr;

    public ms(String str, JSONObject jSONObject) {
        this.ny = str;
        this.f1553ms = jSONObject;
    }

    public ms(String str, xr xrVar) {
        this.ny = str;
        this.xr = xrVar;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public xr ms() {
        return this.xr;
    }

    private ms() {
    }

    public void ah(String str) {
        this.hi = str;
    }

    public String ch() {
        return this.hi;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public synchronized JSONObject ab() {
        xr xrVar;
        if (this.f1553ms == null && (xrVar = this.xr) != null) {
            this.f1553ms = xrVar.ms(ch());
        }
        return this.f1553ms;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public void ms(JSONObject jSONObject) {
        this.f1553ms = jSONObject;
    }

    public static com.bytedance.sdk.component.x.ms.xr d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("type");
            int iOptInt2 = jSONObject.optInt("priority");
            ms msVar = new ms();
            msVar.ms((byte) iOptInt);
            msVar.xr((byte) iOptInt2);
            msVar.ms(jSONObject.optJSONObject(NotificationCompat.CATEGORY_EVENT));
            msVar.ms(jSONObject.optString("localId"));
            msVar.xr(jSONObject.optString("genTime"));
            msVar.ms(jSONObject.optInt("channel"));
            return msVar;
        } catch (JSONException e) {
            sl.ms(e);
            return null;
        }
    }

    public void ah(byte b) {
        this.ch = b;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public byte xr() {
        return this.ch;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public String ah() {
        return this.ny;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public byte d() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public void ms(byte b) {
        this.ah = b;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public void ms(String str) {
        this.ny = str;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public void xr(String str) {
        this.x = str;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public void ms(long j) {
        this.ka = j;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public long x() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public void xr(long j) {
        this.c = j;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public long ny() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public void ah(long j) {
        this.ab = j;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public void ms(int i) {
        this.sl = i;
    }

    public String hi() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public void xr(byte b) {
        this.d = b;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public byte ka() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.x.ms.xr
    public String c() {
        if (TextUtils.isEmpty(this.ny)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.ny);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, ab());
            jSONObject.put("genTime", hi());
            jSONObject.put("priority", (int) this.d);
            jSONObject.put("type", (int) this.ah);
            jSONObject.put("channel", this.sl);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
