package com.byazt.kp;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.byazt.hls.q;
import com.byazt.hls.x;
import com.byazt.vr.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_PRIMARIES, 19})
public class n {
    public static String n = "layerType";
    public l qg;
    public Context s;

    public n(Context context, l lVar) {
        this.s = context;
        this.qg = lVar;
    }

    private ContentResolver n() {
        try {
            return this.s.getContentResolver();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void n(com.byazt.vr.qg qgVar, boolean z) {
        x.n("multi start()");
        if (qgVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverN = n();
            if (contentResolverN != null) {
                contentResolverN.getType(n(Uri.parse(qg() + "adLogStart?is_flush=" + z), qgVar));
            }
        } catch (Throwable unused) {
        }
    }

    public void n(com.byazt.vr.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverN = n();
            if (contentResolverN != null) {
                contentResolverN.getType(n(Uri.parse(qg() + "adLogStop"), qgVar));
            }
        } catch (Throwable unused) {
        }
    }

    public static String n(String str) {
        return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(str.getBytes(), 10);
    }

    public void n(com.byazt.vr.n nVar, com.byazt.vr.qg qgVar) {
        if (nVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverN = n();
            if (contentResolverN != null) {
                contentResolverN.getType(n(Uri.parse(qg() + "adLogDispatch?event=" + n(nVar.qg())), qgVar));
                x.n("dispatch event getType end ");
            }
        } catch (Throwable th) {
            x.n("multi dispatch", th);
        }
    }

    public void n(String str, List<String> list, boolean z, com.byazt.vr.qg qgVar, Map<String, String> map, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(n(it.next())).append(",");
            }
            String strN = n(sb.toString());
            String strN2 = jSONObject == null ? "" : n(jSONObject.toString());
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(strN) + "&replace=" + String.valueOf(z) + "&extraMate=" + strN2 + "&extraMapJson=" + n(jSONObject2.toString());
            ContentResolver contentResolverN = n();
            if (contentResolverN != null) {
                contentResolverN.getType(n(Uri.parse(qg() + "trackAdUrl" + str2), qgVar));
            }
        } catch (Throwable th) {
            q.n("multi_track", null, th, qgVar);
        }
    }

    public void n(String str, com.byazt.vr.qg qgVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverN = n();
            if (contentResolverN != null) {
                contentResolverN.getType(n(Uri.parse(qg() + "trackAdFailed?did=" + String.valueOf(str)), qgVar));
            }
        } catch (Throwable unused) {
        }
    }

    private String qg() {
        return com.byazt.er.s.n(this.s) + "/ad_log_event/";
    }

    private Uri n(Uri uri, com.byazt.vr.qg qgVar) {
        if (uri == null || qgVar == null) {
            return uri;
        }
        try {
            Uri.Builder builderBuildUpon = uri.buildUpon();
            builderBuildUpon.appendQueryParameter(n, String.valueOf(qgVar.w()));
            return builderBuildUpon.build();
        } catch (Throwable unused) {
            return uri;
        }
    }
}
