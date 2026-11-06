package com.byazt.ee;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo {
    public k pr;

    public static zo pr(k kVar) {
        return new zo(kVar);
    }

    private zo(k kVar) {
        this.pr = kVar;
    }

    public <T> T pr(String str, Type type) throws JSONException {
        pr(str);
        if (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) new JSONObject(str);
        }
        return (T) this.pr.pr(str, type);
    }

    public <T> String pr(T t) {
        String string;
        if (t == null) {
            return "{}";
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            string = t.toString();
        } else {
            string = this.pr.pr(t);
        }
        pr(string);
        return string;
    }

    private static void pr(String str) {
        if (!str.startsWith("{") || !str.endsWith("}")) {
            aj.pr(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(String.valueOf(str))));
        }
    }
}
