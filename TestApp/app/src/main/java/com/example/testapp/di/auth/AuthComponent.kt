package com.example.testapp.di.auth

import com.example.testapp.di.scope.AuthScope
import com.example.testapp.ui.auth.AuthActivity
import dagger.Subcomponent

/*
    Scoping just means that all objects provided by the component are re-created only when the
    component is re-created (e.g. singleton scope implies component is never recreated). So if
    we want to scope a component to an activity's lifecycle for example, make sure that the
    component is destroyed when the activity is destroyed.
 */
@AuthScope
@Subcomponent(
    modules = [AuthModule::class]
)
interface AuthComponent {

    fun inject(activity: AuthActivity)
}