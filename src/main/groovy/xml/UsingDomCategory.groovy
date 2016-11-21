package xml

import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

def url = getClass().classLoader.getResource("bore-log.xml")
def boreLogXml = new File(url.getFile()).text
//println "${boreLogXml}"

/**
 * We can use DOMCategory to navigate the DOM structure using GPath-like notation.
 */

def doc = DOMBuilder.parse(new FileReader(new File(url.file)))
println "${doc.firstChild}"
