

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType


NewspaperUtilities.addCommonSteps(job(type: JobType.Maven) {
    name 'newspaper-edition-pdf'
    triggers {
        scm("H/5 * * * *")
    }
    scm {
        git {
            remote {
                url('ssh://git@sbprojects.statsbiblioteket.dk:7999/avis/newspaper-edition-pdf.git')
            }
            branch('master')
        }
    }
    preBuildSteps {
        shell("cd \"\$WORKSPACE\"\n" +
                "mkdir -p \"build\"\n" +
                "cd build\n" +
                "cd testdata")
    }
} as Job)
