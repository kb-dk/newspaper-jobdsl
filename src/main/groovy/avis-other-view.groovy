view(type: ListView) {
    name('Newspaper other')
    description('All newspaper jobs not included in other lists')
    filterBuildQueue()
    filterExecutors()
    jobs {
        name('avis-job-dsl')
        name('Clean_Newspaper_System')
        name('deploy_autonomous_components')
        name('Reset-batch')
        name('Newspaper-devel-config')
        name('Newspaper-testdata')
        name('newspaper_process_monitor')
        name('newspaper_process_monitor_tests')
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