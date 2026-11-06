package com.byazt.xfl;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.gct.pk;
import com.byazt.gn.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2441, 8})
public class s extends w {
    @Override // com.byazt.gn.w, com.byazt.udb.q
    public int qg() {
        return 8;
    }

    public s(Context context, pk pkVar, com.byazt.gn.s sVar, ViewGroup viewGroup) {
        super(context, pkVar, sVar, viewGroup);
    }

    @Override // com.byazt.gn.w
    public JSONObject n() {
        return py();
    }

    private JSONObject py() {
        try {
            return new JSONObject(n.n(this.w, this.x).n(this.w));
        } catch (Throwable unused) {
            return null;
        }
    }
}
