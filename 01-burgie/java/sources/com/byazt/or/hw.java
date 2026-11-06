package com.byazt.or;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1644, 13})
public class hw {
    public final PluginValueSet pr;

    public hw(SparseArray<Object> sparseArray) {
        this.pr = com.byazt.ij.pr.pr(sparseArray).hw();
    }

    public List<String> pr() {
        return (List) this.pr.objectValue(262114, List.class);
    }

    public List<String> hw() {
        return (List) this.pr.objectValue(262115, List.class);
    }

    public boolean hn() {
        return this.pr.booleanValue(262116);
    }

    public boolean x() {
        return this.pr.booleanValue(262117);
    }

    public boolean c() {
        return this.pr.booleanValue(262118);
    }
}
