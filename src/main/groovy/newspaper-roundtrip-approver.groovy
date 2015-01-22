

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-roundtrip-approver'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-roundtrip-approver')
            }
            branch('master')
        }
    }
}
