package buildJobs

import buildJobs.common.NewspaperUtilities
import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-editionRecord-maintainer'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-editionRecord-maintainer')
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
