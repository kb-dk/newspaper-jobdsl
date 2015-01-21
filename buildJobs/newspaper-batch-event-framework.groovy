import common.NewspaperUtilities

job = job(type: Maven) {
    name 'newspaper-batch-event-framework'
    description 'The general autonomous component library'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-batch-event-framework')
            }
            branch('master')
        }
    }
}
NewspaperUtilities.addCommonSteps(job)