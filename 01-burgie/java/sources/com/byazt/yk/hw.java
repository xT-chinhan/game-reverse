package com.byazt.yk;

import com.byazt.dea.uc;
import com.byazt.eyv.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.uc.crashsdk.export.LogType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 932, 13})
public class hw {
    public static volatile hw k;
    public final List<com.byazt.yk.pr> m = new ArrayList();
    public static String pr = "request_finish";
    public static String hw = "download_start";
    public static String hn = "download_finish";
    public static String x = "install_start";
    public static String c = "install_finish";
    public static String uc = "7z_unzip_start";
    public static String fw = "7z_unzip_finish";
    public static String zo = "load_start";
    public static String aj = "load_finish";
    public static String vk = "rm_entry_finish";
    public static String w = "e_create_ac_failed";

    @com.byazt.vzx.pr(pr = {0, 1, 932, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr {
        public static int pr = 1;
        public static int hw = 2;
        public static int hn = -1;
        public static int x = -2;
        public static int c = 12000;
        public static int uc = 12001;
        public static int fw = 12002;
        public static int zo = 12003;
        public static int aj = 12004;
        public static int vk = AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS;
        public static int w = 21000;
        public static int k = 21001;
        public static int m = 21002;
        public static int g = 22000;
        public static int ho = 22001;
        public static int nt = 22002;
        public static int yb = 22999;
        public static int lb = 30000;
        public static int qa = 31000;
        public static int a = LogType.UNEXP_KNOWN_REASON;
        public static int cz = 32001;
        public static int ny = 32002;
        public static int fo = 32003;
        public static int rc = 32004;
        public static int z = 32005;
        public static int b = 32006;
        public static int iu = 32007;
        public static int ve = 32008;
        public static int gz = 32999;
        public static int nl = 40000;
        public static int y = 41000;
        public static int ww = 42000;
        public static int n = 50000;
        public static int e = 50004;
    }

    public static hw pr() {
        if (k == null) {
            synchronized (hw.class) {
                k = new hw();
            }
        }
        return k;
    }

    private hw() {
    }

    public void pr(com.byazt.yk.pr prVar) {
        synchronized (this.m) {
            this.m.add(prVar);
        }
    }

    public void pr(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.m) {
            Iterator<com.byazt.yk.pr> it = this.m.iterator();
            while (it.hasNext()) {
                try {
                    it.next().pr(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    uc.pr(th);
                }
            }
        }
    }
}
