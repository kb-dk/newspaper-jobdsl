import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-workflow-restart-trigger'
    description("Integration test which creates a batch roundtrip object, adds some events to it in various states of success/failure, and then triggers a workflow-restart by removing the failed events and their successors.")
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
