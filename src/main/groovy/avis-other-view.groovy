view(type: ListView) {
    name('Newspaper other')
    description('All newspaper jobs not included in other lists')
    filterBuildQueue()
    filterExecutors()
    jobs {
        project('avis-job-dsl')
        project('Clean_Newspaper_System')
        project('deploy_autonomous_components')
        project('Reset-batch')
        project('Newspaper-devel-config')
        project('Newspaper-testdata')
        project('newspaper_process_monitor')
        project('newspaper_process_monitor_tests')
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