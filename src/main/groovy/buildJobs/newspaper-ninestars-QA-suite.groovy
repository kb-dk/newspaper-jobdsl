package buildJobs

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-ninestars-QA-suite'
    label('Python27')
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-ninestars-QA-suite')
            }
            branch('master')
        }
    }
}
