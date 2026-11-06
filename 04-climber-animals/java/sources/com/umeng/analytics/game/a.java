package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.ek;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: GameState.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public String a;
    public String b;
    private Context c;
    private final String d = "um_g_cache";
    private final String e = "single_level";
    private final String f = "stat_player_level";
    private final String g = "stat_game_level";
    private C0660a h = null;

    public a(Context context) {
        this.c = context;
    }

    public static String a(Serializable serializable) {
        if (serializable == null) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return a(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append((char) (((bArr[i] >> 4) & 15) + 97));
            stringBuffer.append((char) ((bArr[i] & ek.m) + 97));
        }
        return stringBuffer.toString();
    }

    public static byte[] a(String str) {
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length(); i += 2) {
            int i2 = i / 2;
            bArr[i2] = (byte) ((str.charAt(i) - 'a') << 4);
            bArr[i2] = (byte) (bArr[i2] + (str.charAt(i + 1) - 'a'));
        }
        return bArr;
    }

    public static Object b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ObjectInputStream(new ByteArrayInputStream(a(str))).readObject();
        } catch (Exception unused) {
            return null;
        }
    }

    public C0660a c(String str) {
        C0660a c0660a = new C0660a(str);
        this.h = c0660a;
        c0660a.a();
        return this.h;
    }

    public void a() {
        try {
            C0660a c0660a = this.h;
            if (c0660a != null) {
                c0660a.b();
                SharedPreferences.Editor editorEdit = this.c.getSharedPreferences("um_g_cache", 0).edit();
                editorEdit.putString("single_level", a(this.h));
                editorEdit.putString("stat_player_level", this.b);
                editorEdit.putString("stat_game_level", this.a);
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        SharedPreferences sharedPreferences;
        try {
            SharedPreferences preferenceWrapper = PreferenceWrapper.getInstance(this.c, "um_g_cache");
            String string = preferenceWrapper.getString("single_level", null);
            if (!TextUtils.isEmpty(string)) {
                C0660a c0660a = (C0660a) b(string);
                this.h = c0660a;
                if (c0660a != null) {
                    c0660a.c();
                }
            }
            if (TextUtils.isEmpty(this.b)) {
                String string2 = preferenceWrapper.getString("stat_player_level", null);
                this.b = string2;
                if (string2 == null && (sharedPreferences = PreferenceWrapper.getDefault(this.c)) != null) {
                    this.b = sharedPreferences.getString("userlevel", null);
                }
            }
            if (this.a == null) {
                this.a = preferenceWrapper.getString("stat_game_level", null);
            }
        } catch (Throwable unused) {
        }
    }

    public C0660a d(String str) {
        C0660a c0660a = this.h;
        if (c0660a == null) {
            return null;
        }
        c0660a.d();
        if (!this.h.a(str)) {
            return null;
        }
        C0660a c0660a2 = this.h;
        this.h = null;
        return c0660a2;
    }

    /* JADX INFO: renamed from: com.umeng.analytics.game.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GameState.java */
    static class C0660a implements Serializable {
        private static final long a = 20140327;
        private String b;
        private long c;
        private long d;

        public C0660a(String str) {
            this.b = str;
        }

        public boolean a(String str) {
            return this.b.equals(str);
        }

        public void a() {
            this.d = System.currentTimeMillis();
        }

        public void b() {
            this.c += System.currentTimeMillis() - this.d;
            this.d = 0L;
        }

        public void c() {
            a();
        }

        public void d() {
            b();
        }

        public long e() {
            return this.c;
        }

        public String f() {
            return this.b;
        }
    }
}
