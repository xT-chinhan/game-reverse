package com.mar.sdk.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AnsyImageUtil extends AsyncTask<Void, Void, Drawable> {
    private Activity mActivity;
    private String url;

    public abstract void onReceived(Drawable drawable);

    public AnsyImageUtil(Activity activity, String url) {
        this.url = url;
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Drawable doInBackground(Void... params) {
        Drawable drawable = null;
        try {
            InputStream in = (InputStream) new URL(this.url).openConnection().getContent();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[4096];
            while (true) {
                int bytesRead = in.read(buf);
                if (bytesRead != -1) {
                    bos.write(buf, 0, bytesRead);
                } else {
                    byte[] byteArray = bos.toByteArray();
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    Drawable drawable2 = new BitmapDrawable(this.mActivity.getResources(), decodeByteArray);
                    try {
                        in.close();
                        bos.close();
                        return drawable2;
                    } catch (Throwable th) {
                        e = th;
                        drawable = drawable2;
                    }
                }
                e.printStackTrace();
                return drawable;
            }
        } catch (Throwable th2) {
            e = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Drawable result) {
        super.onPostExecute(result);
        onReceived(result);
    }
}
