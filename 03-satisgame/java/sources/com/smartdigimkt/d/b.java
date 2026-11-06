package com.smartdigimkt.d;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.china.activity.TransparentActivity;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static void a(Context context, String... strArr) {
        if (context != null) {
            int iNextInt = new Random().nextInt(1000000000);
            Intent intent = new Intent(context, (Class<?>) TransparentActivity.class);
            intent.putExtra("type", 1000);
            intent.putExtra(com.anythink.china.activity.TransparentActivity.b, iNextInt);
            intent.putExtra(com.anythink.china.activity.TransparentActivity.d, strArr);
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
        }
    }
}
