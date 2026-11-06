package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bp {
    public static final String a = "ContainerFactoryBuilder";
    private static IXAdContainerFactory e;
    private Context c;
    private Class<?> d;
    public double b = 0.1d;
    private bu f = bu.a();

    public bp(Class<?> cls, Context context) {
        this.d = null;
        this.d = cls;
        this.c = context;
    }

    public IXAdContainerFactory a() throws ca.a {
        if (e == null) {
            try {
                e = (IXAdContainerFactory) this.d.getDeclaredConstructor(Context.class).newInstance(this.c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.analytics.pro.bv.bc, "9.394");
                e.initConfig(jSONObject);
                this.b = e.getRemoteVersion();
                e.onTaskDistribute(bd.a, MobadsPermissionSettings.getPermissionInfo());
                e.initCommonModuleObj(t.a());
            } catch (Throwable th) {
                this.f.b(a, th.getMessage());
                throw new ca.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return e;
    }

    public void b() {
        e = null;
    }
}
