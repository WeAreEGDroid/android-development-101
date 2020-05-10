package com.yehia.buseet.egdroid.ui.main_screen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.widget.Toolbar;

import com.yehia.buseet.egdroid.R;
import com.yehia.buseet.egdroid.app.EgDroidApp;
import com.yehia.buseet.egdroid.ui.Base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.titleET)
    EditText titleET;
    @BindView(R.id.descriptionET)
    EditText descriptionET;
    @BindView(R.id.addPostBtn)
    Button addPostBtn;
    @BindView(R.id.viewPostsBtn)
    Button viewPostsBtn;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    MainViewModel viewModel;

    @Inject
    MainViewModel viewModel2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((EgDroidApp)getApplication()).getApplicationComponent()
                .inject(this);

        viewModel.getMovies()
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

}
