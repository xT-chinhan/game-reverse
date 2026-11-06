package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class t {
    private static Resources ah = null;
    private static boolean c = false;
    private static String d = null;
    private static boolean ka = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Context f1367ms;
    private static String xr;

    private static String ah(Context context) {
        if (d == null) {
            d = context.getPackageName();
        }
        return d;
    }

    private static int ms(Context context, String str, String str2) {
        int identifier = ms(context).getIdentifier(str, str2, ah(context));
        if (identifier != 0) {
            return identifier;
        }
        if (!ka) {
            xr(context);
            return ms(context).getIdentifier(str, str2, ah(context));
        }
        return context.getResources().getIdentifier(str, str2, ah(context));
    }

    public static String ms(Context context, String str) {
        return ms(context).getString(xr(context, str));
    }

    public static int xr(Context context, String str) {
        return ms(context, str, "string");
    }

    public static void ms(Context context, String str, ImageView imageView) {
        Drawable drawable = ms(context).getDrawable(ka(context, str));
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public static void ms(Context context, String str, View view) {
        Drawable drawable = ms(context).getDrawable(ka(context, str));
        if (view != null) {
            view.setBackground(drawable);
        }
    }

    public static Drawable ah(Context context, String str) {
        try {
            return ms(context).getDrawable(ka(context, str));
        } catch (Exception e) {
            sl.ms(e);
            return null;
        }
    }

    public static Bitmap d(Context context, String str) {
        return BitmapFactory.decodeResource(ms(context), ka(context, str));
    }

    public static int ka(Context context, String str) {
        try {
            return ms(context, str, "drawable");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int c(Context context, String str) {
        return ms(context, str, "id");
    }

    public static int ab(Context context, String str) {
        return ms(context, str, "style");
    }

    public static int x(Context context, String str) {
        return ms(context, str, "dimen");
    }

    public static int ny(Context context, String str) {
        return ms(context).getColor(ch(context, str));
    }

    public static int ch(Context context, String str) {
        return ms(context, str, "color");
    }

    public static int hi(Context context, String str) {
        return ms(context, str, "anim");
    }

    public static Resources ms(Context context) {
        Resources resources = ah;
        if (resources == null) {
            resources = null;
        }
        Context context2 = f1367ms;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }

    public static synchronized void xr(Context context) {
        try {
            if (TextUtils.isEmpty(xr)) {
                return;
            }
            Resources resources = context.getResources();
            ah = new Resources(xr(resources.getAssets(), xr + "/apk/base-1.apk"), resources.getDisplayMetrics(), resources.getConfiguration());
            d = context.getPackageName();
            ka = true;
        } catch (Throwable th) {
            sl.ah("ResourceHelp", "makePluginResources failed", th);
        }
    }

    private static AssetManager xr(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            ms(assetManager2, str);
            assetManager = assetManager2;
        } catch (Exception unused) {
            ms(assetManager, str);
        }
        try {
            cv.ms(assetManager, "ensureStringBlocks", new Object[0]);
        } catch (Exception unused2) {
        }
        return assetManager;
    }

    public static boolean ms(AssetManager assetManager, String str) {
        Method methodMs = cv.ms((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        if (methodMs == null) {
            methodMs = cv.ms((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        }
        if (methodMs != null) {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i < 0) {
                    break;
                }
                try {
                    if (((Integer) methodMs.invoke(assetManager, str)).intValue() != 0) {
                        return true;
                    }
                    i = i2;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }
}
