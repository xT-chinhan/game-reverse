package com.byazt.qe;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1180, 13})
public class hw {
    public String hw;
    public final PluginValueSet pr;

    public hw(SparseArray<Object> sparseArray, String str) {
        this.pr = com.byazt.ij.pr.pr(sparseArray).hw();
        this.hw = str;
    }

    public String pr() {
        return (String) this.pr.objectValue(260001, String.class);
    }

    public String hw() {
        return (String) this.pr.objectValue(260002, String.class);
    }

    public String hn() {
        return (String) this.pr.objectValue(260003, String.class);
    }

    public String x() {
        return (String) this.pr.objectValue(260004, String.class);
    }

    public boolean c() {
        return this.pr.booleanValue(260005);
    }

    public int uc() {
        return this.pr.intValue(260006);
    }

    public int fw() {
        return this.pr.intValue(260007);
    }

    public float zo() {
        return this.pr.floatValue(260008);
    }

    public Map iu() {
        return (Map) this.pr.objectValue(8260032, Map.class);
    }

    public float aj() {
        return this.pr.floatValue(260009);
    }

    public boolean vk() {
        return this.pr.booleanValue(260010);
    }

    public boolean w() {
        return this.pr.booleanValue(260011);
    }

    public int k() {
        return this.pr.intValue(2600012);
    }

    public String m() {
        return (String) this.pr.objectValue(260013, String.class);
    }

    public String g() {
        return (String) this.pr.objectValue(260014, String.class);
    }

    public int ho() {
        return this.pr.intValue(260015);
    }

    public int nt() {
        return this.pr.intValue(260016);
    }

    public int[] yb() {
        return (int[]) this.pr.objectValue(260017, int[].class);
    }

    public int lb() {
        return this.pr.intValue(260018);
    }

    public String qa() {
        return (String) this.pr.objectValue(260019, String.class);
    }

    public int a() {
        return this.pr.intValue(260020);
    }

    public String cz() {
        return (String) this.pr.objectValue(260021, String.class);
    }

    public String ny() {
        return (String) this.pr.objectValue(260022, String.class);
    }

    public boolean ve() {
        String strNy = ny();
        if (TextUtils.isEmpty(strNy)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(strNy);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && "is_dsp".equals(jSONObjectOptJSONObject.optString(Common.System.NAME))) {
                    return jSONObjectOptJSONObject.optBoolean(Constants.VALUE_FIELD, false);
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public Object fo() {
        return this.pr.objectValue(260023, Object.class);
    }

    public String rc() {
        return (String) this.pr.objectValue(260024, String.class);
    }

    public int z() {
        return this.pr.intValue(260025);
    }

    public boolean b() {
        return this.pr.booleanValue(260026);
    }

    public String gz() {
        return this.hw;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1180, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr {
        public String hw;
        public final com.byazt.ij.pr pr;

        public pr(String str) {
            this.pr = com.byazt.ij.pr.pr();
            this.hw = str;
        }

        public pr(hw hwVar) {
            this.pr = com.byazt.ij.pr.pr(hwVar.pr);
            this.hw = hwVar.hw;
        }

        public pr pr(String str) {
            this.pr.pr(260001, str);
            return this;
        }

        public pr hw(String str) {
            this.pr.pr(260002, str);
            return this;
        }

        public pr hn(String str) {
            this.pr.pr(260003, str);
            return this;
        }

        public pr x(String str) {
            this.pr.pr(260004, str);
            return this;
        }

        public pr pr(boolean z) {
            this.pr.pr(260005, z);
            return this;
        }

        public pr pr(int i) {
            this.pr.pr(260006, i);
            return this;
        }

        public pr hw(int i) {
            this.pr.pr(260007, i);
            return this;
        }

        public pr pr(float f) {
            this.pr.pr(260008, f);
            return this;
        }

        public pr pr(Map<String, Object> map) {
            this.pr.pr(8260032, map);
            return this;
        }

        public pr hw(float f) {
            this.pr.pr(260009, f);
            return this;
        }

        public pr hw(boolean z) {
            this.pr.pr(260010, z);
            return this;
        }

        public pr hn(boolean z) {
            this.pr.pr(260011, z);
            return this;
        }

        public pr hn(int i) {
            this.pr.pr(2600012, i);
            return this;
        }

        public pr c(String str) {
            this.pr.pr(260013, str);
            return this;
        }

        public pr uc(String str) {
            this.pr.pr(260014, str);
            return this;
        }

        public pr x(int i) {
            this.pr.pr(260015, i);
            return this;
        }

        public pr c(int i) {
            this.pr.pr(260016, i);
            return this;
        }

        public pr pr(int[] iArr) {
            this.pr.pr(260017, iArr);
            return this;
        }

        public pr uc(int i) {
            this.pr.pr(260018, i);
            return this;
        }

        public pr fw(String str) {
            this.pr.pr(260019, str);
            return this;
        }

        public pr fw(int i) {
            this.pr.pr(260020, i);
            return this;
        }

        public pr zo(String str) {
            this.pr.pr(260021, str);
            return this;
        }

        public pr aj(String str) {
            this.pr.pr(260022, str);
            return this;
        }

        public pr pr(Object obj) {
            this.pr.pr(260023, obj);
            return this;
        }

        public pr vk(String str) {
            this.pr.pr(260024, str);
            return this;
        }

        public pr zo(int i) {
            this.pr.pr(260025, i);
            return this;
        }

        public pr x(boolean z) {
            this.pr.pr(260026, z);
            return this;
        }

        public hw pr() {
            return new hw(this.pr.hw().sparseArray(), this.hw);
        }
    }
}
