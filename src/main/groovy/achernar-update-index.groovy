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
                'ssh doms@achernar "source .bash_profile ; hopt -s huponexit; ~/7880-cibuild/sboi-summarise/bin/ingest_update.sh  && ~/7880-cibuild/sboi-summarise/bin/index_update.sh < /dev/null &> /dev/null"')

        downstreamParameterized {
            trigger('achernar-invoke-batch-trigger, achernar-ingest-metadata, achernar-ingest-data, achernar-check-structure, achernar-generate-statistics, achernar-check-metadata, achernar-generate-histogram, achernar-generate-jpylyzer, achernar-generate-presentation, achernar-enrich-batch, achernar-generate-manualQA-flags, achernar-approve-roundtrip', 'SUCCESS'){
                currentBuild()
            }
            trigger('achernar-update-edition-records, achernar-update-title-records', 'SUCCESS') {
                currentBuild()
            }

        }
    }
}
