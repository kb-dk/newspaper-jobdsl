view(type: ListView) {
    name('Newspaper Achernar components')
    description('All invokers for the Achernar newspaper system')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex('achernar-.+')
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
        lastBuildConsole() // since 1.23, requires the Extra Columns Plugin
    }
}