view(type: ListView) {
    name('Newspaper components')
    description('All build jobs for the newspaper components')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex('newspaper-.+')
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