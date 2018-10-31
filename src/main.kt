
import brtest.assets.*
import brtest.shows.*
import brtest.assets.ad



fun main(args: Array<String>) {
    val buffy = show(1, "Buffy", "Buffy")
    buffy.addAsset(ad(1, "Episode 1 Ad", "clip", "http://buffy.com", null, "ad for episode 1"))
    buffy.addAsset(video(1, "Episode 1", "video", "http://buffy.com", "1/1/2019", "episode"))

    println("Type check for clip")
    for (asset in buffy.getAssets("clip", null)) {
        println(asset.getDisplayLine())
    }

    println("No expiration test")
    for (asset in buffy.getAssets(null, null)) {
        println(asset.getDisplayLine())
    }

    println("Expires before 1/2/2019")
    for (asset in buffy.getAssets(null, "1/2/2019")) {
        println(asset.getDisplayLine())
    }
}
