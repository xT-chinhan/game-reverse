package com.bytedance.sdk.openadsdk.core.sl.ms;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.interact.ub;
import com.bytedance.sdk.component.adexpress.xr.hi;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.hi.ah.ah.c;
import com.bytedance.sdk.openadsdk.core.jw.p;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.xr.ah;
import com.bytedance.sdk.openadsdk.core.xr.d;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends d implements com.bytedance.sdk.component.adexpress.dynamic.ka.ms, ah {
    private lm ah;
    private View ch;
    private WeakReference<ViewGroup> d;
    private ub hi;
    private volatile boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private hi f3308ms;
    private int sl;
    private boolean xr;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ka.ms
    public void ms(hi hiVar) {
        this.f3308ms = hiVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ka.ms
    public void ms(boolean z, ub ubVar) {
        this.ka = true;
        this.xr = z;
        this.hi = ubVar;
        WeakReference<ViewGroup> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        p.ms(this.d, this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ka.ms
    public void ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.sl = jSONObject.optInt("convertActionType", Integer.MIN_VALUE);
    }

    public ms(lm lmVar, WeakReference<ViewGroup> weakReference) {
        super(null);
        this.ka = false;
        this.sl = Integer.MIN_VALUE;
        this.ah = lmVar;
        this.d = weakReference;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ka.ms
    public void ms(View view) {
        this.ab.xr(view);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ka.ms
    public void xr(View view) {
        this.ab.ms(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.d
    public void ms(View view, com.bytedance.sdk.openadsdk.core.nw.hi hiVar) {
        this.ch = view;
        if (this.ka) {
            this.ka = false;
        } else {
            ah(view);
        }
    }

    private void ah(View view) {
        try {
            ms(view, ((Integer) view.getTag()).intValue());
        } catch (ArrayIndexOutOfBoundsException e) {
            sl.ms(e);
            e.getMessage();
        } catch (Exception e2) {
            sl.d("DynamicClickListener", e2.getMessage());
        }
    }

    private void ms(View view, int i) {
        CharSequence text;
        if (this.f3308ms != null) {
            if (this.xr && this.ah != null) {
                c.d = true;
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            View viewC = this.ab.c();
            if (viewC != null) {
                int[] iArrMs = ul.ms(viewC);
                if (iArrMs != null) {
                    iArr = iArrMs;
                }
                int[] iArrAh = ul.ah(viewC);
                if (iArrAh != null) {
                    iArr2 = iArrAh;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null && text.toString().contains("下载")) {
                    jSONObject.put("is_compliant_download", true);
                }
                jSONObject.putOpt("convertActionType", Integer.valueOf(this.sl));
            } catch (Throwable unused) {
            }
            this.f3308ms.ms(view, i, new i.ms().d(this.ab.u()).ah(this.ab.ub()).xr(this.ab.ao()).ms(this.ab.h()).xr(this.ab.sl()).ms(this.ab.zb()).ms(iArr[0]).xr(iArr[1]).ah(iArr2[0]).d(iArr2[1]).ms(d(view)).ah(String.valueOf(i)).xr(String.valueOf(view.getTag(2097610714))).ms(String.valueOf(view.getTag(2097610715))).d(String.valueOf(view.getTag(2097610713))).ms(this.ab.ka()).ms(jSONObject).ms(this.ab.ch()).ms());
        }
    }

    private JSONObject d(View view) {
        return new JSONObject();
    }

    private void xr() {
        WeakReference<ViewGroup> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null || !p.ms(this.d.get())) {
            return;
        }
        this.sl = 1;
        ah(this.ch);
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ah
    public void ms() {
        xr();
        this.ka = false;
        ub ubVar = this.hi;
        if (ubVar != null) {
            ubVar.ka();
        }
    }
}
