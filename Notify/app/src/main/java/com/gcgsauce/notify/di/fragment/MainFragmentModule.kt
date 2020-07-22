package com.gcgsauce.notify.di.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.gcgsauce.notify.di.key.FragmentKey
import com.gcgsauce.notify.di.factory.FragmentProviderFactory
import com.gcgsauce.notify.di.scope.MainScope
import com.gcgsauce.notify.presentation.ui.NavHostFragment
import com.gcgsauce.notify.presentation.ui.alarm.AlarmListFragment
import com.gcgsauce.notify.presentation.ui.alarm_times.AlarmTimesFragment
import com.gcgsauce.notify.presentation.ui.account.AccountFragment
import com.gcgsauce.notify.presentation.ui.settings.SettingsFragment
import com.gcgsauce.notify.presentation.ui.alarm.create.CreateEditAlarmFragment
import com.gcgsauce.notify.presentation.ui.alarm_times.WeekdayTimesFragment
import com.gcgsauce.notify.presentation.ui.settings.SettingsContainerFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module
abstract class MainFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(NavHostFragment::class)
    abstract fun provideMainNavHostFragment(fragment: NavHostFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(AlarmListFragment::class)
    abstract fun provideAlarmListFragment(fragment: AlarmListFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(AlarmTimesFragment::class)
    abstract fun provideAlarmTimesFragment(fragment: AlarmTimesFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(CreateEditAlarmFragment::class)
    abstract fun provideCreateEditAlarmFragment(fragment: CreateEditAlarmFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(SettingsContainerFragment::class)
    abstract fun provideSettingsContainerFragment(fragment: SettingsContainerFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(SettingsFragment::class)
    abstract fun provideSettingsFragment(fragment: SettingsFragment): Fragment

    @MainScope
    @Binds
    @IntoMap
    @FragmentKey(AccountFragment::class)
    abstract fun provideAccountFragment(fragment: AccountFragment): Fragment

    //do not scope this because when host fragment rotates, it tries to resolve 2 fragments inside the viewpager
    //and since it was created from the same provider, they resolve to the same fragment, which causes a 'fragment
    //is already added' error
    @Binds
    @IntoMap
    @FragmentKey(WeekdayTimesFragment::class)
    abstract fun provideWeekdayTimesFragment(fragment: WeekdayTimesFragment): Fragment

    @MainScope
    @Binds
    abstract fun bindFragmentProviderFactory(
        fragmentProviderFactory: FragmentProviderFactory): FragmentFactory
}