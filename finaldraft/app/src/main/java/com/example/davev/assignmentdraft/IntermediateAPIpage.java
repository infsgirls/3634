package com.example.davev.assignmentdraft;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
//import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

//The purpose of this activity is to present the user with a video linked from Youtube on ERD's.
// It is considered to be the Intermediate lesson for ERD's.
public class IntermediateAPIpage extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    //Storage of API key and the actual YouTube video ID based on the video's URL
    private static final String TAG = "IntermediateAPIpage";
    static final String GOOGLE_API_KEY = "AIzaSyAVnRXh3zLezfgoReRHLOdBPutJVf_nK5w";
    static final String YOUTUBE_VIDEO_ID = "ky5X7qwIUAE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate_apipage);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.intermediate_api);

        //Calling YouTube API methods to present the video on the user's screen
        YouTubePlayerView playerView = new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        constraintLayout.addView(playerView);
        playerView.initialize(GOOGLE_API_KEY, this);


    }

    //The remaining methods below were implemented as part of the development process, and will help identify any
    //issues should they arise in the future. The invoking of the methods have been disabled for the purposes of
    //providing a more seamless user experience.
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG, "onInitializationSuccess: provider is " + provider.getClass().toString());
        Toast.makeText(this, "Initialized Youtube Player successfully", Toast.LENGTH_LONG).show();

//        youTubePlayer.setPlaybackEventListener(playbackEventListener);
//        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);

        if (!wasRestored) {
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }

    }

        @Override
        public void onInitializationFailure (YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult){
            final int REQUEST_CODE = 1;

            if (youTubeInitializationResult.isUserRecoverableError()) {
                youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show();
        } else {
            String errorMessage = String.format("There was an error initializing the YoutubePlayer (%1$s)", youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
            }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(IntermediateAPIpage.this, "Good, video is playing ok", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(IntermediateAPIpage.this, "Video has paused", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopped() {
            Toast.makeText(IntermediateAPIpage.this, "Video has stopped", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {
            Toast.makeText(IntermediateAPIpage.this, "Click Ad now, make the video creator rich!", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(IntermediateAPIpage.this, "Video has started", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(IntermediateAPIpage.this, "Congratulations! You've completed another video.", Toast.LENGTH_LONG).show();
    }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

}
    };
}


//Code generated based on tutorials at https://www.udemy.com/master-android-7-nougat-java-app-development-step-by-step/  [Developed by Tim Buchalka]
//YouTube video found at https://www.youtube.com/watch?v=ky5X7qwIUAE  [owned by ISO Training Institute]
