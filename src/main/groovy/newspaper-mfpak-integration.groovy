

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-mfpak-integration'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-mfpak-integration.git')
            }
            branch('master')
        }
    }
}
