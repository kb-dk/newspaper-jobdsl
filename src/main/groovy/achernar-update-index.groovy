import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Freeform) {}
NewspaperUtilities.addAchernar(job)

job.with {
    name 'achernar-update-index'
    label('Achernar_SBOI')
    triggers {
        cron("H/5 * * * *")
    }

    steps {
        shell('set +e\n' +
                'set +x\n' +
                'ssh doms@achernar "source .bash_profile ; shopt -s huponexit; ~/7880-cibuild/sboi-summarise/bin/ingest_update.sh  && ~/7880-cibuild/sboi-summarise/bin/index_update.sh < /dev/null &> /dev/null"')

    }
    postBuildSteps{
        downstreamParameterized {
            trigger('achernar-invoke-batch-trigger', 'SUCCESS',true){
            }
            trigger('achernar-ingest-metadata', 'SUCCESS',true) {
            }
            trigger('achernar-ingest-data', 'SUCCESS',true) {
            }
            trigger('achernar-check-structure', 'SUCCESS') {
            }
            trigger('achernar-generate-statistics', 'SUCCESS') {
            }
            trigger('achernar-check-metadata', 'SUCCESS') {
            }
            trigger('achernar-generate-histogram', 'SUCCESS') {
            }
            trigger('achernar-generate-jpylyzer', 'SUCCESS') {
            }
            trigger('achernar-generate-presentation', 'SUCCESS') {
            }
            trigger('achernar-enrich-batch', 'SUCCESS') {
            }
            trigger('achernar-generate-manualQA-flags', 'SUCCESS') {
            }
            trigger('achernar-approve-roundtrip', 'SUCCESS') {
            }
            trigger('achernar-update-edition-records', 'SUCCESS') {
            }
            trigger('achernar-update-title-records', 'SUCCESS') {
            }


        }
    }
}
