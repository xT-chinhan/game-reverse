package com.smartdigimkt.g4;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends d {
    public final String c;
    public final JSONObject d;

    public h(int i, com.smartdigimkt.e3.a aVar, String str) {
        String str2;
        String str3 = "";
        try {
            switch (i) {
                case 1:
                    str2 = aVar.T;
                    str3 = str2;
                    break;
                case 2:
                    str2 = aVar.U;
                    str3 = str2;
                    break;
                case 3:
                    str2 = aVar.V;
                    str3 = str2;
                    break;
                case 4:
                    str2 = aVar.W;
                    str3 = str2;
                    break;
                case 5:
                    str2 = aVar.X;
                    str3 = str2;
                    break;
                case 6:
                    str2 = aVar.Y;
                    str3 = str2;
                    break;
                case 7:
                    str2 = aVar.Z;
                    str3 = str2;
                    break;
                case 8:
                    str2 = aVar.a0;
                    str3 = str2;
                    break;
                case 9:
                    str2 = aVar.b0;
                    str3 = str2;
                    break;
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            Uri uri = Uri.parse(aVar.b(str3));
            this.c = uri.getScheme() + "://" + uri.getAuthority() + uri.getPath();
            this.d = new JSONObject();
            for (String str4 : uri.getQueryParameterNames()) {
                this.d.put(str4, URLEncoder.encode(uri.getQueryParameter(str4)));
            }
            this.d.put("req_id", str);
        } catch (Throwable unused) {
        }
    }

    @Override // com.smartdigimkt.g4.d
    public final byte[] h() {
        JSONObject jSONObject = this.d;
        if (jSONObject == null) {
            return new byte[0];
        }
        try {
            jSONObject.put("t", String.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
        return d.a(this.d.toString());
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        return 1;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        return this.c;
    }
}
