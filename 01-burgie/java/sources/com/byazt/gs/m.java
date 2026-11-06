package com.byazt.gs;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 108})
public class m {
    public static volatile m pr;
    public com.byazt.ae.vk hw;

    public static m pr() {
        if (pr == null) {
            synchronized (m.class) {
                if (pr == null) {
                    pr = new m();
                }
            }
        }
        return pr;
    }

    public void pr(com.byazt.ae.vk vkVar) {
        this.hw = vkVar;
    }

    private com.byazt.ae.vk hw() {
        if (this.hw == null) {
            ZeusLogger.errReport("zeussp", "getKvStore kvStore is null");
            this.hw = new com.byazt.ae.vk() { // from class: com.byazt.gs.m.1
                @Override // com.byazt.ae.vk
                public void pr(String str, String str2) {
                }

                @Override // com.byazt.ae.vk
                public int pr(String str, int i) {
                    return 0;
                }

                @Override // com.byazt.ae.vk
                public String hw(String str, String str2) {
                    return "";
                }

                @Override // com.byazt.ae.vk
                public void hw(String str, int i) {
                }

                @Override // com.byazt.ae.vk
                public void pr(String str, boolean z) {
                }

                @Override // com.byazt.ae.vk
                public void pr(String str) {
                }

                @Override // com.byazt.ae.vk
                public boolean hw(String str, boolean z) {
                    return false;
                }
            };
        }
        return this.hw;
    }

    public void pr(String str) {
        hw().pr("282a382c132a362d25".concat(String.valueOf(str)), Build.VERSION.INCREMENTAL);
    }

    public boolean hw(String str) {
        return !TextUtils.isEmpty(hw().hw("322a2627002a273025".concat(String.valueOf(str)), ""));
    }

    public boolean hn(String str) {
        return !TextUtils.equals(hw().hw("322a2627002a273025".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
    }

    public void x(String str) {
        hw().hw("322a2627002a273025".concat(String.valueOf(str)), "");
        hw().pr("322a2627002a273025".concat(String.valueOf(str)), Zeus.getHostAbi());
    }

    public int c(String str) {
        return hw().pr("2a29203416253a382a2c2a251a393630352b2a".concat(String.valueOf(str)), 0);
    }

    public void pr(String str, int i) {
        if (c(str) != i) {
            hw().hw("2a29203416253a382a2c2a251a393630352b2a".concat(String.valueOf(str)), i);
        }
    }

    public String uc(String str) {
        return hw().hw("322a26270022213c34313c270634".concat(String.valueOf(str)), "");
    }

    public void pr(String str, String str2) {
        if (!TextUtils.equals(uc(str), str2)) {
            hw().pr("322a26270022213c34313c270634".concat(String.valueOf(str)), str2);
        }
    }

    public void pr(String str, int i, int i2, int i3) {
        hw().hw("3b353c2c12222b26" + str + "_" + i, i2);
        hw().hw("3b353c2c122a3d26" + str + "_" + i, i3);
    }

    public int hw(String str, int i) {
        return hw().pr("3b353c2c12222b26" + str + "_" + i, 0);
    }

    public int hn(String str, int i) {
        int iPr = hw().pr("3b353c2c122a3d26" + str + "_" + i, Integer.MAX_VALUE);
        if (iPr == 0) {
            return Integer.MAX_VALUE;
        }
        return iPr;
    }

    public void fw(String str) {
        hw().pr("2f2b3c3d0c3f2435363a_".concat(String.valueOf(str)), true);
    }

    public void zo(String str) {
        hw().pr("2f2b3c3d0c3f2435363a_".concat(String.valueOf(str)));
    }

    public boolean aj(String str) {
        return hw().hw("2f2b3c3d0c3f2435363a_".concat(String.valueOf(str)), false);
    }

    public String vk(String str) {
        return hw().hw("3321303d0b22312025".concat(String.valueOf(str)), "");
    }

    public void hw(String str, String str2) {
        hw().pr("3321303d0b22312025".concat(String.valueOf(str)), str2);
    }

    public void pr(String str, int i, boolean z) {
        String str2 = "332b26271e27293c3e3a" + str + "-" + i;
        if (z) {
            hw().pr(str2, true);
        } else {
            hw().pr(str2);
        }
    }

    public boolean x(String str, int i) {
        return hw().hw(String.format(Locale.getDefault(), "332b26271e27293c3e3a%s-%d", str, Integer.valueOf(i)), false);
    }

    public boolean c(String str, int i) {
        return hw().pr(String.format(Locale.getDefault(), "3523333f16252026332b21360d25243525%s", str), -1) == i;
    }

    public void hw(String str, int i, boolean z) {
        hw().pr("1e000d2c301b1126091114073a34" + str + "_" + i, z);
    }

    public boolean uc(String str, int i) {
        return hw().hw("1e000d2c301b1126091114073a34" + str + "_" + i, false);
    }

    public boolean fw(String str, int i) {
        return hw().hw("1e000d2c2d0e08160c002a002b0a111c25" + str + "_" + i, false);
    }

    public void hn(String str, int i, boolean z) {
        hw().pr("1e000d2c2d0e08160c002a002b0a111c25" + str + "_" + i, z);
    }

    public void pr(String str, int i, int i2) {
        hw().hw("0800181c290e3a1c1411070a000d09181d3a" + str + "_" + i, i2);
    }

    public int zo(String str, int i) {
        return hw().pr("0800181c290e3a1c1411070a000d09181d3a" + str + "_" + i, 0);
    }

    public void pr(String str, int i, String str2) {
        hw().hw(str2 + "2503141a330e0126190a001d2b3412111f0b2a01323400170e170c2c" + str + "_" + i, hw(str, i, str2) + 1);
    }

    public int hw(String str, int i, String str2) {
        return hw().pr(str2 + "2503141a330e0126190a001d2b3412111f0b2a01323400170e170c2c" + str + "_" + i, 0);
    }

    public void hn(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            hw().pr("3b293c320c34".concat(String.valueOf(uc.pr(str))), str2);
        }
    }

    public String w(String str) {
        if (!TextUtils.isEmpty(str)) {
            return hw().hw("3b293c320c34".concat(String.valueOf(uc.pr(str))), "");
        }
        return null;
    }

    public void k(String str) {
        if (!TextUtils.isEmpty(str)) {
            hw().pr("3b293c320c34".concat(String.valueOf(uc.pr(str))));
        }
    }

    public void x(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String strPr = uc.pr(str);
            String strHw = hw().hw("3b293c320c34293829312a2716262026".concat(String.valueOf(strPr)), "");
            if (TextUtils.isEmpty(strHw)) {
                hw().pr("3b293c320c34293829312a2716262026".concat(String.valueOf(strPr)), str2);
            } else {
                hw().pr("3b293c320c34293829312a2716262026".concat(String.valueOf(strPr)), strHw + "_" + str2);
            }
        }
    }

    public List<String> m(String str) {
        if (!TextUtils.isEmpty(str)) {
            String strHw = hw().hw("3b293c320c34293829312a2716262026".concat(String.valueOf(uc.pr(str))), "");
            if (!TextUtils.isEmpty(strHw)) {
                return Arrays.asList(strHw.split("_"));
            }
            return null;
        }
        return null;
    }

    public void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            hw().pr("3b293c320c34293829312a2716262026".concat(String.valueOf(uc.pr(str))));
        }
    }
}
