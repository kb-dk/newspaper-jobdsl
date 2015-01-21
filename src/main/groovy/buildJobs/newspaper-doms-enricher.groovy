package buildJobs

import buildJobs.common.NewspaperUtilities
import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-doms-enricher'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-doms-enricher')
            }
            branch('master')
        }
    }
    goals("-Dlogback.configurationFile=\$WORKSPACE/build/devel-config/logback.xml")
}
