

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-prompt-doms-ingester'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-prompt-doms-ingester')
            }
            branch('master')
        }
    }
}
