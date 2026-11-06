package com.byazt.xmw;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1493, 19})
public class n {
    public final PluginValueSet n;

    public n(SparseArray<Object> sparseArray) {
        this.n = com.byazt.qvu.n.n(sparseArray).qg();
    }

    public String n() {
        return (String) this.n.objectValue(264101, String.class);
    }

    public boolean qg() {
        return this.n.booleanValue(264102);
    }

    public s s() {
        SparseArray sparseArray = (SparseArray) this.n.objectValue(264103, SparseArray.class);
        if (sparseArray == null) {
            return null;
        }
        return new s(sparseArray);
    }

    public Map<String, Object> q() {
        return (Map) this.n.objectValue(264104, Map.class);
    }

    public boolean l() {
        return this.n.booleanValue(264105);
    }

    public JSONObject w() {
        return (JSONObject) this.n.objectValue(264106, JSONObject.class);
    }

    public String x() {
        return (String) this.n.objectValue(264107, String.class);
    }

    public boolean fs() {
        return this.n.booleanValue(264108);
    }

    public boolean rv() {
        return this.n.booleanValue(264109);
    }

    public boolean tj() {
        return this.n.booleanValue(264110);
    }

    public String cp() {
        return (String) this.n.objectValue(264111, String.class);
    }
}
