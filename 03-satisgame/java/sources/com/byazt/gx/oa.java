package com.byazt.gx;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public static volatile oa n;
    public com.byazt.ry.tj qg;

    public static oa n() {
        if (n == null) {
            synchronized (oa.class) {
                if (n == null) {
                    n = new oa();
                }
            }
        }
        return n;
    }

    public void n(com.byazt.ry.tj tjVar) {
        this.qg = tjVar;
    }

    private com.byazt.ry.tj qg() {
        if (this.qg == null) {
            ZeusLogger.errReport("zeussp", "getKvStore kvStore is null");
            this.qg = new com.byazt.ry.tj() { // from class: com.byazt.gx.oa.1
                @Override // com.byazt.ry.tj
                public int n(String str, int i) {
                    return 0;
                }

                @Override // com.byazt.ry.tj
                public void n(String str) {
                }

                @Override // com.byazt.ry.tj
                public void n(String str, String str2) {
                }

                @Override // com.byazt.ry.tj
                public void n(String str, boolean z) {
                }

                @Override // com.byazt.ry.tj
                public String qg(String str, String str2) {
                    return "";
                }

                @Override // com.byazt.ry.tj
                public void qg(String str, int i) {
                }

                @Override // com.byazt.ry.tj
                public boolean qg(String str, boolean z) {
                    return false;
                }
            };
        }
        return this.qg;
    }

    public void n(String str) {
        qg().n("282a382c132a362d25".concat(String.valueOf(str)), Build.VERSION.INCREMENTAL);
    }

    public boolean qg(String str) {
        return !TextUtils.isEmpty(qg().qg("322a2627002a273025".concat(String.valueOf(str)), ""));
    }

    public boolean s(String str) {
        return !TextUtils.equals(qg().qg("322a2627002a273025".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
    }

    public void q(String str) {
        qg().qg("322a2627002a273025".concat(String.valueOf(str)), "");
        qg().n("322a2627002a273025".concat(String.valueOf(str)), Zeus.getHostAbi());
    }

    public int l(String str) {
        return qg().n("2a29203416253a382a2c2a251a393630352b2a".concat(String.valueOf(str)), 0);
    }

    public void n(String str, int i) {
        if (l(str) != i) {
            qg().qg("2a29203416253a382a2c2a251a393630352b2a".concat(String.valueOf(str)), i);
        }
    }

    public String w(String str) {
        return qg().qg("322a26270022213c34313c270634".concat(String.valueOf(str)), "");
    }

    public void n(String str, String str2) {
        if (TextUtils.equals(w(str), str2)) {
            return;
        }
        qg().n("322a26270022213c34313c270634".concat(String.valueOf(str)), str2);
    }

    public void n(String str, int i, int i2, int i3) {
        qg().qg("3b353c2c12222b26" + str + "_" + i, i2);
        qg().qg("3b353c2c122a3d26" + str + "_" + i, i3);
    }

    public int qg(String str, int i) {
        return qg().n("3b353c2c12222b26" + str + "_" + i, 0);
    }

    public int s(String str, int i) {
        int iN = qg().n("3b353c2c122a3d26" + str + "_" + i, Integer.MAX_VALUE);
        if (iN == 0) {
            return Integer.MAX_VALUE;
        }
        return iN;
    }

    public void x(String str) {
        qg().n("2f2b3c3d0c3f2435363a_".concat(String.valueOf(str)), true);
    }

    public void fs(String str) {
        qg().n("2f2b3c3d0c3f2435363a_".concat(String.valueOf(str)));
    }

    public boolean rv(String str) {
        return qg().qg("2f2b3c3d0c3f2435363a_".concat(String.valueOf(str)), false);
    }

    public String tj(String str) {
        return qg().qg("3321303d0b22312025".concat(String.valueOf(str)), "");
    }

    public void qg(String str, String str2) {
        qg().n("3321303d0b22312025".concat(String.valueOf(str)), str2);
    }

    public void n(String str, int i, boolean z) {
        String str2 = "332b26271e27293c3e3a" + str + "-" + i;
        if (z) {
            qg().n(str2, true);
        } else {
            qg().n(str2);
        }
    }

    public boolean q(String str, int i) {
        return qg().qg(String.format(Locale.getDefault(), "332b26271e27293c3e3a%s-%d", str, Integer.valueOf(i)), false);
    }

    public boolean l(String str, int i) {
        return qg().n(String.format(Locale.getDefault(), "3523333f16252026332b21360d25243525%s", str), -1) == i;
    }

    public void qg(String str, int i, boolean z) {
        qg().n("1e000d2c301b1126091114073a34" + str + "_" + i, z);
    }

    public boolean w(String str, int i) {
        return qg().qg("1e000d2c301b1126091114073a34" + str + "_" + i, false);
    }

    public boolean x(String str, int i) {
        return qg().qg("1e000d2c2d0e08160c002a002b0a111c25" + str + "_" + i, false);
    }

    public void s(String str, int i, boolean z) {
        qg().n("1e000d2c2d0e08160c002a002b0a111c25" + str + "_" + i, z);
    }

    public void n(String str, int i, int i2) {
        qg().qg("0800181c290e3a1c1411070a000d09181d3a" + str + "_" + i, i2);
    }

    public int fs(String str, int i) {
        return qg().n("0800181c290e3a1c1411070a000d09181d3a" + str + "_" + i, 0);
    }

    public void n(String str, int i, String str2) {
        qg().qg(str2 + "2503141a330e0126190a001d2b3412111f0b2a01323400170e170c2c" + str + "_" + i, qg(str, i, str2) + 1);
    }

    public int qg(String str, int i, String str2) {
        return qg().n(str2 + "2503141a330e0126190a001d2b3412111f0b2a01323400170e170c2c" + str + "_" + i, 0);
    }

    public void s(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qg().n("3b293c320c34".concat(String.valueOf(w.n(str))), str2);
    }

    public String cp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return qg().qg("3b293c320c34".concat(String.valueOf(w.n(str))), "");
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qg().n("3b293c320c34".concat(String.valueOf(w.n(str))));
    }

    public void q(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strN = w.n(str);
        String strQg = qg().qg("3b293c320c34293829312a2716262026".concat(String.valueOf(strN)), "");
        if (TextUtils.isEmpty(strQg)) {
            qg().n("3b293c320c34293829312a2716262026".concat(String.valueOf(strN)), str2);
        } else {
            qg().n("3b293c320c34293829312a2716262026".concat(String.valueOf(strN)), strQg + "_" + str2);
        }
    }

    public List<String> oa(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strQg = qg().qg("3b293c320c34293829312a2716262026".concat(String.valueOf(w.n(str))), "");
        if (TextUtils.isEmpty(strQg)) {
            return null;
        }
        return Arrays.asList(strQg.split("_"));
    }

    public void sz(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qg().n("3b293c320c34293829312a2716262026".concat(String.valueOf(w.n(str))));
    }
}
