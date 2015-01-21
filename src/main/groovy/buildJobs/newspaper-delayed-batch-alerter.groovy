package buildJobs

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-delayed-batch-alerter'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-delayed-batch-alerter')
            }
            branch('master')
        }
    }
}
