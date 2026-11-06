package com.byazt.kbl;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.byazt.hh.c;
import com.byazt.nn.fw;
import com.byazt.nn.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX, 37})
public class pr {
    public static String pr = "layerType";
    public Context hn;
    public c hw;

    public pr(Context context, c cVar) {
        this.hn = context;
        this.hw = cVar;
    }

    private ContentResolver pr() {
        try {
            return this.hn.getContentResolver();
        } catch (Throwable th) {
            return null;
        }
    }

    public void pr(com.byazt.hh.hw hwVar, boolean z) {
        fw.pr("multi start()");
        if (hwVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverPr = pr();
            if (contentResolverPr != null) {
                contentResolverPr.getType(pr(Uri.parse(hw() + "adLogStart?is_flush=" + z), hwVar));
            }
        } catch (Throwable th) {
        }
    }

    public void pr(com.byazt.hh.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverPr = pr();
            if (contentResolverPr != null) {
                contentResolverPr.getType(pr(Uri.parse(hw() + "adLogStop"), hwVar));
            }
        } catch (Throwable th) {
        }
    }

    public static String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return Base64.encodeToString(str.getBytes(), 10);
    }

    public void pr(com.byazt.hh.pr prVar, com.byazt.hh.hw hwVar) {
        if (prVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverPr = pr();
            if (contentResolverPr != null) {
                contentResolverPr.getType(pr(Uri.parse(hw() + "adLogDispatch?event=" + pr(prVar.hw())), hwVar));
                fw.pr("dispatch event getType end ");
            }
        } catch (Throwable th) {
            fw.pr("multi dispatch", th);
        }
    }

    public void pr(String str, List<String> list, boolean z, com.byazt.hh.hw hwVar, Map<String, String> map, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(pr(it.next())).append(",");
            }
            String strPr = pr(sb.toString());
            String strPr2 = jSONObject == null ? "" : pr(jSONObject.toString());
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(strPr) + "&replace=" + String.valueOf(z) + "&extraMate=" + strPr2 + "&extraMapJson=" + pr(jSONObject2.toString());
            ContentResolver contentResolverPr = pr();
            if (contentResolverPr != null) {
                contentResolverPr.getType(pr(Uri.parse(hw() + "trackAdUrl" + str2), hwVar));
            }
        } catch (Throwable th) {
            x.pr("multi_track", null, th, hwVar);
        }
    }

    public void pr(String str, com.byazt.hh.hw hwVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverPr = pr();
            if (contentResolverPr != null) {
                contentResolverPr.getType(pr(Uri.parse(hw() + "trackAdFailed?did=" + String.valueOf(str)), hwVar));
            }
        } catch (Throwable th) {
        }
    }

    private String hw() {
        return com.byazt.ya.hn.pr(this.hn) + "/ad_log_event/";
    }

    private Uri pr(Uri uri, com.byazt.hh.hw hwVar) {
        if (uri != null && hwVar != null) {
            try {
                Uri.Builder builderBuildUpon = uri.buildUpon();
                builderBuildUpon.appendQueryParameter(pr, String.valueOf(hwVar.uc()));
                return builderBuildUpon.build();
            } catch (Throwable th) {
                return uri;
            }
        }
        return uri;
    }
}
