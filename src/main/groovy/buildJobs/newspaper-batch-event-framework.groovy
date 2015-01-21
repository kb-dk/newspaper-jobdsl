package buildJobs

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType


Job job = job(type: JobType.Maven) { NewspaperUtilities.addCommonSteps(job);}


job.with {
    name 'newspaper-batch-event-framework'
    description 'The general autonomous component library'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-batch-event-framework')
            }
            branch('master')
        }
    }
};
job;