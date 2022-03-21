package tech.eboot.xplanet.app;

import android.app.Application;



public class AppX extends Application {

    private static AppX instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    public static synchronized AppX getInstance() {
        return instance;
    }
}
