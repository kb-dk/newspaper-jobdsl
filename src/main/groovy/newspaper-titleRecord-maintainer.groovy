

import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(job);

job.with {
    name 'newspaper-titleRecord-maintainer'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-titleRecord-maintainer')
            }
            branch('master')
        }
    }
    mavenOpts("-Dlogback.configurationFile=\$WORKSPACE/build/devel-config/logback.xml")

}
