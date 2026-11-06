package com.byazt.ee;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 36})
public class ny {
    public final w hn;
    public final Map<String, cz> hw;
    public final Collection<String> pr;
    public final Set<pr> x;

    interface pr {
    }

    public cz pr(String str) {
        if (!this.pr.contains(str) && !TextUtils.equals(str, "host")) {
            throw new IllegalArgumentException("Namespace: " + str + " not registered.");
        }
        return pr(str, null);
    }

    public void pr(pr prVar) {
        this.x.add(prVar);
    }

    public void hw(pr prVar) {
        this.x.remove(prVar);
    }

    private cz pr(String str, JSONObject jSONObject) {
        cz czVar = this.hw.get(str);
        if (czVar == null) {
            cz czVar2 = new cz(str, this.hn.hn(), this.hn.pr(), this.hn.hw(), jSONObject);
            this.hw.put(str, czVar2);
            return czVar2;
        }
        if (jSONObject != null) {
            czVar.update(jSONObject);
            return czVar;
        }
        return czVar;
    }
}
