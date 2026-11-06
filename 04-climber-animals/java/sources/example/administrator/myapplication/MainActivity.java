package example.administrator.myapplication;

import android.content.Intent;
import androidx.core.content.FileProvider;
import com.unity3d.player.UnityPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class MainActivity {
    public static boolean installAPK(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(1);
        intent.setDataAndType(FileProvider.getUriForFile(UnityPlayer.currentActivity, UnityPlayer.currentActivity.getPackageName() + ".fileprovider", file), "application/vnd.android.package-archive");
        UnityPlayer.currentActivity.startActivity(intent);
        return true;
    }
}
