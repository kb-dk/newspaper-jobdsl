job(type: Maven) {
    name 'newspaper-batch-event-framework'
    description 'The general autonomous component library'
    concurrentBuild true
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-batch-event-framework')
            }
        }
    }
    triggers {
        snapshotDependencies(true)
        githubPush()
    }
    jdk('java7')

    mavenInstallation('maven3')
    goals('clean')
    goals('install')
    publishers {
        mailer('', false, true)
    }

}
