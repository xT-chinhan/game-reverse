package com.byazt.zq;

import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.f.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 26})
public class qg {
    public final PluginValueSet n;
    public String qg;

    public qg(SparseArray<Object> sparseArray, String str) {
        this.n = com.byazt.qvu.n.n(sparseArray).qg();
        this.qg = str;
    }

    public String n() {
        return (String) this.n.objectValue(260001, String.class);
    }

    public String qg() {
        return (String) this.n.objectValue(260002, String.class);
    }

    public String s() {
        return (String) this.n.objectValue(260003, String.class);
    }

    public String q() {
        return (String) this.n.objectValue(260004, String.class);
    }

    public boolean l() {
        return this.n.booleanValue(260005);
    }

    public int w() {
        return this.n.intValue(260006);
    }

    public int x() {
        return this.n.intValue(260007);
    }

    public float fs() {
        return this.n.floatValue(260008);
    }

    public Map v() {
        return (Map) this.n.objectValue(8260032, Map.class);
    }

    public float rv() {
        return this.n.floatValue(260009);
    }

    public boolean tj() {
        return this.n.booleanValue(260010);
    }

    public boolean cp() {
        return this.n.booleanValue(260011);
    }

    public int d() {
        return this.n.intValue(2600012);
    }

    public String oa() {
        return (String) this.n.objectValue(260013, String.class);
    }

    public String sz() {
        return (String) this.n.objectValue(260014, String.class);
    }

    public int k() {
        return this.n.intValue(260015);
    }

    public int cy() {
        return this.n.intValue(260016);
    }

    public int[] hd() {
        return (int[]) this.n.objectValue(260017, int[].class);
    }

    public int cd() {
        return this.n.intValue(260018);
    }

    public String um() {
        return (String) this.n.objectValue(260019, String.class);
    }

    public int a() {
        return this.n.intValue(260020);
    }

    public String py() {
        return (String) this.n.objectValue(260021, String.class);
    }

    public String ou() {
        return (String) this.n.objectValue(260022, String.class);
    }

    public boolean j() {
        String strOu = ou();
        if (TextUtils.isEmpty(strOu)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(strOu);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && "is_dsp".equals(jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME))) {
                    return jSONObjectOptJSONObject.optBoolean(e.a.d, false);
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public Object wm() {
        return this.n.objectValue(260023, Object.class);
    }

    public String m() {
        return (String) this.n.objectValue(260024, String.class);
    }

    public int hu() {
        return this.n.intValue(260025);
    }

    public boolean h() {
        return this.n.booleanValue(260026);
    }

    public String an() {
        return this.qg;
    }

    public void n(String str) {
        this.qg = str;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 48})
    public static class n {
        public final com.byazt.qvu.n n;
        public String qg;

        public n(String str) {
            this.n = com.byazt.qvu.n.n();
            this.qg = str;
        }

        public n(qg qgVar) {
            this.n = com.byazt.qvu.n.n(qgVar.n);
            this.qg = qgVar.qg;
        }

        public n n(String str) {
            this.n.n(260001, str);
            return this;
        }

        public n qg(String str) {
            this.n.n(260002, str);
            return this;
        }

        public n s(String str) {
            this.n.n(260003, str);
            return this;
        }

        public n q(String str) {
            this.n.n(260004, str);
            return this;
        }

        public n n(boolean z) {
            this.n.n(260005, z);
            return this;
        }

        public n n(int i) {
            this.n.n(260006, i);
            return this;
        }

        public n qg(int i) {
            this.n.n(260007, i);
            return this;
        }

        public n n(float f) {
            this.n.n(260008, f);
            return this;
        }

        public n n(Map<String, Object> map) {
            this.n.n(8260032, map);
            return this;
        }

        public n qg(float f) {
            this.n.n(260009, f);
            return this;
        }

        public n qg(boolean z) {
            this.n.n(260010, z);
            return this;
        }

        public n s(boolean z) {
            this.n.n(260011, z);
            return this;
        }

        public n s(int i) {
            this.n.n(2600012, i);
            return this;
        }

        public n l(String str) {
            this.n.n(260013, str);
            return this;
        }

        public n w(String str) {
            this.n.n(260014, str);
            return this;
        }

        public n q(int i) {
            this.n.n(260015, i);
            return this;
        }

        public n l(int i) {
            this.n.n(260016, i);
            return this;
        }

        public n n(int[] iArr) {
            this.n.n(260017, iArr);
            return this;
        }

        public n w(int i) {
            this.n.n(260018, i);
            return this;
        }

        public n x(String str) {
            this.n.n(260019, str);
            return this;
        }

        public n x(int i) {
            this.n.n(260020, i);
            return this;
        }

        public n fs(String str) {
            this.n.n(260021, str);
            return this;
        }

        public n rv(String str) {
            this.n.n(260022, str);
            return this;
        }

        public n n(Object obj) {
            this.n.n(260023, obj);
            return this;
        }

        public n tj(String str) {
            this.n.n(260024, str);
            return this;
        }

        public n fs(int i) {
            this.n.n(260025, i);
            return this;
        }

        public n q(boolean z) {
            this.n.n(260026, z);
            return this;
        }

        public qg n() {
            return new qg(this.n.qg().sparseArray(), this.qg);
        }
    }
}
