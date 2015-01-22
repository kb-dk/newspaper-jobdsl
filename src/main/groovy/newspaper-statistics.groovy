import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-statistics'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-statistics')
            }
            branch('master')
        }
    }
}
