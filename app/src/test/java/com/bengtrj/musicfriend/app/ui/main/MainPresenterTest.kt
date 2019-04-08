package com.bengtrj.musicfriend.app.ui.main

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.mockito.Mockito.verify
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object MainPresenterTest : Spek({
    Feature("View attachment") {

        Scenario("ListFragment is shown by default") {

            val presenter = MainPresenter()
            val view: MainContract.View = mock()

            When("view is attached") {
                presenter.attach(view)
            }

            Then("the view shows ListFragment") {
                verify(view).showListFragment()
            }

            Then("no more interactions with the view occur") {
                verifyNoMoreInteractions(view)
            }
        }

        Scenario("About button is pressed") {

            val presenter = MainPresenter()
            val view: MainContract.View = mock()

            Given("view is attached") {
                presenter.attach(view)
                reset(view)
            }

            When("about button is pressed") {
                presenter.onDrawerOptionAboutClick()
            }

            Then("the view shows the AboutFragment") {
                verify(view).showAboutFragment()
            }

            Then("no more interactions with the view occur") {
                verifyNoMoreInteractions(view)
            }
        }

    }
})
