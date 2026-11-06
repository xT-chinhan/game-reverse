package com.byazt.zo;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, 113})
public class d implements Function<SparseArray<Object>, Object> {
    public com.byazt.vyf.x n;
    public w qg = new w();
    public rv s;

    public d(com.byazt.vyf.x xVar) {
        this.n = xVar;
        this.s = new rv(this.n);
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        if (iIntValue == -99999986) {
            com.byazt.vyf.x xVar = this.n;
            if (xVar != null) {
                return xVar.n();
            }
        } else if (iIntValue != -999800) {
            if (iIntValue == 8303 || iIntValue == 999801) {
                if (iIntValue == 8303) {
                    com.byazt.rb.qg.qg("TMe", "initRequestCondition getBridge");
                    return this.qg;
                }
                if (this.n != null) {
                    return this.s;
                }
            }
        } else if (this.n != null) {
            Context context = (Context) pluginValueSetQg.objectValue(-998000, Context.class);
            return new fs(context, this.n.n(context));
        }
        return null;
    }
}
