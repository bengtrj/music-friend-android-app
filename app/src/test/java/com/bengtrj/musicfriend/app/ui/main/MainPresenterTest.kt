package com.bengtrj.musicfriend.app.ui.main

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Test
import org.mockito.Mockito.verify

internal class MainPresenterTest {

    val view: MainContract.View = mock()

    @Test
    internal fun `given view, when attached, shows ListFragment`() {

        val presenter = MainPresenter()
        presenter.attach(view)

        verify(view).showListFragment()
        verifyNoMoreInteractions(view)
    }

    @Test
    internal fun `given attached view, when drawer option is clicked, shows AboutFragment`() {
        val presenter = MainPresenter()
        presenter.attach(view)
        verify(view).showListFragment()

        presenter.onDrawerOptionAboutClick()

        verify(view).showAboutFragment()
        verifyNoMoreInteractions(view)
    }
}