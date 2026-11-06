package com.bytedance.sdk.component.xr.ms.ms.ms;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.bytedance.sdk.component.ah.xr.b;
import com.bytedance.sdk.component.ah.xr.nw;
import com.bytedance.sdk.component.ah.xr.op;
import com.bytedance.sdk.component.ah.xr.re;
import com.bytedance.sdk.component.ah.xr.yu;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import com.bytedance.sdk.component.xr.ms.ub;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends sl {
    com.bytedance.sdk.component.xr.ms.d u;
    re zb;

    public c(re.ms msVar) {
        super(msVar);
        this.zb = msVar.ms();
        this.u = new ab(this.zb);
    }

    @Override // com.bytedance.sdk.component.xr.ms.sl
    public com.bytedance.sdk.component.xr.ms.d ms() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.xr.ms.sl
    public com.bytedance.sdk.component.xr.ms.xr ms(u uVar) {
        if (uVar == null) {
            return null;
        }
        yu.ms msVar = new yu.ms();
        msVar.ms(uVar.ms());
        if (uVar.xr() != null) {
            msVar.ms(uVar.xr().ms());
        }
        if (uVar.c() != null) {
            if (ah(uVar.c())) {
                msVar.ms(uVar.ah(), op.ms(nw.ms(uVar.c().ah.toString()), uVar.c().d));
            } else if (ms(uVar.c())) {
                msVar.ms(uVar.ah(), new b.ms().ms(b.ka).ms(uVar.c().xr(), uVar.c().ms(), op.ms(nw.ms(ShareTarget.ENCODING_TYPE_MULTIPART), uVar.c().ka)).ms());
            } else if (xr(uVar.c())) {
                msVar.ms(uVar.ah(), op.ms(nw.ms(uVar.c().ah.toString()), uVar.c().ka));
            }
        }
        if (uVar.ka() != null && uVar.ka().f1600ms) {
            msVar.ms(new com.bytedance.sdk.component.ah.xr.d.ms().ms().ah());
        }
        if (uVar.d() != null && uVar.d().size() > 0) {
            for (Map.Entry<String, List<String>> entry : uVar.d().entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    msVar.ms(entry.getKey(), it.next());
                }
            }
        }
        return new d(this.zb.ms(msVar.ms()));
    }

    private boolean ms(ub ubVar) {
        return ubVar != null && ubVar.c == ub.ms.FILE_TYPE && ubVar.ka != null && ubVar.ka.length > 0;
    }

    private boolean xr(ub ubVar) {
        return ubVar != null && ubVar.c == ub.ms.BYTE_ARRAY_TYPE && ubVar.ka != null && ubVar.ka.length > 0;
    }

    private boolean ah(ub ubVar) {
        return (ubVar == null || ubVar.c != ub.ms.STRING_TYPE || TextUtils.isEmpty(ubVar.d)) ? false : true;
    }
}
