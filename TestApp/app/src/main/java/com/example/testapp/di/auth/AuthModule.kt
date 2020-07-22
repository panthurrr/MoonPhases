package com.example.testapp.di.auth

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.testapp.di.FragmentKey
import com.example.testapp.di.ViewModelKey
import com.example.testapp.di.scope.AuthScope
import com.example.testapp.ui.auth.AuthFragment
import com.example.testapp.viewmodel.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthModule {

    /*one benefit of providing the actual fragment is that all its dependencies are already created,
      means that we don't need to inject the appropriate component(s) manually
     */
    @AuthScope
    @Binds
    @IntoMap
    @FragmentKey(AuthFragment::class)
    abstract fun provideAuthFragment(fragment: AuthFragment): Fragment

    @AuthScope
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun provideAuthViewModel(viewModel: AuthViewModel): ViewModel
}