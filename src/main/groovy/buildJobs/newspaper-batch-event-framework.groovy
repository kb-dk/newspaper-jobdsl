package buildJobs

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType


NewspaperUtilities.addCommonSteps(job(type: JobType.Maven){
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
} as Job)
