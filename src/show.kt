package brtest.shows

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date

import brtest.assets.asset

class show(internal var ID: Int, internal var name: String, internal var description: String) {
    internal var assets: MutableCollection<asset>

    init {
        this.assets = ArrayList()
    }

    fun addAsset(asset: asset) {
        this.assets.add(asset)
    }

    fun getAssets(type: String?, expiration: String?): Collection<asset> {
        var retList: Collection<asset>

        retList = this.assets;

        if (type != null)
            retList = this.assets.filter { line -> line.type == type }
        if (expiration != null)
            try {
                val exp = SimpleDateFormat("MM/dd/yyyy").parse(expiration)
                retList = retList.filter { line ->  line.expires == null || !(line.expires?.before(exp)?: true) }
            } catch (pe: ParseException) {
                println("Parse Exception in show.getAssets: " + pe.message)
            }

        return retList
    }

}
