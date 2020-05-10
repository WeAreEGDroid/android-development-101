package com.yehia.buseet.egdroid.di.module;

import android.content.Context;

import com.appizona.yehiahd.fastsave.FastSave;
import com.yehia.buseet.egdroid.data_model.DataManager;
import com.yehia.buseet.egdroid.data_model.local.FastLocalHlper;
import com.yehia.buseet.egdroid.data_model.remote.FastApiHelper;
import com.yehia.buseet.egdroid.data_model.remote.IApiHelper;
import com.yehia.buseet.egdroid.ui.main_screen.MainViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    public Context provideAppContext() {
        return this.mContext;
    }

    @Provides
    @Singleton
    public DataManager provideDataManager(IApiHelper apiHelper,
                                          FastLocalHlper localDataHelper) {
        return new DataManager(apiHelper, localDataHelper);
    }

    @Provides
    @Singleton
    public IApiHelper provideApiHelper() {
        return new FastApiHelper();
    }

    @Provides
    @Singleton
    public FastSave provideFastSave(Context mContext) {
        FastSave.init(mContext);
        return FastSave.getInstance();
    }

    @Provides
    @Singleton
    public FastLocalHlper provideLocalDataHelper(FastSave fastSave) {
        return new FastLocalHlper();
    }

    @Provides
    @Singleton
    public MainViewModel provideMainViewModel(DataManager dataManager) {
        return new MainViewModel(dataManager);
    }


}
