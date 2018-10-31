package brtest.assets

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date



open class asset(var ID: Int, var name: String, var type: String, var url: String, p_expires: String?) {
    var expires: Date? = null

    init {
        if (p_expires!=null)
            try {
                this.expires = SimpleDateFormat("MM/dd/yyyy").parse(p_expires)
            } catch (pe: ParseException) {
                println("Parse Exception in asset constructor: " + pe.message)
            }
    }

    open fun getDisplayLine(): String {
        var retVal = ""
        retVal += "(" + this.ID + ") "
        retVal += " <a href=\"" + this.url + "\" target=\"blank\">" + this.name + "</a>"
        retVal += " [" + this.type + "]"
        retVal += " Expires: " + (if (this.expires != null) this.expires.toString() else "No value") + "]"
        return retVal
    }
}

class video(ID: Int, name: String, type: String, url: String, expires: String?, var videoType: String) : asset(ID, name, type, url, expires) {

    override fun getDisplayLine(): String {
        var retVal = super.getDisplayLine()
        retVal += " [Video Type: " + this.videoType + "]"
        return retVal
    }
}

class image(ID: Int, name: String, type: String, url: String, expires: String?) : asset(ID, name, type, url, expires)

class ad(ID: Int, name: String, type: String, url: String, expires: String?, var productDesc: String) : asset(ID, name, type, url, expires) {

    override fun getDisplayLine(): String {
        var retVal = super.getDisplayLine()
        retVal += " [Description: " + this.productDesc + "]"
        return retVal
    }
}
