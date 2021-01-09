package com.example.sakhiraw;

import android.app.Notification;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.Log;

public class StartCallService extends JobService {

    boolean jobCancelledInBetween = false ;

    private static  final String TAG = "Service_Class" ;

    Intent intent;

    @Override
    public boolean onStartJob(JobParameters params) {

        Log.e(TAG, " Job start method called " );

        String phone = "tel:" + "7355749822" ;

        intent = new Intent(Intent.ACTION_CALL);

        intent.setData(Uri.parse(phone));

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);

        jobFinished(params, false);

        return true;

    }


    @Override
    public boolean onStopJob(JobParameters params) {

        Log.e(TAG, "Job cancelled before completion" );

        jobCancelledInBetween = true;

        return true;
    }
}
