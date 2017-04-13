package com.lodz.android.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lodz.android.mmsplayer.contract.IVideoPlayer;
import com.lodz.android.mmsplayer.impl.MmsVideoView;

public class MainActivity extends AppCompatActivity {

    private IVideoPlayer mVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoPlayer = (IVideoPlayer) findViewById(R.id.video_view);
        mVideoPlayer.setListener(new MmsVideoView.Listener() {
            @Override
            public void onPrepared() {

            }

            @Override
            public void onBufferingStart() {
                // 缓冲开始
            }

            @Override
            public void onBufferingEnd() {
                // 缓冲结束
            }

            @Override
            public void onCompletion() {

            }

            @Override
            public void onError(@ErrorType int errorType, String msg) {

            }
        });
        mVideoPlayer.init();
        mVideoPlayer.setVideoPath("http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4");
        mVideoPlayer.start();
    }

    @Override
    public void finish() {
        mVideoPlayer.release();
        super.finish();
    }
}
