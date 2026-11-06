package com.bytedance.sdk.component.adexpress.d;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    public static ms ms(String str) {
        ms msVar = ms.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        msVar = ms.CSS;
                    } else if (path.endsWith(".js")) {
                        msVar = ms.JS;
                    } else if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico")) {
                        msVar = ms.IMAGE;
                    } else if (path.endsWith(".html")) {
                        msVar = ms.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return msVar;
    }

    public static boolean xr(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }

    public enum ms {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        private String ka;

        ms(String str) {
            this.ka = str;
        }

        public String getType() {
            return this.ka;
        }
    }
}
