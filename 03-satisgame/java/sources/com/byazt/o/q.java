package com.byazt.o;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, 5})
public class q {
    public static n n(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        com.byazt.f.n nVarN = com.byazt.f.n.n(downloadInfo);
        if (str.equals("v1")) {
            return new tj(context, nVarN, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new cp(context, nVarN, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new d(context, nVarN, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new x(context, nVarN, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new fs(context, nVarN, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new rv(context, nVarN, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals("custom")) {
            return new s(context, nVarN, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new oa(context, nVarN, com.byazt.e.s.n(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.byazt.e.q.cp().l(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean n(Context context, String str, JSONObject jSONObject, com.byazt.f.n nVar) {
        n oaVar;
        if (context != null && str != null) {
            String strQg = com.byazt.e.s.qg();
            if (!TextUtils.isEmpty(strQg) && !TextUtils.isEmpty(str)) {
                if (com.byazt.bk.l.q() && str.equals("v1")) {
                    oaVar = new tj(context, nVar, strQg);
                } else if (com.byazt.bk.l.q() && str.equals("v2")) {
                    oaVar = new cp(context, nVar, strQg);
                } else if (com.byazt.bk.l.q() && str.equals("v3")) {
                    oaVar = new d(context, nVar, strQg);
                } else if (com.byazt.bk.l.l() && str.equals("o1")) {
                    oaVar = new x(context, nVar, strQg);
                } else if (com.byazt.bk.l.l() && str.equals("o2")) {
                    oaVar = new fs(context, nVar, strQg);
                } else if (com.byazt.bk.l.l() && str.equals("o3")) {
                    oaVar = new rv(context, nVar, strQg, strQg, strQg);
                } else if (com.byazt.bk.l.q() && str.equals("custom")) {
                    oaVar = new s(context, nVar, strQg, jSONObject);
                } else {
                    oaVar = (com.byazt.bk.l.q() && str.equals("vbi")) ? new oa(context, nVar, strQg) : null;
                }
                if (oaVar != null && oaVar.n()) {
                    return true;
                }
            }
        }
        return false;
    }
}
