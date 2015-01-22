import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-batch-metadata-checker'
    label('Python27')
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-batch-metadata-checker')
            }
            branch('master')
        }
    }
}
