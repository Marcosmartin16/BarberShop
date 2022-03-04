package com.marramar.myapplication;

import static android.app.Service.START_STICKY;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.Provider;

public class Servicio extends Service {

    MediaPlayer reproductor;

    @Override
    public void onCreate() {}

    @Override

    public int onStartCommand(Intent intent, int flags, int idArranque) {

        reproductor = MediaPlayer.create(this,R.raw.audio);
        reproductor.start();
        return START_STICKY;
    }



    @Override
    public void onDestroy() {

        reproductor.stop();
    }



    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
