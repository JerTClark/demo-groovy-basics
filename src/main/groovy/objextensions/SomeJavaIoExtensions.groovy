package objextensions

def file(f) {
    if (f instanceof String)
        new File(f)
    else if (f instanceof List)
        f.collect {
            if (it instanceof String) new File(it)
            else if (it instanceof File) it
            else ""
        }
}

def myFile = file("README.md")

/**
 * Easy access to the contents of a file containing text.
 */
println myFile.text

/**
 * The eachLine method.
 */
myFile.eachLine {
    if(it.startsWith("# ")) println "<title>${it - "# "}</title>"
    else if(it.startsWith("## ")) println "<subtitle>${it - "## "}</subtitle>"
    else if(it.startsWith("    ")) println "<code>${it - "    "}</code>"
    else if(it.startsWith(" - ")) println "<li>${it - " - "}</li>"
}

/**
 * The filterLine method.
 */
println myFile.filterLine {
    it =~ " - "
}

