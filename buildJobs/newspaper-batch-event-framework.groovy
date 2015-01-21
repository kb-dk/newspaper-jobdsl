job(type: Maven) {
    name 'newspaper-batch-event-framework-2'
    description 'The general autonomous component library'
    concurrentBuild true
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-batch-event-framework')
            }
        }
        branch('master')
    }
    triggers {
        snapshotDependencies(true)
        githubPush()
    }
    jdk('java7')
    maven {
        mavenInstallation('maven3')
        mavenOpts('-Pnewspaper')
        mavenOpts('-PintegrationTests')
        mavenOpts('-PtestDataTests')
        mavenOpts('-PstandAloneTests')
        mavenOpts('-PexternalTests')
        goals('clean')
        goals('install')
    }
    publishers {
        mailer('', false, true)
    }

}
