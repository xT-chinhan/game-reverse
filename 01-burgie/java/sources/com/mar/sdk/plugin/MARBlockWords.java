package com.mar.sdk.plugin;

import android.text.TextUtils;
import com.mar.sdk.IBlockWords;
import com.mar.sdk.base.PluginFactory;
import com.mar.sdk.log.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MARBlockWords {
    private static MARBlockWords instance;
    private IBlockWords iBlockWords;

    private MARBlockWords() {
    }

    public static MARBlockWords getInstance() {
        if (instance == null) {
            instance = new MARBlockWords();
        }
        return instance;
    }

    public void init() {
        this.iBlockWords = (IBlockWords) PluginFactory.getInstance().initPlugin(12);
    }

    public void getBlockWords(String words, BlockWordsCallBack callBack) {
        if (callBack == null) {
            Log.d("MARSDK", "BlockWordsCallBack can not null");
            return;
        }
        if (words == null || TextUtils.isEmpty(words)) {
            Log.d("MARSDK", "word is null,please input word");
            callBack.selectResult(false, false, new ArrayList());
        } else if (words.length() > 60) {
            Log.d("MARSDK", "word is too long,please fix it, max length is 60");
            callBack.selectResult(false, false, new ArrayList());
        } else if (this.iBlockWords == null) {
            Log.d("MARSDK", "not support block words select now or BlockWordsCallBack is null");
            callBack.selectResult(false, false, new ArrayList());
        } else {
            this.iBlockWords.select(words, callBack);
        }
    }
}
