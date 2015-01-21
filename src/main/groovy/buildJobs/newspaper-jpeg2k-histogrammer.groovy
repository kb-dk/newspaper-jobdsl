package buildJobs

import buildJobs.common.NewspaperUtilities
import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-jpeg2k-histogrammer'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-jpeg2k-histogrammer')
            }
            branch('master')
        }
    }
}
