package com.byazt.xev;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 121})
public final class x {
    public static hw<String> pr = new hw<String>() { // from class: com.byazt.xev.x.1
        @Override // com.byazt.xev.hw
        /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
        public String pr(Object... objArr) {
            SharedPreferences sharedPreferences = (SharedPreferences) objArr[0];
            String string = sharedPreferences.getString("cdid", "");
            if (TextUtils.isEmpty(string)) {
                String string2 = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", string2).apply();
                return string2;
            }
            return string;
        }
    };

    public static String pr(SharedPreferences sharedPreferences) {
        return pr.hw(sharedPreferences);
    }
}
