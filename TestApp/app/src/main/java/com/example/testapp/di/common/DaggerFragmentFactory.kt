package com.example.testapp.di.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

/*
    We need this in order to setup the FragmentFactory in the Activity. A fragment with a non-empty
    constructor can only be created through a custom FragmentFactory.
    Fragments were never permitted to have non-empty constructors because when the screen would be rotated,
    the fragment manager would recreate the fragment, and the arguments
 */
class DaggerFragmentFactory @Inject constructor(
    private val providers: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        // loadFragmentClass is a static method of FragmentFactory
        // and will return the Class of the fragment
        val fragmentClass = loadFragmentClass(classLoader, className)

        // we will then be able to use fragmentClass to get the provider
        // of the Fragment from the providers map
        val provider = providers[fragmentClass] ?:
            providers.asIterable().firstOrNull(){
                fragmentClass.isAssignableFrom(it.key)
            }?.value ?: throw IllegalArgumentException("unknown fragment class $fragmentClass")
        return try {
            provider.get()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
        // The provider for the fragment could be null
        // if the Fragment class is not binded to the Daggers graph
        // in this case, we will default to the default implementation
        // which will attempt to instantiate the Fragment
        // through the no-arg constructor
    }
}