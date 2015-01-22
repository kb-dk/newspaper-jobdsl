

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
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
    prebuildSteps{
        shell("cd \"\$WORKSPACE\"\n" +
                "mkdir -p \"build\"\n" +
                "cd build\n" +
                "cd testdata")
    }
}
