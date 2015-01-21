package buildJobs

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'ewspaper-workflow-restart-trigger'
    label('Python27')
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-workflow-restart-trigger')
            }
            branch('master')
        }
    }
}
