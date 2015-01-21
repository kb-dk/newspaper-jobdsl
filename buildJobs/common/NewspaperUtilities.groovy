package common

import javaposse.jobdsl.dsl.Job

public class NewspaperUtilities {
    static def addCommonSteps(Job job) {
        job.with {
            triggers {
                snapshotDependencies(true)
                githubPush()
            }
            jdk('Java7')
            concurrentBuild false
            blockOnUpstreamProjects()
            preBuildSteps {
                shell("echo \"Getting the integration test config from Stash\"\n" +
                        "cd \"\$WORKSPACE\"\n" +
                        "mkdir -p \"build\"\n" +
                        "cd build\n" +
                        "if [ -d \"devel-config\" ]; then\n" +
                        "  cd devel-config\n" +
                        "  git pull\n" +
                        "else\n" +
                        "  git clone ssh://git@sbprojects.statsbiblioteket.dk:7999/avis/devel-config.git\n" +
                        "fi")
                shell("echo \"Getting the sample batch from Stash\"\n" +
                        "cd \"\$WORKSPACE\"\n" +
                        "mkdir -p \"build\"\n" +
                        "cd build\n" +
                        "if [ -d \"testdata\" ]; then\n" +
                        "  cd testdata\n" +
                        "  git pull\n" +
                        "else\n" +
                        "  git clone ssh://git@sbprojects.statsbiblioteket.dk:7999/avis/testdata.git\n" +
                        "fi")
            }
            mavenInstallation('Maven3')
            goals('clean deploy -U -PstandAloneTests,testDataTests,externalTests,integrationTests -Dintegration.test.newspaper.testdata=$WORKSPACE/build/testdata -Dintegration.test.newspaper.properties=$WORKSPACE/build/devel-config/integration.test.newspaper.properties')
            mavenOpts("")
            publishers {
                mailer('', false, true)
            }
        }
    }
}