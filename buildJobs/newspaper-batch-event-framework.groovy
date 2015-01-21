import common.NewspaperUtilities

job = NewspaperUtilities.commonJob()

job.with {
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
