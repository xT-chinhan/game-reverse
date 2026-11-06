package com.byazt.ce;

import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static com.byazt.hfm.pr pr;

    public static void pr() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(c.fw(), "temp_pkg_info.json");
                Long lValueOf = Long.valueOf(file.length());
                if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                    byte[] bArr = new byte[lValueOf.intValue()];
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        com.byazt.hfm.pr prVarPr = com.byazt.hfm.pr.pr(new JSONObject(new String(bArr, "utf-8")));
                        if (prVarPr != null) {
                            pr = prVarPr;
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            ho.pr("Version", "version init error", th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                }
                            }
                            throw th3;
                        }
                    }
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            } catch (IOException e2) {
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
        }
    }

    public static synchronized com.byazt.hfm.pr hw() {
        return pr;
    }

    public static synchronized void pr(com.byazt.hfm.pr prVar) {
        if (prVar != null) {
            if (prVar.uc()) {
                pr = prVar;
            }
        }
    }

    public static void hn() {
        c.pr(c.fw(), hw(), "temp_pkg_info.json");
    }

    public static boolean pr(String str) {
        return c.pr(hw(), str);
    }

    public static boolean hw(com.byazt.hfm.pr prVar) {
        return c.hn(hw(), prVar);
    }

    public static void x() {
        c.hw(c.fw(), hw(), "temp_pkg_info.json");
        pr = null;
    }
}
