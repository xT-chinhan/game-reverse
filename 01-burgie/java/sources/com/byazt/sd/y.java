package com.byazt.sd;

import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC})
public class y {
    public static final y pr = new y();
    public static int x = -1;
    public static String c = "ext_plugin";
    public AtomicBoolean hw = new AtomicBoolean(false);
    public AtomicBoolean hn = new AtomicBoolean(false);

    private y() {
    }

    public static y pr() {
        return pr;
    }

    public static int hw() {
        if (x == -1) {
            x = pr().fw();
        }
        return x;
    }

    public static boolean hn() {
        if (!a.hw().v()) {
            return false;
        }
        y yVarPr = pr();
        boolean z = yVarPr.hw.get();
        if (!z && com.byazt.zp.m.zo("com.byted.csj.ext")) {
            yVarPr.hw.set(true);
            return true;
        }
        return z;
    }

    private int fw() {
        com.byazt.r.hn hnVar;
        if (hn() && (hnVar = (com.byazt.r.hn) com.byazt.zs.uc.pr("pitaya_new")) != null) {
            return hnVar.hw();
        }
        return -1;
    }

    public static void x() {
        Bundle bundle = new Bundle();
        Bundle bundlePr = pr(zo.nt().ny());
        if (bundlePr != null) {
            bundle.putBundle("com.byted.csj.ext", bundlePr);
        }
        zo.nt().pr(bundle);
    }

    private static Bundle pr(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(PluginConstants.KEY_APP_ID, str);
            String strX = com.byazt.zp.m.x("com.byted.csj.ext");
            if (TextUtils.isEmpty(strX)) {
                return null;
            }
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strX);
            bundle.putString("sdk_version", pr(1160));
            return bundle;
        } catch (Throwable th) {
            com.byazt.ca.ho.hw(c, "error:" + th.getMessage());
            return null;
        }
    }

    public static String pr(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        String string = sb.toString();
        if (i >= 100 && i < 1000) {
            return "0." + string;
        }
        return string;
    }

    public boolean c() {
        try {
            if (!a.hw().v()) {
                return false;
            }
            if (this.hw.get()) {
                return true;
            }
            if (this.hn.compareAndSet(false, true)) {
                if (com.byazt.zp.m.aj("com.byted.csj.ext")) {
                    if (com.byazt.zp.m.zo("com.byted.csj.ext")) {
                        this.hw.set(true);
                        this.hn.set(false);
                        return true;
                    }
                    com.byazt.ca.aj.pr().post(new Runnable() { // from class: com.byazt.sd.y.1
                        @Override // java.lang.Runnable
                        public void run() {
                            y.this.pr(true);
                        }
                    });
                } else {
                    this.hn.set(false);
                }
            }
            return false;
        } catch (Throwable th) {
            com.byazt.ca.ho.hw(c, "pit_ext_error:" + th.getMessage());
        }
    }

    public com.byazt.r.pr uc() {
        if (!com.byazt.ns.hw.pr(a.hw().r()) || !c()) {
            return null;
        }
        return (com.byazt.r.pr) com.byazt.zs.uc.pr("alog");
    }

    public boolean pr(boolean z) {
        try {
            if (this.hw.get()) {
                return true;
            }
            if (!z) {
                this.hn.set(true);
            }
            boolean zFw = com.byazt.zp.m.fw("com.byted.csj.ext");
            this.hw.set(zFw);
            this.hn.set(false);
            return zFw;
        } catch (Throwable th) {
            com.byazt.ca.ho.hw(c, ":" + th.getMessage());
            return false;
        }
    }
}
