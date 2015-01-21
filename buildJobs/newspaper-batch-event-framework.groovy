job(type: Maven) {
    name 'newspaper-batch-event-framework-2'
    description 'The general autonomous component library'
    concurrentBuild true
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-batch-event-framework')
            }
            branch('master')
        }
    }
    triggers {
        snapshotDependencies(true)
        githubPush()
    }
    jdk('java7')

    preBuildSteps {
        shell("echo \"Getting the integration test config from Stash\"\n" +
                "cd \"$WORKSPACE\"\n" +
                "mkdir -p \"build\"\n" +
                "cd build\n" +
                "if [ -d \"devel-config\" ]; then\n" +
                "  cd devel-config\n" +
                "  git pull\n" +
                "else\n" +
                "  git clone ssh://git@sbprojects.statsbiblioteket.dk:7999/avis/devel-config.git\n" +
                "fi")
        shell("echo \"Getting the sample batch from Stash\"\n" +
                "cd \"$WORKSPACE\"\n" +
                "mkdir -p \"build\"\n" +
                "cd build\n" +
                "if [ -d \"testdata\" ]; then\n" +
                "  cd testdata\n" +
                "  git pull\n" +
                "else\n" +
                "  git clone ssh://git@sbprojects.statsbiblioteket.dk:7999/avis/testdata.git\n" +
                "fi")

    }
    postBuildSteps {
        shell("echo 'run after Maven'")
    }
    mavenInstallation('maven3')
    mavenOpts('-Pnewspaper')
    mavenOpts('-PintegrationTests')
    mavenOpts('-PtestDataTests')
    mavenOpts('-PstandAloneTests')
    mavenOpts('-PexternalTests')
    goals('clean')
    goals('install')
    publishers {
        mailer('', false, true)
    }

}
