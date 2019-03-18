package com.bengtrj.musicfriend.app.ui.listAlbums

import android.content.res.Resources
import com.bengtrj.android.test.rx.TestSchedulerProvider
import com.bengtrj.musicfriend.app.R
import com.bengtrj.musicfriend.app.api.ApiServiceInterface
import com.bengtrj.musicfriend.app.di.listAlbums.ListAlbumsPresenterComponent
import com.bengtrj.musicfriend.app.di.listAlbums.ListAlbumsPresenterModule
import com.bengtrj.musicfriend.app.models.Album
import com.bengtrj.musicfriend.app.models.AlbumsQueryResult
import com.bengtrj.musicfriend.app.util.rx.SchedulerProvider
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import it.cosenonjaviste.daggermock.DaggerMock
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.any
import org.mockito.Mockito.anyString
import java.util.concurrent.TimeUnit
import org.mockito.Mockito.`when` as whenever


class ListAlbumsPresenterTest {

    @get:Rule
    var mockitoRule = DaggerMock.rule<ListAlbumsPresenterComponent>(ListAlbumsPresenterModule()) {
        set { module -> presenter = ListAlbumsPresenter(module) }
    }

    private val view: ListAlbumsContract.View = mock()
    private val apiService: ApiServiceInterface = mock()
    private val subscriptions: CompositeDisposable = mock()
    private val resources: Resources = mock()
    private val uiScheduler = TestScheduler()
    private val ioScheduler = TestScheduler()
    private val schedulerProvider: SchedulerProvider = spy(TestSchedulerProvider(ui = uiScheduler, io = ioScheduler))
    private lateinit var presenter: ListAlbumsPresenter

    @Test
    fun `when just attached, does not call api`() {
        presenter.attach(view)
        verifyZeroInteractions(apiService)
    }

    @Test
    fun `when attached and not , does not have subscriptions`() {
        presenter.attach(view)
        verifyZeroInteractions(subscriptions)
    }


    @Test
    fun `when detached, subscriptions cleared`() {
        presenter.detach()
        verify(subscriptions).clear()
        verifyNoMoreInteractions(subscriptions)
    }

    @Test
    fun `when attached and data loaded, calls the api to get satriani's albums`() {

        val observable = Observable.just(AlbumsQueryResult(0, emptyList()))
        whenever(apiService.getAlbumListByArtist("satriani")).thenReturn(observable)

        presenter.attach(view)
        presenter.loadData()

        verify(apiService).getAlbumListByArtist("satriani")
        verifyNoMoreInteractions(apiService)
    }

    @Test
    fun `when attached and data loaded, subscribes once`() {

        val observable = Observable.just(AlbumsQueryResult(0, emptyList()))
        whenever(apiService.getAlbumListByArtist(anyString())).thenReturn(observable)

        presenter.attach(view)
        presenter.loadData()

        verify(subscriptions).add(any())
        verifyNoMoreInteractions(subscriptions)
    }

    @Test
    fun `when attached and data loaded, view gets updated with the result`() {

        val albums = arrayListOf(Album(1, "", "", "", "", 5))
        val observable = Observable.just(
                AlbumsQueryResult(1, albums)
        )
        whenever(apiService.getAlbumListByArtist(anyString())).thenReturn(observable)

        presenter.attach(view)
        presenter.loadData()

        ioScheduler.triggerActions()
        uiScheduler.triggerActions()

        verify(view).loadDataSuccess(albums)
        verify(view).showProgress(false)
    }

    @Test
    fun `when attached and data loaded, view gets updated with error message`() {

        val t = IllegalStateException("O no!")

        val observable: Observable<AlbumsQueryResult> = Observable.error(t)
        whenever(apiService.getAlbumListByArtist(anyString())).thenReturn(observable)
        whenever(resources.getString(R.string.album_load_error)).thenReturn("Error message")

        presenter.attach(view)
        presenter.loadData()

        ioScheduler.triggerActions()
        uiScheduler.triggerActions()

        verify(view).showErrorMessage("Error message")
    }

    @Test
    fun `when attached and data loaded, io and ui schedulers are used`() {

        val observable = Observable.empty<AlbumsQueryResult>()
        whenever(apiService.getAlbumListByArtist(anyString())).thenReturn(observable)

        presenter.attach(view)
        presenter.loadData()

        verify(schedulerProvider).io()
        verify(schedulerProvider).ui()

        ioScheduler.triggerActions()
        uiScheduler.triggerActions()

        verifyNoMoreInteractions(schedulerProvider)
    }

    @Test
    fun `when attached and data loaded, then API calls were run by ioScheduler`() {

        val result = AlbumsQueryResult(0, emptyList())
        val observable =
                Observable.just(result).delay(1, TimeUnit.MILLISECONDS, ioScheduler)

        val testObservable = observable.test()

        whenever(apiService.getAlbumListByArtist(anyString())).thenReturn(observable)

        presenter.attach(view)
        verifyZeroInteractions(apiService)
        testObservable.assertNoValues()
        testObservable.assertNotComplete()

        presenter.loadData()
        verify(apiService).getAlbumListByArtist(anyString()) //no api call yet, just an observable
        testObservable.assertNoValues() //asserts api call done
        testObservable.assertNotComplete()

        ioScheduler.advanceTimeBy(2, TimeUnit.MILLISECONDS)
        testObservable.assertValue(result) //asserts api call done
        testObservable.assertValueCount(1)
        testObservable.assertComplete()

        uiScheduler.triggerActions()

        verifyNoMoreInteractions(apiService)
    }

    @Test
    fun `when attached and data loaded, UI updates are ran by uiScheduler`() {

        val albums = emptyList<Album>()
        val observable =
                Observable.just(AlbumsQueryResult(0, albums))

        whenever(apiService.getAlbumListByArtist(anyString())).thenReturn(observable)

        presenter.attach(view)
        presenter.loadData()

        verifyZeroInteractions(view)

        ioScheduler.triggerActions()
        verifyZeroInteractions(view)

        uiScheduler.triggerActions()
        verify(view).loadDataSuccess(albums)
        verify(view).showProgress(false)

        verifyNoMoreInteractions(view)
    }

}