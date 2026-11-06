package com.smartdigimkt.china.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.smartdigimkt.a.a;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class TransparentActivity extends Activity {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent.getIntExtra("type", 0) != 1000) {
            finish();
            return;
        }
        try {
            ActivityCompat.requestPermissions(this, intent.getStringArrayExtra(com.anythink.china.activity.TransparentActivity.d), intent.getIntExtra(com.anythink.china.activity.TransparentActivity.b, 0));
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        a.a(a.get(Integer.valueOf(i)));
        finish();
    }
}
