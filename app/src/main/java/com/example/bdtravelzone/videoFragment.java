package com.example.bdtravelzone;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Objects;


public class videoFragment extends Fragment {


     //private MediaController mediaController = new MediaController(Objects.requireNonNull(getActivity()).getApplicationContext());

    //return inflater.inflate(R.layout.fragment_food, container, false);

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MediaController mediaController = new MediaController(getActivity());

        View view = inflater.inflate(R.layout.fragment_video,container,false);
        VideoView videoView = (VideoView) view.findViewById(R.id.videoFragmentId);

        //videoView

        mediaController.setAnchorView(videoView);

        Uri video = Uri.parse("android.resource://"+getClass().getPackage().getName()+"/"+R.raw.nilachal);
        videoView.setVideoURI(video);
        videoView.setMediaController(mediaController);
        //videoView.start();

        return view;

    }
}
