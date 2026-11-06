package com.byazt.rg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.byazt.hg.of;
import com.byazt.sd.cz;
import com.byazt.vzx.pr;
import com.byazt.wt.ls;
import com.byazt.xk.hw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 204, MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS})
public class BaseThemeActivity extends Activity {
    public of s;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        of ofVarHw = ls.hw(getIntent());
        this.s = ofVarHw;
        if (ofVarHw == null) {
            hw.pr().pr("meta_null", (Throwable) null);
        } else {
            if (!w() || (window = getWindow()) == null) {
                return;
            }
            window.addFlags(512);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public boolean w() {
        return this.s.gz();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        String stringExtra;
        super.onDestroy();
        Intent intent = getIntent();
        if (intent != null && (stringExtra = intent.getStringExtra("multi_process_materialmeta_key")) != null) {
            cz.hw(stringExtra, of.class);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
