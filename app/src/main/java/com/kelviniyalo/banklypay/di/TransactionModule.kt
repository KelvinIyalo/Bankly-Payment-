package com.kelviniyalo.banklypay.di

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.kelviniyalo.banklypay.presentation.FragmentAdapter
import com.kelviniyalo.banklypay.presentation.MyViewModel
import com.kelviniyalo.banklypay.adapter.RecyclerViewAdapter
import com.kelviniyalo.banklypay.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TransactionModule {

    @Provides
    @Singleton
    fun providesRepo(
        @ApplicationContext context: Context
    ) = Repository(context)

    @Provides
    @Singleton
    fun providesViewModel(
        repository: Repository
    ) = MyViewModel(repository)

    @Provides
    @Singleton
    fun providesAdapter(
    ) = RecyclerViewAdapter()

    @Provides
    @Singleton
    fun providesFragmentAdapter(
        fragmentManager: FragmentManager
    ) = FragmentAdapter(fragmentManager)

}