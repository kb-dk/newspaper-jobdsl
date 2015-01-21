package buildJobs

import buildJobs.common.NewspaperUtilities
import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-manualQA-flagger'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-manualQA-flagger')
            }
            branch('master')
        }
    }
}
