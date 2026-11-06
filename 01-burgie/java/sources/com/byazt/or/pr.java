package com.byazt.or;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1644, 37})
public class pr {
    public final PluginValueSet pr;

    public pr(SparseArray<Object> sparseArray) {
        this.pr = com.byazt.ij.pr.pr(sparseArray).hw();
    }

    public String pr() {
        return (String) this.pr.objectValue(264101, String.class);
    }

    public boolean hw() {
        return this.pr.booleanValue(264102);
    }

    public hn hn() {
        SparseArray sparseArray = (SparseArray) this.pr.objectValue(264103, SparseArray.class);
        if (sparseArray == null) {
            return null;
        }
        return new hn(sparseArray);
    }

    public Map<String, Object> x() {
        return (Map) this.pr.objectValue(264104, Map.class);
    }

    public boolean c() {
        return this.pr.booleanValue(264105);
    }

    public JSONObject uc() {
        return (JSONObject) this.pr.objectValue(264106, JSONObject.class);
    }

    public String fw() {
        return (String) this.pr.objectValue(264107, String.class);
    }

    public boolean zo() {
        return this.pr.booleanValue(264108);
    }

    public boolean aj() {
        return this.pr.booleanValue(264109);
    }

    public boolean vk() {
        return this.pr.booleanValue(264110);
    }

    public String w() {
        return (String) this.pr.objectValue(264111, String.class);
    }
}
