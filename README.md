## Music friend

This is an example app focused on getting things done so I could practice building a pipeline to
leverage the new Play Publish API V3 and automate publishing of app versions to Google Play.

I decided to build a simple app that listed all Satriani albums calling the `iTunes open API`,
simply because it works, does not impose limits nor requires an `api key`.  

It's written in Kotlin using the new `androidx` packages, plus:
 - Square's `Dagger 2` for dependency injection
 - Square's `Picasso` to load the images asynchronously, etc.
 - `JavaRx` for assuring stuff runs on their specific threads (networking on IO threads, UI updates on the main thread etc)

Unfortunately for this first spike there's no tests...
but that will change once I have time and write an article about Android tests!