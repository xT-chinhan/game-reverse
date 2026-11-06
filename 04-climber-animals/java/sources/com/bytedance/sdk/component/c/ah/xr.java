package com.bytedance.sdk.component.c.ah;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.c.ch;
import com.bytedance.sdk.component.c.ub;
import com.bytedance.sdk.component.c.y;
import com.bytedance.sdk.component.c.zb;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@ATS(single = true, value = {"img_service"})
public class xr implements ub {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile c f1183ms;

    private xr() {
    }

    public static ub ms(Context context, zb zbVar) {
        xr xrVar = new xr();
        xrVar.xr(context, zbVar);
        return xrVar;
    }

    private void xr(Context context, zb zbVar) {
        if (this.f1183ms != null) {
            sl.xr("ImageLoader", "already init!");
        }
        if (zbVar == null) {
            zbVar = ka.ms(context);
        }
        this.f1183ms = new c(context, zbVar);
    }

    @Override // com.bytedance.sdk.component.c.ub
    @ATSMethod(1)
    public ch ms(String str) {
        return new ah.xr(this.f1183ms).ms(str);
    }

    @Override // com.bytedance.sdk.component.c.ub
    @ATSMethod(2)
    public void ms(double d) {
        xr(d);
        ah(d);
    }

    @Override // com.bytedance.sdk.component.c.ub
    @ATSMethod(3)
    public void xr(double d) {
        if (this.f1183ms != null) {
            ms(this.f1183ms.ms(), d);
            ms(this.f1183ms.xr(), d);
        }
    }

    @Override // com.bytedance.sdk.component.c.ub
    @ATSMethod(4)
    public void ah(double d) {
        if (this.f1183ms != null) {
            ms(this.f1183ms.ah(), d);
        }
    }

    private void ms(Collection<? extends com.bytedance.sdk.component.c.ms> collection, double d) {
        if (collection == null) {
            return;
        }
        Iterator<? extends com.bytedance.sdk.component.c.ms> it = collection.iterator();
        while (it.hasNext()) {
            it.next().ms(d);
        }
    }

    @Override // com.bytedance.sdk.component.c.ub
    @ATSMethod(5)
    public void ms() {
        ah(0.0d);
        xr(0.0d);
    }

    @Override // com.bytedance.sdk.component.c.ub
    @ATSMethod(6)
    public InputStream ms(String str, String str2) {
        if (this.f1183ms != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.bytedance.sdk.component.c.ah.ah.ah.ms(str);
            }
            Collection<y> collectionXr = this.f1183ms.xr();
            if (collectionXr != null) {
                Iterator<y> it = collectionXr.iterator();
                while (it.hasNext()) {
                    byte[] bArrMs = it.next().ms(str2);
                    if (bArrMs != null) {
                        return new ByteArrayInputStream(bArrMs);
                    }
                }
            }
            Collection<com.bytedance.sdk.component.c.ah> collectionAh = this.f1183ms.ah();
            if (collectionAh != null) {
                Iterator<com.bytedance.sdk.component.c.ah> it2 = collectionAh.iterator();
                while (it2.hasNext()) {
                    InputStream inputStreamMs = it2.next().ms(str2);
                    if (inputStreamMs != null) {
                        return inputStreamMs;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.c.ub
    @ATSMethod(7)
    public InputStream ms(String str, String str2, String str3) {
        if (this.f1183ms == null || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str2 = com.bytedance.sdk.component.c.ah.ah.ah.ms(str);
        }
        com.bytedance.sdk.component.c.ah ahVarMs = this.f1183ms.ms(str3);
        if (ahVarMs != null) {
            return ahVarMs.ms(str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.c.ub
    @ATSMethod(8)
    public boolean xr(String str, String str2, String str3) {
        if (this.f1183ms == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.bytedance.sdk.component.c.ah.ah.ah.ms(str);
        }
        com.bytedance.sdk.component.c.ah ahVarMs = this.f1183ms.ms(str3);
        if (ahVarMs != null) {
            return ahVarMs.xr(str2);
        }
        return false;
    }
}
