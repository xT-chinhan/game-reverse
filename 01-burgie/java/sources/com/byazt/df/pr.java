package com.byazt.df;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.az.hn;
import com.byazt.az.x;
import com.byazt.hg.fo;
import com.byazt.hg.of;
import com.byazt.hg.vk;
import com.byazt.mq.w;
import com.byazt.wr.uc;
import com.byazt.wt.er;
import com.byazt.wt.n;
import com.byazt.yhm.ho;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2343, 37})
public class pr extends x implements com.byazt.mft.pr, hn {
    public volatile boolean c;
    public of hn;
    public boolean hw;
    public int k;
    public w pr;
    public View vk;
    public ho w;
    public WeakReference<ViewGroup> x;

    @Override // com.byazt.mft.pr
    public void pr(w wVar) {
        this.pr = wVar;
    }

    @Override // com.byazt.mft.pr
    public void pr(boolean z, ho hoVar) {
        this.c = true;
        this.hw = z;
        this.w = hoVar;
        WeakReference<ViewGroup> weakReference = this.x;
        if (weakReference != null && weakReference.get() != null) {
            n.pr(this.x, this);
        }
    }

    @Override // com.byazt.mft.pr
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.k = jSONObject.optInt("convertActionType", Integer.MIN_VALUE);
    }

    public pr(of ofVar, WeakReference<ViewGroup> weakReference) {
        super(null);
        this.c = false;
        this.k = Integer.MIN_VALUE;
        this.hn = ofVar;
        this.x = weakReference;
    }

    @Override // com.byazt.mft.pr
    public void pr(View view) {
        this.fw.hw(view);
    }

    @Override // com.byazt.mft.pr
    public void hw(View view) {
        this.fw.pr(view);
    }

    @Override // com.byazt.az.x
    public void pr(View view, vk vkVar) {
        this.vk = view;
        if (this.c) {
            this.c = false;
        } else {
            hn(view);
        }
    }

    private void hn(View view) {
        try {
            pr(view, ((Integer) view.getTag()).intValue());
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        } catch (Exception e2) {
            com.byazt.ca.ho.hw("DynamicClickListener", e2.getMessage());
        }
    }

    private void pr(View view, int i) {
        CharSequence text;
        if (this.pr != null) {
            if (this.hw && this.hn != null) {
                uc.x = true;
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            View viewVk = this.fw.vk();
            if (viewVk != null) {
                int[] iArrPr = er.pr(viewVk);
                if (iArrPr != null) {
                    iArr = iArrPr;
                }
                int[] iArrHn = er.hn(viewVk);
                if (iArrHn != null) {
                    iArr2 = iArrHn;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null && text.toString().contains("下载")) {
                    jSONObject.put("is_compliant_download", true);
                }
                jSONObject.putOpt("convertActionType", Integer.valueOf(this.k));
            } catch (Throwable th) {
            }
            this.pr.pr(view, i, new fo.pr().x(this.fw.lb()).hn(this.fw.qa()).hw(this.fw.a()).pr(this.fw.cz()).hw(this.fw.nt()).pr(this.fw.yb()).pr(iArr[0]).hw(iArr[1]).hn(iArr2[0]).x(iArr2[1]).pr(x(view)).hn(String.valueOf(i)).hw(String.valueOf(view.getTag(2097610714))).pr(String.valueOf(view.getTag(2097610715))).x(String.valueOf(view.getTag(2097610713))).pr(this.fw.aj()).pr(jSONObject).pr(this.fw.g()).pr(), -1);
        }
    }

    private JSONObject x(View view) {
        return new JSONObject();
    }

    private void hw() {
        WeakReference<ViewGroup> weakReference = this.x;
        if (weakReference != null && weakReference.get() != null && n.pr(this.x.get())) {
            this.k = 1;
            hn(this.vk);
        }
    }

    @Override // com.byazt.az.hn
    public void pr() {
        hw();
        this.c = false;
        ho hoVar = this.w;
        if (hoVar != null) {
            hoVar.c();
        }
    }
}
