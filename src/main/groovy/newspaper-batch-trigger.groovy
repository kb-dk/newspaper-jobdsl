import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-batch-trigger'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-batch-trigger')
            }
            branch('master')
        }
    }
}
