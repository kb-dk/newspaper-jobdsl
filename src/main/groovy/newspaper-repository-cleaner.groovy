import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-repository-cleaner'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-repository-cleaner')
            }
            branch('master')
        }
    }
}
