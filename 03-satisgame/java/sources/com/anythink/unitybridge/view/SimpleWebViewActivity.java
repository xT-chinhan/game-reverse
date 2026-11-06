package com.anythink.unitybridge.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.anythink.unitybridge.MsgTools;

/* JADX INFO: loaded from: classes.dex */
public class SimpleWebViewActivity extends Activity {
    public static final String EXTRA_URL = "extra_url";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(EXTRA_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            MsgTools.printMsg("url is empty, do nothing");
            finish();
            return;
        }
        try {
            MsgTools.printMsg("open web view, url: " + stringExtra);
            SimpleWebView simpleWebView = new SimpleWebView(this);
            simpleWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            setContentView(simpleWebView);
            simpleWebView.loadUrl(stringExtra);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MsgTools.printMsg("SimpleWebViewActivity onDestroy");
    }
}
