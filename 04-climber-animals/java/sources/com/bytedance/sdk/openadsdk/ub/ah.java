package com.bytedance.sdk.openadsdk.ub;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.f.ka;
import com.bytedance.sdk.openadsdk.core.g;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public String f4216ms;
    public String xr;

    private ah() {
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static ah f4217ms = new ah();
    }

    public static ah ms() {
        return ms.f4217ms;
    }

    public String xr() {
        try {
            Map<String, Object> mapX = x();
            if (mapX == null) {
                xr(null);
                return null;
            }
            Object obj = mapX.get("motion_info");
            if (obj instanceof String) {
                if (TextUtils.equals("0", (String) obj)) {
                    xr("0");
                    return "0";
                }
                xr("1");
                return "1";
            }
            xr(null);
            return null;
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    private String ab() {
        Map<String, Object> mapX = x();
        if (mapX == null) {
            return null;
        }
        Object obj = mapX.get("od");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void ah() {
        if (ny()) {
            String strAb = ab();
            if (TextUtils.equals(strAb, this.f4216ms)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.live.xr.ms().ms("setOaidEnabled", ms(strAb));
            this.f4216ms = strAb;
        }
    }

    public boolean d() {
        return !TextUtils.equals(xr(), "0");
    }

    public boolean ka() {
        if (ny()) {
            return ms(ab());
        }
        return true;
    }

    public boolean c() {
        Map<String, Object> mapX = x();
        if (mapX != null) {
            Object obj = mapX.get("mcod");
            if (obj instanceof String) {
                String str = (String) obj;
                this.xr = str;
                return !TextUtils.equals(str, "0");
            }
        }
        return true;
    }

    private Map<String, Object> x() {
        ka kaVarAo;
        if (g.xr >= 6408 && (kaVarAo = ch.ub().ao()) != null) {
            return kaVarAo.zb();
        }
        return null;
    }

    private boolean ms(String str) {
        return !TextUtils.equals(str, "0");
    }

    private void xr(String str) {
        if (!TextUtils.equals(this.ah, str)) {
            com.bytedance.sdk.openadsdk.core.live.xr.ms().ms("setSensorEnable", !TextUtils.equals(str, "0"));
        }
        this.ah = str;
    }

    private boolean ny() {
        String strT = ch.ub().t();
        if (TextUtils.isEmpty(strT)) {
            return false;
        }
        strT.hashCode();
        switch (strT) {
            case "5001121":
            case "5002213":
            case "5437586":
            case "5634951":
                return true;
            default:
                return false;
        }
    }
}
