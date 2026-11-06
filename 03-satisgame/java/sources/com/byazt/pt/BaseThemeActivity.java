package com.byazt.pt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.byazt.cp.n;
import com.byazt.eji.s;
import com.byazt.gct.pk;
import com.byazt.ikv.qg;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC})
public class BaseThemeActivity extends Activity {
    public pk ae;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        pk pkVarQg = w.qg(getIntent());
        this.ae = pkVarQg;
        if (pkVarQg == null) {
            s.n().n("meta_null", (Throwable) null);
        } else {
            if (!cp() || (window = getWindow()) == null) {
                return;
            }
            window.addFlags(512);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public boolean cp() {
        return this.ae.lh();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        String stringExtra;
        super.onDestroy();
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("multi_process_materialmeta_key")) == null) {
            return;
        }
        qg.qg(stringExtra, pk.class);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
